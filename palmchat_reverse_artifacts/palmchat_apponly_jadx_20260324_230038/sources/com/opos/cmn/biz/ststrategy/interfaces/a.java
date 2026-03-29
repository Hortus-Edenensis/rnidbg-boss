package com.opos.cmn.biz.ststrategy.interfaces;

import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a {
    STConfigEntity a();

    void a(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener);

    void a(String str, UpdateSTConfigListener updateSTConfigListener);
}
