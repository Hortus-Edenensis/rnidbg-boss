package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.bc;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class PromoteInfo implements Serializable {
    private static final long serialVersionUID = 5783856735147861149L;
    private String name;
    private int type;

    public void Code(int i) {
        this.type = i;
    }

    @AllApi
    public String getName() {
        return bc.V(this.name);
    }

    @AllApi
    public int getType() {
        return this.type;
    }

    public void Code(String str) {
        this.name = str;
    }
}
