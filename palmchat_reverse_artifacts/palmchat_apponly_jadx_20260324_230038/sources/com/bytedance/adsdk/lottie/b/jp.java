package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class jp {
    public static com.bytedance.adsdk.lottie.model.nr.o u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.n nVarPn = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    nVarPn = b.pn(jsonReader, izVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.nr.o(strNextString, iNextInt, nVarPn, zNextBoolean);
    }
}
