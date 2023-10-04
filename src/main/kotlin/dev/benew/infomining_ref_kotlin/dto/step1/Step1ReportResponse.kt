package dev.benew.infomining_ref_kotlin.dto.step1

class Step1ReportResponse {
    var report_id: String? = null // Identifier of the report
    var step1_question_id: String? = null // Step2 identifier of the question
    var step1_selection_id: String? = null // Step2 identifier of the selection
    var step1_input_text: String? = null // if Subjective Answer, response content
    var step1_reg_date: String? = null // response date

    override fun toString(): String {
        return "Step1ReportResponse(report_id=$report_id, step1_question_id=$step1_question_id, step1_selection_id=$step1_selection_id, step1_input_text=$step1_input_text, step1_reg_date=$step1_reg_date)"
    }
}