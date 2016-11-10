package techkids.vn.listviewintro.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by apple on 11/8/16.
 */

public class Student implements Serializable {
    private String name;
    private String gender;
    private int age;

    public static final int OP_ADD = 0;
    public static final int OP_UPDATE = 1;

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }
    final static Student[] STUDENTS =  {
            new Student("Lựu", "female", 17),
            new Student("Tuấn", "male", 15),
            new Student("Nghĩa", "male", 11),
            new Student("Đức", "male", 9),
            new Student("Cường", "male", 16)
    };

    public static ArrayList<Student> list = new ArrayList<>(Arrays.asList(STUDENTS));
}
