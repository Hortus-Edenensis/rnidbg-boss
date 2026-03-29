package com.zm.fissionsdk;

import android.content.Context;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZW2Vz implements IWfReporter {
    public static final String c = "MR";
    public static final String d = "block_outer_fda";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWfReporter f16753a;
    public boolean b;

    public ZW2Vz(IWfReporter iWfReporter, boolean z) {
        this.f16753a = iWfReporter;
        this.b = z;
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public String getOaid() {
        return VZZzW.a().getOaid();
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void initOaidGet(Context context, boolean z) {
        VZZzW.a().initOaidGet(context, z);
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str) {
        WVVzW.a(c, "id", str);
        try {
            onEvent(str, (Map<String, Object>) null);
        } catch (Throwable unused) {
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str, Map<String, Object> map) {
        boolean z;
        WVVzW.a(c, "id", str, "ext", String.valueOf(map));
        if (this.b) {
            VZZzW.a().onEvent(str, map);
            z = true;
        } else {
            z = false;
        }
        if (this.f16753a != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(d, Boolean.valueOf(z));
            this.f16753a.onEvent(str, map);
        }
    }

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfReporter
    public void onEvent(String str, JSONObject jSONObject) {
        String[] strArr = new String[4];
        boolean z = false;
        strArr[0] = "id";
        strArr[1] = str;
        strArr[2] = BodyData.TYPE_JSON;
        strArr[3] = jSONObject == null ? "" : jSONObject.toString();
        WVVzW.a(c, strArr);
        if (this.b) {
            VZZzW.a().onEvent(str, jSONObject);
            z = true;
        }
        if (this.f16753a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(d, z);
            } catch (Throwable unused) {
            }
            this.f16753a.onEvent(str, jSONObject);
        }
    }
}
