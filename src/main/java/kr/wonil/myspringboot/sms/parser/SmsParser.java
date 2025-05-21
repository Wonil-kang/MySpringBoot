package kr.wonil.myspringboot.sms.parser;

import kr.wonil.myspringboot.myexpense.data.dto.MyTransactionDto;
import kr.wonil.myspringboot.myinvest.data.dto.MyStockHistoryDto;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import kr.wonil.myspringboot.util.DateUtil;
import kr.wonil.myspringboot.util.NumberUtil;

import java.util.StringTokenizer;

public class SmsParser {


    public static MyTransactionDto parseKookminSms(MySms sms) {

        StringTokenizer st = null;
        StringTokenizer stLines = null;
        String smsBody = sms.getSmsBody();
        String line, date, time, amount;
        MyTransactionDto mt = new MyTransactionDto();

        mt.setSmsId(sms.getSmsId());
        mt.setSmsBody(smsBody);

        if(!(smsBody.contains("승인")
                || smsBody.contains("취소")
                || smsBody.contains("결제예정"))) return null;

        stLines = new StringTokenizer(smsBody, "\n");

        try {

            if(stLines.hasMoreTokens()) {

                line = stLines.nextToken();

                //Line 1 : [Web발신] 제거
                if(line.contains("Web발신") && stLines.hasMoreTokens())
                    line = stLines.nextToken();



                if(smsBody.contains("후불교통(신용)") && smsBody.contains("결제예정")) {

                    //line = stLines.nextToken();
                    mt.setCardName(line);

                    line = stLines.nextToken();
                    mt.setTransactionInfo(line);

                    line = stLines.nextToken();
                    st = new StringTokenizer(line, " ");

                    mt.setMemo(st.nextToken());
                    mt.setTransactionAmount(st.nextToken());


                    line = stLines.nextToken();
                    st = new StringTokenizer(line, " ");

                    date = st.nextToken();
                    mt.setDateTime(sms.getSmsDate(), date);

                    //System.out.println(mt);

                    return mt;
                }

                //KB국민카드 강*일님 05/27 01:38 182,766(KRW) 스웨   ETR.mytr 승인
                else if(line.contains("(KRW)") && line.endsWith("승인")) {

                    st = new StringTokenizer(line, " ");

                    mt.setCardName(st.nextToken());
                    mt.setOwnerName(st.nextToken());

                    date = st.nextToken();
                    time = st.nextToken();

                    mt.setDateTime(sms.getSmsDate(), date, time);

                    mt.setTransactionAmount(st.nextToken());
                    mt.setTransactionInfo(st.nextToken("승인"));

                    mt.setTransactionType("승인");
                    mt.setInstallmentPlan("일시불");

                    //System.out.println(mt);

                    return mt;

                }

                //Line 2 : KB국민카드3*5* 해외승인, KB국민카드3*5* 해외취소
                else if(line.endsWith("해외승인") || line.endsWith("해외취소")) {

                    st = new StringTokenizer(line, " ");

                    //car

                    line = st.nextToken();
                    mt.setCardName(line); // Card Name : KB국민카드3*5*

                    line = st.nextToken();
                    mt.setTransactionType(line); // Type : 해외승인, 해외취소

                    line = stLines.nextToken(); // Owner : 강*일님
                    mt.setOwnerName(line);

                    line = stLines.nextToken(); // amount, currency, date, time : 299.00(MXN) 10/10 21:25

                    st = new StringTokenizer(line, " ");

                    amount = st.nextToken(); // amount: 299.00(MXN)
                    date = st.nextToken(); // date: 10/10
                    time = st.nextToken(); // time: 21:25

                    mt.setTransactionAmount(amount);
                    mt.setDateTime(sms.getSmsDate(), date, time);

                    line = stLines.nextToken(); // 인도   YOUTUBE
                    mt.setTransactionInfo(line);

                    return mt;

                }

                //Line 2 : KB국민카드3*5*승인, KB국민카드3*5*취소

                else if(line.endsWith("승인") || line.endsWith("취소")) {


                    mt.setCardName(line); // Card Name : KB국민카드3*5*승인, KB국민카드3*5*취소

                    line = stLines.nextToken();
                    mt.setOwnerName(line); // 강*일님

                    line = stLines.nextToken(); // 29,900원 일시불, 14,540원 09/27

                    if(line.contains("/")) {

                        st = new StringTokenizer(line, " ");
                        mt.setTransactionAmount(st.nextToken());
                        mt.setDateTime(sms.getSmsDate(), st.nextToken());

                        mt.setTransactionInfo(stLines.nextToken());

                        return mt;

                    }

                    st = new StringTokenizer(line, " ");

                    mt.setTransactionAmount(st.nextToken());
                    mt.setInstallmentPlan(st.nextToken());

                    line = stLines.nextToken(); // 10/07 23:47
                    st = new StringTokenizer(line, " ");

                    date = st.nextToken(); // date: 10/10
                    time = st.nextToken(); // time: 21:25

                    mt.setDateTime(sms.getSmsDate(), date, time);

                    line = stLines.nextToken(); // 카카오페이(택시
                    mt.setTransactionInfo(line);

                    line = stLines.nextToken(); // 카카오페이(택시
                    mt.setAccumulatedExpense(line);

                    return mt;

                }

            }
        }catch(Exception e) {

            e.printStackTrace();
            System.err.println(e.toString());

            System.err.println(sms.getSmsId());
            System.err.println(smsBody);
            System.err.println(mt);

        }


        return null;
    }

