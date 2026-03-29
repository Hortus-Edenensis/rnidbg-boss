package com.ss.android.downloadlib.pn;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {

    /* JADX INFO: compiled from: SearchBox */
    public interface u<T> {
        T nr();
    }

    public static <T> T u(boolean z, String str, @NonNull u<T> uVar) {
        try {
            return uVar.nr();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.pn.u) {
                throw th;
            }
            fx.u().u(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T u(u<T> uVar) {
        return (T) u(true, null, uVar);
    }

    public static void u(final Runnable runnable) {
        u(new u<Void>() { // from class: com.ss.android.downloadlib.pn.nr.1
            @Override // com.ss.android.downloadlib.pn.nr.u
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Void nr() {
                runnable.run();
                return null;
            }
        });
    }
}
