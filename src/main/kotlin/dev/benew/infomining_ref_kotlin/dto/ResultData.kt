package dev.benew.infomining_ref_kotlin.dto

class ResultData<e> {
    var http_status: Int? = null
    var code: String? = null
    var data: e? = null
    var message: String? = null

    override fun toString(): String {
        return "ResultData(http_status=$http_status, code=$code, data=$data, message=$message)"
    }
}