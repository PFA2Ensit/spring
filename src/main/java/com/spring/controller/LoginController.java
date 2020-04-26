package com.spring.controller;

 
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Etudiant;
import com.spring.service.LoginService;
import com.spring.service.TokenService;
import com.spring.token.GenerateToken;  

@RestController  
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class LoginController {
	
	@Autowired  
    private LoginService loginService;  
      
    @Autowired  
    private TokenService tokenService;  
      
    GenerateToken generateToken = new GenerateToken();  
      
    
      
    @PostMapping("/login")  
    public ResponseEntity<Integer> login(@RequestBody Etudiant etudiant)  
    {  
        int status;  
        HttpHeaders httpHeader = null;  
      
        // Authenticate User.  
        status = loginService.studentLogin(etudiant.getEmail(), etudiant.getPassword());  
          
        /* 
         * If User is authenticated then Do Authorization Task. 
         */  
        if (status > 0)   
        {  
            /* 
             * Generate token. 
             */  
            String tokenData[] = generateToken.createJWT(etudiant.getEmail(), "JavaTpoint", "JWT Token",  
                   etudiant.getUsername(), 43200000);  
              
            // get Token.  
            String token = tokenData[0];  
              
            System.out.println("Authorization :: " + token);  
  
            // Create the Header Object  
            httpHeader = new HttpHeaders();  
  
            // Add token to the Header.  
            httpHeader.add("Authorization", token);  
  
            // Check if token is already exist.  
            long isUserEmailExists = tokenService.getTokenDetail(etudiant.getEmail());  
              
            /* 
             * If token exist then update Token else create and insert the token. 
             */  
            if (isUserEmailExists > 0)   
            {  
                tokenService.updateToken(etudiant.getEmail(), token, tokenData[1]);  
            }   
            else   
            {  
                tokenService.saveUserEmail(etudiant.getEmail(), status);  
                tokenService.updateToken(etudiant.getEmail(), token, tokenData[1]);  
            }  
  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }   
          
        // if not authenticated return  status what we get.  
        else   
        {  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }  
          
  
    }  
      
      
    

}