	/*
	[Web발신]
	 신한카드(4735)승인 강*일 88,833원(일시불)05/01 12:45 (주)호텔신라 누적88,833원

	 */

    public static MyTransactionDto parseShinhanSms(MySms sms) {

        StringTokenizer st = null;
        StringTokenizer stSpace = null;
        String smsBody = sms.getSmsBody();
        String line, nextToken;
        MyTransactionDto mt = new MyTransactionDto();

        mt.setSmsId(sms.getSmsId());
        mt.setSmsBody(smsBody);

        if(!(smsBody.contains("승인")
                || smsBody.contains("취소")
                || (smsBody.contains("자동이체") && smsBody.contains("정상 승인"))
                || smsBody.contains("후불교통비(버스/지하철등)")
                || smsBody.contains("결제예정"))) return null;

        stSpace = new StringTokenizer(smsBody);

        try {

            if(stSpace.hasMoreTokens()) {

                line = stSpace.nextToken();

                //Line 1 : [Web발신] 제거
                if(line.contains("Web발신") && stSpace.hasMoreTokens())
                    line = stSpace.nextToken();

                //[Web발신]
                //[신한카드]강*일님, 06/08일 기준, 05월 후불교통비(버스/지하철등) 38,950원 입니다.
                if(smsBody.contains("후불교통비(버스/지하철등)")) {

                    mt.setTransactionInfo("후불교통비(버스/지하철등)");
                    mt.setCardName("신한카드");
                    mt.setOwnerName("강*일");


                    while(!line.endsWith("월") && stSpace.hasMoreTokens())
                        line = stSpace.nextToken();

                    mt.setDateTime(
                            DateUtil.getCurrentKoreanDate().substring(0,4) +
                                    line.replaceAll("월", "") + "01"
                    );

                    mt.setDateTime(DateUtil.shiftMonth(mt.getDateTime(), 2));
                    mt.setDateTime(DateUtil.shiftDay(mt.getDateTime(), -1) + "0000");

                    while(!line.contains("후불교통비(버스/지하철등)") && stSpace.hasMoreTokens())
                        line = stSpace.nextToken();

                    line = stSpace.nextToken();

                    if(line.endsWith("원")) {
                        mt.setTransactionAmount(
                                line.replaceAll("원", "")
                                        .replaceAll(",", "")
                                        .trim());
                    }

                    mt.setAccumulatedExpense("-");
                    mt.setMemo("-");
                    mt.setCanceledTransactionId("-");
                    mt.setCurrency("KRW");
                    mt.setTransactionType("-");
                    mt.setExpenseCode("103103");

                    return mt;
                }

                if(smsBody.contains("자동이체") && smsBody.contains("정상 승인")) {


                    // 신한카드(4735)승인 강*일님 LG  U+통신요금  자동이체 16,500원 정상 승인
                    // 신한카드(6614)승인 강*일님 LG  U+통신요금  자동이체 25,960원 정상 승인

                    mt.setDateTime(sms.getSmsDate().substring(0,6) + "01");
                    mt.setDateTime(DateUtil.shiftMonth(mt.getDateTime(), 1));
                    mt.setDateTime(DateUtil.shiftDay(mt.getDateTime(), -1) + "000000");

                    mt.setCardName(line); //신한카드(4735)승인
                    mt.setOwnerName(stSpace.nextToken());
                    mt.setTransactionInfo(stSpace.nextToken("자동이체").trim()); // LG  U+통신요금
                    mt.setInstallmentPlan(stSpace.nextToken(" ")); // 자동이체

                    mt.setTransactionAmount(stSpace.nextToken("원").replaceAll(",", "")); // 자동이체

                    mt.setAccumulatedExpense("-");
                    mt.setMemo("-");
                    mt.setCanceledTransactionId("-");
                    mt.setCurrency("KRW");
                    mt.setTransactionType("-");
                    mt.setExpenseCode("-");

                    return mt;
                }

                if(smsBody.contains("자동납부") && smsBody.contains("정상승인")) {


                    // [Web발신]
                    // [신한카드] 자동납부 정상승인 강원일님 04/30 (일시불) 29,490원 서울도시가스(주)

                    // [Web발신]
                    // [신한카드] 자동납부 정상승인 강원일님 03/31 (일시불) 75,460원 서울도시가스(주)

                    // 신한카드(6614)승인 강*일님 LG  U+통신요금  자동이체 25,960원 정상 승인

                    mt.setCardName(line + " " + stSpace.nextToken() + " " + stSpace.nextToken()); //[신한카드] 자동납부
                    mt.setOwnerName(stSpace.nextToken()); //강*일님
                    mt.setDateTime(DateUtil.getCurrentKoreanDateTime().substring(0,4) + stSpace.nextToken().replaceAll("/","") + "000000");
                    mt.setInstallmentPlan(stSpace.nextToken());
                    mt.setTransactionAmount(stSpace.nextToken().replaceAll(",", "").trim()); // 자동이체
                    mt.setTransactionInfo(stSpace.nextToken().trim()); // LG  U+통신요금

                    mt.setAccumulatedExpense("-");
                    mt.setMemo("-");
                    mt.setCanceledTransactionId("-");
                    mt.setCurrency("KRW");
                    mt.setTransactionType("-");
                    mt.setExpenseCode("-");

                    return mt;
                }

					/*
					 *
					 * 	[Web발신]
	 신한카드(4735)승인 강*일 88,833원(일시불)05/01 12:45 (주)호텔신라 누적88,833원
					 */

                if(line.endsWith("승인") || line.endsWith("취소")) {

                    mt.setCardName(line); // Card Name : KB국민카드3*5*승인, KB국민카드3*5*취소

                    line = stSpace.nextToken();
                    mt.setOwnerName(line); // 강*일님

                    line = stSpace.nextToken(); // 88,833원(일시불)05/01

                    if(line.contains("/")) {

                        mt.setTransactionAmount(line.substring(0, line.indexOf("원")).replaceAll(",", ""));

                        mt.setDateTime(
                                DateUtil.getCurrentKoreanDate().substring(0,4) +
                                        line.substring(line.indexOf(")") + 1).replaceAll("/", "") +
                                        stSpace.nextToken().replaceAll(":", "")
                        );

                        mt.setTransactionInfo(stSpace.nextToken());

                        nextToken = null;

                        while(stSpace.hasMoreTokens()) {
                            nextToken = stSpace.nextToken();

                            if(nextToken.startsWith("누적"))
                                break;
                            else
                                mt.appendTransactionInfo(nextToken);

                        }

                        if(nextToken != null && nextToken.startsWith("누적"))
                            mt.setAccumulatedExpense(nextToken.replaceAll(",","").replaceAll("누적", "").replaceAll("원", "")); // 누적88,833원
                        else
                            mt.setAccumulatedExpense("0");

                        if(mt.getTransactionType().equals("취소"))
                            mt.setUseFlag("N");

                        return mt;
                    }
                }

            }
        }catch(Exception e) {

            e.printStackTrace();
            System.err.println(e.toString());

            System.err.println(sms.getSmsId());
            System.err.println(sms.getSmsDate());
            System.err.println(smsBody);
            System.err.println(mt.toString());

        }


        return null;
    }


