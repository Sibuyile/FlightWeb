/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.test.restapi;

import com.sibu.flightsystemweb.domain.Enquiry;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author stud
 */
public class EnquiryRestTest {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8080/flightsystemweb/";
    
    public EnquiryRestTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
      public void testCreate() {
        Enquiry enq = new Enquiry.Builder("101Enq").build();
        HttpEntity<Enquiry> requestEntity = new HttpEntity<>(enq, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/enquiry/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
      
      @Test
    public void testEnquiryUpdate() {
        // LEFT AS AN EXERCISE FOR YOU
        // GET THE CLUB and THEN CHANGE AND MAKE A COPY
        //THEN SEND TO THE SERVER USING A PUT OR POST
        // THEN READ BACK TO SEE IF YOUR CHANGE HAS HAPPENED
        Enquiry enq = new Enquiry.Builder("101Enq").build();
        HttpEntity<Enquiry> requestEntity = new HttpEntity<>(enq, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/enquiry/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
    
     public void testreadClubByNameName() {
        String flightName = "SAA";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Enquiry> responseEntity = restTemplate.exchange(URL + "api/Enquiry/name/" + flightName, HttpMethod.GET, requestEntity, Enquiry.class);
        Enquiry enq = responseEntity.getBody();

        Assert.assertNotNull(enq);

    }
      
     private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }

    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
     
     

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
