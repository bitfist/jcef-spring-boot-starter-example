package io.github.bitfist.jcef.spring.example;

import com.zaxxer.hikari.HikariDataSource;
import io.github.bitfist.jcef.spring.application.JcefApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ExampleApplication {

    @Bean
    @ConditionalOnMissingBean
    DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:sqlite:app.db");
        dataSource.setReadOnly(false);
        dataSource.setDriverClassName("org.sqlite.JDBC");
        return dataSource;
    }

    public static void main(String[] args) {
        JcefApplication.run(ExampleApplication.class, args);
    }
}
