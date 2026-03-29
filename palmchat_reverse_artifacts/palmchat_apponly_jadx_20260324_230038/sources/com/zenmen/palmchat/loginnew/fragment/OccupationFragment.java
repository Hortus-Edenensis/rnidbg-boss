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
import com.zenmen.palmchat.widget.picker.model.PickerData;
import com.zenmen.palmchat.widget.picker.wheel.OccupationWheelPicker;
import com.zenmen.palmchat.widget.picker.wheel.WheelPicker;
import defpackage.bq6;
import defpackage.e73;
import defpackage.gr2;
import defpackage.k86;
import defpackage.l50;
import defpackage.x63;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class OccupationFragment extends BaseExtInfoFragment {
    public static final String u = "OccupationFragment";
    public Activity j;
    public View k;
    public TextView l;
    public TextView m;
    public EffectiveShapeView n;
    public OccupationWheelPicker o;
    public TextView p;
    public com.zenmen.palmchat.loginnew.a q;
    public int r;
    public String s;
    public PickerData t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("regoccupation_clickskip", "click", x63.a(OccupationFragment.this.r));
            com.zenmen.palmchat.loginnew.a aVar = OccupationFragment.this.q;
            OccupationFragment occupationFragment = OccupationFragment.this;
            aVar.p0(occupationFragment.f, occupationFragment.r, OccupationFragment.this.s);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || OccupationFragment.this.t == null) {
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", "occupation");
            map.put(ActionUtils.PAYMENT_AMOUNT, Integer.valueOf(OccupationFragment.this.t.getId()));
            map.put("from", 0);
            OccupationFragment.this.Z(map);
            HashMap<String, Object> mapA = x63.a(OccupationFragment.this.r);
            mapA.put("type", Integer.valueOf(OccupationFragment.this.t.getId()));
            zn6.j("regoccupation_clicknext", "click", mapA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements WheelPicker.a {
        public c() {
        }

        @Override // com.zenmen.palmchat.widget.picker.wheel.WheelPicker.a
        public void a(WheelPicker wheelPicker, PickerData pickerData, int i) {
            OccupationFragment.this.t = pickerData;
            OccupationFragment.this.p.setEnabled(pickerData != null && pickerData.id > 0);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (!isVisible()) {
            return false;
        }
        p0();
        return true;
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseExtInfoFragment
    public void Y(boolean z) {
        if (z) {
            this.q.p0(this.f, this.r, this.s);
            return;
        }
        Activity activity = this.j;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        W(this.j, null, getString(R.string.profile_fail));
    }

    public final void m0() {
        Toolbar toolbar = (Toolbar) this.k.findViewById(R.id.toolbar);
        ((TextView) toolbar.findViewById(R.id.btn_jump)).setOnClickListener(new a());
        ((TextView) toolbar.findViewById(R.id.title)).setText(R.string.complete_profile_title);
    }

    public final void n0() {
        TextView textView = (TextView) this.k.findViewById(R.id.tv_text_title);
        this.l = textView;
        textView.setText(e73.k());
        TextView textView2 = (TextView) this.k.findViewById(R.id.tv_text_subtitle);
        this.m = textView2;
        textView2.setText(e73.j());
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) this.k.findViewById(R.id.take_photo);
        this.n = effectiveShapeView;
        effectiveShapeView.changeShapeType(1);
        TextView textView3 = (TextView) this.k.findViewById(R.id.btn_next);
        this.p = textView3;
        textView3.setOnClickListener(new b());
        this.p.setEnabled(false);
        OccupationWheelPicker occupationWheelPicker = (OccupationWheelPicker) this.k.findViewById(R.id.occupation_wheel_picker);
        this.o = occupationWheelPicker;
        occupationWheelPicker.setOnItemSelectedListener(new c());
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
        this.k = layoutInflater.inflate(R.layout.layout_fragment_occupation, (ViewGroup) null, false);
        m0();
        n0();
        return this.k;
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseExtInfoFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i(u, "onResume");
    }

    public void r0(int i, String str) {
        this.r = i;
        this.s = str;
        if (!TextUtils.isEmpty(str)) {
            gr2.j().h(k86.p(str), this.n, bq6.s());
        }
        zn6.j("regoccupation_show", "view", x63.a(i));
    }

    public final void p0() {
    }
}
