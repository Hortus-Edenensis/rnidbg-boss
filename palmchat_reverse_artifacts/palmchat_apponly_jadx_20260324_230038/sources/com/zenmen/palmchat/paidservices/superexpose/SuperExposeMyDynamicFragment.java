package com.zenmen.palmchat.paidservices.superexpose;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.databinding.FragmentSuperExposeMyDynamicBinding;
import com.zenmen.palmchat.paidservices.superexpose.bean.BoostNo14Config;
import com.zenmen.palmchat.square.DynamicExposeHomeActivity;
import com.zenmen.palmchat.utils.SAppUtil;
import defpackage.az2;
import defpackage.me1;
import defpackage.nl0;
import defpackage.q05;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeMyDynamicFragment extends BaseFragment {
    public String f;
    public String g;
    public boolean h = false;
    public FragmentSuperExposeMyDynamicBinding i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            SAppUtil.I(SuperExposeMyDynamicFragment.this.getActivity(), nl0.h() ? "https://assets-pre.lianxinapp.com/wallet/#/checklist?active=2" : nl0.c().equals("release") ? "https://assets.cdn.lianxinapp.com/wallet/#/checklist?active=2" : "https://short1.lx-qa.com/mapps/wallet/#/checklist?active=2", true, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(SuperExposeMyDynamicFragment.this.getContext(), CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-41bf2881ea1f459fa99594a6594b34cb-strs8y");
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            SuperExposeMyDynamicFragment.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SuperExposeMyDynamicFragment.this.i.f13896a.startLightingAnimation(-1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("page", 2);
                put("clickButton", 2);
                put("from", Integer.valueOf(SuperExposeMyDynamicFragment.this.V()));
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            DynamicExposeHomeActivity.J1(SuperExposeMyDynamicFragment.this.getActivity(), SuperExposeMyDynamicFragment.this.V(), null);
            q05.a("boost_homepage", 2, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("page", 2);
            put("from", Integer.valueOf(SuperExposeMyDynamicFragment.this.V()));
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        if (z) {
            q05.a("boost_homepage", 1, new e());
        }
    }

    public BoostNo14Config T() {
        String strF = SAppUtil.F("boost_No14_config");
        if (!TextUtils.isEmpty(strF)) {
            try {
                return (BoostNo14Config) az2.a(strF, BoostNo14Config.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final int V() {
        return ((SuperExposeHomeActivity) getActivity()).A1();
    }

    public void W(ViewGroup viewGroup) {
        viewGroup.setPadding(0, me1.h(getActivity()), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = me1.h(getActivity()) + me1.b(getActivity(), 44);
        viewGroup.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getString("param1");
            this.g = getArguments().getString("param2");
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentSuperExposeMyDynamicBinding fragmentSuperExposeMyDynamicBindingB = FragmentSuperExposeMyDynamicBinding.b(layoutInflater, viewGroup, false);
        this.i = fragmentSuperExposeMyDynamicBindingB;
        return fragmentSuperExposeMyDynamicBindingB.getRoot();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ArrayList<String> arrayList;
        super.onViewCreated(view, bundle);
        W(this.i.i);
        this.i.h.setImageResource(R.drawable.spuper_expose_home_my_dynamic_top_txt_bg);
        this.i.e.setOnClickListener(new a());
        this.i.f.setOnClickListener(new b());
        BoostNo14Config boostNo14ConfigT = T();
        if (boostNo14ConfigT == null || (arrayList = boostNo14ConfigT.postboost_homepage_introduction) == null || arrayList.size() == 0) {
            boostNo14ConfigT = new BoostNo14Config();
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add("将动态推广至发现更显著的位置，让更多人看到");
            arrayList2.add("可同时曝光多个动态，迅速提升人气");
            arrayList2.add("推广的性别、地域由你定义");
            boostNo14ConfigT.postboost_homepage_introduction = arrayList2;
        }
        this.i.d.removeAllViews();
        for (int i = 0; i < boostNo14ConfigT.postboost_homepage_introduction.size(); i++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.super_expose_home_intro_listitem, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.content)).setText(boostNo14ConfigT.postboost_homepage_introduction.get(i));
            this.i.d.addView(viewInflate);
        }
        this.i.f13896a.post(new c());
        this.i.g.setOnClickListener(new d());
    }
}
