package defpackage;

import android.content.Context;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f17121a = {117, 125, 89, 80, 123, 103, 119, 99, 84};
    public static final byte[] b = {122, 115, 124, 95, 86, 124, 88, 100, 120, 93, 65, 107, 113, 85, 125, 89, 80, 90, 96, 119, ByteCompanionObject.MAX_VALUE, 87, 69, 125, 68, ByteCompanionObject.MAX_VALUE, 98, 68, 69, 119, 109, 100};
    public static final byte[] c = {81, 68, 125, 88, 100, 120, 93, 65, 107, 113, 85, 125, 89, 80, 90, 96, 119, ByteCompanionObject.MAX_VALUE, 87, 69, 125, 68, ByteCompanionObject.MAX_VALUE, 98, 68, 69, 119, 109, 100};
    public static final byte[] d = {120, 102, 114, 99, 95, 73, 125, 38, 117, 126, 94, 84, 124, 102, 98, Utf8.REPLACEMENT_BYTE, 115, 76, 112, 120, 116, 126, 81, 82, 125, 69, 119, ByteCompanionObject.MAX_VALUE, 81, 71, 124, 122, 50, 94, 94, 112, 107, 97, 123, 112, 66, 89, 90, 100, ByteCompanionObject.MAX_VALUE, 97, 115, 72, 120, 102, 113, 116, 84, 108, 112, 123, 98, 116, 94, 69, 107};
    public static final byte[] e = {103, 120, 65, 66, 73, 116, 105, 100, 104, 115, 76, 112, 120, 85, 121, 81, 78, 126, 109, 114};
    public static final byte[] f = {111, 115, 101, 96, 82, 112, 101, 119, 99, 73, 99, 117, 97, 102};
    public static final byte[] g = {113, 116, 68, 105, 109, 109, 123, 80, 68};
    public static final byte[] h = {67, 118, 109, 100, 114, 85, 116, 118, 92, 115, 105, 68};
    public static final byte[] i = {111, 115, 101, 116, 69, 106, 107, 100, 120, 64, 84, 112, 103, 120};
    public static final byte[] j = {71, 124, 124, 66, 120, 93, 69, 106, 124, 119, 124, 64};
    public static final byte[] k = {111, 115, 101, 124, 65, 123, 109, 122};
    public static final byte[] l = {65, 119, 108, 100, 126, 89, 68, 55, 107, 121, ByteCompanionObject.MAX_VALUE, 68, 69, 119, 124, 56, 82, 92, 73, 105, 76, 119, 101, 81};
    public static final byte[] m = {78, 124, ByteCompanionObject.MAX_VALUE, 70, 125, 81, 73, 119, 92, 115, 105, 68};
    public static final byte[] n = {123, 115, 101, 96, 82, 112, 101, 119, 99, 73, 99, 117, 97, 102};

    public static Object a(Object obj) {
        try {
            return pu4.c(obj, bf2.b(f), new Object[0], new Class[0]);
        } catch (Throwable th) {
            p63.f("CopyGuard", "getCopy failed e:" + th);
            return null;
        }
    }

    public static Object b(Object obj) {
        try {
            return pu4.c(obj, bf2.b(i), new Object[0], new Class[0]);
        } catch (Throwable th) {
            p63.f("CopyGuard", "getDesc failed e:" + th);
            return null;
        }
    }

    public static Object c(Context context) {
        return context.getSystemService(bf2.b(f17121a));
    }

    public static String d(Context context, Object obj) {
        try {
            return pu4.c(pu4.c(obj, bf2.b(g), new Object[]{0}, new Class[]{Integer.TYPE}), bf2.b(h), new Object[]{context}, new Class[]{Context.class}).toString();
        } catch (Throwable th) {
            p63.f("CopyGuard", "getString failed e:" + th);
            return null;
        }
    }

    public static long e(Object obj) {
        try {
            Object objC = pu4.c(obj, bf2.b(j), new Object[0], new Class[0]);
            if (objC instanceof Long) {
                return ((Long) objC).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            p63.f("CopyGuard", "getTime failed e:" + th);
            return 0L;
        }
    }
}
