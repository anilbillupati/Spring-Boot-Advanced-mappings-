package com.SrpingBoot_JPAAdvanced.JPAAdvanced;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao.AppDAO;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.Instructor;
import com.SrpingBoot_JPAAdvanced.JPAAdvanced.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructorDetails(appDAO);
		};
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
