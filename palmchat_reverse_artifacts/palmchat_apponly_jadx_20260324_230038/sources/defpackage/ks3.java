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
public final class ks3 extends a84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a84[] f18822a;

    public ks3(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new ms3(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new wd0(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new yd0());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new ud0());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new bp2());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new sd0());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new zq4());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new ar4());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ms3(map));
            arrayList.add(new wd0());
            arrayList.add(new sd0());
            arrayList.add(new yd0());
            arrayList.add(new ud0());
            arrayList.add(new bp2());
            arrayList.add(new zq4());
            arrayList.add(new ar4());
        }
        this.f18822a = (a84[]) arrayList.toArray(new a84[arrayList.size()]);
    }

    @Override // defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (a84 a84Var : this.f18822a) {
            try {
                return a84Var.b(i, etVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.a84, defpackage.mt4
    public void reset() {
        for (a84 a84Var : this.f18822a) {
            a84Var.reset();
        }
    }
}
