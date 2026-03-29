package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pbla implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f19321a;

    public pbla(IBinder iBinder) {
        this.f19321a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f19321a;
    }

    public final String u() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7ed6af", new byte[]{37, 104, 26, 12, 75, 126, 48, 77, 38, 40, 41, 119, 18, 76, 90, 116, 34, 77, 54, 99, 104, 102, 30, 70, 82, Utf8.REPLACEMENT_BYTE, 27, 84, 48, 104, 2, 98, 1, 75, 93, 116, 29, 64, 48, 104, 50, 110, 17, 75, 91, 99, 7, 65, 39, 112, 47, 100, 18}));
            this.f19321a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable unused) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
