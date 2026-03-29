package com.baidu.platform.core.busline;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zm.fda.Z200O.ZZ00Z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.baidu.platform.base.c {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.d.a(DeviceInfoUtil.UID_TAG, busLineSearchOption.mUid);
        if (!TextUtils.isEmpty(busLineSearchOption.mStartUid)) {
            this.d.a(ZZ00Z.l, busLineSearchOption.mStartUid);
        }
        if (!TextUtils.isEmpty(busLineSearchOption.mEndUid)) {
            this.d.a("euid", busLineSearchOption.mEndUid);
        }
        if (busLineSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.d.a("language", "en");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            this.d.a("ret_coordtype", "gcj02ll");
        } else {
            this.d.a("ret_coordtype", "bd09ll");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.f();
    }
}
