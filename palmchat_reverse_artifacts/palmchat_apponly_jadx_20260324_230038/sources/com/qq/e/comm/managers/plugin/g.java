package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f10442a;
    private final File b;
    private String c;
    private int d;
    private String e;

    public g(File file, File file2) {
        this.f10442a = file;
        this.b = file2;
    }

    public boolean a(Context context, boolean z) {
        try {
            if (this.b.exists() && this.f10442a.exists()) {
                String strA = h.a(this.b);
                this.e = strA;
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                String[] strArrSplit = this.e.split("#####");
                if (strArrSplit.length == 2) {
                    String str = strArrSplit[1];
                    int iA = a(strArrSplit[0], 0);
                    if (c.a().a(str, this.f10442a)) {
                        this.c = str;
                        this.d = iA;
                        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z) {
                            return true;
                        }
                        if (!this.f10442a.canWrite() && !this.f10442a.canExecute()) {
                            return this.f10442a.canRead();
                        }
                        return this.f10442a.setReadOnly();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String a() {
        return this.c;
    }

    public boolean a(File file, File file2, Context context) {
        if (file == null || file2 == null) {
            return false;
        }
        if (file.equals(this.f10442a) || h.a(this.f10442a, file, context, true)) {
            return file2.equals(this.b) || h.a(this.b, file2, context, false);
        }
        return false;
    }

    private int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }
}
