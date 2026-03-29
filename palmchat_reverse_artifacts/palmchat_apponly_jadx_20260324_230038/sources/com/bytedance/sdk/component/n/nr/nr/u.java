package com.bytedance.sdk.component.n.nr.nr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.iz;
import com.bytedance.sdk.component.n.u.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static boolean b(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.pn())) ? false : true;
    }

    public static boolean fx(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.b())) ? false : true;
    }

    public static boolean iz(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.iz())) ? false : true;
    }

    private static long nr(int i, Context context, pn pnVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / 1048576;
        long jMaxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            return jFreeMemory <= 10 ? Math.min(i, 10) : Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        return j <= 10 ? Math.min(i, 10) : Math.min(j * 10, i);
    }

    public static boolean pn(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.fx())) ? false : true;
    }

    public static long u(int i, Context context, pn pnVar) {
        return nr(i, context, pnVar);
    }

    public static boolean u(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.u())) ? false : true;
    }

    public static boolean nr(pn pnVar) {
        iz izVarNr = pnVar.nr();
        return (izVarNr == null || TextUtils.isEmpty(izVarNr.nr())) ? false : true;
    }
}
