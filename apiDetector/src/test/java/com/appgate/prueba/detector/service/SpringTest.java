package com.appgate.prueba.detector.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appgate.prueba.detector.entity.DomainBancolombiaEntity;


class SpringTest {
	
	private DomainService domainService = new DomainService();
	

	@Test
	void testGuardarDominio() {
		String dominio = "bancolombia123.com";
		DomainBancolombiaEntity bancolombiaEntity = domainService.obtenerPorNombre(dominio);
		Assertions.assertThat(bancolombiaEntity.getId()).isGreaterThan(0);
	}

}
