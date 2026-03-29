package a.a.c.a.d;

import a.a.c.a.a.i;
import a.a.c.a.d.o;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Pair;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class f implements o.b<a.a.c.a.a.i, Pair<String, Boolean>> {
    @Override // a.a.c.a.d.o.b
    public a.a.c.a.a.i a(IBinder iBinder) {
        int i = i.a.f1100a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.i)) ? new i.a.C0012a(iBinder) : (a.a.c.a.a.i) iInterfaceQueryLocalInterface;
    }

    @Override // a.a.c.a.d.o.b
    public Pair<String, Boolean> a(a.a.c.a.a.i iVar) {
        a.a.c.a.a.i iVar2 = iVar;
        if (iVar2 == null) {
            return null;
        }
        return new Pair<>(iVar2.c(), Boolean.valueOf(iVar2.b()));
    }
}
