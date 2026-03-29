package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f18387a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", t.k, LiveConfigKey.HIGH);
    public static final JsonReader.a b = JsonReader.a.a("p", t.f7496a);

    public static hd2 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        fd fdVarH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strM = null;
        GradientType gradientType = null;
        ed edVarG = null;
        id idVarI = null;
        id idVarI2 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            switch (jsonReader.r(f18387a)) {
                case 0:
                    strM = jsonReader.m();
                    break;
                case 1:
                    jsonReader.d();
                    int iJ = -1;
                    while (jsonReader.g()) {
                        int iR = jsonReader.r(b);
                        if (iR == 0) {
                            iJ = jsonReader.j();
                        } else if (iR != 1) {
                            jsonReader.s();
                            jsonReader.x();
                        } else {
                            edVarG = sd.g(jsonReader, u73Var, iJ);
                        }
                    }
                    jsonReader.f();
                    break;
                case 2:
                    fdVarH = sd.h(jsonReader, u73Var);
                    break;
                case 3:
                    gradientType = jsonReader.j() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    idVarI = sd.i(jsonReader, u73Var);
                    break;
                case 5:
                    idVarI2 = sd.i(jsonReader, u73Var);
                    break;
                case 6:
                    fillType = jsonReader.j() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zH = jsonReader.h();
                    break;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    break;
            }
        }
        return new hd2(strM, gradientType, fillType, edVarG, fdVarH == null ? new fd(Collections.singletonList(new h03(100))) : fdVarH, idVarI, idVarI2, null, null, zH);
    }
}
