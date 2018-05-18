package cn.hff;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class UniversityTrackApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityTrackApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("source args:" + Arrays.asList(args.getSourceArgs()));
        System.out.println("option name" + args.getOptionNames());
    }
}
