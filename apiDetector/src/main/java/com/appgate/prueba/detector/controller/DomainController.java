package com.appgate.prueba.detector.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.prueba.detector.entity.DomainBancolombiaEntity;
import com.appgate.prueba.detector.entity.DomainData;
import com.appgate.prueba.detector.service.DomainService;

@RestController
@RequestMapping("/apiDetecter")
@CrossOrigin(origins = "http://localhost:4200")
public class DomainController {
	@Autowired
	DomainService domainService;

	@GetMapping()
    public ArrayList<DomainBancolombiaEntity> obtenerDominios(){
        return this.domainService.obtenerDominios();
    }

	@PostMapping(path = "/validacion")
	public DomainData obtenerJson(@RequestParam("url") String url, @RequestParam("dominio") String dominio) {
		return this.domainService.obtenerJson(url, dominio);
	}

	@GetMapping("/consulta")
	public DomainBancolombiaEntity obtenerDominioNombre(@RequestParam("nombre") String nombre) {
		return this.domainService.obtenerPorNombre(nombre);
	}

	 @PostMapping()
	    public DomainBancolombiaEntity guardarDominio(@RequestBody DomainBancolombiaEntity domainBancolombiaEntity){
	        return this.domainService.guardarDominio(domainBancolombiaEntity);
	    }
}
