package com.huawei.hms.ads.instreamad;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.aa;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class InstreamAdLoader {
    private z Code;

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public static class Builder {
        private z Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new aa(context, str);
        }

        @GlobalApi
        public InstreamAdLoader build() {
            return new InstreamAdLoader(this);
        }

        @GlobalApi
        public Builder setInstreamAdLoadListener(InstreamAdLoadListener instreamAdLoadListener) {
            this.Code.Code(instreamAdLoadListener);
            return this;
        }

        @GlobalApi
        public Builder setMaxCount(int i) {
            this.Code.V(i);
            return this;
        }

        @GlobalApi
        public Builder setTotalDuration(int i) {
            this.Code.Code(i);
            return this;
        }
    }

    private InstreamAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    @GlobalApi
    public boolean isLoading() {
        return this.Code.Code();
    }

    @GlobalApi
    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
