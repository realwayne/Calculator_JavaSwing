package com.calculator;

public class Conversions {

	public static void main(String[] args) {
		

	}
	
	static String binary_to_decimal(String binary) {
		int decNum = 0, i=0, n, len=binary.length();
		while (i<len) {
			n=binary.charAt(i)-48; 
			if (n!=0&&n!=1) {
				return "ERROR";
			}
			decNum=(decNum*2)+n;
			i++;
		}
		return Integer.toString(decNum);
		
	}
	static String binary_to_hexadecima(String binarys) {
		
		int hexdec[]=new int[1000];
		int dec=0, i=1, j = 0, rem;
		int binary;
		
		try {
			binary=Integer.parseInt(binarys);
		}catch(NumberFormatException e) {
			return "ERROR";
		}
		while (binary>0) {	//binary to decimal
			rem=binary%2;
			dec=dec+(rem*i);
			binary=binary/10;
			i*=2;
		}
		
		i=0;
		while (dec!=0) {
			hexdec[i]=dec%16;
			dec=dec/16;
			i++;
		}
		String hexa="";
		for (j=i-1; j>=0; j--) {
			if (hexdec[j]>9)
				hexa=hexa+(hexdec[j]+55);
			else
				hexa=hexa+hexdec[j];
		}
		return hexa;
	}
	static String binary_to_octal(String binary) {
		int bin, rem, dec=0, octal=0, i=0;
		try {
			bin=Integer.parseInt(binary);
		}catch(NumberFormatException e) {
			return "ERROR";
		}
		while (bin!=0) {//binary to decimal
			rem=bin%10;
			dec=dec+(rem*i);
			bin=bin/10;
			i*=2;
		}
		i=1;
		while (dec!=0) {
			rem=dec%8;
			octal=octal+(rem*i);
			dec=dec/8;
			i*=10;	
		}
		return Integer.toString(octal);
	}
	///////////////////////////////////////////////////////////////////////
	static String decimal_to_binary(int decNum) {
		if (decNum==0) {
			return "0";
		}
		int i=0;
		String binres="";
		while (decNum>0) {
			binres=Integer.toString(decNum%2);
			decNum=decNum/2;
			i++;
		}
		return binres;
	}
	static String decimal_to_octal(int decNum) {
		int rem, octal=0, i=1;
		while (decNum!=0) {
			rem = decNum%8;
			octal=octal+(rem*i);
			decNum=decNum/8;
			i=i*10;
		}
		return Integer.toString(octal);
	}
	static String decimal_to_hexadecimal(int dec) {
		int quotient=dec, temp, i=1;
		String hexNum="";
		while (quotient!=0) {
			temp=quotient%16;
			if (temp<10) {
				temp=temp+48;
			}else {
				temp=temp+55;
			}
			hexNum=hexNum+Integer.toString(temp);
			quotient=quotient/16;
			i++;
		}
		return hexNum;
	}
///////////////////////////////////////////////////////////////////////
	public static String octal_to_binary(String octalNum) {
		String binaryNum="";
		for (int i=0; i<octalNum.length(); i++) {
			switch(octalNum.charAt(i)) {
			case '0':binaryNum+="000";
				break;
			case '1':binaryNum+="001";
				break;
			case '2':binaryNum+="010";
				break;
			case '3':binaryNum+="011";
				break;
			case '4':binaryNum+="100";
				break;
			case '5':binaryNum+="101";
				break;
			case '6':binaryNum+="010";
				break;
			case '7':binaryNum+="111";
				break;
			
			default: return "ERROR";
			}
		}
		return binaryNum;
	}
	static String octal_to_decimal(int octal) {
		int rem, decNum=0, i=1;
		
		while (octal!=0) {
			rem=octal%10;
			decNum+=rem*i;
			octal/=10;
			i=i*8;
		}
		return Integer.toString(decNum);
	}
	static String octal_to_hexadecimal(int octal) {
		int rem=0, i=0, decNum=0;
		String hexNum="";
		while (octal!=0) {
			rem=octal%10;
			octal=octal/10;
			decNum=decNum+rem*(int)Math.pow(8, i);
			i++;
		}
		while (decNum!=0) {
			rem=decNum%16;
			switch(rem) {
			case 10:hexNum=hexNum+'A';
			break;
			case 11:hexNum=hexNum+'B';
			break;
			case 12:hexNum=hexNum+'C';
			break;
			case 13:hexNum=hexNum+'D';
			break;
			case 14:hexNum=hexNum+'E';
			break;
			case 15:hexNum=hexNum+'F';
			break;
			
			default: 
				hexNum=hexNum+(char)(rem+'0');
				break;
			}
			++i;
			decNum/=16;
		}
		return hexNum;
	}

}
