package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.x;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends com.kwad.sdk.core.response.a.a {
    public String aAf;
    public String aAg;
    public JSONObject aAh;
    public double aAi;
    public String maxVersion;
    public String minVersion;
    public String tag;
    public String type;
    public int category = -1;
    public double aAj = 0.0d;
    public int aAk = 1;

    private boolean cT(String str) {
        if (str == null) {
            return false;
        }
        int i = this.category;
        if (i == 0) {
            return str.equals(ILoggerReporter.Category.APM_LOG);
        }
        if (i != 1) {
            return false;
        }
        return str.equals(ILoggerReporter.Category.ERROR_LOG);
    }

    private boolean f(d dVar) {
        if (dVar == null || dVar.msg == null) {
            return false;
        }
        JSONObject jSONObject = this.aAh;
        if (jSONObject == null) {
            return true;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = dVar.msg.opt(next);
            if (objOpt == null || !objOpt.equals(this.aAh.opt(next))) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(@Nullable d dVar) {
        if (dVar == null) {
            return false;
        }
        try {
            if (!cT(dVar.category)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch category not match " + dVar.category + " to " + this.category);
                return false;
            }
            String str = this.minVersion;
            if (str != null && !str.isEmpty() && !bx.aC(BuildConfig.VERSION_NAME, this.minVersion)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch minVersion not match 4.9.20.1 to " + this.minVersion);
                return false;
            }
            String str2 = this.maxVersion;
            if (str2 != null && !str2.isEmpty() && bx.aC(BuildConfig.VERSION_NAME, this.maxVersion)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch maxVersion not match 4.9.20.1 to " + this.maxVersion);
                return false;
            }
            String str3 = this.tag;
            if (str3 != null && !str3.isEmpty() && !this.tag.equals(dVar.tag)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch tag not match " + dVar.tag + " to " + this.tag);
                return false;
            }
            String str4 = this.aAf;
            if (str4 != null && !str4.isEmpty() && !this.aAf.equals(dVar.aAc.value)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch biz not match " + dVar.aAc.value + " to " + this.aAf);
                return false;
            }
            String str5 = this.aAg;
            if (str5 != null && !str5.isEmpty() && !this.aAg.equals(dVar.aAd.value)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch subBiz not match " + dVar.aAd.value + " to " + this.aAg);
                return false;
            }
            String str6 = this.type;
            if (str6 != null && !str6.isEmpty()) {
                com.kwai.adclient.kscommerciallogger.model.d dVar2 = dVar.aAe;
                if (dVar2 == null) {
                    return false;
                }
                if (!this.type.equals(dVar2.getValue())) {
                    com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch type not match " + dVar.aAe.getValue() + " to " + this.type);
                    return false;
                }
            }
            if (f(dVar)) {
                return true;
            }
            com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatchForMsg not match " + dVar.msg + " to " + this.aAh);
            return false;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.category = jSONObject.optInt(x.cw, 0);
        this.minVersion = jSONObject.optString("min_version");
        this.maxVersion = jSONObject.optString("max_version");
        this.tag = jSONObject.optString("tag");
        this.aAf = jSONObject.optString("biz");
        this.aAg = jSONObject.optString("subBiz");
        this.type = jSONObject.optString("type");
        this.aAh = jSONObject.optJSONObject("custom_dimension");
        this.aAi = jSONObject.optDouble("ratio", 0.0d);
        this.aAj = jSONObject.optDouble("convert", 0.0d);
        this.aAk = jSONObject.optInt("device_mode", 1);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, x.cw, this.category);
        aa.putValue(jSONObject, "min_version", this.minVersion);
        aa.putValue(jSONObject, "max_version", this.maxVersion);
        aa.putValue(jSONObject, "tag", this.tag);
        aa.putValue(jSONObject, "biz", this.aAf);
        aa.putValue(jSONObject, "subBiz", this.aAg);
        aa.putValue(jSONObject, "type", this.type);
        aa.putValue(jSONObject, "custom_dimension", this.aAh);
        aa.putValue(jSONObject, "ratio", this.aAi);
        aa.putValue(jSONObject, "convert", this.aAj);
        aa.putValue(jSONObject, "device_mode", this.aAk);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public final String toString() {
        return "KCEventRatioRule{category=" + this.category + ", minVersion='" + this.minVersion + "', maxVersion='" + this.maxVersion + "', tag='" + this.tag + "', biz='" + this.aAf + "', subBiz='" + this.aAg + "', type='" + this.type + "', customDimension=" + this.aAh + ", ratio=" + this.aAi + ", convert=" + this.aAj + ", device_mode=" + this.aAk + '}';
    }
}
