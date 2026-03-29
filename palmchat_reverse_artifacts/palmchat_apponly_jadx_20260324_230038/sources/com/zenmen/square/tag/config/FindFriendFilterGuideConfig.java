package com.zenmen.square.tag.config;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class FindFriendFilterGuideConfig {
    private int frequency_days = 3;
    private String popupBgUrl = null;
    private boolean BgEnable = true;
    private String button_text = null;
    private String cancel_text = null;
    private int position = 25;

    private long frequency() {
        int i;
        int i2 = this.frequency_days;
        if (i2 <= 0) {
            i = 3;
            this.frequency_days = 3;
        } else {
            i = i2 * 24 * 60 * 60 * 1000;
        }
        return i;
    }

    public boolean frequencyEnable() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.FIND_FRIEND_TAB;
        if (System.currentTimeMillis() - sPUtil.i(scene, "key_find_friend_filter_guide_time", 0L) <= frequency()) {
            return false;
        }
        sPUtil.t(scene, "key_find_friend_filter_guide_time", Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public String getNegativeText() {
        return TextUtils.isEmpty(this.cancel_text) ? "下次再说" : this.cancel_text;
    }

    public String getPopupBgUrl() {
        return this.popupBgUrl;
    }

    public String getPositiveText() {
        return TextUtils.isEmpty(this.button_text) ? "去试试" : this.button_text;
    }

    public int getShowPosition() {
        return this.position;
    }

    public boolean popEnable() {
        return this.BgEnable;
    }
}
