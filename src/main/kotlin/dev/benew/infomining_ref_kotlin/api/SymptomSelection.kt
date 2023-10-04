package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ResultData
import dev.benew.infomining_ref_kotlin.dto.symptom.SymptomResponse
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class SymptomSelection (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Symptom Search
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param reportId <- identifier of the report (required)
     * @param param <- search word (required)
     */
    fun symptoms(accessToken: String, languageType: String?,
                 reportId: String, param: String): ResponseEntity<ResultData<List<SymptomResponse>>> {
        log.info("SymptomSelection - symptoms")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("report_id", reportId)
        params.add("param", param)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/symptom/symptoms")
            .queryParams(params)
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        return restTemplate.exchange(
            uri,
            HttpMethod.GET,
            HttpEntity(null, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    fun MLSymptoms(accessToken: String, languageType: String?,
                   reportId: String, param: String): ResponseEntity<ResultData<List<SymptomResponse>>> {
        log.info("SymptomSelection - MLSymptoms")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("report_id", reportId)
        params.add("param", param)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/symptom/MLsymptoms")
            .queryParams(params)
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        return restTemplate.exchange(
            uri,
            HttpMethod.GET,
            HttpEntity(null, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }
}