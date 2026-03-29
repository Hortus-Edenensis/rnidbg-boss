package com.zenmen.palmchat.chat.aigreeting.vo;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AiGreetingChatCardInfo {
    public boolean isGenFromMsg;
    public long lastMsgTime;
    public State state = State.SUCCESS;
    public List<String> textList;

    /* JADX INFO: compiled from: SearchBox */
    public enum State {
        LOADING,
        ERROR,
        SUCCESS
    }
}
