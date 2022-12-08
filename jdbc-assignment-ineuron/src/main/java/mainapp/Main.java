package mainapp;

import DB.DBOperations;
import com.github.javafaker.Faker;
import entities.Student;
import fakedatasource.FakeDataSource;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        String d1, d2, d3;
        d1 = "23-03-2000";
        d2 = "03-23-2000";
        d3 = "2000-03-23";
        Student s=new Student();
        s.setId(112);
        s.setName("sdfsdf");
        s.setGender("sdfsdf");
        s.setAddress("sdfsdf");
        s.setDob((Date) FormatDate.to_dd_MM_yyyy(d1));
        s.setDoj((Date) FormatDate.to_MM_dd_yyyy(d2));
        s.setDom((Date) FormatDate.to_yyyy_MM_dd(d3));
        System.out.println(s);
        DBOperations dbOperations=new DBOperations();
        dbOperations.insert(s);
    }

}
