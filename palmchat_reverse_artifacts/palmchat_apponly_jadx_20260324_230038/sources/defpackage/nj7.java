package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nj7 {
    public static Float a(Map<? super String, Float> map) {
        float fFloatValue = 0.0f;
        for (Float f : map.values()) {
            if (f != null) {
                fFloatValue += f.floatValue();
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static Long b(Map<? super String, Long> map, String str, Long l) {
        if (str == null || map == null) {
            return -1L;
        }
        Long l2 = map.get(str);
        if (l2 != null) {
            l = Long.valueOf(l2.longValue() + l.longValue());
        }
        map.put(str, l);
        return l;
    }

    public static boolean c(int i) {
        return false;
    }

    public static int d(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 16;
        }
        if (i == 3) {
            return 32;
        }
        if (i != 4) {
            return i != 5 ? 0 : 128;
        }
        return 64;
    }
}
