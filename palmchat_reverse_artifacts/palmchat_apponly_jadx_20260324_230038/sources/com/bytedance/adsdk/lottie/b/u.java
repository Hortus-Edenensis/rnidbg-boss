package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    public static com.bytedance.adsdk.lottie.model.u.mv<PointF, PointF> nr(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.u.pn pnVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    pnVarU = u(jsonReader, izVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        nrVarU = b.u(jsonReader, izVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        nrVarU2 = b.u(jsonReader, izVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            izVar.u("Lottie doesn't support expressions.");
        }
        return pnVarU != null ? pnVarU : new com.bytedance.adsdk.lottie.model.u.a(nrVarU, nrVarU2);
    }

    public static com.bytedance.adsdk.lottie.model.u.pn u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(z.u(jsonReader, izVar));
            }
            jsonReader.endArray();
            dw.u(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.iz.u(bg.nr(jsonReader, com.bytedance.adsdk.lottie.pn.a.u())));
        }
        return new com.bytedance.adsdk.lottie.model.u.pn(arrayList);
    }
}
