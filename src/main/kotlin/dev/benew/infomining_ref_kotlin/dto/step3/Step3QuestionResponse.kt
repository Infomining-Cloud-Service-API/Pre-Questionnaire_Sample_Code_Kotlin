package dev.benew.infomining_ref_kotlin.dto.step3

class Step3QuestionResponse {
    var step3_question_id: String? = null // Step 3 identifier of the question
    var step3_question_content: String? = null // Step 3 content of the question
    var step3_guide: String? = null // Step 3 guide of the question
    var step3_report_type: String? = null // Step 3 Reporting Category for Questions
    var step3_answer_type: String? = null // QuestionType ex) Subjective, Objective
    var step3_max_selection_count: String? = null // Maximum number of choices for optional questions
    var step3_follow_up_id: String? = null // Step3 Additional Question Identifiers for Questions

    override fun toString(): String {
        return "Step3QuestionResponse(step3_question_id=$step3_question_id, step3_question_content=$step3_question_content, step3_guide=$step3_guide, step3_report_type=$step3_report_type, step3_answer_type=$step3_answer_type, step3_max_selection_count=$step3_max_selection_count, step3_follow_up_id=$step3_follow_up_id)"
    }
}