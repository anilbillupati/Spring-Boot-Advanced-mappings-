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

            //retriveCourseAndReviews(appDAO);

			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("the id of deleted course is "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("hurray Deleted the course and reviews !!!! ");

	}

	private void retriveCourseAndReviews(AppDAO appDAO) {

		// get the course and review
         	int theId=10;
			Course tempCourse= appDAO.reviewsRetrieve(theId);
		//print the course

		System.out.println("the course details are:"+tempCourse);
	//print the reviews
		System.out.println("The reviews about the courses are:"+tempCourse.getReviews());
		System.out.println("hurray completed");
	}


}
