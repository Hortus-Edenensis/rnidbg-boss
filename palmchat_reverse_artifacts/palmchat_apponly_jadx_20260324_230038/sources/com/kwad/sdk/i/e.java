package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e implements com.kwad.sdk.i.b {
    public double aAi;
    public b aXA;
    public a aXB;
    public int aXz;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.kwad.sdk.i.b {
        public List<String> aXC;
        public List<String> aXD;
        public List<String> aXE;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aXC = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("levelList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aXC.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.aXD = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tagList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aXD.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.aXE = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aXE.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aXF = -1;
        public static int aXG;
        public List<String> aSY;
        public List<String> aSZ;
        public List<String> aXH;
        public int aXI = aXF;

        public final boolean OM() {
            return this.aXI == OK;
        }

        public final void bO(boolean z) {
            this.aXI = z ? OK : aXG;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aSY = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appIdList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.aSY.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.aSZ = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.aSZ.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.aXH = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.aXH.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aAi = jSONObject.optDouble("ratio");
        this.aXz = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aXA = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aXB = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
