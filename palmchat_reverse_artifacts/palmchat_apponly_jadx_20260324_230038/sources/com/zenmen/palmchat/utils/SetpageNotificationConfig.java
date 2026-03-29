package com.zenmen.palmchat.utils;

import androidx.annotation.Keep;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import defpackage.az2;
import defpackage.b05;
import defpackage.q05;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SetpageNotificationConfig {
    public List<String> manufacturer;
    public String set_switch = WkInteractiveManager.TimingTypeOff;
    public MsgShowSwitch msg_show_switch = new MsgShowSwitch();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class MsgShowSwitch {
        public String chat_friend = BuildConfig.USE_CLOUD_CONFIG;
        public String chat_stranger = BuildConfig.USE_CLOUD_CONFIG;
        public String chat_muc = BuildConfig.USE_CLOUD_CONFIG;
        public String official = WkInteractiveManager.TimingTypeOff;
        public String interaction_friend = BuildConfig.USE_CLOUD_CONFIG;
        public String interaction_like = BuildConfig.USE_CLOUD_CONFIG;
        public String interaction_comment = BuildConfig.USE_CLOUD_CONFIG;
        public String subscribe = BuildConfig.USE_CLOUD_CONFIG;
        public String other_nearby = BuildConfig.USE_CLOUD_CONFIG;
        public String other_operation = BuildConfig.USE_CLOUD_CONFIG;

        public String getChatFriend() {
            return this.chat_friend;
        }

        public String getChatMuc() {
            return this.chat_muc;
        }

        public String getChatStranger() {
            return this.chat_stranger;
        }

        public String getInteractionComment() {
            return this.interaction_comment;
        }

        public String getInteractionFriend() {
            return this.interaction_friend;
        }

        public String getInteractionLike() {
            return this.interaction_like;
        }

        public String getOfficial() {
            return this.official;
        }

        public String getOtherNearby() {
            return this.other_nearby;
        }

        public String getOtherOperation() {
            return this.other_operation;
        }

        public String getSubscribe() {
            return this.subscribe;
        }

        public void setChatFriend(String str) {
            this.chat_friend = str;
        }

        public void setChatMuc(String str) {
            this.chat_muc = str;
        }

        public void setChatStranger(String str) {
            this.chat_stranger = str;
        }

        public void setInteractionComment(String str) {
            this.interaction_comment = str;
        }

        public void setInteractionFriend(String str) {
            this.interaction_friend = str;
        }

        public void setInteractionLike(String str) {
            this.interaction_like = str;
        }

        public void setOfficial(String str) {
            this.official = str;
        }

        public void setOtherNearby(String str) {
            this.other_nearby = str;
        }

        public void setOtherOperation(String str) {
            this.other_operation = str;
        }

        public void setSubscribe(String str) {
            this.subscribe = str;
        }
    }

    public static SetpageNotificationConfig getSetpageNotificationConfig() {
        SetpageNotificationConfig setpageNotificationConfig;
        try {
            final JSONObject jSONObjectF = q05.f("setpage_notification");
            b05.c(new b05.a() { // from class: n65
                @Override // b05.a
                public final Object getValue() {
                    return jSONObjectF.toString();
                }
            });
            setpageNotificationConfig = (SetpageNotificationConfig) az2.a(jSONObjectF.toString(), SetpageNotificationConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            setpageNotificationConfig = null;
        }
        return setpageNotificationConfig == null ? new SetpageNotificationConfig() : setpageNotificationConfig;
    }

    public List<String> getManufacturer() {
        return this.manufacturer;
    }

    public MsgShowSwitch getMsgShowSwitch() {
        return this.msg_show_switch;
    }

    public String getSwitch() {
        return this.set_switch;
    }

    public void setManufacturer(List<String> list) {
        this.manufacturer = list;
    }

    public void setMsgShowSwitch(MsgShowSwitch msgShowSwitch) {
        this.msg_show_switch = msgShowSwitch;
    }

    public void setSwitch(String str) {
        this.set_switch = str;
    }
}
