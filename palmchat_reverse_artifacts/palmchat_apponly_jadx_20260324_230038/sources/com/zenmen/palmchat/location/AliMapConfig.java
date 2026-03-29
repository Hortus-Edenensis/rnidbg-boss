package com.zenmen.palmchat.location;

import androidx.annotation.Keep;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.vs0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AliMapConfig {
    public static final String TAG = "AliMapConfig";
    public boolean nearbyLocationShow = true;
    public boolean unlockLocation = true;
    public boolean surroundingSearch = true;
    public boolean tripSurroundingSearch = true;
    public boolean pageSendLocation = true;
    public boolean pageMultipleEditLocation = true;
    public boolean pageMultipleEditSurrounding = true;

    public static AliMapConfig initSearchConfig() {
        AliMapConfig aliMapConfig = new AliMapConfig();
        JSONObject config = vs0.a().getConfig("search_switch");
        if (config != null) {
            aliMapConfig.nearbyLocationShow = config.optBoolean("pagemapfinder_nearbylocationshow_android", true);
            aliMapConfig.unlockLocation = config.optBoolean("pagemapfinder_unlocklocation_android", true);
            aliMapConfig.surroundingSearch = config.optBoolean("pagemapfinder_surroundingsearch_android", true);
            aliMapConfig.tripSurroundingSearch = config.optBoolean("pageitinerary_surroundingsearch_android", true);
            aliMapConfig.pageSendLocation = config.optBoolean("pagesendlocation_surroundingsearch_android", true);
            aliMapConfig.pageMultipleEditLocation = config.optBoolean("pagemultipleedit_locationsearch_android", true);
            aliMapConfig.pageMultipleEditSurrounding = config.optBoolean("pagemultipleedit_surroundingsearch_android", true);
        }
        LogUtil.d(TAG, "initSearchConfig  " + az2.c(aliMapConfig));
        return aliMapConfig;
    }
}
