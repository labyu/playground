package me.labyu.springddd.rdbms;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"me.labyu.springddd.rdbms"})
@EnableJpaAuditing
public class JpaConfig {
}
