package org.mashup.torchlight.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "torchlight.db")
@PropertySource("classpath:/db/torchlight-db-${spring.profiles.active}.properties")
@Getter
@Setter
@ToString
public class TorchlightDBProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int maximumPoolSize;
    private int minimumIdle;
}
