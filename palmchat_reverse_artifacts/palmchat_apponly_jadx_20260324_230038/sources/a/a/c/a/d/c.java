package a.a.c.a.d;

import a.a.c.a.a.h;
import a.a.c.a.b.c;
import a.a.c.a.d.o;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b<a.a.c.a.a.h> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o.b<a.a.c.a.a.h, String> {
        public a(c cVar) {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.h a(IBinder iBinder) {
            int i = h.a.f1098a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.h)) ? new h.a.C0011a(iBinder) : (a.a.c.a.a.h) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.h hVar) {
            a.a.c.a.a.h hVar2 = hVar;
            if (hVar2 == null) {
                return null;
            }
            return hVar2.a();
        }
    }

    public c() {
        super("com.mdid.msa");
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.h, String> a() {
        return new a(this);
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // a.a.c.a.d.b, a.a.c.a.b.c
    public c.a a(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            e.getMessage();
        }
        return super.a(context);
    }
}
