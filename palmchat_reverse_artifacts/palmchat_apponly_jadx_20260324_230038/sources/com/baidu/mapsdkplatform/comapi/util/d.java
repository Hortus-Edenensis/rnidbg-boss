package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.mapsdkplatform.comapi.Initializer;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4012a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    public d(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null || !externalFilesDir.exists()) {
                this.b = context.getFilesDir().getPath();
            } else {
                this.b = externalFilesDir.getPath();
            }
        } else if (Initializer.isAgreePrivacyMode()) {
            this.b = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            this.b = context.getFilesDir().getAbsolutePath();
        }
        this.f4012a = false;
        this.c = this.b + File.separator + "BaiduMapSDKNew";
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = "";
        this.f = "";
    }

    public String a() {
        return this.b + File.separator + "BaiduMapSDKNew";
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.b.equals(((d) obj).b);
    }
}
