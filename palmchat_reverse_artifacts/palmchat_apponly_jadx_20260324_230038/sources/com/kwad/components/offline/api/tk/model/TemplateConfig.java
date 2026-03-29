package com.kwad.components.offline.api.tk.model;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TemplateConfig extends BaseOfflineCompoJsonParse<TemplateConfig> {
    public String bundleFile;
    public String bundleId;
    public String md5;
    public String sha256;
    public String version;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.bundleId = jSONObject.optString("bundleId");
        templateConfig.bundleFile = jSONObject.optString("bundleFile");
        templateConfig.version = jSONObject.optString("version");
        templateConfig.md5 = jSONObject.optString("md5");
        templateConfig.sha256 = jSONObject.optString("sha256");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(templateConfig.bundleId)) {
            aa.putValue(jSONObject, "bundleId", templateConfig.bundleId);
        }
        if (!TextUtils.isEmpty(templateConfig.bundleFile)) {
            aa.putValue(jSONObject, "bundleFile", templateConfig.bundleFile);
        }
        if (!TextUtils.isEmpty(templateConfig.version)) {
            aa.putValue(jSONObject, "version", templateConfig.version);
        }
        if (!TextUtils.isEmpty(templateConfig.md5)) {
            aa.putValue(jSONObject, "md5", templateConfig.md5);
        }
        if (!TextUtils.isEmpty(templateConfig.sha256)) {
            aa.putValue(jSONObject, "sha256", templateConfig.sha256);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig) {
        return toJson(templateConfig, (JSONObject) null);
    }
}
