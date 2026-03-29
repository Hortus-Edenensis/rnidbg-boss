package com.zm.adxsdk.tools;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zm.adxsdk.protocol.api.WfSlot;
import com.zm.fission.fataar.R$color;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;
import com.zm.fission.fataar.R$string;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16606a;
    public final LayoutInflater b;
    public final Context c;

    public k(Context context, ArrayList arrayList) {
        this.c = context;
        this.f16606a = arrayList;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list = this.f16606a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List list = this.f16606a;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f16606a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        t tVar;
        TextView textView;
        Resources resources;
        int i2;
        if (view == null) {
            view = this.b.inflate(R$layout.wf_shell_df_item_slot_history, viewGroup, false);
            jVar = new j();
            if (view != null) {
                jVar.b = (TextView) view.findViewById(R$id.wf_sdk_df_item_slot_id);
                jVar.f16605a = (TextView) view.findViewById(R$id.wf_sdk_df_item_slot_style);
                jVar.c = (TextView) view.findViewById(R$id.wf_sdk_df_item_result);
            }
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        List list = this.f16606a;
        if (list != null && i < list.size() && (tVar = (t) this.f16606a.get(i)) != null && jVar != null) {
            WfSlot wfSlot = tVar.f16613a;
            if (wfSlot != null) {
                jVar.b.setText(wfSlot.getSlotId());
                TextView textView2 = jVar.f16605a;
                int slotType = tVar.f16613a.getSlotType();
                textView2.setText(slotType != 1 ? slotType != 2 ? slotType != 3 ? slotType != 5 ? "未知" : "reward" : MediationConstant.RIT_TYPE_INTERSTITIAL : MediationConstant.RIT_TYPE_SPLASH : TurnInfo.TYPE_NATIVE);
            }
            if (tVar.b) {
                jVar.c.setText(this.c.getResources().getString(R$string.wf_shell_df_slot_success));
                textView = jVar.c;
                resources = this.c.getResources();
                i2 = R$color.wf_shell_df_success_warn;
            } else {
                jVar.c.setText(this.c.getResources().getString(R$string.wf_shell_df_slot_fail));
                textView = jVar.c;
                resources = this.c.getResources();
                i2 = R$color.wf_shell_df_error_warn;
            }
            textView.setTextColor(resources.getColor(i2));
        }
        return view;
    }
}
