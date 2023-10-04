package dev.benew.infomining_ref_kotlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class ObjectMapperConfig {
    @Bean
    fun objectMapper(objectMapperBuilder: Jackson2ObjectMapperBuilder): ObjectMapper {
        return objectMapperBuilder
            .modules(JavaTimeModule())
            .build()
    }
}