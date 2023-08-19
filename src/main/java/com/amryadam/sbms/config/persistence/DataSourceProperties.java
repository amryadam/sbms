package com.amryadam.sbms.config.persistence;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "sbms.datasource",
        ignoreUnknownFields = true
)
@Component
public class DataSourceProperties {

    private String password;
    private String userName;
    private String jdbcUrl;
    private String hibernateDefaultSchema;

    public String getHibernateDdlAuto() {
        return hibernateDdlAuto;
    }

    public void setHibernateDdlAuto(String hibernateDdlAuto) {
        this.hibernateDdlAuto = hibernateDdlAuto;
    }

    private String hibernateDdlAuto;


    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getHibernateDefaultSchema() {
        return hibernateDefaultSchema;
    }

    public void setHibernateDefaultSchema(String hibernateDefaultSchema) {
        this.hibernateDefaultSchema = hibernateDefaultSchema;
    }

    public DataSourceProperties() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
