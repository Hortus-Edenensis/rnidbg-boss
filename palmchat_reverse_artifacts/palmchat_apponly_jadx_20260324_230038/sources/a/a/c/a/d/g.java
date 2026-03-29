package a.a.c.a.d;

import a.a.c.a.a.f;
import a.a.c.a.b.c;
import a.a.c.a.d.o;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g extends b<a.a.c.a.a.f> {
    public final a.a.c.a.c.a c;
    public final a.a.c.a.c.b d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o.b<a.a.c.a.a.f, String> {
        public a() {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.f a(IBinder iBinder) {
            int i = f.a.f1094a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.f)) ? new f.a.C0009a(iBinder) : (a.a.c.a.a.f) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.f fVar) {
            a.a.c.a.a.f fVar2 = fVar;
            if (fVar2 == null) {
                return null;
            }
            fVar2.b(g.this.c);
            fVar2.a(g.this.d);
            return "";
        }
    }

    public g() {
        super("com.hihonor.id");
        this.c = new a.a.c.a.c.a();
        this.d = new a.a.c.a.c.b();
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.f, String> a() {
        return new a();
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // a.a.c.a.d.b, a.a.c.a.b.c
    public c.a a(Context context) {
        c.a aVar = new c.a();
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            new o(context, intent, new a()).a();
            aVar.f1105a = this.c.f1108a;
            aVar.b = this.d.f1109a;
            return aVar;
        } catch (Exception e) {
            e.getMessage();
            return aVar;
        }
    }
}
