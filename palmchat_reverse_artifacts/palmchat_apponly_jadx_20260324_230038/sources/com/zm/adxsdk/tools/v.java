package com.zm.adxsdk.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class v extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16615a;
    public final LayoutInflater b;

    public v(Context context, ArrayList arrayList) {
        this.f16615a = arrayList;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list = this.f16615a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List list = this.f16615a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        u uVar;
        w wVar;
        if (view == null) {
            view = this.b.inflate(R$layout.wf_shell_df_item_slot_history, viewGroup, false);
            uVar = new u();
            uVar.b = (TextView) view.findViewById(R$id.wf_sdk_df_item_slot_id);
            uVar.f16614a = (TextView) view.findViewById(R$id.wf_sdk_df_item_slot_style);
            uVar.c = (TextView) view.findViewById(R$id.wf_sdk_df_item_result);
            view.setTag(uVar);
        } else {
            uVar = (u) view.getTag();
        }
        List list = this.f16615a;
        if (list != null && (wVar = (w) list.get(i)) != null) {
            uVar.b.setText(wVar.f16616a);
            uVar.f16614a.setText(wVar.b);
            uVar.c.setVisibility(8);
        }
        return view;
    }
}
