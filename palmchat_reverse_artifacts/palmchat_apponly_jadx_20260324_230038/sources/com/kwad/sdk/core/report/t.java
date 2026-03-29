package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class t {
    private static String aME = Kx();
    private static long aMF = 0;
    private static Context aMG;

    public static String Kt() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String strKx = Kx();
        aME = strKx;
        return strKx;
    }

    public static String Ku() {
        return aME;
    }

    @WorkerThread
    public static long Kv() {
        long jBN = bN(aMG);
        b(aMG, 1 + jBN);
        return jBN;
    }

    public static long Kw() {
        return aMF;
    }

    private static String Kx() {
        return UUID.randomUUID().toString();
    }

    @WorkerThread
    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        editorEdit.putLong("seq", j);
        return editorEdit.commit();
    }

    @WorkerThread
    private static long bN(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static void init(Context context) {
        aMG = context;
    }
}
