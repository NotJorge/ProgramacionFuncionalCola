import models.Process;
import repository.FunctionalQueue;
import repository.IFunctionalQueue;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        System.out.println("---------------------ENTEROS---------------------");
        System.out.println();
        runIntegerQueue();
        System.out.println();

        System.out.println("---------------------PROCESOS---------------------");
        System.out.println();
        runProcessQueue();
        System.out.println();

        System.out.println("---------------------STRINGS---------------------");
        System.out.println();
        runStringQueue();
    }

    private static void runIntegerQueue() {
        IFunctionalQueue<Integer> intQueue = new FunctionalQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            intQueue.push(random.nextInt(100));
        }

        System.out.println("Cola original: " + intQueue);

        System.out.println("Cola filtrada: " + intQueue.filter(x -> x > 50));

        System.out.println("Cola mapeada: " + intQueue.map(x -> x * 2));

        System.out.println("Primer elemento que cumple con el predicado: " + intQueue.find(x -> x > 50));

        System.out.println("Índice del primer elemento que cumple con el predicado: " + intQueue.findIndex(x -> x > 50));

        System.out.println("Último elemento que cumple con el predicado: " + intQueue.findLast(x -> x > 50));

        System.out.println("Índice del ultimo elemento que cumple con el predicado: " + intQueue.findLastIndex(x -> x > 50));

        System.out.println("Cola ordenada: " + intQueue.sort(x -> x));
    }

    private static void runProcessQueue() {
        IFunctionalQueue<Process> processQueue = new FunctionalQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Process process = Process.builder()
                    .name("P" + i)
                    .priority(random.nextInt(10))
                    .quantum(random.nextInt(101))
                    .build();
            processQueue.push(process);
        }

        System.out.println("Cola original: " + processQueue);

        System.out.println("Cola filtrada: " + processQueue.filter(x -> x.getPriority() > 5));

        System.out.println("Cola mapeada: " + processQueue.map(x -> x.getName().toLowerCase()));

        System.out.println("Primer elemento que cumple con el predicado: " + processQueue.find(x -> x.getPriority() > 5));

        System.out.println("Índice del primer elemento que cumple con el predicado: " + processQueue.findIndex(x -> x.getPriority() > 5));

        System.out.println("Último elemento que cumple con el predicado: " + processQueue.findLast(x -> x.getPriority() > 5));

        System.out.println("Índice del ultimo elemento que cumple con el predicado: " + processQueue.findLastIndex(x -> x.getPriority() > 5));

        System.out.println("Cola ordenada: " + processQueue.sort(Process::getPriority));
    }

    private static void runStringQueue() {
        IFunctionalQueue<String> stringQueue = new FunctionalQueue<>();
        for (int i = 1; i <= 10; i++) {
            stringQueue.push("String " + i);
        }

        System.out.println("Cola original: " + stringQueue);

        System.out.println("Cola filtrada: " + stringQueue.filter(x -> x.length() > 8));

        System.out.println("Cola mapeada: " + stringQueue.map(String::toUpperCase));

        System.out.println("Primer elemento que cumple con el predicado: " + stringQueue.find(x -> x.length() > 5));

        System.out.println("Índice del primer elemento que cumple con el predicado: " + stringQueue.findIndex(x -> x.length() > 5));

        System.out.println("Último elemento que cumple con el predicado: " + stringQueue.findLast(x -> x.length() > 5));

        System.out.println("Índice del último elemento que cumple con el predicado: " + stringQueue.findLastIndex(x -> x.length() > 5));

        System.out.println("Cola ordenada: " + stringQueue.sort(x -> x));

    }
}
