package dev.benew.infomining_ref_kotlin.dto.step3

class Step3ReportResponse {
    var report_id: String? = null // Identifier of the report
    var step3_question_id: String? = null // Step3 identifier of the question
    var step3_follow_up_id: String? = null // Step3 Additional Question Identifiers for Questions
    var step3_selection_id: String? = null // Step3 identifier of the selection
    var step3_input_text: String? = null // if Subjective Answer, response content
    var step3_reg_date: String? = null // response date

    override fun toString(): String {
        return "Step3ReportResponse(report_id=$report_id, step3_question_id=$step3_question_id, step3_follow_up_id=$step3_follow_up_id, step3_selection_id=$step3_selection_id, step3_input_text=$step3_input_text, step3_reg_date=$step3_reg_date)"
    }
}