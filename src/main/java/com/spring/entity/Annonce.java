package com.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name="annonce")
public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonce")
	private Integer Id ;
	
	@NotEmpty( message="Please choose university")
	@Column(name="nom_ecole")
	private Ecole nom_ecole ;
	
	@NotNull( message="Please enter price")
	@Column(name="prix")
	private float prix; 
	
	@NotEmpty( message="Please enter details")
	@Column(name="description")
	private String description ;
	
	@Column(name="nb_place")
	private int nb_place;
	
	@NotNull( message="Please choose type")
	@Column(name="type")
	private Type type;
	
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="date_ajout")
	private Date date_ajout;
	
	@Column(name="available")
	private Boolean available;
	
	@Column(name="genre")
	private String genre;
	
	 @ManyToOne
	 @JoinColumn(name = "id_annonceur", nullable=false)
	private Annonceur annonceur;
	
	
	
	

	 
	
}
