package dev.benew.infomining_ref_kotlin.dto.symptom

class SymptomResponse {
    var symptom_id: String? = null // symptom identifier
    var symptom_content: String? = null // symptom content

    override fun toString(): String {
        return "SymptomResponse(symptom_id=$symptom_id, symptom_content=$symptom_content)"
    }
}