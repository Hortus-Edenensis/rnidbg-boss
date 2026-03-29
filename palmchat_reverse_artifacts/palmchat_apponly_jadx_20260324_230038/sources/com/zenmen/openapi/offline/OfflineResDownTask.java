package com.zenmen.openapi.offline;

import android.text.TextUtils;
import com.zenmen.openapi.OpenApiManager;
import defpackage.a64;
import defpackage.e84;
import defpackage.ex4;
import defpackage.ga3;
import defpackage.hx3;
import defpackage.wn;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OfflineResDownTask implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public STATE f12023a = STATE.IDLE;
    public String b;
    public String c;
    public String d;
    public e84 e;

    /* JADX INFO: compiled from: SearchBox */
    public enum STATE {
        IDLE,
        PENDING,
        DOWNING,
        FAILED,
        FINISHED,
        UNKNOWN
    }

    public OfflineResDownTask(String str, String str2, String str3, e84 e84Var) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = e84Var;
    }

    public STATE a() {
        return this.f12023a;
    }

    public void b(STATE state) {
        this.f12023a = state;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        ex4 ex4VarA = a64.a(this.b);
        if (ex4VarA != null) {
            if (!(ex4VarA.e() ? hx3.n() : hx3.m(OpenApiManager.getContext()))) {
                this.f12023a = STATE.FAILED;
                e84 e84Var = this.e;
                if (e84Var != null) {
                    e84Var.onCallback(-1, "offline res the network is not connect or allow", null);
                }
                a.d().b(this);
                return;
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        STATE state = this.f12023a;
        STATE state2 = STATE.DOWNING;
        if (state == state2) {
            return;
        }
        this.f12023a = state2;
        byte[] bArrE = wn.e(this.c);
        File file = new File(this.d);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bArrE != null) {
            ga3.h(this.d, bArrE);
            this.f12023a = STATE.FINISHED;
            e84 e84Var2 = this.e;
            if (e84Var2 != null) {
                e84Var2.onCallback(1, null, null);
            }
        } else {
            this.f12023a = STATE.FAILED;
            e84 e84Var3 = this.e;
            if (e84Var3 != null) {
                e84Var3.onCallback(-1, "offline res down unknown error", null);
            }
        }
        a.d().b(this);
    }
}
