package com.zm.fda.oaid.Z200O;

import android.content.Context;
import com.zm.fda.oaid.Z200O.OOZ20;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OOZ20 extends com.zm.fda.oaid.ZZ00Z {
    public OOZ20(Context context) {
        this.f16722a = context;
    }

    public static /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (z25o0 != null) {
            z25o0.a(str);
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final com.zm.fda.oaid.Z25O0 z25o0) {
        a(new com.zm.fda.oaid.Z25O0() { // from class: a54
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str) {
                OOZ20.a(z25o0, str);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        return true;
    }
}
