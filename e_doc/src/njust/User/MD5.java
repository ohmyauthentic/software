package njust.User;

public class MD5 {//加密算法
	
	String hex_chr="0123456789abcdef";
	
	private String rhex(int num){
		String str="";
		for(int j=0;j<=3;j++){
			str=str+hex_chr.charAt((num>>(j*8+4))&0x0F)+hex_chr.charAt((num>>(j*8))&0x0F);
		}
		return str;
	}
	
	private int[] str2blks_MD5(String str){
		int nblk=((str.length()+8)>>6)+1;
		int[] blks=new int[nblk*16];
		int i=0;		
		for(i=0;i<nblk*16;i++){
			blks[i]=0;
		}
		for(i=0;i<str.length();i++){
			blks[i>>2]|=str.charAt(i)+((i%4)*8);
		}
		blks[i>>2]|=0x80<<((i%4)*8);
		blks[nblk*16-2]=str.length()*8;
		return blks;
	}
	
	private int add(int x,int y){
		return ((x & 0x7FFFFFFF)+(y& 0x7FFFFFFF))^(x&0x80000000)^(y &0x80000000);
	}
	
	private int rol(int num,int cnt){
		return (num<<cnt)|(num>>>(32-cnt));
	}
	private int cmn(int q,int a,int b,int x,int s,int t){
		return add(rol(add(add(a,q),add(x,t)), s),t);
	}
	
	private int ff(int a,int b,int c,int d,int x,int s,int t){
		return cmn((b&c)|((~b)&d), a, b, x, s, t);
	}
	
	private int gg(int a,int b,int c,int d,int x,int s,int t){
		return cmn((b&d)|(c&(~d)), a, b, x, s, t);
	}
	private int hh(int a,int b,int c,int d,int x,int s,int t){
		return cmn(b^c^d, a, b, x, s, t);
	}
	private int ii(int a,int b,int c,int d,int x,int s,int t){
		return cmn(c^(b|(~d)),a, b, x, s, t);
	}
	
