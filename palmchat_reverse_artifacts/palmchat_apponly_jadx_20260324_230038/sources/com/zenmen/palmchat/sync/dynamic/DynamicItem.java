package com.zenmen.palmchat.sync.dynamic;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.framework.config.DynamicVo;
import defpackage.az2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DynamicItem extends DynamicVo {
    public static DynamicItem parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DynamicItem dynamicItem = new DynamicItem();
        dynamicItem.setEnable(jSONObject.optBoolean("enable"));
        dynamicItem.setStatus(jSONObject.optInt("status"));
        dynamicItem.setInfo(jSONObject.optString("info"));
        dynamicItem.setExtra(jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA));
        return dynamicItem;
    }

    public Object parseExtra(Class cls) {
        if (TextUtils.isEmpty(getExtra())) {
            return null;
        }
        return az2.a(getExtra(), cls);
    }
}
