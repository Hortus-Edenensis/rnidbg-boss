package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ym2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements ym2 {

        /* JADX INFO: renamed from: ym2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1294a implements ym2 {
            public static ym2 b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f22230a;

            public C1294a(IBinder iBinder) {
                this.f22230a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22230a;
            }

            @Override // defpackage.ym2
            public void b(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.mcs.aidl.IMcsSdkService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f22230a.transact(1, parcelObtain, parcelObtain2, 0) || a.C() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.C().b(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ym2 C() {
            return C1294a.b;
        }

        public static ym2 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.mcs.aidl.IMcsSdkService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ym2)) ? new C1294a(iBinder) : (ym2) iInterfaceQueryLocalInterface;
        }
    }

    void b(Bundle bundle);
}
