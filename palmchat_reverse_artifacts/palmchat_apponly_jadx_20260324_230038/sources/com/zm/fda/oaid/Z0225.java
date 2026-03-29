package com.zm.fda.oaid;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0225 {
    public static final String d = "FDA_OAID_OaidIdentifier";
    public static volatile String oaid;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f16705a = new AtomicInteger(0);
    public volatile boolean b = false;
    public volatile boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public static final class OO22Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Z0225 f16706a = new Z0225();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ZZ00Z {
        void a(String str, boolean z);
    }

    public static Z0225 getInstance() {
        return OO22Z.f16706a;
    }

    public void register(Context context, ZZ00Z zz00z) {
        if (zz00z == null) {
            com.zm.fda.oaid.Z2500.Z25O0.a(d, "IOaidListener is null");
            return;
        }
        if (context == null) {
            com.zm.fda.oaid.Z2500.Z25O0.a(d, "context is null, OaidIdentifier register fail");
            zz00z.a("", false);
        } else {
            if (this.c) {
                com.zm.fda.oaid.Z2500.Z25O0.a(d, "OaidIdentifier has registered");
                return;
            }
            this.c = true;
            com.zm.fda.oaid.Z2500.Z25O0.a(d, "OaidIdentifier init");
            b(context, zz00z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final Context context, final ZZ00Z zz00z) {
        if (this.f16705a.getAndIncrement() > 4) {
            if (zz00z != null) {
                zz00z.a("", false);
            }
        } else {
            final com.zm.fda.oaid.ZZ00Z zz00zA = com.zm.fda.oaid.Z200O.ZZ00Z.a(context);
            if (zz00zA != null) {
                zz00zA.c(new Z25O0() { // from class: sp6
                    @Override // com.zm.fda.oaid.Z25O0
                    public final void a(String str) {
                        this.f20802a.a(zz00zA, zz00z, context, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.ZZ00Z zz00z, final ZZ00Z zz00z2, final Context context, String str) {
        this.b = com.zm.fda.oaid.ZZ00Z.a(str);
        if (this.b) {
            if (zz00z2 != null) {
                zz00z2.a(str, true);
            }
        } else if (this.f16705a.get() < 4) {
            com.zm.fda.oaid.Z2500.O022Z.a(new Runnable() { // from class: qp6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20295a.b(context, zz00z2);
                }
            }, 2000);
        } else if (zz00z2 != null) {
            zz00z2.a(str, false);
        }
    }
}
