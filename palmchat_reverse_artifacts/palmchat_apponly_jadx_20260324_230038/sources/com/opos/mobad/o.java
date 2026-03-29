package com.opos.mobad;

import android.content.Context;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.p.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o implements com.opos.mobad.cmn.a.b {
    @Override // com.opos.mobad.cmn.a.b
    public boolean a(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return AdActivity.b(context, complianceInfo, abstractBinderC0760a);
    }

    @Override // com.opos.mobad.cmn.a.b
    public boolean b(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return AdActivity.a(context, complianceInfo, abstractBinderC0760a);
    }

    @Override // com.opos.mobad.cmn.a.b
    public boolean c(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return AdActivity.c(context, complianceInfo, abstractBinderC0760a);
    }
}
