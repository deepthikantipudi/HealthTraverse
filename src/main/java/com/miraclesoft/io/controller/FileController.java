package com.miraclesoft.io.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.miraclesoft.io.model.HealthRecord;
import com.miraclesoft.io.model.PatientProfile;
import com.miraclesoft.payload.UploadFileResponse;
import com.miraclesoft.io.repository.HealthRepository;
import com.miraclesoft.io.services.FileStorageService;
import com.miraclesoft.io.services.HealthService;
import com.miraclesoft.io.services.PatientService;
import com.miraclesoft.io.services.UserService;

@RestController
public class FileController {

	private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private HealthService healthService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		LOG.info("Inside upload file method");
		String fileName= fileStorageService.storeFile(file);
		LOG.info("uploaded file name: "+fileName);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString().toString();
		LOG.info(" file download URI: "+fileDownloadUri);
		//UserDetails ud =new UserDetails();
		//PatientProfile patProf = new PatientProfile();
		HealthRecord saveHealthRecord = healthService.saveHealthRecord(new HealthRecord(userService.getUserById(1),patientService.getPatientById(2) ,fileName, fileDownloadUri, file.getContentType(), file.getSize() ));
		System.out.println(saveHealthRecord.toString());
		LOG.info("File link saved to database");
		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		LOG.info("Inside multiple file upload method");
		return Arrays.asList(files)
	            .stream()
	            .map(file -> uploadFile(file))
	            .collect(Collectors.toList());
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		LOG.info("Inside file Download method");
		// Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOG.error("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
        	LOG.info("content-type cannot determined, entered fallback method for default content type");
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
}
