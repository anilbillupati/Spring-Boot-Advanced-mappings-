package com.SrpingBoot_JPAAdvanced.JPAAdvanced;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao.AppDAO;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Course;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Review;
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
			createCourse(appDAO);


		};
	}

	private void createCourse(AppDAO appDAO) {

		//create course
		 Course tempCourse= new Course("pubg");
		//create the review
		tempCourse.addReviews(new Review("good"));
		tempCourse.addReviews(new Review("Average"));
		tempCourse.addReviews(new Review("Best "));
		tempCourse.addReviews(new Review("i liked it very much "));
		tempCourse.addReviews(new Review("Worst i have ever purchased"));
		tempCourse.addReviews(new Review("better course in the market"));
		//save the course
		appDAO.save(tempCourse);
		System.out.println("hurray Completed it");
	}


}
