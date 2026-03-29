package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class xh implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f21957a;
    public String b;

    public xh(IBinder iBinder) {
        this.b = "";
        this.f21957a = iBinder;
        this.b = rv2.h("8lAhWp7NB89J3VIJU4lIGfGqvEuhZG7tBjI4IuOrU/y3j/vpb/c+G/Rylr/l3ZwQ");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f21957a;
    }

    public String getOAID() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.b);
            this.f21957a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Throwable th) {
            try {
                p63.f("AsusAdvertisingInterface", "get ids-o e: " + th.getMessage());
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
