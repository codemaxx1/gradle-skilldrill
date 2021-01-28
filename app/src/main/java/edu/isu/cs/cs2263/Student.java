package edu.isu.cs.cs2263;

import java.io.Serializable;

public class Student implements Serializable {
    private final Course course;
    private String firstName;
    private String lastName;

    public Student(Course course){
        this.course = course;
    };

    public Student(String firstName, String lastName, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString(){

        return String.format("%s %s %s", firstName, lastName, course);
    }
}
