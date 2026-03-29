package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface xg extends IInterface {
    void u(int i, int i2) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class u extends Binder implements xg {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.xg$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0872u implements xg {
            public static xg u;
            private IBinder nr;

            public C0872u(IBinder iBinder) {
                this.nr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.nr;
            }

            @Override // com.ss.android.socialbase.downloader.depend.xg
            public void u(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (this.nr.transact(1, parcelObtain, parcelObtain2, 0) || u.u() == null) {
                        parcelObtain2.readException();
                    } else {
                        u.u().u(i, i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public u() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static xg u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof xg)) ? new C0872u(iBinder) : (xg) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            u(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static xg u() {
            return C0872u.u;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
