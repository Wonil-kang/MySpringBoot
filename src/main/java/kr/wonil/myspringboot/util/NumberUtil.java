package kr.wonil.myspringboot.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;


public class NumberUtil {

    public static String getReadableNumber(String number){



        try {

            if(number == null) return "0";
            DecimalFormat decimalFormat = new DecimalFormat("###,###");

            if(number.equals("-")) return "0";

            if(number.contains("."))
                return getReadableNumber(number.substring(0,number.indexOf(".")));

            if(number.startsWith("-")){

                return  "-" + decimalFormat.format(NumberUtil.parseInt(number.substring(1,number.length())));

            }

            if(number.equals("")){

                return  "0";
            }

            return decimalFormat.format(NumberUtil.parseInt(number));

        }catch(Exception e){

            System.err.println(e.toString());

        }

        return "0";
    }

    public static String getReadableNumberWithSign(int number){

        if(number > 0) return "+" + getReadableNumber(number + "");

        return getReadableNumber(number + "");
    }

    public static String getReadableNumberWithSign(String number){


        return getReadableNumberWithSign(parseInt(number));
    }



    public static String getReadableNumber(int number){

        return getReadableNumber(number + "");
    }

    public static String getReadableAbsoluteNumber(int number){

        if(number < 0) number = -number;

        return getReadableNumber(number + "");
    }


    public static String getReadableFloatNumberWithSign(double number, int decimalPosition){

        if(number > 0)
            return "+" + getReadableFloatNumber(number, decimalPosition);

        return getReadableFloatNumber(number, decimalPosition);
    }

    public static String getReadableFloatNumberWithSign(String number, int decimalPosition){

        return getReadableFloatNumberWithSign(parseDouble(number), decimalPosition);
    }

    public static String getReadableFloatNumber(String number, int decimalPosition){

        return getReadableFloatNumber(parseDouble(number), decimalPosition);
    }

    public static String getReadableFloatNumberWithPercent(double number, int decimalPosition){

        return getReadableFloatNumber(number, decimalPosition) + "%";
    }

    public static String getReadableFloatNumberWithPercentAndSign(String number, int decimalPosition){

        return getReadableFloatNumberWithPercentAndSign(parseDouble(number), decimalPosition);
    }

    public static String getReadableFloatNumberWithPercentAndSign(double number, int decimalPosition){

        return getReadableFloatNumberWithSign(number, decimalPosition) + "%";
    }

    public static String getReadableFloatNumber(double number, int decimalPosition){


        String numberString = number + "";
        String start;
        String last;

        try {
            start = numberString.substring(0, numberString.indexOf("."));
            last = numberString.substring(numberString.indexOf(".")).replace(".", "");

            if (decimalPosition <= 0) return getReadableNumber(start);

            if (last.length() < decimalPosition) {
                String rst = getReadableNumber(start) + "." + last.substring(0, last.length());

                for (int i = 0; i < (decimalPosition - last.length()); i++) {
                    rst += "0";
                }

                return rst;

            } else return getReadableNumber(start) + "." + last.substring(0, decimalPosition);
        }catch(Exception e){
            return "0.0";
        }
    }

    public static double roundNumber(double number, int decimalPosition){


        return parseDouble(getReadableFloatNumber(number, decimalPosition));
    }


    public static String fillNumber(String number, int length){

        int addNum = length - number.length();
        String prefix = "";

        if(addNum < 0 ) return number;

        for(int i=0; i<addNum; i++){

            prefix += "0";

        }

        return prefix + number;
    }

    public static int parseInt(String number){


        if (number == null) return 0;
        else if (number.equals("-")) return 0;

        if(number.equals(" ")) return 0;

        try {

            if(number.indexOf("E") > -1 || number.indexOf("e") > -1){

                number = number.replace("+","");
                number = number.replace("e","E");

                BigDecimal decimal = new BigDecimal(number);

                return decimal.intValue();
            }

            if(number.endsWith(".0")){
                number = number.replace(".0", "");
                return Integer.parseInt(number);
            }

            return Integer.parseInt(number);


        }catch(Exception e) {

            System.err.println(number);
            System.err.println(e.toString());
            e.printStackTrace();

        }

        return -1;
    }

    public static double parseDouble(String number){
        double rst = 0;

        if(number == null || number.equals("-")) return 0;

        try {

            rst = Double.parseDouble(number);
            return rst;

        }catch (Exception e){

//            Log.e("parseDouble", e.toString());

        }

        return -1;
    }

    public static int min(int a, int b){
        if(a > b) return a;

        return b;
    }

    public static double min(double a, double b){
        if(a > b) return a;

        return b;
    }

    public static double getCompoundInterest(double number, double interest, int numberOfYear){

        for(int i=0; i<numberOfYear; i++){

            number = (1+interest) * number;
        }

        return number;
    }


}
