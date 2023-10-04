package dev.benew.infomining_ref_kotlin.dto.step3

class Step3SelectionResponse {
    var step3_selection_id: String? = null // Step3 identifier of the selection
    var step3_selection_is_follow_up: String? = null // status (Step3 Should I go to follow_up when the option is selected)
    var step3_selection_content: String? = null // Step3 content of the selection

    override fun toString(): String {
        return "Step3SelectionResponse(step3_selection_id=$step3_selection_id, step3_selection_is_follow_up=$step3_selection_is_follow_up, step3_selection_content=$step3_selection_content)"
    }
}