package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f1912a = JsonReader.a.a("nm", "c", "o", "fillEnabled", t.k, LiveConfigKey.HIGH);

    public static b75 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        fd fdVar = null;
        String strM = null;
        cd cdVarC = null;
        int iJ = 1;
        boolean zH = false;
        boolean zH2 = false;
        while (jsonReader.g()) {
            int iR = jsonReader.r(f1912a);
            if (iR == 0) {
                strM = jsonReader.m();
            } else if (iR == 1) {
                cdVarC = sd.c(jsonReader, u73Var);
            } else if (iR == 2) {
                fdVar = sd.h(jsonReader, u73Var);
            } else if (iR == 3) {
                zH = jsonReader.h();
            } else if (iR == 4) {
                iJ = jsonReader.j();
            } else if (iR != 5) {
                jsonReader.s();
                jsonReader.x();
            } else {
                zH2 = jsonReader.h();
            }
        }
        if (fdVar == null) {
            fdVar = new fd(Collections.singletonList(new h03(100)));
        }
        return new b75(strM, zH, iJ == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, cdVarC, fdVar, zH2);
    }
}
