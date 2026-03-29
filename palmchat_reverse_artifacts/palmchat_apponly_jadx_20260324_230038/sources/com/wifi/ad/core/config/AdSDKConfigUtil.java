package com.wifi.ad.core.config;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wifi/ad/core/config/AdSDKConfigUtil;", "", "()V", "TAG_ALLOW_SHOW_COMP_CONFIG", "", "allShowCompConfigMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "initAllConfig", "", "result", "initAllowShowComp", "allObject", "Lorg/json/JSONObject;", "isAllowShowComp", "stragedyId", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdSDKConfigUtil {
    private static final String TAG_ALLOW_SHOW_COMP_CONFIG = "hwextra";
    public static final AdSDKConfigUtil INSTANCE = new AdSDKConfigUtil();
    private static final HashMap<String, Boolean> allShowCompConfigMap = new HashMap<>();

    private AdSDKConfigUtil() {
    }

    public final void initAllConfig(String result) {
        if (TextUtils.isEmpty(result)) {
            return;
        }
        try {
            initAllowShowComp(new JSONObject(result));
        } catch (Exception unused) {
        }
    }

    public final void initAllowShowComp(JSONObject allObject) {
        try {
            JSONArray jSONArrayOptJSONArray = allObject.optJSONArray(TAG_ALLOW_SHOW_COMP_CONFIG);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String key = jSONObjectOptJSONObject.optString("stragedyid");
                if (!TextUtils.isEmpty(key)) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("switch");
                    HashMap<String, Boolean> map = allShowCompConfigMap;
                    Intrinsics.checkExpressionValueIsNotNull(key, "key");
                    map.put(key, Boolean.valueOf(zOptBoolean));
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean isAllowShowComp(String stragedyId) {
        HashMap<String, Boolean> map = allShowCompConfigMap;
        if (!map.containsKey(stragedyId)) {
            return true;
        }
        Boolean bool = map.get(stragedyId);
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        return bool.booleanValue();
    }
}
