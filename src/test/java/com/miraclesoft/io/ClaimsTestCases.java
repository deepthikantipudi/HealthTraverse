//package com.miraclesoft.io;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//public class ClaimsTestCases extends WorkshopApplicationTests {
//
//	@Test
//	public void getTest() throws Exception {
//		// when(patientClaimDetailsRepo.findAll()).thenReturn(Collections.emptyList());
//
//		
//		MvcResult mvcResult = null;
//		try {
//			
//			 mvcResult = mockMvc.perform( // using mock mvc builder we can handle the mockMvc
//					MockMvcRequestBuilders.get("/claims").accept(MediaType.APPLICATION_JSON)).andReturn();
//			
//		}catch(Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//
//		MockHttpServletResponse response = mvcResult.getResponse();
//		assertEquals(401, response.getStatus());  // HttpStatus.OK.value()=200, HttpStatus.CREATED.value()=201
//		System.out.println("Response:" + response.getContentAsString());
//
//		// verify(patientClaimDetailsRepo).findAll();
//	}
//	
////	@Test
////	public void postTest() throws Exception {
////		MvcResult mvcResult = mockMvc.perform( // using mock mvc builder we can handle the mockMvc
////				MockMvcRequestBuilders.post("/addclaim").accept(MediaType.APPLICATION_JSON)
//////						.content("{\n" + "	\"claimId\":\"4\",\n" + "	\"pId\":\"123\"\n" + "	\"phyId\":\"12\",\n"+ "	\"totalAmount\":\"200\",\n" + "	\"paidAmount\":\"100\",\n" + "	\"date\":\"2019-10-10\",\n" + "	\"hospital\":\"UHG\"\n" + "}")
////						.content("{\n" + "	\"claimId\":5,\n" + "	\"pId\":123,\n" + "	\"phyId\":12,\n"+ "	\"totalAmount\":200,\n" + "	\"paidAmount\":100,\n" + "	\"date\":\"2019-10-10\",\n" + "	\"hospital\":\"UHG\"\n" + "}")
//////				.content("{\n" + "	\"claimId\":6\n" + "}")
////				.contentType(MediaType.APPLICATION_JSON))
////				.andReturn();
////		MockHttpServletResponse response = mvcResult.getResponse();
////		System.out.println("Response:" + response.getContentAsString());
////		assertEquals(200, response.getStatus()); // HttpStatus.OK.value()=200, HttpStatus.CREATED.value()=201
////		System.out.println("Response:" + response.getContentAsString());
////		// assertEquals("http://localhost:8080/addclaim",response.getHeader(HttpHeaders.LOCATION));
////	}
////	
////	@Test
////	public void getTestPlans() throws Exception {
////		// when(patientClaimDetailsRepo.findAll()).thenReturn(Collections.emptyList());
////
////		MvcResult mvcResult = mockMvc.perform( // using mock mvc builder we can handle the mockMvc
////				MockMvcRequestBuilders.get("/plans").accept(MediaType.APPLICATION_JSON)).andReturn();
////
////		MockHttpServletResponse response = mvcResult.getResponse();
////		assertEquals(200, response.getStatus());  // HttpStatus.OK.value()=200, HttpStatus.CREATED.value()=201
////		System.out.println("Response:" + response.getContentAsString());
////
////		// verify(patientClaimDetailsRepo).findAll();
////	}
////	
//
//
//}