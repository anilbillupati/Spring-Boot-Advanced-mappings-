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
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetails(appDAO);

			//createCoursesInstructor(appDAO);
			//findInstructorWithCourse(appDAO);
			
			//findCoursesForInstructor(appDAO);
			findInstructorwithcourseJoinFetch(appDAO);


		};
	}

	private void findInstructorwithcourseJoinFetch(AppDAO appDAO) {

		// need to get the instructor based on the id first
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorJoinFetch(theId);

		System.out.println("printing the details of the instructor  "+tempInstructor);
		System.out.println("printing the details of the instructor  "+tempInstructor.getCourses());

		//then get the data from courses
		System.out.println("hurray!!!!!!!!!!  completed ");



	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor= appDAO.findByInstructorId(theId);
		System.out.println("the details of instructor is "+tempInstructor);

		List<Course> courses=appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("the courses of instructor are :"+tempInstructor.getCourses());

		System.out.println("hurray!!!!!!!!!!  completed ");

	}

	private void findInstructorWithCourse(AppDAO appDAO) {

		int theId=1;
		Instructor tempInstructor= appDAO.findByInstructorId(theId);
		System.out.println("the details of instructor is "+tempInstructor);
		System.out.println("the courses of instructor are :"+tempInstructor.getCourses());
		System.out.println("hurray!!!!!!!!!!  completed ");
	}

	private void createCoursesInstructor(AppDAO appDAO) {
		//define the instructor
		Instructor tempInstructor= new Instructor("Raj","Vikramaditya","rv@gmail.com");
		//define the instructor details
		InstructorDetails tempInstructorDetails=new InstructorDetails("takeyouforaward","Teaching,coding");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		//adding the courses
		Course tempCourse1=new Course("DSA");
		Course tempCourse2=new Course("ProblemSolving");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		// saving the instructor
		System.out.println("Get the instructor details"+tempInstructor);
		System.out.println("courses taught by instructor are :"+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("hurray completed !!!!!!!!");


	}

	private void deleteInstructorDetails(AppDAO appDAO) {
		int theId=6;
		System.out.println("the deleted instructor details are :"+theId);
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("hurray completed !!!!!!!!");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		// find the instructor detail
		int theId=3;
		InstructorDetails tempInstructorDetails=appDAO.findInstructorDetailById(theId);

		//print the instructor details
		System.out.println("the isntructor details are :"+tempInstructorDetails);

		//print the instructor
		System.out.println("the details of the instructor using the instructor details are "+tempInstructorDetails.getInstructor());
		System.out.println("hurray completed !!!!!!!!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("it is deleted"+theId);
		appDAO.deleteById(theId);
	}

	private void findInstructor(AppDAO appDAO) {

		int theId=2;
		Instructor tempInstructor= appDAO.findByInstructorId(theId);
		System.out.println("the Instructor with id 1 is "+tempInstructor);
		System.out.println("the instuctor details are:"+tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDAO appDAO) {

		//define the instructor
		Instructor tempInstructor= new Instructor("Samar","Kandala","sk@gmail.com");
		//define the instructor details
		InstructorDetails tempInstructorDetails=new InstructorDetails("Tech architect","Teaching, studying ,coding");
		// to add the connection
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		System.out.println("Saving the instructor :"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("completed");
	}
}
