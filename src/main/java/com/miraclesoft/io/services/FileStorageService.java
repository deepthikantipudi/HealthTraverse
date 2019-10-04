package com.miraclesoft.io.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.miraclesoft.io.ExceptionHandler.FileStorageException;
import com.miraclesoft.io.ExceptionHandler.MyFileNotFoundException;
import com.miraclesoft.io.property.FileStorageProperties;

@Service
public class FileStorageService {
	
	private static final Logger LOG = LoggerFactory.getLogger(FileStorageService.class);

	 private final Path fileStorageLocation;

	    @Autowired
	    public FileStorageService(FileStorageProperties fileStorageProperties) {
	    	LOG.info("Inside FileStorageService Constructor");
	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();

	        try {
	        	LOG.info("About to create file storage location as mentioned in properties file");
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	        	LOG.error("Cannot create folder to store the files");
	            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }

	    public String storeFile(MultipartFile file) {
	    	LOG.info("Inside storeFile method of FileStorageService");
	    	LOG.info("retrieving original file name");
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	        	LOG.info("Checking if the file name contains '..' ");
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	            	LOG.error("File name contains '..'! So, it is invalid ");
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            // Copy file to the target location (Replacing existing file with the same name)
	            Path targetLocation = this.fileStorageLocation.resolve(fileName);
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	            LOG.info("File is successfully stored and returing the file name ");
	            return fileName;
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	    public Resource loadFileAsResource(String fileName) {
	        try {
	        	 LOG.info("inside loadFile as resource method ");
	        	 LOG.info("Retrieving the path of the file ");
	            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
	            LOG.info("converting path to URI ");
	            Resource resource = new UrlResource(filePath.toUri());
	            LOG.info("cHeck if resource exists or not ");
	            if(resource.exists()) {
	                return resource;
	            } else {
	            	 LOG.info("Resource is not found ");
	                throw new MyFileNotFoundException("File not found " + fileName);
	            }
	        } catch (MalformedURLException ex) {
	            throw new MyFileNotFoundException("File not found " + fileName, ex);
	        }
	    }
	}
