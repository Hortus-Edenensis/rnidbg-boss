package com.huawei.openalliance.ad.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.ipc.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface f extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements f {
        static final int Code = 1;
        private static final String I = "IPPSServiceApi";
        static final int V = 2;
        private static final String Z = "com.huawei.android.hms.ppskit.IPPSServiceApi";

        /* JADX INFO: renamed from: com.huawei.openalliance.ad.ipc.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0454a implements f {
            public static f Code;
            private IBinder V;

            public C0454a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.openalliance.ad.ipc.f
            public void Code() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Z);
                    if (this.V.transact(1, parcelObtain, parcelObtain2, 0) || a.V() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.V().Code();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String V() {
                return a.Z;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.openalliance.ad.ipc.f
            public void Code(String str, String str2, e eVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Z);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    if (this.V.transact(2, parcelObtain, parcelObtain2, 0) || a.V() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.V().Code(str, str2, eVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, Z);
        }

        public static f Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(Z);
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new C0454a(iBinder) : (f) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                fh.I(I, "IPPSServiceApi err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        public static f V() {
            return C0454a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(Z);
                Code();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(Z);
                    return true;
                }
                parcel.enforceInterface(Z);
                Code(parcel.readString(), parcel.readString(), e.a.Code(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }

        public static boolean Code(f fVar) {
            if (C0454a.Code != null || fVar == null) {
                return false;
            }
            C0454a.Code = fVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void Code();

    void Code(String str, String str2, e eVar);
}
