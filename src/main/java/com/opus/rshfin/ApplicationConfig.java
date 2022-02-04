package com.opus.rshfin;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@EnableJpaRepositories("com.opus.isotherm")
public class ApplicationConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "asvp2";
    }

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.opus.isotherm";
    }
}
