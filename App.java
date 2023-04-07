package oopAllasHirdetes;

public class App {

	public static void main(String[] args) {
		Feladatok feladatObj = new Feladatok();
		System.out.println("B, feladat - �rja ki a z �ll�sok adatait soronk�nt!:  ");
		feladatObj.adatokKiir();
		System.out.println();
		
		System.out.print("C, feladat - Ennyi hirdet�s van a rendszerben: ");
		feladatObj.allasokSzamaKiir();
		System.out.println();
		
		System.out.println("D, feladat - Legt�bb fizet�s: ");
		feladatObj.maxFizetesKiir();
		System.out.println();
		
		System.out.print("E, feladat - Rendszergazda Hirdet�sek sz�ma: ");
		System.out.println(feladatObj.rendszergazdaDbSzamol()); //met�dusban nincs megjelen�tve ez�rt itt appon bel�l
		//�rjuk ki
		System.out.println();
		
		System.out.println("F, feladat - Melyik �ll�s v�gezhet� t�vmunk�ban?: ");
		feladatObj.tavmunkaAllasokKiir();
		System.out.println();
		
		System.out.println("G, feladat - T�vmunk�s mennyit keres �tlagosan?: ");
		System.out.print(feladatObj.tavmunkaAtlagSzamol());
		System.out.println();
		
		System.out.println("H, feladat - �ll�sok, amihez nem sz�ks�ges tapasztalat: ");
		feladatObj.allasokTapasztalatNelkulKiir();
		System.out.println();
		
		System.out.println("I, feladat - �ll�sok amelyekhez 4 �vn�l is t�bb munkatapasztalatra van sz�ks�g!: ");
		feladatObj.allasokNegyEvnelTobbKiir();
		System.out.println();
		
		System.out.println("J, feladat - 3 h�tn�l r�gebbi �ll�sok: ");
		feladatObj.haromhetnelRegebbiAllasokKiir();
		System.out.println();
		
		System.out.println("K, feladat - Legfrissebb �ll�s(ok): ");
		feladatObj.legfrissebbAllasIdKiir();
		System.out.println();
		
		
		
		System.out.println("L, feladat - �tlagosan melyik poz�ci�ban keresnek a legt�bbet?: ");
		System.out.println(feladatObj.maxAtlagFizetesPozicioSzerintMeghataroz());
		System.out.println();
		
	
		
				
		

	}
}
