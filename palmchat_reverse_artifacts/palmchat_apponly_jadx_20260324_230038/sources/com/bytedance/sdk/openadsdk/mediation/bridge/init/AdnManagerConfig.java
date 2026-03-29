package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.iz;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AdnManagerConfig {
    private static volatile Function<SparseArray<Object>, Object> b;
    private static volatile Function<SparseArray<Object>, Object> fx;
    private static volatile Function<SparseArray<Object>, Object> iz;
    private static volatile Function<SparseArray<Object>, Object> n;
    private static volatile Function<SparseArray<Object>, Object> nr;
    private static volatile Function<SparseArray<Object>, Object> pn;
    private static volatile Function<SparseArray<Object>, Object> u;
    private static volatile Function<SparseArray<Object>, Object> x;

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    public static boolean initAdnManager(String str, String str2) {
        return u(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean u(String str, String str2) {
        Function<SparseArray<Object>, Object> function;
        if (str2 == null) {
            return false;
        }
        try {
            Object objNewInstance = Class.forName(str).newInstance();
            if (objNewInstance instanceof Function) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, 9000);
                sparseArray.put(-99999985, Object.class);
                Object objApply = ((Function) objNewInstance).apply(sparseArray);
                if (objApply instanceof Function) {
                    function = (Function) objApply;
                    switch (str2) {
                        case "ks":
                            b = function;
                            return true;
                        case "gdt":
                            fx = function;
                            return true;
                        case "baidu":
                            nr = function;
                            return true;
                        case "mintegral":
                            pn = function;
                            return true;
                        case "admob":
                            u = function;
                            return true;
                        case "sigmob":
                            iz = function;
                            return true;
                        case "unity":
                            x = function;
                            return true;
                        case "xiaomi":
                            n = function;
                            return true;
                        default:
                            return true;
                    }
                }
            }
        } catch (Throwable th) {
            iz.u(th);
        }
        return false;
    }
}
