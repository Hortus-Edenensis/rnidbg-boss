package defpackage;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final et f1621a;
    public final p52 b;

    public b1(et etVar) {
        this.f1621a = etVar;
        this.b = new p52(etVar);
    }

    public static b1 a(et etVar) {
        if (etVar.g(1)) {
            return new s(etVar);
        }
        if (!etVar.g(2)) {
            return new pe(etVar);
        }
        int iG = p52.g(etVar, 1, 4);
        if (iG == 4) {
            return new m(etVar);
        }
        if (iG == 5) {
            return new n(etVar);
        }
        int iG2 = p52.g(etVar, 1, 5);
        if (iG2 == 12) {
            return new o(etVar);
        }
        if (iG2 == 13) {
            return new p(etVar);
        }
        switch (p52.g(etVar, 1, 7)) {
            case 56:
                return new q(etVar, "310", "11");
            case 57:
                return new q(etVar, "320", "11");
            case 58:
                return new q(etVar, "310", BaseWrapper.ENTER_ID_GAME_CENTER);
            case 59:
                return new q(etVar, "320", BaseWrapper.ENTER_ID_GAME_CENTER);
            case 60:
                return new q(etVar, "310", "15");
            case 61:
                return new q(etVar, "320", "15");
            case 62:
                return new q(etVar, "310", BaseWrapper.ENTER_ID_17);
            case 63:
                return new q(etVar, "320", BaseWrapper.ENTER_ID_17);
            default:
                throw new IllegalStateException("unknown decoder: " + etVar);
        }
    }

    public final p52 b() {
        return this.b;
    }

    public final et c() {
        return this.f1621a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
