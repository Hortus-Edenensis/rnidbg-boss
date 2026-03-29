package com.zenmen.palmchat.square;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.cdo.oaps.ad.OapsKey;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.userdetail.UserDetailFeedAdapter;
import com.zenmen.palmchat.contacts.userdetail.UserFeedActivity;
import com.zenmen.palmchat.databinding.ActivityDynamicExposeHomeBinding;
import com.zenmen.palmchat.databinding.ListitemDynamicExposeHomeBuyBinding;
import com.zenmen.palmchat.databinding.ListitemDynamicExposeHomeDynamicBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.square.SuperExposeAgreementDialog;
import com.zenmen.palmchat.utils.SSpaceItemDecoration1;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.bean.SquareDynamicLifeBeanInfo;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.dynamiclife.bean.SquareFeedSuperShowSkuListResult;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.ui.widget.SquarePersonalHelper;
import defpackage.a0;
import defpackage.a46;
import defpackage.b05;
import defpackage.bj5;
import defpackage.c0;
import defpackage.ds0;
import defpackage.go2;
import defpackage.hc2;
import defpackage.hi5;
import defpackage.kj1;
import defpackage.me1;
import defpackage.nb3;
import defpackage.of2;
import defpackage.q05;
import defpackage.ry5;
import defpackage.sw4;
import defpackage.tg4;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.v4;
import defpackage.vl1;
import defpackage.xn3;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicExposeHomeActivity extends BaseActionBarActivity {
    public SquareFeedSuperShowSkuListResult C;
    public uo2 E;
    public ActivityDynamicExposeHomeBinding q;
    public SuperExposeAgreementDialog r;
    public SBaseRecycleAdapter<UserDetailFeedAdapter.a, SBaseViewHolder> s;
    public SBaseRecycleAdapter<SquareFeedSuperShowSkuListResult.SkuListBean, SBaseViewHolder> t;
    public int w;
    public SquareFeed x;
    public List<SquareFeedSuperShowSkuListResult.SkuListBean> u = new ArrayList();
    public List<UserDetailFeedAdapter.a> v = new ArrayList();
    public int y = -1;
    public int z = -1;
    public boolean A = false;
    public boolean B = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity.this.q.x.setSelected(true);
            DynamicExposeHomeActivity.this.q.y.setSelected(false);
            DynamicExposeHomeActivity.this.q.z.setSelected(false);
            DynamicExposeHomeActivity.this.q.x.setTextColor(Color.parseColor("#FF05D694"));
            DynamicExposeHomeActivity.this.q.y.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.q.z.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.y = 0;
            dynamicExposeHomeActivity.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity.this.q.x.setSelected(false);
            DynamicExposeHomeActivity.this.q.y.setSelected(true);
            DynamicExposeHomeActivity.this.q.z.setSelected(false);
            DynamicExposeHomeActivity.this.q.x.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.q.y.setTextColor(Color.parseColor("#FF05D694"));
            DynamicExposeHomeActivity.this.q.z.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.y = 1;
            dynamicExposeHomeActivity.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity.this.q.x.setSelected(false);
            DynamicExposeHomeActivity.this.q.y.setSelected(false);
            DynamicExposeHomeActivity.this.q.z.setSelected(true);
            DynamicExposeHomeActivity.this.q.x.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.q.y.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.q.z.setTextColor(Color.parseColor("#FF05D694"));
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.y = 2;
            dynamicExposeHomeActivity.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.z = 2;
            dynamicExposeHomeActivity.q.i.setSelected(true);
            DynamicExposeHomeActivity.this.q.j.setSelected(false);
            DynamicExposeHomeActivity.this.q.i.setTextColor(Color.parseColor("#FF05D694"));
            DynamicExposeHomeActivity.this.q.j.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.W1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.z = 1;
            dynamicExposeHomeActivity.q.i.setSelected(false);
            DynamicExposeHomeActivity.this.q.j.setSelected(true);
            DynamicExposeHomeActivity.this.q.i.setTextColor(Color.parseColor("#FF222222"));
            DynamicExposeHomeActivity.this.q.j.setTextColor(Color.parseColor("#FF05D694"));
            DynamicExposeHomeActivity.this.W1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements c0 {
            public a() {
            }

            @Override // defpackage.c0
            public void a(int i, Intent intent) {
                if (i != -1 || q05.o(DynamicExposeHomeActivity.this)) {
                    return;
                }
                DynamicExposeHomeActivity.this.x = (SquareFeed) intent.getParcelableExtra("EXTRA_FEED");
                DynamicExposeHomeActivity.this.V1();
            }
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            Intent intent = new Intent(DynamicExposeHomeActivity.this, (Class<?>) UserFeedActivity.class);
            intent.putExtra("extra_user", q05.e());
            intent.putExtra("extra_tab", 0);
            intent.putExtra("EXTRA_From", 2);
            a0.d(DynamicExposeHomeActivity.this).e(intent).b(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            if (DynamicExposeHomeActivity.this.x.getFeedType() == 1) {
                DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
                MediaViewActivity.B1(16, dynamicExposeHomeActivity.sInstance, dynamicExposeHomeActivity.x, false);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(DynamicExposeHomeActivity.this.x);
                Bundle bundle = new Bundle();
                bundle.putString("key_feed_uid", DynamicExposeHomeActivity.this.x.uid);
                bundle.putInt("key_target_position", 0);
                DynamicExposeHomeActivity dynamicExposeHomeActivity2 = DynamicExposeHomeActivity.this;
                MediaViewActivity.C1(dynamicExposeHomeActivity2.w == 1 ? 8 : 16, arrayList, dynamicExposeHomeActivity2.sInstance, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("status", Integer.valueOf(DynamicExposeHomeActivity.this.H1()));
            put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends go2<LXBaseNetBean<SquareFeedSuperShowSkuListResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15381a;
        public final /* synthetic */ HashMap b;

        public k(String str, HashMap map) {
            this.f15381a = str;
            this.b = map;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15381a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SquareFeedSuperShowSkuListResult> lXBaseNetBean, Exception exc) {
            SquareFeedSuperShowSkuListResult squareFeedSuperShowSkuListResult;
            if (q05.o(DynamicExposeHomeActivity.this) || !z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (squareFeedSuperShowSkuListResult = lXBaseNetBean.data) == null) {
                return;
            }
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            dynamicExposeHomeActivity.C = squareFeedSuperShowSkuListResult;
            dynamicExposeHomeActivity.W1(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends tw4<CommonResponse<SquareDynamicLifeResponseBean>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("status", Integer.valueOf(DynamicExposeHomeActivity.this.H1()));
                put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("status", Integer.valueOf(DynamicExposeHomeActivity.this.H1()));
                put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
            }
        }

        public l() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareDynamicLifeResponseBean> commonResponse) {
            if (q05.o(DynamicExposeHomeActivity.this)) {
                return;
            }
            List<SquareDynamicLifeBeanInfo> list = (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().userDailyLifeList == null || commonResponse.getData().userDailyLifeList.isEmpty()) ? null : commonResponse.getData().userDailyLifeList;
            if (list == null || list.isEmpty()) {
                DynamicExposeHomeActivity.this.q.t.setVisibility(0);
                DynamicExposeHomeActivity.this.q.k.setVisibility(8);
                DynamicExposeHomeActivity.this.q.E.setVisibility(8);
            } else {
                DynamicExposeHomeActivity.this.v.clear();
                Iterator<SquareDynamicLifeBeanInfo> it = list.iterator();
                while (it.hasNext()) {
                    DynamicExposeHomeActivity.this.v.add(new UserDetailFeedAdapter.a(it.next()));
                    if (DynamicExposeHomeActivity.this.v.size() >= 5) {
                        break;
                    }
                }
                DynamicExposeHomeActivity.this.s.notifyDataSetChanged();
                DynamicExposeHomeActivity.this.q.t.setVisibility(8);
                DynamicExposeHomeActivity.this.q.k.setVisibility(8);
                DynamicExposeHomeActivity.this.q.E.setVisibility(0);
            }
            q05.a("postboost_homepage", 1, new a());
            DynamicExposeHomeActivity.this.P1();
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            q05.a("postboost_homepage", 1, new b());
            DynamicExposeHomeActivity.this.q.t.setVisibility(8);
            DynamicExposeHomeActivity.this.q.k.setVisibility(8);
            DynamicExposeHomeActivity.this.q.E.setVisibility(0);
            DynamicExposeHomeActivity.this.P1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f15385a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 1);
            }
        }

        public m(MaterialDialog materialDialog) {
            this.f15385a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_purchaseSucceed_pop", 2, new a());
            Intent intent = new Intent(DynamicExposeHomeActivity.this, (Class<?>) UserFeedActivity.class);
            intent.putExtra("extra_user", q05.e());
            intent.putExtra("extra_tab", 0);
            intent.putExtra("EXTRA_From", 3);
            intent.putExtra(SquarePersonalHelper.EXTRA_FEED_ID, DynamicExposeHomeActivity.this.x.id);
            DynamicExposeHomeActivity.this.startActivity(intent);
            this.f15385a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f15387a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 2);
            }
        }

        public n(MaterialDialog materialDialog) {
            this.f15387a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_purchaseSucceed_pop", 2, new a());
            this.f15387a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15389a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ SquareDynamicLifeBeanInfo c;

        public o(String str, HashMap map, SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
            this.f15389a = str;
            this.b = map;
            this.c = squareDynamicLifeBeanInfo;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15389a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (!q05.o(DynamicExposeHomeActivity.this) && z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                DynamicExposeHomeActivity.this.O1(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 2);
                put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
                put("status", Integer.valueOf(DynamicExposeHomeActivity.this.H1()));
            }
        }

        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_homepage", 2, new a());
            bj5.b().a().c0(DynamicExposeHomeActivity.this, 104, null, null, null, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("button", 1);
                put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
                put("status", Integer.valueOf(DynamicExposeHomeActivity.this.H1()));
            }
        }

        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_homepage", 2, new a());
            DynamicExposeHomeActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            boolean z = !dynamicExposeHomeActivity.A;
            dynamicExposeHomeActivity.A = z;
            dynamicExposeHomeActivity.q.f.setSelected(z);
            DynamicExposeHomeActivity dynamicExposeHomeActivity2 = DynamicExposeHomeActivity.this;
            if (dynamicExposeHomeActivity2.A) {
                dynamicExposeHomeActivity2.q.u.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(DynamicExposeHomeActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-41bf2881ea1f459fa99594a6594b34cb-strs8y");
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            DynamicExposeHomeActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements c0 {
            public a() {
            }

            @Override // defpackage.c0
            public void a(int i, Intent intent) {
                if (i != -1 || q05.o(DynamicExposeHomeActivity.this)) {
                    return;
                }
                DynamicExposeHomeActivity.this.x = (SquareFeed) intent.getParcelableExtra("EXTRA_FEED");
                DynamicExposeHomeActivity.this.V1();
            }
        }

        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            Intent intent = new Intent(DynamicExposeHomeActivity.this, (Class<?>) UserFeedActivity.class);
            intent.putExtra("extra_user", q05.e());
            intent.putExtra("extra_tab", 0);
            intent.putExtra("EXTRA_From", 2);
            intent.putExtra("EXTRA_From_Param", DynamicExposeHomeActivity.this.w);
            a0.d(DynamicExposeHomeActivity.this).e(intent).b(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends SBaseRecycleAdapter<UserDetailFeedAdapter.a, SBaseViewHolder> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends SBaseViewHolder<UserDetailFeedAdapter.a, ListitemDynamicExposeHomeDynamicBinding> {

            /* JADX INFO: renamed from: com.zenmen.palmchat.square.DynamicExposeHomeActivity$u$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class ViewOnClickListenerC1107a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UserDetailFeedAdapter.a f15398a;

                public ViewOnClickListenerC1107a(UserDetailFeedAdapter.a aVar) {
                    this.f15398a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (q05.p()) {
                        return;
                    }
                    DynamicExposeHomeActivity.this.G1(this.f15398a.f13669a);
                }
            }

            public a(ListitemDynamicExposeHomeDynamicBinding listitemDynamicExposeHomeDynamicBinding) {
                super(listitemDynamicExposeHomeDynamicBinding);
            }

            @Override // com.zenmen.palmchat.square.SBaseViewHolder
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public void l(SBaseViewHolder<UserDetailFeedAdapter.a, ListitemDynamicExposeHomeDynamicBinding> sBaseViewHolder, UserDetailFeedAdapter.a aVar, int i) {
                SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo;
                int iB = me1.b(sBaseViewHolder.itemView.getContext(), 64);
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).d.setTextColor(Color.parseColor("#222222"));
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).c.setVisibility(i == 0 ? 0 : 8);
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).getRoot().setOnClickListener(new ViewOnClickListenerC1107a(aVar));
                if (aVar == null || (squareDynamicLifeBeanInfo = aVar.f13669a) == null) {
                    return;
                }
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).d.setVisibility(squareDynamicLifeBeanInfo.feedType == 1 ? 0 : 8);
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).f13910a.setVisibility(aVar.f13669a.feedType == 1 ? 8 : 0);
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).b.setVisibility(aVar.f13669a.feedType != 3 ? 8 : 0);
                if (!TextUtils.isEmpty(aVar.f13669a.url) && aVar.f13669a.feedType != 1) {
                    hc2.a(((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).getRoot().getContext()).load(a46.g(iB, iB, aVar.f13669a.url)).error(R.drawable.icon_default_thumbnail).into(((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).f13910a);
                } else if (!TextUtils.isEmpty(aVar.f13669a.content)) {
                    ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).d.setText(vl1.c(aVar.f13669a.content.trim(), ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).d.getContext(), vl1.j));
                }
                ((ListitemDynamicExposeHomeDynamicBinding) sBaseViewHolder.d).e.setText(DynamicExposeHomeActivity.this.I1(aVar.f13669a.views));
            }
        }

        public u(Context context, List list) {
            super(context, list);
        }

        @Override // com.zenmen.palmchat.square.SBaseRecycleAdapter
        public SBaseViewHolder a(@NonNull ViewGroup viewGroup, int i) {
            return new a(ListitemDynamicExposeHomeDynamicBinding.b(DynamicExposeHomeActivity.this.getLayoutInflater(), viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends SBaseRecycleAdapter<SquareFeedSuperShowSkuListResult.SkuListBean, SBaseViewHolder> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends SBaseViewHolder<SquareFeedSuperShowSkuListResult.SkuListBean, ListitemDynamicExposeHomeBuyBinding> {

            /* JADX INFO: renamed from: com.zenmen.palmchat.square.DynamicExposeHomeActivity$v$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class ViewOnClickListenerC1108a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SquareFeedSuperShowSkuListResult.SkuListBean f15399a;

                public ViewOnClickListenerC1108a(SquareFeedSuperShowSkuListResult.SkuListBean skuListBean) {
                    this.f15399a = skuListBean;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < DynamicExposeHomeActivity.this.u.size(); i++) {
                        if (DynamicExposeHomeActivity.this.u.get(i).productId.equals(this.f15399a.productId)) {
                            DynamicExposeHomeActivity.this.u.get(i).selected = true;
                        } else {
                            DynamicExposeHomeActivity.this.u.get(i).selected = false;
                        }
                    }
                    DynamicExposeHomeActivity.this.R1();
                    DynamicExposeHomeActivity.this.t.notifyDataSetChanged();
                }
            }

            public a(ListitemDynamicExposeHomeBuyBinding listitemDynamicExposeHomeBuyBinding) {
                super(listitemDynamicExposeHomeBuyBinding);
            }

            @Override // com.zenmen.palmchat.square.SBaseViewHolder
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public void l(SBaseViewHolder<SquareFeedSuperShowSkuListResult.SkuListBean, ListitemDynamicExposeHomeBuyBinding> sBaseViewHolder, SquareFeedSuperShowSkuListResult.SkuListBean skuListBean, int i) {
                ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).g.setSelected(skuListBean.selected);
                ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).b.setText(skuListBean.showCount + "");
                ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).c.setText(skuListBean.price + "");
                if (skuListBean.selected) {
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).f13909a.setTextColor(Color.parseColor("#05D694"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).b.setTextColor(Color.parseColor("#05D694"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).e.setTextColor(Color.parseColor("#05D694"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).d.setTextColor(Color.parseColor("#05D694"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).c.setTextColor(Color.parseColor("#05D694"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).f.setTextColor(Color.parseColor("#05D694"));
                } else {
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).f13909a.setTextColor(Color.parseColor("#999999"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).b.setTextColor(Color.parseColor("#222222"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).d.setTextColor(Color.parseColor("#222222"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).e.setTextColor(Color.parseColor("#222222"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).c.setTextColor(Color.parseColor("#222222"));
                    ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).f.setTextColor(Color.parseColor("#222222"));
                }
                ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).h.setText((skuListBean.showTime / 3600) + "小时");
                ((ListitemDynamicExposeHomeBuyBinding) sBaseViewHolder.d).g.setOnClickListener(new ViewOnClickListenerC1108a(skuListBean));
            }
        }

        public v(Context context, List list) {
            super(context, list);
        }

        @Override // com.zenmen.palmchat.square.SBaseRecycleAdapter
        public SBaseViewHolder a(@NonNull ViewGroup viewGroup, int i) {
            return new a(ListitemDynamicExposeHomeBuyBinding.b(DynamicExposeHomeActivity.this.getLayoutInflater(), viewGroup, false));
        }
    }

    public static void J1(Context context, int i2, SquareFeed squareFeed) {
        Intent intent = new Intent(context, (Class<?>) DynamicExposeHomeActivity.class);
        intent.putExtra("EXTRA_FROM", i2);
        intent.putExtra("EXTRA_FEED", squareFeed);
        context.startActivity(intent);
    }

    public void G1(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
        String str = q05.c() + "/square.feed.super.show.select";
        HashMap map = new HashMap();
        map.put("feedId", Long.valueOf(squareDynamicLifeBeanInfo.id));
        zw4.e(new o(str, map, squareDynamicLifeBeanInfo));
    }

    public int H1() {
        if (this.q.t.getVisibility() == 0) {
            return 3;
        }
        if (this.q.E.getVisibility() == 0) {
            return 2;
        }
        return this.q.k.getVisibility() == 0 ? 1 : -1;
    }

    public String I1(int i2) {
        return i2 <= 999 ? String.valueOf(i2) : i2 <= 9999 ? String.format("%.1fk", Double.valueOf(((double) i2) / 1000.0d)) : String.format("%.1fw", Double.valueOf(((double) i2) / 10000.0d));
    }

    public final void K1() {
        Q1(this.q.G);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.q.m.setLayoutManager(linearLayoutManager);
        this.q.F.setOnClickListener(new p());
        this.q.f13888a.setOnClickListener(new q());
        this.q.g.setOnClickListener(new r());
        this.q.h.setOnClickListener(new s());
        this.q.r.setOnClickListener(new t());
        u uVar = new u(this, this.v);
        this.s = uVar;
        this.q.m.setAdapter(uVar);
        this.q.w.setLayoutManager(new GridLayoutManager(this, 2));
        this.q.w.addItemDecoration(new SSpaceItemDecoration1(this, 4));
        v vVar = new v(this, this.u);
        this.t = vVar;
        this.q.w.setAdapter(vVar);
        int i2 = this.w;
        if (i2 == 604 || i2 == 605) {
            V1();
        } else {
            this.q.k.setVisibility(8);
            L1();
        }
        this.q.x.setOnClickListener(new a());
        this.q.y.setOnClickListener(new b());
        this.q.z.setOnClickListener(new c());
        this.q.i.setOnClickListener(new d());
        this.q.j.setOnClickListener(new e());
        this.q.c.setOnClickListener(new f());
        this.q.e.setOnClickListener(new g());
    }

    public final void L1() {
        if (this.E == null) {
            this.E = bj5.b().c();
        }
        this.E.f(v4.e(com.zenmen.palmchat.c.b()), v4.b(com.zenmen.palmchat.c.b()), xn3.a(), 0L, N1());
    }

    public final void M1() {
        String str = q05.c() + "/square.feed.super.show.sku.list";
        HashMap map = new HashMap();
        map.put("gender", Integer.valueOf(q05.e().getGender() != 1 ? 0 : 1));
        zw4.e(new k(str, map));
    }

    public final tw4<CommonResponse<SquareDynamicLifeResponseBean>> N1() {
        return new l();
    }

    public final void O1(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
        if (squareDynamicLifeBeanInfo.feedType == 1) {
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.uid = squareDynamicLifeBeanInfo.uid;
            squareFeed.feedType = squareDynamicLifeBeanInfo.feedType;
            squareFeed.id = squareDynamicLifeBeanInfo.id;
            squareFeed.exid = squareDynamicLifeBeanInfo.exid;
            squareFeed.content = squareDynamicLifeBeanInfo.content;
            this.x = squareFeed;
        } else {
            SquareFeed squareFeed2 = new SquareFeed();
            squareFeed2.uid = squareDynamicLifeBeanInfo.uid;
            squareFeed2.feedType = squareDynamicLifeBeanInfo.feedType;
            squareFeed2.id = squareDynamicLifeBeanInfo.id;
            squareFeed2.exid = squareDynamicLifeBeanInfo.exid;
            squareFeed2.content = squareDynamicLifeBeanInfo.content;
            Media media = new Media();
            String str = squareDynamicLifeBeanInfo.url;
            media.thumbUrl = str;
            media.url = str;
            ArrayList arrayList = new ArrayList();
            arrayList.add(media);
            squareFeed2.mediaList = arrayList;
            this.x = squareFeed2;
        }
        V1();
    }

    public final void P1() {
        if (H1() != 3) {
            this.q.i.setSelected(false);
            this.q.j.setSelected(true);
            this.q.i.setTextColor(Color.parseColor("#FF222222"));
            this.q.j.setTextColor(Color.parseColor("#FF05D694"));
            this.z = 1;
        } else {
            this.q.i.setSelected(false);
            this.q.j.setSelected(false);
            this.q.i.setTextColor(Color.parseColor("#FF222222"));
            this.q.j.setTextColor(Color.parseColor("#FF222222"));
            this.z = -1;
        }
        if (H1() != 3) {
            if (q05.e().getGender() == 1) {
                this.q.x.setSelected(true);
                this.q.y.setSelected(false);
                this.q.z.setSelected(false);
                this.q.x.setTextColor(Color.parseColor("#FF05D694"));
                this.q.y.setTextColor(Color.parseColor("#FF222222"));
                this.q.z.setTextColor(Color.parseColor("#FF222222"));
                this.y = 0;
            } else {
                this.q.x.setSelected(false);
                this.q.y.setSelected(true);
                this.q.z.setSelected(false);
                this.q.x.setTextColor(Color.parseColor("#FF222222"));
                this.q.y.setTextColor(Color.parseColor("#FF05D694"));
                this.q.z.setTextColor(Color.parseColor("#FF222222"));
                this.y = 1;
            }
            this.q.d.setAlpha(1.0f);
        } else {
            this.q.x.setSelected(false);
            this.q.y.setSelected(false);
            this.q.z.setSelected(false);
            this.q.x.setTextColor(Color.parseColor("#FF222222"));
            this.q.y.setTextColor(Color.parseColor("#FF222222"));
            this.q.z.setTextColor(Color.parseColor("#FF222222"));
            this.y = -1;
            this.q.d.setAlpha(0.6f);
        }
        W1(false);
    }

    public void Q1(ViewGroup viewGroup) {
        viewGroup.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = me1.h(this) + me1.b(this, 48);
        viewGroup.setLayoutParams(layoutParams);
    }

    public void R1() {
        int i2 = -1;
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            if (this.u.get(i3).selected) {
                i2 = i3;
            }
        }
        if (i2 <= -1) {
            this.q.v.setText("0");
            return;
        }
        this.q.v.setText(this.u.get(i2).price + "");
    }

    public final void S1() {
        MaterialDialog materialDialogD = q05.d(this, R.layout.dialog_dynamic_super_expose_buy_success);
        View viewFindViewById = materialDialogD.j().findViewById(R.id.close_layout);
        materialDialogD.j().findViewById(R.id.btn_submit).setOnClickListener(new m(materialDialogD));
        viewFindViewById.setOnClickListener(new n(materialDialogD));
        q05.a("postboost_purchaseSucceed_pop", 1, null);
        materialDialogD.show();
    }

    public final void T1() {
        if (H1() != 1) {
            ry5.a("请选择你要曝光的动态");
            return;
        }
        if (!kj1.b().c().booleanValue()) {
            ry5.a("您当前不支持购买此服务");
            return;
        }
        if (this.y < 0) {
            ry5.a("请选择你要曝光的性别");
            return;
        }
        if (this.z < 0) {
            ry5.a("请选择你要曝光的区域");
            return;
        }
        LocationEx locationExI = q05.i();
        if (this.z == 2) {
            boolean zB = tg4.b(com.zenmen.palmchat.c.b(), com.kuaishou.weapon.p0.g.g);
            boolean zF = com.zenmen.palmchat.location.b.f(com.zenmen.palmchat.c.b());
            b05.d("hasLocation=" + zB);
            b05.d("isSysLocationServiceOpen=" + zF);
            if (!zF) {
                ry5.a("请先开启定位，再来购买此服务吧");
                return;
            } else if (!zB) {
                ry5.a("您还未授权地理位置，无法购买此服务");
                return;
            } else if (locationExI == null) {
                ry5.a("您还未授权地理位置，无法购买此服务");
                return;
            }
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            if (this.u.get(i3).selected) {
                i2 = i3;
            }
        }
        if (i2 < 0) {
            ry5.a("请选择曝光套餐");
            return;
        }
        if (i2 > -1) {
            String str = q05.c() + "/square.feed.super.show.buy";
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(this.w));
            map.put("feedId", Long.valueOf(this.x.getFeedId()));
            map.put("productId", this.u.get(i2).productId);
            map.put("superShowGender", Integer.valueOf(this.y));
            map.put("superShowRange", Integer.valueOf(this.z));
            if (locationExI != null) {
                map.put("cityCode", locationExI.getCityCode());
            } else {
                map.put("cityCode", 0);
            }
            map.put("gender", Integer.valueOf(q05.e().getGender() != 1 ? 0 : 1));
            zw4.e(new j(str, map, i2));
        }
    }

    public void U1() {
        int i2;
        if (this.u != null) {
            i2 = -1;
            for (int i3 = 0; i3 < this.u.size(); i3++) {
                if (this.u.get(i3).selected) {
                    i2 = i3;
                }
            }
        } else {
            i2 = -1;
        }
        if (H1() != 1 || this.y == -1 || this.z == -1 || i2 == -1) {
            this.q.d.setAlpha(0.6f);
        } else {
            this.q.d.setAlpha(1.0f);
        }
    }

    public final void V1() {
        this.v.clear();
        this.q.E.setVisibility(8);
        this.q.t.setVisibility(8);
        this.q.k.setVisibility(0);
        this.q.p.setVisibility(8);
        this.q.o.setVisibility(8);
        this.q.B.setVisibility(8);
        this.q.A.setText("");
        List<Media> list = this.x.mediaList;
        if (list == null || list.size() <= 0) {
            this.q.B.setVisibility(0);
            if (!TextUtils.isEmpty(this.x.getContent())) {
                this.q.B.setText(this.x.getContent());
            }
        } else {
            int iB = a46.b(this, 76.0f);
            int iB2 = a46.b(this, 72.0f);
            this.q.o.setVisibility(0);
            String strG = this.x.mediaList.get(0).thumbUrl;
            if (this.x.feedType == 3) {
                strG = a46.g(iB, iB2, strG);
            }
            hc2.b(this).load(strG).apply(RequestOptions.bitmapTransform(new RoundedCorners(8))).error(R.drawable.icon_default_thumbnail).into(this.q.o);
            if (this.x.getFeedType() == 3 || this.x.getFeedType() == 6) {
                this.q.p.setVisibility(0);
            } else {
                this.q.p.setVisibility(8);
            }
        }
        this.q.k.setOnClickListener(new h());
        if (!TextUtils.isEmpty(this.x.getContent())) {
            this.q.A.setText(this.x.getContent());
        }
        this.q.q.setAvatarView(q05.e().getIconURL(), null);
        if (!TextUtils.isEmpty(q05.e().getNickName())) {
            this.q.s.setText(q05.e().getNickName());
        }
        q05.a("postboost_homepage", 1, new i());
        P1();
    }

    public final void W1(boolean z) {
        List<SquareFeedSuperShowSkuListResult.SkuListBean> list;
        List<SquareFeedSuperShowSkuListResult.SkuListBean> list2;
        if (this.C != null) {
            if (this.z == 2) {
                this.u.clear();
                SquareFeedSuperShowSkuListResult.CityBean cityBean = this.C.city;
                if (cityBean != null && (list2 = cityBean.skuList) != null) {
                    this.u.addAll(list2);
                    if ((H1() == 3 || H1() == -1) && !z) {
                        for (int i2 = 0; i2 < this.u.size(); i2++) {
                            this.u.get(i2).selected = false;
                        }
                    } else {
                        for (int i3 = 0; i3 < this.u.size(); i3++) {
                            if (this.u.get(i3).productId.equals(this.C.city.defaultProductId)) {
                                this.u.get(i3).selected = true;
                            } else {
                                this.u.get(i3).selected = false;
                            }
                        }
                    }
                    R1();
                    this.t.notifyDataSetChanged();
                }
            } else {
                this.u.clear();
                SquareFeedSuperShowSkuListResult.CityBean cityBean2 = this.C.country;
                if (cityBean2 != null && (list = cityBean2.skuList) != null) {
                    this.u.addAll(list);
                    if ((H1() == 3 || H1() == -1) && !z) {
                        for (int i4 = 0; i4 < this.u.size(); i4++) {
                            this.u.get(i4).selected = false;
                        }
                    } else {
                        for (int i5 = 0; i5 < this.u.size(); i5++) {
                            if (this.u.get(i5).productId.equals(this.C.country.defaultProductId)) {
                                this.u.get(i5).selected = true;
                            } else {
                                this.u.get(i5).selected = false;
                            }
                        }
                    }
                    R1();
                    this.t.notifyDataSetChanged();
                }
            }
        }
        U1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityDynamicExposeHomeBinding activityDynamicExposeHomeBindingB = ActivityDynamicExposeHomeBinding.b(getLayoutInflater());
        this.q = activityDynamicExposeHomeBindingB;
        setContentView(activityDynamicExposeHomeBindingB.getRoot());
        this.w = getIntent().getIntExtra("EXTRA_FROM", -1);
        this.x = (SquareFeed) getIntent().getParcelableExtra("EXTRA_FEED");
        if (q05.e() == null) {
            finish();
        }
        K1();
        M1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f15373a;

            public a(int i) {
                this.f15373a = i;
                put("from", Integer.valueOf(DynamicExposeHomeActivity.this.w));
                put("productId", DynamicExposeHomeActivity.this.u.get(i).productId);
                put(OapsKey.KEY_PRICE, Integer.valueOf(DynamicExposeHomeActivity.this.u.get(i).price));
                put("superShowGender", Integer.valueOf(DynamicExposeHomeActivity.this.y));
                put("superShowRange", Integer.valueOf(DynamicExposeHomeActivity.this.z));
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            int i = -1;
            for (int i2 = 0; i2 < DynamicExposeHomeActivity.this.u.size(); i2++) {
                if (DynamicExposeHomeActivity.this.u.get(i2).selected) {
                    i = i2;
                }
            }
            if (i > -1) {
                q05.a("postboost_homepage_buyButton", 2, new a(i));
            }
            DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
            if (dynamicExposeHomeActivity.A) {
                dynamicExposeHomeActivity.T1();
            } else {
                dynamicExposeHomeActivity.r = new SuperExposeAgreementDialog(DynamicExposeHomeActivity.this.sInstance, new b());
                DynamicExposeHomeActivity.this.r.show();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements SuperExposeAgreementDialog.e {
            public b() {
            }

            @Override // com.zenmen.palmchat.square.SuperExposeAgreementDialog.e
            public void onConfirm() {
                DynamicExposeHomeActivity dynamicExposeHomeActivity = DynamicExposeHomeActivity.this;
                dynamicExposeHomeActivity.A = true;
                dynamicExposeHomeActivity.q.f.setSelected(true);
                DynamicExposeHomeActivity.this.T1();
            }

            @Override // com.zenmen.palmchat.square.SuperExposeAgreementDialog.e
            public void onCancel() {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15379a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ int c;

        public j(String str, HashMap map, int i) {
            this.f15379a = str;
            this.b = map;
            this.c = i;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15379a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (q05.o(DynamicExposeHomeActivity.this) || !z || lXBaseNetBean == null) {
                return;
            }
            if (lXBaseNetBean.resultCode == 2006) {
                String strE = of2.e(602, DynamicExposeHomeActivity.this.w, "");
                DynamicExposeHomeActivity.this.R1();
                nb3.k(AppContext.getContext(), strE, DynamicExposeHomeActivity.this.u.get(this.c).price, new a());
                return;
            }
            if (lXBaseNetBean.isSuccess()) {
                DynamicExposeHomeActivity.this.S1();
                ds0.a().b(new hi5());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nb3.c {
            public a() {
            }

            @Override // nb3.c
            public void a(int i, String str, Object obj) {
            }
        }
    }
}
