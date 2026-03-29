package com.zenmen.palmchat.chat.config;

import androidx.annotation.Keep;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatWordsizeConfig {
    private Platform platform;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Platform {

        /* JADX INFO: renamed from: android, reason: collision with root package name */
        private int f12748android = 15;
        private int ios;

        public int getAndroid() {
            return this.f12748android;
        }

        public int getIos() {
            return this.ios;
        }

        public void setAndroid(int i) {
            this.f12748android = i;
        }

        public void setIos(int i) {
            this.ios = i;
        }
    }

    public static ChatWordsizeConfig getChatWordsizeConfig() {
        ChatWordsizeConfig chatWordsizeConfig;
        try {
            JSONObject jSONObjectF = q05.f("chat_wordsize");
            b05.a("读取的配置文件是====》" + jSONObjectF.toString());
            chatWordsizeConfig = (ChatWordsizeConfig) az2.a(jSONObjectF.toString(), ChatWordsizeConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            chatWordsizeConfig = null;
        }
        if (chatWordsizeConfig == null) {
            chatWordsizeConfig = new ChatWordsizeConfig();
        }
        if (chatWordsizeConfig.platform == null) {
            chatWordsizeConfig.platform = new Platform();
        }
        int android2 = chatWordsizeConfig.platform.getAndroid();
        if (android2 < 14) {
            chatWordsizeConfig.platform.setAndroid(14);
            b05.a("字体大小配置小于14，已调整为14");
        } else if (android2 > 17) {
            chatWordsizeConfig.platform.setAndroid(17);
            b05.a("字体大小配置大于17，已调整为17");
        }
        return chatWordsizeConfig;
    }

    public Platform getPlatform() {
        return this.platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
