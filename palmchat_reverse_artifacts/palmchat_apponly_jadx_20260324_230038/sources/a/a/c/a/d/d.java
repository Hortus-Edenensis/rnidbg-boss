package a.a.c.a.d;

import a.a.c.a.a.a;
import a.a.c.a.b.c;
import a.a.c.a.d.o;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b<a.a.c.a.a.a> {
    public final Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o.b<a.a.c.a.a.a, String> {
        public a() {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.a a(IBinder iBinder) {
            int i = a.AbstractBinderC0004a.f1086a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.a)) ? new a.AbstractBinderC0004a.C0005a(iBinder) : (a.a.c.a.a.a) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.a aVar) {
            a.a.c.a.a.a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            return aVar2.a(d.this.c.getPackageName());
        }
    }

    public d(Context context) {
        super("com.coolpad.deviceidsupport");
        this.c = context;
    }

    @Override // a.a.c.a.d.b, a.a.c.a.b.c
    public c.a a(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                c.a aVar = new c.a();
                aVar.f1105a = string;
                return aVar;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return super.a(context);
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.a, String> a() {
        return new a();
    }
}
