package com.zenmen.palmchat.utils.captcha;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CaptchaResult {
    public long diffTime;
    public String modeType;
    public String rid;

    public CaptchaResult(String str, String str2, long j) {
        this.rid = str;
        this.modeType = str2;
        this.diffTime = j;
    }
}
