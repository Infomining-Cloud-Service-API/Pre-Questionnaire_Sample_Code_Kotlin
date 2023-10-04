package dev.benew.infomining_ref_kotlin.dto.step3

class Step3TotalResponse {
    var step3_question_info: Step3QuestionResponse? = null
    var step3_selection_list: List<Step3SelectionResponse>? = null

    override fun toString(): String {
        return "Step3TotalResponse(step3_question_info=$step3_question_info, step3_selection_list=$step3_selection_list)"
    }
}