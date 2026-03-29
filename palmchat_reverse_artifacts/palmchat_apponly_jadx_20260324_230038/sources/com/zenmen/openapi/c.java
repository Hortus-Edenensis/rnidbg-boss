package com.zenmen.openapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface c extends IInterface {
    String getConfig(String str) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements c {
        static final int TRANSACTION_getConfig = 1;

        /* JADX INFO: renamed from: com.zenmen.openapi.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0942a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12019a;

            public C0942a(IBinder iBinder) {
                this.f12019a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12019a;
            }

            @Override // com.zenmen.openapi.c
            public String getConfig(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.openapi.ILxComm");
                    parcelObtain.writeString(str);
                    this.f12019a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.zenmen.openapi.ILxComm");
        }

        public static c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.openapi.ILxComm");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0942a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.openapi.ILxComm");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.openapi.ILxComm");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            String config = getConfig(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(config);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
