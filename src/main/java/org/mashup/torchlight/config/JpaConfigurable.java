package org.mashup.torchlight.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.Properties;

public interface JpaConfigurable {

    LocalContainerEntityManagerFactoryBean entityManagerFactory();
    default Properties additionalJpaProperties(JpaProperties jpaProperties, HibernateProperties hibernateProperties) {
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl-auto", hibernateProperties.getDdlAuto());
        properties.setProperty("hibernate.dialect", jpaProperties.getDatabasePlatform());
        properties.setProperty("hibernate.physical_naming_strategy", hibernateProperties.getNaming().getPhysicalStrategy());
        properties.setProperty("hibernate.implicit_naming_strategy", hibernateProperties.getNaming().getImplicitStrategy());
        properties.setProperty("hibernate.dialect.storage_engine", "innodb");
        properties.setProperty("hibernate.connection.CharSet", "UTF-8");
        properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
        properties.setProperty("hibernate.connection.useUnicode", java.lang.Boolean.toString(true));

        return properties;
    }
}
