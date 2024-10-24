package com.example.featureflag.change_repository_example.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SuppressWarnings({"unused", "java:S1171", "java:S112", "java:S3599"})
@Configuration
public class JacksonMapper {

    private JacksonMapper() {
        //construtor privado para não permitir instanciar a classe
    }

    public static final ObjectMapper objectMapper = new ObjectMapper() {{
        registerModule(new JavaTimeModule());
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        SimpleModule simpleModule = new SimpleModule();
        registerModule(simpleModule);
    }};

    @Bean
    public ObjectMapper updateBean() {
        return objectMapper;
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException("Error toJson object in JacksonMapper. ex: " + ex.getMessage());
        }
    }

    public static <T> T loadObjectsFromFile(String path, Class<T> classType) {
        try (FileReader file = new FileReader(path, StandardCharsets.UTF_8)) {
            return objectMapper.readValue(file, classType);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
