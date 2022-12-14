package bachelor.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;

@EnableJpaRepositories
@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {

        SpringApplication.run(CompanyApplication.class, args);
    }

}
