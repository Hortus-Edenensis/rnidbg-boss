package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface dx extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements dx {
        @Override // com.umeng.analytics.pro.dx
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    String a() throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements dx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f10939a = 1;
        private static final String b = "com.zui.deviceidservice.IDeviceidInterface";

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements dx {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static dx f10940a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.dx
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.b);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && b.b() != null) {
                        return b.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            public String b() {
                return b.b;
            }
        }

        public b() {
            attachInterface(this, b);
        }

        public static dx a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof dx)) ? new a(iBinder) : (dx) iInterfaceQueryLocalInterface;
        }

        public static dx b() {
            return a.f10940a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(b);
                return true;
            }
            parcel.enforceInterface(b);
            String strA = a();
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }

        public static boolean a(dx dxVar) {
            if (a.f10940a != null || dxVar == null) {
                return false;
            }
            a.f10940a = dxVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
