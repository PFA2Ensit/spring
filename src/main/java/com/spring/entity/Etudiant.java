package com.spring.entity;

import javax.persistence.GeneratedValue;


import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Table(name="etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_e")
	private Integer id_e ;
	@NotEmpty( message="Please enter the username")
	@Column(name="username")
	private String username ;
	@NotNull( message="Please enter the password")
	@Column(name="password")
	private String password; 	
	@NotEmpty( message="Please enter your email")
	
	@Column(name="email")
	private String email ;
	@NotNull( message="Please enter the phone number")
	@Column(name="phone")
	private String phone;
	
	

}
