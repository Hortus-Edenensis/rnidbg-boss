package com.zenmen.palmchat.settings.portrait;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ProfileEditConfig {
    public static final int ERROR_CODE_FORBIDDEN = 1138;
    public static final int ERROR_CODE_NO_COUNT = 1137;
    public List<LimitItem> limit;

    private LimitItem getPortraitLimit() {
        List<LimitItem> list = this.limit;
        if (list == null) {
            return null;
        }
        for (LimitItem limitItem : list) {
            if ("avatar".equals(limitItem.type) && limitItem.groupStatus) {
                return limitItem;
            }
        }
        return null;
    }

    public boolean canModifyPortrait() {
        LimitItem portraitLimit = getPortraitLimit();
        return portraitLimit == null || portraitLimit.num >= 1;
    }

    public String getPortraitTips() {
        LimitItem portraitLimit = getPortraitLimit();
        if (portraitLimit != null) {
            return portraitLimit.tips;
        }
        return null;
    }

    public boolean needShowLastChance() {
        LimitItem portraitLimit = getPortraitLimit();
        return portraitLimit != null && portraitLimit.num == 1;
    }
}
