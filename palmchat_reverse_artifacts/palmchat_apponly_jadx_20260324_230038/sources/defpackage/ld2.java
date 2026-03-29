package defpackage;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ld2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f18959a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", RXScreenCaptureService.KEY_WIDTH, "lc", "lj", "ml", LiveConfigKey.HIGH, "d");
    public static final JsonReader.a b = JsonReader.a.a("p", t.f7496a);
    public static final JsonReader.a c = JsonReader.a.a("n", "v");

    public static a a(JsonReader jsonReader, u73 u73Var) throws IOException {
        String str;
        ed edVar;
        ArrayList arrayList = new ArrayList();
        String strM = null;
        GradientType gradientType = null;
        ed edVarG = null;
        id idVarI = null;
        id idVarI2 = null;
        dd ddVarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float fI = 0.0f;
        dd ddVar = null;
        boolean zH = false;
        fd fdVar = null;
        while (jsonReader.g()) {
            switch (jsonReader.r(f18959a)) {
                case 0:
                    strM = jsonReader.m();
                    continue;
                case 1:
                    str = strM;
                    jsonReader.d();
                    int iJ = -1;
                    while (jsonReader.g()) {
                        int iR = jsonReader.r(b);
                        if (iR != 0) {
                            edVar = edVarG;
                            if (iR != 1) {
                                jsonReader.s();
                                jsonReader.x();
                            } else {
                                edVarG = sd.g(jsonReader, u73Var, iJ);
                            }
                        } else {
                            edVar = edVarG;
                            iJ = jsonReader.j();
                        }
                        edVarG = edVar;
                    }
                    jsonReader.f();
                    break;
                case 2:
                    fdVar = sd.h(jsonReader, u73Var);
                    continue;
                case 3:
                    str = strM;
                    gradientType = jsonReader.j() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    idVarI = sd.i(jsonReader, u73Var);
                    continue;
                case 5:
                    idVarI2 = sd.i(jsonReader, u73Var);
                    continue;
                case 6:
                    ddVarE = sd.e(jsonReader, u73Var);
                    continue;
                case 7:
                    str = strM;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.j() - 1];
                    break;
                case 8:
                    str = strM;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.j() - 1];
                    break;
                case 9:
                    str = strM;
                    fI = (float) jsonReader.i();
                    break;
                case 10:
                    zH = jsonReader.h();
                    continue;
                case 11:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        jsonReader.d();
                        String strM2 = null;
                        dd ddVarE2 = null;
                        while (jsonReader.g()) {
                            int iR2 = jsonReader.r(c);
                            if (iR2 != 0) {
                                dd ddVar2 = ddVar;
                                if (iR2 != 1) {
                                    jsonReader.s();
                                    jsonReader.x();
                                } else {
                                    ddVarE2 = sd.e(jsonReader, u73Var);
                                }
                                ddVar = ddVar2;
                            } else {
                                strM2 = jsonReader.m();
                            }
                        }
                        dd ddVar3 = ddVar;
                        jsonReader.f();
                        if (strM2.equals("o")) {
                            ddVar = ddVarE2;
                        } else {
                            if (strM2.equals("d") || strM2.equals("g")) {
                                u73Var.u(true);
                                arrayList.add(ddVarE2);
                            }
                            ddVar = ddVar3;
                        }
                    }
                    dd ddVar4 = ddVar;
                    jsonReader.e();
                    if (arrayList.size() == 1) {
                        arrayList.add((dd) arrayList.get(0));
                    }
                    ddVar = ddVar4;
                    continue;
                default:
                    jsonReader.s();
                    jsonReader.x();
                    continue;
            }
            strM = str;
        }
        String str2 = strM;
        if (fdVar == null) {
            fdVar = new fd(Collections.singletonList(new h03(100)));
        }
        return new a(str2, gradientType, edVarG, fdVar, idVarI, idVarI2, ddVarE, lineCapType, lineJoinType, fI, arrayList, ddVar, zH);
    }
}
