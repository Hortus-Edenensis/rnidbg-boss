package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cr implements fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11482a;

    public cr(Context context) {
        this.f11482a = context;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        cn.m265a(this.f11482a);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i, Exception exc) {
        cn.a(this.f11482a, faVar.mo438a(), i);
    }
}
