package com.zenmen.openapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zenmen.openapi.a;
import com.zenmen.openapi.b;
import com.zenmen.openapi.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface e extends IInterface {
    d H() throws RemoteException;

    b m() throws RemoteException;

    c v() throws RemoteException;

    com.zenmen.openapi.a z() throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: com.zenmen.openapi.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0944a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12021a;

            public C0944a(IBinder iBinder) {
                this.f12021a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12021a;
            }

            @Override // com.zenmen.openapi.e
            public b m() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.openapi.IOpenAPIService");
                    this.f12021a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return b.a.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zenmen.openapi.e
            public c v() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.openapi.IOpenAPIService");
                    this.f12021a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return c.a.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zenmen.openapi.e
            public com.zenmen.openapi.a z() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zenmen.openapi.IOpenAPIService");
                    this.f12021a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return a.AbstractBinderC0938a.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.zenmen.openapi.IOpenAPIService");
        }

        public static e g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.openapi.IOpenAPIService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0944a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.openapi.IOpenAPIService");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.openapi.IOpenAPIService");
                return true;
            }
            if (i == 1) {
                com.zenmen.openapi.a aVarZ = z();
                parcel2.writeNoException();
                parcel2.writeStrongInterface(aVarZ);
            } else if (i == 2) {
                b bVarM = m();
                parcel2.writeNoException();
                parcel2.writeStrongInterface(bVarM);
            } else if (i == 3) {
                d dVarH = H();
                parcel2.writeNoException();
                parcel2.writeStrongInterface(dVarH);
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                c cVarV = v();
                parcel2.writeNoException();
                parcel2.writeStrongInterface(cVarV);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
