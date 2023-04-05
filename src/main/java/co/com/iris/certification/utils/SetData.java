package co.com.iris.certification.utils;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SetData {

    protected static final Map<String, String> MONTHS = new HashMap<>();
    static {
        MONTHS.put("01", "ene.");
        MONTHS.put("02", "feb.");
        MONTHS.put("03", "mar.");
        MONTHS.put("04", "abr.");
        MONTHS.put("05", "may.");
        MONTHS.put("06", "jun.");
        MONTHS.put("07", "jul.");
        MONTHS.put("08", "ago.");
        MONTHS.put("09", "sept.");
        MONTHS.put("10", "oct.");
        MONTHS.put("11", "nov.");
        MONTHS.put("12", "dic.");
    }

    private SetData() {
    }
    public static String setPassword(String password) {
        return password + (int) Math.floor(Math.random() * 101);
    }

    public static String[] dateInDayMonthYearFormat(String date, String splitChar) {
        return (date.split(splitChar));
    }

    public static String getCurrentYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String getCurrentDateFormatDayMonthYear() {
        String pattern = "dd/MM/yyyy";
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static String convertMonth(String month) {
        return MONTHS.get(month);
    }

    public static String convertDayAndMonth(String value) {
        if (value.startsWith("0")) {
            value = value.substring(1);
        }
        return value;
    }

    public static String formatValueTransfer(String value){

        return value.replace("$","").replace(",", "");
    }

    public static BigDecimal formatValueBigDecimal(String value){
        return new BigDecimal(value.replace("$","").replace(",", ""));
    }

    public static List<String> convertStringToList(String parameter){
        return Arrays.stream(parameter.split(",")).collect(Collectors.toList());
    }

    public static List<String> convertListToLowerCase(List<String> list){
        int i =0;
        while(i<list.size()){
            list.set(i,list.get(i).toLowerCase());
            i++;
        }
        return list;
    }

    public static List<String> removeBlankSpacesInElementsOfList(List<String> list){
        int i =0;
        while(i<list.size()){
            list.set(i,list.get(i).trim());
            i++;
        }
        return list;
    }
    public static Map<Integer,String> convertListToMap(List<String> lista){
        Map<Integer, String> map = new HashMap<>();
        for (int i=0; i<lista.size();i++) {
            map.put(i,lista.get(i).toLowerCase());
        }
        return map;
    }

    public static String removeLineBreak(String parameter){
        return parameter.replace("\n", " ").replace(",","");
    }
}
