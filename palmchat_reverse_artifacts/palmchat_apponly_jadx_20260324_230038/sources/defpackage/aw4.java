package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class aw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f1592a = JsonReader.a.a("nm", "c", "o", "tr", LiveConfigKey.HIGH);

    public static yv4 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String strM = null;
        dd ddVarF = null;
        dd ddVarF2 = null;
        pd pdVarG = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f1592a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                ddVarF = sd.f(jsonReader, u73Var, false);
            } else if (iR == 2) {
                ddVarF2 = sd.f(jsonReader, u73Var, false);
            } else if (iR == 3) {
                pdVarG = qd.g(jsonReader, u73Var);
            } else if (iR != 4) {
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        return new yv4(strM, ddVarF, ddVarF2, pdVarG, zH);
    }
}
