package me.nkozlov.kotlin.alice

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [me.nkozlov.alice.irrverbs.AliceIrregularVerbsApplication::class])
class AliceIrregularVerbsApplicationTests {

    @Test
    fun contextLoads() {
    }

}
