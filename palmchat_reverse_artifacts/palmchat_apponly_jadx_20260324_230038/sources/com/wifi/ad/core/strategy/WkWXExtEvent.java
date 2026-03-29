package com.wifi.ad.core.strategy;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.heytap.mcssdk.constant.b;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.MD5Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/wifi/ad/core/strategy/WkWXExtEvent;", "", "()V", "createWxEventMap", "", "slotid", "req_mode", "", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "requestId", "mContext", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkWXExtEvent {
    public static final WkWXExtEvent INSTANCE = new WkWXExtEvent();

    private WkWXExtEvent() {
    }

    public final String createWxEventMap(String slotid, int req_mode, AdParams adParams, String requestId, Context mContext) throws JSONException {
        if (adParams.getExt() == null) {
            return "";
        }
        Map<String, String> ext = adParams.getExt();
        String str = ext != null ? ext.get("h5EventExt") : null;
        if (str == null || str.length() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(str);
        String appId = adParams.getAppId();
        if (!(appId == null || appId.length() == 0)) {
            jSONObject.put(b.z, appId);
        }
        if (!(slotid.length() == 0)) {
            jSONObject.put("slotid", slotid);
        }
        jSONObject.put("sceneid", adParams.getScene());
        jSONObject.put("req_mode", req_mode);
        jSONObject.put(MapBundleKey.MapObjKey.OBJ_QID, requestId);
        jSONObject.put("sid", requestId);
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        jSONObject.put("imeimd5", MD5Util.toMD5(nestInfoTaker.getMeID(mContext)));
        jSONObject.put("imei1md5", MD5Util.toMD5(nestInfoTaker.getImEI1(mContext)));
        jSONObject.put("imei2md5", MD5Util.toMD5(nestInfoTaker.getImEI2(mContext)));
        jSONObject.put("aidmd5", MD5Util.toMD5(nestInfoTaker.getAndroidId()));
        jSONObject.put("oaid", nestInfoTaker.getOaId());
        jSONObject.put("sdkv", NestSdkVersion.INSTANCE.getVersion(mContext));
        String string = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "resJson.toString()");
        return string;
    }
}
