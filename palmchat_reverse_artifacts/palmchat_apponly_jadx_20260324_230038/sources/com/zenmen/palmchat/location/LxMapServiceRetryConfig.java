package com.zenmen.palmchat.location;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.amap.api.services.core.AMapException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.vs0;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class LxMapServiceRetryConfig {
    public static final String TAG = "LxMapServiceRetryConfig";
    public RetryConfig scene_1;
    public RetryConfig scene_2;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class RetryConfig {
        public String baidu_errorcode;
        public int gaode_requestfre;
        public int location_cache_interval;

        public boolean isErrorCodeMatch(int i) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(this.baidu_errorcode) || (strArrSplit = this.baidu_errorcode.split(",")) == null || strArrSplit.length <= 0) {
                return false;
            }
            return Arrays.asList(strArrSplit).contains(String.valueOf(i));
        }
    }

    private static LxMapServiceRetryConfig buildDefault() {
        LxMapServiceRetryConfig lxMapServiceRetryConfig = new LxMapServiceRetryConfig();
        RetryConfig retryConfig = new RetryConfig();
        retryConfig.location_cache_interval = 0;
        lxMapServiceRetryConfig.scene_1 = retryConfig;
        RetryConfig retryConfig2 = new RetryConfig();
        retryConfig2.location_cache_interval = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        lxMapServiceRetryConfig.scene_2 = retryConfig2;
        return lxMapServiceRetryConfig;
    }

    public static LxMapServiceRetryConfig initConfig() {
        JSONObject config = vs0.a().getConfig("Android_mapservice_retry");
        LxMapServiceRetryConfig lxMapServiceRetryConfigBuildDefault = config != null ? (LxMapServiceRetryConfig) az2.a(config.toString(), LxMapServiceRetryConfig.class) : null;
        if (lxMapServiceRetryConfigBuildDefault == null) {
            lxMapServiceRetryConfigBuildDefault = buildDefault();
        }
        LogUtil.d(TAG, "LxMapServiceRetryConfig  " + az2.c(lxMapServiceRetryConfigBuildDefault));
        return lxMapServiceRetryConfigBuildDefault;
    }

    public int getRequestInterval(boolean z) {
        RetryConfig retryConfig = z ? this.scene_1 : this.scene_2;
        if (retryConfig != null) {
            return retryConfig.gaode_requestfre;
        }
        return 0;
    }

    public boolean isErrorCodeMatch(boolean z, int i) {
        RetryConfig retryConfig = z ? this.scene_1 : this.scene_2;
        if (retryConfig != null) {
            return retryConfig.isErrorCodeMatch(i);
        }
        return false;
    }
}