		/*
	[Web발신]
	 신한카드(4735)승인 강*일 88,833원(일시불)05/01 12:45 (주)호텔신라 누적88,833원

	 */

    public static MyTransactionDto parseHyundaiSms(MySms sms) {

        StringTokenizer st = null;
        StringTokenizer stSpace = null;
        StringTokenizer stWords = null;
        String smsBody = sms.getSmsBody();
        String line, date, time, amount, nextToken;
        MyTransactionDto mt = new MyTransactionDto();

        mt.setSmsId(sms.getSmsId());
        mt.setSmsBody(smsBody);

        if(!(smsBody.contains("승인")
                || smsBody.contains("취소")
                || (smsBody.contains("자동이체") && smsBody.contains("정상 승인"))
                || smsBody.contains("후불교통비(버스/지하철등)")
                || smsBody.contains("결제예정"))) return null;

        stSpace = new StringTokenizer(smsBody, "\n");

        try {

            if(stSpace.hasMoreTokens()) {

                line = stSpace.nextToken();

                //Line 1 : [Web발신] 제거
                if(line.contains("Web발신") && stSpace.hasMoreTokens())
                    line = stSpace.nextToken();

					/*
					 *
					 * 	[Web발신]
	 신한카드(4735)승인 강*일 88,833원(일시불)05/01 12:45 (주)호텔신라 누적88,833원
					 */

                if(line.trim().endsWith("체크승인")) {

                    mt.setCardName(line.trim()); // Card Name : 현대카드 체크승인

                    line = stSpace.nextToken();
                    mt.setOwnerName(line.trim()); // 강*일

                    line = stSpace.nextToken().trim(); // 1,500원 일시불

                    if(line.contains("원 일")) {

                        stWords = new StringTokenizer(line.trim());

                        mt.setTransactionAmount(stWords.nextToken().replaceAll("원", "").replaceAll(",", ""));

                        //mt.setTransactionInfo(stSpace.nextToken());
                    }

                    line = stSpace.nextToken().trim(); // 04/27 10:15

                    stWords = new StringTokenizer(line.trim());

                    mt.setDateTime(
                            DateUtil.getCurrentKoreanDate().substring(0,4)
                                    + stWords.nextToken().replaceAll("/","")
                                    + stWords.nextToken().replaceAll(":","")
                                    + "00"
                    );

                    mt.setTransactionInfo(stSpace.nextToken()); //코스트코코리아

                    return mt;
                }
            }
        }catch(Exception e) {

            e.printStackTrace();
            System.err.println(e.toString());

            System.err.println(sms.getSmsId());
            System.err.println(sms.getSmsDate());
            System.err.println(smsBody);
            System.err.println(mt.toString());

        }


        return null;
    }

