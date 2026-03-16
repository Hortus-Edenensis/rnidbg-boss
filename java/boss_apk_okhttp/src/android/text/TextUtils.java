package android.text;

public final class TextUtils {
    private TextUtils() {}

    public static boolean isEmpty(CharSequence value) {
        return value == null || value.length() == 0;
    }

    public static boolean equals(CharSequence left, CharSequence right) {
        if (left == right) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.toString().contentEquals(right);
    }
}
