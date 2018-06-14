package ftn.xmlws.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SoapApplication.class);

    @Value("${INSTANCE_NO}")
    private String AGENT_INSTANCE;

    @Value("${INSTANCE_DATABASE}")
    private String DATABASE_INSTANCE;

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("***********************************************");
        logger.info("******      WEB SERVICE AGENT {}          ******", AGENT_INSTANCE);
        logger.info("******      USING DATABASE {} ******", DATABASE_INSTANCE);
        logger.info("******      AUTHOR sansajn               ******");
        logger.info("***********************************************");
    }
}
