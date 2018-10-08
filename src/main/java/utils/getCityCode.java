package utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.CitylistDao;
import services.FileService;

/*
 * 
 * 
 * ��ȡ�ļ��������������Ϣ�⣨���д��룩
 * 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ�
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class getCityCode {
	@Autowired
	private FileService fileService;
	@Autowired
	private CitylistDao citylistDao;
	
	
	//@Test
	public void readCid(){
		String text=fileService.readToString("C:\\Users\\һֻ\\Desktop\\Я��.txt");
		System.out.println(text);
		StringBuilder strB = new StringBuilder(text);
		int temp=0;
		int temp1=0;
		int temp2=0;
		int temp3=0;
		int end=strB.lastIndexOf("data");			//���һ��
		while(strB.indexOf("data")>0){
			temp=strB.indexOf("data");
			strB.delete(0,temp+1);
			temp1=strB.indexOf("|",0);
			System.out.println(strB.substring(5, temp1));			//beijing
			temp2=strB.indexOf("|",temp1+1);
			System.out.println(strB.substring(temp1+1,temp2));		//����
			temp3=strB.indexOf("\"",temp2);
			System.out.println(strB.substring(temp2+1,temp3));   	//1
			//citylistDao.addLessOne(strB.substring(temp1+1,temp2), strB.substring(5, temp1));
			citylistDao.upDateCidBycityName(strB.substring(temp1+1,temp2),new Integer(strB.substring(temp2+1,temp3)));}
	}
	//@Test
	public void readYid(){
		String text=fileService.readToString("C:\\Users\\һֻ\\Desktop\\����.txt");
		System.out.println(text);
		StringBuilder strB = new StringBuilder(text);
		int temp=0;
		int temp1=0;
		int temp2=0;
		int temp3=0;
		int end=strB.lastIndexOf("CityCode");			//���һ��
		while(strB.indexOf("CityCode")>0){
			temp=strB.indexOf("CityCode");
			strB.delete(0,temp+1);
			temp1=strB.indexOf("\",");
			//System.out.println(strB.substring(10,temp1));			//0001
			temp2=strB.indexOf("CityNameEn");	
			temp3=strB.indexOf("CityThreeSign");
			//System.out.println(strB.substring(temp2+13,temp3-3));			//Beijing
			int i=citylistDao.ifExist(strB.substring(temp2+13,temp3-3));
			if(i==0) {
				//System.out.println(strB.substring(temp2+13,temp3-3)+" "+strB.substring(10,temp1)+"  "+i);
			}
			else {
				citylistDao.upDateYidBycityNameEn(strB.substring(temp2+13,temp3-3),strB.substring(10,temp1));
				//System.out.println(0+strB.substring(temp2+13,temp3-3));
				//System.out.println("����"+strB.substring(temp2+13,temp3-3));
			}
			//System.out.println(strB.substring(temp2+1,temp3));   	//1
			//citylistDao.addLessOne(strB.substring(temp1+1,temp2), strB.substring(5, temp1));
			//citylistDao.upDateCidBycityName(strB.substring(temp1+1,temp2),new Integer(strB.substring(temp2+1,temp3)));}
		}
	}
	@Test
	public void readTid(){
		String text=fileService.readToString("C:\\Users\\һֻ\\Desktop\\;ţ.txt");
		System.out.println(text);
		StringBuilder strB = new StringBuilder(text);
		int temp=0;
		int temp1=0;
		int temp2=0;
		int temp3=0;
		
		while(strB.indexOf("title")>0){
			temp=strB.indexOf("title=");
			strB.delete(0,temp+7);
			temp1=strB.indexOf("\"");
			System.out.println(strB.substring(0, temp1));			//����
			temp2=strB.indexOf("code=");
			temp3=strB.indexOf("\"",temp2+6);
			System.out.println(strB.substring(temp2+6,temp3));		//����
			
		//	citylistDao.addLessOne(strB.substring(temp1+1,temp2), strB.substring(5, temp1));
			citylistDao.upDateTidBycityName(strB.substring(0, temp1),new Integer(strB.substring(temp2+6,temp3)));
			}
	}
	}

