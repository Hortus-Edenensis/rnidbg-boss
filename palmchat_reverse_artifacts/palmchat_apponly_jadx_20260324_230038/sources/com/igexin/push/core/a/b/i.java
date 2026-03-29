package com.igexin.push.core.a.b;

import com.wifi.ad.core.config.DeviceInfoUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7150a = "ResponseDeviceidAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_deviceid")) {
                return true;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.getString(DeviceInfoUtil.DEVICEID_TAG));
            if (com.igexin.push.core.e.H == null) {
                return true;
            }
            com.igexin.push.core.a.b.d().i();
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
