package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a-\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Landroid/os/Parcelable;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "c", "d", "R", "bytes", "Landroid/os/Parcelable$Creator;", "creator", "a", "([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;", t.l, "zx-core_release"}, k = 2, mv = {1, 4, 0})
public final class dc4 {
    public static final <R extends Parcelable> R a(byte[] bArr, Parcelable.Creator<R> creator) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        R r = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        Intrinsics.checkExpressionValueIsNotNull(r, "r");
        return r;
    }

    public static final <R extends Parcelable> R b(byte[] bArr, Parcelable.Creator<R> creator) {
        try {
            return (R) a(bArr, creator);
        } catch (Exception e) {
            n63.g.k(e);
            return null;
        }
    }

    public static final byte[] c(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.setDataPosition(0);
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] r = parcelObtain.marshall();
        parcelObtain.recycle();
        Intrinsics.checkExpressionValueIsNotNull(r, "r");
        return r;
    }

    public static final byte[] d(Parcelable parcelable) {
        try {
            return c(parcelable);
        } catch (Exception e) {
            n63.g.k(e);
            return null;
        }
    }
}
