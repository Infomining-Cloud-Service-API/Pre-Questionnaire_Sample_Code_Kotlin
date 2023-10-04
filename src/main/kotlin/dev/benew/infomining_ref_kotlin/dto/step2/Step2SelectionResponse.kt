package dev.benew.infomining_ref_kotlin.dto.step2

class Step2SelectionResponse {
    var step2_selection_id: String? = null // Step2 identifier of the selection
    var step2_selection_content: String? = null // Step2 content of the selection

    override fun toString(): String {
        return "Step2SelectionResponse(step2_selection_id=$step2_selection_id, step2_selection_content=$step2_selection_content)"
    }
}