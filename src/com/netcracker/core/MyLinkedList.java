package com.netcracker.core;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node firstNode; //the pointer on the first element
    private Node lastNode; //the pointer on the last element
    private int size; //the size of the collection

    //Creating an empty list
    public MyLinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    //Determining whether the index satisfies the condition of bounds.
    private boolean isIndexValid(int index) {
        return ((index >= 0) && (index <= size));
    }

    //Finding and getting the node with the given index.
    //We consider the situation when the given index is valid.
    private Node getNodeByIndex(int index) {
        Node nd = null;
        //In order to reduce the number of operations, we can find the place of our Node
        //following the chain of nodes from the beginning OR from the end of the list.
        //It depends on the location of the index relative to the middle of the chain.
        if(index <= (size / 2)) {
            nd = firstNode; //We follow from the beginning, because the index is closer to the beginning.
            for(int i = 0; i < index; ++i) {
                nd = nd.nextNode;
            }
        } else {
            nd = lastNode; //We follow from the end, because the index is closer to the end.
            for(int i = size - 1; i > index; --i) {
                nd = nd.previousNode;
            }
        }
        return nd;
    }

    //Determining whether the list is empty.
    public boolean isEmpty() {
        return ((firstNode == null) && (lastNode == null) && (size == 0));
    }

    //Returns the number of elements in this list.
    public int size() {
        return size;
    }

    //Appends the specified element to the beginning of this list.
    private void addToTheBeginning(E element) {
        Node nd = new Node(element, null, null);
        if(!isEmpty()) {
            nd.nextNode = firstNode;
            firstNode.previousNode = nd;
        } else {
            lastNode = nd;
        }
        firstNode = nd;
        ++size;
    }

    //Appends the specified element to the end of this list.
    public void add(E element) {
        Node nd = new Node(element, null, null);
        if(!isEmpty()) {
            nd.previousNode = lastNode;
            lastNode.nextNode = nd;
        } else {
            firstNode = nd;
        }
        lastNode = nd;
        ++size;
    }

    //Inserts the specified element at the specified position in this list.
    public void add(int index, E element) {
        if(!isIndexValid(index)) return; //Here we check the index for its validity.
        Node nd = new Node(element, null, null);
        Node ndIndexOld = getNodeByIndex(index);
        if(index == size) { //Here we consider the situation, where the node is added to the end of the list.
            this.add(element);
        } else {
            if(index == 0) {
                this.addToTheBeginning(element);
            } else { // (0 < index < size)
                nd.nextNode = ndIndexOld;
                nd.previousNode = ndIndexOld.previousNode;
                (ndIndexOld.previousNode).nextNode = nd;
                ndIndexOld.previousNode = nd;
                ++size;
            }
        }
    }

    //Removes all of the elements from this list.
    public void clear() {
        //*********************************
        //Such "cleaning" of the nodes is made on the off-chance.
        Node ndTmp = null;
        Node nd = firstNode;
        while(nd != null) {
            ndTmp = nd.nextNode;
            nd.nextNode = null;
            nd.previousNode = null;
            nd.objNode = null;
            nd = ndTmp;
        }
        //*********************************
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    //Returns the element at the specified position in this list.
    public E get(int index) {
        if(!isIndexValid(index) || isEmpty() || (index == size)) return null;
        return getNodeByIndex(index).objNode;
    }

    //Returns the index of the first occurrence of the specified element in this list,
    //or -1 if this list does not contain the element.
    public int indexOf(E element) {
        int indexFirstOccurrence = 0;
        Node nd = firstNode;
        if(element != null) {
            while(nd != null) {
                if(nd.objNode.equals(element)) {
                    return indexFirstOccurrence;
                }
                ++indexFirstOccurrence;
                nd = nd.nextNode;
            }
        } else {
            while(nd != null) {
                if(nd.objNode == null) {
                    return indexFirstOccurrence;
                }
                ++indexFirstOccurrence;
                nd = nd.nextNode;
            }
        }
        return -1;
    }

    //Removes the element at the specified position in this list.
    //Returns the element that was removed from the list.
    public E remove(int index) {
        if(!isIndexValid(index) || (index == size) || isEmpty()) return null;
        Node nd = getNodeByIndex(index);
        E objNode = nd.objNode;
        if((index == (size - 1)) && (index > 0)) {
            (nd.previousNode).nextNode = null;
            lastNode = nd.previousNode;
        } else {
            if ((index < (size - 1)) && (index == 0)) {
                (nd.nextNode).previousNode = null;
                firstNode = nd.nextNode;
            } else {
                if ((index == (size - 1)) && (index == 0)) {
                    firstNode = null;
                    lastNode = null;
                } else {
                    (nd.previousNode).nextNode = nd.nextNode;
                    (nd.nextNode).previousNode = nd.previousNode;
                }
            }
        }
        --size;
        nd.objNode = null;
        nd.previousNode = null;
        nd.nextNode = null;
        nd = null;
        return objNode;
    }

    //Replaces the element at the specified position in this list with the specified element.
    //Returns the element that was replaced in the list.
    public E set(int index, E element) {
        if(!isIndexValid(index) || (index == size) || isEmpty()) return null;
        Node nd = new Node(element, null, null);
        Node ndIndexOld = getNodeByIndex(index);
        E objNode = ndIndexOld.objNode;
        if((index == (size - 1)) && (index > 0)) {
            nd.previousNode = ndIndexOld.previousNode;
            (nd.previousNode).nextNode = nd;
            lastNode = nd;
        } else {
            if((index < (size - 1)) && (index == 0)) {
                nd.nextNode = ndIndexOld.nextNode;
                (ndIndexOld.nextNode).previousNode = nd;
                firstNode = nd;
            } else {
                if ((index == (size - 1)) && (index == 0)) {
                    firstNode = nd;
                    lastNode = nd;
                } else { // (0 < index < size)
                    nd.nextNode = ndIndexOld.nextNode;
                    nd.previousNode = ndIndexOld.previousNode;
                    (ndIndexOld.nextNode).previousNode = nd;
                    (ndIndexOld.previousNode).nextNode = nd;
                }
            }
        }
        ndIndexOld.objNode = null;
        ndIndexOld.nextNode = null;
        ndIndexOld.previousNode = null;
        return objNode;
    }

    //Returns an array containing all of the elements in this list in proper sequence
    //(from first to last element).
    public E[] toArray() {
        if(isEmpty()) return null;
        E[] arrayObjNode;
        arrayObjNode = (E[]) java.lang.reflect.Array.newInstance(firstNode.objNode.getClass(), size);
        Node nd = firstNode;
        int index = 0;
        while(nd != null) {
            arrayObjNode[index++] = nd.objNode;
            nd = nd.nextNode;
        }
        return arrayObjNode;
    }

    //Returns the string "representation" of this list.
    public String toString() {
        if(isEmpty()) return ("MyLinkedList is empty.");
        Node nd = firstNode;
        String str = new String("MyLinkedList: [" + nd.objNode.toString());
        nd = nd.nextNode;
        while(nd != null) {
            str = str + ", " + nd.objNode.toString();
            nd = nd.nextNode;
        }
        str = str + "]";
        return str;
    }

    //Returns an iterator over elements of type E in this list.
    @Override
    public Iterator<E> iterator() {
        return new MyIterator(-1);
    }

    //Returns a list iterator over the elements of type E in this list.
    @Override
    public ListIterator<E> listIterator() {
        return new MyLinkedListIterator(-1);
    }


    //***********************************************************************************************************//
    //The inner class of the node, which contains our data-object. The list consists of the set of such nodes.
    private class Node {

        public E objNode; //Our data, which we "add" (through the corresponding node) to the list.
        public Node nextNode; //The pointer to the next node-with-information in the list.
        public Node previousNode; //The pointer to the previous node-with-information in the list.

        Node(E objNode, Node nextNode, Node previousNode){
            this.objNode = objNode;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        @Override
        public String toString() {
            return objNode.toString();
        }

    }
    //***********************************************************************************************************//

    //***********************************************************************************************************//
    //The inner class of the iterator.
    private class MyIterator implements Iterator<E>{

        protected Node nd;
        protected int index;

        public MyIterator(int index) {
            if(isEmpty()) {
                this.index = -1;
                this.nd = null;
            } else {
                this.index = (index < 0) ? (-1) : ((index > size) ? size : index);
                this.nd = getNodeByIndex(this.index);
            }
        }

        //Returns true if the iteration has more elements.
        @Override
        public boolean hasNext() {
            boolean b = (index < (size - 1));
            if((index == size - 1) && !isEmpty()) {
                index++;
            }
            return b;
        }

        //Returns the next element in the iteration.
        @Override
        public E next() {
            if(!(index < size)){
                index = size;
                return null;
            }
            if(index != -1) {
                nd = nd.nextNode;
            } else {
                nd = firstNode;
            }
            ++index;
            return nd.objNode;
        }
    }
    //***********************************************************************************************************//

    //***********************************************************************************************************//
    //The inner class of the list-iterator.
    private class MyLinkedListIterator extends MyIterator implements ListIterator<E>{

        protected int indexPrevious;

        public MyLinkedListIterator(int index) {
            super(index);
        }

        //Returns true if this list iterator has more elements when traversing the list in the reverse direction.
        @Override
        public boolean hasPrevious() {
            boolean b = (index > 0);
            if(index == 0 && !isEmpty()) {
                --index;
            }
            return b;
        }

        //Returns the previous element in the list and moves the cursor position backwards.
        @Override
        public E previous() {
            if(!(index >= 0)) {
                index = -1;
                return null;
            }
            if(index != size) {
                nd = nd.previousNode;
            } else {
                nd = lastNode;
            }
            --index;
            return nd.objNode;
        }

        //Returns the index of the element that would be returned by a subsequent call to next().
        //Returns list size if the list iterator is at the end of the list.
        @Override
        public int nextIndex() {
            if(!(index < size)){
                return size;
            }
            return (index + 1);
        }

        //Returns the index of the element that would be returned by a subsequent call to previous().
        //Returns -1 if the list iterator is at the beginning of the list.
        @Override
        public int previousIndex() {
            if(!(index >= 0)) {
                return (-1);
            }
            return (index - 1);
        }

        //Removes from the list the last element that was returned by next() or previous().
        @Override
        public void remove() {
            if(!isIndexValid(index) || (index == size) || isEmpty()) return;
            if((index == (size - 1)) && (index > 0)) {
                (nd.previousNode).nextNode = null;
                lastNode = nd.previousNode;
                nd = nd.previousNode;
                --index;
            } else {
                if ((index < (size - 1)) && (index == 0)) {
                    (nd.nextNode).previousNode = null;
                    firstNode = nd.nextNode;
                    nd = nd.nextNode;
                } else {
                    if ((index == (size - 1)) && (index == 0)) {
                        firstNode = null;
                        lastNode = null;
                        index = -1;
                        nd.objNode = null;
                        nd.previousNode = null;
                        nd.nextNode = null;
                        nd = null;
                    } else {
                        (nd.previousNode).nextNode = nd.nextNode;
                        (nd.nextNode).previousNode = nd.previousNode;
                        nd = nd.nextNode;
                    }
                }
            }
            --size;
            return;
        }

        //Replaces the last element returned by next() or previous() with the specified element.
        //The iterator doesn't change its "position".
        @Override
        public void set(E e) {
            Node ndAdded = new Node(e, null, null);
            if(isEmpty()) {
                firstNode = ndAdded;
                lastNode = ndAdded;
                nd = firstNode;
                ++index;
                ++size;
            } else {
                if((index == (size - 1)) && (index == 0)) {
                    firstNode = ndAdded;
                    lastNode = ndAdded;
                    nd.objNode = null;
                    nd = ndAdded;
                } else {
                    if((index == (size - 1)) && (index > 0)) {
                        ndAdded.previousNode = nd.previousNode;
                        (nd.previousNode).nextNode = ndAdded;
                        lastNode = ndAdded;
                        nd.nextNode = null; nd.previousNode = null; nd.objNode = null;
                        nd = ndAdded;
                    } else {
                        if((index == 0)) {
                            ndAdded.nextNode = nd.nextNode;
                            (nd.nextNode).previousNode = ndAdded;
                            firstNode = ndAdded;
                            nd.nextNode = null; nd.objNode = null;
                            nd = ndAdded;
                        } else {
                            ndAdded.previousNode = nd.previousNode;
                            ndAdded.nextNode = nd.nextNode;
                            (nd.previousNode).nextNode = ndAdded;
                            (nd.nextNode).previousNode = ndAdded;
                            nd.nextNode = null; nd.previousNode = null; nd.objNode = null;
                            nd = ndAdded;
                        }
                    }
                }
            }
            return;
        }

        //Inserts the specified element into the list after the current position and moves the iterator forward
        //to this added element.
        @Override
        public void add(E e) {
            Node ndAdded = new Node(e, null, null);
            if(isEmpty()) {
                firstNode = ndAdded;
                lastNode = ndAdded;
                nd = firstNode;
            } else {
                if(index == size - 1) {
                    ndAdded.previousNode = nd;
                    nd.nextNode = ndAdded;
                    lastNode = ndAdded;
                    nd = nd.nextNode;
                } else {
                    ndAdded.nextNode = nd.nextNode;
                    ndAdded.previousNode = nd;
                    (nd.nextNode).previousNode = ndAdded;
                    nd.nextNode = ndAdded;
                    nd = nd.nextNode;
                }
            }
            ++index;
            ++size;
            return;
        }

    }
    //***********************************************************************************************************//


}