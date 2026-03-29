package defpackage;

import com.airbnb.lottie.model.DocumentData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bv5 extends i03<DocumentData> {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends i93<DocumentData> {
        public final /* synthetic */ w83 d;
        public final /* synthetic */ i93 e;
        public final /* synthetic */ DocumentData f;

        public a(w83 w83Var, i93 i93Var, DocumentData documentData) {
            this.d = w83Var;
            this.e = i93Var;
            this.f = documentData;
        }

        @Override // defpackage.i93
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DocumentData a(w83<DocumentData> w83Var) {
            this.d.h(w83Var.f(), w83Var.a(), w83Var.g().f2517a, w83Var.b().f2517a, w83Var.d(), w83Var.c(), w83Var.e());
            String str = (String) this.e.a(this.d);
            DocumentData documentDataB = w83Var.c() == 1.0f ? w83Var.b() : w83Var.g();
            this.f.a(str, documentDataB.b, documentDataB.c, documentDataB.d, documentDataB.e, documentDataB.f, documentDataB.g, documentDataB.h, documentDataB.i, documentDataB.j, documentDataB.k);
            return this.f;
        }
    }

    public bv5(List<h03<DocumentData>> list) {
        super(list);
    }

    @Override // defpackage.sq
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public DocumentData i(h03<DocumentData> h03Var, float f) {
        DocumentData documentData;
        i93<A> i93Var = this.e;
        if (i93Var == 0) {
            return (f != 1.0f || (documentData = h03Var.c) == null) ? h03Var.b : documentData;
        }
        float f2 = h03Var.g;
        Float f3 = h03Var.h;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        DocumentData documentData2 = h03Var.b;
        DocumentData documentData3 = documentData2;
        DocumentData documentData4 = h03Var.c;
        return (DocumentData) i93Var.b(f2, fFloatValue, documentData3, documentData4 == null ? documentData2 : documentData4, f, d(), f());
    }

    public void q(i93<String> i93Var) {
        super.n(new a(new w83(), i93Var, new DocumentData()));
    }
}
