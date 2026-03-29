package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class af {
    private static AtomicInteger beA = new AtomicInteger(0);
    private static volatile boolean beB = false;
    private static volatile boolean beC;

    private static int RT() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int iDs = hVar.Ds();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + iDs);
        return iDs;
    }

    private static void RU() {
        if (beB) {
            return;
        }
        beA.set(RX());
        beC = bo.m("kssdk_kv_mode", "downgrade", false);
        beB = true;
    }

    public static void RV() {
        if (RY() || RT() == 0) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.utils.b.a aVarRW = af.RW();
                if (aVarRW == null) {
                    return;
                }
                af.c(aVarRW);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(aVarRW);
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a RW() {
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences sharedPreferencesHF = bo.hF("ksadsdk_kv_perf");
        if (sharedPreferencesHF == null) {
            return null;
        }
        try {
            Map<String, ?> all = sharedPreferencesHF.getAll();
            if (all == null) {
                return null;
            }
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
            aVar.bhQ = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesHF.edit();
            Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
            while (it2.hasNext()) {
                editorEdit.putInt(it2.next().getKey(), 0);
            }
            editorEdit.apply();
            d(aVar);
            e(aVar);
        } catch (Throwable unused) {
        }
        return aVar;
    }

    private static int RX() {
        int iC = bo.c("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + iC);
        return iC;
    }

    private static boolean RY() {
        RU();
        return beA.get() == 0;
    }

    private static boolean RZ() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int Sa() {
        RU();
        int iRT = (beC || !RZ()) ? 0 : RT();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + iRT);
        return iRT;
    }

    public static void Sb() {
        RU();
        int i = beA.get();
        int iSa = Sa();
        boolean z = i != iSa;
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(iSa);
        }
    }

    private static void Sc() {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context == null) {
                        return;
                    }
                    Iterator<String> it = i.a.awr.iterator();
                    while (it.hasNext()) {
                        af.U(context, it.next());
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                af.fh(0);
                af.beA.set(0);
            }
        });
    }

    private static void Sd() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.awr.iterator();
                        while (it.hasNext()) {
                            af.T(context, it.next());
                        }
                        af.fh(1);
                        af.beA.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Context context, String str) {
        SharedPreferences sharedPreferencesHF;
        com.kwad.sdk.utils.a.c cVarAB = com.kwad.sdk.utils.a.e.aB(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (sharedPreferencesHF = bo.hF(str)) == null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesHF.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (cVarAB.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences sharedPreferencesHF2 = bo.hF(str);
        if (sharedPreferencesHF2 == null) {
            cVarAB.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        cVarAB.putAll(sharedPreferencesHF2.getAll());
        cVarAB.putBoolean("sp_to_kv_transfer_flag", true);
        bo.ax(str, "kv_to_sp_transfer_flag");
        a(str, cVarAB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U(Context context, String str) {
        SharedPreferences sharedPreferencesHF = bo.hF(str);
        if (sharedPreferencesHF == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesHF.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (sharedPreferencesHF.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c cVarAB = com.kwad.sdk.utils.a.e.aB(context, str);
        Map<String, Object> all = cVarAB.getAll();
        if (all.isEmpty()) {
            bo.l(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bo.a(str, all);
        bo.l(str, "kv_to_sp_transfer_flag", true);
        cVarAB.remove("sp_to_kv_transfer_flag");
        cVarAB.release();
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (i.a.aws.contains(str)) {
            return;
        }
        cVar.release();
    }

    @WorkerThread
    public static void au(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    int iC = bo.c("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bo.ax("ksadsdk_kv_perf", str);
                    } else {
                        bo.b("ksadsdk_kv_perf", str, iC + 1);
                    }
                } catch (Exception e) {
                    bo.ax("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        });
    }

    public static void av(final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.utils.af.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                SharedPreferences sharedPreferencesHF = bo.hF("ksadsdk_kv_perf");
                if (sharedPreferencesHF != null && sharedPreferencesHF.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bo.b("ksadsdk_kv_perf_failed", str, bo.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bo.b("ksadsdk_kv_perf_success", str, bo.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        int i = aVar.bhR;
        if (((double) i) / ((double) (i + aVar.bhS)) > 0.10000000149011612d) {
            beC = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bo.l("kssdk_kv_mode", "downgrade", true);
        }
        if (beC) {
            Sb();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesHF = bo.hF("ksadsdk_kv_perf_failed");
        int iIntValue = 0;
        if (sharedPreferencesHF == null) {
            aVar.bhR = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesHF.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bhR = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesHF.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesHF = bo.hF("ksadsdk_kv_perf_success");
        int iIntValue = 0;
        if (sharedPreferencesHF == null) {
            aVar.bhS = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesHF.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bhS = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesHF.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public static void fh(int i) {
        bo.b("kssdk_kv_mode", "mode", i);
    }

    private static boolean hm(String str) {
        return i.a.awr.contains(str);
    }

    public static boolean hn(String str) {
        boolean z = RY() || !hm(str);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "shouldUseModeSp:" + z);
        return z;
    }

    private static void transfer(int i) {
        if (i == 0) {
            Sc();
        } else if (i == 1) {
            Sd();
        }
    }
}
