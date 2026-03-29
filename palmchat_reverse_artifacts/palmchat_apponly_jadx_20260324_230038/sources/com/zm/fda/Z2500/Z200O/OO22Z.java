package com.zm.fda.Z2500.Z200O;

import android.content.Context;
import com.zm.fda.Z2500.Z0225;
import com.zm.fda.Z2500.Z25O0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z implements Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16697a;
    public O022Z b;

    public OO22Z(Context context) {
        this.f16697a = context;
    }

    @Override // com.zm.fda.Z2500.Z25O0
    public void a(Z0225 z0225) {
        O022Z o022z = new O022Z(this.f16697a, z0225);
        this.b = o022z;
        o022z.start();
    }

    @Override // com.zm.fda.Z2500.Z25O0
    public void a() {
        O022Z o022z = this.b;
        if (o022z != null) {
            o022z.quit();
        }
    }
}
