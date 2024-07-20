package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findByInstructorId(int theId);
    void deleteById(int theId);
    InstructorDetails findInstructorDetailById(int theId);
    void deleteInstructorDetailsById(int theId);

}
