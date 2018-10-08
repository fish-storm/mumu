package utils;

import java.io.File;
import java.io.FileOutputStream;    
import java.io.InputStream;    
import java.io.OutputStream;    
import java.net.URL;    
import java.net.URLConnection;    
    
    
public class DownloadImage {    
    
    /**   
     * @param args   
     * @throws Exception    
     */    
    public static void main(String[] args) throws Exception {    
        // TODO Auto-generated method stub    
         download("http://m.tuniucdn.com//fb2//t1//G1//M00//5C//45//Cii9EFk6fC-IV0zzAAFkUi840pYAAMBPAFx1AoAAWRq921_w450_h300_c1_t0.jpg", "1_li1325169021.jpg","d:\\image\\");    
    }    
        
    public static void download(String urlString, String filename,String savePath) throws Exception {    
        // ����URL    
        URL url = new URL(urlString);    
        // ������    
        URLConnection con = url.openConnection();    
        //��������ʱΪ5s    
        con.setConnectTimeout(5*1000);    
        // ������    
        InputStream is = con.getInputStream();    
        
        // 1K�����ݻ���    
        byte[] bs = new byte[1024];    
        // ��ȡ�������ݳ���    
        int len;    
        // ������ļ���    
       File sf=new File(savePath);    
       if(!sf.exists()){    
           sf.mkdirs();    
       }    
       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);    
        // ��ʼ��ȡ    
        while ((len = is.read(bs)) != -1) {    
          os.write(bs, 0, len);    
        }    
        // ��ϣ��ر���������    
        os.close();    
        is.close();    
    }     
    
}    