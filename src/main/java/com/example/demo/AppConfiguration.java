package com.example.demo;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.Properties;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Log4j2
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean("appProperties")
    public Properties applicationProperties() {
        Resource resource = new ClassPathResource("/application.properties");
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props;
        } catch (Exception e) {
            throw new RuntimeException("Application properties not found please put " +
                    "applicattion.properties file in resources folder");
        }
    }

    @Bean
    public DataSource prodDataSource(@Qualifier("appProperties") Properties applicationProperties) {
        log.info("initializing datasource prod database...");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setPassword(applicationProperties.getProperty("database_password"));
        dataSource.setUser(applicationProperties.getProperty("database_user"));
        if(System.getProperty("database_port") != null){
            System.out.println("database port jvm param detected " + System.getProperty("database_port") +
                    " and it will override one from app properties");
            dataSource.setPort(Integer.valueOf(System.getProperty("database_port")));
        }
        dataSource.setURL(applicationProperties.getProperty("database_url"));
        return dataSource;
    }

    @Bean("emailProperties")
    public Properties emailProperties(@Qualifier("appProperties") Properties applicationProperties) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", applicationProperties.getProperty("mail.smtp.host"));
        properties.put("mail.smtp.port", applicationProperties.getProperty("mail.smtp.port"));
        properties.put("mail.smtp.starttls.enable", applicationProperties.getProperty("mail.smtp.starttls.enable"));
        properties.put("mail.smtp.auth", applicationProperties.getProperty("mail.smtp.auth"));
        properties.put("fromEmail", applicationProperties.getProperty("fromEmail"));
        properties.put("appPassword", applicationProperties.getProperty("appPassword"));
        return properties;
    }

}
