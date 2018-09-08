import java.math.BigInteger;

//import java.math.BigInteger;

public class Main {
	
	int bitLength = 1000;
	int eLength = 400;
	String myText = "Hallo";
	int testGroesse = 10;
	Schluesselgeneration [] schluesselArray = new Schluesselgeneration[testGroesse];
	BigInteger[][] encryptText = new BigInteger[testGroesse][];
	
	
	public Main(){
		
		for (int i=0;i<=testGroesse-1;i++) {
			schluesselArray[i]= new Schluesselgeneration(bitLength,eLength);
		}
		
		for(int i=0;i<=testGroesse-1;i++) {
			encryptText[i]=encrypt(schluesselArray[i]);
			System.out.println("");
		}	
		
		for(int j=0;j<testGroesse;j++) {
			for (int i=0;i<myText.length();i++) {
				System.out.print(encryptText[j][i] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
	
	public BigInteger[] textToArray() {
		//Array mit Zeichen
		char[] letterArray = myText.toCharArray();
				
		//Array mit BitInteger
		BigInteger[] numberArray = new BigInteger[myText.length()];
		
		//Zeichenarray wird in BitIntegerarray übersetzt
		for (int p=0;p<myText.length();p++) {
			int q=(int)letterArray[p]+100;
			
			BigInteger bint = new BigInteger(Integer.toString(q));
			numberArray[p]=bint;
		}	
		return numberArray;
	}
	
	public BigInteger[] encrypt(Schluesselgeneration schluessel){
		//Array mit verschlüsselten BitInteger
		BigInteger[] numberEncryptArray = new BigInteger[myText.length()];
		 
		//Verschlüsseln
		for (int i=0;i<myText.length();i++) {
			numberEncryptArray[i]=textToArray()[i].modPow(schluessel.getE(), schluessel.getN());
		}
		return numberEncryptArray;
	}
	
	public BigInteger[] decrypt() {
		BigInteger[] numberDecryptArray = new BigInteger[myText.length()];
		
		for (int i=0;i<myText.length();i++) {
			numberDecryptArray[i]=encrypt(schluesselArray[0])[i].modPow(schluesselArray[0].getD(), schluesselArray[0].getN());
		}	
		return numberDecryptArray;
	}

	public String arrayToText() {
		String meinTextNeu="";

		//Übersetzt des Zahlenarry in einen Text
		for (int i=0;i<myText.length();i++) {
			String q = decrypt()[i].toString();
			int p=Integer.parseInt(q)-100;
			char t=(char)p;
			meinTextNeu = meinTextNeu + t;
		}
		return meinTextNeu;
	}
	
	public static void main(String[] args) {
		
		new Main();	
	}
}


/* Franz jagt im komplett verwahrlosten Taxi quer durch Bayern */
