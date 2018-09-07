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
		
		//Zeichenarray wird in BitIntegerarray �bersetzt
		for (int p=0;p<meinText.length();p++) {
			int q=(int)letterArray[p];
			BigInteger bint = new BigInteger(Integer.toString(q));
			numberArray[p]=bint;
		}	
		return numberArray;
	}
	
	BigInteger[] encrypt(){
		//Array mit verschl�sselten BitInteger
		BigInteger[] numberEncryptArray = new BigInteger[meinText.length()];
		
		//Verschl�sseln
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

		//�bersetzt des Zahlenarry in einen Text
		for (int i=0;i<meinText.length();i++) {
			String q = decrypt()[i].toString();
			int p=Integer.parseInt(q);
			char t=(char)p;
			meinTextNeu = meinTextNeu + t;
		}
		return meinTextNeu;
	}
}



/* 1. methode so mache das ich einzel chan verschl�ssle und entschl�ssle ufr�efe ohni das es sache dopplet macht
 * 2. mache, dass char wo nur zweistellig sin es null hindehi bech�mid
 * 
 * else: 
 * Konventione kontrolliere
 * gueti sinnvolli koment�r mache
 * gitds en gueti eifachi doc?
 * 
 */
