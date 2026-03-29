package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aDd = new ConcurrentHashMap();
    private static SharedPreferences aDe = null;

    private static SharedPreferences GC() {
        if (aDe == null) {
            aDe = bo.hF("ksadsdk_config");
        }
        return aDe;
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> setDL = dL(key);
        if (setDL == null) {
            setDL = new CopyOnWriteArraySet<>();
            aDd.put(key, setDL);
        }
        setDL.add(bVar);
    }

    @WorkerThread
    public static synchronized void bA(Context context) {
        SharedPreferences sharedPreferencesGC = GC();
        if (sharedPreferencesGC != null) {
            a(sharedPreferencesGC);
        }
    }

    @WorkerThread
    public static synchronized void bz(Context context) {
        try {
            SharedPreferences sharedPreferencesGC = GC();
            if (sharedPreferencesGC != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesGC.edit();
                a(editorEdit);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> dL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aDd.get(str);
    }

    public static void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aDd.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aDd.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.l(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = aDd.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aDd.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = aDd.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aDd.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences sharedPreferencesGC;
        if (bVar == null || (sharedPreferencesGC = GC()) == null) {
            return;
        }
        try {
            bVar.a(sharedPreferencesGC);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
