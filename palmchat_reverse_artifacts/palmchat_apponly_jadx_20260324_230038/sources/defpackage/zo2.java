package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface zo2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements zo2 {

        /* JADX INFO: renamed from: zo2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1298a implements zo2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f22464a;

            public C1298a(IBinder iBinder) {
                this.f22464a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22464a;
            }

            @Override // defpackage.zo2
            public void c(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.content.ISyncAdapterUnsyncableAccountCallback");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f22464a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zo2 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.content.ISyncAdapterUnsyncableAccountCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zo2)) ? new C1298a(iBinder) : (zo2) iInterfaceQueryLocalInterface;
        }
    }

    void c(boolean z) throws RemoteException;
}
