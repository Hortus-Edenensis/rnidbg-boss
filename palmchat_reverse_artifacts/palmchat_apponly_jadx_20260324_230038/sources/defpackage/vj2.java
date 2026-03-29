package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vj2 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f21459a;
    public String b = rv2.h("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==");

    public vj2(IBinder iBinder) {
        this.f21459a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String getOaid() throws RemoteException {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken(this.b);
                this.f21459a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Exception e) {
                p63.f("HuaweiAdvertisingInterface", "getIds error: " + e.getMessage());
                parcelObtain2.recycle();
                parcelObtain.recycle();
                string = "";
            }
            return string;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
