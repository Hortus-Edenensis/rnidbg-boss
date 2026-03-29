package com.ss.android.downloadlib.u.u;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.u.u.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface fx extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class u extends Binder implements fx {
        private static String u = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.u.u.fx$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0850u implements fx {
            private IBinder u;

            public C0850u(IBinder iBinder) {
                if (TextUtils.isEmpty(u.u)) {
                    JSONObject jSONObjectA = l.a();
                    String unused = u.u = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(t.k), jSONObjectA.optString("s"));
                }
                this.u = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.u;
            }

            @Override // com.ss.android.downloadlib.u.u.fx
            public void u(nr nrVar, b bVar) throws RemoteException {
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
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.u.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(u);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(u);
            u(parcel.readInt() != 0 ? nr.CREATOR.createFromParcel(parcel) : null, b.u.u(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static fx u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(u);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fx)) {
                return (fx) iInterfaceQueryLocalInterface;
            }
            return new C0850u(iBinder);
        }
    }

    void u(nr nrVar, b bVar) throws RemoteException;
}
