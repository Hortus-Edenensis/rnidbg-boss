package com.zenmen.palmchat.chat.specialattention;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class SpecialAttentionConfig {
    public boolean getmsg_enable;
    public int getmsg_maxtime;
    public int getmsg_popwinrate;
    public int getmsg_validtime;
    public boolean lotsmsg_enable;
    public int lotsmsg_maxtime;
    public int lotsmsg_num;
    public int lotsmsg_popwinrate;
    public int lotsmsg_validtime;
    public String nonewmsg_offline_random;
    public String nonewmsg_offline_txt;
    public String nonewmsg_online_random;
    public String nonewmsg_online_txt;
    public boolean noticebar_enable;
    public int noticebar_permanent_close;
    public String number_alert;
    public int specialattention_close_rate;
    public String specialattention_close_txt;
    public String specialattention_huawei_leftbutt;
    public String specialattention_huawei_rightbutt;
    public String specialattention_huawei_txt;
    public String specialattention_msg_close;
    public String specialattention_pop_leftbutt;
    public String specialattention_pop_rightbutt;
    public String specialattention_profile_butt;
    public String specialattention_profile_close;
    public String specialattention_profile_open;
    public String specialattention_toast_hwtxt;
    public String specialattention_toast_txt;

    public static long getOnlineStatusInterval() {
        return 1800000L;
    }

    private String getRandomString(String str) {
        String[] strArrSplit;
        if (str == null || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
            return null;
        }
        List listAsList = Arrays.asList(strArrSplit);
        Collections.shuffle(listAsList);
        return (String) listAsList.get(0);
    }

    public static long getStatusUpdateInterval() {
        return 300000L;
    }

    public String getFirstSetDes() {
        return !TextUtils.isEmpty(this.specialattention_profile_open) ? this.specialattention_profile_open : "对她/他（判断性别）特别感兴趣？\n把她/他设为特别关注，就可以：\n新消息和动态优先通知，重要消息不错过；\n专属通知栏展示关注对象，随时快速找到她/他；";
    }

    public String getHuaweiPushCancel() {
        return !TextUtils.isEmpty(this.specialattention_huawei_leftbutt) ? this.specialattention_huawei_leftbutt : "不接收";
    }

    public String getHuaweiPushConfirm() {
        return !TextUtils.isEmpty(this.specialattention_huawei_rightbutt) ? this.specialattention_huawei_rightbutt : "接收";
    }

    public String getHuaweiPushDes() {
        return !TextUtils.isEmpty(this.specialattention_huawei_txt) ? this.specialattention_huawei_txt : "是否接收订阅推送？\n订阅成功后，可接收到您特别关注好友的上线、动态、个人资料页变更通知";
    }

    public int getNotificationCloseRate() {
        int i = this.specialattention_close_rate;
        if (i > 0) {
            return i;
        }
        return 3;
    }

    public String getNotificationGuideButtonTxtOnChat() {
        return !TextUtils.isEmpty(this.specialattention_profile_butt) ? this.specialattention_profile_butt : "立即关注";
    }

    public String getNotificationGuideOnChat() {
        return !TextUtils.isEmpty(this.specialattention_close_txt) ? this.specialattention_close_txt : "系统检测到你有设置特别关注对象，需要打开通知栏权限，特权才可生效！";
    }

    public String getNotificationGuideString() {
        return !TextUtils.isEmpty(this.specialattention_profile_close) ? this.specialattention_profile_close : "对她/他（判断性别）特别感兴趣？\n把她/他设为特别关注，就可以：\n新消息和动态优先通知，重要消息不错过；\n专属通知栏展示关注对象，随时快速找到她/他；\n需要开启通知栏权限>";
    }

    public String getOfflineDes() {
        String randomString = getRandomString(this.nonewmsg_offline_random);
        return !TextUtils.isEmpty(randomString) ? randomString : "问问她/他在干什么";
    }

    public String getOnlineDes() {
        String randomString = getRandomString(this.nonewmsg_online_random);
        return !TextUtils.isEmpty(randomString) ? randomString : "在线等你聊天";
    }

    public String getSACancel() {
        return !TextUtils.isEmpty(this.specialattention_pop_leftbutt) ? this.specialattention_pop_leftbutt : "取消订阅";
    }

    public String getSAConfirm() {
        return !TextUtils.isEmpty(this.specialattention_pop_rightbutt) ? this.specialattention_pop_rightbutt : "订阅";
    }

    public String getSASetSuccessToast(boolean z) {
        return z ? !TextUtils.isEmpty(this.specialattention_toast_hwtxt) ? this.specialattention_toast_hwtxt : "订阅成功，您将收到特别关注好友的上线、动态、个人资料页变更通知" : !TextUtils.isEmpty(this.specialattention_toast_txt) ? this.specialattention_toast_txt : "订阅成功，您将收到特别关注好友的上线、动态、个人资料页变更通知";
    }
}