    public static MyStockHistoryDto parseHanKookStockSms(MySms sms) {

        StringTokenizer stLines = null;
        String smsBody = sms.getSmsBody();
        String line;
        MyStockHistoryDto ms = new MyStockHistoryDto();

        boolean buyFlag;

        ms.setSmsId(sms.getSmsId());
        ms.setSmsBody(smsBody);


        if(smsBody.contains("현금매수체결"))
            buyFlag = true;

        else if(smsBody.contains("현금매도체결"))
            buyFlag = false;

        else
            return null;

        stLines = new StringTokenizer(smsBody, "\n");

        try {

            //[Web발신]
            line = stLines.nextToken();

            //[한투]강원일님
            line = stLines.nextToken();

            //현금매수체결, 현금매도체결
            line = stLines.nextToken();

            //KODEX선진국MSCIWorld
            line = stLines.nextToken();
            line = line.trim();
            ms.setStockName(line);

            //(251350)
            line = stLines.nextToken();
            line = line.replaceAll("\\(", "").replaceAll("\\)", "").trim();
            ms.setStockNumber(line);

            //105주
            line = stLines.nextToken();

            line = line.replaceAll("주", "").replaceAll(",", "").trim();

            if(buyFlag)
                ms.setNumberOfStock(NumberUtil.parseInt(line));
            else
                ms.setNumberOfStock(NumberUtil.parseInt("-" + line));

            //20,615원
            line = stLines.nextToken();
            line = line.replaceAll("원", "").replaceAll(",", "").trim();
            ms.setStockPrice(NumberUtil.parseInt(line));

            ms.setStockTradingDate(sms.getSmsDate());
            ms.setTotalTradingPrice();

            return ms;

        }catch(Exception e) {

            e.printStackTrace();
            System.err.println(e.toString());

            System.err.println(sms.getSmsId());
            System.err.println(smsBody);
            System.err.println(ms);

        }


        return null;
    }

}
