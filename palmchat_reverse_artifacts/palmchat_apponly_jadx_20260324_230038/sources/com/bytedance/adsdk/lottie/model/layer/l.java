package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.adsdk.lottie.model.nr;
import com.bytedance.adsdk.lottie.model.nr.my;
import com.bytedance.adsdk.lottie.u.nr.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l extends fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f4987a;
    private com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> bg;
    private com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> bq;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> c;
    private com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> dw;
    private com.bytedance.adsdk.lottie.u.nr.u<Typeface, Typeface> gi;
    private final Paint jk;
    private final k k;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> kj;
    private final Map<com.bytedance.adsdk.lottie.model.b, List<com.bytedance.adsdk.lottie.u.u.b>> l;
    private final LongSparseArray<String> mv;
    private final com.bytedance.adsdk.lottie.n my;
    private final RectF n;
    private final com.bytedance.adsdk.lottie.iz o;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> q;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> qq;
    private final List<u> s;
    private com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> sx;
    private final Paint t;
    private final StringBuilder x;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> z;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.l$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[nr.u.values().length];
            u = iArr;
            try {
                iArr[nr.u.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[nr.u.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[nr.u.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private float nr;
        private String u;

        private u() {
            this.u = "";
            this.nr = 0.0f;
        }

        public void u(String str, float f) {
            this.u = str;
            this.nr = f;
        }
    }

    public l(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        com.bytedance.adsdk.lottie.model.u.nr nrVar;
        com.bytedance.adsdk.lottie.model.u.nr nrVar2;
        com.bytedance.adsdk.lottie.model.u.u uVar;
        com.bytedance.adsdk.lottie.model.u.u uVar2;
        super(nVar, nVar2);
        this.x = new StringBuilder(2);
        this.n = new RectF();
        this.f4987a = new Matrix();
        int i = 1;
        this.jk = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.l.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.t = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.l.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.l = new HashMap();
        this.mv = new LongSparseArray<>();
        this.s = new ArrayList();
        this.my = nVar;
        this.o = nVar2.u();
        k kVarU = nVar2.bg().u();
        this.k = kVarU;
        kVarU.u(this);
        u(kVarU);
        com.bytedance.adsdk.lottie.model.u.t tVarBq = nVar2.bq();
        if (tVarBq != null && (uVar2 = tVarBq.u) != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU = uVar2.u();
            this.sx = uVarU;
            uVarU.u(this);
            u(this.sx);
        }
        if (tVarBq != null && (uVar = tVarBq.nr) != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVarU2 = uVar.u();
            this.bq = uVarU2;
            uVarU2.u(this);
            u(this.bq);
        }
        if (tVarBq != null && (nrVar2 = tVarBq.fx) != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU3 = nrVar2.u();
            this.c = uVarU3;
            uVarU3.u(this);
            u(this.c);
        }
        if (tVarBq == null || (nrVar = tVarBq.b) == null) {
            return;
        }
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU4 = nrVar.u();
        this.qq = uVarU4;
        uVarU4.u(this);
        u(this.qq);
    }

    private boolean fx(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
        com.bytedance.adsdk.lottie.model.nr nrVarX = this.k.x();
        com.bytedance.adsdk.lottie.model.fx fxVar = this.o.my().get(nrVarX.nr);
        if (fxVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(nrVarX, matrix);
        if (this.my.z()) {
            u(nrVarX, matrix, fxVar, canvas);
        } else {
            u(nrVarX, fxVar, canvas);
        }
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.o.b().width(), this.o.b().height());
    }

    private void u(com.bytedance.adsdk.lottie.model.nr nrVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar = this.bg;
        if (uVar != null) {
            this.jk.setColor(uVar.x().intValue());
        } else {
            com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2 = this.sx;
            if (uVar2 != null) {
                this.jk.setColor(uVar2.x().intValue());
            } else {
                this.jk.setColor(nrVar.n);
            }
        }
        com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar3 = this.dw;
        if (uVar3 != null) {
            this.t.setColor(uVar3.x().intValue());
        } else {
            com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar4 = this.bq;
            if (uVar4 != null) {
                this.t.setColor(uVar4.x().intValue());
            } else {
                this.t.setColor(nrVar.f4996a);
            }
        }
        int iIntValue = ((this.b.u() == null ? 100 : this.b.u().x().intValue()) * 255) / 100;
        this.jk.setAlpha(iIntValue);
        this.t.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar5 = this.q;
        if (uVar5 != null) {
            this.t.setStrokeWidth(uVar5.x().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar6 = this.c;
        if (uVar6 != null) {
            this.t.setStrokeWidth(uVar6.x().floatValue());
        } else {
            this.t.setStrokeWidth(nrVar.jk * com.bytedance.adsdk.lottie.pn.a.u());
        }
    }

    private u nr(int i) {
        for (int size = this.s.size(); size < i; size++) {
            this.s.add(new u());
        }
        return this.s.get(i - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(com.bytedance.adsdk.lottie.model.nr nrVar, Matrix matrix, com.bytedance.adsdk.lottie.model.fx fxVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        int i;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar = this.z;
        if (uVar != null) {
            fFloatValue = uVar.x().floatValue();
        } else {
            fFloatValue = nrVar.fx;
        }
        float f = fFloatValue / 100.0f;
        float fU = com.bytedance.adsdk.lottie.pn.a.u(matrix);
        List<String> listU = u(nrVar.u);
        int size = listU.size();
        float f2 = nrVar.pn / 10.0f;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar2 = this.kj;
        if (uVar2 != null) {
            fFloatValue2 = uVar2.x().floatValue();
        } else {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar3 = this.qq;
            if (uVar3 != null) {
                fFloatValue2 = uVar3.x().floatValue();
            }
            float f3 = f2;
            i = 0;
            int i2 = -1;
            while (i < size) {
                String str = listU.get(i);
                PointF pointF = nrVar.mv;
                int i3 = i;
                List<u> listU2 = u(str, pointF == null ? 0.0f : pointF.x, fxVar, f, f3, true);
                int i4 = 0;
                while (i4 < listU2.size()) {
                    u uVar4 = listU2.get(i4);
                    int i5 = i2 + 1;
                    canvas.save();
                    u(canvas, nrVar, i5, uVar4.nr);
                    u(uVar4.u, nrVar, fxVar, canvas, fU, f, f3);
                    canvas.restore();
                    i4++;
                    listU2 = listU2;
                    i2 = i5;
                }
                i = i3 + 1;
            }
        }
        f2 += fFloatValue2;
        float f32 = f2;
        i = 0;
        int i22 = -1;
        while (i < size) {
        }
    }

    private void u(String str, com.bytedance.adsdk.lottie.model.nr nrVar, com.bytedance.adsdk.lottie.model.fx fxVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.lottie.model.b bVar = this.o.k().get(com.bytedance.adsdk.lottie.model.b.u(str.charAt(i), fxVar.u(), fxVar.fx()));
            if (bVar != null) {
                u(bVar, f2, nrVar, canvas);
                canvas.translate((((float) bVar.nr()) * f2 * com.bytedance.adsdk.lottie.pn.a.u()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(com.bytedance.adsdk.lottie.model.nr nrVar, com.bytedance.adsdk.lottie.model.fx fxVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        int size;
        int i;
        Typeface typefaceU = u(fxVar);
        if (typefaceU == null) {
            return;
        }
        String strFx = nrVar.u;
        bq bqVarKj = this.my.kj();
        if (bqVarKj != null) {
            strFx = bqVarKj.fx(t(), strFx);
        }
        this.jk.setTypeface(typefaceU);
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar = this.z;
        if (uVar != null) {
            fFloatValue = uVar.x().floatValue();
        } else {
            fFloatValue = nrVar.fx;
        }
        this.jk.setTextSize(com.bytedance.adsdk.lottie.pn.a.u() * fFloatValue);
        this.t.setTypeface(this.jk.getTypeface());
        this.t.setTextSize(this.jk.getTextSize());
        float f = nrVar.pn / 10.0f;
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar2 = this.kj;
        if (uVar2 != null) {
            fFloatValue2 = uVar2.x().floatValue();
        } else {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVar3 = this.qq;
            if (uVar3 != null) {
                fFloatValue2 = uVar3.x().floatValue();
            }
            float fU = ((f * com.bytedance.adsdk.lottie.pn.a.u()) * fFloatValue) / 100.0f;
            List<String> listU = u(strFx);
            size = listU.size();
            i = 0;
            int i2 = -1;
            while (i < size) {
                String str = listU.get(i);
                PointF pointF = nrVar.mv;
                int i3 = i;
                List<u> listU2 = u(str, pointF == null ? 0.0f : pointF.x, fxVar, 0.0f, fU, false);
                for (int i4 = 0; i4 < listU2.size(); i4++) {
                    u uVar4 = listU2.get(i4);
                    i2++;
                    canvas.save();
                    u(canvas, nrVar, i2, uVar4.nr);
                    u(uVar4.u, nrVar, canvas, fU);
                    canvas.restore();
                }
                i = i3 + 1;
            }
        }
        f += fFloatValue2;
        float fU2 = ((f * com.bytedance.adsdk.lottie.pn.a.u()) * fFloatValue) / 100.0f;
        List<String> listU3 = u(strFx);
        size = listU3.size();
        i = 0;
        int i22 = -1;
        while (i < size) {
        }
    }

    private void u(Canvas canvas, com.bytedance.adsdk.lottie.model.nr nrVar, int i, float f) {
        PointF pointF = nrVar.l;
        PointF pointF2 = nrVar.mv;
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        float f2 = (i * nrVar.iz * fU) + (pointF == null ? 0.0f : (nrVar.iz * 0.6f * fU) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.u[nrVar.b.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    private Typeface u(com.bytedance.adsdk.lottie.model.fx fxVar) {
        Typeface typefaceX;
        com.bytedance.adsdk.lottie.u.nr.u<Typeface, Typeface> uVar = this.gi;
        if (uVar != null && (typefaceX = uVar.x()) != null) {
            return typefaceX;
        }
        Typeface typefaceU = this.my.u(fxVar);
        return typefaceU != null ? typefaceU : fxVar.b();
    }

    private List<String> u(String str) {
        return Arrays.asList(str.replaceAll(HttpClient.NEWLINE, "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void u(String str, com.bytedance.adsdk.lottie.model.nr nrVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strU = u(str, length);
            length += strU.length();
            u(strU, nrVar, canvas);
            canvas.translate(this.jk.measureText(strU) + f, 0.0f);
        }
    }

    private List<u> u(String str, float f, com.bytedance.adsdk.lottie.model.fx fxVar, float f2, float f3, boolean z) {
        float fMeasureText;
        float f4 = 0.0f;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        float f5 = 0.0f;
        int i3 = 0;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.lottie.model.b bVar = this.o.k().get(com.bytedance.adsdk.lottie.model.b.u(cCharAt, fxVar.u(), fxVar.fx()));
                if (bVar != null) {
                    fMeasureText = ((float) bVar.nr()) * f2 * com.bytedance.adsdk.lottie.pn.a.u();
                }
            } else {
                fMeasureText = this.jk.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                i3 = i4;
                f5 = f7;
                z2 = false;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                u uVarNr = nr(i);
                if (i3 == i2) {
                    uVarNr.u(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    uVarNr.u(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            nr(i).u(str.substring(i2), f4);
        }
        return this.s.subList(0, i);
    }

    private void u(com.bytedance.adsdk.lottie.model.b bVar, float f, com.bytedance.adsdk.lottie.model.nr nrVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.u.u.b> listU = u(bVar);
        for (int i = 0; i < listU.size(); i++) {
            Path pathB = listU.get(i).b();
            pathB.computeBounds(this.n, false);
            this.f4987a.reset();
            this.f4987a.preTranslate(0.0f, (-nrVar.x) * com.bytedance.adsdk.lottie.pn.a.u());
            this.f4987a.preScale(f, f);
            pathB.transform(this.f4987a);
            if (nrVar.t) {
                u(pathB, this.jk, canvas);
                u(pathB, this.t, canvas);
            } else {
                u(pathB, this.t, canvas);
                u(pathB, this.jk, canvas);
            }
        }
    }

    private void u(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void u(String str, com.bytedance.adsdk.lottie.model.nr nrVar, Canvas canvas) {
        if (nrVar.t) {
            u(str, this.jk, canvas);
            u(str, this.t, canvas);
        } else {
            u(str, this.t, canvas);
            u(str, this.jk, canvas);
        }
    }

    private void u(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.u.u.b> u(com.bytedance.adsdk.lottie.model.b bVar) {
        if (this.l.containsKey(bVar)) {
            return this.l.get(bVar);
        }
        List<my> listU = bVar.u();
        int size = listU.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.lottie.u.u.b(this.my, this, listU.get(i), this.o));
        }
        this.l.put(bVar, arrayList);
        return arrayList;
    }

    private String u(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!fx(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.mv.indexOfKey(j) >= 0) {
            return this.mv.get(j);
        }
        this.x.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.x.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.x.toString();
        this.mv.put(j, string);
        return string;
    }
}
