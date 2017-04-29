package com.whatdy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//命令行启动
//需要使用maven run进行启动
//@SpringBootApplication
//@EnableSwagger2
//@ComponentScan(basePackages = "com.whatdy")
public class ApplicationCommandLineRunner  implements CommandLineRunner{
    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length>0 && arg0[0].equals("exitcode")) {
            throw  new ExitException();
        }
    }
    public static void main(String[] args) throws Exception {
        new SpringApplication(Application.class).run(args);
    }
    class ExitException extends RuntimeException implements ExitCodeGenerator{

        private static final long serialVersionUID = 1L;
        @Override
        public int getExitCode() {
            return 10;
        }
    }
}
