package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.bj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final int Code = 60000;
    private static final String I = "Monitor";
    private static final String V = "unbindTask";
    private final String B = V + hashCode();
    private int C = 0;
    private Context F;
    private String S;
    private InterfaceC0452a Z;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.ipc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0452a {
        void Code();
    }

    public a(Context context, String str, InterfaceC0452a interfaceC0452a) {
        this.F = context.getApplicationContext();
        this.S = str;
        this.Z = interfaceC0452a;
    }

    private int B() {
        return TextUtils.equals(x.cA, this.F.getPackageName()) ? 0 : 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        fh.V(Z(), "unbindService");
        try {
            this.Z.Code();
        } catch (Throwable th) {
            fh.I(I, "unbindService err: %s", th.getClass().getSimpleName());
        }
    }

    private String Z() {
        return "Monitor_" + this.S;
    }

    public Context Code() {
        return this.F;
    }

    public synchronized void I() {
        int i = this.C - 1;
        this.C = i;
        if (i < 0) {
            this.C = 0;
        }
        fh.Code(Z(), "dec count: %d", Integer.valueOf(this.C));
        if (this.C <= 0) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.C();
                }
            }, this.B, B());
        }
    }

    public synchronized void V() {
        this.C++;
        bj.Code(this.B);
        fh.V(Z(), "inc count: " + this.C);
    }
}
