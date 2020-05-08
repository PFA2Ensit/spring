package com.spring.repository;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.spring.entity.Annonce;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
	List<Annonce>findAllByAnnonceur(Integer id);
	
	@RestResource(path="searchBox")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteAndAvailableTrue(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	@RestResource(path="name")
	Page<Annonce> findByNomEcoleAndAvailableTrue(@Param("nom") String name, Pageable pagebale);
	@RestResource(path="tri")
	Page<Annonce> findFirst6ByAndAvailableTrueOrderByDateAjoutDesc(Pageable pagebale);
	
	@RestResource(path="prixD")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteAndAvailableTrueOrderByPrixDesc(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	
	@RestResource(path="prixA")
	Page<Annonce> findByNomEcoleAndTypeAndCapaciteAndAvailableTrueOrderByPrixAsc(@Param("nom") String nom,@Param("type")String type,@Param("nombre") int nombre,Pageable pagebale);
	
	@RestResource(path="count")
	@Query("select count(e) from Annonce e ")
	long count();
	
	
	
	


}
