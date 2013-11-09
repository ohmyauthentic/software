package njust.User;

public class character {
	public static String getString(String str){   //中文处理方法,否则存入数据库会出现乱码现象
        if(str==null) str="";
        else {
           try{
              byte[] b=str.getBytes("ISO-8859-1");
              str=new String(b);
            }catch(Exception e){
                 e.printStackTrace();
           }
        }
        return str;
    }
}
