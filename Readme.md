## Errata 
 * Page 36 (lin no 7):  
 **The output does not change:
Observer 1: Alpha
Observer 1: Beta
Observer 1: Gamma
Observer 2: Alpha
Observer 2: Beta
Observer 2: Gamma**
 _should be_ 
**The output looks as follows:
Observer 1: Alpha
Observer 1: Beta
Observer 1: Gamma
Observer 2: 5
Observer 2: 5**

* Page 56:

  _A given Maybe<T> will only emit 0 or 1 emissions. It will pass the possible emission to onSuccess(), and in either case, it willl call onComplete() when done. Maybe.just() can be used to create a Maybe emitting the single item. Maybe.empty() will create a Maybe that yields no emission:_

  **should be**

  _A given Maybe<T> will only emit 0 or 1 emissions. If there is an emission, it will pass it to onSuccess(). Otherwise, it will call onComplete() when done. These events are mutually exclusive for Maybe, so onComplete() won’t be called after onSuccess()._
### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781787120426">https://packt.link/free-ebook/9781787120426 </a> </p>
