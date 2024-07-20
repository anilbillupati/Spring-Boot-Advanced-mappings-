package com.SrpingBoot_JPAAdvanced.JPAAdvanced;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao.AppDAO;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.*;
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

                createCourseAndStudent(appDAO);

		};
	}

	private void createCourseAndStudent(AppDAO appDAO) {

		//create Courses
		Course tempCourse= new Course("DSA");
		// create students
		Student tempStudent= new Student("anil","billupati","billupatianil@gmail.com");
		Student tempStudent2= new Student("sunil","b","sb@gmail.com");
		Student tempStudent3= new Student("Hussain","sk","sk@gmail.com");
		Student tempStudent4= new Student("pavan","venkatesh","pv@gmail.com");
		Student tempStudent5= new Student("saraswatthi","g","gs@gmail.com");


		//save the Students with courses

		tempCourse.addStudent(tempStudent);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);
		tempCourse.addStudent(tempStudent4);
		tempCourse.addStudent(tempStudent5);

		//now saving the courses that are associated with the Students
		System.out.println("the Course is "+tempCourse);
		System.out.println("No of students enrolled are: "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Hurray Completed ");
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
