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
		  finsStudentAndCourse(appDAO);
		  
		  addMoreCoursesForStudent(appDAO);


		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent =appDAO.findStudentAndCourseByStudentId(theId);
		//create Course=
		Course tempCourse=new Course("Java");
		Course tempCourse2=new Course("Game Development");

		//add the Courses to the student
		tempStudent.addCourses(tempCourse);
		tempStudent.addCourses(tempCourse2);

		appDAO.updateStudent(tempStudent);
		System.out.println("Update Student completed");

	}

	private void finsStudentAndCourse(AppDAO appDAO) {

		int theId=3;
		Student tempStudent=appDAO.findStudentAndCourseByStudentId(theId);
		System.out.println("the course is "+tempStudent);
		System.out.println("the course is "+tempStudent.getCourses());
		System.out.println("Hurray Completed ");

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
}
