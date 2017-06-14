import io.reactivex.Observable

 fun main(args: Array<String>) {

     val source = Observable.just(100, 50, 250, 150)

     val total = source.sum()
 }

 fun Observable<Int>.sum() =
       reduce(0) { total, next -> total + next }