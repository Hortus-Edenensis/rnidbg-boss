package com.zenmen.palmchat.chat.intimacy.vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class IntimacyConfig {
    public List<QuickSendVo> chatwindow_sayhi_gift;
    public List<String> chatwindow_sayhi_txt;
    public String giftpanel_banner;
    public float msglist_value = 0.5f;
    public float chatwindow_alert_pic = 5.0f;
    public float chatwindow_alert_audio = 50.0f;
    public float chatwindow_alert_call = 2000.0f;
    public String specialsendmsg_toast = "你们的亲密度太低啦！还不能互发图片消息，赶快和TA聊聊，提升亲密度吧！";
}
