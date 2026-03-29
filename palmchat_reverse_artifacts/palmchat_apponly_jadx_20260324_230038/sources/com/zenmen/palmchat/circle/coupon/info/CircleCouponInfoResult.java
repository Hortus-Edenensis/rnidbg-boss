package com.zenmen.palmchat.circle.coupon.info;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleCouponInfoResult {
    public static final int COUPON_NOT_RECEIVED = 0;
    public static final int COUPON_RECEIVED = 1;
    public static final int COUPON_TIME_EXPIRE = 1;
    public static final int COUPON_TIME_WITHIN = 0;
    public static final int COUPON_TYPE_EXCLUSIVE = 3;
    public static final int COUPON_TYPE_LUCKY = 1;
    public static final int COUPON_TYPE_NORMAL = 2;
    public static final int COUPON_VIEW_DISPLAY = 1;
    public static final int COUPON_VIEW_HIDE = 0;
    public int couponType;
    public String couponTypeTips;
    public int expireStatus;
    public String headIconUrl;
    public boolean lastPage;
    public String listContent;
    public String nickname;
    public String receiveAmount;
    public String receiveContent;
    public int receiveStatus;
    public List<CircleCouponInfoItem> records;
    public String specificNickname;
    public String specificUid;
    public String uid;
    public int viewDisplay;
}
