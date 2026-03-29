package com.lantern.auth.onekey.helper;

import android.content.Context;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.callback.CMCallback;
import com.lantern.auth.util.report.OneKeyReportInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CMHelper extends OneKeyHelper {
    private AuthnHelper mHelper;

    public CMHelper(Context context) {
        super(context);
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public int getLoginType() {
        return 1;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public String getMoveType() {
        return OneKeyHelper.MOVETYPE_CMCC;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void init() {
        synchronized (CMHelper.class) {
            if (this.mHelper != null) {
                return;
            }
            this.mHelper = AuthnHelper.getInstance(this.mContext);
        }
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.mHelper.getPhoneInfo(getClientIdByType(), getClientKeyByType(), new CMCallback(true, bLCallback, oneKeyReportInfo));
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void retryAccessToken(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.mHelper.loginAuth(getClientIdByType(), getClientKeyByType(), new CMCallback(false, bLCallback, oneKeyReportInfo));
    }
}
