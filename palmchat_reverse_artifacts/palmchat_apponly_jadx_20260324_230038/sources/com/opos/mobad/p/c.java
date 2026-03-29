package com.opos.mobad.p;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface c extends IInterface {
    void a() throws RemoteException;

    void a(long j) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void b() throws RemoteException;

    void b(long j) throws RemoteException;

    void c() throws RemoteException;

    void c(long j) throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.opos.mobad.p.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0763a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9159a;

            public C0763a(IBinder iBinder) {
                this.f9159a = iBinder;
            }

            @Override // com.opos.mobad.p.c
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    this.f9159a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9159a;
            }

            @Override // com.opos.mobad.p.c
            public void b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    this.f9159a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.c
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    this.f9159a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.c
            public void a(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    parcelObtain.writeLong(j);
                    this.f9159a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.c
            public void b(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    parcelObtain.writeLong(j);
                    this.f9159a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.c
            public void c(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    parcelObtain.writeLong(j);
                    this.f9159a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.c
            public void a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebVideoShowCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9159a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.opos.mobad.web.WebVideoShowCallback");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.web.WebVideoShowCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0763a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.opos.mobad.web.WebVideoShowCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    a();
                    break;
                case 2:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    b();
                    break;
                case 3:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    a(parcel.readLong());
                    break;
                case 4:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    b(parcel.readLong());
                    break;
                case 5:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    c();
                    break;
                case 6:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 7:
                    parcel.enforceInterface("com.opos.mobad.web.WebVideoShowCallback");
                    c(parcel.readLong());
                    break;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
