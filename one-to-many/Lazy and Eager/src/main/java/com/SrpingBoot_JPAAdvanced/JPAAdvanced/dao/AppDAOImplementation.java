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
    @Transactional
    public void deleteById(int theId) {
        //define the instructor
        Instructor newInstructor =entityManager.find(Instructor.class,theId);
        entityManager.remove(newInstructor);

        //delete the instructor id
    }

    @Override
    public InstructorDetails findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetails.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetails tempInstructorDetails=entityManager.find(InstructorDetails.class,theId);

        tempInstructorDetails.getInstructor().setInstructorDetails(null);

        entityManager.remove(tempInstructorDetails);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
          //create a query

        TypedQuery<Course> query =entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",theId);
        //execute the query
        List<Course> courseList=query.getResultList();

        // get the instructor courses by using the get method
        return courseList;
    }

    @Override
    public Instructor findInstructorJoinFetch(int theId) {
        TypedQuery<Instructor>  query= entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetails where i.id= :data",Instructor.class);
        query.setParameter("data",theId);
        Instructor tempInstructor=query.getSingleResult();
        return tempInstructor;

    };


}