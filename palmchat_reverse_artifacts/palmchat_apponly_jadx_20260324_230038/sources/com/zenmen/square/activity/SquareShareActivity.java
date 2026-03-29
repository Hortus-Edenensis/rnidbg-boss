package com.zenmen.square.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.adapter.SquareShareContactsAdapter;
import com.zenmen.square.adapter.SquareShareFriendsAdapter;
import com.zenmen.square.bean.SquareContactBean;
import com.zenmen.square.bean.SquareFriendBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import defpackage.b35;
import defpackage.b5;
import defpackage.bj5;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.fk2;
import defpackage.gi5;
import defpackage.k86;
import defpackage.kj5;
import defpackage.l50;
import defpackage.mj5;
import defpackage.n5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.uo2;
import defpackage.v4;
import defpackage.vi5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareActivity extends FrameworkBaseActivity implements Observer {
    public View A;
    public View B;
    public RecyclerView C;
    public SquareShareContactsAdapter E;
    public View F;
    public View G;
    public uo2 H;
    public SquareShareFeedBean L;
    public int V;
    public TextView q;
    public TextView r;
    public TextView s;
    public View t;
    public ImageView u;
    public View v;
    public ImageView w;
    public View x;
    public RecyclerView y;
    public SquareShareFriendsAdapter z;
    public List<SquareFriendBean> I = new ArrayList();
    public List<SquareContactBean> J = new ArrayList();
    public List<SquareContactBean> K = new ArrayList();
    public int M = 0;
    public int N = 0;
    public int O = -1;
    public int P = -1;
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;
    public boolean T = false;
    public boolean U = false;
    public Comparator<SquareContactBean> W = new n();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16136a;

        /* JADX INFO: renamed from: com.zenmen.square.activity.SquareShareActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1151a implements Comparator<SquareFriendBean> {
            public C1151a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(SquareFriendBean squareFriendBean, SquareFriendBean squareFriendBean2) {
                int i = squareFriendBean.feedCount;
                int i2 = squareFriendBean2.feedCount;
                if (i != i2) {
                    return i2 - i;
                }
                int i3 = squareFriendBean.messageCount;
                int i4 = squareFriendBean2.messageCount;
                if (i3 != i4) {
                    return i4 - i3;
                }
                return 0;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f16138a;

            public b(List list) {
                this.f16138a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareShareActivity.this.I = this.f16138a;
                SquareShareActivity.this.t2(false);
            }
        }

        public a(ArrayList arrayList) {
            this.f16136a = arrayList;
        }

        @Override // defpackage.b5
        public void call() {
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : bj5.b().a().X(dn0.a(v4.e(SquareShareActivity.this)))) {
                for (ContactInfoItem contactInfoItem2 : this.f16136a) {
                    if (contactInfoItem2.getUid().equals(contactInfoItem.getUid())) {
                        SquareFriendBean squareFriendBean = new SquareFriendBean();
                        squareFriendBean.selected = true;
                        squareFriendBean.item = contactInfoItem2;
                        squareFriendBean.messageCount = bj5.b().a().a0(SquareShareActivity.this, contactInfoItem2);
                        squareFriendBean.feedCount = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + contactInfoItem2.getUid()), 0);
                        arrayList.add(squareFriendBean);
                    }
                }
            }
            Collections.sort(arrayList, new C1151a());
            SquareShareActivity.this.runOnUiThread(new b(arrayList));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16139a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f16140a;

            public a(List list) {
                this.f16140a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareShareActivity.this.K = this.f16140a;
                SquareShareActivity.this.s2();
            }
        }

        public b(ArrayList arrayList) {
            this.f16139a = arrayList;
        }

        @Override // defpackage.b5
        public void call() {
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : this.f16139a) {
                for (SquareContactBean squareContactBean : SquareShareActivity.this.J) {
                    if (contactInfoItem.getUid().equals(squareContactBean.id)) {
                        squareContactBean.selected = true;
                        squareContactBean.feedCount = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + squareContactBean.number), 0);
                        arrayList.add(squareContactBean);
                    }
                }
            }
            Collections.sort(arrayList, SquareShareActivity.this.W);
            SquareShareActivity.this.runOnUiThread(new a(arrayList));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements b5 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f16142a;

            public a(List list) {
                this.f16142a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareShareActivity.this.J = this.f16142a;
                if (SquareShareActivity.this.P > 0) {
                    SquareShareActivity.this.s2();
                } else {
                    SquareShareActivity.this.T = true;
                }
                if (SquareShareActivity.this.N > 0) {
                    SquareShareActivity.this.O = 3;
                } else {
                    SquareShareActivity.this.O = 5;
                }
                if (SquareShareActivity.this.S) {
                    SquareShareActivity.this.S = false;
                    SquareShareActivity.this.t2(true);
                }
            }
        }

        public c() {
        }

        @Override // defpackage.b5
        public void call() {
            List<SquareContactBean> listO = bj5.b().a().o();
            SquareShareActivity.this.N = listO.size();
            for (SquareContactBean squareContactBean : listO) {
                squareContactBean.feedCount = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + squareContactBean.number), 0);
            }
            Collections.sort(listO, SquareShareActivity.this.W);
            SquareShareActivity.this.runOnUiThread(new a(listO));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements b5 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<SquareFriendBean> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(SquareFriendBean squareFriendBean, SquareFriendBean squareFriendBean2) {
                int i = squareFriendBean.feedCount;
                int i2 = squareFriendBean2.feedCount;
                if (i != i2) {
                    return i2 - i;
                }
                int i3 = squareFriendBean.messageCount;
                int i4 = squareFriendBean2.messageCount;
                if (i3 != i4) {
                    return i4 - i3;
                }
                return 0;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f16145a;

            public b(List list) {
                this.f16145a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareShareActivity.this.I = this.f16145a;
                if (SquareShareActivity.this.O > 0) {
                    SquareShareActivity.this.t2(true);
                } else {
                    SquareShareActivity.this.S = true;
                }
                if (SquareShareActivity.this.M > 0) {
                    SquareShareActivity.this.P = 3;
                } else {
                    SquareShareActivity.this.P = 5;
                }
                if (SquareShareActivity.this.T) {
                    SquareShareActivity.this.T = false;
                    SquareShareActivity.this.s2();
                }
            }
        }

        public d() {
        }

        @Override // defpackage.b5
        public void call() {
            List<ContactInfoItem> listX = bj5.b().a().X(dn0.a(v4.e(SquareShareActivity.this)));
            SquareShareActivity.this.M = listX.size();
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : listX) {
                SquareFriendBean squareFriendBean = new SquareFriendBean();
                squareFriendBean.item = contactInfoItem;
                squareFriendBean.messageCount = bj5.b().a().a0(SquareShareActivity.this, contactInfoItem);
                squareFriendBean.feedCount = SPUtil.f14322a.f(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + contactInfoItem.getUid()), 0);
                arrayList.add(squareFriendBean);
            }
            Collections.sort(arrayList, new a());
            SquareShareActivity.this.runOnUiThread(new b(arrayList));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {
        public e() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", SquareShareActivity.this.getPackageName(), null));
            SquareShareActivity.this.startActivity(intent);
            SquareShareActivity.this.U = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            int i = 1;
            SquareShareActivity.this.u2(true);
            if (SquareShareActivity.this.h2()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("localnews", SquareShareActivity.this.Q ? 1 : 0);
                    if (!SquareShareActivity.this.R) {
                        i = 0;
                    }
                    jSONObject.put("circlenews", i);
                    jSONObject.put("friendsnews", SquareShareActivity.this.z.r().size());
                    jSONObject.put("Contactsnews", SquareShareActivity.this.E.r().size());
                    jSONObject.put("from", SquarePublishActivity.D0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.f("pagepostshare_down_pubilsh", "click", jSONObject);
                mj5.r().B(SquareShareActivity.this.L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareShareActivity.this.Q = !r2.Q;
            SquareShareActivity.this.R = false;
            SquareShareActivity.this.u.setImageResource(SquareShareActivity.this.Q ? R$drawable.square_share_selected : R$drawable.square_share_unselected);
            SquareShareActivity.this.w.setImageResource(R$drawable.square_share_unselected);
            SquareShareActivity.this.i2();
            zn6.c("pagepostshare_center_localnews", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareShareActivity.this.Q = false;
            SquareShareActivity.this.R = !r3.R;
            ImageView imageView = SquareShareActivity.this.u;
            int i = R$drawable.square_share_unselected;
            imageView.setImageResource(i);
            ImageView imageView2 = SquareShareActivity.this.w;
            if (SquareShareActivity.this.R) {
                i = R$drawable.square_share_selected;
            }
            imageView2.setImageResource(i);
            SquareShareActivity.this.i2();
            zn6.c("pagepostshare_center_friendnews", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements SquareShareFriendsAdapter.a {
        public i() {
        }

        @Override // com.zenmen.square.adapter.SquareShareFriendsAdapter.a
        public void a(SquareFriendBean squareFriendBean, View view) {
            squareFriendBean.selected = !squareFriendBean.selected;
            SquareShareActivity.this.z.notifyDataSetChanged();
            SquareShareActivity.this.i2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
            for (SquareFriendBean squareFriendBean : SquareShareActivity.this.z.f()) {
                if (squareFriendBean.selected) {
                    arrayList.add(squareFriendBean.item);
                }
            }
            bj5.b().a().d0(SquareShareActivity.this, arrayList, dn0.a(v4.e(SquareShareActivity.this)), 100);
            zn6.c("pagepostshare_center_morefriend", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements SquareShareContactsAdapter.a {
        public k() {
        }

        @Override // com.zenmen.square.adapter.SquareShareContactsAdapter.a
        public void a(SquareContactBean squareContactBean, View view) {
            boolean z = !squareContactBean.selected;
            squareContactBean.selected = z;
            if (z) {
                SquareShareActivity.this.K.add(squareContactBean);
            } else {
                SquareShareActivity.this.K.remove(squareContactBean);
            }
            SquareShareActivity.this.E.notifyDataSetChanged();
            SquareShareActivity.this.i2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<ContactInfoItem> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
                String firstPinyin = contactInfoItem.getFirstPinyin();
                String firstPinyin2 = contactInfoItem2.getFirstPinyin();
                for (int i = 0; i < firstPinyin.length(); i++) {
                    if (i >= firstPinyin2.length() || firstPinyin.charAt(i) > firstPinyin2.charAt(i)) {
                        return 1;
                    }
                    if (firstPinyin.charAt(i) != firstPinyin2.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Comparator<ContactInfoItem> {
            public b() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
                String firstPinyin = contactInfoItem.getFirstPinyin();
                String firstPinyin2 = contactInfoItem2.getFirstPinyin();
                for (int i = 0; i < firstPinyin.length(); i++) {
                    if (i >= firstPinyin2.length() || firstPinyin.charAt(i) > firstPinyin2.charAt(i)) {
                        return 1;
                    }
                    if (firstPinyin.charAt(i) != firstPinyin2.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
            Iterator it = SquareShareActivity.this.K.iterator();
            while (it.hasNext()) {
                arrayList.add(bj5.b().a().P((SquareContactBean) it.next()));
            }
            ArrayList<ContactInfoItem> arrayList2 = new ArrayList<>();
            Iterator it2 = SquareShareActivity.this.J.iterator();
            while (it2.hasNext()) {
                arrayList2.add(bj5.b().a().P((SquareContactBean) it2.next()));
            }
            Collections.sort(arrayList, new a());
            Collections.sort(arrayList2, new b());
            bj5.b().a().A(SquareShareActivity.this, arrayList, arrayList2, 101);
            zn6.c("pagepostshare_center_moreaddressfriend", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            BaseActivityPermissionDispatcher.b(SquareShareActivity.this, BaseActivityPermissionDispatcher.PermissionType.CONTACT, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Comparator<SquareContactBean> {
        public n() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SquareContactBean squareContactBean, SquareContactBean squareContactBean2) {
            int i = squareContactBean.feedCount;
            int i2 = squareContactBean2.feedCount;
            if (i != i2) {
                return i2 > i ? 1 : -1;
            }
            String str = squareContactBean.firstPinyin;
            String str2 = squareContactBean2.firstPinyin;
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (i3 >= str2.length() || str.charAt(i3) > str2.charAt(i3)) {
                    return 1;
                }
                if (str.charAt(i3) != str2.charAt(i3)) {
                    return -1;
                }
            }
            if (str.length() > str2.length()) {
                return 1;
            }
            return str.length() < str2.length() ? -1 : 0;
        }
    }

    public final boolean h2() {
        return true;
    }

    public final void i2() {
        u2(false);
        this.q.setEnabled(h2());
    }

    public final void initActionBar() {
        initToolbar(R$id.toolbar, "分享到", true);
        getToolbar().setBackgroundResource(R$color.white);
    }

    public final void j2() {
        if (!q2()) {
            this.O = 5;
            if (this.S) {
                this.S = false;
                t2(true);
                return;
            }
            return;
        }
        if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList)) {
            this.G.setVisibility(8);
            n2();
            return;
        }
        this.B.setVisibility(0);
        this.G.setVisibility(0);
        this.C.setVisibility(8);
        this.F.setVisibility(8);
        this.O = 3;
        if (this.S) {
            this.S = false;
            t2(true);
        }
    }

    public final void k2() {
        this.r.setText(gi5.q("postrecommend_name", "本地动态"));
        this.s.setText(gi5.q("postfriend_name", "连信好友圈"));
        int iO = gi5.o();
        if (iO == 1) {
            this.Q = true;
            this.u.setImageResource(R$drawable.square_share_selected);
        } else if (iO == 2) {
            this.R = true;
            this.w.setImageResource(R$drawable.square_share_selected);
        }
    }

    public final void l2() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.L = (SquareShareFeedBean) intent.getParcelableExtra(MediationConstant.RIT_TYPE_FEED);
        this.V = intent.getIntExtra("key_from", 0);
    }

    public final void m2() {
        this.q = (TextView) findViewById(R$id.confirm);
        this.t = findViewById(R$id.recommend);
        this.u = (ImageView) findViewById(R$id.recommend_choice);
        this.v = findViewById(R$id.moments);
        this.w = (ImageView) findViewById(R$id.moments_choice);
        this.r = (TextView) findViewById(R$id.tv_recommend);
        this.s = (TextView) findViewById(R$id.tv_moment);
        this.x = findViewById(R$id.friends);
        this.y = (RecyclerView) findViewById(R$id.friends_recycler);
        this.A = findViewById(R$id.friends_more);
        this.B = findViewById(R$id.contacts);
        this.C = (RecyclerView) findViewById(R$id.contacts_recycler);
        this.F = findViewById(R$id.contacts_more);
        this.G = findViewById(R$id.contacts_permission);
        k2();
        this.q.setOnClickListener(new f());
        this.t.setOnClickListener(new g());
        this.v.setOnClickListener(new h());
        this.y.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.y.setItemAnimator(null);
        this.y.setNestedScrollingEnabled(false);
        SquareShareFriendsAdapter squareShareFriendsAdapter = new SquareShareFriendsAdapter(this, null);
        this.z = squareShareFriendsAdapter;
        this.y.setAdapter(squareShareFriendsAdapter);
        this.z.t(new i());
        this.A.setOnClickListener(new j());
        this.C.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.C.setItemAnimator(null);
        this.C.setNestedScrollingEnabled(false);
        SquareShareContactsAdapter squareShareContactsAdapter = new SquareShareContactsAdapter(this, null);
        this.E = squareShareContactsAdapter;
        this.C.setAdapter(squareShareContactsAdapter);
        this.E.t(new k());
        this.F.setOnClickListener(new l());
        this.G.setOnClickListener(new m());
        this.x.setVisibility(8);
        this.B.setVisibility(8);
        i2();
    }

    public final void n2() {
        b35.c().a().a(new c());
    }

    public final void o2() {
        b35.c().a().a(new d());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1 && intent != null) {
            ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("choose_contact_list");
            if (parcelableArrayListExtra2 == null || parcelableArrayListExtra2.isEmpty()) {
                return;
            } else {
                b35.c().a().a(new a(parcelableArrayListExtra2));
            }
        }
        if (i2 != 101 || i3 != -1 || intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("choose_contact_list")) == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        b35.c().a().a(new b(parcelableArrayListExtra));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.H = bj5.b().c();
        setContentView(R$layout.square_layout_activity_share);
        l2();
        initActionBar();
        m2();
        o2();
        j2();
        mj5.r().addObserver(this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.V);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("pagepostshare", "view", jSONObject);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mj5.r().deleteObserver(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList[0])) {
            return;
        }
        r2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        j2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.U) {
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
            if (tg4.b(this, permissionType.permissionList)) {
                onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
            }
        }
    }

    public final void p2() {
        if (this.Q) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_square");
            bundle.putString("square_tab", "recommendTitle");
            aVar.b(bundle);
            startActivity(n5.b(this, aVar));
        } else if (!this.R) {
            SquareShareFeedBean squareShareFeedBean = this.L;
            if (squareShareFeedBean.sendLxFriendFlag) {
                fk2.a aVar2 = new fk2.a();
                Bundle bundle2 = new Bundle();
                bundle2.putString("main_tab", "tab_msg");
                bundle2.putParcelable("share_sms", this.L.shareSmsBean);
                aVar2.b(bundle2);
                startActivity(n5.b(this, aVar2));
            } else if (squareShareFeedBean.sendContactsFriendFlag && squareShareFeedBean.shareSmsBean != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<SquareContactBean> it = this.L.contactLists.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().number);
                }
                k86.V(this, this.L.shareSmsBean.msgContent, arrayList, 102);
            }
        } else if (gi5.t("momentsTitle")) {
            fk2.a aVar3 = new fk2.a();
            Bundle bundle3 = new Bundle();
            bundle3.putString("main_tab", "tab_square");
            bundle3.putString("square_tab", "momentsTitle");
            bundle3.putParcelable("share_sms", this.L.shareSmsBean);
            aVar3.b(bundle3);
            startActivity(n5.b(this, aVar3));
        } else {
            n5.f(this, new Bundle());
        }
        ds0.a().b(new kj5());
        vi5.b().j();
        finish();
    }

    public final boolean q2() {
        List<Media> list;
        SquareShareFeedBean squareShareFeedBean = this.L;
        return (squareShareFeedBean == null || (list = squareShareFeedBean.mediaList) == null || list.size() != 1) ? false : true;
    }

    public final void r2() {
        new sd3(this).k("请在设置-应用-连信-权限中开启通讯录权限，以正常使用动态分享功能").P("去开启").L("取消").f(new e()).Q();
    }

    public final void s2() {
        if (this.J.isEmpty()) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            if (this.K.isEmpty()) {
                List<SquareContactBean> list = this.J;
                this.E.q(list.subList(0, Math.min(this.P, list.size())));
            } else {
                this.E.q(this.K);
            }
            this.F.setVisibility((this.N > this.E.getItemCount() || this.N > this.P) ? 0 : 8);
        }
        i2();
    }

    public final void t2(boolean z) {
        if (this.I.isEmpty()) {
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            if (z) {
                List<SquareFriendBean> list = this.I;
                this.z.q(list.subList(0, Math.min(this.O, list.size())));
            } else {
                this.z.q(this.I);
            }
            this.A.setVisibility((this.M > this.z.getItemCount() || this.M > this.O) ? 0 : 8);
        }
        i2();
    }

    public final void u2(boolean z) {
        if (this.L == null) {
            return;
        }
        boolean z2 = !this.z.r().isEmpty();
        boolean z3 = !this.E.r().isEmpty();
        SquareShareFeedBean squareShareFeedBean = this.L;
        squareShareFeedBean.sendLxFriendFlag = z2;
        if (z2 && z) {
            squareShareFeedBean.lxFriendBeanList = this.z.r();
        }
        SquareShareFeedBean squareShareFeedBean2 = this.L;
        squareShareFeedBean2.sendContactsFriendFlag = z3;
        if (z3 && z) {
            squareShareFeedBean2.contactLists = this.E.r();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (isFinishing() || obj == null) {
            return;
        }
        SquareShareFeedBean squareShareFeedBean = this.L;
        int i2 = squareShareFeedBean.publicStatus;
        if (i2 == 1) {
            if (this.Q || this.R) {
                p2();
                return;
            } else {
                showBaseProgressBar();
                return;
            }
        }
        if (i2 == -1) {
            hideBaseProgressBar();
            sy5.f(com.zenmen.palmchat.c.b(), this.L.errorMsg, 1).g();
            return;
        }
        if (i2 == 2) {
            if (this.Q || this.R || squareShareFeedBean.sendContactsFriendFlag) {
                return;
            }
            hideBaseProgressBar();
            p2();
            return;
        }
        if (i2 == 5) {
            if (this.Q || this.R) {
                return;
            }
            mj5.r().G(this);
            hideBaseProgressBar();
            return;
        }
        if (i2 == 3) {
            if (this.Q || this.R || !squareShareFeedBean.sendContactsFriendFlag) {
                return;
            }
            showBaseProgressBar();
            return;
        }
        if (i2 != 4 || this.Q || this.R || !squareShareFeedBean.sendContactsFriendFlag || squareShareFeedBean.shareSmsBean == null) {
            return;
        }
        hideBaseProgressBar();
        p2();
    }
}
