package dev.benew.infomining_ref_kotlin.dto.step2

class Step2ReportResponse {
    var report_id: String? = null // Identifier of the report
    var step2_question_id: String? = null // Step 2 identifier of the question
    var step2_selection_id: String? = null // Step 2 identifier of the selection
    var step2_input_text: String? = null // if Subjective Answer, response content
    var step2_branch_bool: String? = null // Whether of scenario questions
    var step2_reg_date: String? = null // response date

    override fun toString(): String {
        return "Step2ReportResponse(report_id=$report_id, step2_question_id=$step2_question_id, step2_selection_id=$step2_selection_id, step2_input_text=$step2_input_text, step2_branch_bool=$step2_branch_bool, step2_reg_date=$step2_reg_date)"
    }
}