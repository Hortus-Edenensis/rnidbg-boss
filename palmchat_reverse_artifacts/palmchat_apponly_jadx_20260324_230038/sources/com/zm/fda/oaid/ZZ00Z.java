package com.zm.fda.oaid;

import android.content.Context;
import android.text.TextUtils;
import defpackage.nq6;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ZZ00Z implements O022Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16722a;

    public abstract void c(Z25O0 z25o0);

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        com.zm.fda.oaid.Z200O.ZZ500.OO22Z oo22z = new com.zm.fda.oaid.Z200O.ZZ500.OO22Z(this.f16722a);
        if (oo22z.isSupport()) {
            a(oo22z, this.f16722a, z25o0);
        } else if (com.zm.fda.oaid.Z2500.Z0225.b(this.f16722a)) {
            a(this.f16722a, z25o0);
        } else {
            b(this.f16722a, z25o0);
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public final void a(final Z25O0 z25o0) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: pq6
            @Override // java.lang.Runnable
            public final void run() {
                this.f20080a.b(z25o0);
            }
        });
    }

    private void a(O022Z o022z, final Context context, final Z25O0 z25o0) {
        o022z.a(new Z25O0() { // from class: jq6
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str) {
                this.f18482a.a(z25o0, context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Z25O0 z25o0, Context context, String str) {
        if (a(str)) {
            z25o0.a(str);
        } else if (com.zm.fda.oaid.Z2500.Z0225.b(context)) {
            a(context, z25o0);
        } else {
            b(context, z25o0);
        }
    }

    private void b(Context context, Z25O0 z25o0) {
        com.zm.fda.oaid.Z200O.ZZ500.ZZ00Z zz00zA = com.zm.fda.oaid.Z200O.ZZ500.ZZ00Z.a(context);
        com.zm.fda.oaid.Z200O.ZZ500.O022Z o022zA = com.zm.fda.oaid.Z200O.ZZ500.O022Z.a(context);
        if (zz00zA.a()) {
            z25o0.getClass();
            zz00zA.a(new nq6(z25o0));
        } else if (o022zA.a()) {
            z25o0.getClass();
            o022zA.a(new nq6(z25o0));
        }
    }

    private void a(final Context context, final Z25O0 z25o0) {
        final String str = "";
        new com.zm.fda.oaid.Z200O.Z25O0(context).a(new Z25O0() { // from class: dq6
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str2) {
                this.f17126a.a(z25o0, str, context, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Z25O0 z25o0, String str, Context context, String str2) {
        if (a(str2)) {
            z25o0.a(str);
        } else {
            b(context, z25o0);
        }
    }
}
