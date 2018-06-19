package ftn.xmlws.soap;

import com.xmlws.ftn.soap.SyncServicePortService;
import com.xmlws.ftn.soap.SyncServicePort;
import com.xmlws.ftn.soap.GetSyncRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"ftn.xmlws.soap","com.xmlws.ftn.soap", "generated.soap.com.xmlws.ftn.agent_soap"})
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
