package com.appgate.prueba.detector.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.prueba.detector.data.CompareData;
import com.appgate.prueba.detector.data.ReadFiles;
import com.appgate.prueba.detector.entity.DomainBancolombiaEntity;
import com.appgate.prueba.detector.entity.DomainData;
import com.appgate.prueba.detector.repository.DomainRepository;

@Service
public class DomainService {
	Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	DomainRepository domainRepository;


    public ArrayList<DomainBancolombiaEntity> obtenerDominios(){
        return (ArrayList<DomainBancolombiaEntity>) domainRepository.findAll();
    }

	public DomainData obtenerJson(String url, String dominio) {
		DomainData domainData = new DomainData();
		ReadFiles readFiles = new ReadFiles();
		CompareData compareData = new CompareData();
		ArrayList<String> dominiosSimilares = new ArrayList<>();
		ArrayList<String> dominiosPuny = new ArrayList<>();
		try {

			dominiosSimilares = compareData.compareData(dominio, readFiles.readFile(url));
			dominiosPuny = compareData.comparePunyCode(dominio, readFiles.readFile(url));
			domainData.setDominio(dominio);
			domainData.setDominios_similares(dominiosSimilares);
			domainData.setDominios_sim_punycode(dominiosPuny);
			guardarDominio(dominiosSimilares, dominiosPuny);
		} catch (Exception e) {
			logger.error("Ocurrio un error al construir el json " + e);
		}

		return domainData;
	}

	public void guardarDominio(ArrayList<String> dominiosSimilares, ArrayList<String> dominiosPuny) {

		dominiosSimilares.forEach(data -> {
			try {
				DomainBancolombiaEntity bancolombiaEntity = new DomainBancolombiaEntity();
				bancolombiaEntity.setFechaCreacion(new Date());
				bancolombiaEntity.setNombre(data);
				domainRepository.save(bancolombiaEntity);
			} catch (Exception e) {

				logger.error("Ocurrio un error al guardar el dominio, puede que este ya este creado " + e.getCause());
			}

		});
		dominiosPuny.forEach(data -> {
			try {
				DomainBancolombiaEntity bancolombiaEntity = new DomainBancolombiaEntity();
				bancolombiaEntity.setFechaCreacion(new Date());
				bancolombiaEntity.setNombre(data);
				domainRepository.save(bancolombiaEntity);
			} catch (Exception e) {

				logger.error("Ocurrio un error al guardar el dominio, puede que este ya este creado " + e.getCause());
			}
		});

	}

	public DomainBancolombiaEntity  obtenerPorNombre(String nombre) {
        return domainRepository.findByNombre(nombre);
    }

	public DomainBancolombiaEntity  guardarDominio(DomainBancolombiaEntity domainBancolombiaEntity) {
		domainBancolombiaEntity.setFechaCreacion(new Date());
        return domainRepository.save(domainBancolombiaEntity);
    }

}
