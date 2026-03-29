package com.baidu.vi;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VIContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f4299a;

    public static Context getContext() {
        return f4299a;
    }

    public static void init(Context context) {
        f4299a = context;
    }
}
