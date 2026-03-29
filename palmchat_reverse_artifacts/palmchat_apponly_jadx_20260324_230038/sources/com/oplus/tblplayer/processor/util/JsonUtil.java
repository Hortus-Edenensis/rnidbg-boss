package com.oplus.tblplayer.processor.util;

import android.content.Context;
import android.util.JsonReader;
import android.util.Pair;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class JsonUtil {
    private static final int MAX_MATRIX_SIZE = 9;

    public static List<Pair<Long, float[]>> createTextureMatrixListFromJson(Context context, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(context.getAssets().open(str)));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if ("matrices".equals(jsonReader.nextName())) {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        long j = Long.parseLong(jsonReader.nextName());
                        arrayList.add(new Pair(Long.valueOf(j), readMatrixArray(jsonReader)));
                    }
                    jsonReader.endObject();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            return arrayList;
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static float[] readMatrixArray(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = (float) jsonReader.nextDouble();
        }
        jsonReader.endArray();
        return fArr;
    }
}
