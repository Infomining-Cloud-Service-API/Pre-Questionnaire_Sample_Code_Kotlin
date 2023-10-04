package dev.benew.infomining_ref_kotlin.dto.step1

class Step1SelectionResponse {
    var step1_selection_id: String? = null // Step1 identifier of the selection
    var step1_selection_content: String? = null // Step1 content of the selection
    var follow_up_id: String? = null // Identifier of the question that follows based on the choice of choice (If null, end of Step1 question)
    var step1_selection_required: String? = null // 0:Not Required    1:Required    2:Depending on your choice

    override fun toString(): String {
        return "Step1SelectionResponse(step1_selection_id=$step1_selection_id, step1_selection_content=$step1_selection_content, follow_up_id=$follow_up_id, step1_selection_required=$step1_selection_required)"
    }
}