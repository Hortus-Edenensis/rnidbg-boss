package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public interface d extends Serializable {
    void Code(Context context);

    void Code(RewardVerifyConfig rewardVerifyConfig);

    void Code(Map<String, Object> map, ReportUrlListener reportUrlListener);

    AppInfo E();

    boolean H();

    int J();

    RewardVerifyConfig P();

    String R();

    String T();

    void V(Map<String, Object> map, ReportUrlListener reportUrlListener);

    String W();

    String X();

    int Y();

    boolean aa();

    String ac();

    boolean ad();

    PromoteInfo ag();

    BiddingInfo ah();

    String c();

    String d();

    String e();

    int f();

    String g();

    String h();

    long i();

    long j();

    boolean k();

    String l();

    String m();

    String n();

    AdContentData q();

    String r();

    long x();

    int y();
}
