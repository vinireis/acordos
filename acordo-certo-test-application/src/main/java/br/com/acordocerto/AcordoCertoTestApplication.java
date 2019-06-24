package br.com.acordocerto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vinicius.reis
 */
@SpringBootApplication
@EnableSwagger2
public class AcordoCertoTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcordoCertoTestApplication.class, args);
    }
}
