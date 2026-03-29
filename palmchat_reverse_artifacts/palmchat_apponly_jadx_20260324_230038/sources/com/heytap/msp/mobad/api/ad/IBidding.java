package com.heytap.msp.mobad.api.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IBidding {
    public static final int CODE_GET_ECPM = -1;
    public static final int CODE_RANK_LOSE_OTHER = 4;
    public static final int CODE_RANK_LOSS_AD_FAIL = 3;
    public static final int CODE_RANK_LOSS_LOW_PRICE = 1;
    public static final int CODE_RANK_LOSS_TIMEOUT = 2;
    public static final int ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE = -102;
    public static final int ECPM_PRICE_STATUS_LESS_ZERO = -105;
    public static final int ECPM_PRICE_STATUS_NULL_AD = -103;
    public static final int ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY = -104;
    public static final int ECPM_STATUS_NULL_AD_IMPL = -101;

    int getECPM();

    void notifyRankLoss(int i, String str, int i2);

    void notifyRankWin(int i);

    void setBidECPM(int i);
}
