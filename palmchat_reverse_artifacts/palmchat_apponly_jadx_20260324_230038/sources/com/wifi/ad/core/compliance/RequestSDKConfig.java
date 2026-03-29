package com.wifi.ad.core.compliance;

import android.text.TextUtils;
import com.wifi.ad.core.utils.WifiLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/compliance/RequestSDKConfig;", "", "()V", "adSDKNativeSceneArray", "Lorg/json/JSONArray;", "getAdSDKNativeSceneArray", "()Lorg/json/JSONArray;", "setAdSDKNativeSceneArray", "(Lorg/json/JSONArray;)V", "adSDKSceneArray", "getAdSDKSceneArray", "setAdSDKSceneArray", "checkAllowNativeRequest", "", "scene", "sdkName", "", "checkAllowRequest", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final class RequestSDKConfig {
    public static final RequestSDKConfig INSTANCE = new RequestSDKConfig();
    private static JSONArray adSDKNativeSceneArray;
    private static JSONArray adSDKSceneArray;

    private RequestSDKConfig() {
    }

    private final int checkAllowNativeRequest(int scene, String sdkName) {
        JSONArray jSONArray;
        if (adSDKNativeSceneArray == null) {
            return -1;
        }
        if (!TextUtils.isEmpty(sdkName) && (jSONArray = adSDKNativeSceneArray) != null) {
            if (jSONArray == null) {
                Intrinsics.throwNpe();
            }
            if (jSONArray.length() > 0) {
                JSONArray jSONArray2 = adSDKNativeSceneArray;
                if (jSONArray2 == null) {
                    Intrinsics.throwNpe();
                }
                int length = jSONArray2.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONArray jSONArray3 = adSDKNativeSceneArray;
                        if (jSONArray3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Object obj = jSONArray3.get(i);
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        String adScene = jSONObject.optString("adScenes");
                        if (!TextUtils.isEmpty(adScene)) {
                            String adSdk = jSONObject.optString("enableSDK");
                            Intrinsics.checkExpressionValueIsNotNull(adScene, "adScene");
                            if (!StringsKt__StringsKt.contains$default((CharSequence) adScene, (CharSequence) "all", false, 2, (Object) null)) {
                                List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) adScene, new String[]{","}, false, 0, 6, (Object) null);
                                if (listSplit$default != null && (!listSplit$default.isEmpty())) {
                                    Iterator it = listSplit$default.iterator();
                                    while (it.hasNext()) {
                                        if (Intrinsics.areEqual(String.valueOf(scene), (String) it.next()) && !TextUtils.isEmpty(adSdk)) {
                                            Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                            if (StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) "all", false, 2, (Object) null)) {
                                                return 1;
                                            }
                                            Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                            return StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) sdkName, false, 2, (Object) null) ? 1 : 0;
                                        }
                                    }
                                }
                            } else if (!TextUtils.isEmpty(adSdk)) {
                                Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                if (StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) "all", false, 2, (Object) null)) {
                                    return 1;
                                }
                                Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                return StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) sdkName, false, 2, (Object) null) ? 1 : 0;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return 1;
    }

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final boolean checkAllowRequest(int scene, String sdkName) {
        JSONArray jSONArray;
        int iCheckAllowNativeRequest = checkAllowNativeRequest(scene, sdkName);
        WifiLog.d("DDT checkAllowRequest res " + iCheckAllowNativeRequest + " scene " + scene + " sdkName " + sdkName);
        ?? r5 = 0;
        if (iCheckAllowNativeRequest != -1) {
            if (iCheckAllowNativeRequest == 1) {
                return true;
            }
            if (iCheckAllowNativeRequest == 0) {
                return false;
            }
        }
        if (!TextUtils.isEmpty(sdkName) && (jSONArray = adSDKSceneArray) != null) {
            if (jSONArray == null) {
                Intrinsics.throwNpe();
            }
            if (jSONArray.length() > 0) {
                JSONArray jSONArray2 = adSDKSceneArray;
                if (jSONArray2 == null) {
                    Intrinsics.throwNpe();
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        JSONArray jSONArray3 = adSDKSceneArray;
                        if (jSONArray3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Object obj = jSONArray3.get(i);
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        String adScene = jSONObject.optString("adScenes");
                        if (!TextUtils.isEmpty(adScene)) {
                            String adSdk = jSONObject.optString("enableSDK");
                            Intrinsics.checkExpressionValueIsNotNull(adScene, "adScene");
                            if (!StringsKt__StringsKt.contains$default(adScene, "all", (boolean) r5, 2, (Object) null)) {
                                String[] strArr = new String[1];
                                strArr[r5] = ",";
                                List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) adScene, strArr, false, 0, 6, (Object) null);
                                if (listSplit$default != null && (!listSplit$default.isEmpty())) {
                                    Iterator it = listSplit$default.iterator();
                                    while (it.hasNext()) {
                                        if (Intrinsics.areEqual(String.valueOf(scene), (String) it.next()) && !TextUtils.isEmpty(adSdk)) {
                                            Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                            if (StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) "all", false, 2, (Object) null)) {
                                                return true;
                                            }
                                            Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                            return StringsKt__StringsKt.contains$default((CharSequence) adSdk, (CharSequence) sdkName, false, 2, (Object) null);
                                        }
                                    }
                                }
                            } else if (!TextUtils.isEmpty(adSdk)) {
                                Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                if (StringsKt__StringsKt.contains$default(adSdk, "all", (boolean) r5, 2, (Object) null)) {
                                    return true;
                                }
                                Intrinsics.checkExpressionValueIsNotNull(adSdk, "adSdk");
                                return StringsKt__StringsKt.contains$default(adSdk, sdkName, (boolean) r5, 2, (Object) null);
                            }
                        }
                        i++;
                        r5 = 0;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return true;
    }

    public final JSONArray getAdSDKNativeSceneArray() {
        return adSDKNativeSceneArray;
    }

    public final JSONArray getAdSDKSceneArray() {
        return adSDKSceneArray;
    }

    public final void setAdSDKNativeSceneArray(JSONArray jSONArray) {
        adSDKNativeSceneArray = jSONArray;
    }

    public final void setAdSDKSceneArray(JSONArray jSONArray) {
        adSDKSceneArray = jSONArray;
    }
}
