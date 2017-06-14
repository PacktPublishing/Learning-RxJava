import io.reactivex.Observable
 import io.reactivex.rxkotlin.Observables

 fun main(args: Array<String>) {

     val strings = Observable.just("Alpha", "Beta", "Gamma",
     "Delta")
     val numbers = Observable.range(1,4)

     //Emits Pair<String,Int>
     Observables.zip(strings, numbers) { s, n -> s to n }
             .subscribe {
                 println(it)
             }
 }