package com.zenmen.openapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface d extends IInterface {
    void onEvent(String str, String str2) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements d {
        static final int TRANSACTION_onEvent = 1;

        /* JADX INFO: renamed from: com.zenmen.openapi.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0943a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12020a;

            public C0943a(IBinder iBinder) {
                this.f12020a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12020a;
            }
        }

        public a() {
            attachInterface(this, "com.zenmen.openapi.IMDAManager");
        }

        public static d asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.openapi.IMDAManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0943a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.openapi.IMDAManager");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.openapi.IMDAManager");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            onEvent(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
