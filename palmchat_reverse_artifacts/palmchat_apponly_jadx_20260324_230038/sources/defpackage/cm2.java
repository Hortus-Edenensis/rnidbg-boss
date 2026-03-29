package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface cm2 extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a extends Binder implements cm2 {

        /* JADX INFO: renamed from: cm2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0033a implements cm2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f2017a;

            public C0033a(IBinder iBinder) {
                this.f2017a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2017a;
            }

            @Override // defpackage.cm2
            public void d(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f2017a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static cm2 g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof cm2)) ? new C0033a(iBinder) : (cm2) iInterfaceQueryLocalInterface;
        }
    }

    void d(String str, String str2) throws RemoteException;
}
