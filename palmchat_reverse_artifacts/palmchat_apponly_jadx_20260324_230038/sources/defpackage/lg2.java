package defpackage;

import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lg2 {
    public static HandlerThread a(String str) {
        return b(str, 0);
    }

    public static HandlerThread b(String str, int i) {
        return new HandlerThread("LXHT#" + str, i);
    }
}
