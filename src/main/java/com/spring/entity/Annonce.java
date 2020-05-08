package com.spring.entity;

import java.util.Date;
import java.util.List;

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
import net.minidev.json.JSONObject;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="annonce")
public class Annonce {
	
	
	

	public Annonce(String nom_ecole, float prix, String description, int nb_place, String type, String image_url,
			Boolean available, String genre, Annonceur annonceur) {
		super();
		this.nomEcole = nom_ecole;
		this.prix = prix;
		this.description = description;
		this.capacite = nb_place;
		this.type = type;
		this.image_url = image_url;
		this.available = available;
		this.genre = genre;
		this.annonceur = annonceur;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonce")
	private Integer Id ;
	
	@Column(name="nom_ecole")
	private String nomEcole ;
	
	@Column(name="prix")
	private float prix; 
	
	@Column(name="description")
	private String description ;
	
	@Column(name="nb_place")
	private int capacite;
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="date_ajout")
	private Date dateAjout = new Date();
	
	@Column(name="available")
	private Boolean available;
	
	@Column(name="genre")
	private String genre;
	
	 @ManyToOne
	 @JoinColumn(name = "id_annonceur",insertable =true)
	private Annonceur annonceur;
	 
	 

	@Override
	/*public String toString() {
		return "Annonce [Id=" + Id + ", nom_ecole=" + nomEcole + ", prix=" + prix + ", description=" + description
				+ ", nb_place=" + nb_place + ", type=" + type + ", image_url=" + image_url + ", date_ajout="
				+ date_ajout + ", available=" + available + ", genre=" + genre + ", annonceur=" + annonceur + "]";
	}*/
	 public String toString(){
	      String info = "";
	      
	        JSONObject jsonInfo = new JSONObject();
	        jsonInfo.put("name",this.nomEcole);
	        
	        JSONObject companyObj = new JSONObject();
	        companyObj.put("id ann", this.annonceur.getId());
	        jsonInfo.put("annonceur", companyObj);
	        
	        info = jsonInfo.toString();
	        return info;
	    }



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		this.Id = id;
	}



	public String getNomEcole() {
		return nomEcole;
	}



	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}



	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getCapacite() {
		return capacite;
	}



	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getImage_url() {
		return image_url;
	}



	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



	public Date getDate_ajout() {
		return dateAjout;
	}



	public void setDate_ajout(Date date_ajout) {
		this.dateAjout = date_ajout;
	}



	public Boolean getAvailable() {
		return available;
	}



	public void setAvailable(Boolean available) {
		this.available = available;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Annonceur getAnnonceur() {
		return annonceur;
	}



	public void setAnnonceur(Annonceur annonceur) {
		this.annonceur = annonceur;
	}
	
	
	
	

	 
	
}
