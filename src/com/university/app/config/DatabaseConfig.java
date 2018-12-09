package com.university.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

// Note: In this class you can set any settings to connect to your DB.

@Configuration
@ComponentScan(basePackages = "com.university.*")
// @PropertySource(value = {"classpath:database.properties"})
public class DatabaseConfig {

    @Autowired
    private Environment mEnv;

    @Bean
    public DataSource dataSource() {
        String jdbcDriverClassName = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3308/university?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String jdbcUserName = "root";
        String jdbcPassword = "qWeRtY21__123";

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

             Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
            ex.printStackTrace();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
