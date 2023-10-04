package dev.benew.infomining_ref_kotlin.dto.report

class ReportResponse {
    var step_idx: String? = null
    var step_type: String? = null
    var report_category: String? = null
    var report_type: String? = null
    var report_question: String? = null
    var report_text: String? = null

    override fun toString(): String {
        return "ReportResponse(step_idx=$step_idx, step_type=$step_type, report_category=$report_category, report_type=$report_type, report_question=$report_question, report_text=$report_text)"
    }
}