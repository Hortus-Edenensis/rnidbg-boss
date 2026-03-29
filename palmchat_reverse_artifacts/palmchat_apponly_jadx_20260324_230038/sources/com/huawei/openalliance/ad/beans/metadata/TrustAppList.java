package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class TrustAppList {
    Map<String, List<String>> trustAppList;

    public Map<String, List<String>> Code() {
        return this.trustAppList;
    }

    public void Code(Map<String, List<String>> map) {
        this.trustAppList = map;
    }
}
