package com.amap.api.col.p0002sl;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2906a;
    private gd b;
    private String c;

    public ii(Context context, gd gdVar, String str) {
        this.f2906a = context.getApplicationContext();
        this.b = gdVar;
        this.c = str;
    }

    public final byte[] a() {
        return ge.a(a(this.f2906a, this.b, this.c));
    }

    private static String a(Context context, gd gdVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(gdVar.c());
            sb.append("\",\"product\":\"");
            sb.append(gdVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(fv.c(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
