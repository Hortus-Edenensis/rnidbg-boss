package j$.time.format;

import com.umeng.commonsdk.internal.a;

/* JADX INFO: loaded from: classes2.dex */
public enum TextStyle {
    FULL(2, 0),
    FULL_STANDALONE(a.g, 0),
    SHORT(1, 1),
    SHORT_STANDALONE(a.f, 1),
    NARROW(4, 1),
    NARROW_STANDALONE(a.i, 1);

    private final int calendarStyle;
    private final int zoneNameStyleIndex;

    TextStyle(int i, int i2) {
        this.calendarStyle = i;
        this.zoneNameStyleIndex = i2;
    }
}
