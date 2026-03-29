package com.bytedance.sdk.openadsdk.mediation.init.u.u.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import defpackage.wc7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static final SparseArray<Object> u(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        wc7 wc7VarB = wc7.b();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        wc7VarB.h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        wc7VarB.i(265001, mediationConfigUserInfoForSegment.getUserId());
        wc7VarB.i(265002, mediationConfigUserInfoForSegment.getChannel());
        wc7VarB.i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        wc7VarB.f(265004, mediationConfigUserInfoForSegment.getAge());
        wc7VarB.i(265005, mediationConfigUserInfoForSegment.getGender());
        wc7VarB.i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return wc7VarB.a().sparseArray();
    }
}
