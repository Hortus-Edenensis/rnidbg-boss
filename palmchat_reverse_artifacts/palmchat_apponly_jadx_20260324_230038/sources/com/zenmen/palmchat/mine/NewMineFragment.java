package com.zenmen.palmchat.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.circle.ui.CircleLaunchCreateCircleActivity;
import com.zenmen.palmchat.contacts.AddContactActivity;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.invite.ContactInviteFriendsActivity;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.settings.AppSettingsActivity;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;
import com.zenmen.palmchat.utils.CustomScrollView;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.b05;
import defpackage.bo0;
import defpackage.ch;
import defpackage.eg6;
import defpackage.fg6;
import defpackage.gk4;
import defpackage.ip3;
import defpackage.ir5;
import defpackage.is0;
import defpackage.k86;
import defpackage.kt3;
import defpackage.l50;
import defpackage.lt3;
import defpackage.nb3;
import defpackage.nx3;
import defpackage.oc0;
import defpackage.op3;
import defpackage.qm5;
import defpackage.rk4;
import defpackage.tj2;
import defpackage.uk5;
import defpackage.zn6;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewMineFragment extends DynamicConfigFragment implements View.OnClickListener {
    public static final String r = "com.zenmen.palmchat.mine.NewMineFragment";
    public RelativeLayout i;
    public ImageView j;
    public View k;
    public TextView l;
    public View m;
    public eg6 n;
    public boolean o = false;
    public long p = 0;
    public final is0.f q = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestedScrollView.OnScrollChangeListener {
        public a() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Log.i("DynamicConfigFragment", "onScrollChange: " + i + "  " + i2 + " " + i3 + "  " + i4);
            if (i2 == 0) {
                NewMineFragment.this.m.setVisibility(0);
            } else {
                NewMineFragment.this.m.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CustomScrollView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomScrollView f14707a;

        public b(CustomScrollView customScrollView) {
            this.f14707a = customScrollView;
        }

        @Override // com.zenmen.palmchat.utils.CustomScrollView.e
        public void a() {
            LogUtil.i("DynamicConfigFragment", "ScrollListener: onScrollToBottom - ScrollY: " + this.f14707a.getScrollY());
            ch.s().V(3);
        }

        @Override // com.zenmen.palmchat.utils.CustomScrollView.e
        public void b() {
            LogUtil.i("DynamicConfigFragment", "ScrollListener: onScrollToTop - ScrollY: " + this.f14707a.getScrollY());
            ch.s().V(2);
        }

        @Override // com.zenmen.palmchat.utils.CustomScrollView.e
        public void c() {
            LogUtil.i("DynamicConfigFragment", "ScrollListener: onTopPull - ScrollY: " + this.f14707a.getScrollY());
            ch.s().V(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements is0.f {
        public c() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                if (l50.a()) {
                    return;
                }
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) AddContactActivity.class);
                intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_menu");
                NewMineFragment.this.startActivity(intent);
                ip3.c("pagemy_postopnav_btnapply");
                return;
            }
            if (i == 1) {
                if (l50.a()) {
                    return;
                }
                Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) ContactInviteFriendsActivity.class);
                intent2.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_discover");
                NewMineFragment.this.startActivity(intent2);
                nx3.e(k86.a("key_show_invite_friends"));
                ip3.c("pagemy_postopnav_btninvite");
                return;
            }
            if (i == 2) {
                if (oc0.c()) {
                    Intent intent3 = new Intent(AppContext.getContext(), (Class<?>) CircleLaunchCreateCircleActivity.class);
                    intent3.putExtra("extra_from", 2);
                    NewMineFragment.this.startActivity(intent3);
                    ip3.c("pagemy_postopnav_btngroup");
                    return;
                }
                oc0.g("lx_group_create2_click");
                Intent intent4 = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
                intent4.putExtra("from_type", 4);
                NewMineFragment.this.startActivity(intent4);
                return;
            }
            if (i != 3) {
                return;
            }
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent5 = new Intent();
            intent5.setClass(NewMineFragment.this.getActivity(), CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.m());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent5.putExtras(bundle);
            NewMineFragment.this.startActivity(intent5);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f14709a;

        public d(uk5 uk5Var) {
            this.f14709a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f14709a.f21235a;
            if (i == 34 || i == 35) {
                NewMineFragment.this.r0();
            }
        }
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        if (z) {
            n0();
            r0();
            k0("pagemy_postopnav_btnwallet", "view");
            k0("pagemy_postopnav_btnsetup", "view");
            k0("pagemy_tabbutton", "click");
            zn6.c("pagemy", "view");
        }
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment
    public int W() {
        if (!this.o) {
            lt3 lt3Var = new lt3(getActivity());
            if (lt3Var.n() > 0 || lt3Var.f(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE)) {
                return -1;
            }
        }
        return super.W();
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment
    public int c0() {
        return R.layout.layout_fragment_mine_new;
    }

    public final void k0(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("report_type", str2);
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_USER_ACTION, null, str, null, null, jSONObject.toString());
            zn6.d(str, null, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m0(View view) {
        this.m = view.findViewById(R.id.decor_guide_bubble_layout);
        TextView textView = (TextView) view.findViewById(R.id.decor_guide_bubble);
        this.l = textView;
        textView.setOnClickListener(this);
        this.i = (RelativeLayout) view.findViewById(R.id.mine_bar_myfirends_container);
        this.j = (ImageView) view.findViewById(R.id.mine_bar_myfirends);
        this.k = view.findViewById(R.id.mine_bar_myfirends_dot);
        this.i.setOnClickListener(this);
        view.setPadding(0, a46.n(getContext()), 0, 0);
        view.findViewById(R.id.mine_bar_wallet).setOnClickListener(this);
        boolean zA = op3.a();
        this.o = zA;
        if (zA) {
            view.findViewById(R.id.mine_bar_wallet).setVisibility(8);
        }
        view.findViewById(R.id.mine_bar_setting).setOnClickListener(this);
        r0();
        CustomScrollView customScrollView = (CustomScrollView) view.findViewById(R.id.rootScrollView);
        customScrollView.setOnScrollChangeListener(new a());
        customScrollView.setOnScrollListener(new b(customScrollView));
        this.n = new eg6(getActivity(), view);
    }

    public final void n0() {
        if (Math.abs(this.p - ir5.b()) >= 3000) {
            fg6.k(getContext(), null);
            this.p = ir5.b();
        }
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 9211 || getActivity() == null) {
            return;
        }
        r0();
        UserProfileGuide.k(getActivity(), 15);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.decor_guide_bubble /* 2131363266 */:
                nx3.e("key_amulet_mytab_bubble");
                rk4.d(getActivity(), 1, null, 1, -1, -1);
                break;
            case R.id.mine_bar_myfirends_container /* 2131365932 */:
                if (!l50.a()) {
                    Intent intent = new Intent(getActivity(), (Class<?>) ContactActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("source_tab_tag", MainTabsActivity.y2());
                    intent.putExtras(bundle);
                    getActivity().startActivityForResult(intent, 9211);
                    new lt3(getActivity()).q(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE);
                    HashMap map = new HashMap();
                    map.put(EventParams.KEY_CT_SDK_POSITION, "1");
                    ip3.b("pagemy_tool_friend", "click", map);
                    zn6.c("pagemy_friend", "click");
                }
                break;
            case R.id.mine_bar_setting /* 2131365934 */:
                Intent intent2 = new Intent(getActivity(), (Class<?>) AppSettingsActivity.class);
                LogUtil.onClickEvent(BaseWrapper.ENTER_ID_OAPS_CLOUD, null, null);
                startActivity(intent2);
                if (com.zenmen.palmchat.utils.a.E().d0()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, "");
                        LogUtil.onNotifyClickEvent("4321", null, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                k0("pagemy_postopnav_btnsetup", "click");
                break;
            case R.id.mine_bar_wallet /* 2131365935 */:
                if (!l50.a()) {
                    LogUtil.uploadInfoImmediate("qb1", null, null, null);
                    nx3.e("key_wallet_new");
                    nb3.j(getContext());
                    SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_wallet_activity_click", new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss").format(new Date()));
                    k0("pagemy_postopnav_btnwallet", "click");
                }
                break;
        }
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ch.s().r().j(this);
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m0(viewOnCreateView);
        l0();
        k0("pagemy_tabbutton", "view");
        String strP = AccountUtils.p(AppContext.getContext());
        if (!TextUtils.isEmpty(strP)) {
            b05.d("当前用户的uid======>" + strP);
        }
        return viewOnCreateView;
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        eg6 eg6Var = this.n;
        if (eg6Var != null) {
            eg6Var.c();
        }
        p0();
    }

    @Override // com.zenmen.palmchat.maintab.DynamicConfigFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        n0();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        if (getView() != null) {
            getView().post(new d(uk5Var));
        }
    }

    public final void p0() {
        if (gk4.f() || !nx3.a("key_amulet_mytab_bubble")) {
            this.l.setVisibility(8);
            return;
        }
        ContactInfoItem contactInfoItemS = bo0.r().s();
        String strB = rk4.b(contactInfoItemS != null && contactInfoItemS.hasAmulet());
        if (TextUtils.isEmpty(strB)) {
            this.l.setVisibility(8);
        } else {
            this.l.setText(strB);
            this.l.setVisibility(0);
        }
    }

    public final void r0() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            if (this.o) {
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
                HashMap map = new HashMap();
                map.put(EventParams.KEY_CT_SDK_POSITION, "1");
                ip3.b("pagemy_tool_friend", "view", map);
            }
        }
        View view = this.k;
        if (view != null) {
            if (this.o) {
                view.setVisibility(8);
                return;
            }
            if (kt3.b <= 0) {
                view.setVisibility(8);
                return;
            }
            lt3 lt3Var = new lt3(getActivity());
            if (lt3Var.n() > 0 || lt3Var.f(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public final void l0() {
    }
}
