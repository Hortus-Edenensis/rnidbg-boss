package com.lantern.auth.onekey.helper;

import android.content.Context;
import cn.com.chinatelecom.account.api.CtAuth;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.callback.CTCallback;
import com.lantern.auth.util.report.OneKeyReportInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CTHelper extends OneKeyHelper {
    private CtAuth mHelper;

    public CTHelper(Context context) {
        super(context);
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public int getLoginType() {
        return 8;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public String getMoveType() {
        return OneKeyHelper.MOVETYPE_TELECOM;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void init() {
        synchronized (CTHelper.class) {
            if (this.mHelper != null) {
                return;
            }
            CtAuth ctAuth = CtAuth.getInstance();
            this.mHelper = ctAuth;
            ctAuth.init(this.mContext, getClientIdByType(), getClientKeyByType(), null);
        }
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.mHelper.requestPreLogin(null, new CTCallback(true, bLCallback, oneKeyReportInfo));
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void retryAccessToken(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        preLogin(bLCallback, oneKeyReportInfo);
    }
}
