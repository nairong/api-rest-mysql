package com.cities.restAPI.resource;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cities.restAPI.model.City;
import com.cities.restAPI.repository.CityRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cidades")
public class CityResource {
	
	
	
	@Autowired
	CityRepository cityRepository;
	
	
	@ApiOperation(value="Retorna todas as cidades")
	@GetMapping("/cidades")
	public List<City> findCities(){
		return cityRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma cidade pelo ID")
	@GetMapping("/cidades/byIbgeID/{id}")
	public City findCityByID(@PathVariable(value="id") long id){
		return cityRepository.findById(id);	
	}
		
	@ApiOperation(value="Retorna cidades de um determinado Estado")
	@GetMapping("/cidades/byUF/{uf}")
	public List<City> findCityByUF(@PathVariable(value="uf") String uf){
		return cityRepository.findByUF(uf);
	}
	
	@ApiOperation(value="Retorna as CAPITAIS de um determinado Estado")
	@GetMapping("/cidades/capital")
	public List<City> findCapital(){
		return cityRepository.findCapital();
	}

	@ApiOperation(value="Retorna o total de Registros")
	@GetMapping("/cidades/total")
	public long findTotal(){
		return cityRepository.count();
	}
	
	@ApiOperation(value="Retorna total de cidade por UF")
	@GetMapping("/cidades/totalByUF/{uf}")
	public long findTotalCityByUF(@PathVariable(value="uf") String uf){
		return cityRepository.findTotalByUf(uf);
	}
		
	@ApiOperation(value="Insere uma cidade")
	@PostMapping("/cidades")
	public City saveCity(@RequestBody City city) {
		return cityRepository.save(city);
	}

	@ApiOperation(value="Remove uma cidade")
	@DeleteMapping("/cidades")
	public void deleteCity(@RequestBody  City city) {
		cityRepository.delete(city);
	}
	
	
	@ApiOperation(value="Atualiza uma cidade")
	@PutMapping("/cidades")
	public City updateCity(@RequestBody  City city) {
		return cityRepository.save(city);
	}
		
	
	
}	
	
	
	
	

	
 



