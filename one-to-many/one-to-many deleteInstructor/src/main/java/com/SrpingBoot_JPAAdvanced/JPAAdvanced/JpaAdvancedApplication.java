package com.SrpingBoot_JPAAdvanced.JPAAdvanced;

import com.SrpingBoot_JPAAdvanced.JPAAdvanced.dao.AppDAO;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {

            deleteInstructor(appDAO);

        };
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("it is deleted" + theId);
        appDAO.deleteById(theId);
    }


}
