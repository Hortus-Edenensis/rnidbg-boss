package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static Map<String, WeakReference<C0616a>> aOe = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0616a {
        private HandlerThread aOf;
        private Handler iK;

        public C0616a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aOf = handlerThread;
            handlerThread.start();
            this.iK = new Handler(this.aOf.getLooper());
        }

        public final Handler getHandler() {
            return this.iK;
        }
    }

    public static synchronized Handler La() {
        return eR("reportHT").getHandler();
    }

    @NonNull
    private static C0616a eR(String str) {
        WeakReference<C0616a> weakReference = aOe.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0616a c0616a = new C0616a(str);
        aOe.put(str, new WeakReference<>(c0616a));
        return c0616a;
    }
}
