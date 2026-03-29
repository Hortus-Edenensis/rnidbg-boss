package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.umeng.analytics.pro.dn;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class n {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.lottie.model.nr.fx u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        com.bytedance.adsdk.lottie.model.nr.fx fxVarU;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            fxVarU = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("d")) {
                if (strNextName.equals(MapBundleKey.MapObjKey.OBJ_TYPE)) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals(com.kuaishou.weapon.p0.t.n) ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                if (strNextString.equals("fl")) {
                    b = 1;
                    break;
                }
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                }
                break;
            case 3307:
                if (strNextString.equals("gr")) {
                    b = 3;
                    break;
                }
                break;
            case 3308:
                if (strNextString.equals("gs")) {
                    b = 4;
                    break;
                }
                break;
            case 3488:
                if (strNextString.equals("mm")) {
                    b = 5;
                    break;
                }
                break;
            case 3633:
                if (strNextString.equals("rc")) {
                    b = 6;
                    break;
                }
                break;
            case 3634:
                if (strNextString.equals("rd")) {
                    b = 7;
                    break;
                }
                break;
            case 3646:
                if (strNextString.equals("rp")) {
                    b = 8;
                    break;
                }
                break;
            case 3669:
                if (strNextString.equals("sh")) {
                    b = 9;
                    break;
                }
                break;
            case 3679:
                if (strNextString.equals("sr")) {
                    b = 10;
                    break;
                }
                break;
            case 3681:
                if (strNextString.equals("st")) {
                    b = 11;
                    break;
                }
                break;
            case 3705:
                if (strNextString.equals("tm")) {
                    b = 12;
                    break;
                }
                break;
            case 3710:
                if (strNextString.equals("tr")) {
                    b = dn.k;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                fxVarU = iz.u(jsonReader, izVar, iNextInt);
                break;
            case 1:
                fxVarU = xg.u(jsonReader, izVar);
                break;
            case 2:
                fxVarU = my.u(jsonReader, izVar);
                break;
            case 3:
                fxVarU = m.u(jsonReader, izVar);
                break;
            case 4:
                fxVarU = o.u(jsonReader, izVar);
                break;
            case 5:
                fxVarU = kj.u(jsonReader);
                izVar.u("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                fxVarU = rh.u(jsonReader, izVar);
                break;
            case 7:
                fxVarU = bf.u(jsonReader, izVar);
                break;
            case 8:
                fxVarU = ja.u(jsonReader, izVar);
                break;
            case 9:
                fxVarU = jp.u(jsonReader, izVar);
                break;
            case 10:
                fxVarU = h.u(jsonReader, izVar, iNextInt);
                break;
            case 11:
                fxVarU = y.u(jsonReader, izVar);
                break;
            case 12:
                fxVarU = bc.u(jsonReader, izVar);
                break;
            case 13:
                fxVarU = fx.u(jsonReader, izVar);
                break;
            default:
                com.bytedance.adsdk.lottie.pn.pn.nr("Unknown shape type ".concat(strNextString));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return fxVarU;
    }
}
