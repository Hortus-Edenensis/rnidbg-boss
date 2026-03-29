package defpackage;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class k75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f18591a = JsonReader.a.a("nm", "ind", "ks", LiveConfigKey.HIGH);

    public static j75 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String strM = null;
        kd kdVarK = null;
        int iJ = 0;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f18591a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                iJ = jsonReader.j();
            } else if (iR == 2) {
                kdVarK = sd.k(jsonReader, u73Var);
            } else if (iR != 3) {
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        return new j75(strM, iJ, kdVarK, zH);
    }
}
