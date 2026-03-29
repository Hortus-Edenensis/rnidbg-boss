package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cl implements ff, fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11474a;

    public cl(Context context) {
        this.f11474a = context;
    }

    @Override // com.xiaomi.push.fk
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo264a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.b(this.f11474a);
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m414a())) {
            ct.d(this.f11474a);
        } else {
            ct.b(this.f11474a);
        }
    }
}
