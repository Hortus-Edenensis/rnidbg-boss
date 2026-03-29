package com.tencent.turingfd.sdk.ams.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TNative$aa {
    public static native SparseArray<Object> a90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i);

    public static native SparseArray<Object> b90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i);

    public static native SparseArray<Object> c90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, int i);

    public static native SparseArray<Object> e90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> f90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, byte[] bArr, int i);

    public static native SparseArray<Object> g90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> h90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

    public static native SparseArray<Object> i90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Object obj, Object obj2, Object obj3);

    public static native String j90_9F87DFDD2CC93068();

    public static native byte[] k90_9F87DFDD2CC93068(byte[] bArr);

    public static native void l90_9F87DFDD2CC93068(InvocationHandler invocationHandler, AtomicReference<Object> atomicReference, ClassLoader classLoader);

    public static native SparseArray<Object> m90_9F87DFDD2CC93068(SparseArray<Object> sparseArray, Context context, Map<String, String> map);

    /* JADX INFO: compiled from: SearchBox */
    public static class bb implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
