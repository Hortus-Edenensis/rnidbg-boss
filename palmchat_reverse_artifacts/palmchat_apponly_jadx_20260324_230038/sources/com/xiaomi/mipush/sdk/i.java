package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.df;
import com.xiaomi.push.gf;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class i implements df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11376a;

    public i(Context context) {
        this.f11376a = context;
    }

    @Override // com.xiaomi.push.df
    public String a() {
        return b.m99a(this.f11376a).d();
    }

    @Override // com.xiaomi.push.df
    public void a(he heVar, gf gfVar, gs gsVar) {
        u.a(this.f11376a).a(heVar, gfVar, gsVar);
    }
}
