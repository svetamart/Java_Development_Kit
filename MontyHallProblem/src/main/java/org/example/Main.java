package org.example;

import org.apache.commons.math3.stat.Frequency;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> resultsChanged = new HashMap<>();
        Map<Integer, String> resultsUnchanged = new HashMap<>();

        for (int i = 1; i <= 500; i++) {
            List<String> doors = initializeDoors();
            int playerChoice = chooseDoor(doors);
            int revealedDoor = revealGoat(doors, playerChoice);
            int finalChangedChoice = changeDoor(doors, playerChoice, revealedDoor);

            String resultChanged = doors.get(finalChangedChoice);
            resultsChanged.put(i, resultChanged);

            String resultUnchanged = doors.get(playerChoice);
            resultsUnchanged.put(i, resultUnchanged);
        }

        writeResultsAndStatistics("changed_results.txt", resultsChanged, "Changed decision");
        writeResultsAndStatistics("unchanged_results.txt", resultsUnchanged, "Unchanged decision");
    }

    private static void writeResultsAndStatistics(String filename, Map<Integer, String> results, String label) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Integer, String> entry : results.entrySet()) {
                writer.write("Step " + entry.getKey() + ": " + entry.getValue() + "\n");
            }
            calculateStatistics(results, writer, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateStatistics(Map<Integer, String> results, BufferedWriter writer, String label) throws IOException {
        Frequency frequency = new Frequency();
        results.values().forEach(frequency::addValue);

        writer.write("\nStatistics for " + label + ":\n");
        writer.write("Positive results: " + frequency.getCount("car") + "\n");
        writer.write("Negative results: " + frequency.getCount("goat") + "\n");
        writer.write("Percentage of positive results: " + frequency.getPct("car") * 100 + "%\n");
        writer.write("Percentage of negative results: " + frequency.getPct("goat") * 100 + "%\n");
    }
    private static List<String> initializeDoors() {
        List<String> doors = new ArrayList<>();
        doors.add("car");
        doors.add("goat");
        doors.add("goat");
        Collections.shuffle(doors);
        return doors;
    }

    public static int revealGoat (List<String> list, int initial) {
        return IntStream.range(0, list.size())
                .filter(i -> i != initial && list.get(i).equals("goat"))
                .findFirst()
                .orElse(3);

    };

    public static int chooseDoor (List<String> list) {
        Random rand = new Random();
        return rand.nextInt(list.size());
    };
    
    public static int changeDoor (List<String> list, int revealed, int initial) {
        return IntStream.range(0, list.size())
                .filter(i -> i != initial && i != revealed)
                .findFirst()
                .orElse(3);
        }
}