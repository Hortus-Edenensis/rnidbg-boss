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
public final class ls3 implements mt4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f19067a;
    public mt4[] b;

    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        d(map);
        return b(xsVar);
    }

    public final qx4 b(xs xsVar) throws NotFoundException {
        mt4[] mt4VarArr = this.b;
        if (mt4VarArr != null) {
            for (mt4 mt4Var : mt4VarArr) {
                try {
                    return mt4Var.a(xsVar, this.f19067a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public qx4 c(xs xsVar) throws NotFoundException {
        if (this.b == null) {
            d(null);
        }
        return b(xsVar);
    }

    public void d(Map<DecodeHintType, ?> map) {
        this.f19067a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new ks3(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new mp4());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new ou0());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new nn());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new va4());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new ie3());
            }
            if (z && z2) {
                arrayList.add(new ks3(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new ks3(map));
            }
            arrayList.add(new mp4());
            arrayList.add(new ou0());
            arrayList.add(new nn());
            arrayList.add(new va4());
            arrayList.add(new ie3());
            if (z2) {
                arrayList.add(new ks3(map));
            }
        }
        this.b = (mt4[]) arrayList.toArray(new mt4[arrayList.size()]);
    }

    @Override // defpackage.mt4
    public void reset() {
        mt4[] mt4VarArr = this.b;
        if (mt4VarArr != null) {
            for (mt4 mt4Var : mt4VarArr) {
                mt4Var.reset();
            }
        }
    }
}
