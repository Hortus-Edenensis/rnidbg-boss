package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class sr0 {
    public byte[] a(List<pr0> list) {
        ArrayList<Bundle> arrayListI = hv.i(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListI);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
