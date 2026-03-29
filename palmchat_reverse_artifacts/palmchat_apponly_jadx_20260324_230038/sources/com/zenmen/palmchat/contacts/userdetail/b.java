package com.zenmen.palmchat.contacts.userdetail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.reflect.TypeToken;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserDetailGiftAdapter;
import com.zenmen.palmchat.giftkit.bean.PackPanelItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.aw;
import defpackage.az2;
import defpackage.fg6;
import defpackage.fk2;
import defpackage.g74;
import defpackage.hx3;
import defpackage.js2;
import defpackage.k86;
import defpackage.l50;
import defpackage.n5;
import defpackage.tj2;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.z92;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f13695a;
    public View b;
    public View c;
    public View d;
    public RecyclerView e;
    public UserDetailGiftAdapter f;
    public View g;
    public View h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public TextView m;
    public View n;
    public TextView o;
    public TextView p;
    public ContactInfoItem q;
    public boolean r = true;
    public boolean s = false;
    public boolean t = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements g74<UserDetailGiftAdapter.a> {
        public a() {
        }

        @Override // defpackage.g74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, int i, UserDetailGiftAdapter.a aVar) {
            if (l50.a()) {
                return;
            }
            if (aVar.f13674a == null) {
                b.this.n();
            } else {
                b.this.k();
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1032b implements View.OnClickListener {
        public ViewOnClickListenerC1032b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.r = true;
            b bVar = b.this;
            bVar.o(bVar.q);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f13699a;

        public d(Activity activity) {
            this.f13699a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js2.e();
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_msg");
            aVar.b(bundle);
            this.f13699a.startActivity(n5.b(this.f13699a, aVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            b.this.k();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("targetuid", b.this.q.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends yw4 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<ArrayList<PackPanelItem>> {
            public a() {
            }
        }

        public g() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            b.this.i(true);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            boolean z;
            LogUtil.json("UserDetailGiftHelper", jSONObject, "GiftDao.queryUserGiftReceived");
            if (yy2Var == null || !yy2Var.f22300a) {
                b.this.i(true);
                return;
            }
            try {
                List list = (List) az2.b(yy2Var.d.optString("gifts"), new a().getType());
                if (list == null || list.isEmpty()) {
                    b.this.q(null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new UserDetailGiftAdapter.a((PackPanelItem) it.next()));
                        if (arrayList.size() == 4) {
                            break;
                        }
                    }
                    b.this.q(arrayList);
                }
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            b.this.i(true ^ z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {
        public h() {
            put("targetuid", b.this.q.getUid());
            put("giftnum", Integer.valueOf(b.this.f.getItemCount() > 0 ? 1 : 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("targetuid", b.this.q.getUid());
            put("giftnum", Integer.valueOf(b.this.f.getItemCount() > 0 ? 1 : 0));
        }
    }

    public b(Activity activity, View view, boolean z, boolean z2) {
        this.f13695a = activity;
        this.b = view;
        this.c = view.findViewById(R.id.gift_divider);
        this.d = view.findViewById(R.id.gift_more);
        this.g = view.findViewById(R.id.gift_empty);
        this.j = (TextView) view.findViewById(R.id.gift_empty_mine);
        this.h = view.findViewById(R.id.gift_empty_other);
        this.i = (TextView) view.findViewById(R.id.gift_empty_action);
        this.k = view.findViewById(R.id.gift_status);
        this.m = (TextView) view.findViewById(R.id.gift_error);
        this.l = view.findViewById(R.id.gift_loading);
        this.n = view.findViewById(R.id.gift_empty_task);
        this.o = (TextView) view.findViewById(R.id.gift_part1);
        this.p = (TextView) view.findViewById(R.id.gift_part2);
        this.e = (RecyclerView) view.findViewById(R.id.gift_recycler);
        this.e.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        this.e.setItemAnimator(null);
        UserDetailGiftAdapter userDetailGiftAdapter = new UserDetailGiftAdapter(activity, null);
        this.f = userDetailGiftAdapter;
        userDetailGiftAdapter.s(z);
        this.f.n(new a());
        this.e.setAdapter(this.f);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.Ga)), 5, 9, 18);
        this.m.setText(spannableStringBuilder);
        this.m.setOnClickListener(new ViewOnClickListenerC1032b());
        this.i.setOnClickListener(new c());
        this.p.setOnClickListener(new d(activity));
        this.d.setOnClickListener(new e());
        j();
    }

    public final void h() {
        if (this.f.getItemCount() > 0) {
            this.g.setVisibility(8);
            this.e.setVisibility(0);
            this.d.setVisibility(0);
            return;
        }
        this.g.setVisibility(0);
        this.e.setVisibility(8);
        ContactInfoItem contactInfoItem = this.q;
        if (!(contactInfoItem != null && contactInfoItem.getUid().equals(AccountUtils.p(this.f13695a)))) {
            this.h.setVisibility(0);
            this.n.setVisibility(8);
            this.j.setVisibility(8);
        } else {
            if (!js2.m()) {
                this.h.setVisibility(8);
                this.n.setVisibility(8);
                this.j.setVisibility(0);
                return;
            }
            js2.q(this.f13695a);
            this.h.setVisibility(8);
            if (this.n.getVisibility() != 0) {
                js2.f();
            }
            this.n.setVisibility(0);
            this.j.setVisibility(8);
            this.o.setText(js2.k().e);
            this.p.setText(js2.k().f);
        }
    }

    public final void i(boolean z) {
        if (z) {
            this.r = true;
            if (hx3.m(this.f13695a)) {
                Toast.makeText(this.f13695a, "请求数据失败，请稍后重试", 0).show();
            } else {
                Activity activity = this.f13695a;
                Toast.makeText(activity, activity.getString(R.string.square_network_error), 0).show();
            }
            this.k.setVisibility(0);
            this.m.setVisibility(0);
            this.g.setVisibility(8);
            this.e.setVisibility(8);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            h();
        }
        this.l.setVisibility(8);
    }

    public void j() {
        this.b.setVisibility(8);
    }

    public final void k() {
        Uri.Builder builderBuildUpon = Uri.parse(tj2.i("/receive-gift/#/")).buildUpon();
        builderBuildUpon.appendQueryParameter(bd.h, this.q.getExid());
        builderBuildUpon.appendQueryParameter(DeviceInfoUtil.UID_TAG, this.q.getUid());
        builderBuildUpon.appendQueryParameter("nickname", this.q.getNickName());
        builderBuildUpon.appendQueryParameter("gender", this.q.getGender() + "");
        builderBuildUpon.appendQueryParameter("vipStatus", fg6.g(this.q.getExt()) + "");
        if (TextUtils.isEmpty(this.q.getBigIconURL())) {
            builderBuildUpon.appendQueryParameter(LxAdDLManager.ITEM_ICONURL, this.q.getBigIconURL());
        } else {
            builderBuildUpon.appendQueryParameter(LxAdDLManager.ITEM_ICONURL, this.q.getIconURL());
        }
        Intent intent = new Intent();
        intent.setClass(this.f13695a, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", builderBuildUpon.toString());
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putBoolean("hide_toolbar", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        this.f13695a.startActivity(intent);
        zn6.j("profile_gift", "click", new i());
    }

    public void m() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || contactInfoItem.getUid() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fuid", this.q.getUid());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z92.d(jSONObject, new g().setCacheConfig(aw.a(this.q.getUid())));
    }

    public final void n() {
        InputFragment.b1 = true;
        if (this.q.getIsStranger()) {
            this.q.setBizType(64);
            Activity activity = this.f13695a;
            ContactInfoItem contactInfoItem = this.q;
            SquareTempChatActivity.I1(activity, contactInfoItem, contactInfoItem.getBizType(), null);
        } else {
            Intent intent = new Intent(this.f13695a, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", this.q);
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
            k86.X(intent);
            this.f13695a.startActivity(intent);
        }
        zn6.j("newpageprofil_giftclick", "click", new f());
    }

    public void o(ContactInfoItem contactInfoItem) {
        this.b.setVisibility(0);
        if (contactInfoItem != null && this.r) {
            this.r = false;
            this.q = contactInfoItem;
            if ((!TextUtils.equals(contactInfoItem.getUid(), AccountUtils.p(this.f13695a)) && this.c != null) || this.t) {
                this.c.setVisibility(8);
            }
            p();
            m();
        }
    }

    public final void p() {
        this.g.setVisibility(8);
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.l.setVisibility(0);
        this.d.setVisibility(8);
    }

    public final void q(List<UserDetailGiftAdapter.a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.t && !TextUtils.equals(this.q.getUid(), AccountUtils.p(this.f13695a)) && list.size() > 0) {
            if (list.size() < 4) {
                list.add(new UserDetailGiftAdapter.a(null));
            } else {
                list.remove(list.size() - 1);
                list.add(new UserDetailGiftAdapter.a(null));
            }
        }
        this.f.q(list);
        if (this.s) {
            return;
        }
        this.s = true;
        zn6.j("profile_gift", "view", new h());
    }

    public void l() {
    }
}
