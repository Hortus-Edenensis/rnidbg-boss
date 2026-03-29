package a.a.c.a.d;

import a.a.c.a.a.c;
import a.a.c.a.d.o;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class h extends b<a.a.c.a.a.c> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o.b<a.a.c.a.a.c, String> {
        public a(h hVar) {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.c a(IBinder iBinder) {
            int i = c.a.f1090a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.c)) ? new c.a.C0007a(iBinder) : (a.a.c.a.a.c) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.c cVar) {
            a.a.c.a.a.c cVar2 = cVar;
            if (cVar2 == null) {
                return null;
            }
            return cVar2.a();
        }
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.c, String> a() {
        return new a(this);
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
