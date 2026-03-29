package com.lantern.auth.onekey.prelogin;

import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PreLoginResult {
    public LXBaseNetBean<JSONObject> loginResult;
    public String mAccessToken;
    public long mCTS;
    public long mExpires;
    public String mFromSource;
    public int mLoginType;
    public String mMaskPhone;
    public String mMsg;
    public int mRetCode;
    public String mUniqueId;
    public String mobToken;
    public String operator;

    public boolean hasLoginFromServer() {
        return this.loginResult != null;
    }

    public boolean isValid() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mCTS;
        return jCurrentTimeMillis - j < this.mExpires && j != 0;
    }

    public String toString() {
        return String.format("retcode %d, fromSource %s, maskPhone %s, loginType %d,  accessToken %s, expires %d, uniqueId %s, CTS %d, mMsg %s", Integer.valueOf(this.mRetCode), this.mFromSource, this.mMaskPhone, Integer.valueOf(this.mLoginType), this.mAccessToken, Long.valueOf(this.mExpires), this.mUniqueId, Long.valueOf(this.mCTS), this.mMsg);
    }
}
