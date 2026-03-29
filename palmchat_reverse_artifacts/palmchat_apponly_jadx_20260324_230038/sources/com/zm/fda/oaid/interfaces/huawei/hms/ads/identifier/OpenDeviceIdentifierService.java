package com.zm.fda.oaid.interfaces.huawei.hms.ads.identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.zm.fda.oaid.Z2500.OO22Z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class Stub {
        public static final String DESCRIPTOR = OO22Z.a("Y29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U=");
        public static final int TRANSACTION_GETOAID = 1;
        public static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;

        /* JADX INFO: compiled from: SearchBox */
        public static class Proxy implements OpenDeviceIdentifierService {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }

            @Override // com.zm.fda.oaid.interfaces.huawei.hms.ads.identifier.OpenDeviceIdentifierService
            public String getOaid() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zm.fda.oaid.interfaces.huawei.hms.ads.identifier.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static OpenDeviceIdentifierService asInterface(IBinder iBinder) {
            return new Proxy(iBinder);
        }
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
