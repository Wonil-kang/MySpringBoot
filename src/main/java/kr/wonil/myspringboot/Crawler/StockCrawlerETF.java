package kr.wonil.myspringboot.Crawler;


import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class StockCrawlerETF {
	
	public static String StockMarket_URL = 
			"https://finance.naver.com/api/sise/etfItemList.nhn?etfType=0&targetColumn=market_sum&sortOrder=desc&_callback=window.__jindo2_callback._8370";


	public static ArrayList<StockDto> getETFInfo(){

		
		ArrayList<StockDto> stocks = null;

		try{

			setSSL();
			Document doc = Jsoup.connect(StockMarket_URL)
					.ignoreContentType(true)
					.get();

//			System.out.println(doc.toString());

			stocks = parseETF(doc.toString());

		}catch (Exception e){

			System.err.println(e.toString());
			e.printStackTrace();
			
			return null;

		}


		return stocks;
		
	}
	
	private static ArrayList<StockDto> parseETF(String rst) {
		
		String json = parseJsonETF(rst);
		
		//if (json != null) System.out.println(json); //show JSON ARRAY
		
		ArrayList<StockDto> stocks = parseETFInfo(json);
		//parseStockInfo(stocks);
		//System.out.println(stocks);

		return stocks;
	}
	
	/*
	 * Extract JSON Lines
	 */
	private static String parseJsonETF(String rst) {
		
		
		StringTokenizer st1 = new StringTokenizer(rst, "\n");
		String json = null;
		
		while(st1.hasMoreTokens()) {
			
			String str = st1.nextToken();
			
			if(str.indexOf("etfItemList")> -1) {
				str = str.substring(str.indexOf("(")+1);
				json = str.substring(0,str.length()-1);
				
				break;
			}
			
		}
		
		
		//System.out.println(table);
		return json;
	}
	
	/*
	 * Extract Individual ETF Info From JSON
	 */
	private static ArrayList<StockDto> parseETFInfo(String json) {
		
		
		ArrayList<StockDto> stocks = new ArrayList<>();

		try {
			
			if(json == null) return null;

			JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
			//JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = (JSONArray)((JSONObject)jsonObject.get("result")).get("etfItemList");

			JSONObject o = null;
			StockDto s = null;
			
			for(int i=0; i < jsonArray.size(); i++) {
				
				o = (JSONObject) jsonArray.get(i);
				s = new StockDto(o);
				
				stocks.add(s);
			}
			
			
			
		} catch (Exception e) {

			System.err.println(e.toString());
			e.printStackTrace();

		}

		return stocks;
	
	}
	
	public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[] { 
				new X509TrustManager() {
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						// TODO Auto-generated method stub
						return null;
					} 
					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub	
					}
				} 
			}; 
		SSLContext sc = SSLContext.getInstance("SSL"); 
		sc.init(null, trustAllCerts, new SecureRandom()); 
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { 
			@Override 
			public boolean verify(String hostname, SSLSession session) {
				return true; 
			} 
		}); 
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); 
	}

}
