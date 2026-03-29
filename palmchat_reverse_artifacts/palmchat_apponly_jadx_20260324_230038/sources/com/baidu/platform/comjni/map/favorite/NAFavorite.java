package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NAFavorite extends JNIBaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4263a = 0;

    private native boolean nativeAdd(long j, String str, String str2);

    private native boolean nativeClear(long j);

    private native boolean nativeCloseCache(long j);

    private native long nativeCreate();

    private native boolean nativeDelete(long j);

    private native int nativeGetAll(long j, Bundle bundle);

    private native int nativeGetLength(long j);

    private native int nativeGetRelations(long j, String str, Bundle bundle, int i);

    private native String nativeGetValue(long j, String str);

    private native boolean nativeIsExist(long j, String str);

    private native boolean nativeLoad(long j, String str, String str2, String str3, int i, int i2, int i3);

    private native int nativeRelease(long j);

    private native boolean nativeRemove(long j, String str);

    private native boolean nativeResumeCache(long j);

    private native boolean nativeSaveCache(long j);

    private native boolean nativeSetType(long j, int i);

    private native boolean nativeUpdate(long j, String str, String str2);

    private native boolean nativeUpdateInOrder(long j, String str, String str2);

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeLoad(j, str, str2, str3, i, i2, i3);
    }

    public long b() {
        long jNativeCreate = nativeCreate();
        this.f4263a = jNativeCreate;
        return jNativeCreate;
    }

    public int c() {
        return nativeRelease(this.f4263a);
    }

    public boolean d() {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeSaveCache(j);
    }

    public boolean b(String str, String str2) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeUpdate(j, str, str2);
    }

    public boolean c(String str) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeRemove(j, str);
    }

    public boolean a(int i) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeSetType(j, i);
    }

    public boolean b(String str) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        try {
            return nativeIsExist(j, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(String str, String str2) {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeAdd(j, str, str2);
    }

    public boolean a() {
        long j = this.f4263a;
        if (j == 0) {
            return false;
        }
        return nativeClear(j);
    }

    public String a(String str) {
        long j = this.f4263a;
        if (j == 0) {
            return null;
        }
        try {
            return nativeGetValue(j, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public int a(Bundle bundle) {
        long j = this.f4263a;
        if (j == 0) {
            return 0;
        }
        try {
            return nativeGetAll(j, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
