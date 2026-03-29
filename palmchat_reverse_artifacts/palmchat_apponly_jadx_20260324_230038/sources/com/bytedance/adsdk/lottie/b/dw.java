package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class dw {
    public static <T> List<com.bytedance.adsdk.lottie.iz.u<T>> u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, float f, xw<T> xwVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            izVar.u("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals(com.kuaishou.weapon.p0.t.f7496a)) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(bq.u(jsonReader, izVar, f, xwVar, false, z));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(bq.u(jsonReader, izVar, f, xwVar, true, z));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(bq.u(jsonReader, izVar, f, xwVar, false, z));
            }
        }
        jsonReader.endObject();
        u(arrayList);
        return arrayList;
    }

    public static <T> void u(List<? extends com.bytedance.adsdk.lottie.iz.u<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.lottie.iz.u<T> uVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.lottie.iz.u<T> uVar2 = list.get(i2);
            uVar.x = Float.valueOf(uVar2.iz);
            if (uVar.nr == null && (t = uVar2.u) != null) {
                uVar.nr = t;
                if (uVar instanceof com.bytedance.adsdk.lottie.u.nr.a) {
                    ((com.bytedance.adsdk.lottie.u.nr.a) uVar).u();
                }
            }
        }
        com.bytedance.adsdk.lottie.iz.u<T> uVar3 = list.get(i);
        if ((uVar3.u == null || uVar3.nr == null) && list.size() > 1) {
            list.remove(uVar3);
        }
    }
}
