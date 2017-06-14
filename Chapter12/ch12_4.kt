 import io.reactivex.Observable

 fun main(args: Array<String>) {

     Observable.just("Alpha", "Beta", "Gama", "Delta", "Epsilon")
             .map { s: String -> s.length }
             .subscribe { i: Int -> println(i) }
 }