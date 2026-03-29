package com.bytedance.adsdk.lottie.b;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class my {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.lottie.model.nr.pn u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        int iNextInt;
        com.bytedance.adsdk.lottie.model.u.b bVarNr = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.nr.x xVar = null;
        com.bytedance.adsdk.lottie.model.u.fx fxVarU = null;
        com.bytedance.adsdk.lottie.model.u.iz izVarFx = null;
        com.bytedance.adsdk.lottie.model.u.iz izVarFx2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            iNextInt = -1;
            switch (strNextName) {
                case "e":
                    izVarFx2 = b.fx(jsonReader, izVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(com.kuaishou.weapon.p0.t.f7496a)) {
                            fxVarU = b.u(jsonReader, izVar, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    bVarNr = b.nr(jsonReader, izVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    izVarFx = b.fx(jsonReader, izVar);
                    break;
                case "t":
                    xVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.nr.x.LINEAR : com.bytedance.adsdk.lottie.model.nr.x.RADIAL;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.nr.pn(strNextString, xVar, fillType, fxVarU, bVarNr == null ? new com.bytedance.adsdk.lottie.model.u.b(Collections.singletonList(new com.bytedance.adsdk.lottie.iz.u(100))) : bVarNr, izVarFx, izVarFx2, null, null, zNextBoolean);
    }
}
