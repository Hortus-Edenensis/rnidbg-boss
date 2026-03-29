package com.zenmen.palmchat.paidservices.superexpose;

import android.R;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.databinding.FragmentSuperExposeMyselfBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.paidservices.superexpose.bean.BoostNo14Config;
import com.zenmen.palmchat.paidservices.superexpose.bean.LbsSquareSuperShowHistoryNumBean;
import com.zenmen.palmchat.utils.SAppUtil;
import defpackage.ap3;
import defpackage.az2;
import defpackage.go2;
import defpackage.me1;
import defpackage.nl0;
import defpackage.q05;
import defpackage.sw4;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeMyselfFragment extends BaseFragment {
    public String f;
    public String g;
    public int h = 0;
    public boolean i = false;
    public boolean j = false;
    public FragmentSuperExposeMyselfBinding k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            SAppUtil.I(SuperExposeMyselfFragment.this.getActivity(), nl0.h() ? "https://assets-pre.lianxinapp.com/wallet/#/checklist?active=2" : nl0.c().equals("release") ? "https://assets.cdn.lianxinapp.com/wallet/#/checklist?active=2" : "https://short1.lx-qa.com/mapps/wallet/#/checklist?active=2", true, false);
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
            ap3.a().B(SuperExposeMyselfFragment.this.getActivity(), nl0.q + "/popup/#/boost/illustrate");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SuperExposeMyselfFragment.this.k.f13897a.startLightingAnimation(-1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("page", 1);
                put("clickButton", 1);
                put("from", Integer.valueOf(SuperExposeMyselfFragment.this.Y()));
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("boost_homepage", 2, new a());
            com.zenmen.palmchat.paidservices.superexpose.a.b().g(SuperExposeMyselfFragment.this.getActivity(), 601, SuperExposeMyselfFragment.this.Y(), false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f14795a;

        public e(View.OnClickListener onClickListener) {
            this.f14795a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f14795a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2<LXBaseNetBean<LbsSquareSuperShowHistoryNumBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14796a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public f(String str, HashMap map, boolean z) {
            this.f14796a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f14796a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<LbsSquareSuperShowHistoryNumBean> lXBaseNetBean, Exception exc) {
            LbsSquareSuperShowHistoryNumBean lbsSquareSuperShowHistoryNumBean;
            if (q05.o(SuperExposeMyselfFragment.this.getActivity())) {
                return;
            }
            SuperExposeMyselfFragment.this.h = 0;
            if (z && lXBaseNetBean.isSuccess() && (lbsSquareSuperShowHistoryNumBean = lXBaseNetBean.data) != null) {
                SuperExposeMyselfFragment.this.h = lbsSquareSuperShowHistoryNumBean.count;
            }
            SuperExposeMyselfFragment superExposeMyselfFragment = SuperExposeMyselfFragment.this;
            if (superExposeMyselfFragment.h == 0) {
                BoostNo14Config boostNo14ConfigW = superExposeMyselfFragment.W();
                SuperExposeMyselfFragment.this.k.c.setText((boostNo14ConfigW == null || TextUtils.isEmpty(boostNo14ConfigW.boost_homepage_buttonContent)) ? "人气之王非你莫属" : boostNo14ConfigW.boost_homepage_buttonContent);
                return;
            }
            SuperExposeMyselfFragment.c0(superExposeMyselfFragment.k.c, new SpannableString(String.format("已有%s人获得了", SuperExposeMyselfFragment.T(SuperExposeMyselfFragment.this.h + ""))), Color.parseColor("#14CD64"), SuperExposeMyselfFragment.T(SuperExposeMyselfFragment.this.h + ""), null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("page", 1);
            put("from", Integer.valueOf(SuperExposeMyselfFragment.this.Y()));
        }
    }

    public static String T(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int length = sb.length() - 3; length > 0; length -= 3) {
            sb.insert(length, ",");
        }
        return sb.toString();
    }

    public static void c0(TextView textView, SpannableString spannableString, int i, String str, View.OnClickListener onClickListener) {
        String string = spannableString.toString();
        spannableString.setSpan(new ForegroundColorSpan(i), string.indexOf(str), string.indexOf(str) + str.length(), 34);
        spannableString.setSpan(new e(onClickListener), string.indexOf(str), string.indexOf(str) + str.length(), 34);
        spannableString.setSpan(new RelativeSizeSpan(1.2857143f), string.indexOf(str), string.indexOf(str) + str.length(), 33);
        textView.setText(spannableString);
        textView.setHighlightColor(ContextCompat.getColor(textView.getContext(), R.color.transparent));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        if (z) {
            q05.a("boost_homepage", 1, new g());
        }
    }

    public final void V() {
        zw4.e(new f(q05.c() + "/lbs.square.super.show.history.num", new HashMap(), false));
    }

    public BoostNo14Config W() {
        String strF = SAppUtil.F("boost_No14_config");
        if (!TextUtils.isEmpty(strF)) {
            try {
                return (BoostNo14Config) az2.a(strF, BoostNo14Config.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final int Y() {
        return ((SuperExposeHomeActivity) getActivity()).A1();
    }

    public void Z(ViewGroup viewGroup) {
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
        FragmentSuperExposeMyselfBinding fragmentSuperExposeMyselfBindingB = FragmentSuperExposeMyselfBinding.b(layoutInflater, viewGroup, false);
        this.k = fragmentSuperExposeMyselfBindingB;
        return fragmentSuperExposeMyselfBindingB.getRoot();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ArrayList<String> arrayList;
        super.onViewCreated(view, bundle);
        Z(this.k.i);
        if (q05.e().getGender() == 1) {
            this.k.h.setImageResource(com.zenmen.palmchat.R.drawable.spuper_expose_home_myself_top_txt_man_bg);
        } else {
            this.k.h.setImageResource(com.zenmen.palmchat.R.drawable.spuper_expose_home_myself_top_txt_women_bg);
        }
        c0(this.k.c, new SpannableString(String.format("已有%s人获得了", T(this.h + ""))), Color.parseColor("#14CD64"), T(this.h + ""), null);
        V();
        this.k.e.setOnClickListener(new a());
        this.k.f.setOnClickListener(new b());
        BoostNo14Config boostNo14ConfigW = W();
        if (boostNo14ConfigW == null || (arrayList = boostNo14ConfigW.boost_homepage_introduction) == null || arrayList.size() == 0) {
            boostNo14ConfigW = new BoostNo14Config();
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add("1小时内获得10倍曝光");
            arrayList2.add("人均可获得20+打招呼，让更多异性主动找你聊天");
            arrayList2.add("好评如潮，近一半用户会多次购买");
            boostNo14ConfigW.boost_homepage_introduction = arrayList2;
        }
        this.k.d.removeAllViews();
        for (int i = 0; i < boostNo14ConfigW.boost_homepage_introduction.size(); i++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(com.zenmen.palmchat.R.layout.super_expose_home_intro_listitem, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(com.zenmen.palmchat.R.id.content)).setText(boostNo14ConfigW.boost_homepage_introduction.get(i));
            this.k.d.addView(viewInflate);
        }
        this.k.f13897a.post(new c());
        this.k.g.setOnClickListener(new d());
    }
}
