package com.cities.restAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cities.restAPI.model.City;


import java.util.List;



public interface CityRepository extends JpaRepository<City, Long>{
	

	
	//Retorna as cidades pelo ID
	City findById(long id);
	
	
	//Retorna as cidades pelo UF
	@Query("FROM City WHERE uf = ?1")
	List<City> findByUF( String name);
	
	
	//Retorna a quantidade de cidades pelo UF
	@Query("SELECT count(*) FROM City WHERE uf = ?1")
	long findTotalByUf(String uf);
		
	
	//Retornar somente as cidades que são capitais ordenadas por nome
	@Query("FROM City WHERE capital LIKE 'true' ORDER BY name")
	List<City> findCapital();


}

