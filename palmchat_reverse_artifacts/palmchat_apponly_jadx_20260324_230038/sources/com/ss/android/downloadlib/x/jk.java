package com.ss.android.downloadlib.x;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk {
    private static Map<String, u> u = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(String str);
    }

    private static u fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u.remove(str);
    }

    public static boolean nr(String str) {
        return com.ss.android.downloadlib.addownload.l.pn().u(com.ss.android.downloadlib.addownload.l.getContext(), str);
    }

    public static void u(String[] strArr, u uVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        u(strValueOf, uVar);
        TTDelegateActivity.u(strValueOf, strArr);
    }

    public static void u(String str) {
        u uVarFx;
        if (TextUtils.isEmpty(str) || (uVarFx = fx(str)) == null) {
            return;
        }
        uVarFx.u();
    }

    public static void u(String str, String str2) {
        u uVarFx;
        if (TextUtils.isEmpty(str) || (uVarFx = fx(str)) == null) {
            return;
        }
        uVarFx.u(str2);
    }

    private static void u(String str, u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        u.put(str, uVar);
    }
}
