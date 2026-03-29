package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.mapapi.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cv5 extends com.airbnb.lottie.model.layer.a {
    public final StringBuilder D;
    public final RectF E;
    public final Matrix F;
    public final Paint G;
    public final Paint H;
    public final Map<t02, List<mo0>> I;
    public final LongSparseArray<String> J;
    public final bv5 K;
    public final u83 L;
    public final u73 M;

    @Nullable
    public sq<Integer, Integer> N;

    @Nullable
    public sq<Integer, Integer> O;

    @Nullable
    public sq<Integer, Integer> P;

    @Nullable
    public sq<Integer, Integer> Q;

    @Nullable
    public sq<Float, Float> R;

    @Nullable
    public sq<Float, Float> S;

    @Nullable
    public sq<Float, Float> T;

    @Nullable
    public sq<Float, Float> U;

    @Nullable
    public sq<Float, Float> V;

    @Nullable
    public sq<Typeface, Typeface> W;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Paint {
        public a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Paint {
        public b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16927a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f16927a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16927a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16927a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public cv5(u83 u83Var, Layer layer) {
        dd ddVar;
        dd ddVar2;
        cd cdVar;
        cd cdVar2;
        super(u83Var, layer);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.L = u83Var;
        this.M = layer.b();
        bv5 bv5VarA = layer.s().a();
        this.K = bv5VarA;
        bv5VarA.a(this);
        i(bv5VarA);
        nd ndVarT = layer.t();
        if (ndVarT != null && (cdVar2 = ndVarT.f19494a) != null) {
            sq<Integer, Integer> sqVarA = cdVar2.a();
            this.N = sqVarA;
            sqVarA.a(this);
            i(this.N);
        }
        if (ndVarT != null && (cdVar = ndVarT.b) != null) {
            sq<Integer, Integer> sqVarA2 = cdVar.a();
            this.P = sqVarA2;
            sqVarA2.a(this);
            i(this.P);
        }
        if (ndVarT != null && (ddVar2 = ndVarT.c) != null) {
            sq<Float, Float> sqVarA3 = ddVar2.a();
            this.R = sqVarA3;
            sqVarA3.a(this);
            i(this.R);
        }
        if (ndVarT == null || (ddVar = ndVarT.d) == null) {
            return;
        }
        sq<Float, Float> sqVarA4 = ddVar.a();
        this.T = sqVarA4;
        sqVarA4.a(this);
        i(this.T);
    }

    public final void O(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = c.f16927a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            if (i != 3) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final String P(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!c0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.J.containsKey(j)) {
            return this.J.get(j);
        }
        this.D.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.D.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.D.toString();
        this.J.put(j, string);
        return string;
    }

    public final void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void R(t02 t02Var, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<mo0> listY = Y(t02Var);
        for (int i = 0; i < listY.size(); i++) {
            Path path = listY.get(i).getPath();
            path.computeBounds(this.E, false);
            this.F.set(matrix);
            this.F.preTranslate(0.0f, (-documentData.g) * r86.e());
            this.F.preScale(f, f);
            path.transform(this.F);
            if (documentData.k) {
                U(path, this.G, canvas);
                U(path, this.H, canvas);
            } else {
                U(path, this.H, canvas);
                U(path, this.G, canvas);
            }
        }
    }

    public final void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.k) {
            Q(str, this.G, canvas);
            Q(str, this.H, canvas);
        } else {
            Q(str, this.H, canvas);
            Q(str, this.G, canvas);
        }
    }

    public final void T(String str, DocumentData documentData, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strP = P(str, length);
            length += strP.length();
            S(strP, documentData, canvas);
            canvas.translate(this.G.measureText(strP) + f, 0.0f);
        }
    }

    public final void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void V(String str, DocumentData documentData, Matrix matrix, q02 q02Var, Canvas canvas, float f, float f2) {
        float fFloatValue;
        for (int i = 0; i < str.length(); i++) {
            t02 t02Var = this.M.c().get(t02.c(str.charAt(i), q02Var.a(), q02Var.c()));
            if (t02Var != null) {
                R(t02Var, matrix, f2, documentData, canvas);
                float fB = ((float) t02Var.b()) * f2 * r86.e() * f;
                float f3 = documentData.e / 10.0f;
                sq<Float, Float> sqVar = this.U;
                if (sqVar != null) {
                    fFloatValue = sqVar.h().floatValue();
                } else {
                    sq<Float, Float> sqVar2 = this.T;
                    if (sqVar2 != null) {
                        fFloatValue = sqVar2.h().floatValue();
                    }
                    canvas.translate(fB + (f3 * f), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fB + (f3 * f), 0.0f);
            }
        }
    }

    public final void W(DocumentData documentData, Matrix matrix, q02 q02Var, Canvas canvas) {
        sq<Float, Float> sqVar = this.V;
        float fFloatValue = (sqVar != null ? sqVar.h().floatValue() : documentData.c) / 100.0f;
        float fG = r86.g(matrix);
        String str = documentData.f2517a;
        float fE = documentData.f * r86.e();
        List<String> listA0 = a0(str);
        int size = listA0.size();
        for (int i = 0; i < size; i++) {
            String str2 = listA0.get(i);
            float fZ = Z(str2, q02Var, fFloatValue, fG);
            canvas.save();
            O(documentData.d, canvas, fZ);
            canvas.translate(0.0f, (i * fE) - (((size - 1) * fE) / 2.0f));
            V(str2, documentData, matrix, q02Var, canvas, fG, fFloatValue);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0088 A[LOOP:0: B:17:0x0086->B:18:0x0088, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(DocumentData documentData, q02 q02Var, Canvas canvas) {
        float fFloatValue;
        int size;
        int i;
        Typeface typefaceB0 = b0(q02Var);
        if (typefaceB0 == null) {
            return;
        }
        String str = documentData.f2517a;
        this.L.b0();
        this.G.setTypeface(typefaceB0);
        sq<Float, Float> sqVar = this.V;
        float fFloatValue2 = sqVar != null ? sqVar.h().floatValue() : documentData.c;
        this.G.setTextSize(r86.e() * fFloatValue2);
        this.H.setTypeface(this.G.getTypeface());
        this.H.setTextSize(this.G.getTextSize());
        float fE = documentData.f * r86.e();
        float f = documentData.e / 10.0f;
        sq<Float, Float> sqVar2 = this.U;
        if (sqVar2 == null) {
            sq<Float, Float> sqVar3 = this.T;
            if (sqVar3 != null) {
                fFloatValue = sqVar3.h().floatValue();
            }
            float fE2 = ((f * r86.e()) * fFloatValue2) / 100.0f;
            List<String> listA0 = a0(str);
            size = listA0.size();
            for (i = 0; i < size; i++) {
                String str2 = listA0.get(i);
                float fMeasureText = this.H.measureText(str2) + ((str2.length() - 1) * fE2);
                canvas.save();
                O(documentData.d, canvas, fMeasureText);
                canvas.translate(0.0f, (i * fE) - (((size - 1) * fE) / 2.0f));
                T(str2, documentData, canvas, fE2);
                canvas.restore();
            }
        }
        fFloatValue = sqVar2.h().floatValue();
        f += fFloatValue;
        float fE22 = ((f * r86.e()) * fFloatValue2) / 100.0f;
        List<String> listA02 = a0(str);
        size = listA02.size();
        while (i < size) {
        }
    }

    public final List<mo0> Y(t02 t02Var) {
        if (this.I.containsKey(t02Var)) {
            return this.I.get(t02Var);
        }
        List<e75> listA = t02Var.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new mo0(this.L, this, listA.get(i)));
        }
        this.I.put(t02Var, arrayList);
        return arrayList;
    }

    public final float Z(String str, q02 q02Var, float f, float f2) {
        float fB = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            t02 t02Var = this.M.c().get(t02.c(str.charAt(i), q02Var.a(), q02Var.c()));
            if (t02Var != null) {
                fB = (float) (((double) fB) + (t02Var.b() * ((double) f) * ((double) r86.e()) * ((double) f2)));
            }
        }
        return fB;
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.M.b().width(), this.M.b().height());
    }

    public final List<String> a0(String str) {
        return Arrays.asList(str.replaceAll(HttpClient.NEWLINE, "\r").replaceAll("\n", "\r").split("\r"));
    }

    @Nullable
    public final Typeface b0(q02 q02Var) {
        Typeface typefaceH;
        sq<Typeface, Typeface> sqVar = this.W;
        if (sqVar != null && (typefaceH = sqVar.h()) != null) {
            return typefaceH;
        }
        Typeface typefaceC0 = this.L.c0(q02Var.a(), q02Var.c());
        return typefaceC0 != null ? typefaceC0 : q02Var.d();
    }

    public final boolean c0(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.f16999a) {
            sq<Integer, Integer> sqVar = this.O;
            if (sqVar != null) {
                G(sqVar);
            }
            if (i93Var == null) {
                this.O = null;
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.O = f96Var;
            f96Var.a(this);
            i(this.O);
            return;
        }
        if (t == d93.b) {
            sq<Integer, Integer> sqVar2 = this.Q;
            if (sqVar2 != null) {
                G(sqVar2);
            }
            if (i93Var == null) {
                this.Q = null;
                return;
            }
            f96 f96Var2 = new f96(i93Var);
            this.Q = f96Var2;
            f96Var2.a(this);
            i(this.Q);
            return;
        }
        if (t == d93.s) {
            sq<Float, Float> sqVar3 = this.S;
            if (sqVar3 != null) {
                G(sqVar3);
            }
            if (i93Var == null) {
                this.S = null;
                return;
            }
            f96 f96Var3 = new f96(i93Var);
            this.S = f96Var3;
            f96Var3.a(this);
            i(this.S);
            return;
        }
        if (t == d93.t) {
            sq<Float, Float> sqVar4 = this.U;
            if (sqVar4 != null) {
                G(sqVar4);
            }
            if (i93Var == null) {
                this.U = null;
                return;
            }
            f96 f96Var4 = new f96(i93Var);
            this.U = f96Var4;
            f96Var4.a(this);
            i(this.U);
            return;
        }
        if (t == d93.F) {
            sq<Float, Float> sqVar5 = this.V;
            if (sqVar5 != null) {
                G(sqVar5);
            }
            if (i93Var == null) {
                this.V = null;
                return;
            }
            f96 f96Var5 = new f96(i93Var);
            this.V = f96Var5;
            f96Var5.a(this);
            i(this.V);
            return;
        }
        if (t != d93.M) {
            if (t == d93.O) {
                this.K.q(i93Var);
                return;
            }
            return;
        }
        sq<Typeface, Typeface> sqVar6 = this.W;
        if (sqVar6 != null) {
            G(sqVar6);
        }
        if (i93Var == null) {
            this.W = null;
            return;
        }
        f96 f96Var6 = new f96(i93Var);
        this.W = f96Var6;
        f96Var6.a(this);
        i(this.W);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.L.p1()) {
            canvas.concat(matrix);
        }
        DocumentData documentDataH = this.K.h();
        q02 q02Var = this.M.g().get(documentDataH.b);
        if (q02Var == null) {
            canvas.restore();
            return;
        }
        sq<Integer, Integer> sqVar = this.O;
        if (sqVar != null) {
            this.G.setColor(sqVar.h().intValue());
        } else {
            sq<Integer, Integer> sqVar2 = this.N;
            if (sqVar2 != null) {
                this.G.setColor(sqVar2.h().intValue());
            } else {
                this.G.setColor(documentDataH.h);
            }
        }
        sq<Integer, Integer> sqVar3 = this.Q;
        if (sqVar3 != null) {
            this.H.setColor(sqVar3.h().intValue());
        } else {
            sq<Integer, Integer> sqVar4 = this.P;
            if (sqVar4 != null) {
                this.H.setColor(sqVar4.h().intValue());
            } else {
                this.H.setColor(documentDataH.i);
            }
        }
        int iIntValue = ((this.x.h() == null ? 100 : this.x.h().h().intValue()) * 255) / 100;
        this.G.setAlpha(iIntValue);
        this.H.setAlpha(iIntValue);
        sq<Float, Float> sqVar5 = this.S;
        if (sqVar5 != null) {
            this.H.setStrokeWidth(sqVar5.h().floatValue());
        } else {
            sq<Float, Float> sqVar6 = this.R;
            if (sqVar6 != null) {
                this.H.setStrokeWidth(sqVar6.h().floatValue());
            } else {
                this.H.setStrokeWidth(documentDataH.j * r86.e() * r86.g(matrix));
            }
        }
        if (this.L.p1()) {
            W(documentDataH, matrix, q02Var, canvas);
        } else {
            X(documentDataH, q02Var, canvas);
        }
        canvas.restore();
    }
}
