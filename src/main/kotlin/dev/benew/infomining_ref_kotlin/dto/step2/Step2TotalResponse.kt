package dev.benew.infomining_ref_kotlin.dto.step2

class Step2TotalResponse {
    var step2_question_info: Step2QuestionResponse? = null
    var step2_selection_list: List<Step2SelectionResponse>? = null

    override fun toString(): String {
        return "Step2TotalResponse(step2_question_info=$step2_question_info, step2_selection_list=$step2_selection_list)"
    }
}