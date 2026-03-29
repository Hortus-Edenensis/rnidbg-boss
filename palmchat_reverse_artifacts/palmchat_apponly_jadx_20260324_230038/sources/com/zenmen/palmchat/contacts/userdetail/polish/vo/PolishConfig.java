package com.zenmen.palmchat.contacts.userdetail.polish.vo;

import androidx.annotation.Keep;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PolishConfig {
    public String friendRecommend;
    public int redDotMinutes;
    public String rule;
    public List<String> texts;
    public a successPop = new a();
    public String defaultEntranceList = "擦亮主页";

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13732a = "曝光次数+n，明天继续擦亮，曝光+s，记得回来哦~";
        public String b = "继续加曝光";
    }

    public static PolishConfig buildDefaultConfig() {
        PolishConfig polishConfig = new PolishConfig();
        polishConfig.redDotMinutes = EffectConstants.ROTATION_DEGREES_180;
        ArrayList arrayList = new ArrayList();
        polishConfig.texts = arrayList;
        arrayList.add("近7天曝光不错哦~多多保持");
        polishConfig.texts.add("最近7天数据不错哦~");
        polishConfig.rule = "1.擦亮自己的个人主页，可获得额外的曝光次数；\n2.连续擦亮主页，可获得更多曝光；\n3.每次擦亮主页可获得的曝光次数以活动页面显示为准。";
        polishConfig.friendRecommend = "Ta刚刚擦亮了主页，我也去擦亮>";
        return polishConfig;
    }

    public List<String> getTextList() {
        List<String> list = this.texts;
        if (list != null && list.size() > 0) {
            return this.texts;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("近7天曝光不错哦~多多保持");
        arrayList.add("最近7天数据不错哦~");
        return arrayList;
    }
}
