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
	// itt a lista kap egy pojo-t, (AllasTarolo), komplex t�pust adtunk meg
	public List<AllasTarolo> fajlBeolvas(String fajlNev) {
		List<AllasTarolo> allasokLista = new ArrayList<AllasTarolo>();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fajlNev), "UTF-8")); //1.l�p�s
			
			@SuppressWarnings("unused")
		String fejlec = br.readLine(); //2. l�p�s
			
		while(br.ready()) {//3.l�p�s
				String sor = br.readLine();
				String[] sorAdatok = sor.split(";");
				
				//vagy �gy oldjuk meg a sorAdatok[4] boolean-ra parse-ol�s�t
//				Boolean tavmunkaTemp = false;
//				if(Integer.parseInt(sorAdatok[4] == 1)) {
//					tavmunkaTemp = true;
//				}
				
				//vagy �gy oldjuk meg a sorAdatok[4] boolean-ra parse-ol�s�t
//				Boolean tavmunkaTemp = false;
//				if(sorAdatok[4].equals("1")) {
//					tavmunkaTemp = true;
//				}
				
				//vagy �gy
//				Boolean tavmunkaTemp = sorAdatok[4].equals("1");
				
//				String[] datumAdatok = sorAdatok[5].split("-"); //tov�bb daraboltuk, ha nem lenne localDate
//				LocalDate datumTemp = LocalDate.of(
//						Integer.parseInt(datumAdatok[0]),
//						Integer.parseInt(datumAdatok[1]),
//						Integer.parseInt(datumAdatok[2])
//						);
//				
				//4.l�p�s
				AllasTarolo ujAllasTaroloObj = new AllasTarolo(
						Integer.parseInt(sorAdatok[0]),
						sorAdatok[1],
						Integer.parseInt(sorAdatok[2]),
						Byte.parseByte(sorAdatok[3]),
						sorAdatok[4].equals("1"), //ez a legjobb megold�s, mert az equals boolean-al t�r vissza
						LocalDate.parse(sorAdatok[5]));
//				System.out.println(ujAllasTaroloObj.toString()); //ezt csak le ellen�rizz�k
				
				allasokLista.add(ujAllasTaroloObj); //5.l�p�s
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
