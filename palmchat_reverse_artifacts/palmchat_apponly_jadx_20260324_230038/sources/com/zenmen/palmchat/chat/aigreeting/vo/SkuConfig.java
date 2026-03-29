package com.zenmen.palmchat.chat.aigreeting.vo;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class SkuConfig {
    public static final int INFINITE_COUNT = -999;
    public String mainTitle;
    public List<SkuItem> packageDealList;
    public String purchaseInstructions;
    public int remainDay;
    public int remainNum;
    public String subTitle;

    public boolean canSend() {
        int i = this.remainNum;
        return i > 0 || i == -999;
    }
}
