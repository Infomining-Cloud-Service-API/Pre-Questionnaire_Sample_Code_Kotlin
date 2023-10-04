package dev.benew.infomining_ref_kotlin.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import dev.benew.infomining_ref_kotlin.dto.AuthTokenResponse
import dev.benew.infomining_ref_kotlin.dto.ResultData
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

/**
 * Authentication API Example
 */
@Component
class Auth (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private final val baseUrl = "https://auth.infomining-cloud.com"

    /**
     * @apiNote
     *   getToken
     *
     * @param projectId     <- Your_Project_Id (required)
     * @param projectSecret <- Your_Project_Secret (required)
     */
    fun getToken(projectId: String, projectSecret: String): ResponseEntity<ResultData<AuthTokenResponse>> {
        log.info("Auth - getToken")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/auth/token")
            .encode().build().toUri()
        log.info("uri:$uri")


        val headers = HttpHeaders()
        headers.add("Project-Id", projectId)
        headers.add("Project-Secret", projectSecret)

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(null, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   getTokenByRefreshToken
     *
     * @param refreshToken <- Your_Refresh_Token (required)
     */
    fun getTokenByRefreshToken(refreshToken: String): ResponseEntity<ResultData<AuthTokenResponse>> {
        log.info("Auth - getTokenByRefreshToken");

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/auth/refresh_token")
            .encode().build().toUri()
        log.info("uri:$uri")

        val headers = HttpHeaders()
        headers.add("Refresh-Token", refreshToken)

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(null, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }





}