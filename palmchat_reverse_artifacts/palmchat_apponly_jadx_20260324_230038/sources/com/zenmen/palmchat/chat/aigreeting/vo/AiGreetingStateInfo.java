package com.zenmen.palmchat.chat.aigreeting.vo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AiGreetingStateInfo {
    public int remainCount;
    public int remainDay;
    public SkuConfig skuConfig;

    public String getRemainCountForShow() {
        if (this.remainCount == -999) {
            return "剩余无限次";
        }
        return "剩余 " + this.remainCount + " 次";
    }

    public boolean hasRemainCountFroRequest() {
        int i = this.remainCount;
        return i > 0 || i == -999;
    }
}
