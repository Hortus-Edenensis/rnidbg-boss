package com.zm.adxsdk.protocol.api;

import android.content.Context;
import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfSlot implements Serializable {
    public static final String APP_OPEN_STYLE = "appOpenStyle";
    public static final String CONTENT_ID = "contentId";
    public static final String EVENT_EXTRA = "eventExtra";
    public static final String EXPRESS_REQUEST = "expressRequest";
    public static final String REGISTER_TIMESTAMP = "registerTimestamp";
    public static final String REWARD_COUNT_DOWN = "rewardCountDown";
    public static final String REWARD_ITEM = "reward_item";
    public static final String SERVER_EXT = "serverExt";
    public static final String SUPPORT_TWINS_ECPM = "supportTwinsECpm";
    public static final String TARGET_DSP_ID = "targetDspId";
    public static final String TARGET_INSTALLED_APP = "targetInstalledApp";
    public static final String TARGET_MATERIAL_TYPE = "targetMaterialType";
    private Builder mBuilder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder implements Serializable {
        private int clickAreaType;
        private transient Context context;
        private int count;
        private int expressType;
        private String mockId;
        private String requestId;
        private Map<String, Serializable> requestParams;
        private int requestType;
        public boolean showMovieStyle;
        private String slotId;
        private int slotType;
        private List<String> targetSlotId;
        private int timeout;

        public void addAllRequestParams(Map<String, Serializable> map) {
            if (map != null) {
                if (this.requestParams == null) {
                    this.requestParams = new ConcurrentHashMap();
                }
                this.requestParams.putAll(map);
            }
        }

        public Builder addRequestParam(String str, Serializable serializable) {
            if (this.requestParams == null) {
                this.requestParams = new ConcurrentHashMap();
            }
            try {
                if (!TextUtils.isEmpty(str) && serializable != null) {
                    this.requestParams.put(str, serializable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return this;
        }

        public WfSlot build() {
            return new WfSlot(this);
        }

        public Builder setClickAreaType(int i) {
            this.clickAreaType = i;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setCount(int i) {
            this.count = i;
            return this;
        }

        public Builder setExpressType(int i) {
            this.expressType = i;
            return this;
        }

        public Builder setMockId(String str) {
            this.mockId = str;
            return this;
        }

        public Builder setRequestId(String str) {
            this.requestId = str;
            return this;
        }

        public Builder setRequestType(int i) {
            this.requestType = i;
            return this;
        }

        public Builder setShowMovieStyle(boolean z) {
            this.showMovieStyle = z;
            return this;
        }

        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }

        public Builder setSlotType(int i) {
            this.slotType = i;
            return this;
        }

        public Builder setTargetSlotId(List<String> list) {
            this.targetSlotId = list;
            return this;
        }

        public Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }
    }

    public Map<String, Serializable> getAllRequestParam() {
        try {
            if (this.mBuilder.requestParams != null) {
                return this.mBuilder.requestParams;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Builder getBuilder() {
        return this.mBuilder;
    }

    public int getClickAreaType() {
        return this.mBuilder.clickAreaType;
    }

    public Context getContext() {
        return this.mBuilder.context;
    }

    public int getCount() {
        return this.mBuilder.count;
    }

    public int getExpressType() {
        return this.mBuilder.expressType;
    }

    public String getMockId() {
        return this.mBuilder.mockId;
    }

    public String getRequestId() {
        return this.mBuilder.requestId;
    }

    public Serializable getRequestParam(String str) {
        try {
            if (this.mBuilder.requestParams != null) {
                return (Serializable) this.mBuilder.requestParams.get(str);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getRequestType() {
        return this.mBuilder.requestType;
    }

    public String getSlotId() {
        return this.mBuilder.slotId;
    }

    public int getSlotType() {
        return this.mBuilder.slotType;
    }

    public List<String> getTargetSlotId() {
        return this.mBuilder.targetSlotId;
    }

    public int getTimeout() {
        return this.mBuilder.timeout;
    }

    public boolean showMovieStyle() {
        return this.mBuilder.showMovieStyle;
    }

    private WfSlot(Builder builder) {
        this.mBuilder = builder;
    }
}
