package com.netcracker.tests;

import com.netcracker.core.ILinkedList;
import com.netcracker.core.MyLinkedList;
import com.netcracker.elements.Circle;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestEstimatingTimeTask1 {

    public static void main(String[] args) {

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

    }

}