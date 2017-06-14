 import io.reactivex.Observable

 fun main(args: Array<String>) {

     Observable.just("Alpha", "Beta", "Gama", "Delta", "Epsilon")
             .map(String::length)
             .subscribe(::println)
 }