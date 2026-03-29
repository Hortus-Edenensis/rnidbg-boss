package com.bytedance.sdk.openadsdk.core.h;

import com.bytedance.sdk.openadsdk.core.bg;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class iz {
    private static final String u = "iz";
    private final Set<String> nr = new HashSet(1);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.h.iz$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[b.values().length];
            u = iArr;
            try {
                iArr[b.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[b.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[b.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public synchronized boolean nr(String str) {
        return true;
    }

    public abstract void u();

    public abstract void u(String str);

    public final synchronized boolean u(String str, int i) {
        if (i == 0) {
            return u(str, b.GRANTED);
        }
        return u(str, b.DENIED);
    }

    public final synchronized boolean u(final String str, b bVar) {
        this.nr.remove(str);
        int i = AnonymousClass5.u[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.iz.2
                    @Override // java.lang.Runnable
                    public void run() {
                        iz.this.u(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (nr(str)) {
                    if (this.nr.isEmpty()) {
                        bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.iz.3
                            @Override // java.lang.Runnable
                            public void run() {
                                iz.this.u();
                            }
                        });
                        return true;
                    }
                } else {
                    bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.iz.4
                        @Override // java.lang.Runnable
                        public void run() {
                            iz.this.u(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.nr.isEmpty()) {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    iz.this.u();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void u(String[] strArr) {
        Collections.addAll(this.nr, strArr);
    }
}
