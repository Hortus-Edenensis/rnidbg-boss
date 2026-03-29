package com.wifi.ad.core.reporter;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.heytap.mcssdk.constant.b;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.spstrategy.SPMdaLogUtil;
import com.wifi.ad.core.utils.DeviceUtils;
import com.wifi.ad.core.utils.MD5Util;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.csj.ad.NestCsjProvider;
import com.wifi.ks.ad.NestKsProvider;
import com.wifi.self.ad.NestWifiProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/reporter/AbstractReporter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "checkWxEventExt", "", "params", "Lcom/wifi/ad/core/config/EventParams;", "ext", "", "", "onEvent", b.k, "paramsJson", "onThirdEvent", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class AbstractReporter {
    private Context context;

    public AbstractReporter(Context context) {
        this.context = context;
    }

    private final void checkWxEventExt(EventParams params, Map<String, String> ext) {
        if (params == null || ext == null || !ext.containsKey(EventParams.KEY_WXEVENTEXT)) {
            return;
        }
        String str = ext.get(EventParams.KEY_WXEVENTEXT);
        boolean z = true;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(EventParams.KEY_WX_SRCID, params.getSrcId());
            jSONObject.put(EventParams.KEY_WX_APPKEY, params.getMediaId());
            String sdkFrom = params.getSdkFrom();
            if (!(sdkFrom == null || sdkFrom.length() == 0)) {
                String str2 = "";
                if (StringsKt__StringsKt.contains$default((CharSequence) sdkFrom, (CharSequence) NestKsProvider.SDK_FROM, false, 2, (Object) null)) {
                    str2 = "K";
                } else if (StringsKt__StringsKt.contains$default((CharSequence) sdkFrom, (CharSequence) "guangdiantong", false, 2, (Object) null)) {
                    str2 = WkAdxAdConfigMg.DSP_NAME_GDT;
                } else if (StringsKt__StringsKt.contains$default((CharSequence) sdkFrom, (CharSequence) NestCsjProvider.SDK_FROM, false, 2, (Object) null)) {
                    str2 = WkAdxAdConfigMg.DSP_NAME_CSJ;
                } else if (StringsKt__StringsKt.contains$default((CharSequence) sdkFrom, (CharSequence) NestWifiProvider.SDK_FROM, false, 2, (Object) null)) {
                    str2 = "W";
                } else if (StringsKt__StringsKt.contains$default((CharSequence) sdkFrom, (CharSequence) "baidu", false, 2, (Object) null)) {
                    str2 = WkAdxAdConfigMg.DSP_NAME_BAIDU;
                }
                if (WkAdxAdConfigMg.mAllDspIdMap.containsKey(str2)) {
                    jSONObject.put(EventParams.KEY_WX_DSPID, WkAdxAdConfigMg.mAllDspIdMap.get(str2));
                }
            }
            String adTitle = params.getAdTitle();
            if (adTitle == null || adTitle.length() == 0) {
                String adImage = params.getAdImage();
                if (!(adImage == null || adImage.length() == 0)) {
                    adTitle = params.getAdImage();
                }
            }
            if (adTitle != null && adTitle.length() != 0) {
                z = false;
            }
            if (!z) {
                jSONObject.put("adid", MD5Util.toMD5(adTitle));
                jSONObject.put(EventParams.KEY_WX_INDENTITYID, MD5Util.toMD5(adTitle + System.currentTimeMillis()));
            }
            String string = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "wxObject.toString()");
            ext.put(EventParams.KEY_WXEVENTEXT, string);
        } catch (Exception unused) {
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public void onEvent(String eventId, EventParams params, Map<String, String> ext) {
        String string;
        if (!TextUtils.isEmpty(eventId)) {
            SPMdaLogUtil sPMdaLogUtil = SPMdaLogUtil.INSTANCE;
            if (ArraysKt___ArraysKt.contains(sPMdaLogUtil.getAllConfigEvents(), eventId) && sPMdaLogUtil.getConfigMdaSwitch() == 0) {
                WifiLog.d("SPAD onEvent eventIdConfig " + eventId + " 不允许打点");
                return;
            }
        }
        checkWxEventExt(params, ext);
        boolean z = true;
        if (params.getThirdSdkInfo() != null) {
            try {
                JsonElement jsonElement = new JsonParser().parse(params.getThirdSdkInfo());
                Intrinsics.checkExpressionValueIsNotNull(jsonElement, "JsonParser().parse(params.thirdSdkInfo)");
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                if (asJsonArray.size() < 1) {
                    return;
                }
                for (JsonElement obj : asJsonArray) {
                    if (ext != null) {
                        Intrinsics.checkExpressionValueIsNotNull(obj, "obj");
                        obj.getAsJsonObject().addProperty("requestId", ext.get("requestId"));
                        if (ext.containsKey("appId")) {
                            obj.getAsJsonObject().addProperty("appId", ext.get("appId"));
                        }
                    }
                }
                WifiLog.d("AbstractReporter onEvent params.thirdSdkInfo != null eventId = " + eventId + " json = " + asJsonArray.toString());
                String string2 = asJsonArray.toString();
                Intrinsics.checkExpressionValueIsNotNull(string2, "paramsArray.toString()");
                onThirdEvent(eventId, string2);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (ext != null) {
            if (params.getRequestId() != null) {
                String str = ext.get("requestId");
                if (!(str == null || str.length() == 0)) {
                    params.setRequestId(str);
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(DeviceUtils.getCurrentNetworkInfo(this.context), "DeviceUtils.getCurrentNetworkInfo(this.context)");
            params.setNetType(r1[0]);
            params.setNetSubType(r1[1]);
            params.setSdkVersion(NestSdkVersion.INSTANCE.getVersion(this.context));
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(EventParams.toJson(params));
                for (Map.Entry<String, String> entry : ext.entrySet()) {
                    if (!jSONObject2.has(entry.getKey()) && (params.getRequestId() == null || !Intrinsics.areEqual("requestId", entry.getKey()))) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ext", jSONObject2);
                string = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject(EventParams.toJson(params));
                for (Map.Entry<String, String> entry2 : ext.entrySet()) {
                    if (!jSONObject4.has(entry2.getKey()) && (params.getRequestId() == null || !Intrinsics.areEqual("requestId", entry2.getKey()))) {
                        jSONObject4.put(entry2.getKey(), entry2.getValue());
                    }
                }
                jSONObject3.put("ext", jSONObject4);
                string = jSONObject3.toString();
            }
            if (string != null && string.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            onEvent(eventId, string);
            WifiLog.d("WifiNestReporter " + eventId + " : " + string);
        }
    }

    public abstract void onEvent(String eventId, String paramsJson);

    public abstract void onThirdEvent(String eventId, String paramsJson);

    public final void setContext(Context context) {
        this.context = context;
    }
}
