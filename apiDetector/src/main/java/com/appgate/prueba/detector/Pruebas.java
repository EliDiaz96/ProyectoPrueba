package com.appgate.prueba.detector;

import com.appgate.prueba.detector.data.CompareData;
import com.appgate.prueba.detector.data.ReadFiles;

public class Pruebas {
	public static String dominioPrincipal1 = "bancolombia.com";
	public static String dominioPrincipal2 = "bancolombia.com.co";

	

	public static void main(String[] args) {

		ReadFiles readFiles = new ReadFiles();
		String fileName = "D:/Downloads/SSE_TEST-main/data/dominios.txt";

		CompareData compareData =new CompareData();

		compareData.compareData(dominioPrincipal1, readFiles.readFile(fileName));
		compareData.comparePunyCode(dominioPrincipal1, readFiles.readFile(fileName));


		//System.out.println(IDN.toUnicode("xn--ancol0mbia-rzi.com.co", IDN.ALLOW_UNASSIGNED));
		/*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}*/
	}
	
}
