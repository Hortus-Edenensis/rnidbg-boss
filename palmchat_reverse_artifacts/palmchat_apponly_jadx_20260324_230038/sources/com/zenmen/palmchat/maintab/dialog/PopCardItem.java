package com.zenmen.palmchat.maintab.dialog;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PopCardItem {
    public int age;
    public String answerBtnImage;
    public String backImage;
    public String backgroup;
    public String body;
    public String bodyColor;
    public String btnColor;
    public String btnImage;
    public String btnText;
    public String btnUrl;
    public boolean dynamicEffect;
    public String effectColor;
    public Object ext;
    public String fuid;
    public String icon;
    public boolean iconMask;
    public String iconUrl;
    public int popupSeq;
    public String refuseBtnImage;
    public String regionUrl;
    public String scene;
    public int sex;
    public int style;
    public String subTitle;
    public String subTitleColor;
    public String text;
    public String textColor;
    public String title;
    public String titleColor;
    public boolean needCheckTeenMode = false;
    public int subtype = 0;
    public int shakeSwitch = 0;

    public static PopCardItem genTestItem() {
        PopCardItem popCardItem = new PopCardItem();
        popCardItem.style = 1;
        popCardItem.title = "title";
        popCardItem.titleColor = "#FFFFFF";
        popCardItem.subTitle = "subTitle";
        popCardItem.subTitleColor = "#69575A";
        popCardItem.backgroup = "#69575A";
        popCardItem.sex = 1;
        popCardItem.age = 18;
        popCardItem.iconMask = true;
        popCardItem.icon = "https://pics3.baidu.com/feed/7a899e510fb30f240105736b00c6e34cac4b0399.jpeg@f_auto?token=bf01bba12ac57e6969d2fa64ce8dc6eb";
        popCardItem.dynamicEffect = true;
        popCardItem.effectColor = "#FFA8B9";
        popCardItem.body = "body";
        popCardItem.bodyColor = "#222222";
        popCardItem.btnText = "btn";
        popCardItem.btnImage = "https://palmchat.cdn.lianxinapp.com/static/resource/img/inpopbutton.png";
        popCardItem.backImage = "https://palmchat.cdn.lianxinapp.com/static/resource/img/inpoptotal.png";
        popCardItem.btnUrl = "zenxin://activity?page=a0211&uid=6047798883206144&sourceType=60&canChat=1&domain=private.youni&bizType=34";
        popCardItem.regionUrl = "zenxin://activity?page=a0624&exid=BRspwUQfuDVRoAWEhd7Ric-1-1-lfCrF&domain=private.youni&bizType=34";
        popCardItem.popupSeq = 1;
        return popCardItem;
    }
}
