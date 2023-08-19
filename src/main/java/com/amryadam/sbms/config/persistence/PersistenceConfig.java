package com.amryadam.sbms.config.persistence;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.logging.log4j2.SpringBootPropertySource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sbmsEntityManagerFactory", transactionManagerRef = "sbmsTransactionManager",
        basePackages = {"com.amryadam.sbms.repository"})
public class PersistenceConfig {



    private final DataSourceProperties dataSourceProperties;

    public PersistenceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "HikariDataSource")
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        config.setUsername(dataSourceProperties.getUserName());
        config.setPassword(dataSourceProperties.getPassword());
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        // For SQl Server
        props.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
//        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        props.put("hibernate.default_schema", dataSourceProperties.getHibernateDefaultSchema());
        props.put("hibernate.hbm2ddl.auto",dataSourceProperties.getHibernateDdlAuto());
        return props;
    }

    @Bean(name = "sbmsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("HikariDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.amryadam.sbms.models")
                .properties(jpaProperties())
                .build();
    }


    @Bean(name = "sbmsTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("sbmsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
