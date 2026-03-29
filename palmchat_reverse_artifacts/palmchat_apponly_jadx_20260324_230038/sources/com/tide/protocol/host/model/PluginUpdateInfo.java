package com.tide.protocol.host.model;

import com.tide.protocol.util.TdLogUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PluginUpdateInfo {
    public String downloadUrl;
    public int frameCode;
    public int hostCode;
    public int id;
    public String md5;
    public int pluginCode;
    public String pluginName;
    public boolean updateForce;

    public static PluginUpdateInfo fromJson(String str) {
        PluginUpdateInfo pluginUpdateInfo;
        try {
            pluginUpdateInfo = new PluginUpdateInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                pluginUpdateInfo.id = jSONObject.getInt("id");
                pluginUpdateInfo.pluginName = jSONObject.getString("plugin_name");
                pluginUpdateInfo.pluginCode = jSONObject.getInt("plugin_code");
                pluginUpdateInfo.downloadUrl = jSONObject.getString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
                pluginUpdateInfo.md5 = jSONObject.getString("md5");
                pluginUpdateInfo.updateForce = jSONObject.getBoolean("update_force");
                pluginUpdateInfo.hostCode = jSONObject.getInt("host_code");
                pluginUpdateInfo.frameCode = jSONObject.getInt("frame_code");
            } catch (JSONException e) {
                e = e;
                TdLogUtils.error(e.getMessage());
            }
        } catch (JSONException e2) {
            e = e2;
            pluginUpdateInfo = null;
        }
        return pluginUpdateInfo;
    }

    public String toString() {
        return "PluginUpdateInfo{id=" + this.id + ", pluginName='" + this.pluginName + "', pluginCode=" + this.pluginCode + ", downloadUrl='" + this.downloadUrl + "', md5='" + this.md5 + "', updateForce=" + this.updateForce + ", hostCode=" + this.hostCode + ", frameCode=" + this.frameCode + '}';
    }
}
