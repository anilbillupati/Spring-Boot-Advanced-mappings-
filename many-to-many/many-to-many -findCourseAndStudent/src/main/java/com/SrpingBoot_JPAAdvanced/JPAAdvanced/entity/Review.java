package com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="review")
public class Review {

    // create the fields
    //add annotations to the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name ="comment")
    private String comment;


   // constructors
    public Review(){

    }

    public Review(String comment) {
        this.comment = comment;
    }
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // adding the consistency


    //to string


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
