package dev.benew.infomining_ref_kotlin.dto.step1

class Step1QuestionResponse {
    var step1_question_id: String? = null // Step 1 identifier of the question
    var step1_question_content: String? = null // Step 1 content of the question
    var step1_guide: String? = null // Step 1 guide of the question
    var step1_report_type: String? = null // Step 1 Reporting Category for Questions
    var step1_answer_type: String? = null // QuestionType ex) Subjective, Objective
    var step1_max_selection_count: String? = null // Maximum number of choices for optional questions

    override fun toString(): String {
        return "Step1QuestionResponse(step1_question_id=$step1_question_id, step1_question_content=$step1_question_content, step1_guide=$step1_guide, step1_report_type=$step1_report_type, step1_answer_type=$step1_answer_type, step1_max_selection_count=$step1_max_selection_count)"
    }
}