package com.opos.mobad.p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.opos.mobad.p.b;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a extends IInterface {
    void a() throws RemoteException;

    void a(b bVar) throws RemoteException;

    void a(Map map) throws RemoteException;

    /* JADX INFO: renamed from: com.opos.mobad.p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0760a extends Binder implements a {

        /* JADX INFO: renamed from: com.opos.mobad.p.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0761a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9157a;

            public C0761a(IBinder iBinder) {
                this.f9157a = iBinder;
            }

            @Override // com.opos.mobad.p.a
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    this.f9157a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9157a;
            }

            @Override // com.opos.mobad.p.a
            public void a(b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f9157a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.p.a
            public void a(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.web.WebShowCallback");
                    parcelObtain.writeMap(map);
                    this.f9157a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0760a() {
            attachInterface(this, "com.opos.mobad.web.WebShowCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.web.WebShowCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0761a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a(b.a.a(parcel.readStrongBinder()));
            } else if (i == 2) {
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a();
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.opos.mobad.web.WebShowCallback");
                    return true;
                }
                parcel.enforceInterface("com.opos.mobad.web.WebShowCallback");
                a(parcel.readHashMap(getClass().getClassLoader()));
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
