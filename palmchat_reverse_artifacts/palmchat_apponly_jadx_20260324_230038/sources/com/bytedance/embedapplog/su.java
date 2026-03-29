package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class su extends w {
    private final mh iz;
    private final Context pn;

    public su(Context context, mh mhVar) {
        super(false, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-alpha.102-7200");
        jSONObject.put("channel", this.iz.t());
        yd.u(jSONObject, "aid", this.iz.jk());
        yd.u(jSONObject, "release_build", this.iz.gi());
        yd.u(jSONObject, "app_region", this.iz.s());
        yd.u(jSONObject, "app_language", this.iz.mv());
        yd.u(jSONObject, "user_agent", this.iz.d());
        yd.u(jSONObject, "ab_sdk_version", this.iz.my());
        yd.u(jSONObject, "ab_version", this.iz.bq());
        yd.u(jSONObject, "aliyun_uuid", this.iz.nr());
        String strL = this.iz.l();
        if (TextUtils.isEmpty(strL)) {
            strL = ex.u(this.pn, this.iz);
        }
        if (!TextUtils.isEmpty(strL)) {
            yd.u(jSONObject, "google_aid", strL);
        }
        String strZ = this.iz.z();
        if (!TextUtils.isEmpty(strZ)) {
            try {
                jSONObject.put("app_track", new JSONObject(strZ));
            } catch (Throwable th) {
                ti.nr(th);
            }
        }
        String strK = this.iz.k();
        if (strK != null && strK.length() > 0) {
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, new JSONObject(strK));
        }
        yd.u(jSONObject, "user_unique_id", this.iz.o());
        return true;
    }
}
