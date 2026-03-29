package com.zenmen.palmchat.paidservices.readstate.guide;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class GuideConfig {
    public int totalNum = 8;
    public long intervalSeconds = 60;
    public String svip_success = "消息已读权益已到账，已开始自动更新状态，去发消息吧～";
    public boolean cmdSwitch = true;
    public FirstMsg firstMsg = new FirstMsg();
    public Msgs Msgs = new Msgs();
    public Visits visits = new Visits();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class FirstMsg {
        public boolean enable = true;
        public String text = "查看消息是否已读";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Msgs {
        public int num = 2;
        public String text = "消息迟迟不回？查看消息是否已读";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Visits {
        public int num = 2;
        public String text = "想知道ta看消息了没？查看消息是否已读";
    }
}
