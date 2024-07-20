package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

}
