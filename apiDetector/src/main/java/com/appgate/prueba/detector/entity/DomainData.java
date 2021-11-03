package com.appgate.prueba.detector.entity;

import java.util.ArrayList;

public class DomainData {
	private String dominio;
	private ArrayList<String> dominios_similares;
	private ArrayList<String> dominios_sim_punycode;

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public ArrayList<String> getDominios_similares() {
		return dominios_similares;
	}

	public void setDominios_similares(ArrayList<String> dominios_similares) {
		this.dominios_similares = dominios_similares;
	}

	public ArrayList<String> getDominios_sim_punycode() {
		return dominios_sim_punycode;
	}

	public void setDominios_sim_punycode(ArrayList<String> dominios_sim_punycode) {
		this.dominios_sim_punycode = dominios_sim_punycode;
	}

}
