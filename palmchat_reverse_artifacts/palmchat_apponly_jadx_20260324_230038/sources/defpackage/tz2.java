package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tz2 {
    public static String a(int i) {
        if (i < 60) {
            if (i < 0 || i >= 10) {
                return "00:" + i;
            }
            return "00:0" + i;
        }
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 >= 10) {
            if (i3 < 10) {
                return i2 + ":0" + i3;
            }
            return i2 + ":" + i3;
        }
        if (i3 < 10) {
            return "0" + i2 + ":0" + i3;
        }
        return "0" + i2 + ":" + i3;
    }
}
