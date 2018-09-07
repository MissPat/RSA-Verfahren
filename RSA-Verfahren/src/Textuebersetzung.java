import java.math.BigInteger;

public class Textuebersetzung {
	
	String meinText;
	BigInteger e;
	BigInteger d;
	BigInteger n;
	
	Textuebersetzung(String meinText, BigInteger e, BigInteger d, BigInteger n){
		this.n=n;
		this.e=e;
		this.d=d;
		this.meinText=meinText;
	}
	
	BigInteger[] textToArray() {
		//Array mit Zeichen
		char[] letterArray = meinText.toCharArray();
				
		//Array mit BitInteger
		BigInteger[] numberArray = new BigInteger[meinText.length()];
		
		//Zeichenarray wird in BitIntegerarray übersetzt
		for (int p=0;p<meinText.length();p++) {
			int q=(int)letterArray[p];
			BigInteger bint = new BigInteger(Integer.toString(q));
			numberArray[p]=bint;
		}	
		return numberArray;
	}
	
	BigInteger[] encrypt(){
		//Array mit verschlüsselten BitInteger
		BigInteger[] numberEncryptArray = new BigInteger[meinText.length()];
		
		//Verschlüsseln
		for (int i=0;i<meinText.length();i++) {
			numberEncryptArray[i]=textToArray()[i].modPow(e, n);
		}
		return numberEncryptArray;
	}
	
	BigInteger[] decrypt() {
		BigInteger[] numberDecryptArray = new BigInteger[meinText.length()];
		
		for (int i=0;i<meinText.length();i++) {
			numberDecryptArray[i]=encrypt()[i].modPow(d, n);
		}	
		return numberDecryptArray;
	}

	String ArrayToText() {
		String meinTextNeu="";

		//Übersetzt des Zahlenarry in einen Text
		for (int i=0;i<meinText.length();i++) {
			String q = decrypt()[i].toString();
			int p=Integer.parseInt(q);
			char t=(char)p;
			meinTextNeu = meinTextNeu + t;
		}
		return meinTextNeu;
	}
}



/* 1. methode so mache das ich einzel chan verschlüssle und entschlüssle ufrüefe ohni das es sache dopplet macht
 * 2. mache, dass char wo nur zweistellig sin es null hindehi bechömid
 * 
 * else: 
 * Konventione kontrolliere
 * gueti sinnvolli komentär mache
 * gitds en gueti eifachi doc?
 * 
 */
