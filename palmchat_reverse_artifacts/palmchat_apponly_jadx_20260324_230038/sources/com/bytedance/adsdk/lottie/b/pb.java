package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pb implements xw<com.bytedance.adsdk.lottie.model.nr.s> {
    public static final pb u = new pb();

    private pb() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    @Override // com.bytedance.adsdk.lottie.b.xw
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.adsdk.lottie.model.nr.s nr(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listU = null;
        List<PointF> listU2 = null;
        List<PointF> listU3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listU == null || listU2 == null || listU3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listU.isEmpty()) {
                    return new com.bytedance.adsdk.lottie.model.nr.s(new PointF(), false, Collections.emptyList());
                }
                int size = listU.size();
                PointF pointF = listU.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listU.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.u(com.bytedance.adsdk.lottie.pn.n.u(listU.get(i2), listU3.get(i2)), com.bytedance.adsdk.lottie.pn.n.u(pointF2, listU2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listU.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.u(com.bytedance.adsdk.lottie.pn.n.u(listU.get(i3), listU3.get(i3)), com.bytedance.adsdk.lottie.pn.n.u(pointF3, listU2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.lottie.model.nr.s(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listU2 = bg.u(jsonReader, f);
                    break;
                case "o":
                    listU3 = bg.u(jsonReader, f);
                    break;
                case "v":
                    listU = bg.u(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }
}
