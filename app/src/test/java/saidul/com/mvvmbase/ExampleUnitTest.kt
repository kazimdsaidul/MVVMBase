package saidul.com.mvvmbase

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun rxZip(){

        val stringObservable1 = Observable.just("Hello")
        val stringObservable2 = Observable.just(arrayOf("1","2","3"))

        Observable.zip(stringObservable1, stringObservable2, object : BiFunction<String, Array<String>, String> {
            @Throws(Exception::class)
            override fun apply( s: String, s2: Array<String>): String {
                println("apply "+Thread.currentThread().name)
                return "$s - $s2"
            }
        }).observeOn(Schedulers.io())
                .subscribe(object : Consumer<String> {
            @Throws(Exception::class)
            override fun accept(s: String) {

                println("accept "+Thread.currentThread().name)
                println(s)
            }
        })


    }
}
