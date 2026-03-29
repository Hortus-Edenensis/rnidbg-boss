package com.huawei.hms.ads.data;

import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
@AllApi
public class Keyword {

    @c(Code = OapsKey.KEY_KEYWORD)
    private String keyword;
    private Integer type;

    @AllApi
    public Keyword() {
    }

    @AllApi
    public Keyword(Integer num, String str) {
        this.type = num;
        this.keyword = str;
    }

    @AllApi
    public String getKeyword() {
        return this.keyword;
    }

    @AllApi
    public Integer getType() {
        return this.type;
    }

    @AllApi
    public void setKeyword(String str) {
        this.keyword = str;
    }

    @AllApi
    public void setType(Integer num) {
        this.type = num;
    }
}
