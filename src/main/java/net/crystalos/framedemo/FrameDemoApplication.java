package net.crystalos.framedemo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class FrameDemoApplication {

    @Autowired
    @Qualifier("entityManagerFactoryPrimary")
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    @Qualifier("entityManagerFactorySecondary")
    private EntityManagerFactory secondaryEntityManagerFactory;

    @Bean(name="PrimarySessionFactory")
    public SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean(name="SecondarySessionFactory")
    public SessionFactory getSecondarySessionFactory() {
        return secondaryEntityManagerFactory.unwrap(SessionFactory.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FrameDemoApplication.class, args);
    }
/*
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]"));
        return factory;
    }*/
}
