package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yy4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f22301a = JsonReader.a.a("nm", t.k, LiveConfigKey.HIGH);

    @Nullable
    public static wy4 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        boolean zH = false;
        String strM = null;
        dd ddVarF = null;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f22301a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                ddVarF = sd.f(jsonReader, u73Var, true);
            } else if (iR != 2) {
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        if (zH) {
            return null;
        }
        return new wy4(strM, ddVarF);
    }
}
