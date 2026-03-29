package com.huawei.appmarket.service.externalservice.activityresult;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IActivityResult extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult";

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements IActivityResult {
        static final int Code = 1;

        /* JADX INFO: renamed from: com.huawei.appmarket.service.externalservice.activityresult.IActivityResult$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0405a implements IActivityResult {
            public static IActivityResult b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f6491a;

            public C0405a(IBinder iBinder) {
                this.f6491a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6491a;
            }

            @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
            public void onActivityCancel(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IActivityResult.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.f6491a.transact(1, parcelObtain, parcelObtain2, 0) || a.Code() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.Code().onActivityCancel(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, IActivityResult.DESCRIPTOR);
        }

        public static IActivityResult Code() {
            return C0405a.b;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(IActivityResult.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(IActivityResult.DESCRIPTOR);
            onActivityCancel(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static IActivityResult Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IActivityResult.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IActivityResult)) ? new C0405a(iBinder) : (IActivityResult) iInterfaceQueryLocalInterface;
        }

        public static boolean Code(IActivityResult iActivityResult) {
            if (C0405a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iActivityResult == null) {
                return false;
            }
            C0405a.b = iActivityResult;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    void onActivityCancel(int i);
}
