package a.a.c.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a.a.c.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractBinderC0004a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f1086a = 0;

        /* JADX INFO: renamed from: a.a.c.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0005a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1087a;

            public C0005a(IBinder iBinder) {
                this.f1087a = iBinder;
            }

            @Override // a.a.c.a.a.a
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f1087a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0004a.f1086a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1087a;
            }
        }
    }

    String a(String str);
}
