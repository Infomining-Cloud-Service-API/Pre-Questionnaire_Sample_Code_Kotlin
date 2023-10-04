package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ResultData
import dev.benew.infomining_ref_kotlin.dto.StatusResponse
import dev.benew.infomining_ref_kotlin.dto.step3.Step3FollowUpResponse
import dev.benew.infomining_ref_kotlin.dto.step3.Step3QuestionResponse
import dev.benew.infomining_ref_kotlin.dto.step3.Step3ReportResponse
import dev.benew.infomining_ref_kotlin.dto.step3.Step3TotalResponse
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
class Step3Scenario (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Step3 Scenario Question List by Saved Answer
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param reportId <- identifier of the report (required)
     */
    fun questions(accessToken: String, languageType: String?,
                  reportId: String): ResponseEntity<ResultData<List<Step3QuestionResponse>>> {
        log.info("Step3 - questions")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("report_id", reportId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step3/questions")
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
     *   Step 3 List of options for the question
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param reportId <- identifier of the report (required)
     * @param questionId <- Step3 identifier of the question (required)
     */
    fun question(accessToken: String, languageType: String?,
                 reportId: String, questionId: String): ResponseEntity<ResultData<Step3TotalResponse>> {
        log.info("Step3 - question")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("report_id", reportId)
        params.add("question_id", questionId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step3/question")
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
     *   Step3 Additional Question Information
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param followUpId <- Step3 Additional Question Identifiers for Questions (required)
     */
    fun followUp(accessToken: String, languageType: String?,
                 followUpId: String): ResponseEntity<ResultData<Step3FollowUpResponse>> {
        log.info("Step3 - followUp")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("follow_up_id", followUpId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step3/followUp")
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
     *   Step3 Save Report
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param questionId <- Step3 identifier of the question (optional)
     * @param followupQuestionId <- Step3 identifier of the followup (optional)
     * @param selectionId <- Step3 identifier of the selection (optional)
     * @param inputTxt <- Step3 answer to a question(Subjective) (optional)
     * @param questionType <- objective, subjective (required)
     */
    fun saveStep3Report(accessToken: String,
                        reportId: String, questionId: String?, followupQuestionId: String?,
                        selectionId: String?, inputTxt: String?, questionType: String): ResponseEntity<ResultData<StatusResponse>> {
        log.info("Step3 - saveStep3Report")
        val uri = UriComponentsBuilder
            .fromUriString(baseUrl)
            .path("/v1/report/step3/saveReport")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        questionId?.let { params.add("question_id", it) }
        followupQuestionId?.let { params.add("followup_question_id", it) }
        selectionId?.let { params.add("selection_id", it) }
        inputTxt?.let { params.add("input_txt", it) }
        params.add("question_type", questionType)

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   Step 3 of the report Question and answer information
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     */
    fun step3History(accessToken: String,
                     reportId: String): ResponseEntity<ResultData<List<Step3ReportResponse>>> {
        log.info("Step3 - step3History")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step3/history")
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

    /**
     * @apiNote
     *   Last Report Summary
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     */
    fun reportEnd(accessToken: String,
                  reportId: String): ResponseEntity<ResultData<List<Step3ReportResponse>>> {
        log.info("Step3 - reportEnd")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/reportEnd")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }
}