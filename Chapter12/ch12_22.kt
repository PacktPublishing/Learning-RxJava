 import io.reactivex.Observable
 import io.reactivex.rxkotlin.Observables

 fun main(args: Array<String>) {

     val strings = Observable.just("Alpha", "Beta", "Gamma",
     "Delta")
     val numbers = Observable.range(1,4)

     data class StringAndNumber(val myString: String, val myNumber: Int)

     Observables.zip(strings, numbers) { s, n -> StringAndNumber(s,n) }
             .subscribe {
                 println(it)
             }
 }