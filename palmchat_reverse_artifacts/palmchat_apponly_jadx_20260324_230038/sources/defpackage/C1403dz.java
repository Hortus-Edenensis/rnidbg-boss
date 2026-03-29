package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: dz, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "delegate", "Lbz;", "a", "Laz;", "Lv53;", "node", "", t.l, "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class C1403dz {
    public static final <T> bz<T> a(Continuation<? super T> continuation) {
        if (!(continuation instanceof ce1)) {
            return new bz<>(continuation, 1);
        }
        bz<T> bzVarI = ((ce1) continuation).i();
        if (bzVarI != null) {
            if (!bzVarI.H()) {
                bzVarI = null;
            }
            if (bzVarI != null) {
                return bzVarI;
            }
        }
        return new bz<>(continuation, 2);
    }

    public static final void b(az<?> azVar, v53 v53Var) {
        azVar.m(new jv4(v53Var));
    }
}
