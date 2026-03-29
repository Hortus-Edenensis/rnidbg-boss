package com.kwad.sdk.core.b.a;

import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.components.core.page.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.page.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.page.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.page.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
        aVar.Vf = jSONObject.optInt("neo_tk_render_type");
    }

    private static JSONObject b(com.kwad.components.core.page.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MapBundleKey.MapObjKey.OBJ_AD_STYLE, i);
        }
        int i2 = aVar.Vf;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neo_tk_render_type", i2);
        }
        return jSONObject;
    }
}
