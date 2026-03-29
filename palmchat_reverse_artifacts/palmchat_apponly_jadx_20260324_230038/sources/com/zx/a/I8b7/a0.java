package com.zx.a.I8b7;

import com.zx.a.I8b7.l2;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f16766a;

    public a0(y yVar) {
        this.f16766a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            y yVar = this.f16766a;
            if (yVar.f16885a != null) {
                yVar.f16885a = new JSONArray();
                l2 l2Var = l2.a.f16824a;
                l2Var.f16823a.getClass();
                l2Var.f16823a.a(23, "", true);
            }
        } catch (Throwable unused) {
        }
    }
}
