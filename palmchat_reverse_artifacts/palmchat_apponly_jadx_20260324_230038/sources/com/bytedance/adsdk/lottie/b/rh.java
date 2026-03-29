package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class rh {
    public static com.bytedance.adsdk.lottie.model.nr.t u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> mvVarNr = null;
        com.bytedance.adsdk.lottie.model.u.iz izVarFx = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    mvVarNr = u.nr(jsonReader, izVar);
                    break;
                case "r":
                    nrVarU = b.u(jsonReader, izVar);
                    break;
                case "s":
                    izVarFx = b.fx(jsonReader, izVar);
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
        return new com.bytedance.adsdk.lottie.model.nr.t(strNextString, mvVarNr, izVarFx, nrVarU, zNextBoolean);
    }
}
