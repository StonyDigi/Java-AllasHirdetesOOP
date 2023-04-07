package oopAllasHirdetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feladatok {

	List<AllasTarolo> allasokLista = new FajlKezelo().fajlBeolvas("allasok.csv");

	public void adatokKiir() {
		for (AllasTarolo item : allasokLista) {
			System.out.print(item.getId());
			System.out.print("\t");
			System.out.print(item.getMegnevezes());
			System.out.print("\t");
			System.out.print(item.getBruttoFizetes());
			System.out.print("\t");
			System.out.print(item.getTavmunkaSzovegesen());
			System.out.print("\t");
			System.out.print(item.getPublikacioIdeje());
			System.out.println();
		}
	}

	public void allasokSzamaKiir() {
		System.out.println(allasokLista.size());

	}

	public void maxFizetesKiir() {
		Integer maxFizetes = allasokLista.get(0).getBruttoFizetes();
		for (AllasTarolo item : allasokLista) {
			if (item.getBruttoFizetes() > maxFizetes) {
				maxFizetes = item.getBruttoFizetes();
			}
		}
		for (AllasTarolo item : allasokLista) { // boolean tipusu az equals
			if (item.getBruttoFizetes().equals(maxFizetes)) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getBruttoFizetes());
				System.out.print("\t");
				System.out.println();
			}
		}
	}

	public int rendszergazdaDbSzamol() {
		int db = 0;
		for (AllasTarolo item : allasokLista) {
			if (item.getMegnevezes().equalsIgnoreCase("rendszergazda")) {
				db++;
			}
		}
		return db; // nem kiirjuk, hanem visszatérünk értékkel
	}

	public void tavmunkaAllasokKiir() {
		for (AllasTarolo item : allasokLista) {
			if (item.getTavmunka() == true) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getTavmunkaSzovegesen());
				System.out.print("\t");
				System.out.println();

			}
		}
	}

	public double tavmunkaAtlagSzamol() {
		Integer db = 0;
		Double osszeg = 0.0;
		for (AllasTarolo item : allasokLista) {
			if (item.getTavmunka()) {
				db++;
				osszeg += item.getBruttoFizetes();
			}

		}
		return Math.round(osszeg / db); // math.Round-al kerekítettem
	}

	public void allasokTapasztalatNelkulKiir() {
		for (AllasTarolo item : allasokLista) {
			if (item.getElvartTapasztalatiEvek() == 0) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getElvartTapasztalatiEvek());
				System.out.println();
			}
		}
	}

	public void allasokNegyEvnelTobbKiir() {
		for (AllasTarolo item : allasokLista) {
			if (item.getElvartTapasztalatiEvek() > 4) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getElvartTapasztalatiEvek());
				System.out.println();

			}

		}
	}

	public void haromhetnelRegebbiAllasokKiir() {
		LocalDate ma = LocalDate.now();
		LocalDate haromHettelEzelottiDatum = ma.minusDays(21);
//		System.out.println(haromHettelEzelottiDatum);
		for (AllasTarolo item : allasokLista) {
			if (item.getPublikacioIdeje().isBefore(haromHettelEzelottiDatum)) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getPublikacioIdeje());
				System.out.println();

			}

		}

	}

	public void legfrissebbAllasIdKiir() {
		LocalDate legfrissebbDatum = allasokLista.get(0).getPublikacioIdeje();
		for (AllasTarolo item : allasokLista) {
			if(item.getPublikacioIdeje().compareTo(legfrissebbDatum)>0) {
				legfrissebbDatum = item.getPublikacioIdeje();
				
			}
			
		}
//		System.out.println(legfrissebbDatum); // 2022-02-11
		for (AllasTarolo item : allasokLista) {
			if(item.getPublikacioIdeje().compareTo(legfrissebbDatum)==0) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getMegnevezes());
				System.out.print("\t");
				System.out.print(item.getPublikacioIdeje());
				System.out.println();	
			}	
		}
	}
	public Map<String, Double> maxAtlagFizetesPozicioSzerintMeghataroz() {
		//1.lépés: létrehozunk egy olyan adatszerkezetet, amelyikben minden pozi csak 1x szerepel
		Set <String> poziciok = new HashSet<String>();
		for (AllasTarolo item : allasokLista) {
			poziciok.add(item.getMegnevezes());	
		}
//		System.out.println(poziciok);
		//2.lépés: Kulcs-Érték párok létrehozása és feltöltése: kucs a megnevezés
		//érték az átlag
		Map<String, Double> atlagPoziciok = new HashMap<String, Double>();
		for (String pozicio : poziciok) {
			Double osszegTemp = 0.0;
			Double dbTemp = 0.0;
			for (AllasTarolo item : allasokLista) {
				if(pozicio.equalsIgnoreCase(item.getMegnevezes())) {
					dbTemp++;
					osszegTemp +=item.getBruttoFizetes();
				}	
			}
			atlagPoziciok.put(pozicio, osszegTemp/dbTemp);	
		}
//		System.out.println(atlagPoziciok);
		//3. lépés: Max kiválasztás tétele HashMap-en
		Double maxAtlag = 0.0;
		String maxAtlagPozicio = null;
		for (Map.Entry<String, Double> item : atlagPoziciok.entrySet()) {
			if(item.getValue()>maxAtlag) {
				maxAtlag = item.getValue();
				maxAtlagPozicio = item.getKey();
			}	
		}
//		String valasz = maxAtlagPozicio + ", "+maxAtlag;
		Map<String, Double> maxAtlagFizetesKulcsErtek = new HashMap<String, Double>();
		maxAtlagFizetesKulcsErtek.put(maxAtlagPozicio, maxAtlag);
		return maxAtlagFizetesKulcsErtek;	
		}
		
	}

