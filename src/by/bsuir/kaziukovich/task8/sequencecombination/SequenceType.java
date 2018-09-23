package by.bsuir.kaziukovich.task8.sequencecombination;

/**
 * Enum to describe type of sequence
 */
public enum SequenceType {
    SEQUENCE_A("Sequence A"), SEQUENCE_B("Sequence B");

    /**
     * String representation of enum value
     */
    private final String name;

    /**
     * Returns string representation of enum value
     * @return String representation of enum value
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Automatic constructor of enum
     * @param s Enum value name
     */
    SequenceType(String s) {
        name = s;
    }
}
