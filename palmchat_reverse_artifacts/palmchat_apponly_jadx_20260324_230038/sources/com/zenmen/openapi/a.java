package com.zenmen.openapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface a extends IInterface {
    String getProfile() throws RemoteException;

    String getSid() throws RemoteException;

    String getToken() throws RemoteException;

    String getUid() throws RemoteException;

    /* JADX INFO: renamed from: com.zenmen.openapi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0938a extends Binder implements a {
        static final int TRANSACTION_getProfile = 4;
        static final int TRANSACTION_getSid = 2;
        static final int TRANSACTION_getToken = 3;
        static final int TRANSACTION_getUid = 1;

        /* JADX INFO: renamed from: com.zenmen.openapi.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0939a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12014a;

            public C0939a(IBinder iBinder) {
                this.f12014a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12014a;
            }
        }

        public AbstractBinderC0938a() {
            attachInterface(this, "com.zenmen.openapi.IAccountManager");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.openapi.IAccountManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0939a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.openapi.IAccountManager");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.openapi.IAccountManager");
                return true;
            }
            if (i == 1) {
                String uid = getUid();
                parcel2.writeNoException();
                parcel2.writeString(uid);
            } else if (i == 2) {
                String sid = getSid();
                parcel2.writeNoException();
                parcel2.writeString(sid);
            } else if (i == 3) {
                String token = getToken();
                parcel2.writeNoException();
                parcel2.writeString(token);
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                String profile = getProfile();
                parcel2.writeNoException();
                parcel2.writeString(profile);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
