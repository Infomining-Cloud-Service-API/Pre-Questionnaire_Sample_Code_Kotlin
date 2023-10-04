package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ResultData
import dev.benew.infomining_ref_kotlin.dto.StatusResponse
import dev.benew.infomining_ref_kotlin.dto.step2.Step2DepartmentsResponse
import dev.benew.infomining_ref_kotlin.dto.step2.Step2QuestionResponse
import dev.benew.infomining_ref_kotlin.dto.step2.Step2ReportResponse
import dev.benew.infomining_ref_kotlin.dto.step2.Step2TotalResponse
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
 *  #3
 * Step2Scenario
 */
@Component
class Step2Scenario (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Step2 Save Symptom Selection Report
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param symptomId <- identifier of the symptom (required)
     */
    fun symptomSelection(accessToken: String,
                         reportId: String, symptomId: String): ResponseEntity<ResultData<StatusResponse>> {
        log.info("Step2 - symptomSelection")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step2/symptomSelect")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("symptom_id", symptomId)

        return restTemplate.exchange(
            uri,
            HttpMethod.POST,
            HttpEntity(params, headers),
            ParameterizedTypeReference.forType(ResultData::class.java)
        )
    }

    /**
     * @apiNote
     *   a list of medical departments by report
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param reportId <- identifier of the report (required)
     */
    fun departments(accessToken: String, languageType: String?,
                    reportId: String): ResponseEntity<ResultData<Step2DepartmentsResponse>> {
        log.info("Step2 - departments")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("report_id", reportId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step2/departments")
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
     *   Step2 Question List by Symptom
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param symptomId <- identifier of the symptom (required)
     */
    fun questions(accessToken: String, languageType: String?,
                  symptomId: String): ResponseEntity<ResultData<List<Step2QuestionResponse>>> {
        log.info("Step2 - questions")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("symptom_id", symptomId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step2/questions")
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
     *   Step 2 List of options for the question
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param questionId <- Step2 identifier of the question (required)
     * @param reportId <- identifier of the report (required)
     */
    fun question(accessToken: String, languageType: String?,
                 questionId: String, reportId: String): ResponseEntity<ResultData<Step2TotalResponse>> {
        log.info("Step2 - question")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("question_id", questionId)
        params.add("report_id", reportId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step2/question")
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
     *   Step2 Question Information by Branch Question Selection
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param languageType <- ex) kr, en (optional)
     * @param selectionId <- Step2 identifier of the selection (required)
     */
    fun branchQuestion(accessToken: String, languageType: String?,
                       selectionId: String): ResponseEntity<ResultData<Step2QuestionResponse>> {
        log.info("Step2 - branchQuestion")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        languageType?.let { params.add("language_type", it) }
        params.add("selection_id", selectionId)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/step2/branchQuestion")
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
     *   Step2 Save Report
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param questionId <- Step2 identifier of the question (required)
     * @param selectionId <- Step2 identifier of the selection (optional)
     * @param inputTxt <- Step2 answer to a question(Subjective) (optional)
     * @param questionType <- objective, subjective (required)
     */
    fun saveStep2Report(accessToken: String, reportId: String, questionId: String, selectionId: String?, inputTxt: String?, questionType: String): ResponseEntity<ResultData<StatusResponse>> {
        log.info("Step2 - saveStep2Report")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step2/saveReport")
            .encode().build().toUri()
        log.info("uri:$uri")

        /** header **/
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $accessToken")

        /** parameter **/
        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("question_id", questionId)
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
     *   Step 2 of the report Question and answer information
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     */
    fun step2History(accessToken: String,
                     reportId: String): ResponseEntity<ResultData<List<Step2ReportResponse>>> {
        log.info("Step2 - step2History")

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/step2/history")
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