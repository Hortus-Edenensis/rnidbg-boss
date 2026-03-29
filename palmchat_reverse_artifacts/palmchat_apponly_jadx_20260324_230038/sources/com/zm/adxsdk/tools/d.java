package com.zm.adxsdk.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zm.adxsdk.protocol.api.WfSlot;
import com.zm.adxsdk.tools.defective.ui.SlotDetailActivity;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f16600a;

    public final void a(ArrayList arrayList, AdapterView adapterView, View view, int i, long j) {
        t tVar;
        WfSlot wfSlot;
        if (i >= arrayList.size() || (tVar = (t) arrayList.get(i)) == null || (wfSlot = tVar.f16613a) == null) {
            return;
        }
        String slotId = wfSlot.getSlotId();
        int slotType = tVar.f16613a.getSlotType();
        a(slotId, slotType != 1 ? slotType != 2 ? slotType != 3 ? slotType != 5 ? "未知" : "reward" : MediationConstant.RIT_TYPE_INTERSTITIAL : MediationConstant.RIT_TYPE_SPLASH : TurnInfo.TYPE_NATIVE, String.valueOf(tVar.b), tVar.c);
    }

    public final /* synthetic */ void b(ArrayList arrayList, AdapterView adapterView, View view, int i, long j) {
        a(((w) arrayList.get(i)).f16616a, ((w) arrayList.get(i)).b, "", "");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.wf_shell_df_layout_fragment_code_check, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        final ArrayList arrayList;
        super.onViewCreated(view, bundle);
        ListView listView = (ListView) view.findViewById(R$id.wf_df_history_listview);
        ListView listView2 = (ListView) view.findViewById(R$id.wf_df_test_listview);
        Button button = (Button) view.findViewById(R$id.wf_df_check_slot_id);
        this.f16600a = (EditText) view.findViewById(R$id.wf_df_slot_id_et);
        g gVarA = g.a();
        final ArrayList arrayList2 = gVarA.c == null ? null : new ArrayList(gVarA.c.values());
        g gVarA2 = g.a();
        ArrayList arrayList3 = gVarA2.i;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(new w("1_1_1", "横版图片+落地页"));
            arrayList4.add(new w("1_1_2", "横版图片+直接下载"));
            arrayList4.add(new w("1_1_3", "横版图片+DEEPLINK"));
            arrayList4.add(new w("1_1_4", "横版图片+微信小程序"));
            arrayList4.add(new w("1_1_5", "横版图片+应用市场"));
            arrayList4.add(new w("1_2_1", "竖版图片+落地页"));
            arrayList4.add(new w("1_2_2", "竖版图片+直接下载"));
            arrayList4.add(new w("1_2_3", "竖版图片+DEEPLINK"));
            arrayList4.add(new w("1_2_4", "竖版图片+微信小程序"));
            arrayList4.add(new w("1_2_5", "竖版图片+应用市场"));
            arrayList4.add(new w("1_3_1", "横版视频+落地页"));
            arrayList4.add(new w("1_3_2", "横版视频+直接下载"));
            arrayList4.add(new w("1_3_3", "横版视频+DEEPLINK"));
            arrayList4.add(new w("1_3_4", "横版视频+微信小程序"));
            arrayList4.add(new w("1_3_5", "横版视频+应用市场"));
            arrayList4.add(new w("1_4_1", "竖版视频+落地页"));
            arrayList4.add(new w("1_4_2", "竖版视频+直接下载"));
            arrayList4.add(new w("1_4_3", "竖版视频+DEEPLINK"));
            arrayList4.add(new w("1_4_4", "竖版视频+微信小程序"));
            arrayList4.add(new w("1_4_5", "竖版视频+应用市场"));
            gVarA2.i = arrayList4;
            arrayList = arrayList4;
        } else {
            arrayList = gVarA2.i;
        }
        k kVar = new k(getContext(), arrayList2);
        v vVar = new v(getContext(), arrayList);
        listView.setAdapter((ListAdapter) kVar);
        listView2.setAdapter((ListAdapter) vVar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: f77
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                this.f17475a.a(arrayList2, adapterView, view2, i, j);
            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: g77
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                this.f17676a.b(arrayList, adapterView, view2, i, j);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: h77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f17892a.a(view2);
            }
        });
    }

    public final /* synthetic */ void a(View view) {
        a(this.f16600a.getText().toString(), "", "", "");
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (getContext() != null) {
            Intent intent = new Intent();
            intent.putExtra("slot_id", str);
            intent.putExtra("slot_type", str2);
            intent.putExtra("request_result", str3);
            intent.putExtra("error_msg", str4);
            intent.setClass(getContext(), SlotDetailActivity.class);
            getContext().startActivity(intent);
        }
    }
}
