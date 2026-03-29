package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface qu6 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements qu6 {

        /* JADX INFO: renamed from: qu6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1270a implements qu6 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f20325a;

            public C1270a(IBinder iBinder) {
                this.f20325a = iBinder;
            }

            @Override // defpackage.qu6
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f20325a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20325a;
            }

            @Override // defpackage.qu6
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f20325a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static qu6 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qu6)) ? new C1270a(iBinder) : (qu6) iInterfaceQueryLocalInterface;
        }
    }

    String a() throws RemoteException;

    boolean c() throws RemoteException;
}
