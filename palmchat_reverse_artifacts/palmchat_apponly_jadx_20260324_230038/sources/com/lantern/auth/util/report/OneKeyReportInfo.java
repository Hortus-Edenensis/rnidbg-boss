package com.lantern.auth.util.report;

import android.text.TextUtils;
import com.lantern.auth.app.FunDC;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OneKeyReportInfo {
    public boolean isRetry = false;
    public int mLoginType;
    public String mRemoteType;
    public String mScene;
    public String mSid;

    public Map<String, String> toMap() {
        HashMap<String, String> mapGenExt = FunDC.genExt(null, null);
        if (!TextUtils.isEmpty(this.mSid)) {
            mapGenExt.put("sid", this.mSid);
        }
        if (!TextUtils.isEmpty(this.mScene)) {
            mapGenExt.put("fromSource", this.mScene);
        }
        if (!TextUtils.isEmpty(this.mRemoteType)) {
            mapGenExt.put("remoteType", this.mRemoteType);
        }
        int i = this.mLoginType;
        int i2 = i & 16;
        if (i2 == 16) {
            i = i2;
        }
        mapGenExt.put("loginType", i + "");
        return mapGenExt;
    }
}
