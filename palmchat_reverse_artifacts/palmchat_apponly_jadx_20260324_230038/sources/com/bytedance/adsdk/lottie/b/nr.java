package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private static com.bytedance.adsdk.lottie.model.u.t nr(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.u.u uVarX = null;
        com.bytedance.adsdk.lottie.model.u.u uVarX2 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    nrVarU2 = b.u(jsonReader, izVar);
                    break;
                case "fc":
                    uVarX = b.x(jsonReader, izVar);
                    break;
                case "sc":
                    uVarX2 = b.x(jsonReader, izVar);
                    break;
                case "sw":
                    nrVarU = b.u(jsonReader, izVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.u.t(uVarX, uVarX2, nrVarU, nrVarU2);
    }

    public static com.bytedance.adsdk.lottie.model.u.t u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.u.t tVarNr = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                tVarNr = nr(jsonReader, izVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return tVarNr == null ? new com.bytedance.adsdk.lottie.model.u.t(null, null, null, null) : tVarNr;
    }
}
