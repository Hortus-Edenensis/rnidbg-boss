package com.opos.cmn.an.f.c;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f7774a;

    public c(Class<?> cls) {
        this.f7774a = cls;
    }

    public Method a(String str, Class<?>... clsArr) {
        try {
            if (this.f7774a == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f7774a.getDeclaredMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
