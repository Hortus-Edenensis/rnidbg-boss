package com.zm.fissionsdk.api;

import android.content.Context;
import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FissionSlot {
    public static final String CONTENT_ID = "contentId";
    public static final String REWARD_COUNT_DOWN = "rewardCountDown";
    public static final String REWARD_ITEM = "reward_item";
    private Builder mBuilder;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder implements Serializable {
        private int clickAreaType = 4;
        private transient Context context;
        private int count;
        private int expressType;
        private String requestId;
        private Map<String, Serializable> requestParams;
        private String slotId;
        private int slotType;

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

        public FissionSlot build() {
            return new FissionSlot(this);
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

        public Builder setRequestId(String str) {
            this.requestId = str;
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
    }

    public Map<String, Serializable> getAllRequestParams() {
        return this.mBuilder.requestParams;
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

    public String getRequestId() {
        return this.mBuilder.requestId;
    }

    public String getSlotId() {
        return this.mBuilder.slotId;
    }

    public int getSlotType() {
        return this.mBuilder.slotType;
    }

    private FissionSlot(Builder builder) {
        this.mBuilder = builder;
    }
}
