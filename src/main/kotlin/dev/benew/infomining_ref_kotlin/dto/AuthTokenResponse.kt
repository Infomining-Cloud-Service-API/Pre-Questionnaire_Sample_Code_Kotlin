package dev.benew.infomining_ref_kotlin.dto

import java.time.LocalDateTime

class AuthTokenResponse {
    var refresh_token: String? = null
    var refresh_expired: LocalDateTime? = null
    var access_token: String? = null
    var access_expired: LocalDateTime? = null

    constructor()
    constructor(
        refresh_token: String?,
        refresh_expired: LocalDateTime?,
        access_token: String?,
        access_expired: LocalDateTime?,
    ) {
        this.refresh_token = refresh_token
        this.refresh_expired = refresh_expired
        this.access_token = access_token
        this.access_expired = access_expired
    }

    override fun toString(): String {
        return "AuthTokenResponse(refresh_token=$refresh_token, refresh_expired=$refresh_expired, access_token=$access_token, access_expired=$access_expired)"
    }
}