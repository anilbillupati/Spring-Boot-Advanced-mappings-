package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImplementation implements AppDAO {

    //define the entity manager
    private EntityManager entityManager;

    //inject entity manager using the CI
    @Autowired
    public AppDAOImplementation(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findByInstructorId(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        //define the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        //break the bond between the courses and instructor bcz the courses foreign key points to the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null); // to break the connection between the course and the instructor
        }
        //delete the instructor id
        entityManager.remove(tempInstructor);
    }
}
