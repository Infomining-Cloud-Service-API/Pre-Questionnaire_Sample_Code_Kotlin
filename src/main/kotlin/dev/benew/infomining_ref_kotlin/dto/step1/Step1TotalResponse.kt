package dev.benew.infomining_ref_kotlin.dto.step1

class Step1TotalResponse {
    var step1_question_info: Step1QuestionResponse? = null
    var step1_selection_list: List<Step1SelectionResponse>? = null

    override fun toString(): String {
        return "Step1TotalResponse(step1_question_info=$step1_question_info, step1_selection_list=$step1_selection_list)"
    }
}