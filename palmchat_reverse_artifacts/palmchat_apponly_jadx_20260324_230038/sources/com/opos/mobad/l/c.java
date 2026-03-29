package com.opos.mobad.l;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface c extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.opos.mobad.l.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0754a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f8970a;

            public C0754a(IBinder iBinder) {
                this.f8970a = iBinder;
            }

            @Override // com.opos.mobad.l.c
            public void a(AdHelper.AdHelperData adHelperData) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.opos.mobad.show.OnFallbackChangeListener");
                    if (adHelperData != null) {
                        parcelObtain.writeInt(1);
                        adHelperData.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f8970a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8970a;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.opos.mobad.show.OnFallbackChangeListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0754a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.opos.mobad.show.OnFallbackChangeListener");
                return true;
            }
            parcel.enforceInterface("com.opos.mobad.show.OnFallbackChangeListener");
            a(parcel.readInt() != 0 ? AdHelper.AdHelperData.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(AdHelper.AdHelperData adHelperData) throws RemoteException;
}
