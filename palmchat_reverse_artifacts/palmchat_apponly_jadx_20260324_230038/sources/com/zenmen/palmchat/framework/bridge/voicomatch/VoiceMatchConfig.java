package com.zenmen.palmchat.framework.bridge.voicomatch;

import android.text.TextUtils;
import androidx.annotation.Keep;
import defpackage.ap3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchConfig {
    public EntryMsg entry_msg;
    public String speedupExtra;
    public SpeedupPOP speedupPOP;
    public String rule = "";
    public SpeedUp speedup = new SpeedUp();
    public Ending ending = new Ending();
    public String notice = "安全提示：语音聊天过程中请文明用语，平台将严厉打击擦边色情、诋毁诽谤等行为。";
    public String match_timeout = "排队人过多，使用加速卡抢先开聊";
    public int exitseconds_male = 10;
    public int exitseconds_female = 10;
    public int exitseconds_payer = 20;
    public long fake_timeout = 10;
    public OpenProfile openprofile = new OpenProfile();
    public AutoCheck autoCheck = new AutoCheck();
    public int totalMinutes = 5;
    public String countDownTips = "通话时长不足1分钟了，倒计时结束后将自动挂断电话哦~";
    public String timeUpPOP = "次数已用完，使用加速卡额外匹配一次";
    private VideoChat videoChat = null;
    public String accept_video_confim = "接听视频";
    public String accept_video_deny = "不想";

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class AutoCheck {
        public boolean autoCheck = true;
        public int autoCheckType = 1001;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Ending {
        public String exit = "因对方秒退，本次匹配不消耗次数";
        public String profileopend = "可在消息页找到ta哦，记得常联系~";
        public String profilenotopen = "继续匹配吧，表现越好匹配效率越高哦";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class EntryBubble {
        public EntryBubbleItem female;
        public EntryBubbleItem male;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class EntryBubbleItem {
        public int count;
        public int day_gap;
        public List<Integer> day_visits;
        public boolean enable;
        public int frequency_days = 0;
        public List<String> images;
        public String subtitle;
        public String taichi;
        public String title;
        public String url;

        public static EntryBubbleItem getTestItem() {
            EntryBubbleItem entryBubbleItem = new EntryBubbleItem();
            entryBubbleItem.enable = true;
            entryBubbleItem.taichi = "LX-62188_B,LX-62188_D";
            entryBubbleItem.title = "哈哈";
            entryBubbleItem.subtitle = "x人在等待";
            entryBubbleItem.url = "zenxin://activity?page=a0623&from=7&subPage=1";
            entryBubbleItem.images = getTestList();
            entryBubbleItem.frequency_days = 0;
            ArrayList arrayList = new ArrayList();
            entryBubbleItem.day_visits = arrayList;
            arrayList.add(1);
            entryBubbleItem.day_visits.add(2);
            entryBubbleItem.day_visits.add(3);
            entryBubbleItem.day_gap = 0;
            return entryBubbleItem;
        }

        private static List<String> getTestList() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("https://img1.baidu.com/it/u=2172818577,3783888802&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1422");
            arrayList.add("https://img1.baidu.com/it/u=3572707476,2215453850&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=1066");
            arrayList.add("https://img2.baidu.com/it/u=3018303209,1765139986&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=722");
            return arrayList;
        }

        public boolean isEnable() {
            String[] strArrSplit;
            if (this.enable && !TextUtils.isEmpty(this.taichi) && (strArrSplit = this.taichi.split(",")) != null && strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    String[] strArrSplit2 = str.split("_");
                    if (strArrSplit2 != null && strArrSplit2.length == 2) {
                        if (strArrSplit2[1].equals(ap3.a().n(strArrSplit2[0], ""))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class EntryMsg {
        public EntryMsgItem female;
        public EntryMsgItem male;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class EntryMsgItem {
        public boolean enable = true;
        public String sysmsg_show = "找人语音聊聊天？语音速配，真实声音、实时连线，去试试>";
        public String text;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class OpenProfile {
        public int limitminutes = 3;
        public String manullyopen = "你们已互相公开身份，可以在消息页找到对方哦";
        public String autoopen = "通话已满3分钟，自动公开身份，可以在消息页找到对方哦";
        public String autoopen_v2 = "通话已满x分钟，自动公开身份，可以在消息页找到对方哦";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SpeedUp {
        public String title = "正在加速匹配中";
        public String desc = "匹配效率翻3倍";
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SpeedupPOP {
        public boolean enable;
        public int m;
        public String title;
        public int waitSeconds;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class VideoChat {
        public String inviteButton = "邀ta视频";
        public String tips = "公开身份之后可以邀请ta视频聊天哦->";
        public String inviteConfirm = "确认邀请对方视频吗？本次将消耗1张视频卡";
        public String openInvite = "你已经公开身份，可以邀请ta公开身份并视频哦～";
        public String answerPopup = "ta对你很感兴趣，邀请你视频聊聊天";
        public String answerOpenPopup = "ta对你很感兴趣，邀请你公开身份、视频聊聊天";
        public int holdSeconds = 5;
        public String inviterHolding = "对方已同意邀请，即将进入视频通话页面，请您整理仪容仪表，注意文明聊天。";
        public String inviteeHolding = "即将进入视频通话页面，请您整理仪容仪表，注意文明聊天。";
    }

    public static VoiceMatchConfig buildVideoConfig() {
        VoiceMatchConfig voiceMatchConfig = new VoiceMatchConfig();
        voiceMatchConfig.rule = "1、视频匹配全天开放，建议20点到22点使用，配对成功率更高哦~ \n2、如剩余次数不足，使用加速卡可获得更多匹配次数，匹配效率提升10倍，失败不消耗； \n3、聊天中请注意文明用语，遵守《用户协议》中《连信平台用户行为规范》的相关要求； \n4、如发现对方有违反社会道德，扰乱平台秩序以及其他违法违规的言论及行为，请立即举报，举报途径为：通话中-右上角-投诉入口";
        voiceMatchConfig.notice = "安全提示：视频聊天过程中请文明用语，平台将严厉打击擦边色情、诋毁诽谤等行为。";
        OpenProfile openProfile = new OpenProfile();
        voiceMatchConfig.openprofile = openProfile;
        openProfile.limitminutes = 1;
        openProfile.autoopen = "通话已满1分钟，自动公开身份，可以在消息页找到对方哦";
        SpeedupPOP speedupPOP = new SpeedupPOP();
        voiceMatchConfig.speedupPOP = speedupPOP;
        speedupPOP.enable = true;
        speedupPOP.title = "等了好一会啦，使用加速卡预估缩短m等待时间";
        speedupPOP.m = 90;
        speedupPOP.waitSeconds = 10;
        voiceMatchConfig.speedupExtra = "当前排队m人";
        return voiceMatchConfig;
    }

    public String getQueueSizeForShow(int i) {
        if (!TextUtils.isEmpty(this.speedupExtra)) {
            return this.speedupExtra.replace("m", String.valueOf(i));
        }
        return "当前排队" + i + "人";
    }

    public VideoChat getVideoChatConfig() {
        if (this.videoChat == null) {
            this.videoChat = new VideoChat();
        }
        return this.videoChat;
    }
}
