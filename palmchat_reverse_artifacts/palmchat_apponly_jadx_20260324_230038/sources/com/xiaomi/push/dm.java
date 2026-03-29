package com.xiaomi.push;

import android.content.Context;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dm extends dl {
    public dm(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo207a() {
        return BaseWrapper.ENTER_ID_SHORTCUT;
    }

    @Override // com.xiaomi.push.dl
    public String b() {
        return "ram:" + i.m638a() + ",rom:" + i.m643b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + i.c() + ",romOriginal:" + i.d();
    }

    @Override // com.xiaomi.push.dl
    public gh a() {
        return gh.Storage;
    }
}
