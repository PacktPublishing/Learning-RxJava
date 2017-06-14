import io.reactivex.rxkotlin.toObservable

 fun main(args: Array<String>) {

     val myList = listOf("Alpha", "Beta", "Gamma", "Delta", 
     "Epsilon")

     myList.toObservable()
             .map(String::length)
             .subscribe(::println)
 }