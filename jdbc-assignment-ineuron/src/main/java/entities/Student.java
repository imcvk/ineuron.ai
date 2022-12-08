package entities;

import java.sql.Date;

public class Student {
    int id;
    String name;
    String address;
    String gender;
    Date dob;
    Date doj;
    Date dom;

    public Student() {
    }

    public Student(String name, String address, String gender, Date dob, Date doj, Date dom) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.doj = doj;
        this.dom = dom;
    }

    public Student(int id, String name, String address, String gender, Date dob, Date doj, Date dom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.doj = doj;
        this.dom = dom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getDom() {
        return dom;
    }

    public void setDom(Date dom) {
        this.dom = dom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", doj=" + doj +
                ", dom=" + dom +
                '}';
    }
}
