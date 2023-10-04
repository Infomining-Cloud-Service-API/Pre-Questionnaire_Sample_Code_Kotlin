package dev.benew.infomining_ref_kotlin.dto.step3

class Step3FollowUpResponse {
    var step3_follow_up_id: String? = null // Step3 Additional Question Identifiers for Questions
    var step3_follow_up_content: String? = null // Step3 Additional Question content for Questions
    var step3_follow_up_guide: String? = null // Step3 Additional Question guide for Questions
    var step3_follow_up_report_type: String? = null // Step3 Additional Question report type for Questions
    var step3_follow_up_answer_type: String? = null // // Step3 Additional Question answer type for Questions (follow up is only Subjective)

    override fun toString(): String {
        return "Step3FollowUpResponse(step3_follow_up_id=$step3_follow_up_id, step3_follow_up_content=$step3_follow_up_content, step3_follow_up_guide=$step3_follow_up_guide, step3_follow_up_report_type=$step3_follow_up_report_type, step3_follow_up_answer_type=$step3_follow_up_answer_type)"
    }
}