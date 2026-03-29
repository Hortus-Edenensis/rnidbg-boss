package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.sx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class y {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.lottie.model.nr.sx u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        com.bytedance.adsdk.lottie.model.u.nr nrVarU;
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVar = null;
        com.bytedance.adsdk.lottie.model.u.u uVarX = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
        sx.u uVar = null;
        sx.nr nrVar2 = null;
        float fNextDouble = 0.0f;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.u.b bVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    uVarX = b.x(jsonReader, izVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        nrVarU = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                nrVarU = b.u(jsonReader, izVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                izVar.u(true);
                                arrayList.add(nrVarU);
                                break;
                            case "o":
                                nrVar = nrVarU;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                case "o":
                    bVar = b.nr(jsonReader, izVar);
                    continue;
                    break;
                case "w":
                    nrVarU2 = b.u(jsonReader, izVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    uVar = sx.u.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    nrVar2 = sx.nr.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (bVar == null) {
            bVar = new com.bytedance.adsdk.lottie.model.u.b(Collections.singletonList(new com.bytedance.adsdk.lottie.iz.u(100)));
        }
        return new com.bytedance.adsdk.lottie.model.nr.sx(strNextString, nrVar, arrayList, uVarX, bVar, nrVarU2, uVar, nrVar2, fNextDouble, zNextBoolean);
    }
}
