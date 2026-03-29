package com.heytap.msp.mobad.api;

import com.heytap.msp.mobad.api.impl.params.DownloadEngine;
import com.heytap.msp.mobad.api.impl.params.HttpExecutor;
import com.heytap.msp.mobad.api.impl.params.HttpsExecutor;
import com.heytap.msp.mobad.api.impl.params.Log;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class InitParams {
    public static final int ADVANCE_MODE_0 = 0;
    public static final int ADVANCE_MODE_1 = 1;
    public static final int ADVANCE_MODE_2 = 2;
    public static final InitParams NONE = new Builder().setDebug(false).build();
    private static final String TAG = "InitParams";
    public final int advanceMode;
    public final boolean appOUIDStatus;
    public final ClassifyByAgeProvider classifyByAgeProvider;
    public final boolean debug;
    public final MobCustomController mobCustomController;
    public final boolean touristMode;

    public InitParams(Builder builder) {
        this.debug = builder.debug;
        this.appOUIDStatus = builder.appOUIDStatus;
        this.touristMode = builder.touristMode;
        this.classifyByAgeProvider = builder.classifyByAgeProvider;
        this.advanceMode = builder.advanceMode;
        this.mobCustomController = builder.mobCustomController;
    }

    public String toString() {
        return "InitParams{}";
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private ExecutorService bizExecutorService;
        private ClassifyByAgeProvider classifyByAgeProvider;
        private DownloadEngine downloadEngine;
        private HttpExecutor httpExecutor;
        private HttpsExecutor httpsExecutor;
        private ExecutorService ioExecutorService;
        private Log log;
        private MobCustomController mobCustomController;
        private ExecutorService netExecutorService;
        private boolean debug = false;
        private boolean useOtherModels = false;
        private boolean appOUIDStatus = true;
        private boolean touristMode = false;
        private int advanceMode = 0;
        private int mMinorsMode = 0;
        private int mMinorsModeEnable = 0;
        private int mMinorsModeAgeRange = 0;

        public InitParams build() {
            return new InitParams(this);
        }

        public Builder setAdvanceModel(int i) {
            this.advanceMode = i;
            return this;
        }

        public Builder setAppOUIDStatus(boolean z) {
            this.appOUIDStatus = z;
            return this;
        }

        public Builder setClassifyByAgeProvider(ClassifyByAgeProvider classifyByAgeProvider) {
            this.classifyByAgeProvider = classifyByAgeProvider;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setMobCustomController(MobCustomController mobCustomController) {
            this.mobCustomController = mobCustomController;
            return this;
        }

        public Builder setTouristMode(boolean z) {
            this.touristMode = z;
            return this;
        }

        @Deprecated
        public Builder setBizExecutorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder setDownloadEngine(DownloadEngine downloadEngine) {
            return this;
        }

        @Deprecated
        public Builder setHttpExecutor(HttpExecutor httpExecutor) {
            return this;
        }

        @Deprecated
        public Builder setHttpsExecutor(HttpsExecutor httpsExecutor) {
            return this;
        }

        @Deprecated
        public Builder setIoExecutorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder setLog(Log log) {
            return this;
        }

        @Deprecated
        public Builder setNetExecutorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder setUseOtherModels(boolean z) {
            return this;
        }
    }
}
