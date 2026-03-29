package defpackage;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f19154a = JsonReader.a.a("s", "e", "o", "nm", "m", LiveConfigKey.HIGH);

    public static ShapeTrimPath a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String strM = null;
        ShapeTrimPath.Type typeForId = null;
        dd ddVarF = null;
        dd ddVarF2 = null;
        dd ddVarF3 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f19154a);
            if (iR == 0) {
                ddVarF = sd.f(jsonReader, u73Var, false);
            } else if (iR == 1) {
                ddVarF2 = sd.f(jsonReader, u73Var, false);
            } else if (iR == 2) {
                ddVarF3 = sd.f(jsonReader, u73Var, false);
            } else if (iR == 3) {
                strM = jsonReader.m();
            } else if (iR == 4) {
                typeForId = ShapeTrimPath.Type.forId(jsonReader.j());
            } else if (iR != 5) {
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        return new ShapeTrimPath(strM, typeForId, ddVarF, ddVarF2, ddVarF3, zH);
    }
}
