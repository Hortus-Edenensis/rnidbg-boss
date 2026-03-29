package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.dn;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblb implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f19322a;

    public pblb(IBinder iBinder) {
        this.f19322a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f19322a;
    }

    public final String u() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "270800", new byte[]{32, 58, 78, 2, dn.l, 52, 36, 5, 47, 101, 48, 52, dn.k, ByteCompanionObject.MAX_VALUE, 26, 55, 33, 26, 100, 101, 38, 59, 87, 77, 29, 62, 21, Utf8.REPLACEMENT_BYTE, 69, 38, 10, 17, 74, 72, 46, 46, 53, 26, 72, 102, 55, 48, 81, 74, dn.l, 36, 52}));
            this.f19322a.transact(3, parcelObtain, parcelObtain2, 0);
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
