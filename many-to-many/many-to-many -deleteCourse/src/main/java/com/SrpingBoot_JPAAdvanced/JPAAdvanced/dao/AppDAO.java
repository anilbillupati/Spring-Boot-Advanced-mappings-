package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Student;

import java.util.List;

public interface AppDAO {


    void save(Course theCourse);

    Student findStudentAndCourseByStudentId(int theId);

    void updateStudent(Student tempStudent);
    void deleteCourseById(int theId);

}
