package dev.benew.infomining_ref_kotlin.api

import dev.benew.infomining_ref_kotlin.dto.ResultData
import dev.benew.infomining_ref_kotlin.dto.report.ReportResponse
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
class GetReport (
    val restTemplate: RestTemplate
) {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val baseUrl = "https://api.infomining-dev.com/rest_api"

    /**
     * @apiNote
     *   Full Report Summary
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param reportType <- type of report(report, question) (required)
     */
    fun getSummaryReportInfo(accessToken: String,
                             reportId: String, reportType: String): ResponseEntity<ResultData<List<ReportResponse>>> {
        log.info("GetReport - getSummaryReportInfo")

        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("report_type", reportType)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/get_summary_report_info")
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
     *   Full Report Summary
     *
     * @param accessToken <- Your_Access_Token (required)
     * @param reportId <- identifier of the report (required)
     * @param reportType <- type of report(report, question) (required)
     */
    fun getSummaryReportStorageInfo(accessToken: String,
                                    reportId: String, reportType: String): ResponseEntity<ResultData<List<ReportResponse>>> {
        log.info("GetReport - getSummaryReportStorageInfo")

        val params = LinkedMultiValueMap<String, String>()
        params.add("report_id", reportId)
        params.add("report_type", reportType)

        val uri = UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/v1/report/get_summary_report_storage_info")
            .queryParams(params)
            .encode().build().toUri()
        log.info("uri:$uri")

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