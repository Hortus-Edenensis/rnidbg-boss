package com.zenmen.palmchat.chat;

import androidx.annotation.Keep;
import defpackage.ac1;
import defpackage.az2;
import defpackage.q05;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AndroidVideoEditSwitchConfig {
    private boolean enable = false;
    private List<String> blacklist = new ArrayList();

    public static AndroidVideoEditSwitchConfig getConfig() {
        AndroidVideoEditSwitchConfig androidVideoEditSwitchConfig = null;
        try {
            JSONObject jSONObjectF = q05.f("android_video_edit_switch");
            if (jSONObjectF != null) {
                androidVideoEditSwitchConfig = (AndroidVideoEditSwitchConfig) az2.a(jSONObjectF.toString(), AndroidVideoEditSwitchConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (androidVideoEditSwitchConfig == null) {
            androidVideoEditSwitchConfig = new AndroidVideoEditSwitchConfig();
        }
        if (androidVideoEditSwitchConfig.blacklist == null) {
            androidVideoEditSwitchConfig.blacklist = new ArrayList();
        }
        return androidVideoEditSwitchConfig;
    }

    public static boolean shouldUseNewSDK() {
        AndroidVideoEditSwitchConfig config = getConfig();
        if (!config.isEnable()) {
            return false;
        }
        String str = ac1.b;
        if (str == null || config.getBlacklist() == null) {
            return true;
        }
        Iterator<String> it = config.getBlacklist().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return false;
            }
        }
        return true;
    }

    public List<String> getBlacklist() {
        return this.blacklist;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setBlacklist(List<String> list) {
        this.blacklist = list;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }
}
