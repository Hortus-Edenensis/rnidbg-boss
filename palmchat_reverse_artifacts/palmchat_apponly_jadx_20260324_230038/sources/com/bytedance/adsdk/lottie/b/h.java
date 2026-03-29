package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.jk;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class h {
    public static com.bytedance.adsdk.lottie.model.nr.jk u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, int i) throws IOException {
        boolean z = i == 3;
        String strNextString = null;
        jk.u uVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVarNr = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU3 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU4 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU5 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU6 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    mvVarNr = u.nr(jsonReader, izVar);
                    break;
                case "r":
                    nrVarU2 = b.u(jsonReader, izVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    nrVarU3 = b.u(jsonReader, izVar);
                    break;
                case "is":
                    nrVarU5 = b.u(jsonReader, izVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    nrVarU4 = b.u(jsonReader, izVar);
                    break;
                case "os":
                    nrVarU6 = b.u(jsonReader, izVar, false);
                    break;
                case "pt":
                    nrVarU = b.u(jsonReader, izVar, false);
                    break;
                case "sy":
                    uVarU = jk.u.u(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.nr.jk(strNextString, uVarU, nrVarU, mvVarNr, nrVarU2, nrVarU3, nrVarU4, nrVarU5, nrVarU6, zNextBoolean, z);
    }
}
