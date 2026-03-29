package com.ss.android.downloadlib.u.u;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class u extends Binder implements b {
        private static String u = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.u.u.b$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0849u implements b {
            private IBinder u;

            public C0849u(IBinder iBinder) {
                if (TextUtils.isEmpty(u.u)) {
                    JSONObject jSONObjectA = l.a();
                    String unused = u.u = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("t"), jSONObjectA.optString("s"));
                }
                this.u = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.u;
            }

            @Override // com.ss.android.downloadlib.u.u.b
            public void u(nr nrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(u.u);
                    if (nrVar != null) {
                        parcelObtain.writeInt(1);
                        nrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.u.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(u);
                u(parcel.readInt() != 0 ? nr.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(u);
            return true;
        }

        public static b u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(u);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
                return (b) iInterfaceQueryLocalInterface;
            }
            return new C0849u(iBinder);
        }
    }

    void u(nr nrVar) throws RemoteException;
}
