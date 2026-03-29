package com.zenmen.palmchat.paidservices.voicematch.vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class VoiceMatchResult {
    public int level;
    public String marquee;
    public String matchid;
    public List<SkuItem> skus;
    public String[] subTitle;
    public String[] title;
    public int xp;

    public static VoiceMatchInfo convert2VoiceMatchInfo(VoiceMatchResult voiceMatchResult, int i) {
        VoiceMatchInfo voiceMatchInfo = new VoiceMatchInfo();
        voiceMatchInfo.errorCode = i;
        if (voiceMatchResult != null) {
            voiceMatchInfo.title = voiceMatchResult.title;
            voiceMatchInfo.subTitle = voiceMatchResult.subTitle;
            voiceMatchInfo.matchid = voiceMatchResult.matchid;
            voiceMatchInfo.skus = voiceMatchResult.skus;
        }
        return voiceMatchInfo;
    }
}
