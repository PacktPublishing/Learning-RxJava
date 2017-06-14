import io.reactivex.Observable

 fun main(args: Array<String>) {

     val strings = Observable.just("Alpha", "Beta", "Gamma",
     "Delta")
     val numbers = Observable.range(1,4)

     //compile error, can't infer parameters
     val zipped = Observable.zip(strings, numbers) { s,n -> "$s $n" }

     zipped.subscribe(::println)
 }