package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IGlobalUtil extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IGlobalUtil";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements IGlobalUtil {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int F = 8;
        static final int I = 3;
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements IGlobalUtil {
            public static IGlobalUtil Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return IGlobalUtil.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.V.transact(8, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().callMethod(str, iObjectWrapper, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(1, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().getFilePath(str, iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirect(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.V.transact(4, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getFilePathDirect(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirectByCacheType(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (!this.V.transact(5, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getFilePathDirectByCacheType(str, i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    if (!this.V.transact(6, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getMultiMediaPlayingManager();
                    }
                    parcelObtain2.readException();
                    return b.AbstractBinderC0441b.Code(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.V.transact(7, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().isFreedomWindowMode(iObjectWrapper);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(2, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().registerActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(3, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().unregisterActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, IGlobalUtil.DESCRIPTOR);
        }

        public static IGlobalUtil Code() {
            return a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IGlobalUtil.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    getFilePath(parcel.readString(), IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    registerActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    unregisterActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    String filePathDirect = getFilePathDirect(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirect);
                    return true;
                case 5:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    String filePathDirectByCacheType = getFilePathDirectByCacheType(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirectByCacheType);
                    return true;
                case 6:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    com.huawei.hms.ads.uiengine.b multiMediaPlayingManager = getMultiMediaPlayingManager();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(multiMediaPlayingManager != null ? multiMediaPlayingManager.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    boolean zIsFreedomWindowMode = isFreedomWindowMode(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsFreedomWindowMode ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    Bundle bundleCallMethod = callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleCallMethod != null) {
                        parcel2.writeInt(1);
                        bundleCallMethod.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static IGlobalUtil Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGlobalUtil.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGlobalUtil)) ? new a(iBinder) : (IGlobalUtil) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(IGlobalUtil iGlobalUtil) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iGlobalUtil == null) {
                return false;
            }
            a.Code = iGlobalUtil;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback);

    String getFilePathDirect(String str);

    String getFilePathDirectByCacheType(String str, int i);

    com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager();

    boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper);

    void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements IGlobalUtil {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public String getFilePathDirect(String str) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public String getFilePathDirectByCacheType(String str, int i) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }
}
