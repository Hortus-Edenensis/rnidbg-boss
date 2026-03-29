package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jr6 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f18486a;
    public String b = rv2.h("Mpy0fkBSw1N+kug2cBPj2Z07jpK2SYpu9oSV4B2lEuO7ZdtoaGwNjuH9BjHR80mN");

    public jr6(IBinder iBinder) {
        this.f18486a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String getOAID() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.b);
            this.f18486a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Throwable th) {
            try {
                p63.f("ZuiAdvertisingInterface", "get Ids-o error: " + th.getMessage());
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
