package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eu4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17364a = JsonReader.a.a("nm", "p", "s", t.k, LiveConfigKey.HIGH);

    public static du4 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String strM = null;
        rd<PointF, PointF> rdVarB = null;
        id idVarI = null;
        dd ddVarE = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f17364a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                rdVarB = hd.b(jsonReader, u73Var);
            } else if (iR == 2) {
                idVarI = sd.i(jsonReader, u73Var);
            } else if (iR == 3) {
                ddVarE = sd.e(jsonReader, u73Var);
            } else if (iR != 4) {
                jsonReader.x();
            } else {
                zH = jsonReader.h();
            }
        }
        return new du4(strM, rdVarB, idVarI, ddVarE, zH);
    }
}
