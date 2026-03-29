package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface ISplashApi extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.ISplashApi";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements ISplashApi {
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
        static final int f6605a = 11;
        static final int b = 12;
        static final int c = 13;
        static final int d = 14;
        static final int e = 15;
        static final int f = 16;
        static final int g = 17;
        static final int h = 18;
        static final int i = 19;
        static final int j = 20;
        static final int k = 21;
        static final int l = 22;
        static final int m = 23;
        static final int n = 24;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements ISplashApi {
            public static ISplashApi Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return ISplashApi.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(23, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().callMethod(str, iObjectWrapper, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.V.transact(24, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().callMethodForResult(str, iObjectWrapper, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isDestroyed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.V.transact(19, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().isDestroyed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isFinishing() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.V.transact(18, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().isFinishing();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdDismissed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(7, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().notifyAdDismissed();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdFailedToLoad(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(9, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().notifyAdFailedToLoad(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public String notifyAdLoaded() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.V.transact(2, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().notifyAdLoaded();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdFailToDisplay() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(6, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onAdFailToDisplay();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdShowEnd(long j, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(15, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onAdShowEnd(j, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onDisplayTimeUp() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(12, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onDisplayTimeUp();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onEasterEggPrepare() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(20, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onEasterEggPrepare();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onFeedback(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(14, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onFeedback(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoadFailed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(11, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onMaterialLoadFailed();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoaded() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(5, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onMaterialLoaded();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onSkipAd(int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (this.V.transact(13, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onSkipAd(i, i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onStartEasterEggFailed(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(17, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onStartEasterEggFailed(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean onTouch(int i, int i2, long j, String str, int i3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    try {
                        if (!this.V.transact(1, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                            boolean zOnTouch = b.Code().onTouch(i, i2, j, str, i3);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zOnTouch;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
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

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean processWhyEventUnified() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.V.transact(21, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().processWhyEventUnified();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void removeExSplashBlock() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(10, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().removeExSplashBlock();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportEvents(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(16, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().reportEvents(str, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportShowStartEvent() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.V.transact(3, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().reportShowStartEvent();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportSplashEvent(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(22, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().reportSplashEvent(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void toShowSpare(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.V.transact(8, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().toShowSpare(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void updatePhyShowStart(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    if (this.V.transact(4, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().updatePhyShowStart(j);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, ISplashApi.DESCRIPTOR);
        }

        public static ISplashApi Code() {
            return a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString(ISplashApi.DESCRIPTOR);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zOnTouch = onTouch(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnTouch ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    String strNotifyAdLoaded = notifyAdLoaded();
                    parcel2.writeNoException();
                    parcel2.writeString(strNotifyAdLoaded);
                    return true;
                case 3:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportShowStartEvent();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    updatePhyShowStart(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onMaterialLoaded();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onAdFailToDisplay();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    notifyAdDismissed();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    toShowSpare(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    notifyAdFailedToLoad(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    removeExSplashBlock();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onMaterialLoadFailed();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onDisplayTimeUp();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onSkipAd(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onFeedback(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onAdShowEnd(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportEvents(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onStartEasterEggFailed(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zIsFinishing = isFinishing();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsFinishing ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zIsDestroyed = isDestroyed();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDestroyed ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onEasterEggPrepare();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zProcessWhyEventUnified = processWhyEventUnified();
                    parcel2.writeNoException();
                    parcel2.writeInt(zProcessWhyEventUnified ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportSplashEvent(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    Bundle bundleCallMethodForResult = callMethodForResult(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleCallMethodForResult != null) {
                        parcel2.writeInt(1);
                        bundleCallMethodForResult.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        public static ISplashApi Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISplashApi.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISplashApi)) ? new a(iBinder) : (ISplashApi) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(ISplashApi iSplashApi) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSplashApi == null) {
                return false;
            }
            a.Code = iSplashApi;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    boolean isDestroyed();

    boolean isFinishing();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i);

    String notifyAdLoaded();

    void onAdFailToDisplay();

    void onAdShowEnd(long j, int i);

    void onDisplayTimeUp();

    void onEasterEggPrepare();

    void onFeedback(int i);

    void onMaterialLoadFailed();

    void onMaterialLoaded();

    void onSkipAd(int i, int i2);

    void onStartEasterEggFailed(Bundle bundle);

    boolean onTouch(int i, int i2, long j, String str, int i3);

    boolean processWhyEventUnified();

    void removeExSplashBlock();

    void reportEvents(String str, Bundle bundle);

    void reportShowStartEvent();

    void reportSplashEvent(Bundle bundle);

    void toShowSpare(int i);

    void updatePhyShowStart(long j);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ISplashApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isDestroyed() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isFinishing() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public String notifyAdLoaded() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean onTouch(int i, int i2, long j, String str, int i3) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean processWhyEventUnified() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdDismissed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdFailToDisplay() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onDisplayTimeUp() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onEasterEggPrepare() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoadFailed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoaded() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void removeExSplashBlock() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportShowStartEvent() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdFailedToLoad(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onFeedback(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onStartEasterEggFailed(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportSplashEvent(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void toShowSpare(int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void updatePhyShowStart(long j) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdShowEnd(long j, int i) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onSkipAd(int i, int i2) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportEvents(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        }
    }
}
