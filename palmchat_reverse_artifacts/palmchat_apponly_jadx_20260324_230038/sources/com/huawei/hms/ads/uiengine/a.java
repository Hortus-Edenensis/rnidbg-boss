package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface a extends IInterface {
    public static final String Code = "com.huawei.hms.ads.uiengine.IMediaplayerAgent";

    /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0439a implements a {
        @Override // com.huawei.hms.ads.uiengine.a
        public long Code() {
            return 0L;
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void I(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Code(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void I(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Code(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void V(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.a
        public void Z(Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements a {
        static final int B = 4;
        static final int C = 5;
        static final int D = 8;
        static final int F = 7;
        static final int I = 2;
        static final int L = 9;
        static final int S = 6;
        static final int V = 1;
        static final int Z = 3;

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0440a implements a {
            public static a V;
            private IBinder I;

            public C0440a(IBinder iBinder) {
                this.I = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public long Code() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (!this.I.transact(1, parcelObtain, parcelObtain2, 0) && b.I() != null) {
                        return b.I().Code();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String I() {
                return a.Code;
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (this.I.transact(7, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().V();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Z(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(5, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().Z(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.I;
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Code(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(2, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().Code(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void I(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(4, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().I(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(3, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().V(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void Code(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    parcelObtain.writeString(str);
                    if (this.I.transact(6, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().Code(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void I(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    parcelObtain.writeString(str);
                    if (this.I.transact(9, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().I(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.a
            public void V(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.Code);
                    parcelObtain.writeString(str);
                    if (this.I.transact(8, parcelObtain, parcelObtain2, 0) || b.I() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.I().V(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, a.Code);
        }

        public static a Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.Code);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0440a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a I() {
            return C0440a.V;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(a.Code);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(a.Code);
                    long jCode = Code();
                    parcel2.writeNoException();
                    parcel2.writeLong(jCode);
                    return true;
                case 2:
                    parcel.enforceInterface(a.Code);
                    Code(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(a.Code);
                    V(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(a.Code);
                    I(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(a.Code);
                    Z(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(a.Code);
                    Code(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(a.Code);
                    V();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(a.Code);
                    V(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(a.Code);
                    I(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static boolean Code(a aVar) {
            if (C0440a.V != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0440a.V = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    long Code();

    void Code(Bundle bundle);

    void Code(String str);

    void I(Bundle bundle);

    void I(String str);

    void V();

    void V(Bundle bundle);

    void V(String str);

    void Z(Bundle bundle);
}
