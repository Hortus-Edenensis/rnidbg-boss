package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.Keyword;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ag extends ah {
    private static final int B = -111111;
    private static final String Z = "JsbBaseAdRequest";

    public ag(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SearchInfo Code(JSONObject jSONObject) {
        String[] strArrSplit;
        int length;
        int i;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.az.aE);
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.aF);
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.aG);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strOptString3)) {
            String[] strArrSplit2 = strOptString3.split(",");
            if (TextUtils.isEmpty(strOptString2)) {
                strArrSplit = null;
            } else {
                strArrSplit = strOptString2.split(",");
                if (!TextUtils.isEmpty(strOptString2)) {
                    length = strArrSplit.length;
                }
                for (i = 0; i < strArrSplit2.length; i++) {
                    if (!TextUtils.isEmpty(strArrSplit2[i])) {
                        arrayList.add(new Keyword(length >= i + 1 ? Integer.valueOf(com.huawei.openalliance.ad.utils.bc.Code(strArrSplit[i], 0)) : null, strArrSplit2[i]));
                    }
                }
            }
            length = 0;
            while (i < strArrSplit2.length) {
            }
        }
        String strOptString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.aH);
        if (TextUtils.isEmpty(strOptString) && arrayList.isEmpty() && TextUtils.isEmpty(strOptString4)) {
            return null;
        }
        return new SearchInfo(strOptString, arrayList, strOptString4);
    }

    private Map<String, Bundle> D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) com.huawei.openalliance.ad.utils.ad.V(str, Map.class, Map.class);
        fh.Code(Z, "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                map2.put(str2, bundle);
            }
        }
        return map2;
    }

    private App V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("version");
        String strOptString3 = jSONObject.optString("pkgname");
        if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new App(strOptString3, strOptString, strOptString2);
    }

    public abstract void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    public Location I(String str) {
        JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("location");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("latitude");
        String strOptString2 = jSONObjectOptJSONObject.optString("longitude");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.cg, strOptString) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.cg, strOptString2)) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(new BigDecimal(strOptString).doubleValue());
        location.setLongitude(new BigDecimal(strOptString2).doubleValue());
        return location;
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.ag.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ag.this.Code(context, str, remoteCallResultCallback);
                } catch (Throwable th) {
                    fh.Code(5, ag.Z, "executeInNetworkThread exception", th);
                    ah.Code(remoteCallResultCallback, ag.this.Code, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
                }
            }
        });
    }

    private void Code(Context context, String str, RequestOptions.Builder builder, AdParam.Builder builder2) {
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        JSONObject jSONObject = new JSONObject(str);
        Integer numValueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.n, -111111));
        Integer numValueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.o, -111111));
        Integer numValueOf3 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.j, -111111));
        Integer numValueOf4 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.k, -111111));
        Integer numValueOf5 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.l, -111111));
        Integer numValueOf6 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.m, -111111));
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.az.p);
        Boolean boolValueOf = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.G, true));
        Boolean boolValueOf2 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.H, true));
        Integer numValueOf7 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.az.J, 0));
        Boolean boolValueOf3 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.K, false));
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.P);
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.x);
        String strOptString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.N);
        String strOptString5 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.O);
        Integer numValueOf8 = Integer.valueOf(jSONObject.optInt("brand", -111111));
        String strOptString6 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.t);
        String strOptString7 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.W);
        Map<String, Bundle> mapD = D(jSONObject.optString(com.huawei.openalliance.ad.constant.az.M));
        App appV = V(jSONObject.optJSONObject("app"));
        Location locationI = I(str);
        SearchInfo searchInfoCode = Code(jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.az.aD));
        if (builder != null) {
            if (numValueOf != null) {
                i3 = -111111;
                if (-111111 != numValueOf.intValue()) {
                    builder.setTagForChildProtection(numValueOf);
                }
            } else {
                i3 = -111111;
            }
            if (numValueOf2 != null && i3 != numValueOf2.intValue()) {
                builder.setTagForUnderAgeOfPromise(numValueOf2);
            }
            if (!TextUtils.isEmpty(strOptString)) {
                builder.setAdContentClassification(strOptString);
            }
            if (i3 != numValueOf4.intValue()) {
                builder.setIsQueryUseEnabled(numValueOf4);
            }
            if (numValueOf3 != null && i3 != numValueOf3.intValue()) {
                builder.setNonPersonalizedAd(numValueOf3);
            }
            if (numValueOf5 != null && i3 != numValueOf5.intValue()) {
                builder.setHwNonPersonalizedAd(numValueOf5);
            }
            if (numValueOf6 != null && i3 != numValueOf6.intValue()) {
                builder.setThirdNonPersonalizedAd(numValueOf6);
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                builder.setConsent(strOptString2);
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                builder.setSearchTerm(strOptString3);
            }
            if (boolValueOf != null) {
                builder.setRequestLocation(boolValueOf);
            }
            if (appV != null) {
                builder.setApp(appV);
            }
            if (TextUtils.isEmpty(strOptString4)) {
                str3 = strOptString4;
            } else {
                str3 = strOptString4;
                builder.setAppLang(str3);
            }
            if (TextUtils.isEmpty(strOptString5)) {
                str2 = strOptString5;
            } else {
                str2 = strOptString5;
                builder.setAppCountry(str2);
            }
            if (mapD != null) {
                builder.setExtras(mapD);
            }
            if (searchInfoCode != null) {
                builder.setSearchInfo(searchInfoCode);
            }
        } else {
            str2 = strOptString5;
            str3 = strOptString4;
        }
        if (builder2 != null) {
            if (numValueOf != null) {
                i = -111111;
                if (-111111 != numValueOf.intValue()) {
                    builder2.setTagForChildProtection(numValueOf);
                }
            } else {
                i = -111111;
            }
            if (numValueOf2 != null && i != numValueOf2.intValue()) {
                builder2.setTagForUnderAgeOfPromise(numValueOf2);
            }
            if (!TextUtils.isEmpty(strOptString)) {
                builder2.setAdContentClassification(strOptString);
            }
            if (numValueOf3 != null) {
                i2 = -111111;
                if (-111111 != numValueOf3.intValue()) {
                    builder2.setNonPersonalizedAd(numValueOf3);
                }
            } else {
                i2 = -111111;
            }
            if (numValueOf5 != null && i2 != numValueOf5.intValue()) {
                builder2.setHwNonPersonalizedAd(numValueOf5);
            }
            if (numValueOf6 != null && i2 != numValueOf6.intValue()) {
                builder2.setThirdNonPersonalizedAd(numValueOf6);
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                builder2.setConsent(strOptString2);
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                builder2.setSearchTerm(strOptString3);
            }
            if (boolValueOf != null) {
                builder2.setRequestLocation(boolValueOf.booleanValue());
            }
            if (appV != null) {
                builder2.setAppInfo(appV);
            }
            if (!TextUtils.isEmpty(str3)) {
                builder2.setAppLang(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                builder2.setAppCountry(str2);
            }
            if (!TextUtils.isEmpty(strOptString7)) {
                builder2.setContentBundle(Z(strOptString7));
            }
            if (locationI != null) {
                builder2.setLocation(locationI);
            }
            if (searchInfoCode != null) {
                builder2.setSearchInfo(searchInfoCode);
            }
        }
        if (numValueOf8 != null && -111111 != numValueOf8.intValue()) {
            HiAd.getInstance(context).setBrand(numValueOf8.intValue());
        }
        if (boolValueOf2 != null) {
            HiAd.getInstance(context).setAppInstalledNotify(boolValueOf2.booleanValue());
        }
        if (numValueOf7.intValue() != 0) {
            HiAd.getInstance(context).setAppActivateStyle(numValueOf7.intValue());
        }
        if (boolValueOf3 != null) {
            HiAd.getInstance(context).setAppAutoOpenForbidden(boolValueOf3.booleanValue());
        }
        if (TextUtils.isEmpty(strOptString6)) {
            return;
        }
        HiAd.getInstance(context).setCountryCode(strOptString6);
    }

    public AdParam I(Context context, String str) {
        AdParam.Builder builder = new AdParam.Builder();
        Code(context, str, (RequestOptions.Builder) null, builder);
        return builder.build();
    }

    public RequestOptions V(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        Code(context, str, builder, (AdParam.Builder) null);
        return builder.build();
    }

    public String Z(String str) {
        return str;
    }
}
