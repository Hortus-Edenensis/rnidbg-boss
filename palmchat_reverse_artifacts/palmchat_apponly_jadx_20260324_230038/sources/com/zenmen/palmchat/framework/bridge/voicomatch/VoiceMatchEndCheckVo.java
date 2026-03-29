package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchEndCheckVo {
    public int level;
    public String marquee;
    public String[] privilegeUpgradeImages;
    public List<SkuItem> skus;
    public boolean slient;
    public String[] subTitle;
    public String[] title;
    public int xp;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class H5Params {
        public int level;
        public String[] privilegeUpgradeImages;
    }

    public H5Params buildH5Params() {
        H5Params h5Params = new H5Params();
        h5Params.level = this.level;
        h5Params.privilegeUpgradeImages = this.privilegeUpgradeImages;
        return h5Params;
    }

    public String getSubTitleForShow() {
        String[] strArr = this.subTitle;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    public String getTitleForShow() {
        String[] strArr = this.title;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }
}
