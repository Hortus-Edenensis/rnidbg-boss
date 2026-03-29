package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class ja {
    public static com.bytedance.adsdk.lottie.model.nr.l u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        com.bytedance.adsdk.lottie.model.u.l lVarU = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    nrVarU = b.u(jsonReader, izVar, false);
                    break;
                case "o":
                    nrVarU2 = b.u(jsonReader, izVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    lVarU = fx.u(jsonReader, izVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.nr.l(strNextString, nrVarU, nrVarU2, lVarU, zNextBoolean);
    }
}
