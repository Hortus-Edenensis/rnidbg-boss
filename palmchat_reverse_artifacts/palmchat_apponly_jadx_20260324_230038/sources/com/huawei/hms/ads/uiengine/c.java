package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface c extends IInterface {
    public static final String D = "com.huawei.hms.ads.uiengine.INativeApi";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements c {
        @Override // com.huawei.hms.ads.uiengine.c
        public boolean B() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code() {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public String I() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V() {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public boolean Z() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(long j) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(String str, long j, long j2, int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(long j, long j2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void V(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, long j, long j2, int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.c
        public void Code(boolean z) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements c {
        static final int L = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f6606a = 2;
        static final int b = 3;
        static final int c = 4;
        static final int d = 5;
        static final int e = 6;
        static final int f = 7;
        static final int g = 8;
        static final int h = 9;
        static final int i = 10;
        static final int j = 11;
        static final int k = 12;
        static final int l = 13;
        static final int m = 14;
        static final int n = 15;
        static final int o = 16;
        static final int p = 17;
        static final int q = 18;
        static final int r = 19;
        static final int s = 20;
        static final int t = 21;
        static final int u = 22;
        static final int v = 23;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements c {
            public static c Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean B() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (!this.V.transact(10, parcelObtain, parcelObtain2, 0) && b.S() != null) {
                        return b.S().B();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String C() {
                return c.D;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (this.V.transact(19, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public String I() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (!this.V.transact(17, parcelObtain, parcelObtain2, 0) && b.S() != null) {
                        return b.S().I();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (this.V.transact(15, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().V();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public boolean Z() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (!this.V.transact(8, parcelObtain, parcelObtain2, 0) && b.S() != null) {
                        return b.S().Z();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(13, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(23, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().V(iObjectWrapper);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeLong(j);
                    if (this.V.transact(22, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(j);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(String str, long j, long j2, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (this.V.transact(3, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            b.S().V(str, j, j2, i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    if (this.V.transact(5, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(j, j2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void V(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(18, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().V(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(16, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(6, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iObjectWrapper);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(7, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iObjectWrapper, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(12, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (this.V.transact(9, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iObjectWrapper, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(11, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iObjectWrapper, str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(14, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    if (this.V.transact(21, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(1, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, long j, long j2, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (this.V.transact(2, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            b.S().Code(str, j, j2, i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(20, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(str, iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.c
            public void Code(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.D);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.V.transact(4, parcelObtain, parcelObtain2, 0) || b.S() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.S().Code(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, c.D);
        }

        public static c Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.D);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c S() {
            return a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString(c.D);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(c.D);
                    V(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(c.D);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(c.D);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(c.D);
                    boolean Z = Z();
                    parcel2.writeNoException();
                    parcel2.writeInt(Z ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(c.D);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(c.D);
                    boolean zB = B();
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(c.D);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(c.D);
                    Code(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(c.D);
                    Code(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(c.D);
                    V();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(c.D);
                    String strI = I();
                    parcel2.writeNoException();
                    parcel2.writeString(strI);
                    return true;
                case 18:
                    parcel.enforceInterface(c.D);
                    V(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(c.D);
                    Code();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(c.D);
                    Code(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(c.D);
                    V(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        public static boolean Code(c cVar) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cVar == null) {
                return false;
            }
            a.Code = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    boolean B();

    void Code();

    void Code(int i);

    void Code(long j);

    void Code(long j, long j2);

    void Code(Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper);

    void Code(IObjectWrapper iObjectWrapper, int i);

    void Code(IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(IObjectWrapper iObjectWrapper, String str);

    void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    void Code(IPPSUiEngineCallback iPPSUiEngineCallback);

    void Code(String str);

    void Code(String str, int i);

    void Code(String str, long j, long j2, int i, int i2);

    void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void Code(boolean z);

    String I();

    void V();

    void V(IObjectWrapper iObjectWrapper);

    void V(String str, long j, long j2, int i, int i2);

    void V(String str, Bundle bundle);

    boolean Z();
}
