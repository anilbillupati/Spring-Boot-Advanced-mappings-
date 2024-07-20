package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findByInstructorId(int theId);


    Instructor findInstructorJoinFetch (int theId);

    void save(Course theCourse);
    void deleteCourseById(int theId);

    Course reviewsRetrieve(int theId);


}
