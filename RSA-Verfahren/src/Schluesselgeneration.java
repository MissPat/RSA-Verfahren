import java.math.BigInteger;
import java.util.Random;

//Diese Klasse dient dazu, die Schlüsselzahlen zu erzeugen

public class Schluesselgeneration {

	int bitLength;
	int eLength;
	BigInteger e,d,n;
	
	//Konstruktor
	Schluesselgeneration(int bitLength, int eLength){
		this.bitLength=bitLength;
		this.eLength=eLength;
		
		//Erzeugt die Schlüssel
		BigInteger q = BigInteger.probablePrime(bitLength, new Random());
		BigInteger p = BigInteger.probablePrime(bitLength, new Random());
		n = p.multiply(q);
		BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(eLength, new Random());
		//Überprüfung: ist e und phiN teilerfremd
		while(phiN.mod(e)==BigInteger.ZERO) {
			e = BigInteger.probablePrime(eLength/4, new Random());
		}	
		d = e.modInverse(phiN);
	}
	//Methode für n
	BigInteger getN() {
		return n;
	}
		
	//Methode für e
	BigInteger getE() {
		return e;
	}
		
	//Methode für d
	BigInteger getD() {
		return d;
	}
}
