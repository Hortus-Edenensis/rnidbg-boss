package com.tencent.turingfd.sdk.ams.ad;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RiskDetectReq extends Blueberry {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<Integer, String> f10737a = null;
        public boolean b = true;
        public int c = 0;
        public int d = 0;

        public RiskDetectReq build() {
            return new RiskDetectReq(this);
        }

        public Builder cache(boolean z) {
            this.b = z;
            return this;
        }

        public Builder inputParam(Map<Integer, String> map) {
            this.f10737a = map;
            return this;
        }

        public Builder packTimeoutMillis(int i) {
            this.d = i;
            return this;
        }

        public Builder reqTimeoutMillis(int i) {
            this.c = i;
            return this;
        }
    }

    public RiskDetectReq(Builder builder) {
        super(builder.f10737a, builder.b, builder.c, builder.d);
    }
}
