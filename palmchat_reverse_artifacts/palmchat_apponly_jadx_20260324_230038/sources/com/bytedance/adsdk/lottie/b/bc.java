package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.bg;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class bc {
    public static com.bytedance.adsdk.lottie.model.nr.bg u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        String strNextString = null;
        bg.u uVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    nrVarU2 = b.u(jsonReader, izVar, false);
                    break;
                case "m":
                    uVarU = bg.u.u(jsonReader.nextInt());
                    break;
                case "o":
                    nrVarU3 = b.u(jsonReader, izVar, false);
                    break;
                case "s":
                    nrVarU = b.u(jsonReader, izVar, false);
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
        return new com.bytedance.adsdk.lottie.model.nr.bg(strNextString, uVarU, nrVarU, nrVarU2, nrVarU3, zNextBoolean);
    }
}
