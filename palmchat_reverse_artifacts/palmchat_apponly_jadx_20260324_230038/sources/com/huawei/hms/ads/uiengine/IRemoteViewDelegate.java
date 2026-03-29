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
public interface IRemoteViewDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IRemoteViewDelegate";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends Binder implements IRemoteViewDelegate {
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

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements IRemoteViewDelegate {
            public static IRemoteViewDelegate Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return IRemoteViewDelegate.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public IObjectWrapper getView() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (!this.V.transact(1, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().getView();
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onCreate(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.V.transact(2, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onCreate(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onDestroy() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(3, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onDestroy();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onPause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(4, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onPause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onRestart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(8, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onRestart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onResume() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(5, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onResume();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(6, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.V.transact(7, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().onStop();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public Bundle sendCommand(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.V.transact(10, parcelObtain, parcelObtain2, 0) && b.Code() != null) {
                        return b.Code().sendCommand(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(9, parcelObtain, parcelObtain2, 0) || b.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.Code().setCallback(iPPSUiEngineCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, IRemoteViewDelegate.DESCRIPTOR);
        }

        public static IRemoteViewDelegate Code() {
            return a.Code;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IRemoteViewDelegate.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(view != null ? view.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onCreate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 3:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onDestroy();
                    break;
                case 4:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onPause();
                    break;
                case 5:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onResume();
                    break;
                case 6:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onStart();
                    break;
                case 7:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onStop();
                    break;
                case 8:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onRestart();
                    break;
                case 9:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    setCallback(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    break;
                case 10:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    Bundle bundleSendCommand = sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleSendCommand != null) {
                        parcel2.writeInt(1);
                        bundleSendCommand.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }

        public static IRemoteViewDelegate Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteViewDelegate.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteViewDelegate)) ? new a(iBinder) : (IRemoteViewDelegate) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(IRemoteViewDelegate iRemoteViewDelegate) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteViewDelegate == null) {
                return false;
            }
            a.Code = iRemoteViewDelegate;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    Bundle sendCommand(String str, Bundle bundle);

    void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements IRemoteViewDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public IObjectWrapper getView() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public Bundle sendCommand(String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onDestroy() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onPause() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onRestart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onResume() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStop() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onCreate(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }
}
