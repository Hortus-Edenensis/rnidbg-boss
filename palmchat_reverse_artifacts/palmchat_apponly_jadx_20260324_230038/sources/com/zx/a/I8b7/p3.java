package com.zx.a.I8b7;

import com.zx.module.base.Listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class p3 implements Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Listener f16844a;
    public final /* synthetic */ t3 b;

    public p3(t3 t3Var, Listener listener) {
        this.b = t3Var;
        this.f16844a = listener;
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(String str, String str2) {
        if (str.equals("zxid") || str.equals("MESSAGE_ON_ZXID_RECEIVED")) {
            this.b.f16866a.set(false);
        }
        this.f16844a.onMessage(str, str2);
    }
}
