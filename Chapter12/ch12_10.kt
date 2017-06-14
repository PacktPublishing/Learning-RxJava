import io.reactivex.Observable

 fun main(args: Array<String>) {

     val source = Observable.just("Alpha", "Beta", "Gama", "Delta",
    "Epsilon")

     val asSet = source.toSet()

 }

 fun <T> Observable<T>.toSet() =
         collect({ HashSet<T>() }, { set, next -> set.add(next) })
         .map { it as Set<T> }