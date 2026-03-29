package defpackage;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.dn;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class op0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f19801a = JsonReader.a.a(MapBundleKey.MapObjKey.OBJ_TYPE, "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static np0 a(JsonReader jsonReader, u73 u73Var) throws IOException {
        np0 np0VarA;
        String strM;
        jsonReader.d();
        byte b = 2;
        int iJ = 2;
        while (true) {
            np0VarA = null;
            if (!jsonReader.g()) {
                strM = null;
                break;
            }
            int iR = jsonReader.r(f19801a);
            if (iR == 0) {
                strM = jsonReader.m();
                break;
            }
            if (iR != 1) {
                jsonReader.s();
                jsonReader.x();
            } else {
                iJ = jsonReader.j();
            }
        }
        if (strM == null) {
            return null;
        }
        switch (strM.hashCode()) {
            case 3239:
                b = !strM.equals(t.n) ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                if (strM.equals("fl")) {
                    b = 1;
                    break;
                }
                break;
            case 3295:
                if (!strM.equals("gf")) {
                }
                break;
            case 3307:
                if (strM.equals("gr")) {
                    b = 3;
                    break;
                }
                break;
            case 3308:
                if (strM.equals("gs")) {
                    b = 4;
                    break;
                }
                break;
            case 3488:
                if (strM.equals("mm")) {
                    b = 5;
                    break;
                }
                break;
            case 3633:
                if (strM.equals("rc")) {
                    b = 6;
                    break;
                }
                break;
            case 3634:
                if (strM.equals("rd")) {
                    b = 7;
                    break;
                }
                break;
            case 3646:
                if (strM.equals("rp")) {
                    b = 8;
                    break;
                }
                break;
            case 3669:
                if (strM.equals("sh")) {
                    b = 9;
                    break;
                }
                break;
            case 3679:
                if (strM.equals("sr")) {
                    b = 10;
                    break;
                }
                break;
            case 3681:
                if (strM.equals("st")) {
                    b = 11;
                    break;
                }
                break;
            case 3705:
                if (strM.equals("tm")) {
                    b = 12;
                    break;
                }
                break;
            case 3710:
                if (strM.equals("tr")) {
                    b = dn.k;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                np0VarA = dc0.a(jsonReader, u73Var, iJ);
                break;
            case 1:
                np0VarA = c75.a(jsonReader, u73Var);
                break;
            case 2:
                np0VarA = jd2.a(jsonReader, u73Var);
                break;
            case 3:
                np0VarA = f75.a(jsonReader, u73Var);
                break;
            case 4:
                np0VarA = ld2.a(jsonReader, u73Var);
                break;
            case 5:
                np0VarA = tn3.a(jsonReader);
                u73Var.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                np0VarA = eu4.a(jsonReader, u73Var);
                break;
            case 7:
                np0VarA = yy4.a(jsonReader, u73Var);
                break;
            case 8:
                np0VarA = aw4.a(jsonReader, u73Var);
                break;
            case 9:
                np0VarA = k75.a(jsonReader, u73Var);
                break;
            case 10:
                np0VarA = kk4.a(jsonReader, u73Var, iJ);
                break;
            case 11:
                np0VarA = l75.a(jsonReader, u73Var);
                break;
            case 12:
                np0VarA = m75.a(jsonReader, u73Var);
                break;
            case 13:
                np0VarA = qd.g(jsonReader, u73Var);
                break;
            default:
                m63.c("Unknown shape type " + strM);
                break;
        }
        while (jsonReader.g()) {
            jsonReader.x();
        }
        jsonReader.f();
        return np0VarA;
    }
}
