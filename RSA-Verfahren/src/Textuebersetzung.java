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
	
	BigInteger[] encrypt(){
		//Array mit Zeichen
		char[] letterArray = meinText.toCharArray();
		
		//Array mit BitInteger
		BigInteger[] numberArray = new BigInteger[meinText.length()];
		
		//Array mit verschlüsselten BitInteger
		BigInteger[] numberEncryptArray = new BigInteger[meinText.length()];
		
		//Zeichenarray wird in BitIntegerarray übersetzt
		for (int p=0;p<meinText.length();p++) {
			int q=(int)letterArray[p];
			BigInteger bint = new BigInteger(Integer.toString(q));
			numberArray[p]=bint;
		}
		
		//Verschlüsseln
		for (int i=0;i<meinText.length();i++) {
			numberEncryptArray[i]=numberArray[i].modPow(e, n);
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

}
