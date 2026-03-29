package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class kk4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f18711a = JsonReader.a.a("nm", "sy", OapsKey.KEY_PAGE_TYPE, "p", t.k, "or", "os", "ir", "is", LiveConfigKey.HIGH, "d");

    public static PolystarShape a(JsonReader jsonReader, u73 u73Var, int i) throws IOException {
        boolean z = i == 3;
        String strM = null;
        PolystarShape.Type typeForValue = null;
        dd ddVarF = null;
        rd<PointF, PointF> rdVarB = null;
        dd ddVarF2 = null;
        dd ddVarE = null;
        dd ddVarE2 = null;
        dd ddVarF3 = null;
        dd ddVarF4 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            switch (jsonReader.r(f18711a)) {
                case 0:
                    strM = jsonReader.m();
                    break;
                case 1:
                    typeForValue = PolystarShape.Type.forValue(jsonReader.j());
                    break;
                case 2:
                    ddVarF = sd.f(jsonReader, u73Var, false);
                    break;
                case 3:
                    rdVarB = hd.b(jsonReader, u73Var);
                    break;
                case 4:
                    ddVarF2 = sd.f(jsonReader, u73Var, false);
                    break;
                case 5:
                    ddVarE2 = sd.e(jsonReader, u73Var);
                    break;
                case 6:
                    ddVarF4 = sd.f(jsonReader, u73Var, false);
                    break;
                case 7:
                    ddVarE = sd.e(jsonReader, u73Var);
                    break;
                case 8:
                    ddVarF3 = sd.f(jsonReader, u73Var, false);
                    break;
                case 9:
                    zH = jsonReader.h();
                    break;
                case 10:
                    z = jsonReader.j() == 3;
                    break;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    break;
            }
        }
        return new PolystarShape(strM, typeForValue, ddVarF, rdVarB, ddVarF2, ddVarE, ddVarE2, ddVarF3, ddVarF4, zH, z);
    }
}
