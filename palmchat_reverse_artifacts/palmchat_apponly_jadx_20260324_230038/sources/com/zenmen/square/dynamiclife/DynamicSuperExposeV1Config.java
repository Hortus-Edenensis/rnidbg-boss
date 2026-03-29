package com.zenmen.square.dynamiclife;

import android.text.TextUtils;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class DynamicSuperExposeV1Config {
    public boolean boost_label = true;
    public DynamicSuperExposeV1newpost_popFrequency newpost_popFrequency;
    public String pageprofil_new_url;
    public String pageprofil_old_postlist_url;
    public String pageprofil_old_url;
    private String post_interact_button_text;
    private String post_interact_exceed_text;
    public String postboost_postSucceed_pop_button_text;
    public String[] postboost_postSucceed_pop_content;
    public String rccLevel;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class DynamicSuperExposeV1newpost_popFrequency {
        public int count;
        public int time;
    }

    public String getPost_interact_button_text() {
        if (TextUtils.isEmpty(this.post_interact_button_text)) {
            this.post_interact_button_text = "立即曝光";
        }
        return this.post_interact_button_text;
    }

    public String getPost_interact_exceed_text() {
        if (TextUtils.isEmpty(this.post_interact_exceed_text)) {
            this.post_interact_exceed_text = "超过了s的用户，上推荐提升曝光";
        }
        return this.post_interact_exceed_text;
    }

    public String getPostboost_postSucceed_pop_button_text() {
        if (TextUtils.isEmpty(this.postboost_postSucceed_pop_button_text)) {
            this.postboost_postSucceed_pop_button_text = "我要上推荐";
        }
        return this.postboost_postSucceed_pop_button_text;
    }

    public String[] getPostboost_postSucceed_pop_content() {
        String[] strArr = this.postboost_postSucceed_pop_content;
        if (strArr == null || strArr.length == 0) {
            this.postboost_postSucceed_pop_content = new String[]{"你的动态将出现在列表显著位置，让更多人看到", "可同时曝光多个动态，迅速提升人气"};
        }
        return this.postboost_postSucceed_pop_content;
    }
}
