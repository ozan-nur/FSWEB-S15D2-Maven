package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Ann'in taskları
        Set<Task> annTasks = new HashSet<>();
        annTasks.add(new Task("Java Collections", "Write List Interface", "Ann", Status.IN_QUEUE, Priority.LOW));
        annTasks.add(new Task("Java Collections", "Write Set Interface", "Ann", Status.ASSIGNED, Priority.MED));

        // Bob'un taskları
        Set<Task> bobTasks = new HashSet<>();
        bobTasks.add(new Task("Java Collections", "Write Map Interface", "Bob", Status.IN_QUEUE, Priority.HIGH));

        // Carol'un taskları
        Set<Task> carolTasks = new HashSet<>();
        carolTasks.add(new Task("Java Collections", "Write Queue Interface", "Carol", Status.IN_PROGRESS, Priority.MED));

        // Unassigned tasklar
        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(new Task("Java Basics", "Learn Variables", "", Status.IN_QUEUE, Priority.LOW));

        // TaskData objesi oluştur
        TaskData taskData = new TaskData(annTasks, bobTasks, carolTasks, unassignedTasks);

        // Tüm taskları al
        Set<Task> allTasks = taskData.getTasks("all");
        System.out.println("Tüm tasklar:");
        allTasks.forEach(System.out::println);

        // Ann'in taskları
        System.out.println("\nAnn'in taskları:");
        taskData.getTasks("ann").forEach(System.out::println);

        // Unassigned tasklar
        System.out.println("\nAtanmamış tasklar:");
        taskData.getTasks("unassigned").forEach(System.out::println);

        // Örnek: Union ve Intersection
        Set<Task> union = taskData.getUnion(annTasks, bobTasks);
        System.out.println("\nAnn ve Bob'un tasklarının birleşimi:");
        union.forEach(System.out::println);

        Set<Task> intersection = taskData.getIntersection(annTasks, bobTasks);
        System.out.println("\nAnn ve Bob'un ortak taskları:");
        intersection.forEach(System.out::println);

        // Örnek: StringSet unique words
        Set<String> uniqueWords = StringSet.findUniqueWords();
        System.out.println("\nUnique words count: " + uniqueWords.size());
        System.out.println("Some sample words: " + uniqueWords.stream().limit(10).toList());
    }
}
