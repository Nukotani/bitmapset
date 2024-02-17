package bitmapset;

/**
 * BitmapSubset
 */
public class BitmapSubset<E> {
  long elements;
  BitmapSet<E> universe;
  BitmapSubset(long elements, BitmapSet<E> universe) {
    this.elements = elements;
    this.universe = universe;
  }
  BitmapSubset(E[] elements, BitmapSet<E> universe) {
    this.universe = universe;
    this.elements = 0;
    for(int i = 0; i < universe.elements.size(); i++) {
      for(E element: elements) {
        if (universe.elements.get(i) == element) {
          this.elements += 1 << i;
        }
      }
    }
  }
  //static set operations
  //TODO: implement exceptions!
  static public<E> BitmapSubset<E> union(BitmapSubset<E> a, BitmapSubset<E> b) throws Exception {
    if(a.universe == b.universe) {
      long elements = a.elements | b.elements;
      return new BitmapSubset<E>(elements, a.universe);
    }else {
      throw new Exception();
    }
  } 

  static public<E> BitmapSubset<E> intersection(BitmapSubset<E> a, BitmapSubset<E> b) throws Exception {
    if(a.universe == b.universe) {
      long elements = a.elements & b.elements;
        return new BitmapSubset<E>(elements, a.universe);
      }else {
        throw new Exception();
      }
  }

  static public<E> BitmapSubset<E> difference(BitmapSubset<E> a, BitmapSubset<E> b) throws Exception {
    if(a.universe == b.universe) {
      long elements = a.elements & ~b.elements;
        return new BitmapSubset<E>(elements, a.universe);
      }else {
        throw new Exception();
      }
  }
  static public<E> BitmapSubset<E> complement(BitmapSubset<E> a) {
    return new BitmapSubset<>(~a.elements, a.universe);
  }
}
