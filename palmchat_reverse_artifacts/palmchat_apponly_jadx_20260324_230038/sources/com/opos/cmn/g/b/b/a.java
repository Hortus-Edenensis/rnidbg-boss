package com.opos.cmn.g.b.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.an.transactivity.api.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8021a;
    private com.opos.cmn.an.d.a b;

    public a(String str, com.opos.cmn.an.d.a aVar) {
        this.f8021a = str;
        this.b = aVar;
    }

    @Override // com.opos.cmn.an.transactivity.api.b, com.opos.cmn.an.transactivity.a.a
    public void a(Activity activity, Bundle bundle) {
        try {
            if (activity != null) {
                try {
                    com.opos.cmn.an.f.a.a("MkdlTransLifeCallback", "marketUrl:", this.f8021a, " activityExtraParams:", this.b, " result:", Boolean.valueOf(com.opos.cmn.g.b.a.a.a((Context) activity, this.f8021a, this.b)));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("MkdlTransLifeCallback", "onCreate", e);
                }
            }
        } finally {
            activity.finish();
        }
    }
}
