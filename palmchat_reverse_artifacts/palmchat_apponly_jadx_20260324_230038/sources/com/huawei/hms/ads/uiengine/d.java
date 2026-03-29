package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface d extends IInterface {
    public static final String Code = "com.huawei.hms.ads.uiengine.IUiEngineUtil";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements d {
        @Override // com.huawei.hms.ads.uiengine.d
        public Bundle Code(String str, Bundle bundle, IObjectWrapper iObjectWrapper) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void V(int i, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public IObjectWrapper Code(IObjectWrapper iObjectWrapper) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public List<String> Code(Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void Code(int i, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void Code(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public boolean Code(String str, int i, Bundle bundle) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void I(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.d
        public void Z(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements d {
        static final int B = 4;
        static final int C = 5;
        static final int D = 8;
        static final int F = 7;
        static final int I = 2;
        static final int L = 9;
        static final int S = 6;
        static final int V = 1;
        static final int Z = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f6607a = 10;
        static final int b = 11;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements d {
            public static d V;
            private IBinder I;

            public a(IBinder iBinder) {
                this.I = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public Bundle Code(String str, Bundle bundle, IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.I.transact(11, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().Code(str, bundle, iObjectWrapper);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void I(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(9, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().I(iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void V(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(8, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().V(i, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void Z(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(10, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().Z(iObjectWrapper, bundle);
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

            @Override // com.huawei.hms.ads.uiengine.d
            public IObjectWrapper Code(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.I.transact(4, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().Code(iObjectWrapper);
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(6, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().V(iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String Code() {
                return d.Code;
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public List<String> Code(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.I.transact(1, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().Code(bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void Code(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(7, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().Code(i, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(5, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().Code(iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public void Code(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.I.transact(2, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().Code(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.d
            public boolean Code(String str, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.Code);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.I.transact(3, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().Code(str, i, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, d.Code);
        }

        public static d Code() {
            return a.V;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(d.Code);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(d.Code);
                    List<String> listCode = Code(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listCode);
                    return true;
                case 2:
                    parcel.enforceInterface(d.Code);
                    Code(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(d.Code);
                    boolean zCode = Code(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zCode ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(d.Code);
                    IObjectWrapper iObjectWrapperCode = Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperCode != null ? iObjectWrapperCode.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(d.Code);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(d.Code);
                    V(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(d.Code);
                    Code(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(d.Code);
                    V(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(d.Code);
                    I(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(d.Code);
                    Z(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(d.Code);
                    Bundle bundleCode = Code(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundleCode != null) {
                        parcel2.writeInt(1);
                        bundleCode.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static d Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(d.Code);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(d dVar) {
            if (a.V != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (dVar == null) {
                return false;
            }
            a.V = dVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    Bundle Code(String str, Bundle bundle, IObjectWrapper iObjectWrapper);

    IObjectWrapper Code(IObjectWrapper iObjectWrapper);

    List<String> Code(Bundle bundle);

    void Code(int i, Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(String str, Bundle bundle);

    boolean Code(String str, int i, Bundle bundle);

    void I(IObjectWrapper iObjectWrapper, Bundle bundle);

    void V(int i, Bundle bundle);

    void V(IObjectWrapper iObjectWrapper, Bundle bundle);

    void Z(IObjectWrapper iObjectWrapper, Bundle bundle);
}
