package com.zm.adxsdk.tools;

import android.view.View;
import com.zm.adxsdk.tools.defective.ui.SlotDetailActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlotDetailActivity f16610a;

    public q(SlotDetailActivity slotDetailActivity) {
        this.f16610a = slotDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16610a.finish();
    }
}
