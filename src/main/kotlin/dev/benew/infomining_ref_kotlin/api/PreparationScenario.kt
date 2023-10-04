package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ReportIdResponse
import dev.benew.infomining_ref_kotlin.dto.ResultData
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

/**
 *  #1
 * Preparation Scenario
 */
@Component
class PreparationScenario (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Generating a report
     *
     * @param accessToken <- Your_Access_Token (required)
     */
    fun reportStart(accessToken: String): ResponseEntity<ResultData<ReportIdResponse>> {
        log.info("PreparationScenario - reportStart")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/reportStart")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(null, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   Step1 Save the report (enter at once)
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param userName <- (required)
     * @param userGender <- (M:Male, F:Female) (required)
     * @param userAge <- (required)
     * @param userPregnant <- Pregnancy status of user (preg:pregnant, null:not pregnant) (F <- required, M <- optional)
     * @param userHeight <- (optional)
     * @param userWeight <- (optional)
     * @param userJob <- (optional)
     * @param userReligion <- (optional)
     */
    fun saveReportTotal(accessToken: String,
                        userName: String, userGender: String, userAge: String,
                        userPregnant: String?, userHeight: String?, userWeight: String?, userJob: String?, userReligion: String?): ResponseEntity<ResultData<ReportIdResponse>> {
        log.info("PreparationScenario- saveReportTotal")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step1/saveReportTotal")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header, parameter **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        val params = LinkedMultiValueMap<String, String>()
        params.add("user_name", userName)
        params.add("user_gender", userGender)
        params.add("user_age", userAge)
        userPregnant?.let { params.add("user_pregnant", it) }
        userHeight?.let { params.add("user_height", it) }
        userWeight?.let { params.add("user_weight", it) }
        userJob?.let { params.add("user_job", it) }
        userReligion?.let { params.add("user_religion", it) }

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

}