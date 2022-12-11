package mainapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static Date to_yyyy_MM_dd(String input) throws ParseException {
        SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = null;
        java.sql.Date sqlDate = null;
        yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
        utilDate = yyyy_MM_dd.parse(input);
        sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public static Date to_dd_MM_yyyy(String input) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date utlDate = simpleDateFormat.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utlDate.getTime());
        return sqlDate;
    }

    public static Date to_MM_dd_yyyy(String input) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date utlDate = simpleDateFormat.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utlDate.getTime());
        return sqlDate;
    }
}
