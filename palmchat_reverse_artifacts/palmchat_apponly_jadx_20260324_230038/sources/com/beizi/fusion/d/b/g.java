package com.beizi.fusion.d.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface g extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.beizi.fusion.d.b.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0138a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4648a;

            public C0138a(IBinder iBinder) {
                this.f4648a = iBinder;
            }

            @Override // com.beizi.fusion.d.b.g
            public String a() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f4648a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable unused) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4648a;
            }
        }
    }

    String a();
}
