package com.netcracker.tests;

import com.netcracker.core.TimeForStandardCollections;

public class TestEstimatingTimeTask2 {

    public static void main(String[] args) {

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
