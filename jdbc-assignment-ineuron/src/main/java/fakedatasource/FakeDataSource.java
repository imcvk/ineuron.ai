package fakedatasource;

import com.github.javafaker.Faker;
import entities.Student;

import java.sql.Date;

public class FakeDataSource {
    private Faker faker;

    public FakeDataSource() {
    }

    public FakeDataSource(Faker faker) {
        this.faker = faker;
    }

    public Faker getFaker() {
        return faker;
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public int getUserId() {
        return faker.number().numberBetween(9999, 99999);
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getCountry() {
        return faker.address().country();
    }

    public Student constructStudent() {
        Student s = new Student();
        s.setName(faker.name().fullName());
        s.setGender("male");
        s.setAddress(faker.address().fullAddress());
        s.setDob(new java.sql.Date(1997 - 12 - 12));
        s.setDoj(new java.sql.Date(2015 - 12 - 12));
        s.setDom(new Date(2021 - 12 - 12));
        return s;
    }
}
