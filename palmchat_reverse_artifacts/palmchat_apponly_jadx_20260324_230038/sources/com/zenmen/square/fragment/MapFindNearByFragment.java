package com.zenmen.square.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.openapi.config.LxApiProxy;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.model.bean.NearByResp;
import com.zenmen.square.ui.widget.FindMapEntryView;
import defpackage.a46;
import defpackage.an1;
import defpackage.gu3;
import defpackage.l50;
import defpackage.pm5;
import defpackage.vs0;
import defpackage.zn6;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MapFindNearByFragment extends NearByFragment {
    public FindMapEntryView C;
    public View y = null;
    public TextView z = null;
    public ImageView A = null;
    public boolean B = LxApiProxy.getInstance().getConfigApi().b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            MapFindNearByFragment.this.V0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            MapFindNearByFragment.this.V0();
        }
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public boolean A0() {
        return true;
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public gu3 E0() {
        if (this.k == 0) {
            this.k = new gu3(o(), "lbs.square.nearby.pull.v9");
        }
        return (gu3) this.k;
    }

    public final void V0() {
        FindMapEntryView findMapEntryView = this.C;
        if (findMapEntryView != null) {
            findMapEntryView.checkPermissionAndJump(12, 0, 0);
            Z0();
        }
    }

    public final void W0() {
        DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
        if (driftInfo == null || !driftInfo.valid()) {
            LogUtil.d("", "mapFindX MapFindNearByFragmentT 无解锁");
            this.y.setVisibility(0);
            X0(0);
        } else {
            LogUtil.d("", "mapFindX MapFindNearByFragmentT 有解锁");
            this.y.setVisibility(8);
            X0(1);
        }
    }

    public final void X0(int i) {
        try {
            HashMap map = new HashMap();
            map.put("type", Integer.valueOf(i));
            zn6.g("pagelffriend_mapfinder_list", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public final void Z0() {
        try {
            zn6.g("pagelffriend_mapfinder_list_mapfinderentry", new JSONObject(new HashMap()));
        } catch (Exception unused) {
        }
    }

    public final void a1(String str) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            zn6.g("pagelffriend_mapfindertab", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public final void b1(View view) {
        JSONObject jSONObjectOptJSONObject;
        this.y = view.findViewById(R$id.map_find_tab_no_layout);
        TextView textView = (TextView) view.findViewById(R$id.map_find_tab_no_button);
        this.z = textView;
        textView.setOnClickListener(new a());
        ImageView imageView = (ImageView) view.findViewById(R$id.map_find_tab_no_img);
        this.A = imageView;
        imageView.setOnClickListener(new b());
        JSONObject config = vs0.a().getConfig("userrecommend_tabs_230414");
        if (config == null || (jSONObjectOptJSONObject = config.optJSONObject("mapfinder")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("intro_pic");
        if (!TextUtils.isEmpty(strOptString)) {
            a46.u(strOptString, this.A, R$drawable.map_find_tab_no_all_bg);
        }
        String strOptString2 = jSONObjectOptJSONObject.optString("button_text");
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        this.z.setText(strOptString2);
    }

    public void c1(FindMapEntryView findMapEntryView) {
        this.C = findMapEntryView;
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 113;
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            an1.c().r(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.B != LxApiProxy.getInstance().getConfigApi().b()) {
            this.B = !this.B;
            z(true);
        }
        W0();
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        b1(view);
        an1.c().p(this);
        a1("view");
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void updateDriftState(NearByResp.DriftBean driftBean) {
        W0();
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, defpackage.to2
    public void z(boolean z) {
        DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
        if (driftInfo != null && driftInfo.valid()) {
            super.z(z);
        } else {
            this.y.setVisibility(0);
            X0(0);
        }
    }
}
