package com.huawei.hms.ads.uiengineloader;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class p extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6634a = "p";

    @Override // com.huawei.hms.ads.uiengineloader.o
    public final void a() {
    }

    @Override // com.huawei.hms.ads.uiengineloader.o
    public final void a(Context context) {
        try {
            context.getClassLoader().loadClass("com.huawei.hms.ads.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, context);
        } catch (Exception e) {
            af.b(f6634a, "failed to init Module " + e.getClass().getSimpleName());
        }
    }
}
