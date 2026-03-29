package a.a.c.a.d;

import a.a.c.a.a.d;
import a.a.c.a.d.o;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b<a.a.c.a.a.d> {

    /* JADX INFO: renamed from: a.a.c.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0013a implements o.b<a.a.c.a.a.d, String> {
        public C0013a(a aVar) {
        }

        @Override // a.a.c.a.d.o.b
        public a.a.c.a.a.d a(IBinder iBinder) {
            int i = d.a.f1092a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a.a.c.a.a.d)) ? new d.a.C0008a(iBinder) : (a.a.c.a.a.d) iInterfaceQueryLocalInterface;
        }

        @Override // a.a.c.a.d.o.b
        public String a(a.a.c.a.a.d dVar) {
            a.a.c.a.a.d dVar2 = dVar;
            if (dVar2 == null) {
                return null;
            }
            return dVar2.a();
        }
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // a.a.c.a.d.b
    public o.b<a.a.c.a.a.d, String> a() {
        return new C0013a(this);
    }

    @Override // a.a.c.a.d.b
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
