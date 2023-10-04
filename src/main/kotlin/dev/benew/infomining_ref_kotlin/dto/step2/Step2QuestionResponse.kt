package dev.benew.infomining_ref_kotlin.dto.step2

class Step2QuestionResponse {
    var step2_question_id: String? = null // Step 2 identifier of the question
    var step2_question_content: String? = null // Step 2 content of the question
    var step2_guide: String? = null // Step 2 guide of the question
    var step2_report_type: String? = null // Step 2 Reporting Category for Questions
    var step2_answer_type: String? = null // QuestionType ex) Subjective, Objective
    var step2_max_selection_count: String? = null // Maximum number of choices for optional questions
    var step2_branch_bool: String? = null // Whether of scenario questions

    var step2_img_array: List<String>? = null // Step2 Sample image list when image type question

    override fun toString(): String {
        return "Step2QuestionResponse(step2_question_id=$step2_question_id, step2_question_content=$step2_question_content, step2_guide=$step2_guide, step2_report_type=$step2_report_type, step2_answer_type=$step2_answer_type, step2_max_selection_count=$step2_max_selection_count, step2_branch_bool=$step2_branch_bool, step2_img_array=$step2_img_array)"
    }
}