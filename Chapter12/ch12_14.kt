 import io.reactivex.Observable
 import io.reactivex.functions.BiFunction

 fun main(args: Array<String>) {

     val strings = Observable.just("Alpha", "Beta", "Gamma",
     "Delta")
     val numbers = Observable.range(1,4)

     val zipped = Observable.zip(strings, numbers,
             BiFunction<String,Int,String> { s,n -> "$s $n" }
     )

     zipped.subscribe(::println)
 }