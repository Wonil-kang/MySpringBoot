package kr.wonil.myspringboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class DateUtil {

    public static int DATE_TYPE_1 = 1; //03/12 17:40:40



    public static String getReadableDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

        return format.format(date);
    }

    public static String getReadableDate(long date){

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

        return format.format(date);
    }

    public static String getReadableKoreanDate(long longDate){

        TimeZone timeZone;                                        // 객체 생성
        Date date = new Date(longDate);                        // 현재 날짜가 담긴 Date 객체 생성
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);


        try {
            timeZone = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
            dateFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            return dateFormat.format(date);

        }catch (Exception e){

        }

        return dateFormat.format(longDate);
    }


    public static long getLongDate(String dateTime){

        long rstTime = 0;
        SimpleDateFormat simpleDateFormat;
        Date date;

        try {

            if(dateTime.length() == 12)
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
            else if(dateTime.length() == 8)
                simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            else
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            date = (Date) simpleDateFormat.parse(dateTime);
            rstTime = date.getTime();

        }catch (Exception e){

//            Log.e("getLongDate",e.toString());
        }

        return rstTime;
    }


    public static String getReadableDateForView(String date){

        if(date.length() >= 14) {

            if(getCurrentKoreanDate().substring(0,8).equals(date.substring(0,8)))
                return date.substring(8,10) + ":" + date.substring(10,12) + ":" + date.substring(12,14);

            return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6,8) + "." +
                    "(" + getSimpleDayForView(getDay(date)) + ") " +
                    date.substring(8,10) + ":" + date.substring(10,12) + ":" + date.substring(12,14);

        }


        else if(date.length() >= 12) {

            if(getCurrentKoreanDate().substring(0,8).equals(date.substring(0,8)))
                return date.substring(8,10) + ":" + date.substring(10,12);

            return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6,8) + "." +
                    "(" + getSimpleDayForView(getDay(date)) + ") " +
                    date.substring(8,10) + ":" + date.substring(10,12);
        }


        if(date.length() >= 8) {

            return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6,8) + ".(" + getSimpleDayForView(getDay(date)) + ")";
        }

        return "-";

    }

    public static String getSimpleReadableDateForView(String date){

        if(date.length() >= 14) {

            if(getCurrentKoreanDate().substring(0,8).equals(date.substring(0,8)))
                return date.substring(8,10) + ":" + date.substring(10,12) + ":" + date.substring(12,14);

            return date.substring(4,6) + "/" + date.substring(6,8);
        }

        else if(date.length() >= 12) {

            if(getCurrentKoreanDate().substring(0,8).equals(date.substring(0,8)))
                return date.substring(8,10) + ":" + date.substring(10,12);

            return date.substring(4,6) + "/" + date.substring(6,8);
        }

        else if(date.length() >= 8) {

            return date.substring(4,6) + "/" + date.substring(6,8);
        }

        return "-";

    }


    public static String getSimpleReadableDateOrTimeForView(String date){

        if(date.length() >= 12) {

            if(getCurrentKoreanDate().substring(0,8).equals(date.substring(0,8)))
                return date.substring(8,10) + ":" + date.substring(10,12);

            return date.substring(4,6) + "/" + date.substring(6,8);
        }

        else if(date.length() >= 8) {

            return date.substring(4,6) + "/" + date.substring(6,8);
        }

        return "-";

    }


    public static String getReadableDateTimeForView(String date){

        if(date.length() >= 12){

            return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6,8) + ".(" + getSimpleDayForView(getDay(date)) + ")" +
                    "\t" + date.substring(8,10) + ":" + date.substring(10,12);

        }else if(date.length() == 8) {

            return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6,8) + ".(" + getSimpleDayForView(getDay(date)) + ")";
        }

        return "-";

    }

    //yyyymmddHHmm
    public static String getCurrentKoreanDateTime(){

        return getCurrentKoreanDateTimeSecond().substring(0,12);
    }

    public static String getCurrentKoreanTime(){

        return getCurrentKoreanDateTimeSecond().substring(8,12);
    }

    public static String getCurrentKoreanDate(){

        getCurrentKoreanDateTimeSecond().substring(0,8);

        return getCurrentKoreanDateTimeSecond().substring(0,8);
    }

    public static String getCurrentKoreanDateTimeSecond(){

        TimeZone timeZone;                                        // 객체 생성
        Date date = new Date();                        // 현재 날짜가 담긴 Date 객체 생성
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
        String rst = null;


        try {
            timeZone = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
            dateFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            rst = dateFormat.format(date);

//            System.out.println(rst);

            return rst;

        }catch (Exception e){

            System.err.println(e.toString());

        }


        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getCurrentLocalTime(){

        return getCurrentLocalDateTimeSecond().substring(8,12);
    }


    public static String getCurrentLocalDateTimeSecond(){

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(System.currentTimeMillis());
    }


    public static String getCurrentLocalDateTime(){

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return dateFormat.format(System.currentTimeMillis());
    }


    public static String getCurrentYear(){

        return getCurrentKoreanDate().substring(0,4);
    }

    public static String getLastYear(){

        int thisYear = NumberUtil.parseInt(getCurrentYear());

        return (thisYear - 1) + "";
    }

    public static String getReadableTime(String dateTime){

        if(dateTime == null) return "-";
        if(dateTime.length() < 12) return "-";

        return dateTime.substring(8,10)+":"+dateTime.substring(10,12);

    }

    public static String getReadableDateAndDay(String dateTime){

        if(dateTime == null) return "-";
        if(dateTime.length() < 12) return "-";

        return NumberUtil.parseInt(dateTime.substring(4,6))+"월"+
                NumberUtil.parseInt(dateTime.substring(6,8)) + "일("
                + getSimpleDayForView(dateTime) +")" ;

    }

    public static String getReadableSimpleDateTime(String date){

        if(date == null) return "-";
        if(date.length() != 12) return "-";

        String currentTime = getCurrentKoreanDateTime();


        if(currentTime.substring(0,8).equals(date.substring(0,8))){

            return date.substring(8,10) + ":" + date.substring(10,12);

        }else if(NumberUtil.parseInt(currentTime.substring(0,8)) - NumberUtil.parseInt(date.substring(0,8)) == 1){
            return "어제";

        }else if(currentTime.substring(0,4).equals(date.substring(0,4))){
            String month = date.substring(4,6);
            String day = date.substring(6,8);

            if(month.startsWith("0")) month = month.substring(1,2);
            if(day.startsWith("0")) day = day.substring(1,2);

            return month +"월" + day + "일";
        }else{

            return date.substring(0,4)+"."+date.substring(4,6)+ "." + date.substring(6,8);
        }
    }

    public static String getReadableDateExceptYear(String date){

        if(date == null) return "-";
        if(date.length() != 12) return "-";

        String currentTime = getCurrentKoreanDateTime();

        if(currentTime.substring(0,8).equals(date.substring(0,8))){

            return "오늘 " + date.substring(8,10) + ":" + date.substring(10,12);

        }else if(NumberUtil.parseInt(currentTime.substring(0,8)) - NumberUtil.parseInt(date.substring(0,8)) == 1){
            return "어제 " + date.substring(8,10) + ":" + date.substring(10,12);

        }else{
            String month = NumberUtil.getReadableNumber(date.substring(4,6));
            String day = NumberUtil.getReadableNumber(date.substring(6,8));

            return month +"." + day + "(" +getShortTermDayForView(date) +") " + date.substring(8,10) + ":" + date.substring(10,12);
        }
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static int getDay(String inputDate){

        if(inputDate.length() < 8) return -1;

        DateFormat dateFormat =  new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        Date date = null;

        try {

            date = dateFormat.parse(inputDate.substring(0, 8));
            calendar.setTime(date);

            return calendar.get(Calendar.DAY_OF_WEEK);

        }catch (Exception e){
            System.err.println(e.toString());
        }
        return -1;
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static boolean isKoreanBusinessDayTime(){

        TimeZone timeZone;                                        // 객체 생성
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();                        // 현재 날짜가 담긴 Date 객체 생성
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.KOREAN);
        DateFormat timeFormat = new SimpleDateFormat("HHmm", Locale.KOREAN);
        int day = -1;
        int time = -1;

        //dateFormat.format(date)     //  출력

        try {

            timeZone = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
            dateFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            timeFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            date = dateFormat.parse(dateFormat.format(date));
            calendar.setTime(date);
            day = calendar.get(Calendar.DAY_OF_WEEK);

            if(day != 1 && day != 7) {

                time = NumberUtil.parseInt(timeFormat.format(date));

                if(time >= 855 && time <= 1535 )
                    return true;

            }


        }catch (Exception e){


        }

        return false;
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static boolean isKoreanWeekend(){

        TimeZone timeZone;                                        // 객체 생성
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();                        // 현재 날짜가 담긴 Date 객체 생성
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.KOREAN);
        DateFormat timeFormat = new SimpleDateFormat("HHmm", Locale.KOREAN);
        int day = -1;

        //dateFormat.format(date)     //  출력

        try {

            timeZone = TimeZone.getTimeZone("Asia/Seoul");  // TimeZone에 표준시 설정
            dateFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            timeFormat.setTimeZone(timeZone);                    //DateFormat에 TimeZone 설정
            date = dateFormat.parse(dateFormat.format(date));
            calendar.setTime(date);
            day = calendar.get(Calendar.DAY_OF_WEEK);

            if(day == 1 || day == 7) return true;


        }catch (Exception e){


        }

        return false;
    }

    public static String getSimpleDayForView(String date) {

        if(date.length() < 12) return "-";
        int day = getDay(date);

        return getSimpleDayForView(day);
    }

    public static String getDayForView(String date) {

        if(date.length() < 12) return "-";
        int day = getDay(date);

        return getDayForView(day);
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static String getDayForView(int day) {

        switch (day) {
            case 1:
                return "일요일";

            case 2:
                return "월요일";

            case 3:
                return "화요일";

            case 4:
                return "수요일";

            case 5:
                return "목요일";

            case 6:
                return "금요일";

            case 7:
                return "토요일";
        }
        return "-";
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static String getSimpleDayForView(int day) {

        switch (day) {
            case 1:
                return "일";

            case 2:
                return "월";

            case 3:
                return "화";

            case 4:
                return "수";

            case 5:
                return "목";

            case 6:
                return "금";

            case 7:
                return "토";
        }
        return "-";
    }

    public static String getShortTermDayForView(String date) {

        int day = getDay(date);

        switch (day) {
            case 1:
                return "일";

            case 2:
                return "월";

            case 3:
                return "화";

            case 4:
                return "수";

            case 5:
                return "목";

            case 6:
                return "금";

            case 7:
                return "토";
        }
        return "-";
    }

    public static String shiftDay(String inputDate, int shift){

        if(inputDate.length() < 8) return "-";
        if(shift == 0) return inputDate;

        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;

        try {

            date = dateFormat.parse(inputDate.substring(0, 8));
            calendar.setTime(date);

            //calendar.add(Calendar.MONTH, 2);
            calendar.add(Calendar.DATE, shift);

            return dateFormat.format(calendar.getTime());

        }catch (Exception e){
            System.err.println(e.toString());
        }

        return "-";
    }

    public static String shiftMonth(String inputDate, int shift){

        if(inputDate.length() < 8) return "-";
        if(shift == 0) return inputDate;

        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        String rst;

        try {

            date = dateFormat.parse(inputDate.substring(0, 8));
            calendar.setTime(date);

            calendar.add(Calendar.MONTH, shift);
            //calendar.add(Calendar.DATE, shift);
            rst = dateFormat.format(calendar.getTime());

            return rst;

        }catch (Exception e){
            System.err.println(e.toString());
        }

        return "-";
    }


    public static String shiftYear(String inputDate, int shift){

        if(inputDate.length() < 8) return "-";
        if(shift == 0) return inputDate;

        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        String rst;

        try {

            date = dateFormat.parse(inputDate.substring(0, 8));
            calendar.setTime(date);

            calendar.add(Calendar.YEAR, shift);
            //calendar.add(Calendar.DATE, shift);
            rst = dateFormat.format(calendar.getTime());

            return rst;

        }catch (Exception e){
            System.err.println(e.toString());
        }

        return "-";
    }

    //Sunday 1, Monday 2, Tuesday 3, Wednesday 4, Thursday 5, Friday 6, Saturday 7
    public static String getStartDateOfWeek(boolean sundayStartFlag, String inputDate){

        if(inputDate.length() < 8) return "-";

        int day = getDay(inputDate);
        int shiftNumberOfDate;

        if(sundayStartFlag) {
            //In case of Sunday

            if (day == 1)
                return inputDate;
            else
                shiftNumberOfDate = -day + 1;

        }else{

            if (day == 1)
                shiftNumberOfDate = -6;
            else
                shiftNumberOfDate = -day + 2;
        }

        return DateUtil.shiftDay(inputDate.substring(0,8), shiftNumberOfDate);
    }

    /*
     * 8자리 날짜만 입력
     */
    public static int getDifferenceDates(String startDate, String endDate){

        if(startDate.length() < 8 || endDate.length() < 8) return -1;
        String firstDate = startDate.substring(0,8);
        String secondDate = endDate.substring(0,8);

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            // date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
            Date FirstDate = format.parse(firstDate);
            Date SecondDate = format.parse(secondDate);

            // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
            // 연산결과 -950400000. long type 으로 return 된다.
            long calDate = FirstDate.getTime() - SecondDate.getTime();

            // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
            // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
            long calDateDays = calDate / (24 * 60 * 60 * 1000);

            calDateDays = Math.abs(calDateDays);

            return (int) (calDateDays);

        }catch (Exception e){

            return -1;
        }
    }

    public static String getLastDateOfMonth(String yearMonth){

        if(yearMonth.length() < 6) return "-";
        Calendar  calendar = Calendar.getInstance();
        String day = null;
        calendar.set(
                NumberUtil.parseInt(yearMonth.substring(0,4)),
                NumberUtil.parseInt(yearMonth.substring(4,6)) - 1, //1월이 0이기 때문
                1);

        day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) +"";

        if(day.length() == 2) return yearMonth.substring(0,6) + day;
        if(day.length() == 1) return yearMonth.substring(0,6) + 0 +day;

        return "-";

    }

    public static String getShiftMonthStartDate(String date, int shift){

        String newDate = shiftMonth(date, shift).substring(0,6) + "010000";

        return newDate;
    }

    public static String getShiftMonthStartDate( int shift){

        return getShiftMonthStartDate(getCurrentKoreanDateTime(), shift);
    }


    public static String getShiftMonthLastDate(String date, int shift){

        String newDate = getLastDateOfMonth(
                shiftMonth(date, shift).substring(0,6)).substring(0,8)
                + "2500";

        return newDate;
    }

    public static String getShiftMonthLastDate(int shift){

        return getShiftMonthLastDate(getCurrentKoreanDateTime(), shift);
    }


    /*
    public static int getMonthDays(String month, TransactionManager transactionManager){

        String today = getCurrentDateTime();
        String dbStartDate = transactionManager.getEarliestExpenseDate();
        String startDate = null;
        String lastDate = null;
        String tMonth = null;

        if(month.length() < 6) return 0;
        tMonth = month.substring(0,6);

        if (dbStartDate.substring(0,6).equals(month.substring(0,6))){

            startDate = dbStartDate.substring(0,8);

        }else{
            startDate = tMonth.substring(0,6) + "01";
        }

        if (month.equals(today.substring(0,6)))
            lastDate = today.substring(0,8);
        else
            lastDate = getLastDateOfMonth(tMonth);

        return getDifferenceDates(startDate, lastDate);
    }


     */

    public static String getStartDate(String date){

        if(date.length() == 4) return date + "0101";

        if(date.length() == 6) return date + "01";

        return "19000101";
    }

    public static String getEndDate(String date){

        if(date.length() == 4) return date + "1231";

        if(date.length() == 6) return getLastDateOfMonth(date);

        return "29991231";
    }



    public static String getLastDate(String date){

        if(date.length() == 4) return (NumberUtil.parseInt(date) - 1) + "";

        if(date.length() == 6) return shiftMonth(date+"01", -1).substring(0,6);

        return "29991231";
    }

    public static boolean isBusinessTime(){

        int time = NumberUtil.parseInt(getCurrentKoreanTime());

        return time > 859 && time < 1531;
    }


    public static long getTimeDifference(String dateTime1, String dateTime2){
        long time1 = getLongDate(dateTime1)/1000;
        long time2 = getLongDate(dateTime2)/1000;
        long diff = time1 - time2;

        if(diff < 0) return -diff;

        return diff;
    }

    public static String getReadableTimeForSeconds(long sec){

        long mins = sec/60;
        long hours = mins/60;

        mins %= 60;

        if(mins < 10)
            return hours + ":0" + mins;

        return hours + ":" + mins;

    }

    public static String getReadableDateForEditingView(String date){

        int length = -1;
        if(date == null) return "-";

        length = date.length();


        if(length <= 3)
            return date;

        else if(length == 4)
            return date.substring(0,2) + "." + date.substring(2,4) + ".";


        return  date.substring(0,length-4)
                + "." + date.substring(length-4,length-2)
                + "." + date.substring(length-2,length) + ".";

    }

    public static boolean checkDateValidity(String date, int targetLength){

        if(targetLength != date.length())
            return false;

        if(targetLength >= 8){
            int year = NumberUtil.parseInt(date.substring(0,4));
            int month = NumberUtil.parseInt(date.substring(4,6));
            int day = NumberUtil.parseInt(date.substring(6,8));

            if(year < 1000 || year > 3000)
                return false;

            if(month < 1 || month > 12)
                return false;

            if(day < 1 || day > 31)
                return false;
        }


        return true;

    }



    /*
     * YYYY.MM.DD. HH:mm:SS (WD)
     */
    public static String getReadableDate(String date, String format){

        String year, month, day, hour, minute, second;
        int length;

        if(date == null || date.length() < 8) return "-";

        //format = format.toUpperCase(Locale.ROOT);
        length = date.length();

        year = date.substring(0,4);
        month = date.substring(4,6);
        day = date.substring(6,8);

        if(format.contains("WD")) {
            format = format.replace("WD", getSimpleDayForView(date));

        }

        if(length <= 9){
            return format.replace("YYYY", year)
                    .replace("MM",month)
                    .replace("DD",day);
        }

        else if(length <= 13){
            hour = date.substring(8,10);
            minute = date.substring(10,12);

            return format.replace("YYYY", year)
                    .replace("MM",month)
                    .replace("DD",day)
                    .replace("HH",hour)
                    .replace("mm",minute);
        }

        else {

            hour = date.substring(8,10);
            minute = date.substring(10,12);
            second = date.substring(12,14);

            return format.replace("YYYY", year)
                    .replace("MM", month)
                    .replace("DD", day)
                    .replace("HH", hour)
                    .replace("mm", minute)
                    .replace("SS", second);
        }



    }

    public static String getReadableDate(String date, int type){

        if(type == DATE_TYPE_1){

            if(date.length() < 14) return "-";
            date = date.substring(4,6) + "/" +
                    date.substring(6,8) + " " +
                    date.substring(8,10) + ":" +
                    date.substring(10,12) + ":" +
                    date.substring(12,14);

        }

        return date;
    }

    public static int getDaysOfMonth(String month){

        int daysOfMonth = 0;
        String nextMonth = shiftMonth(month.substring(0,6)+"01", 1);
        daysOfMonth = NumberUtil.parseInt(shiftDay(nextMonth,-1).substring(6,8));

        return daysOfMonth;
    }

}
