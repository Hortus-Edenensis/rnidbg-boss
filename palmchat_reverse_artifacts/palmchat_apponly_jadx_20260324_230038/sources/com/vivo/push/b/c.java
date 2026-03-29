package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11197a;
    private String b;
    private long c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;

    public c(int i, String str) {
        super(i);
        this.c = -1L;
        this.d = -1;
        this.f11197a = null;
        this.b = str;
    }

    public final int a(Context context) {
        if (this.d == -1) {
            String strA = this.b;
            if (TextUtils.isEmpty(strA)) {
                com.vivo.push.util.t.a("BaseAppCommand", "pkg name is null");
                strA = a();
                if (TextUtils.isEmpty(strA)) {
                    com.vivo.push.util.t.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.d = com.vivo.push.util.z.b(context, strA);
            if (!TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final int d() {
        return this.e;
    }

    public final void e() {
        this.f = null;
    }

    public final String f() {
        return this.f11197a;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.f11197a = str;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(ReportItem.RequestKeyRequestId, this.f11197a);
        dVar.a("package_name", this.b);
        dVar.a("sdk_version", 354L);
        dVar.a("PUSH_APP_STATUS", this.d);
        if (!TextUtils.isEmpty(this.f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.g);
    }

    public final void d(String str) {
        this.g = str;
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f11197a = dVar.a(ReportItem.RequestKeyRequestId);
        this.b = dVar.a("package_name");
        this.c = dVar.b("sdk_version", 0L);
        this.d = dVar.b("PUSH_APP_STATUS", 0);
        this.f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
