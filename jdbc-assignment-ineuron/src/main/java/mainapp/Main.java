package mainapp;


import java.text.ParseException;

import java.sql.Date;
import java.util.Scanner;

import DB.DBOperations;
import entities.Student;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DBOperations dbOperations = new DBOperations();

        boolean active = true;
        while (active) {
            System.out.println("1.Create    2.Delete    3.Update    4.Select    5.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Main.createRecord(sc, dbOperations);
                    break;
                case 2:
                    Main.deleteRecord(sc, dbOperations);
                    break;
                case 3:
                    Main.updateRecord(sc, dbOperations);
                    break;
                case 4:
                    Main.selectRecord(sc, dbOperations);
                    break;
                case 5:
                    active = false;
                    break;
            }
        }
    }

    public static void createRecord(Scanner sc, DBOperations dbOperations) throws ParseException {
        Student student = Main.getStudent(sc);
        dbOperations.insert(student);
    }
    public static void deleteRecord(Scanner sc, DBOperations dbOperations) {
        System.out.println("Enter Student id to delete:");
        int id = sc.nextInt();
        dbOperations.delete(id);
    }
    public static void selectRecord(Scanner sc, DBOperations dbOperations) {
        System.out.println("Enter Student id to fetch record:");
        int id = sc.nextInt();
        System.out.println(dbOperations.select(id));
    }
    public static void updateRecord(Scanner sc, DBOperations dbOperations) throws ParseException {
        System.out.println("Enter Student ID to Update:");
        int id = sc.nextInt();
        Student student = Main.getStudent(sc);
        student.setId(id);
        try {
            dbOperations.update(student);
        } catch (Exception e) {
        }
    }

    public static Student getStudent(Scanner sc) {
        Student student = new Student();
        Date dob = null, doj = null, dom = null;
        String name, address, gender, tempDate;
        System.out.println("Enter Name of Student:");
        name = sc.next();
        System.out.println("Enter Address of Student:");
        address = sc.next();
        System.out.println("Enter Gender of Student:");
        gender = sc.next();
        System.out.println("Enter DOB of Student:");
        tempDate = sc.next();
        try {
            dob = (Date) FormatDate.to_dd_MM_yyyy(tempDate);
            System.out.println("Enter DOJ of Student:");
            tempDate = sc.next();
            doj = (Date) FormatDate.to_MM_dd_yyyy(tempDate);
            System.out.println("Enter DOM of Student:");
            tempDate = sc.next();
            dom = (Date) FormatDate.to_yyyy_MM_dd(tempDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setName(name);
        student.setAddress(address);
        student.setGender(gender);
        student.setDob(dob);
        student.setDoj(doj);
        student.setDom(dom);
        return student;
    }
}
