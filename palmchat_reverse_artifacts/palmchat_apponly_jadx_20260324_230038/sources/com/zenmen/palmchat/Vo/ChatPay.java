package com.zenmen.palmchat.Vo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatPay {
    public PayData data;
    public String payDes;
    public int resultCode;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class PayData {
        public String orderId;
        public int paymentAmount;
        public int paymentMethod;
    }

    public String getLXDForShow() {
        return this.payDes;
    }

    public boolean isCLKPay() {
        PayData payData;
        return this.resultCode == 0 && (payData = this.data) != null && payData.paymentMethod == 0;
    }

    public boolean isPayFailedWithoutMoney() {
        return this.resultCode == 1902;
    }
}
