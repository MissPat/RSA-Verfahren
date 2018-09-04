//import java.math.BigInteger;

public class Main {
	
	Main(){
		int bitLength =16;
		int eLength = 4;
		String meinText = "Hallo";
		
		Schluesselgeneration sErzeugung = new Schluesselgeneration(bitLength,eLength); //Erstellt ein Objekt für die Schlüsselgeneration
		System.out.println("n = "+sErzeugung.getN());
		System.out.println("e = "+sErzeugung.getE());
		System.out.println("d = "+sErzeugung.getD());
		
		Textuebersetzung translation = new Textuebersetzung(meinText,sErzeugung.getE(),sErzeugung.getD(),sErzeugung.getN());
		for(int i=0;i<5;i++) {
			System.out.println(translation.decrypt()[i]);
		}
		for(int i=0;i<5;i++) {
			System.out.println(translation.encrypt()[i]);
		}			
	}
	
	public static void main(String[] args) {
		
		new Main();	
	}
}
