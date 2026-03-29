package cn.jiguang.api;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLogger {
    public final void a(int i, boolean z, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, getCommonTag(), 18, str, null, Integer.valueOf(i), Boolean.valueOf(z), str2, th);
    }

    public void d(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public void dd(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public void ee(String str, String str2) {
        a(6, false, str, str2, null);
    }

    public abstract String getCommonTag();

    public void i(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public void ii(String str, String str2) {
        a(4, false, str, str2, null);
    }

    public void v(String str, String str2) {
        a(2, true, str, str2, null);
    }

    public void vv(String str, String str2) {
        a(2, false, str, str2, null);
    }

    public void w(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public void ww(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        a(3, true, str, str2, th);
    }

    public void dd(String str, String str2, Throwable th) {
        a(3, false, str, str2, th);
    }

    public void e(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public void ee(String str, String str2, Throwable th) {
        a(6, false, str, str2, th);
    }

    public void i(String str, String str2, Throwable th) {
        a(4, true, str, str2, th);
    }

    public void ii(String str, String str2, Throwable th) {
        a(4, false, str, str2, th);
    }

    public void v(String str, String str2, Throwable th) {
        a(2, true, str, str2, th);
    }

    public void vv(String str, String str2, Throwable th) {
        a(2, false, str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        a(5, true, str, str2, th);
    }

    public void ww(String str, String str2, Throwable th) {
        a(5, false, str, str2, th);
    }

    public static void flushCached2File() {
    }

    public void _d(String str, String str2, Object... objArr) {
    }
}
