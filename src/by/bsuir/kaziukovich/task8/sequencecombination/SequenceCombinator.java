package by.bsuir.kaziukovich.task8.sequencecombination;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class containing methods to combine two sequences of real numbers and show theirs position in new sequence
 */
public class SequenceCombinator {
    /**
     * Adds new key-value pair to Map
     * @param map Map to be modified
     * @param value Number value (key of map)
     * @param sequenceType Sequence type (part of value of map)
     */
    private static void addToSequenceTypeMap(Map<Double, List<SequenceType>> map, double value, SequenceType sequenceType) {
        if (map.containsKey(value)) {
            map.get(value).add(sequenceType);
        } else {
            ArrayList<SequenceType> sequenceTypeList = new ArrayList<>();

            sequenceTypeList.add(sequenceType);
            map.put(value, sequenceTypeList);
        }
    }

    /**
     * Creates new Map by sequence and sequence type
     * @param sequence Sequence to be converted
     * @param sequenceType Sequence type
     * @return Created map
     */
    private static Map<Double, List<SequenceType>> doubleArrayToSequenceTypeMap(double[] sequence, SequenceType sequenceType) {
        LinkedHashMap<Double, List<SequenceType>> result = new LinkedHashMap<>();

        if ((sequence == null) || (sequenceType == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        for (double value : sequence) {
            addToSequenceTypeMap(result, value, sequenceType);
        }
        return result;
    }

    /**
     * Checks whether provided array is sorted
     * @param array Array to check
     * @return True if array is sorted, otherwise false
     */
    private static boolean isArraySorted(double[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates new sequence by two other, with providing positions for elements of old sequences
     * @param sequenceA Sequence A
     * @param sequenceB Sequence B
     * @return Created combined sequence
     */
    public static Map<Double, List<SequenceType>> getCombinedSequences(double[] sequenceA, double[] sequenceB) {
        LinkedHashMap<Double, List<SequenceType>> resultMap = new LinkedHashMap<>();
        int aIndex = 0, bIndex = 0;

        if ((sequenceA == null) || (sequenceB == null)) {
            throw new IllegalArgumentException("Sequences shouldn't be null");
        }
        if (!isArraySorted(sequenceA) || !isArraySorted(sequenceB)) {
            throw new IllegalArgumentException("Sequences should be sorted");
        }
        if (sequenceA.length == 0) {
            return doubleArrayToSequenceTypeMap(sequenceB, SequenceType.SEQUENCE_B);
        }
        if (sequenceB.length == 0) {
            return doubleArrayToSequenceTypeMap(sequenceA, SequenceType.SEQUENCE_A);
        }

        while ((aIndex < sequenceA.length) && (bIndex < sequenceB.length)) {
            if (sequenceA[aIndex] <= sequenceB[bIndex]) {
                addToSequenceTypeMap(resultMap, sequenceA[aIndex], SequenceType.SEQUENCE_A);
                aIndex++;
            } else {
                addToSequenceTypeMap(resultMap, sequenceB[bIndex], SequenceType.SEQUENCE_B);
                bIndex++;
            }
        }
        while (aIndex < sequenceA.length) {
            addToSequenceTypeMap(resultMap, sequenceA[aIndex], SequenceType.SEQUENCE_A);
            aIndex++;
        }
        while (bIndex < sequenceB.length) {
            addToSequenceTypeMap(resultMap, sequenceB[bIndex], SequenceType.SEQUENCE_B);
            bIndex++;
        }
        return resultMap;
    }

    /**
     * Constructor to avoid object creation
     */
    private SequenceCombinator() {}
}
