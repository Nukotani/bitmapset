package bitmapset;
import java.util.Vector;

/**
 * BitmapSet
 *
 * A Set implemented where the subsets are implemented as bitmaps
 * This class represents the universe set
 */
public class BitmapSet<E> {
  Vector<E> elements;
  public BitmapSet(E[] elements) {
    for(E element: elements) {
      for(E VecElement: this.elements) {
        if (element == VecElement) {
          break;
        }
      }
      this.elements.add(element);
    }
  }
  /**
   * Creates a subset
   *
   * @param elements the elements of the subset
  */
  public BitmapSubset<E> createSubset(E[] elements) {
    return new BitmapSubset<E>(elements, this);
  }
}