	public String calcMD5(String str){
		int [] x=str2blks_MD5(str);
		int a=0x67452301;
		int b=0xEFCDAB89;
		int c=0x98BADCFE;
		int d=0x10325476;
		for(int i=0;i<x.length;i+=16){
			int olda=a;
			int oldb=b;
			int oldc=c;
			int oldd=d;
			a=ff(a, b, c, d, x[i+0],  7, 0xD76AA478);
			d=ff(d, a, b, c, x[i+1], 12, 0xE8C7B756);
			c=ff(c, d, a, b, x[i+2], 17, 0x242070DB);
			b=ff(b, c, d, a, x[i+3], 22, 0xC1BDCEEE);
			
			a=ff(a, b, c, d, x[i+4],  7, 0xF57C0FAF);
			d=ff(d, a, b, c, x[i+5], 12, 0x4787C62A);
			c=ff(c, d, a, b, x[i+6], 17, 0xA8304613);
			b=ff(b, c, d, a, x[i+7], 22, 0x1736ABCD);
			
			a=ff(a, b, c, d, x[i+8],  7, 0xA4B32DC8);
			d=ff(d, a, b, c, x[i+9], 12, 0xED34B756);
			c=ff(c, d, a, b, x[i+10], 17, 0x2EF207DB);
			b=ff(b, c, d, a, x[i+11], 22, 0xFBDC4819);
			
			a=ff(a, b, c, d, x[i+12],  7, 0xF357DAB8);
			d=ff(d, a, b, c, x[i+13], 12, 0xFDCAD5BD);
			c=ff(c, d, a, b, x[i+14], 17, 0xDC3470DB);
			b=ff(b, c, d, a, x[i+15], 22, 0xC1BDCEEE);
			
			a=gg(a, b, c, d, x[i+1],  9, 0xD7FFCCDA);
			d=gg(d, a, b, c, x[i+6], 5, 0xE8DABC56);
			c=gg(c, d, a, b, x[i+11], 13, 0xDDD7B0CB);
			b=gg(b, c, d, a, x[i+0], 19, 0xC325BAEE);
			
			a=gg(a, b, c, d, x[i+6],  9, 0xDFABA443);
			d=gg(d, a, b, c, x[i+10], 5, 0xE8FCDB36);
			c=gg(c, d, a, b, x[i+15], 13, 0xBF890FDB);
			b=gg(b, c, d, a, x[i+4], 19, 0xB1BDCEFE);
			
			a=gg(a, b, c, d, x[i+9],  9, 0xA76CDABA);
			d=gg(d, a, b, c, x[i+14], 5, 0xE8C43B56);
			c=gg(c, d, a, b, x[i+3], 13, 0xDA3070DB);
			b=gg(b, c, d, a, x[i+8], 19, 0xBFECECDE);
			
			a=gg(a, b, c, d, x[i+13],9, 0xDFFCBAE8);
			d=gg(d, a, b, c, x[i+2], 5, 0xE8FB756);
			c=gg(c, d, a, b, x[i+7], 13, 0x24AC50DB);
			b=gg(b, c, d, a, x[i+12],19, 0xDAE3489E);
			
			a=hh(a, b, c, d, x[i+5],  5, 0xA78FDCDA);
			d=hh(d, a, b, c, x[i+8], 9,  0xBD7B756D);
			c=hh(c, d, a, b, x[i+11], 14, 0x45AD30DB);
			b=hh(b, c, d, a, x[i+14], 20, 0xCDF4EAE);
			a=hh(a, b, c, d, x[i+1],  5, 0xAAACCB45);
			d=hh(d, a, b, c, x[i+4], 9, 0xE85DB566);
			c=hh(c, d, a, b, x[i+7], 14, 0x289BF0DB);
			b=hh(b, c, d, a, x[i+10], 20, 0xBCEBDCFE);
			a=hh(a, b, c, d, x[i+13],  5, 0xDBCF56A8);
			d=hh(d, a, b, c, x[i+0], 9, 0xE234B756);
			c=hh(c, d, a, b, x[i+3], 14, 0xAD207FDB);
			b=hh(b, c, d, a, x[i+6], 20, 0xE1BDCDDD);
			a=hh(a, b, c, d, x[i+9], 5, 0x7381BCDE);
			d=hh(d, a, b, c, x[i+12], 9, 0xE688AEFC);
			c=hh(c, d, a, b, x[i+15], 14, 0xAEBFD0DB);
			b=hh(b, c, d, a, x[i+2], 20, 0xC6738BFE);
			
			a=ii(a, b, c, d, x[i+0], 6, 0xD7ADBC78);
			d=ii(d, a, b, c, x[i+7], 10, 0xEFB7B756);
			c=ii(c, d, a, b, x[i+14], 15, 0x2DC070DB);
			b=ii(b, c, d, a, x[i+5], 21, 0xC1AE3EDE);
			a=ii(a, b, c, d, x[i+12], 6, 0xD7633478);
			d=ii(d, a, b, c, x[i+3], 10, 0xECCD3756);
			c=ii(c, d, a, b, x[i+10], 15, 0xDC4070DB);
			b=ii(b, c, d, a, x[i+1], 21, 0xCACDCEEB);
			a=ii(a, b, c, d, x[i+8],  6, 0xD76ADA78);
			d=ii(d, a, b, c, x[i+15], 10, 0xDCFCDCBD);
			c=ii(c, d, a, b, x[i+6], 15, 0x24CDEDEB);
			b=ii(b, c, d, a, x[i+13], 21, 0xCCDBCACE);
			a=ii(a, b, c, d, x[i+4],  6, 0xD3234478);
			d=ii(d, a, b, c, x[i+11], 10, 0x3234B756);
			c=ii(c, d, a, b, x[i+2], 15, 0x2424352A);
			b=ii(b, c, d, a, x[i+9], 21, 0x32BDCEDC);
			
			a=add(a,olda);
			b=add(b,oldb);
			c=add(c,oldc);
			d=add(d,oldd);
		}
		return rhex(a)+rhex(b)+rhex(c)+rhex(d);
	}
	
	private String charRandom(){
		String str;
		char Stra[]=new char[2];
		int randomNumber=0,i=0;
		for(i=0;i<2;i++){
			while(randomNumber<=97||randomNumber>=122){
				randomNumber=(int)(Math.random()*122)+97;
			}
			Stra[i]=(char)randomNumber;
			randomNumber=0;
		}
		str=new String(Stra);
		return str;
	}
	
	private String toUpperStr(String str){
		String s;
		s=str.substring(2,str.length());
		char a[]=s.toCharArray();
		for(int i=0;i<a.length;i++){
			if(Character.isLowerCase(a[i])){
				a[i]=Character.toUpperCase(a[i]);
			}
		}
		s=new String(a);
		str=str.substring(0,2)+s;
		return str;
	}
	//加密
	public String toMd5Str(String str){
		String strRandom=charRandom();
		str=strRandom+calcMD5(strRandom+str);
		str=toUpperStr(str);
		return str;
	}
	//解密
	public boolean checkPWD(String dbPWD,String inputPWD){
		dbPWD=dbPWD.trim();
		inputPWD=inputPWD.trim();
		String str=dbPWD.substring(0,2);
		str=str+calcMD5(str+inputPWD);
		str=toUpperStr(str);
		//System.out.println("jianc     "+str);
		if(str.equals(dbPWD)){
			return true;
		}
		else{
			return false;
		}
	}
}