package com.zenmen.palmchat.update;

import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.wifi.adsdk.download.LxAdDLManager;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UpdateInfo implements Serializable {
    public static int TYPE_DELAY = 4;
    public static int TYPE_FORCE = 1;
    public static int TYPE_NONEED = 0;
    public static int TYPE_SELECT = 2;
    private static final long serialVersionUID = -8927188911079318146L;
    public String channel;
    public String desc;
    public String downloadUrl;
    public String pmd5;
    public int promptFrequency;
    public int psize;
    public String title;
    public int updateType;
    public int vcode;
    public String vname;

    public static UpdateInfo buildFromJson(JSONObject jSONObject) {
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.updateType = jSONObject.optInt("updateType");
        updateInfo.vcode = jSONObject.optInt(RedirectRespWrapper.KEY_VERCODE);
        updateInfo.psize = jSONObject.optInt("psize");
        updateInfo.vname = jSONObject.optString(RedirectRespWrapper.KEY_VERNAME);
        updateInfo.desc = jSONObject.optString(LxAdDLManager.ITEM_DESC);
        updateInfo.downloadUrl = jSONObject.optString("downloadUrl");
        updateInfo.pmd5 = jSONObject.optString("pmd5");
        updateInfo.channel = jSONObject.optString("channel");
        updateInfo.title = jSONObject.optString("title");
        updateInfo.promptFrequency = jSONObject.optInt("promptFrequency");
        return updateInfo;
    }

    public String toString() {
        return "UpdateInfo updateType=" + this.updateType + " vcode=" + this.vcode + " psize=" + this.psize + " vname=" + this.vname + " desc=" + this.desc + " downloadUrl=" + this.downloadUrl + " pmd5=" + this.pmd5;
    }
}
