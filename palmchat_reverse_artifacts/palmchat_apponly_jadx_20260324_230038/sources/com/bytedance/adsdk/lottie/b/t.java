package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t {
    private com.bytedance.adsdk.lottie.model.u.nr b;
    private com.bytedance.adsdk.lottie.model.u.nr fx;
    private com.bytedance.adsdk.lottie.model.u.nr nr;
    private com.bytedance.adsdk.lottie.model.u.nr pn;
    private com.bytedance.adsdk.lottie.model.u.u u;

    private void nr(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.b = b.u(jsonReader, izVar);
                        break;
                    case "Opacity":
                        this.nr = b.u(jsonReader, izVar, false);
                        break;
                    case "Direction":
                        this.fx = b.u(jsonReader, izVar, false);
                        break;
                    case "Shadow Color":
                        this.u = b.x(jsonReader, izVar);
                        break;
                    case "Softness":
                        this.pn = b.u(jsonReader, izVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    public jk u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        com.bytedance.adsdk.lottie.model.u.nr nrVar;
        com.bytedance.adsdk.lottie.model.u.nr nrVar2;
        com.bytedance.adsdk.lottie.model.u.nr nrVar3;
        com.bytedance.adsdk.lottie.model.u.nr nrVar4;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    nr(jsonReader, izVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.bytedance.adsdk.lottie.model.u.u uVar = this.u;
        if (uVar == null || (nrVar = this.nr) == null || (nrVar2 = this.fx) == null || (nrVar3 = this.b) == null || (nrVar4 = this.pn) == null) {
            return null;
        }
        return new jk(uVar, nrVar, nrVar2, nrVar3, nrVar4);
    }
}
