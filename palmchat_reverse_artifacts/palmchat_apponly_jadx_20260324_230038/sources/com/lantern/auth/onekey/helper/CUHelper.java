package com.lantern.auth.onekey.helper;

import android.content.Context;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.callback.CUCallback;
import com.lantern.auth.util.report.OneKeyReportInfo;
import com.unicom.online.account.shield.UniAccountHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CUHelper extends OneKeyHelper {
    private UniAccountHelper mHelper;

    public CUHelper(Context context) {
        super(context);
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public int getLoginType() {
        return 4;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public String getMoveType() {
        return OneKeyHelper.MOVETYPE_UNICOM;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void init() {
        synchronized (CUHelper.class) {
            if (this.mHelper != null) {
                return;
            }
            UniAccountHelper uniAccountHelper = UniAccountHelper.getInstance();
            this.mHelper = uniAccountHelper;
            uniAccountHelper.init(this.mContext, getClientIdByType(), false);
        }
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.mHelper.cuGetToken(8000, new CUCallback(true, bLCallback, oneKeyReportInfo));
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void retryAccessToken(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        preLogin(bLCallback, oneKeyReportInfo);
    }
}
