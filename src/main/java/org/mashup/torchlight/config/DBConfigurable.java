package org.mashup.torchlight.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mashup.torchlight.config.properties.TorchlightDBProperties;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public interface DBConfigurable {

    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory);
    default DataSource configureDataSource(TorchlightDBProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setConnectionTestQuery("SELECT 1");
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setMaximumPoolSize(properties.getMaximumPoolSize());
        dataSource.setMinimumIdle(properties.getMinimumIdle());

        dataSource.addDataSourceProperty("cachePrepStmts", "true");
        dataSource.addDataSourceProperty("prepStmtCacheSize", "250");
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return dataSource;
    }
}
