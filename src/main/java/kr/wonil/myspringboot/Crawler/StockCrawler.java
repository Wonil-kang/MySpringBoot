package kr.wonil.myspringboot.Crawler;

import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StockCrawler{

    private static final Logger log = LoggerFactory.getLogger(StockCrawler.class);

    public static ArrayList<StockDto> getStockInfo(){

        String StockMarket_URL = "https://finance.naver.com/sise/sise_market_sum.nhn";
        ArrayList<StockDto> stocks = null;

        try {

            setSSL();
            Document doc = Jsoup.connect(StockMarket_URL).get();
//            System.out.println(doc.toString());
            stocks = parseStocks(doc.toString());

        }catch (Exception e){

			System.err.println(e.toString());
			e.printStackTrace();

        }


        return stocks;

    }

    private static ArrayList<StockDto> parseStocks(String rst) {

        String table = parseStockTable(rst);
        ArrayList<String> stocks = parseStockInfoLines(table);

        return parseStockInfo(stocks);
        //System.out.println(stocks);
    }

    /*
     * Extract Stock Table
     */
    private static String parseStockTable(String rst) {


        StringTokenizer st1 = new StringTokenizer(rst, "\n");
        String table ="";

        while(st1.hasMoreTokens()) {

            String str = st1.nextToken();

            if(str.indexOf("<table")> -1 && str.indexOf("type_2")> -1) {

                while(st1.hasMoreTokens()) {

                    String tableLine = st1.nextToken();

                    if(tableLine.indexOf("</table>")> -1) break;

                    table += tableLine + "\n";
                }

            }

        }

        //System.out.println(table);
        return table;
    }

    /*
     * Extract Individual Stock Info HTML Line
     */
    private static ArrayList<String> parseStockInfoLines(String str) {

        StringTokenizer st = new StringTokenizer(str, "\n");
        ArrayList<String> stocks = new ArrayList<String>();

        while(st.hasMoreTokens()) {

            String line = st.nextToken();

            if(line.indexOf("<tr")> -1 && line.indexOf("onmouseover")> -1  && line.indexOf("onmouseout")> -1) {

                String stockLines = "";

                while(st.hasMoreTokens()) {

                    String stockLine = st.nextToken();

                    if(stockLine.indexOf("</tr>")> -1) break;

                    stockLines += stockLine + "\n";
                }

                stocks.add(stockLines);
            }
        }

        return stocks;

    }

    /*
     * Extract Individual Stock Info
     */
    private static ArrayList<StockDto> parseStockInfo(ArrayList<String> stocks) {

        ArrayList<StockDto> stockArr = new ArrayList<StockDto>();
        StockDto s;
        JSONParser parser = new JSONParser();

        for(int i=0; i < stocks.size(); i++) {

            try {
                s = new StockDto((JSONObject) parser.parse(stocks.get(i)));
                stockArr.add(s);
            }catch (Exception e){
                e.printStackTrace();
                log.error(e.toString());
            }
        }


        return stockArr;
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
