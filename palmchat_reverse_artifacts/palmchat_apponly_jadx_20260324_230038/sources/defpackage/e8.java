package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e8 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f17230a;
    public String b;

    public e8(IBinder iBinder) {
        this.b = "";
        this.f17230a = iBinder;
        this.b = rv2.h("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjKewmlEeKVcapnVp59DHSw2ZuSa3pDDty/LQ1R0HbmN4Tu7alH/m3nVMfORBLpozB8=");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String getId() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.b);
            this.f17230a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Throwable th) {
            try {
                p63.f("AdvertisingInterface", "getId error: " + th.getMessage());
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
