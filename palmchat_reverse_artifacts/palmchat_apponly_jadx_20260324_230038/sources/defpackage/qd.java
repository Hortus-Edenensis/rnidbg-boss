package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f20229a = JsonReader.a.a("a", "p", "s", "rz", t.k, "o", "so", "eo", "sk", "sa");
    public static final JsonReader.a b = JsonReader.a.a(t.f7496a);

    public static boolean a(gd gdVar) {
        return gdVar == null || (gdVar.isStatic() && gdVar.b().get(0).b.equals(0.0f, 0.0f));
    }

    public static boolean b(rd<PointF, PointF> rdVar) {
        return rdVar == null || (!(rdVar instanceof ld) && rdVar.isStatic() && rdVar.b().get(0).b.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(dd ddVar) {
        return ddVar == null || (ddVar.isStatic() && ((Float) ((h03) ddVar.b().get(0)).b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(jd jdVar) {
        return jdVar == null || (jdVar.isStatic() && ((m25) ((h03) jdVar.b().get(0)).b).a(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(dd ddVar) {
        return ddVar == null || (ddVar.isStatic() && ((Float) ((h03) ddVar.b().get(0)).b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(dd ddVar) {
        return ddVar == null || (ddVar.isStatic() && ((Float) ((h03) ddVar.b().get(0)).b).floatValue() == 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static pd g(JsonReader jsonReader, u73 u73Var) throws IOException {
        dd ddVarF;
        boolean z = false;
        boolean z2 = jsonReader.p() == JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.d();
        }
        dd ddVar = null;
        gd gdVarA = null;
        rd<PointF, PointF> rdVarB = null;
        jd jdVarJ = null;
        dd ddVarF2 = null;
        dd ddVarF3 = null;
        fd fdVarH = null;
        dd ddVarF4 = null;
        dd ddVarF5 = null;
        while (jsonReader.g()) {
            switch (jsonReader.r(f20229a)) {
                case 0:
                    jsonReader.d();
                    while (jsonReader.g()) {
                        if (jsonReader.r(b) != 0) {
                            jsonReader.s();
                            jsonReader.x();
                        } else {
                            gdVarA = hd.a(jsonReader, u73Var);
                        }
                    }
                    jsonReader.f();
                    z = false;
                    break;
                case 1:
                    rdVarB = hd.b(jsonReader, u73Var);
                    z = false;
                    break;
                case 2:
                    jdVarJ = sd.j(jsonReader, u73Var);
                    z = false;
                    break;
                case 3:
                    u73Var.a("Lottie doesn't support 3D layers.");
                    ddVarF = sd.f(jsonReader, u73Var, z);
                    if (ddVarF.b().isEmpty()) {
                        if (((h03) ddVarF.b().get(0)).b == 0) {
                            ddVarF.b().set(0, new h03(u73Var, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(u73Var.f())));
                        }
                        ddVar = ddVarF;
                        z = false;
                    } else {
                        ddVarF.b().add(new h03(u73Var, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(u73Var.f())));
                    }
                    ddVar = ddVarF;
                    z = false;
                    break;
                case 4:
                    ddVarF = sd.f(jsonReader, u73Var, z);
                    if (ddVarF.b().isEmpty()) {
                    }
                    ddVar = ddVarF;
                    z = false;
                    break;
                case 5:
                    fdVarH = sd.h(jsonReader, u73Var);
                    break;
                case 6:
                    ddVarF4 = sd.f(jsonReader, u73Var, z);
                    break;
                case 7:
                    ddVarF5 = sd.f(jsonReader, u73Var, z);
                    break;
                case 8:
                    ddVarF2 = sd.f(jsonReader, u73Var, z);
                    break;
                case 9:
                    ddVarF3 = sd.f(jsonReader, u73Var, z);
                    break;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    z = false;
                    break;
            }
        }
        if (z2) {
            jsonReader.f();
        }
        gd gdVar = a(gdVarA) ? null : gdVarA;
        rd<PointF, PointF> rdVar = b(rdVarB) ? null : rdVarB;
        dd ddVar2 = c(ddVar) ? null : ddVar;
        if (d(jdVarJ)) {
            jdVarJ = null;
        }
        return new pd(gdVar, rdVar, jdVarJ, ddVar2, fdVarH, ddVarF4, ddVarF5, f(ddVarF2) ? null : ddVarF2, e(ddVarF3) ? null : ddVarF3);
    }
}
