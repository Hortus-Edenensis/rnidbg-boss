package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class Video {
    private int maxDuration;

    public Video() {
    }

    @b
    public Video(int i) {
        this.maxDuration = i;
    }

    public int Code() {
        return this.maxDuration;
    }

    public void Code(int i) {
        this.maxDuration = i;
    }
}
