package com.zenmen.palmchat.chat.gift;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatGiftGuideCard {
    public static final int APPLY_SOURCE_DIALOG = 0;
    public static final int APPLY_SOURCE_PROFILE = 1;
    public static final int GUIDE_TYPE_FIRST_MSG = 0;
    public static final int GUIDE_TYPE_FRIEND_AGREE = 2;
    public static final int GUIDE_TYPE_FRIEND_APPLY = 1;
    public String buttonBgUrl;
    public String buttonText;
    public String buttonTextColor;
    public String cardBgUrl;
    public String content;
    public String giftIcon;
    public int giftId;
    public String giftName;
    public int giftPrice;
    public boolean isNewStyle;
    public String subtitle;
    public String title;
    public String titleColor;
    public String url;
    public int guideType = 0;
    public int applySource = 0;

    public String getBtnBgUrl() {
        return this.buttonBgUrl;
    }

    public String getBtnText() {
        return !TextUtils.isEmpty(this.buttonText) ? this.buttonText : "去挑选";
    }

    public Integer getBtnTextColor() {
        try {
            return Integer.valueOf(Color.parseColor(this.buttonTextColor));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getCardBgUrl() {
        return this.cardBgUrl;
    }

    public String getContentForShow() {
        return !TextUtils.isEmpty(this.content) ? this.content : "收到礼物更容易回复你";
    }

    public Integer getTitleColor() {
        try {
            return Integer.valueOf(Color.parseColor(this.titleColor));
        } catch (Exception e) {
            e.printStackTrace();
            return Integer.valueOf(Color.parseColor("#810086"));
        }
    }

    public String getTitleForShow() {
        return !TextUtils.isEmpty(this.title) ? this.title : "送朵玫瑰，表达你的诚意";
    }

    public String getUrlForShow() {
        return !TextUtils.isEmpty(this.url) ? this.url : "https://palmchat.cdn.lianxinapp.com/static/resource/img/redrosenew.png";
    }
}
