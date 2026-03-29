package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ms3 extends a84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t36[] f19357a;

    public ms3(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new oj1());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new o36());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new qj1());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new v36());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new oj1());
            arrayList.add(new qj1());
            arrayList.add(new v36());
        }
        this.f19357a = (t36[]) arrayList.toArray(new t36[arrayList.size()]);
    }

    @Override // defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] iArrO = t36.o(etVar);
        for (t36 t36Var : this.f19357a) {
            try {
                qx4 qx4VarL = t36Var.l(i, etVar, iArrO, map);
                boolean z = qx4VarL.b() == BarcodeFormat.EAN_13 && qx4VarL.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return qx4VarL;
                }
                qx4 qx4Var = new qx4(qx4VarL.g().substring(1), qx4VarL.d(), qx4VarL.f(), BarcodeFormat.UPC_A);
                qx4Var.h(qx4VarL.e());
                return qx4Var;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.a84, defpackage.mt4
    public void reset() {
        for (t36 t36Var : this.f19357a) {
            t36Var.reset();
        }
    }
}
