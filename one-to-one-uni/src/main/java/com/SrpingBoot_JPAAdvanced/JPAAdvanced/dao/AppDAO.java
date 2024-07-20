package com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findByInstructorId(int theId);
    void deleteById(int theId);


}
