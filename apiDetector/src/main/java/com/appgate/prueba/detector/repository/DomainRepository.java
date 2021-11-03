package com.appgate.prueba.detector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appgate.prueba.detector.entity.DomainBancolombiaEntity;

@Repository
public interface DomainRepository extends CrudRepository<DomainBancolombiaEntity, Long> {
	public abstract DomainBancolombiaEntity findByNombre(String nombre);

}
