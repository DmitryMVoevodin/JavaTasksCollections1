package com.netcracker.core;

import com.netcracker.elements.Circle;

import java.util.*;

public class TimeForStandardCollections {

    //ArrayList vs LinkedList.....................................................................
    public static void listArrayVsLinkedAdd(int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            arrayList.add(new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultArrayList = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            linkedList.add(new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedList = estimatedTime;
        arrayList.clear(); arrayList = null;
        linkedList.clear(); linkedList = null;
        System.out.println("\nArrayList vs LinkedList - add(E element).");
        System.out.println("Time for ArrayList vs time for LinkedList: " + resultArrayList + " vs " + resultLinkedList);
        System.out.println("Conclusion: The ratio of time ArrayList/LinkedList is " + resultArrayList + "/" + resultLinkedList + "=" + (resultArrayList * 1.0 / resultLinkedList));
    }

    public static void listArrayVsLinkedAddIndex(int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        int numberOfElementsSub = n / 3;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;

        System.out.println("\nArrayList vs LinkedList - add(int index, E element).");
        System.out.print("Time for ArrayList vs time for LinkedList: ");
        for(int i = 0; i < numberOfElements; ++i) {
            arrayList.add(0, new Circle(1, "red"));
            linkedList.add(0, new Circle(1, "red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            arrayList.add(((numberOfElements + i) / 2), new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultArrayList = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            linkedList.add(((numberOfElements + i) / 2), new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedList = estimatedTime;
        System.out.print("(" + resultArrayList + " vs " + resultLinkedList + ") ");
        System.out.println(" The ratio of time ArrayList/LinkedList is " + resultArrayList * 1.0 / resultLinkedList);
    }

    public static void listArrayVsLinkedAddIndex2(int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;
        double[] ar = new double[11];
        System.out.println("\nArrayList vs LinkedList - add(int index, E element).");
        System.out.print("Time for ArrayList vs time for LinkedList: ");
        for(int t = 0; t < ar.length; ++t) {
            startTime = System.nanoTime();
            for(int i = 0; i < numberOfElements; ++i) {
                arrayList.add(i / 10 * t, new Circle(1, "red"));
            }
            estimatedTime = System.nanoTime() - startTime;
            resultArrayList = estimatedTime;
            startTime = System.nanoTime();
            for(int i = 0; i < numberOfElements; ++i) {
                linkedList.add(i / 10 * t, new Circle(1, "red"));
            }
            estimatedTime = System.nanoTime() - startTime;
            resultLinkedList = estimatedTime;
            arrayList.clear();
            linkedList.clear();
            System.out.print("(" + resultArrayList + " vs " + resultLinkedList + ") ");
            ar[t] = (resultArrayList * 1.0 / resultLinkedList);
        }
        System.out.println("\nConclusion: the ratio of time ArrayList/LinkedList represents a function with extremum.");
        System.out.println("Let's consider the places in the list (connected with the index), where 0% - is the beginning, 50% - is the middle and 100% - is the end of the list");
        for(int t = 0; t < ar.length; ++t) {
            System.out.print(ar[t] + "(" + (100 * t / (ar.length - 1)) + "%) ");
        }
        System.out.println();
    }

    public static void listArrayVsLinkedAddIndexWithIterator(int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        int numberOfElementsSub = n / 3;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;

        System.out.println("\nArrayList vs LinkedList - add(int index, E element) with the usage of iterator for LinkedList.");
        System.out.print("Time for ArrayList vs time for LinkedList(with the usage of iterator): ");
        for(int i = 0; i < numberOfElements; ++i) {
            arrayList.add(0, new Circle(1, "red"));
            linkedList.add(0, new Circle(1, "red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            arrayList.add(((numberOfElements + i) / 2), new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultArrayList = estimatedTime;
        startTime = System.nanoTime();
        ListIterator<Circle> iterForList = linkedList.listIterator();
        for(int i = 0; i < numberOfElementsSub - 1; ++i) {
            iterForList.next();
        }
        for(int i = 0; i < numberOfElementsSub; ++i) {
            iterForList.add(new Circle(1, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedList = estimatedTime;
        System.out.print("(" + resultArrayList + " vs " + resultLinkedList + ") ");
        System.out.println(" The ratio of time ArrayList/LinkedList is " + resultArrayList * 1.0 / resultLinkedList);
    }

    public static void listArrayVsLinkedRemoveIndex(int regime, int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        int numberOfElementsSub = n / 3;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;

        System.out.println("\nArrayList vs LinkedList - remove(int index).");
        System.out.print("Time for ArrayList vs time for LinkedList: ");
        for(int i = 0; i < numberOfElements; ++i) {
            arrayList.add(0, new Circle(1, "red"));
            linkedList.add(0, new Circle(1, "red"));
        }
        int valRegime1 = (regime != 0) ? 0 : 1;
        int valRegime2 = (regime <= 0) ? 0 : 1;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            arrayList.remove((numberOfElements - i) / 2 * valRegime1 + (numberOfElements - i - 1) * valRegime2);
        }
        estimatedTime = System.nanoTime() - startTime;
        resultArrayList = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            linkedList.remove((numberOfElements - i) / 2 * valRegime1 + (numberOfElements - i - 1) * valRegime2);
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedList = estimatedTime;
        System.out.print("(" + resultArrayList + " vs " + resultLinkedList + ") ");
        System.out.println(" The ratio of time ArrayList/LinkedList is " + resultArrayList * 1.0 / resultLinkedList);
        String str = new String((regime < 0) ? "from the beginning." : ((regime == 0) ? "in the middle." : "from the end."));
        System.out.println("we were removing the elements " + str);
    }

    public static void listArrayVsLinkedRemoveIndexWithIterator(int n) {
        List<Circle> arrayList = new ArrayList<>();
        List<Circle> linkedList = new LinkedList<>();
        int numberOfElements = n;
        int numberOfElementsSub = n / 3;
        long startTime, estimatedTime;
        long resultArrayList, resultLinkedList;

        System.out.println("\nArrayList vs LinkedList - add(int index, E element) with the usage of iterator for LinkedList.");
        System.out.print("Time for ArrayList vs time for LinkedList(with the usage of iterator): ");
        for(int i = 0; i < numberOfElements; ++i) {
            arrayList.add(0, new Circle(1, "red"));
            linkedList.add(0, new Circle(1, "red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            arrayList.remove((numberOfElements - i) / 2);
        }
        estimatedTime = System.nanoTime() - startTime;
        resultArrayList = estimatedTime;
        startTime = System.nanoTime();
        ListIterator<Circle> iterForList = linkedList.listIterator();
        for(int i = 0; i < numberOfElementsSub - 1; ++i) {
            iterForList.next();
        }
        iterForList.remove();
        for(int i = 0; i < numberOfElementsSub; ++i) {
            iterForList.next();
            iterForList.remove();
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedList = estimatedTime;
        System.out.print("(" + resultArrayList + " vs " + resultLinkedList + ") ");
        System.out.println(" The ratio of time ArrayList/LinkedList is " + resultArrayList * 1.0 / resultLinkedList);
    }



    //HashSet vs LinkedHashSet vs TreeSet..............................................................
    public static void setHashVsLinkedHashVsTreeAdd(int bound, int n) {
        Set<Circle> hashSet = new HashSet<>();
        Set<Circle> linkedHashSet = new LinkedHashSet<>();
        Set<Circle> treeSet = new TreeSet<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashSet, resultLinkedHashSet, resultTreeSet;
        Random rnd = new Random();
        startTime = System.nanoTime();
        for(int j = 0; j < 2; ++j) {
            for(int i = 0; i < numberOfElements; ++i) {
                hashSet.add(new Circle(rnd.nextInt(bound), "red"));
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int j = 0; j < 2; ++j) {
            for(int i = 0; i < numberOfElements; ++i) {
                linkedHashSet.add(new Circle(rnd.nextInt(bound), "red"));
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int j = 0; j < 2; ++j) {
            for(int i = 0; i < numberOfElements; ++i) {
                treeSet.add(new Circle(rnd.nextInt(bound), "red"));
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeSet = estimatedTime;

        hashSet.clear(); hashSet = null;
        linkedHashSet.clear(); linkedHashSet = null;
        treeSet.clear(); treeSet = null;
        System.out.println("\nHashSet vs LinkedHashSet vs TreeSet - add(E element).");
        System.out.println("Time for HashSet vs LinkedHashSet vs TreeSet: " + resultHashSet + " vs " + resultLinkedHashSet + " vs " + resultTreeSet);
        long minTime = Math.min(resultHashSet, Math.min(resultLinkedHashSet, resultTreeSet));
        System.out.println("Conclusion: The ratios of time HashSet/minTime, LinkedHashSet/minTime and TreeSet/minTime respectively are " +
                (resultHashSet * 1.0 / minTime) + ", " + (resultLinkedHashSet * 1.0 / minTime) + ", " + (resultTreeSet * 1.0 / minTime));

    }


    public static void setHashVsLinkedHashVsTreeContains(int bound, int n) {
        Set<Circle> hashSet = new HashSet<>();
        Set<Circle> linkedHashSet = new LinkedHashSet<>();
        Set<Circle> treeSet = new TreeSet<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashSet, resultLinkedHashSet, resultTreeSet;
        Random rnd = new Random();
        for(int i = 0; i < numberOfElements; ++i) {
            int r = rnd.nextInt(bound);
            hashSet.add(new Circle(r, "red"));
            linkedHashSet.add(new Circle(r, "red"));
            treeSet.add(new Circle(r, "red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            hashSet.contains(new Circle(rnd.nextInt(bound), "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            linkedHashSet.contains(new Circle(rnd.nextInt(bound), "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            treeSet.contains(new Circle(rnd.nextInt(bound), "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeSet = estimatedTime;

        hashSet.clear(); hashSet = null;
        linkedHashSet.clear(); linkedHashSet = null;
        treeSet.clear(); treeSet = null;
        System.out.println("\nHashSet vs LinkedHashSet vs TreeSet - contains(E element).");
        System.out.println("Time for HashSet vs LinkedHashSet vs TreeSet: " + resultHashSet + " vs " + resultLinkedHashSet + " vs " + resultTreeSet);
        long minTime = Math.min(resultHashSet, Math.min(resultLinkedHashSet, resultTreeSet));
        System.out.println("Conclusion: The ratios of time HashSet/minTime, LinkedHashSet/minTime and TreeSet/minTime respectively are " +
                (resultHashSet * 1.0 / minTime) + ", " + (resultLinkedHashSet * 1.0 / minTime) + ", " + (resultTreeSet * 1.0 / minTime));

    }


    public static void setHashVsLinkedHashVsTreeRemove(int bounds, int n) {
        Set<Circle> hashSet = new HashSet<>();
        Set<Circle> linkedHashSet = new LinkedHashSet<>();
        Set<Circle> treeSet = new TreeSet<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashSet, resultLinkedHashSet, resultTreeSet;
        Random rnd = new Random();
        for(int i = 0; i < numberOfElements; ++i) {
            int r = rnd.nextInt(bounds);
            hashSet.add(new Circle(r, "red"));
            linkedHashSet.add(new Circle(r, "red"));
            treeSet.add(new Circle(r, "red"));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            hashSet.remove(new Circle(i, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            linkedHashSet.remove(new Circle(i, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashSet = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            treeSet.remove(new Circle(i, "red"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeSet = estimatedTime;

        hashSet.clear(); hashSet = null;
        linkedHashSet.clear(); linkedHashSet = null;
        treeSet.clear(); treeSet = null;
        System.out.println("\nHashSet vs LinkedHashSet vs TreeSet - remove(E element).");
        System.out.println("Time for HashSet vs LinkedHashSet vs TreeSet: " + resultHashSet + " vs " + resultLinkedHashSet + " vs " + resultTreeSet);
        long minTime = Math.min(resultHashSet, Math.min(resultLinkedHashSet, resultTreeSet));
        System.out.println("Conclusion: The ratios of time HashSet/minTime, LinkedHashSet/minTime and TreeSet/minTime respectively are " +
                (resultHashSet * 1.0 / minTime) + ", " + (resultLinkedHashSet * 1.0 / minTime) + ", " + (resultTreeSet * 1.0 / minTime));

    }

    //HashMap vs LinkedHashMap vs TreeMap.............................................................
    public static void mapHashVsLinkedHashVsTreePut(int n) {
        Map<String, Circle> hashMap = new HashMap<>();
        Map<String, Circle> linkedHashMap = new LinkedHashMap<>();
        Map<String, Circle> treeMap = new TreeMap<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashMap, resultLinkedHashMap, resultTreeMap;
        Random rnd = new Random();
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(i);
            hashMap.put(str, new Circle(i, str));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(i);
            linkedHashMap.put(str, new Circle(i, str));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(i);
            treeMap.put(str, new Circle(i, str));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeMap = estimatedTime;

        hashMap.clear(); hashMap = null;
        linkedHashMap.clear(); linkedHashMap = null;
        treeMap.clear(); treeMap = null;
        System.out.println("\nHashMap vs LinkedHashMap vs TreeMap - put(String key, Circle circle).");
        System.out.println("Time for HashMap vs LinkedHashMap vs TreeMap: " + resultHashMap + " vs " + resultLinkedHashMap + " vs " + resultTreeMap);
        long minTime = Math.min(resultHashMap, Math.min(resultLinkedHashMap, resultTreeMap));
        System.out.println("Conclusion: The ratios of time HashMap/minTime, LinkedHashMap/minTime and TreeMap/minTime respectively are " +
                (resultHashMap * 1.0 / minTime) + ", " + (resultLinkedHashMap * 1.0 / minTime) + ", " + (resultTreeMap * 1.0 / minTime));
    }


    public static void mapHashVsLinkedHashVsTreeContainsKey(int n) {
        Map<String, Circle> hashMap = new HashMap<>();
        Map<String, Circle> linkedHashMap = new LinkedHashMap<>();
        Map<String, Circle> treeMap = new TreeMap<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashMap, resultLinkedHashMap, resultTreeMap;
        Random rnd = new Random();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(rnd.nextInt(numberOfElements));
            String str1 = new String(str);
            String str2 = new String(str);
            String str3 = new String(str);
            for (int j = 0; j < 1; ++j) {
                int r = rnd.nextInt(numberOfElements / 1000);
                hashMap.put((i + "V"), new Circle(r, str1));
                linkedHashMap.put((i + "V"), new Circle(r, str2));
                treeMap.put((i + "V"), new Circle(r, str3));
            }
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            hashMap.containsKey((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            linkedHashMap.containsKey((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            treeMap.containsKey((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeMap = estimatedTime;

        hashMap.clear(); hashMap = null;
        linkedHashMap.clear(); linkedHashMap = null;
        treeMap.clear(); treeMap = null;
        System.out.println("\nHashMap vs LinkedHashMap vs TreeMap - containsKey(Object key).");
        System.out.println("Time for HashMap vs LinkedHashMap vs TreeMap: " + resultHashMap + " vs " + resultLinkedHashMap + " vs " + resultTreeMap);
        long minTime = Math.min(resultHashMap, Math.min(resultLinkedHashMap, resultTreeMap));
        System.out.println("Conclusion: The ratios of time HashMap/minTime, LinkedHashMap/minTime and TreeMap/minTime respectively are " +
                (resultHashMap * 1.0 / minTime) + ", " + (resultLinkedHashMap * 1.0 / minTime) + ", " + (resultTreeMap * 1.0 / minTime));

    }

    public static void mapHashVsLinkedHashVsTreeContainsValue(int n) {
        Map<String, Circle> hashMap = new HashMap<>();
        Map<String, Circle> linkedHashMap = new LinkedHashMap<>();
        Map<String, Circle> treeMap = new TreeMap<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashMap, resultLinkedHashMap, resultTreeMap;
        Random rnd = new Random();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(rnd.nextInt(numberOfElements));
            int r = rnd.nextInt(numberOfElements);
            String str1 = new String(str);
            String str2 = new String(str);
            String str3 = new String(str);
            hashMap.put(str1, new Circle(r, str1));
            linkedHashMap.put(str2, new Circle(r, str2));
            treeMap.put(str3, new Circle(r, str3));
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            for(int j = 0; j < 3; ++j) {
                hashMap.containsValue(new Circle(i, ("red" + j)));
                hashMap.containsValue(new Circle(i, ("orange" + j)));
                hashMap.containsValue(new Circle(i, ("yellow" + j)));
                hashMap.containsValue(new Circle(i, ("green" + j)));
                hashMap.containsValue(new Circle(i, ("blue" + j)));
                hashMap.containsValue(new Circle(i, ("violet" + j)));
                hashMap.containsValue(new Circle(i, ("black" + j)));
                hashMap.containsValue(new Circle(i, ("white" + j)));
                hashMap.containsValue(new Circle(i, ("brown" + j)));
                hashMap.containsValue(new Circle(i, ("pink" + j)));

            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            for(int j = 0; j < 3; ++j) {
                linkedHashMap.containsValue(new Circle(i, ("red" + j)));
                linkedHashMap.containsValue(new Circle(i, ("orange" + j)));
                linkedHashMap.containsValue(new Circle(i, ("yellow" + j)));
                linkedHashMap.containsValue(new Circle(i, ("green" + j)));
                linkedHashMap.containsValue(new Circle(i, ("blue" + j)));
                linkedHashMap.containsValue(new Circle(i, ("violet" + j)));
                linkedHashMap.containsValue(new Circle(i, ("black" + j)));
                linkedHashMap.containsValue(new Circle(i, ("white" + j)));
                linkedHashMap.containsValue(new Circle(i, ("brown" + j)));
                linkedHashMap.containsValue(new Circle(i, ("pink" + j)));
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            for(int j = 0; j < 3; ++j) {
                treeMap.containsValue(new Circle(i, ("red" + j)));
                treeMap.containsValue(new Circle(i, ("orange" + j)));
                treeMap.containsValue(new Circle(i, ("yellow" + j)));
                treeMap.containsValue(new Circle(i, ("green" + j)));
                treeMap.containsValue(new Circle(i, ("blue" + j)));
                treeMap.containsValue(new Circle(i, ("violet" + j)));
                treeMap.containsValue(new Circle(i, ("black" + j)));
                treeMap.containsValue(new Circle(i, ("white" + j)));
                treeMap.containsValue(new Circle(i, ("brown" + j)));
                treeMap.containsValue(new Circle(i, ("pink" + j)));
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeMap = estimatedTime;

        hashMap.clear(); hashMap = null;
        linkedHashMap.clear(); linkedHashMap = null;
        treeMap.clear(); treeMap = null;
        System.out.println("\nHashMap vs LinkedHashMap vs TreeMap - containsValue(ObjectValue).");
        System.out.println("Time for HashMap vs LinkedHashMap vs TreeMap: " + resultHashMap + " vs " + resultLinkedHashMap + " vs " + resultTreeMap);
        long minTime = Math.min(resultHashMap, Math.min(resultLinkedHashMap, resultTreeMap));
        System.out.println("Conclusion: The ratios of time HashMap/minTime, LinkedHashMap/minTime and TreeMap/minTime respectively are " +
                (resultHashMap * 1.0 / minTime) + ", " + (resultLinkedHashMap * 1.0 / minTime) + ", " + (resultTreeMap * 1.0 / minTime));
    }


    public static void mapHashVsLinkedHashVsTreeRemove(int n) {
        Map<String, Circle> hashMap = new HashMap<>();
        Map<String, Circle> linkedHashMap = new LinkedHashMap<>();
        Map<String, Circle> treeMap = new TreeMap<>();
        int numberOfElements = n;
        long startTime, estimatedTime;
        long resultHashMap, resultLinkedHashMap, resultTreeMap;
        Random rnd = new Random();
        for(int i = 0; i < numberOfElements; ++i) {
            String str = strMake(rnd.nextInt(numberOfElements));
            String str1 = new String(str);
            String str2 = new String(str);
            String str3 = new String(str);
            for (int j = 0; j < numberOfElements / 10; ++j) {
                int r = rnd.nextInt(numberOfElements / 10);
                hashMap.put((i + "V"), new Circle(r, str1));
                linkedHashMap.put((i + "V"), new Circle(r, str2));
                treeMap.put((i + "V"), new Circle(r, str3));
            }
        }
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            hashMap.remove((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            linkedHashMap.remove((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultLinkedHashMap = estimatedTime;
        startTime = System.nanoTime();
        for(int i = 0; i < numberOfElements; ++i) {
            treeMap.remove((i + "V"));
        }
        estimatedTime = System.nanoTime() - startTime;
        resultTreeMap = estimatedTime;

        hashMap.clear(); hashMap = null;
        linkedHashMap.clear(); linkedHashMap = null;
        treeMap.clear(); treeMap = null;
        System.out.println("\nHashMap vs LinkedHashMap vs TreeMap - remove(Object key).");
        System.out.println("Time for HashMap vs LinkedHashMap vs TreeMap: " + resultHashMap + " vs " + resultLinkedHashMap + " vs " + resultTreeMap);
        long minTime = Math.min(resultHashMap, Math.min(resultLinkedHashMap, resultTreeMap));
        System.out.println("Conclusion: The ratios of time HashMap/minTime, LinkedHashMap/minTime and TreeMap/minTime respectively are " +
                (resultHashMap * 1.0 / minTime) + ", " + (resultLinkedHashMap * 1.0 / minTime) + ", " + (resultTreeMap * 1.0 / minTime));
    }

    private static String strMake(int i) {
        String str = null;
        switch(i % 30) {
            case 0: str = new String("red0"); break;
            case 1: str = new String("orange0"); break;
            case 2: str = new String("yellow0"); break;
            case 3: str = new String("green0"); break;
            case 4: str = new String("blue0"); break;
            case 5: str = new String("violet0"); break;
            case 6: str = new String("black0"); break;
            case 7: str = new String("white0"); break;
            case 8: str = new String("pink0"); break;
            case 9: str = new String("brown0"); break;
            case 10: str = new String("red1"); break;
            case 11: str = new String("orange1"); break;
            case 12: str = new String("yellow1"); break;
            case 13: str = new String("green1"); break;
            case 14: str = new String("blue1"); break;
            case 15: str = new String("violet1"); break;
            case 16: str = new String("black1"); break;
            case 17: str = new String("white1"); break;
            case 18: str = new String("pink1"); break;
            case 19: str = new String("brown1"); break;
            case 20: str = new String("red2"); break;
            case 21: str = new String("orange2"); break;
            case 22: str = new String("yellow2"); break;
            case 23: str = new String("green2"); break;
            case 24: str = new String("blue2"); break;
            case 25: str = new String("violet2"); break;
            case 26: str = new String("black2"); break;
            case 27: str = new String("white2"); break;
            case 28: str = new String("pink2"); break;
            case 29: str = new String("brown2"); break;
        }
        return str;
    }

}
