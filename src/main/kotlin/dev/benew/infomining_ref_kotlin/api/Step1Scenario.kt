package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ResultData
import dev.benew.infomining_ref_kotlin.dto.StatusResponse
import dev.benew.infomining_ref_kotlin.dto.step1.Step1QuestionResponse
import dev.benew.infomining_ref_kotlin.dto.step1.Step1ReportResponse
import dev.benew.infomining_ref_kotlin.dto.step1.Step1TotalResponse
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
 *  #2
 * Step1Scenario
 */
@Component
class Step1Scenario (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Step 1 Call the entire question
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     */
    fun getQuestions(accessToken: String, languageType: String?): ResponseEntity<ResultData<List<Step1QuestionResponse>>> {
        log.info("Step1 - getQuestions")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step1/questions")
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

    /**
     * @apiNote
     *   Step 1 List of options for the question
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param questionId <- step1 identifier of the question (required)
     */
    fun question(accessToken: String, languageType: String?,
                 questionId: String): ResponseEntity<ResultData<Step1TotalResponse>> {
        log.info("Step1 - getQuestion");

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("question_id", questionId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step1/question")
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

    /**
     * @apiNote
     *   Step 1 Save the report (for each question)
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param questionId <- Step1 identifier of the question (required)
     * @param selectionId <- Step1 identifier of the selection (required)
     * @param inputTxt <- Step1 선택지의 내용(주관식일 경우에만 존재) (optional)
     */
    fun saveStep1Report(accessToken: String,
                        reportId: String, questionId: String, selectionId: String, inputTxt: String?): ResponseEntity<ResultData<StatusResponse>> {
        log.info("Step1 - saveStep1Report")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step1/saveReport")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("question_id", questionId)
        params.add("selection_id", selectionId)
        inputTxt?.let { params.add("input_txt", inputTxt) }

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   Save user information in step1
     *
     * @param reportId <- identifier of the report (required)
     * @param userAge <- (required)
     * @param userHeight <- (required)
     * @param userWeight <- (required)
     */
    fun saveReportUserInfo(accessToken: String, reportId: String, userAge: Int, userHeight: Int, userWeight: Int): ResponseEntity<ResultData<StatusResponse>> {
        log.info("Step1 - saveReportUserInfo")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step1/saveReportUserInfo")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("user_age", userAge.toString())
        params.add("user_height", userHeight.toString())
        params.add("user_weight", userWeight.toString())

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   Step 1 of the report Question and answer information
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     */
    fun step1History(accessToken: String,
                     reportId: String): ResponseEntity<ResultData<List<Step1ReportResponse>>> {
        log.info("Step1 - step1History")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step1/history")
            .queryParam("report_id", reportId)
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