package com.example.demo;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

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
        dataSource.setURL(applicationProperties.getProperty("database_url"));
        if (System.getProperty("database_port") != null) {
            System.out.println("database port jvm param detected " + System.getProperty("database_port") +
                    " and it will override one from app properties");
            dataSource.setPort(Integer.valueOf(System.getProperty("database_port")));
        }
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

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.demo.dao.orm");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
