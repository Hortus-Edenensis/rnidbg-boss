package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.nr.sx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class o {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.lottie.model.nr.iz u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        boolean z;
        com.bytedance.adsdk.lottie.model.u.nr nrVar;
        float f;
        sx.u uVar;
        sx.nr nrVar2;
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.nr.x xVar = null;
        com.bytedance.adsdk.lottie.model.u.fx fxVarU = null;
        com.bytedance.adsdk.lottie.model.u.iz izVarFx = null;
        com.bytedance.adsdk.lottie.model.u.iz izVarFx2 = null;
        com.bytedance.adsdk.lottie.model.u.nr nrVarU = null;
        sx.u uVar2 = null;
        sx.nr nrVar3 = null;
        float fNextDouble = 0.0f;
        com.bytedance.adsdk.lottie.model.u.nr nrVar4 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.u.b bVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            z = zNextBoolean;
            nrVar = nrVar4;
            f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.lottie.model.u.nr nrVarU2 = null;
                        while (jsonReader.hasNext()) {
                            sx.nr nrVar5 = nrVar3;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            sx.u uVar3 = uVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                nrVarU2 = b.u(jsonReader, izVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            nrVar3 = nrVar5;
                            uVar2 = uVar3;
                        }
                        sx.u uVar4 = uVar2;
                        sx.nr nrVar6 = nrVar3;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            nrVar = nrVarU2;
                            nrVar3 = nrVar6;
                            uVar2 = uVar4;
                        } else {
                            if (strNextString2.equals("d") || strNextString2.equals("g")) {
                                izVar.u(true);
                                arrayList.add(nrVarU2);
                            }
                            nrVar3 = nrVar6;
                            uVar2 = uVar4;
                        }
                    }
                    uVar = uVar2;
                    nrVar2 = nrVar3;
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        nrVar4 = nrVar;
                        zNextBoolean = z;
                        nrVar3 = nrVar2;
                        fNextDouble = f;
                        uVar2 = uVar;
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        zNextBoolean = z;
                        nrVar4 = nrVar;
                        nrVar3 = nrVar2;
                        fNextDouble = f;
                        uVar2 = uVar;
                        break;
                    }
                    break;
                case "e":
                    izVarFx2 = b.fx(jsonReader, izVar);
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals(com.kuaishou.weapon.p0.t.f7496a)) {
                            fxVarU = b.u(jsonReader, izVar, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "o":
                    bVar = b.nr(jsonReader, izVar);
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "s":
                    izVarFx = b.fx(jsonReader, izVar);
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "t":
                    xVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.nr.x.LINEAR : com.bytedance.adsdk.lottie.model.nr.x.RADIAL;
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "w":
                    nrVarU = b.u(jsonReader, izVar);
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "lc":
                    uVar2 = sx.u.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "lj":
                    nrVar3 = sx.nr.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = z;
                    nrVar4 = nrVar;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    uVar = uVar2;
                    nrVar2 = nrVar3;
                    nrVar4 = nrVar;
                    zNextBoolean = z;
                    nrVar3 = nrVar2;
                    fNextDouble = f;
                    uVar2 = uVar;
                    break;
            }
        }
        sx.u uVar5 = uVar2;
        sx.nr nrVar7 = nrVar3;
        float f2 = fNextDouble;
        com.bytedance.adsdk.lottie.model.u.nr nrVar8 = nrVar4;
        boolean z2 = zNextBoolean;
        if (bVar == null) {
            bVar = new com.bytedance.adsdk.lottie.model.u.b(Collections.singletonList(new com.bytedance.adsdk.lottie.iz.u(100)));
        }
        return new com.bytedance.adsdk.lottie.model.nr.iz(strNextString, xVar, fxVarU, bVar, izVarFx, izVarFx2, nrVarU, uVar5, nrVar7, f2, arrayList, nrVar8, z2);
    }
}
