package cn.fly.verify;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dy extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f2210a;
    private volatile String b;
    private volatile boolean c = false;
    private final String d;

    public dy() {
        String strA = ba.a("043eMgffhhf<jRfkSjSgfZgPgfflhfNei0gffifehj3h_flfffk'ehPhfgf5fQfkfehfgkiigngkhmim[fii*hkRfe)fn");
        this.d = strA;
        attachInterface(this, strA);
    }

    public dy a(CountDownLatch countDownLatch) {
        this.f2210a = countDownLatch;
        return this;
    }

    public boolean b() {
        return this.c;
    }

    @Override // android.os.Binder, android.os.IBinder
    public String getInterfaceDescriptor() {
        return this.d;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readLong(), parcel.readInt() > 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
        } else {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(this.d);
                return true;
            }
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readInt() > 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        }
        parcel2.writeNoException();
        return true;
    }

    public String a() {
        return this.b;
    }

    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    public void a(int i, Bundle bundle) {
        try {
            if (bundle.containsKey(ba.a("0105gf*fGfjfkfefjghNifTgg"))) {
                this.b = bundle.getString(ba.a("0105gf0f6fjfkfefjgh7if<gg"));
            } else if (bundle.containsKey(ba.a("017JgfEfJfjfkfefj(iOfkfhfk!k,fjhjPkfkh"))) {
                this.c = bundle.getBoolean(ba.a("017'gfJf3fjfkfefjViVfkfhfkVkKfjhj1kfkh"));
            }
            CountDownLatch countDownLatch = this.f2210a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
