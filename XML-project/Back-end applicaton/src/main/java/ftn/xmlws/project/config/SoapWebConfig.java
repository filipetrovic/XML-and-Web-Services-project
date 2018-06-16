package ftn.xmlws.project.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, ApplicationConstants.CONFIG_SERVLET_REGISTRATION);
    }

    @Bean
    public XsdSchema agentSchema() {
        return new SimpleXsdSchema(new ClassPathResource(ApplicationConstants.CONFIG_SCHEMA_LOCATION));
    }

    @Bean("core")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema agentSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(agentSchema);
        definition.setLocationUri(ApplicationConstants.CONFIG_LOCATION_URI);
        definition.setPortTypeName(ApplicationConstants.CONFIG_SERVICE);
        definition.setTargetNamespace(ApplicationConstants.ENDPOINT_AGENT);
        return definition;
    }

}