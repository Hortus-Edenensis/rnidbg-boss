package com.opos.mobad.l;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.opos.mobad.l.b;
import com.opos.mobad.l.c;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a extends IInterface {
    void a() throws RemoteException;

    void a(int i, String str) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(long j, boolean z) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, b bVar) throws RemoteException;

    void a(Map map) throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;

    void f() throws RemoteException;

    /* JADX INFO: renamed from: com.opos.mobad.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0751a extends Binder implements a {

        /* JADX INFO: renamed from: com.opos.mobad.l.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0752a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f8968a;

            public C0752a(IBinder iBinder) {
                this.f8968a = iBinder;
            }

            @Override // com.opos.mobad.l.a
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8968a;
            }

            @Override // com.opos.mobad.l.a
            public void b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void f() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    this.f8968a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.f8968a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeLong(j);
                    this.f8968a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(long j, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f8968a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f8968a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeString(str);
                    this.f8968a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(String str, b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f8968a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.opos.mobad.l.a
            public void a(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.AdShowCallback");
                    parcelObtain.writeMap(map);
                    this.f8968a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0751a() {
            attachInterface(this, "com.opos.mobad.show.AdShowCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.show.AdShowCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0752a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.opos.mobad.show.AdShowCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a();
                    break;
                case 2:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    b();
                    break;
                case 3:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readLong());
                    break;
                case 5:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    c();
                    break;
                case 6:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readInt(), parcel.readString());
                    break;
                case 7:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    d();
                    break;
                case 8:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    e();
                    break;
                case 9:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readString());
                    break;
                case 10:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readLong(), parcel.readInt() != 0);
                    break;
                case 11:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(parcel.readHashMap(getClass().getClassLoader()));
                    break;
                case 12:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    a(c.a.a(parcel.readStrongBinder()));
                    break;
                case 13:
                    parcel.enforceInterface("com.opos.mobad.show.AdShowCallback");
                    f();
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
