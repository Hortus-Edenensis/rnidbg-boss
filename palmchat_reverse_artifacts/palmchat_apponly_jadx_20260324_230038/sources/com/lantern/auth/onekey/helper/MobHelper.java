package com.lantern.auth.onekey.helper;

import android.content.Context;
import cn.fly.verify.FlyVerify;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.callback.MobCallback;
import com.lantern.auth.util.report.OneKeyReportInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MobHelper extends OneKeyHelper {
    public MobHelper(Context context) {
        super(context);
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public int getLoginType() {
        return 16;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public String getMoveType() {
        return OneKeyHelper.MOVETYPE_MOB;
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        FlyVerify.preVerify(new MobCallback(true, bLCallback, oneKeyReportInfo));
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void retryAccessToken(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        FlyVerify.verify(new MobCallback(false, bLCallback, oneKeyReportInfo));
    }

    @Override // com.lantern.auth.onekey.helper.OneKeyHelper
    public void init() {
    }
}
