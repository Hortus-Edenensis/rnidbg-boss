package com.zenmen.openapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface b extends IInterface {
    String getAndroidId() throws RemoteException;

    String getChanId() throws RemoteException;

    String getDeviceId() throws RemoteException;

    String getImei() throws RemoteException;

    String getLanguage() throws RemoteException;

    String getMac() throws RemoteException;

    String getNetModel() throws RemoteException;

    String getVersionCode() throws RemoteException;

    String getVersionName() throws RemoteException;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements b {
        static final int TRANSACTION_getAndroidId = 3;
        static final int TRANSACTION_getChanId = 7;
        static final int TRANSACTION_getDeviceId = 2;
        static final int TRANSACTION_getImei = 1;
        static final int TRANSACTION_getLanguage = 9;
        static final int TRANSACTION_getMac = 6;
        static final int TRANSACTION_getNetModel = 8;
        static final int TRANSACTION_getVersionCode = 5;
        static final int TRANSACTION_getVersionName = 4;

        /* JADX INFO: renamed from: com.zenmen.openapi.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0941a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12018a;

            public C0941a(IBinder iBinder) {
                this.f12018a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12018a;
            }
        }

        public a() {
            attachInterface(this, "com.zenmen.openapi.IDeviceManager");
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zenmen.openapi.IDeviceManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0941a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.zenmen.openapi.IDeviceManager");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.zenmen.openapi.IDeviceManager");
                return true;
            }
            switch (i) {
                case 1:
                    String imei = getImei();
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 2:
                    String deviceId = getDeviceId();
                    parcel2.writeNoException();
                    parcel2.writeString(deviceId);
                    return true;
                case 3:
                    String androidId = getAndroidId();
                    parcel2.writeNoException();
                    parcel2.writeString(androidId);
                    return true;
                case 4:
                    String versionName = getVersionName();
                    parcel2.writeNoException();
                    parcel2.writeString(versionName);
                    return true;
                case 5:
                    String versionCode = getVersionCode();
                    parcel2.writeNoException();
                    parcel2.writeString(versionCode);
                    return true;
                case 6:
                    String mac = getMac();
                    parcel2.writeNoException();
                    parcel2.writeString(mac);
                    return true;
                case 7:
                    String chanId = getChanId();
                    parcel2.writeNoException();
                    parcel2.writeString(chanId);
                    return true;
                case 8:
                    String netModel = getNetModel();
                    parcel2.writeNoException();
                    parcel2.writeString(netModel);
                    return true;
                case 9:
                    String language = getLanguage();
                    parcel2.writeNoException();
                    parcel2.writeString(language);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
