package com.wifi.ad.core.data;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/wifi/ad/core/data/BlackListFilterData;", "", "shouldFilter", "", WiseOpenHianalyticsData.UNION_COSTTIME, "", "(ZJ)V", "getCostTime", "()J", "getShouldFilter", "()Z", "component1", "component2", "copy", "equals", AdnName.OTHER, "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final /* data */ class BlackListFilterData {
    private final long costTime;
    private final boolean shouldFilter;

    public BlackListFilterData(boolean z, long j) {
        this.shouldFilter = z;
        this.costTime = j;
    }

    public static /* synthetic */ BlackListFilterData copy$default(BlackListFilterData blackListFilterData, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = blackListFilterData.shouldFilter;
        }
        if ((i & 2) != 0) {
            j = blackListFilterData.costTime;
        }
        return blackListFilterData.copy(z, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldFilter() {
        return this.shouldFilter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCostTime() {
        return this.costTime;
    }

    public final BlackListFilterData copy(boolean shouldFilter, long costTime) {
        return new BlackListFilterData(shouldFilter, costTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlackListFilterData)) {
            return false;
        }
        BlackListFilterData blackListFilterData = (BlackListFilterData) other;
        return this.shouldFilter == blackListFilterData.shouldFilter && this.costTime == blackListFilterData.costTime;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final boolean getShouldFilter() {
        return this.shouldFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.shouldFilter;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        long j = this.costTime;
        return (r0 * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BlackListFilterData(shouldFilter=" + this.shouldFilter + ", costTime=" + this.costTime + ")";
    }
}
