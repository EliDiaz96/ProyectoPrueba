package com.appgate.prueba.detector.data;

import java.net.IDN;
import java.util.ArrayList;

import com.appgate.prueba.detector.utils.SimilarityUtil;

public class CompareData {

	public ArrayList<String> compareData(String dominio, ArrayList<String> dominios) {
		double porcetajeSimilitud = 0.48;
		SimilarityUtil similarityUtil = new SimilarityUtil();

		ArrayList<String> dominiosSimilares = new ArrayList<>();
		dominios.forEach(data -> {
			double similitud = similarityUtil.sim(data, dominio);
			if (similitud >= porcetajeSimilitud) {
				dominiosSimilares.add(data);
			}

		});
		return dominiosSimilares;
	}

	public ArrayList<String> comparePunyCode(String dominio, ArrayList<String> dominios) {
		double porcetajeSimilitud = 0.6;
		SimilarityUtil similarityUtil = new SimilarityUtil();

		ArrayList<String> dominiosPuny = new ArrayList<>();
		dominios.forEach(data -> {
			String punycode = IDN.toUnicode(data, IDN.ALLOW_UNASSIGNED);
			double similitud = similarityUtil.sim(punycode, dominio);
			if (similitud >= porcetajeSimilitud) {
				dominiosPuny.add(punycode);
			}

		});
		return dominiosPuny;
	}
}
