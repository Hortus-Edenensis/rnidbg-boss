package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cm implements ff, fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11475a;

    public cm(Context context) {
        this.f11475a = context;
    }

    @Override // com.xiaomi.push.fk
    /* JADX INFO: renamed from: a */
    public boolean mo264a(fo foVar) {
        return true;
    }

    @Override // com.xiaomi.push.ff
    public void a(fo foVar) {
        ct.a(this.f11475a);
    }

    @Override // com.xiaomi.push.ff
    public void a(er erVar) {
        if (erVar != null && erVar.a() == 0 && "PING".equals(erVar.m414a())) {
            ct.c(this.f11475a);
        } else {
            ct.a(this.f11475a);
        }
    }
}
