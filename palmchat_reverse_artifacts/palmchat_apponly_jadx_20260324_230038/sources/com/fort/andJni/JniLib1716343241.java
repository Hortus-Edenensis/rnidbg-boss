package com.fort.andJni;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class JniLib1716343241 {
    static final boolean $assertionsDisabled = false;
    private static final String LIB_DIR = "lib";
    private static final String TAG = "LibraryLoaderHelper";
    private static boolean sLibrariesWereUnpacked;

    static {
        try {
            System.loadLibrary("dexvmp");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static boolean InvokeBoolean(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Boolean) method.invoke(obj, objArr2)).booleanValue();
    }

    public static byte InvokeByte(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Byte) method.invoke(obj, objArr2)).byteValue();
    }

    public static char InvokeChar(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Character) method.invoke(obj, objArr2)).charValue();
    }

    public static double InvokeDouble(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Double) method.invoke(obj, objArr2)).doubleValue();
    }

    public static float InvokeFloat(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Float) method.invoke(obj, objArr2)).floatValue();
    }

    public static int InvokeInt(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Integer) method.invoke(obj, objArr2)).intValue();
    }

    public static long InvokeLong(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Long) method.invoke(obj, objArr2)).longValue();
    }

    public static Object InvokeObject(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return method.invoke(obj, objArr2);
    }

    public static short InvokeShort(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        return ((Short) method.invoke(obj, objArr2)).shortValue();
    }

    public static void InvokeVoid(Object... objArr) throws Exception {
        Object obj = objArr[0];
        Method method = (Method) objArr[1];
        Object[] objArr2 = new Object[objArr.length - 2];
        for (int i = 0; i < objArr.length - 2; i++) {
            objArr2[i] = objArr[i + 2];
        }
        method.invoke(obj, objArr2);
    }

    public static native void a(Class cls, int i);

    public static native byte cB(Object... objArr);

    public static native char cC(Object... objArr);

    public static native double cD(Object... objArr);

    public static native float cF(Object... objArr);

    public static native int cI(Object... objArr);

    public static native long cJ(Object... objArr);

    public static native Object cL(Object... objArr);

    public static native short cS(Object... objArr);

    public static native void cV(Object... objArr);

    public static native boolean cZ(Object... objArr);
}
