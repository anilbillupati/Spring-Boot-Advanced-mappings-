package com.SrpingBoot_JPAAdvanced.JPAAdvanced;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao.AppDAO;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}
     @Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{


			  updateInstructor(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=4;

		//get the Instructor by id
		Instructor tempInstructor=appDAO.findByInstructorId(theId);
		//updating the value
		tempInstructor.setFirstName("Billupati");

		appDAO.updateInstructor(tempInstructor);

		System.out.println("Hurray Completed!!!!");
	}


}
