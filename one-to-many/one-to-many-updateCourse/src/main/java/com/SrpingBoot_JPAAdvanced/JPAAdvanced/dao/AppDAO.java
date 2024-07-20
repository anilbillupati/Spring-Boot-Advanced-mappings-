package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findByInstructorId(int theId);

    void updateCourse (Course tempCourse);
    Course findCourseByID(int theId);

}
