package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.picker.multi.IntentionPicker;
import defpackage.bq6;
import defpackage.e73;
import defpackage.gr2;
import defpackage.k86;
import defpackage.l50;
import defpackage.x63;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class IntentionFragment extends BaseExtInfoFragment {
    public static final String t = "IntentionFragment";
    public Activity j;
    public View k;
    public TextView l;
    public TextView m;
    public EffectiveShapeView n;
    public IntentionPicker o;
    public TextView p;
    public com.zenmen.palmchat.loginnew.a q;
    public int r;
    public ArrayList<Integer> s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("regintention_clickskip", "click", x63.a(IntentionFragment.this.r));
            IntentionFragment.this.q.m1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IntentionFragment.this.m0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<Integer> arrayList;
            if (l50.a() || (arrayList = IntentionFragment.this.s) == null || arrayList.size() <= 0) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = IntentionFragment.this.s.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", "intention");
            map.put(ActionUtils.PAYMENT_AMOUNT, jSONArray.toString());
            map.put("from", 0);
            IntentionFragment.this.Z(map);
            HashMap<String, Object> mapA = x63.a(IntentionFragment.this.r);
            mapA.put("type", jSONArray);
            zn6.j("regintention_clicknext", "click", mapA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements IntentionPicker.b {
        public d() {
        }

        @Override // com.zenmen.palmchat.widget.picker.multi.IntentionPicker.b
        public void a(ArrayList<Integer> arrayList) {
            IntentionFragment intentionFragment = IntentionFragment.this;
            intentionFragment.s = arrayList;
            intentionFragment.p.setEnabled(arrayList != null && arrayList.size() > 0);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (!isVisible()) {
            return false;
        }
        m0();
        return true;
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseExtInfoFragment
    public void Y(boolean z) {
        if (z) {
            this.q.m1();
        } else {
            W(this.j, null, getString(R.string.profile_fail));
        }
    }

    public final void k0() {
        Toolbar toolbar = (Toolbar) this.k.findViewById(R.id.toolbar);
        ((TextView) toolbar.findViewById(R.id.btn_jump)).setOnClickListener(new a());
        ((TextView) toolbar.findViewById(R.id.title)).setText(R.string.complete_profile_title);
        toolbar.setNavigationIcon(R.drawable.login_back);
        toolbar.setNavigationOnClickListener(new b());
    }

    public final void l0() {
        TextView textView = (TextView) this.k.findViewById(R.id.tv_text_title);
        this.l = textView;
        textView.setText(e73.i());
        TextView textView2 = (TextView) this.k.findViewById(R.id.tv_text_subtitle);
        this.m = textView2;
        textView2.setText(e73.h());
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) this.k.findViewById(R.id.take_photo);
        this.n = effectiveShapeView;
        effectiveShapeView.changeShapeType(1);
        TextView textView3 = (TextView) this.k.findViewById(R.id.btn_next);
        this.p = textView3;
        textView3.setOnClickListener(new c());
        this.p.setEnabled(false);
        IntentionPicker intentionPicker = (IntentionPicker) this.k.findViewById(R.id.intention_picker);
        this.o = intentionPicker;
        intentionPicker.bind(new d(), null);
    }

    public final void m0() {
        this.q.n(this.g);
        zn6.j("regintention_clickback", "click", x63.a(this.r));
    }

    public void n0(int i, String str) {
        this.r = i;
        if (!TextUtils.isEmpty(str)) {
            gr2.j().h(k86.p(str), this.n, bq6.s());
        }
        zn6.j("regintention_show", "view", x63.a(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.loginnew.fragment.BaseExtInfoFragment, com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.j = activity;
        this.q = (com.zenmen.palmchat.loginnew.a) activity;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.layout_fragment_intention, (ViewGroup) null, false);
        k0();
        l0();
        return this.k;
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseExtInfoFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i(t, "onResume");
    }
}
