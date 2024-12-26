package org.example;

import java.util.List;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        RandomGenerator rand = RandomGenerator.getDefault();
        List<Integer> intList = rand.ints(150, 0, 100).boxed().toList();
        System.out.print("Список цілочисленних чисел : ");
        printList(intList);
        System.out.println("\nЗА ДОПОМОГОЮ STREAM API: \n");
        tasks(intList, new StreamAPITasks());
        System.out.println("\nЗА ДОПОМОГОЮ PARALLEL STREAM: \n");
        tasks(intList, new ParallelStreamAPITasks());
    }

    static void tasks(List<Integer> list, IIntStreamTasks operator) {
        int sum = operator.sumofInts(list);
        System.out.printf("Сума інтових чисел: %d\n", sum);

        double avg = operator.findAverage(list);
        System.out.printf("Середнє значення: %.02f\n", avg);

        double dev = operator.findStandardDeviation(list);
        System.out.printf("Стандартне відхилення: %.02f\n", dev);

        List<Integer> multipliedBy2List = operator.multiplyBy2(list);
        System.out.print("Помножених на 2: ");
        printList(multipliedBy2List);

        List<Integer> filterDivisibleBy3List = operator.filterDivisibleBy3(list);
        System.out.print("Ділимих на 3: ");
        printList(filterDivisibleBy3List);
    }

    static void printList(List<Integer> list) {
        list.forEach(v -> System.out.printf("%d ", v));
        System.out.println();
    }

}