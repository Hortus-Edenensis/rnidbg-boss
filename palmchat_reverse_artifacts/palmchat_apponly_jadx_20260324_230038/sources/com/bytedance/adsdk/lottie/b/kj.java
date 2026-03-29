package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.a;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class kj {
    public static com.bytedance.adsdk.lottie.model.nr.a u(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        a.u uVarU = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    uVarU = a.u.u(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.nr.a(strNextString, uVarU, zNextBoolean);
    }
}
