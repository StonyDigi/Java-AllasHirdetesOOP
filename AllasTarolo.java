package oopAllasHirdetes;

import java.time.LocalDate;

public class AllasTarolo {

	private Integer id;
	private String megnevezes;
	private Integer bruttoFizetes;
	private Byte elvartTapasztalatiEvek;
	private boolean tavmunka;
	private LocalDate publikacioIdeje;

	public AllasTarolo(Integer id, String megnevezes, Integer bruttoFizetes, Byte elvartTapasztalatiEvek,
			boolean tavmunka, LocalDate publikacioIdeje) {

		this.id = id;
		this.megnevezes = megnevezes;
		this.bruttoFizetes = bruttoFizetes;
		this.elvartTapasztalatiEvek = elvartTapasztalatiEvek;
		this.tavmunka = tavmunka;
		this.publikacioIdeje = publikacioIdeje;
	}

	public Integer getId() {
		return id;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public Integer getBruttoFizetes() {
		return bruttoFizetes;
	}

	public Byte getElvartTapasztalatiEvek() {
		return elvartTapasztalatiEvek;
	}

	public boolean getTavmunka() {
		return tavmunka;
	}

	public LocalDate getPublikacioIdeje() {
		return publikacioIdeje;
	}

	public String toString() {
		return this.id + "\t" + this.megnevezes + "\t" + this.bruttoFizetes + "\t" + "" + this.elvartTapasztalatiEvek
				+ "\t" + this.tavmunka + "\t" + this.publikacioIdeje;
	}
	public String getTavmunkaSzovegesen() {
		return this.tavmunka ? "Távmunka" : "Nincs távmunka";
	}
}
