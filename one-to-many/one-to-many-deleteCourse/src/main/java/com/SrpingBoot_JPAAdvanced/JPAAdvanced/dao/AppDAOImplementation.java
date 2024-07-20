package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.TypeDescriptor;
import java.util.List;

@Repository
public class AppDAOImplementation implements  AppDAO{

    //define the entity manager
    private EntityManager entityManager;

    //inject entity manager using the CI
    @Autowired
    public AppDAOImplementation(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findByInstructorId(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    public Course findCourseByID(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse=entityManager.find(Course.class,theId);
        entityManager.remove(tempCourse);

    }


}
