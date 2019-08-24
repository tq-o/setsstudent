package sets;

import java.util.Iterator;

/**
 * A LinkedList-based implementation of Set
 */

  /********************************************************
   * NOTE: Before you start, check the Set interface in
   * Set.java for detailed description of each method.
   *******************************************************/
  
  /********************************************************
   * NOTE: for this project you must use linked lists
   * implemented by yourself. You are NOT ALLOWED to use
   * Java arrays of any type, or any Collection-based class 
   * such as ArrayList, Vector etc. You will receive a 0
   * if you use any of them.
   *******************************************************/ 

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary,
   * but do NOT add new files (as they will be ignored).
   *******************************************************/

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;

  // Constructors
  public LinkedSet() {
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
    // TODO (1)
	  int size = 0;
	  //LinkedNodeIterator<E> ite =  new LinkedNodeIterator<E> (head); 
	  //Is this needed?
	  /*LinkedSet<E> ite = new LinkedSet<E>(head);
	  Iterator<E> iter = ite.iterator();
	  while (iter.hasNext()) {
		  E e = iter.next();
		  if (e!=null) size++; }*/
	  LinkedSet<E> ite = new LinkedSet<E>(head);
	  for (E i: ite) size++;
	  
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
	  //LinkedSet<E> ite = new LinkedSet<E>(head);
	  //LinkedNodeIterator<E> ite = new LinkedNodeIterator<E>(head);
	  if (size() == 0) return true;
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	  LinkedSet<E> ite = new LinkedSet<E>(head);
	  for (E i: ite) 
		  if(i.equals(o)) return true;
    return false;
  }

  
  public int size(Set<E> that) {
	  int size = 0;
	  
	  return size;
  }
  @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	  int total = 0;
	  //LinkedSet<E> ite = new LinkedSet<E>(that);
	  //if (!isSubset(that)) {
		  //for (E i: ite) {
			  //for (E j: that) 
				  for (E j: that) 
					  if (contains(j)) total++;
				  //if (i.equals(j)) total++; 
		  
	  //}

    return (total >= size());
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)

	  int total = 0;
	  
	  //if (!isSuperset(that)) {
			  for (E j: that) 
				  if (contains(j)) total++;   
		  //if (total==that.size()) return true;
	  //}

  return (total <= size() && total==that.size());

  }

  @Override
  public Set<E> adjoin(E e) {
    // TODO (6)
	  LinkedSet<E> ite = new LinkedSet<E>(head);
	  //LinkedNode<E> newHead = head;
	  int total = 0;
	  for (E i: ite) 
		  if (contains(e)) total++;
	  if (total==0) 
		  head = new LinkedNode<E>(e, head);
	  ite = new LinkedSet<E>(head);
    return ite;
  }

  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	  //Set<E> ite = new LinkedSet<E>(head);
	  Set<E> ite = null;
	  for (E i: that) 
		  ite = adjoin(i);
	  if (ite == null) ite = new LinkedSet<E>(head);
    return ite;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	  
	  LinkedNode<E> newList = null;
	  for (E i: that)
		  if (contains(i)) {
			  //if (newList==null) newList = new LinkedNode i;
			  //LinkedNode <E> newNode = new LinkedNode<E> (i,null);
			  if (newList == null) newList = new LinkedNode<E>(i,null);
			  else newList = new LinkedNode<E>(i, newList);
		  }
	  Set<E> ite = new LinkedSet<E>(newList);
    return ite;
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    // TODO (9)
	  LinkedNode<E> newList = null;
	  for (E i: that)
		  if (!(contains(i))) {
			  if (newList == null) newList = new LinkedNode<E>(i,null);
			  else newList = new LinkedNode<E>(i,newList);
	  	      
		  }
	  Set<E> ite = new LinkedSet<E>(newList);
    return ite;
  }

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	  LinkedSet<E> ite = new LinkedSet<E>(head);
	  LinkedNode<E> newList = null;
	  for (E i: ite) 
		  if (!(i.equals(e))) {
			  if (newList==null) newList = new LinkedNode<E>(i,null);
			  else newList = new LinkedNode<E>(i,newList);
	  	  }
	  
	  LinkedSet<E> iter = new LinkedSet<E>(newList);
    return iter;

  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}
