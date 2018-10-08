package services;

import java.util.List;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface SearchService {
		String getUrlInCtrip(String keyword,String city);		//http://hotels.ctrip.com/hotel/xi'an10/k1��ŷ�ڵ�
		String getUrl(String hotelName,String city,int site,int page);			//�������url(�ڲ�ͬ����վ)
					//1 Я��  2 ����  3;ţ 4���� 
		void setHotelDetail(String urlInCtrip);					
		
		String getHtml(String url,int delay,boolean ifJsEnabled);			//��ȡҳ������(�ڲ�ͬ����վ)
		
		String getSearchIndexJson(String city,int page,String keyWord);				//����Ĭ����ҳ����//���һ�������nameΪpage
		
		String getDetailOnCtrip(String cid); 								//TODO
		String getDetailOnElong(String city,String hotelName);
				
		
		String getRoomOnCtrip(String cid);
		String getRoomOnElong(String hotelName,String city,List<String> roomList);
		String getRoomOnTuniu(String hotelName,String city,List<String> roomList);
		
		
		String getHotelImgSrcJson(String hotelId);
		//��ȡ���ͣ���ȡ���µ�
		//http://hotel.elong.com/search/list_cn_1005.html?keywords=��¥�Ƶ�
		//http://hotel.tuniu.com/list?city=2703&keyword=��¥�Ƶ�
}
