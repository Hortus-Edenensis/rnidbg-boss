package com.zenmen.palmchat;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ss.android.download.api.constant.BaseConstants;
import defpackage.az2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class DynamicItem {
    private boolean enable;
    private String extra;
    private String info;
    private int status;

    public static DynamicItem parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DynamicItem dynamicItem = new DynamicItem();
        dynamicItem.enable = jSONObject.optBoolean("enable");
        dynamicItem.status = jSONObject.optInt("status");
        dynamicItem.info = jSONObject.optString("info");
        dynamicItem.extra = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
        return dynamicItem;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getInfo() {
        return this.info;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public Object parseExtra(Class cls) {
        if (TextUtils.isEmpty(this.extra)) {
            return null;
        }
        return az2.a(this.extra, cls);
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
