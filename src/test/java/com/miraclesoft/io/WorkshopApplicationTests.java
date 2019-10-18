//package com.miraclesoft.io;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.miraclesoft.io.awt.config.WebSecurityConfig;
//import com.miraclesoft.io.awt.filter.JwtRequestFilter;
//import com.miraclesoft.io.controller.InsuranceController;
//import com.miraclesoft.io.services.JwtUserDetailsService;
//import com.miraclesoft.io.services.PatientClaimDetailsService;
//import com.miraclesoft.io.services.PatientInsurancePlanService;
//
//@RunWith(SpringRunner.class)
////@WebMvcTest(InsuranceController.class)
//@WebAppConfiguration
//@SpringBootTest(classes = InsuranceController.class)
//@AutoConfigureMockMvc
//public class WorkshopApplicationTests {
//
////	@Autowired
////	org.springframework.test.web.servlet.MockMvc mockMvc;
//	
////	@Autowired
////	MockMvc mockMvc; // to use direct rest calls
//
//	@MockBean
//	PatientClaimDetailsService patientClaimDetailsService;
//	
////	@MockBean
////	PatientClaimDetailsRepo patientClaimDetailsRepo;
//	
//	@Autowired
//	org.springframework.test.web.servlet.MockMvc mockMvc;
//
//	@MockBean
//	PatientInsurancePlanService patientInsurancePlanService;
//	
//	
//	
//	@MockBean
//	com.miraclesoft.io.awt.filter.JwtAuthenticationEntryPoint JwtAuthenticationEntryPoint;
//	
//	@MockBean
//	JwtUserDetailsService jwtUserDetailsService;
//
//	@MockBean
//	com.miraclesoft.io.awt.service.JwtService JwtService;
//	
//	@MockBean
//	com.miraclesoft.io.awt.util.JWTUtility JWTUtility;
//	
//	@MockBean
//	JwtRequestFilter jwtRequestFilter;
//	
//	@MockBean
//	WebSecurityConfig webSecurityConfig;
//
//	@Autowired
//    private WebApplicationContext wac;
// 
//    
//    private FilterChainProxy springSecurityFilterChain;
// 
// 
////    @Before
////    public void setup() {
////        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
////          .addFilter(springSecurityFilterChain).build();
////    }
//	
//	
//	
//	@Test
//	public void contextLoads() throws Exception {
//	
//	}
//}
