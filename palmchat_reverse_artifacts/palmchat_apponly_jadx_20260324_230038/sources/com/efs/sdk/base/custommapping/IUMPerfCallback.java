package com.efs.sdk.base.custommapping;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface IUMPerfCallback {

    /* JADX INFO: compiled from: SearchBox */
    public enum PerfType {
        PERF_TYPE_START(1),
        PERF_TYPE_POWER(2);

        int mType;

        PerfType(int i) {
            this.mType = i;
        }

        public final int getType() {
            return this.mType;
        }
    }

    void onCallback(PerfType perfType);
}
