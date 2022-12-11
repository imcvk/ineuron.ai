package DB;

import entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {
    private final String INSERTER = "INSERT INTO ASSIGNMENT1(NAME, ADDRESS, GENDER,DOB,DOJ,DOM) VALUES (?,?,?,?,?,?)";

    public boolean insert(Student s) {
        boolean r = false;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERTER);
            statement.setString(1, s.getName());
            statement.setString(2, s.getAddress());
            statement.setString(3, s.getGender());
            statement.setDate(4, s.getDob());
            statement.setDate(5, s.getDoj());
            statement.setDate(6, s.getDom());
            r = statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    private final String DELETER = "DELETE FROM ASSIGNMENT1 WHERE ID=?";

    public int delete(int id) {
        int r = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETER);
            statement.setInt(1, id);
            r = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    private String selector = "select * from ASSIGNMENT1 where id=?";

    public Student select(int id) {
        int r = 0;
        Student s = new Student();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(selector);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                s.setName(resultSet.getString(2));
                s.setAddress(resultSet.getString(3));
                s.setGender(resultSet.getString(4));
                s.setDob(resultSet.getDate(5));
                s.setDoj(resultSet.getDate(6));
                s.setDom(resultSet.getDate(7));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    private String selectorAll = "select * from ASSIGNMENT1";

    public List<Student> selectAll() {
        int r = 0;
        List<Student> students = new ArrayList<Student>();
        Student s = new Student();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectorAll);
            ResultSet resultSetAll = statement.executeQuery();
            while (resultSetAll.next()) {
                s.setName(resultSetAll.getString(2));
                s.setAddress(resultSetAll.getString(3));
                s.setDob(resultSetAll.getDate(4));
                s.setDoj(resultSetAll.getDate(5));
                s.setDoj(resultSetAll.getDate(6));
                s.setGender(resultSetAll.getString(7));
                students.add(s);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private final String UPDATER = "UPDATE ASSIGNMENT1 A SET A.ADDRESS=?,A.GENDER=?,A.DOB=?,A.DOJ=?,A.DOM=?,A.NAME=? where A.ID=?";

    public int update(Student s) {
        int r = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATER);
            statement.setString(1, s.getAddress());
            statement.setString(2, s.getGender());
            statement.setDate(3, s.getDob());
            statement.setDate(4, s.getDoj());
            statement.setDate(5, s.getDom());
            statement.setString(6, s.getName());
            statement.setInt(7, s.getId());
            r = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
