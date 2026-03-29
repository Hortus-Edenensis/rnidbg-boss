package com.zm.adxsdk.tools;

import android.content.Context;
import android.os.Build;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static volatile g j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WfConfig f16604a;
    public IWfRuntime b;
    public ConcurrentHashMap c = new ConcurrentHashMap();
    public ArrayList d = new ArrayList();
    public ArrayList e = new ArrayList();
    public ArrayList f = new ArrayList();
    public ArrayList g = new ArrayList();
    public ArrayList h;
    public ArrayList i;

    public final void a(String str, String str2) {
        e eVar = new e();
        eVar.f16607a = str;
        eVar.b = str2;
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(eVar);
    }

    public final void b(String str, String str2) {
        h hVar = new h();
        hVar.f16607a = str;
        String[] strArr = c.f16599a;
        boolean z = false;
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (strArr[i].equals(str)) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        hVar.b = z;
        hVar.c = str2;
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(hVar);
    }

    public final void a(String str, boolean z) {
        h hVar = new h();
        hVar.f16607a = str;
        hVar.b = z;
        hVar.c = "必要";
        hVar.d = "";
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(hVar);
    }

    public static g a() {
        if (j == null) {
            synchronized (g.class) {
                if (j == null) {
                    j = new g();
                }
            }
        }
        return j;
    }

    public final void b(String str, boolean z) {
        p pVar = new p();
        pVar.f16607a = str;
        pVar.b = "建议传true";
        pVar.c = z;
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.h.add(pVar);
    }

    public final ArrayList a(Context context) {
        String[] strArr;
        ArrayList arrayList = this.f;
        if (arrayList != null && !arrayList.isEmpty()) {
            return this.f;
        }
        String[] strArr2 = c.f16599a;
        if (strArr2 == null || strArr2.length <= 0) {
            try {
                strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            } catch (Throwable th) {
                th.printStackTrace();
                strArr = null;
            }
            c.f16599a = strArr;
        }
        if (this.f == null) {
            this.f = new ArrayList();
        }
        b(f.d, "必要");
        b(f.e, "必要");
        b(f.f, Build.VERSION.SDK_INT < 30 ? "可选" : "必要");
        b(f.g, "可选");
        b(f.h, "可选");
        b(f.i, "可选");
        b(f.j, "可选");
        b(f.k, "可选");
        b(f.l, "可选");
        return this.f;
    }
}
