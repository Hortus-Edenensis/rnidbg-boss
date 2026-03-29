package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Keep
public final class LiveURL {
    public final String backupURL;
    public final String mainURL;
    public String sdkParams;

    public LiveURL(String str, String str2, String str3) {
        this.mainURL = str;
        this.backupURL = str2;
        this.sdkParams = str3;
    }

    public static LiveURL build(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LiveURL(jSONObject.optString("main_play_url"), jSONObject.optString("backup_play_url"), jSONObject.optString("SdkParams"));
    }

    public String getVCodec() {
        JSONObject jSONObject = this.sdkParams != null ? new JSONObject(this.sdkParams) : null;
        if (jSONObject != null && jSONObject.has("VCodec")) {
            String strOptString = jSONObject.optString("VCodec");
            if (!TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
        }
        return null;
    }
}
