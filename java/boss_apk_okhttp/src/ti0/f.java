package ti0;

public final class f {
    private static long lastSortMessageId = 0L;

    private f() {}

    public static long o() {
        return lastSortMessageId;
    }

    public static void setLastSortMessageId(long value) {
        lastSortMessageId = value;
    }
}
