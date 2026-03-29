package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.hms.ads.uiengine.c;
import com.huawei.hms.ads.uiengine.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IRemoteCreator extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IRemoteCreator";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements IRemoteCreator {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int D = 9;
        static final int F = 8;
        static final int I = 3;
        static final int L = 10;
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f6604a = 11;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements IRemoteCreator {
            public static IRemoteCreator Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return IRemoteCreator.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void bindData(IObjectWrapper iObjectWrapper, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (this.V.transact(6, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().bindData(iObjectWrapper, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void destroyView(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(8, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().destroyView(iObjectWrapper);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public d getUiEngineUtil() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (!this.V.transact(9, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getUiEngineUtil();
                    }
                    parcelObtain2.readException();
                    return d.b.Code(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public String getVersion() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (!this.V.transact(1, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getVersion();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newBannerTemplateView(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.V.transact(5, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().newBannerTemplateView(bundle);
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.V.transact(4, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().newNativeTemplateView(bundle, cVar);
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.V.transact(7, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().newRemoteViewDelegate(iObjectWrapper, str, bundle);
                    }
                    parcelObtain2.readException();
                    return IRemoteViewDelegate.b.Code(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newRewardTemplateView() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (!this.V.transact(10, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().newRewardTemplateView();
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSplashApi != null ? iSplashApi.asBinder() : null);
                    if (!this.V.transact(3, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().newSplashTemplateView(bundle, iSplashApi);
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iGlobalUtil != null ? iGlobalUtil.asBinder() : null);
                    if (this.V.transact(2, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().setGlobalUtil(iGlobalUtil);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setSdkInfo(int i, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(11, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().setSdkInfo(i, i2, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, IRemoteCreator.DESCRIPTOR);
        }

        public static IRemoteCreator Code() {
            return a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IRemoteCreator.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    setGlobalUtil(IGlobalUtil.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewSplashTemplateView = newSplashTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ISplashApi.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewSplashTemplateView != null ? iObjectWrapperNewSplashTemplateView.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewNativeTemplateView = newNativeTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, c.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewNativeTemplateView != null ? iObjectWrapperNewNativeTemplateView.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewBannerTemplateView = newBannerTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewBannerTemplateView != null ? iObjectWrapperNewBannerTemplateView.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    bindData(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IRemoteViewDelegate iRemoteViewDelegateNewRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iRemoteViewDelegateNewRemoteViewDelegate != null ? iRemoteViewDelegateNewRemoteViewDelegate.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    destroyView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    d uiEngineUtil = getUiEngineUtil();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uiEngineUtil != null ? uiEngineUtil.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewRewardTemplateView = newRewardTemplateView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewRewardTemplateView != null ? iObjectWrapperNewRewardTemplateView.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    setSdkInfo(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static IRemoteCreator Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteCreator.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteCreator)) ? new a(iBinder) : (IRemoteCreator) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(IRemoteCreator iRemoteCreator) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteCreator == null) {
                return false;
            }
            a.Code = iRemoteCreator;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void bindData(IObjectWrapper iObjectWrapper, String str);

    void destroyView(IObjectWrapper iObjectWrapper);

    d getUiEngineUtil();

    String getVersion();

    IObjectWrapper newBannerTemplateView(Bundle bundle);

    IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar);

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    IObjectWrapper newRewardTemplateView();

    IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi);

    void setGlobalUtil(IGlobalUtil iGlobalUtil);

    void setSdkInfo(int i, int i2, Bundle bundle);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements IRemoteCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public d getUiEngineUtil() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public String getVersion() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newBannerTemplateView(Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newNativeTemplateView(Bundle bundle, c cVar) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newRewardTemplateView() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void destroyView(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void bindData(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void setSdkInfo(int i, int i2, Bundle bundle) {
        }
    }
}
