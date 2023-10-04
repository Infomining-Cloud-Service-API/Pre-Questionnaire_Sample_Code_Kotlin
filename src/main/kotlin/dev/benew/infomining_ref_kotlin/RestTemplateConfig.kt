package dev.benew.infomining_ref_kotlin

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {
    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder
            .requestFactory { HttpComponentsClientHttpRequestFactory() }
            .errorHandler(object : DefaultResponseErrorHandler() {
                override fun hasError(response: ClientHttpResponse): Boolean {
                    val httpStatus = response.statusCode
                    return httpStatus.series() == HttpStatus.Series.SERVER_ERROR
                }
            }).build()
    }
}