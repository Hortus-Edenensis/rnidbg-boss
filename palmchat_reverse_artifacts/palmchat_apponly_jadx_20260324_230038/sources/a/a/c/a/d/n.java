package a.a.c.a.d;

import a.a.c.a.a.b;
import a.a.c.a.d.o;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class n extends b<a.a.c.a.a.b> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o.b<a.a.c.a.a.b, String> {
        public a(n nVar) {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.b a(IBinder iBinder) {
            int i = b.a.f1088a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.b)) ? new b.a.C0006a(iBinder) : (a.a.c.a.a.b) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.b bVar) {
            return bVar.a();
        }
    }

    public n() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.b, String> a() {
        return new a(this);
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
