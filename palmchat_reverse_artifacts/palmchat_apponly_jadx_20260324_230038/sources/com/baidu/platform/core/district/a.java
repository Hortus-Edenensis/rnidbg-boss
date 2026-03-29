package com.baidu.platform.core.district;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.baidu.platform.base.c {
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        if (districtSearchOption == null) {
            return;
        }
        this.d.a("qt", "con");
        this.d.a("rp_format", BodyData.TYPE_JSON);
        this.d.a("rp_filter", "mobile");
        this.d.a("area_res", ex.Code);
        this.d.a("addr_identify", "1");
        this.d.a("ie", "utf-8");
        this.d.a("pn", "0");
        this.d.a("rn", "10");
        this.d.a("c", districtSearchOption.mCityName);
        String str = districtSearchOption.mDistrictName;
        if (str == null || str.equals("")) {
            this.d.a("wd", districtSearchOption.mCityName);
        } else {
            this.d.a("wd", districtSearchOption.mDistrictName);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.j();
    }
}
