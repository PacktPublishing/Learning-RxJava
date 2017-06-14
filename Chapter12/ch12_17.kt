 import io.reactivex.Observable
 import io.reactivex.rxkotlin.subscribeBy

 fun main(args: Array<String>) {

     Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
             .count()
             .subscribeBy { println("There are $it items") }
 }