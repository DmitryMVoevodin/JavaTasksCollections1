package com.netcracker.core;

import java.util.ListIterator;

public interface ILinkedList<E> extends Iterable<E> {

    //Determines whether the list is empty.
    boolean isEmpty();

    //Appends the specified element to the end of this list.
    void add(E element);

    //Inserts the specified element at the specified position in this list.
    void add(int index, E element);

    //Removes all of the elements from this list.
    void clear();

    //Returns the element at the specified position in this list.
    E get(int index);

    //Returns the index of the first occurrence of the specified element in this list,
    //or -1 if this list does not contain the element.
    int indexOf(E element);

    //Removes the element at the specified position in this list.
    //Returns the element that was removed from the list.
    E remove(int index);

    //Replaces the element at the specified position in this list with the specified element.
    //Returns the element that was replaced in the list.
    E set(int index, E element);

    //Returns the number of elements in this list.
    int size();

    //Returns an array containing all of the elements in this list in proper sequence
    //(from first to last element).
    E[] toArray();

    //Returns the string "representation" of this list.
    String toString();

    //Returns a list iterator over the elements in this list.
    ListIterator<E> listIterator();

}
