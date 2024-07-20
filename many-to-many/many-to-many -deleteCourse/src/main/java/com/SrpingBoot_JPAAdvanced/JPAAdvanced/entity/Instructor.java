package com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name="id")

    private int id;
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    //making the relation with the instructor details table

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails instructorDetails;

    public Instructor(){

    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
    }


    //adding the course relation mapping with the instructor
    //many courses have same instructor many is courses and one is instructor

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor",cascade = {CascadeType.DETACH,CascadeType.MERGE,
                                                  CascadeType.PERSIST,CascadeType.REFRESH,})
    private List<Course> courses;


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    // adding the convenience method to it
    // adding the courses to the list
    public void add(Course tempCourses){
        if(courses ==null) {
            courses=new ArrayList<>();
        }
        courses.add(tempCourses);
        tempCourses.setInstructor(this);
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetails=" + instructorDetails +
                '}';
    }



}
