package defpackage;

import android.content.SyncResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface ap2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements ap2 {

        /* JADX INFO: renamed from: ap2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0026a implements ap2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1546a;

            public C0026a(IBinder iBinder) {
                this.f1546a = iBinder;
            }

            @Override // defpackage.ap2
            public void a(SyncResult syncResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.content.ISyncContext");
                    b.b(parcelObtain, syncResult, 0);
                    this.f1546a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1546a;
            }
        }

        public static ap2 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.content.ISyncContext");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ap2)) ? new C0026a(iBinder) : (ap2) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static <T extends Parcelable> void b(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void a(SyncResult syncResult) throws RemoteException;
}
