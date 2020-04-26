package com.spring.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity  
@Table(name="Token")  
public class Token {  
      
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="token_id")  
    private int tokenID;  
      
    @Column(name="user_id")  
    private int userID;  
       
    @Column(name="authenticationToken")  
    private String authenticationToken;  
      
    @Column(name="secretKey")  
    private String secretKey;  
      
    @Column(name="email_id")  
    private String emailId;  
      
    
    
      
}  