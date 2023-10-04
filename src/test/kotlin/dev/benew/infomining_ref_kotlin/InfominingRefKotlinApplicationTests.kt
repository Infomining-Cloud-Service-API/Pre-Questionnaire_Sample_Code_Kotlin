package dev.benew.infomining_ref_kotlin

import com.fasterxml.jackson.databind.ObjectMapper
import dev.benew.infomining_ref_kotlin.api.Auth
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InfominingRefKotlinApplicationTests (
    @Autowired val auth: Auth,
    @Autowired val mapper: ObjectMapper
) {

    @Test
    fun authTest() {
        println(
            mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                auth.getToken("test", "test").body
            )
        )


    }

}
