package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.uiengine.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface b extends IInterface {
    public static final String Code = "com.huawei.hms.ads.uiengine.IMultiMPlayingManager";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements b {
        @Override // com.huawei.hms.ads.uiengine.b
        public void Code(com.huawei.hms.ads.uiengine.a aVar) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void V(com.huawei.hms.ads.uiengine.a aVar) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void Code(String str, com.huawei.hms.ads.uiengine.a aVar) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void V(String str, com.huawei.hms.ads.uiengine.a aVar) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void I(String str, com.huawei.hms.ads.uiengine.a aVar) {
        }

        @Override // com.huawei.hms.ads.uiengine.b
        public void Z(String str, com.huawei.hms.ads.uiengine.a aVar) {
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0441b extends Binder implements b {
        static final int B = 4;
        static final int C = 5;
        static final int I = 2;
        static final int S = 6;
        static final int V = 1;
        static final int Z = 3;

        /* JADX INFO: renamed from: com.huawei.hms.ads.uiengine.b$b$a */
        /* JADX INFO: compiled from: SearchBox */
        public static class a implements b {
            public static b V;
            private IBinder I;

            public a(IBinder iBinder) {
                this.I = iBinder;
            }

            public String Code() {
                return b.Code;
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void I(String str, com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().I(str, aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void V(com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(6, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().V(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void Z(String str, com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().Z(str, aVar);
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

            @Override // com.huawei.hms.ads.uiengine.b
            public void Code(com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().Code(aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void V(String str, com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().V(str, aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.b
            public void Code(String str, com.huawei.hms.ads.uiengine.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.Code);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.I.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0441b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0441b.Code().Code(str, aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0441b() {
            attachInterface(this, b.Code);
        }

        public static b Code() {
            return a.V;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(b.Code);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(b.Code);
                    Code(parcel.readString(), a.b.Code(parcel.readStrongBinder()));
                    break;
                case 2:
                    parcel.enforceInterface(b.Code);
                    V(parcel.readString(), a.b.Code(parcel.readStrongBinder()));
                    break;
                case 3:
                    parcel.enforceInterface(b.Code);
                    I(parcel.readString(), a.b.Code(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface(b.Code);
                    Z(parcel.readString(), a.b.Code(parcel.readStrongBinder()));
                    break;
                case 5:
                    parcel.enforceInterface(b.Code);
                    Code(a.b.Code(parcel.readStrongBinder()));
                    break;
                case 6:
                    parcel.enforceInterface(b.Code);
                    V(a.b.Code(parcel.readStrongBinder()));
                    break;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }

        public static b Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.Code);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(b bVar) {
            if (a.V != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.V = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void Code(com.huawei.hms.ads.uiengine.a aVar);

    void Code(String str, com.huawei.hms.ads.uiengine.a aVar);

    void I(String str, com.huawei.hms.ads.uiengine.a aVar);

    void V(com.huawei.hms.ads.uiengine.a aVar);

    void V(String str, com.huawei.hms.ads.uiengine.a aVar);

    void Z(String str, com.huawei.hms.ads.uiengine.a aVar);
}
