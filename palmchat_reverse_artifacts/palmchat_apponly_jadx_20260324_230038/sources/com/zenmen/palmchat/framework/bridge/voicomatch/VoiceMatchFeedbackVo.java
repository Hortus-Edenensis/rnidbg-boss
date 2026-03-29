package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchFeedbackVo {
    public List<FeedbackItem> feedbackTexts;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class FeedbackItem {
        public int id;
        public String name;
    }
}
