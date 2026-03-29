package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class IntentUtils {
    static HashMap<Long, WeakReference<Bundle>> u = new HashMap<>();

    @Keep
    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void u(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            u(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void u(long j, Bundle bundle) {
        u.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void u(Intent intent) {
        Bundle bundleU;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleU = u(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleU);
    }

    private static Bundle u(long j) {
        WeakReference<Bundle> weakReferenceRemove = u.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
