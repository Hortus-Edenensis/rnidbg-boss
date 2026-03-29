package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n extends com.baidu.platform.base.c {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.d.a("qt", "bus");
        this.d.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.d.a("ie", "utf-8");
        this.d.a("lrn", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
        this.d.a("version", "3");
        this.d.a("rp_format", BodyData.TYPE_JSON);
        this.d.a("rp_filter", "mobile");
        this.d.a("ic_info", "2");
        this.d.a("exptype", "depall");
        this.d.a("sn", a(transitRoutePlanOption.mFrom));
        this.d.a("en", a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.d.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.d.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.w();
    }
}
