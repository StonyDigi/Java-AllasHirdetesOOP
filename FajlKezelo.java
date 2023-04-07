package oopAllasHirdetes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FajlKezelo {
	// itt a lista kap egy pojo-t, (AllasTarolo), komplex típust adtunk meg
	public List<AllasTarolo> fajlBeolvas(String fajlNev) {
		List<AllasTarolo> allasokLista = new ArrayList<AllasTarolo>();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fajlNev), "UTF-8")); //1.lépés
			
			@SuppressWarnings("unused")
		String fejlec = br.readLine(); //2. lépés
			
		while(br.ready()) {//3.lépés
				String sor = br.readLine();
				String[] sorAdatok = sor.split(";");
				
				//vagy így oldjuk meg a sorAdatok[4] boolean-ra parse-olását
//				Boolean tavmunkaTemp = false;
//				if(Integer.parseInt(sorAdatok[4] == 1)) {
//					tavmunkaTemp = true;
//				}
				
				//vagy így oldjuk meg a sorAdatok[4] boolean-ra parse-olását
//				Boolean tavmunkaTemp = false;
//				if(sorAdatok[4].equals("1")) {
//					tavmunkaTemp = true;
//				}
				
				//vagy így
//				Boolean tavmunkaTemp = sorAdatok[4].equals("1");
				
//				String[] datumAdatok = sorAdatok[5].split("-"); //tovább daraboltuk, ha nem lenne localDate
//				LocalDate datumTemp = LocalDate.of(
//						Integer.parseInt(datumAdatok[0]),
//						Integer.parseInt(datumAdatok[1]),
//						Integer.parseInt(datumAdatok[2])
//						);
//				
				//4.lépés
				AllasTarolo ujAllasTaroloObj = new AllasTarolo(
						Integer.parseInt(sorAdatok[0]),
						sorAdatok[1],
						Integer.parseInt(sorAdatok[2]),
						Byte.parseByte(sorAdatok[3]),
						sorAdatok[4].equals("1"), //ez a legjobb megoldás, mert az equals boolean-al tér vissza
						LocalDate.parse(sorAdatok[5]));
//				System.out.println(ujAllasTaroloObj.toString()); //ezt csak le ellenõrizzük
				
				allasokLista.add(ujAllasTaroloObj); //5.lépés
			}
		br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return allasokLista;
	}
}
