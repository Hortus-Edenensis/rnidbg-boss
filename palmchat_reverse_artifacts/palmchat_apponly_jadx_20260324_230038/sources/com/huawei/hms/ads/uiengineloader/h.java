package com.huawei.hms.ads.uiengineloader;

import dalvik.system.DexClassLoader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class h extends DexClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6629a = "h";

    public h(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                af.c(f6629a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z);
    }
}
