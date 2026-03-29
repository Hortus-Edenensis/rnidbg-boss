package com.bytedance.sdk.component.adexpress.dynamic.fx;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.dc;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static final Map<String, Integer> u;
    private String b;
    private String fx;
    private iz iz;
    private String nr;
    private iz pn;
    private String x;

    static {
        HashMap map = new HashMap();
        u = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put(MediaFormat.KEY_SUBTITLE, 0);
        map.put(az.at, 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put("close", 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put(dc.F, 27);
        map.put("timedown", 13);
        map.put("icon", 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
        map.put("image-flip-slide", 29);
    }

    public void b(String str) {
        this.x = str;
    }

    public String fx() {
        return this.b;
    }

    public String getType() {
        return this.nr;
    }

    public int iz() {
        return this.pn.jw();
    }

    public String nr() {
        return this.fx;
    }

    public iz pn() {
        return this.pn;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.nr + "', data='" + this.fx + "', value=" + this.pn + ", themeValue=" + this.iz + ", dataExtraInfo='" + this.x + "'}";
    }

    public int u() {
        if (TextUtils.isEmpty(this.nr)) {
            return 0;
        }
        if (this.nr.equals("logo")) {
            String str = this.nr + this.fx;
            this.nr = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.nr.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = u;
        if (map.get(this.nr) != null) {
            return map.get(this.nr).intValue();
        }
        return -1;
    }

    public iz x() {
        return this.iz;
    }

    public String b() {
        return this.x;
    }

    public void fx(String str) {
        this.b = str;
    }

    public void nr(String str) {
        this.fx = str;
    }

    public void nr(iz izVar) {
        this.iz = izVar;
    }

    public void u(String str) {
        this.nr = str;
    }

    public void u(iz izVar) {
        this.pn = izVar;
    }
}
