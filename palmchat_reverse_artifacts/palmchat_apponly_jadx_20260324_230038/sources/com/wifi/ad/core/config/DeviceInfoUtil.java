package com.wifi.ad.core.config;

import android.text.TextUtils;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/config/DeviceInfoUtil;", "", "()V", "DEVICEID_TAG", "", "DHID_TAG", "UID_TAG", "addDeviceInfo", "", "resObject", "Lorg/json/JSONObject;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class DeviceInfoUtil {
    public static final String DEVICEID_TAG = "deviceid";
    public static final String DHID_TAG = "dhid";
    public static final DeviceInfoUtil INSTANCE = new DeviceInfoUtil();
    public static final String UID_TAG = "uid";

    private DeviceInfoUtil() {
    }

    public final void addDeviceInfo(JSONObject resObject) {
        if (resObject != null) {
            try {
                NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
                if (TextUtils.isEmpty(nestInfoTaker.getDeviceInfo())) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(nestInfoTaker.getDeviceInfo());
                String strOptString = jSONObject.optString("dhid");
                String strOptString2 = jSONObject.optString(DEVICEID_TAG);
                String strOptString3 = jSONObject.optString(UID_TAG);
                resObject.put("dhid", strOptString);
                resObject.put(DEVICEID_TAG, strOptString2);
                resObject.put(UID_TAG, strOptString3);
            } catch (Exception unused) {
            }
        }
    }
}
