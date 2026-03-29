package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class pn {
    private static com.bytedance.adsdk.lottie.model.nr.u nr(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.nr.u uVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z) {
                        uVar = new com.bytedance.adsdk.lottie.model.nr.u(b.u(jsonReader, izVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!strNextName.equals(MapBundleKey.MapObjKey.OBJ_TYPE)) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z = true;
                }
            }
            jsonReader.endObject();
            return uVar;
        }
    }

    public static com.bytedance.adsdk.lottie.model.nr.u u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        com.bytedance.adsdk.lottie.model.nr.u uVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.nr.u uVarNr = nr(jsonReader, izVar);
                    if (uVarNr != null) {
                        uVar = uVarNr;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return uVar;
    }
}
