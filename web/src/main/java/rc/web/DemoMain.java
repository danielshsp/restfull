package rc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"rc"})
@ComponentScan(basePackages = {"rc"})

public class DemoMain {
    public static void main(String [] args){
        SpringApplication.run(DemoMain.class, args);
    }

}
