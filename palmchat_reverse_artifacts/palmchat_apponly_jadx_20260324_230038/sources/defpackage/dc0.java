package defpackage;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f17017a = JsonReader.a.a("nm", "p", "s", LiveConfigKey.HIGH, "d");

    public static cc0 a(JsonReader jsonReader, u73 u73Var, int i) throws IOException {
        boolean z = i == 3;
        String strM = null;
        rd<PointF, PointF> rdVarB = null;
        id idVarI = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f17017a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                rdVarB = hd.b(jsonReader, u73Var);
            } else if (iR == 2) {
                idVarI = sd.i(jsonReader, u73Var);
            } else if (iR == 3) {
                zH = jsonReader.h();
            } else if (iR != 4) {
                jsonReader.s();
                jsonReader.x();
            } else {
                z = jsonReader.j() == 3;
            }
        }
        return new cc0(strM, rdVarB, idVarI, z, zH);
    }
}
