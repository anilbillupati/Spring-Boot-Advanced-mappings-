package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Student;
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

    public AppDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }



    @Override
    public Student findStudentAndCourseByStudentId(int theId) {

        TypedQuery<Student> query=entityManager.createQuery("select s from Student s JOIN FETCH s.courses where s.id=:data ",Student.class);
        query.setParameter("data",theId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student tempStudent) {

        entityManager.merge(tempStudent);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course temCourse=entityManager.find(Course.class,theId);

        entityManager.remove(temCourse);
    };
}
