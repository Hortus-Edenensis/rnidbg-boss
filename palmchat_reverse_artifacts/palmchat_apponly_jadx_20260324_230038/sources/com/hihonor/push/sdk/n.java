package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f6462a;

    public n(s sVar) {
        this.f6462a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        s sVar = this.f6462a;
        a0 a0Var = sVar.b;
        Context context = sVar.f6472a;
        a0Var.getClass();
        try {
            d1 d1Var = new d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            d1Var.e = b.a();
            b.a(z.c.a(d1Var));
            d.b.a(context, null);
            return null;
        } catch (Exception e) {
            throw b.a(e);
        }
    }
}
