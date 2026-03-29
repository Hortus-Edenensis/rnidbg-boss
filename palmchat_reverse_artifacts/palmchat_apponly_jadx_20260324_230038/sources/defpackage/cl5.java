package defpackage;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class cl5 implements fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2010a;

    public cl5(String str) {
        this.f2010a = str;
    }

    public static cl5 a(gc4 gc4Var) {
        return new cl5(gc4Var.E(gc4Var.a()));
    }

    @Override // defpackage.fn
    public int getType() {
        return AviExtractor.FOURCC_strn;
    }
}
