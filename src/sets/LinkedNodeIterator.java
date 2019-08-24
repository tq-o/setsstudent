package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
    // TODO (1) define data variables
  public LinkedNode<E> iter;
  // Constructors
  public LinkedNodeIterator(LinkedNode<E> head) {
      // TODO (2) choose appropriate parameters and do the initialization
	  iter = head;
  }

  @Override
  public boolean hasNext() {
    // TODO (3)

	  return (iter!=null);
  }

  @Override
  public E next() {
    // TODO (4)
	if (!hasNext())
		throw new NoSuchElementException();
	E i = iter.getData();
	iter = iter.getNext();
	return i;
  }

  @Override
  public void remove() {
    // Nothing to change for this method
    throw new UnsupportedOperationException();
  }
}
