package com.netcracker.tests;

import com.netcracker.core.ILinkedList;
import com.netcracker.core.MyLinkedList;
import com.netcracker.core.TimeForStandardCollections;
import com.netcracker.elements.Circle;
import com.netcracker.elements.Extra;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainClass {

    public static void main(String[] args) {

        //******************************************Test #1*******************************************
        //Testing whether the collection MyLinkedList is valid and all the methods are correct.

        System.out.println("\n*************************************************************************************");
        System.out.println("Testing whether the collection MyLinkedList is valid and all the methods are correct.");

        System.out.println("\n1) Creating the object myLinkedList:");
        ILinkedList<Circle> myLinkedList = new MyLinkedList<>();
        System.out.println("The method toString(): " + myLinkedList);
        System.out.println("The method isEmpty(): " + myLinkedList.isEmpty());

        System.out.println("\n2) Creating and adding elements using add(E element).");
        System.out.println("Additional testing of toString() and size().");
        Circle c1 = new Circle(16.7, "white");
        System.out.print("The object c1 " + c1.toString() + " belongs to ");
        myLinkedList.add(c1); System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        Circle c2 = new Circle(20.0, "red");
        System.out.print("The object c2 " + c2.toString() + " belongs to ");
        myLinkedList.add(c2); System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        Circle c3 = new Circle(5.1, "green");
        System.out.print("The object c3 " + c3.toString() + " belongs to ");
        myLinkedList.add(c3); System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        Circle c4 = new Circle(2.0, "yellow");
        System.out.print("The object c4 " + c4.toString() + " belongs to ");
        myLinkedList.add(c4); System.out.println(myLinkedList + " with size = " + myLinkedList.size());

        System.out.println("\n3) Removing elements using remove(int index).");
        System.out.println("The element[4] = " + myLinkedList.remove(4) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[-1] = " + myLinkedList.remove(-1) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[3] = " + myLinkedList.remove(3) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[1] = " + myLinkedList.remove(1) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.remove(0) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[1] = " + myLinkedList.remove(1) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.remove(0) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.remove(0) + " was removed --> " + myLinkedList + " with size = " + myLinkedList.size());

        System.out.println("\n4) Testing get(int index), add(int index, E element) and set(int index, E element).");
        System.out.println(myLinkedList);
        Circle c5 = new Circle(9.3, "brown");
        System.out.println("The element[-1] = " + myLinkedList.set(-1, c5) + " was replaced by " + c5 + " (i.e. " + myLinkedList.get(-1) + ") --> " + myLinkedList + " size = " + myLinkedList.size());
        System.out.println("The element[3] = " + myLinkedList.set(3, c5) + " was replaced by " + c5 + " (i.e. " + myLinkedList.get(3) + ") --> " + myLinkedList + " size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.set(0, c5) + " was replaced by " + c5 + " (i.e. " + myLinkedList.get(0) + ") --> " + myLinkedList + " size = " + myLinkedList.size());
        myLinkedList.add(-1, c5);
        System.out.println("The element[-1] = " + c5 + " (i.e. " + myLinkedList.get(-1) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        myLinkedList.add(3, c5);
        System.out.println("The element[3] = " + c5 + " (i.e. " + myLinkedList.get(3) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        myLinkedList.add(0, c5);
        System.out.println("The element[0] = " + c5 + " (i.e. " + myLinkedList.get(0) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        Circle c6 = new Circle(1, "black");
        System.out.println("The element[1] = " + myLinkedList.set(1, c6) + " was replaced by " + c6 + " (i.e. " + myLinkedList.get(1) + ") --> " + myLinkedList + " size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.set(0, c6) + " was replaced by " + c6 + " (i.e. " + myLinkedList.get(0) + ") --> " + myLinkedList + " size = " + myLinkedList.size());
        Circle c7 = new Circle(89, "white");
        myLinkedList.add(1, c7);
        System.out.println("The element[1] = " + c7 + " (i.e. " + myLinkedList.get(1) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        Circle c8 = new Circle(66, "gray");
        myLinkedList.add(1, c8);
        System.out.println("The element[1] = " + c8 + " (i.e. " + myLinkedList.get(1) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        Circle c9 = new Circle(17.2, "violet");
        myLinkedList.add(0, c9);
        System.out.println("The element[0] = " + c9 + " (i.e. " + myLinkedList.get(0) + ") was added --> " + myLinkedList + " size = " + myLinkedList.size());
        Circle c10 = new Circle(1, "orange");
        Circle c11 = new Circle(2, "blue");
        Circle c12 = new Circle(3, "pink");
        System.out.println("The element[3] = " + myLinkedList.set(3, c10) + " was replaced by " + c10 + " --> " + myLinkedList + " size = " + myLinkedList.size());
        System.out.println("The element[2] = " + myLinkedList.set(2, c11) + " was replaced by " + c11 + " --> " + myLinkedList + " size = " + myLinkedList.size());
        System.out.println("The element[0] = " + myLinkedList.set(0, c12) + " was replaced by " + c12 + " --> " + myLinkedList + " size = " + myLinkedList.size());

        System.out.println("\n5) Testing indexOf(E element) and clear().");
        Circle c13 = new Circle(2, "blue");
        Circle c14 = new Circle(2, "blue");
        myLinkedList.add(c13);
        System.out.println("Let's consider " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The index of the first occurrence of the element " + c14 + " is " + myLinkedList.indexOf(c14) + ".");
        myLinkedList.set(2, c1);
        System.out.println("Let's consider " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The index of the first occurrence of the element " + c14 + " is " + myLinkedList.indexOf(c14) + ".");
        myLinkedList.set(4, c2);
        System.out.println("Let's consider " + myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("The index of the first occurrence of the element " + c14 + " is " + myLinkedList.indexOf(c14) + ".");
        System.out.println("Now we'll use clear() for this list:");
        myLinkedList.clear();
        System.out.println(myLinkedList);

        System.out.println("\n6) Testing toArray().");
        myLinkedList.add(c1); myLinkedList.add(c2); myLinkedList.add(c3); myLinkedList.add(c4); myLinkedList.add(c5);
        System.out.println(myLinkedList);
        Circle[] circleArray1 = myLinkedList.toArray();
        if(circleArray1 != null) {
            System.out.print("Array: ");
            for(int i = 0; i < circleArray1.length; ++i) {
                System.out.print(circleArray1[i] + " ");
            }
        } else {
            System.out.print("Array: null");
        }
        System.out.println("\nNow we'll delete all the elements:");
        myLinkedList.clear();
        System.out.println(myLinkedList);
        Circle[] circleArray2 = myLinkedList.toArray();
        if(circleArray2 != null) {
            System.out.print("Array: ");
            for(int i = 0; i < circleArray2.length; ++i) {
                System.out.print(circleArray2[i] + " ");
            }
        } else {
            System.out.print("Array: null");
        }
        System.out.println();


        System.out.println("\n7) Testing iterator - next() and previous().");
        System.out.println(myLinkedList);
        ListIterator<Circle> iter1 = myLinkedList.listIterator();
        while(iter1.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();
        for(int i = 0; i < 7; ++i) {
            myLinkedList.add(new Circle(new Random().nextInt(25), "w"));
        }
        System.out.println("And now we filled the list --> \n" + myLinkedList);
        ListIterator<Circle> iter2 = myLinkedList.listIterator();
        System.out.println("From the beginning to the end:");
        while(iter2.hasNext()) {
            System.out.print(iter2.next() + " ");
        }
        System.out.println("\nFrom the end to the beginning:");
        while(iter2.hasPrevious()) {
            System.out.print(iter2.previous() + " ");
        }

        System.out.println("\n\n8) Testing iterator - nextIndex() and previousIndex().");
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        ListIterator<Circle> iter3 = myLinkedList.listIterator();
        while(iter3.hasNext()) {
            System.out.println(iter3.next() + ", previousIndex() = " + iter3.previousIndex() + ", nextIndex() = " + iter3.nextIndex());
        }

        System.out.println("\n\n9) Testing iterator - remove().");
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("Let's remove the first element: ");
        myLinkedList.add(3, new Circle(44.44,"r"));
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        ListIterator<Circle> iter4 = myLinkedList.listIterator();
        System.out.println("\nLet's remove the first element: ");
        iter4.next();
        iter4.remove();
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("\nLet's remove the element with radius = 44.44: ");
        while(iter4.hasNext()) {
            Circle cTmp = iter4.next();
            if(Extra.isEqual(cTmp.getRadius(), 44.44)) {
                System.out.print(cTmp + ", previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex() + " is removed! ");
                iter4.remove();
                System.out.println("And we are standing on previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex());
            } else {
                System.out.println(cTmp + ", previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex());
            }
        }
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("\nNow we are going to remove \"the last\" element (out of our range): ");
        iter4.remove();
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("\nNow we are going to remove the last element (in our range): " + iter4.previous());
        iter4.remove();
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("We are standing on the position, where: " + "previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex());
        System.out.println("\nLet's consider the following list:");
        for(int i = 0; i < 4; ++i) {
            iter4.remove();
        }
        System.out.println(myLinkedList);
        System.out.println("Let's remove the element:");
        iter4.remove();
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("We are standing on the position, where: " + "previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex());
        System.out.println("Once again:");
        iter4.remove();
        System.out.println(myLinkedList + " with size = " + myLinkedList.size());
        System.out.println("We are standing on the position, where: " + "previousIndex() = " + iter4.previousIndex() + ", nextIndex() = " + iter4.nextIndex());

        System.out.println("\n\n9) Testing iterator - set(E e) and add(E e).");
        Circle c101 = new Circle(43.2,"red");
        Circle c102 = new Circle(13.4,"orange");
        Circle c103 = new Circle(20.6,"yellow");
        Circle c104 = new Circle(81.5,"green");
        Circle c105 = new Circle(10.0,"blue");
        Circle c106 = new Circle(3.0,"violet");
        Circle c107 = new Circle(1.0,"pink");

        ListIterator<Circle> iter5 = myLinkedList.listIterator();
        System.out.println(myLinkedList);
        System.out.println("Let's do set(c101)");
        iter5.set(c101);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        iter5.remove();
        System.out.println("After remove() " + myLinkedList);
        System.out.println("Let's do add(c102)");
        iter5.set(c102);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        System.out.println("Let's do set(c103)");
        iter5.set(c103);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        System.out.println("Let's do set(c104)");
        iter5.add(c104);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        System.out.println("Let's do iter5.previous() and set(c105)");
        iter5.previous();
        iter5.add(c105);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        System.out.println("Let's do set(c106)");
        iter5.set(c106);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        System.out.println("Let's do iter5.previous() and set(c107)");
        iter5.previous();
        iter5.set(c107);
        System.out.println(myLinkedList + " where previousIndex() = " + iter5.previousIndex() + ", nextIndex() = " + iter5.nextIndex());
        myLinkedList.clear();

        //********************************************************************************************



        //******************************************Test #2*******************************************
        //Estimating the program time for our collection MyLinkedList and for LinkedList from java.util.

        System.out.println("\n*************************************************************************************");
        System.out.println("Estimating the program time for our collection MyLinkedList and for LinkedList from java.util.");

        int numberOfElements;
        ILinkedList<Circle> circlesMy = new MyLinkedList<>();
        List<Circle> circlesStandard = new LinkedList<>();
        long startTime, estimatedTime;
        long resultMy, resultStandard;
        Random rndMy = new Random();
        Random rndStandard = new Random();




        //Estimating the time for add(E element) - the element adding to the end of the list.
        System.out.println("\n1)Estimating the time for add(E element) - the element adding to the end of the list.");
        numberOfElements = 1000000;
        System.out.println("We use " + numberOfElements + " elements for testing.");
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.add(new Circle(1,"red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultMy = estimatedTime;

        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesStandard.add(new Circle(1,"red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultStandard = estimatedTime;
        System.out.println("Time for MyLinkedList vs time for Standard MyLinkedList: " + resultMy + " vs " + resultStandard);
        System.out.println("Conclusion: The ratio of time OurCollection/JavaCollection is " + resultMy + "/" + resultStandard + "=" + (resultMy * 1.0 / resultStandard));
        circlesMy.clear(); circlesStandard.clear();




        //Estimating the time for add(int index, E element) - the element adding to the random place of the list.
        System.out.println("\n2)Estimating the time for add(int index, E element) - the element adding to the random place of the list.");
        numberOfElements = 50000;
        System.out.println("We use " + numberOfElements + " elements for testing.");
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.add(rndMy.nextInt(i + 1), new Circle(1,"red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultMy = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesStandard.add(rndStandard.nextInt(i + 1), new Circle(1,"red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultStandard = estimatedTime;
        System.out.println("Time for MyLinkedList vs time for Standard MyLinkedList: " + resultMy + " vs " + resultStandard);
        System.out.println("Conclusion: The ratio of time OurCollection/JavaCollection is " + resultMy + "/" + resultStandard + "=" + (resultMy * 1.0 / resultStandard));
        circlesMy.clear(); circlesStandard.clear();




        //Estimating the time for get(int index) - the operation of searching the element by its index.
        System.out.println("\n3)Estimating the time for get(int index) - the operation of searching the element by its index.");
        numberOfElements = 50000;
        System.out.println("We use a list of " + numberOfElements + " elements for testing.");
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.add(new Circle(1,"red"));
            circlesStandard.add(new Circle(1,"red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.get(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        resultMy = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesStandard.get(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        resultStandard = estimatedTime;
        System.out.println("Time for MyLinkedList vs time for Standard MyLinkedList: " + resultMy + " vs " + resultStandard);
        System.out.println("Conclusion: The ratio of time OurCollection/JavaCollection is " + resultMy + "/" + resultStandard + "=" + (resultMy * 1.0 / resultStandard));
        circlesMy.clear(); circlesStandard.clear();




        //Estimating the time for set(int index, E element) - the operation of element replacement in the list.
        System.out.println("\n4)Estimating the time for set(int index, E element) - the operation of element replacement in the list.");
        numberOfElements = 50000;
        System.out.println("We use a list of " + numberOfElements + " elements for testing.");
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.add(new Circle(1,"red"));
            circlesStandard.add(new Circle(1,"red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.set(i, new Circle(2, "green"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultMy = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesStandard.set(i, new Circle(2, "green"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultStandard = estimatedTime;
        System.out.println("Time for MyLinkedList vs time for Standard MyLinkedList: " + resultMy + " vs " + resultStandard);
        System.out.println("Conclusion: The ratio of time OurCollection/JavaCollection is " + resultMy + "/" + resultStandard + "=" + (resultMy * 1.0 / resultStandard));
        circlesMy.clear(); circlesStandard.clear();




        //Estimating the time for remove(int index) - the operation of removing the element with some random index.
        System.out.println("\n5)Estimating the time for remove(int index) - the operation of removing the element with some random index.");
        numberOfElements = 50000;
        System.out.println("We use " + numberOfElements + " elements for testing.");
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.add(new Circle(1,"red"));
            circlesStandard.add(new Circle(1,"red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesMy.remove(rndMy.nextInt(numberOfElements - i));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultMy = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            circlesStandard.remove(rndStandard.nextInt(numberOfElements - i));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultStandard = estimatedTime;
        System.out.println("Time for MyLinkedList vs time for Standard MyLinkedList: " + resultMy + " vs " + resultStandard);
        System.out.println("Conclusion: The ratio of time OurCollection/JavaCollection is " + resultMy + "/" + resultStandard + "=" + (resultMy * 1.0 / resultStandard));
        circlesMy.clear(); circlesStandard.clear();

        //********************************************************************************************




        System.out.println("\n\n**********************************Testing ArrayList VS LinkedList**********************************");
        TimeForStandardCollections.listArrayVsLinkedAdd(100000); //Добавление элементов
        TimeForStandardCollections.listArrayVsLinkedAddIndex(100000); //Вставка элементов
        TimeForStandardCollections.listArrayVsLinkedAddIndex2(10000); //Вставка элементов с демонстрацией вставки в разные места списка
        TimeForStandardCollections.listArrayVsLinkedAddIndexWithIterator(100000); //Вставка элементов с помощью итератора
        TimeForStandardCollections.listArrayVsLinkedRemoveIndex(-1, 100000); //Удаление с начала
        TimeForStandardCollections.listArrayVsLinkedRemoveIndex(0, 10000); //Удаление в середине
        TimeForStandardCollections.listArrayVsLinkedRemoveIndex(1, 100000); //Удаление с конца
        TimeForStandardCollections.listArrayVsLinkedRemoveIndexWithIterator(100000); //Удаление с помощью итератора

        System.out.println("\n\n****************************Testing HashSet VS LinkedHashSet VS TreeSet****************************");
        TimeForStandardCollections.setHashVsLinkedHashVsTreeAdd(10, 100000); //Добавление элементов
        TimeForStandardCollections.setHashVsLinkedHashVsTreeAdd(100000, 100000); //Добавление элементов
        TimeForStandardCollections.setHashVsLinkedHashVsTreeContains(100000, 100000); //Поиск элементов
        TimeForStandardCollections.setHashVsLinkedHashVsTreeRemove(100000, 100000); //Удаление элементов

        System.out.println("\n\n****************************Testing HashMap VS LinkedHashMap VS TreeMap****************************");
        TimeForStandardCollections.mapHashVsLinkedHashVsTreePut(100000); //Добавление элементов
        TimeForStandardCollections.mapHashVsLinkedHashVsTreeContainsKey(10000); //Поиск ключа
        TimeForStandardCollections.mapHashVsLinkedHashVsTreeRemove(10000); //Удаление элементов

    }

}
