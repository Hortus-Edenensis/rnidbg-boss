package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7910a;
    protected boolean b = false;
    protected boolean c;
    protected String d;

    public a(Context context, String str, boolean z) {
        this.f7910a = context;
        this.d = str;
        this.c = z;
    }

    @JavascriptInterface
    public boolean init(String str) {
        if (!this.b) {
            try {
                if (this.c) {
                    String str2 = this.d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("src=");
                    sb.append(str != null ? str : com.igexin.push.core.b.m);
                    sb.append("jsSign=");
                    sb.append(str2);
                    com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
                    if (!com.opos.cmn.an.d.b.a(str) && str.equals(str2)) {
                    }
                } else {
                    com.opos.cmn.an.f.a.c("JSCommonEngine", "forceJsInit=false.");
                }
                this.b = true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("init src=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb2.append(str);
        sb2.append(",result=");
        sb2.append(this.b);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb2.toString());
        return this.b;
    }
}
