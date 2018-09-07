//import java.math.BigInteger;

public class Main {
	
	Main(){
		int bitLength = 64;
		int eLength = bitLength/2;
		String meinText = "Babedibubed";
		
		Schluesselgeneration sErzeugung = new Schluesselgeneration(bitLength,eLength); //Erstellt ein Objekt für die Schlüsselgeneration
		System.out.println("n = "+sErzeugung.getN());
		System.out.println("e = "+sErzeugung.getE());
		System.out.println("d = "+sErzeugung.getD());
		
		Textuebersetzung translation = new Textuebersetzung(meinText,sErzeugung.getE(),sErzeugung.getD(),sErzeugung.getN());
		for(int i=0;i<meinText.length();i++) {
			System.out.println(translation.encrypt()[i]);
		}
		for(int i=0;i<meinText.length();i++) {
			System.out.println(translation.decrypt()[i]);
		}	
		System.out.println(translation.ArrayToText());
	}
	
	public static void main(String[] args) {
		
		new Main();	
	}
}
