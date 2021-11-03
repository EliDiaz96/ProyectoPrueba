package com.appgate.prueba.detector.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
public class ReadFiles {


	public ArrayList<String> readFile(String url) {
		ArrayList<String> dominios = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(url))) {
			stream.forEach((data)-> dominios.add(data));
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return dominios;
	}
}
