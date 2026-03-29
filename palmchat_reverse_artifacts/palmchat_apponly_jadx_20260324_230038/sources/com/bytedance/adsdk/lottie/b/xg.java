package com.bytedance.adsdk.lottie.b;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class xg {
    public static com.bytedance.adsdk.lottie.model.nr.k u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        com.bytedance.adsdk.lottie.model.u.b bVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.u uVarX = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    uVarX = b.x(jsonReader, izVar);
                    break;
                case "o":
                    bVar = b.nr(jsonReader, izVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (bVar == null) {
            bVar = new com.bytedance.adsdk.lottie.model.u.b(Collections.singletonList(new com.bytedance.adsdk.lottie.iz.u(100)));
        }
        return new com.bytedance.adsdk.lottie.model.nr.k(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, uVarX, bVar, zNextBoolean2);
    }
}
