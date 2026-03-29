package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.a.I8b7.e1;
import com.zx.a.I8b7.l2;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class q3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t3 f16850a;

    public q3(t3 t3Var) {
        this.f16850a = t3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        e1 e1Var = e1.a.f16790a;
        try {
            e1Var.f16789a = System.currentTimeMillis();
            e1Var.b = UUID.randomUUID().toString().replaceAll("-", "");
            l2 l2Var = l2.a.f16824a;
            String strA = l2Var.f16823a.a(24);
            if (!TextUtils.isEmpty(strA)) {
                e1Var.c = Integer.parseInt(strA);
            }
            e1Var.c++;
            u3 u3Var = l2Var.f16823a;
            String str = e1Var.c + "";
            u3Var.getClass();
            l2Var.f16823a.a(24, str, true);
            r2.a("process start pts:" + e1Var.f16789a + ", pid:" + e1Var.b + ", rc:" + e1Var.c);
        } catch (Throwable th) {
            r2.a(th);
        }
        if (!this.f16850a.b.get()) {
            throw new IllegalStateException("ZXSdkImpl not init, should init firstly");
        }
        try {
            t3.a(this.f16850a);
        } catch (Throwable th2) {
            this.f16850a.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", e2.a(10000, th2.getMessage()));
            StringBuilder sb = new StringBuilder();
            sb.append("ZXCore start failed: ");
            g3.a(th2, sb);
        }
    }
}
