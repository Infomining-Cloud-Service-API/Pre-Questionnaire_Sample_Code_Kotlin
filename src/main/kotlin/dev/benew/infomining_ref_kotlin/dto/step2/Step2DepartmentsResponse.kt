package dev.benew.infomining_ref_kotlin.dto.step2

class Step2DepartmentsResponse {
    var departments: String? = null // Departments covered by the report

    override fun toString(): String {
        return "Step2DepartmentsResponse(departments=$departments)"
    }
}