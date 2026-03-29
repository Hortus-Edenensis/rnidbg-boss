package com.zm.adxsdk.tools;

import android.view.View;
import com.zm.adxsdk.tools.defective.ui.SlotDetailActivity;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlotDetailActivity f16611a;

    public r(SlotDetailActivity slotDetailActivity) {
        this.f16611a = slotDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16611a.o = new StringBuilder();
        this.f16611a.a("发起请求");
        SlotDetailActivity slotDetailActivity = this.f16611a;
        if (slotDetailActivity.p) {
            slotDetailActivity.a("正在请求中，请等待...");
            return;
        }
        slotDetailActivity.p = true;
        FissionSdk.getLoadManager().loadNative(new FissionSlot.Builder().setContext(slotDetailActivity).setRequestId(UUID.randomUUID().toString()).setClickAreaType(4).setSlotType(1).setSlotId(slotDetailActivity.k).setCount(1).build(), new s(slotDetailActivity));
    }
}
