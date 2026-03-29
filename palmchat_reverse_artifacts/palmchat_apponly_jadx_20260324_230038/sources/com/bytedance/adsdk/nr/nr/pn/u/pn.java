package com.bytedance.adsdk.nr.nr.pn.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn {
    private static Object u(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i - number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(((long) i) - number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i - number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) i) - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object u(long j, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(j - number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(j - number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(j - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Long.valueOf(j - ((long) number.intValue()));
    }

    private static Object u(float f, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f - number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(f - number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(((double) f) - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Float.valueOf(f - number.intValue());
    }

    private static Object u(double d, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Double.valueOf(d - number.longValue());
            }
            if (number instanceof Float) {
                return Double.valueOf(d - ((double) number.floatValue()));
            }
            if (number instanceof Double) {
                return Double.valueOf(d - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return Double.valueOf(d - ((double) number.intValue()));
    }

    public static Object u(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return u(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return u(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return u(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
        }
        return u(number.intValue(), number2);
    }
}
