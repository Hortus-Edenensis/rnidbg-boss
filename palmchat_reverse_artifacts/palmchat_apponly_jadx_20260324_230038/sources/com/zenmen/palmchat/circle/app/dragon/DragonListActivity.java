package com.zenmen.palmchat.circle.app.dragon;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.widget.adapters.EndlessScrollListener;
import defpackage.j70;
import defpackage.lg1;
import defpackage.pc0;
import defpackage.pr2;
import defpackage.ry5;
import defpackage.td3;
import defpackage.w86;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DragonListActivity extends BaseActionBarActivity {
    public EndlessScrollListener A;
    public Toolbar q;
    public TextView r;
    public String s;
    public View t;
    public RecyclerView u;
    public f v;
    public String x;
    public SwipeRefreshLayout z;
    public List<DragonItem> w = new ArrayList();
    public int y = 0;
    public boolean B = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragonListActivity.this.S1(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements EndlessScrollListener.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void a(int i) {
            Log.d(BaseActionBarActivity.TAG, "onShowError() called with: pageNumber = [" + i + "]");
            DragonListActivity.this.v.g();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void b() {
            Log.d(BaseActionBarActivity.TAG, "onNoMorePages() called");
            DragonListActivity.this.v.i();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void c(int i) {
            Log.d(BaseActionBarActivity.TAG, "onLoadMore() called with: pageNumber = [" + i + "]");
            if (DragonListActivity.this.B) {
                return;
            }
            DragonListActivity dragonListActivity = DragonListActivity.this;
            int i2 = dragonListActivity.y + 1;
            dragonListActivity.y = i2;
            dragonListActivity.R1(i2);
            DragonListActivity.this.v.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragonListActivity.this.S1(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<DragonListVO>> {
        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DragonListVO> baseResponse) {
            DragonListActivity.this.B = false;
            DragonListActivity.this.z.setRefreshing(false);
            if (DragonListActivity.this.y == 1) {
                if (baseResponse == null || baseResponse.getData() == null || CollectionUtils.isEmpty(baseResponse.getData().getJielongVOList())) {
                    DragonListActivity.this.t.setVisibility(0);
                    DragonListActivity.this.u.setVisibility(8);
                    return;
                }
                DragonListActivity.this.t.setVisibility(8);
                DragonListActivity.this.u.setVisibility(0);
                DragonListActivity.this.w = baseResponse.getData().getJielongVOList();
                DragonListActivity.this.A.b();
                DragonListActivity.this.v.notifyDataSetChanged();
                return;
            }
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                DragonListActivity.this.A.c(DragonListActivity.this.y);
                return;
            }
            if (CollectionUtils.isEmpty(baseResponse.getData().getJielongVOList())) {
                DragonListActivity.this.A.a();
                return;
            }
            ArrayList<DragonItem> jielongVOList = baseResponse.getData().getJielongVOList();
            if (jielongVOList.size() < 10) {
                DragonListActivity.this.A.a();
            }
            DragonListActivity.this.w.addAll(jielongVOList);
            DragonListActivity.this.v.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragonItem f13009a;
        public final /* synthetic */ int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f13010a;

            public a(boolean z) {
                this.f13010a = z;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                if (baseResponse != null) {
                    if (baseResponse.getResultCode() != 0) {
                        ry5.a(baseResponse.getErrorMsg());
                        return;
                    }
                    ry5.a(DragonListActivity.this.getString(R.string.send_success));
                    if (!this.f13010a) {
                        e.this.f13009a.setToTop(0);
                        Collections.sort(DragonListActivity.this.w, new DragonItem.b());
                        DragonListActivity.this.v.notifyDataSetChanged();
                    } else {
                        e.this.f13009a.setToTop(1);
                        DragonListActivity.this.w.remove(e.this.b);
                        DragonListActivity.this.w.add(0, e.this.f13009a);
                        DragonListActivity.this.v.notifyDataSetChanged();
                    }
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends wi0<BaseResponse> {
            public b() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                DragonListActivity.this.hideBaseProgressBar();
                if (baseResponse == null || baseResponse.getResultCode() != 0) {
                    ry5.a(baseResponse == null ? DragonListActivity.this.getString(R.string.send_failed) : baseResponse.getErrorMsg());
                    return;
                }
                DragonListActivity.this.w.remove(e.this.f13009a);
                DragonListActivity.this.v.notifyDataSetChanged();
                if (DragonListActivity.this.w.size() == 0) {
                    DragonListActivity.this.t.setVisibility(0);
                    DragonListActivity.this.u.setVisibility(8);
                }
            }
        }

        public e(DragonItem dragonItem, int i) {
            this.f13009a = dragonItem;
            this.b = i;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            boolean z = false;
            if (i == 0) {
                if (this.f13009a.getToTop() == 1) {
                    this.f13009a.optoptime = 0L;
                } else {
                    this.f13009a.optoptime = System.currentTimeMillis();
                    z = true;
                }
                lg1.c().n(this.f13009a, z, new a(z));
                return;
            }
            if (i == 1) {
                DragonListActivity.this.showBaseProgressBar("正在处理", false);
                lg1 lg1VarC = lg1.c();
                DragonItem dragonItem = this.f13009a;
                lg1VarC.a(dragonItem.groupId, dragonItem.dragonId, new b());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public LayoutInflater e;
        public Context f;
        public boolean g = true;
        public boolean h = false;
        public boolean i = false;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DragonItem f13012a;
            public final /* synthetic */ int b;

            public a(DragonItem dragonItem, int i) {
                this.f13012a = dragonItem;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DragonListActivity.this.W1(this.f13012a, this.b);
            }
        }

        public f(Context context) {
            this.f = context;
            this.e = LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean d(int i, View view) {
            DragonListActivity dragonListActivity = DragonListActivity.this;
            dragonListActivity.W1((DragonItem) dragonListActivity.w.get(i), i);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i, View view) {
            DragonItem dragonItem = (DragonItem) DragonListActivity.this.w.get(i);
            Intent intent = new Intent();
            intent.setClass(DragonListActivity.this, DragonJoinActivity.class);
            intent.putExtra(j70.b, DragonListActivity.this.x);
            intent.putExtra(j70.e, dragonItem);
            DragonListActivity.this.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view) {
            if (this.h) {
                DragonListActivity.this.V1();
            }
        }

        public void g() {
            this.h = true;
            this.g = false;
            this.i = false;
            notifyItemChanged(DragonListActivity.this.w.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DragonListActivity.this.w.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == DragonListActivity.this.w.size() ? 2 : 1;
        }

        public void h() {
            this.g = true;
            this.h = false;
            this.i = false;
            notifyItemChanged(DragonListActivity.this.w.size());
        }

        public void i() {
            this.i = true;
            this.g = false;
            this.h = false;
            notifyItemChanged(DragonListActivity.this.w.size());
        }

        public void j() {
            this.g = true;
            this.h = false;
            this.i = false;
            notifyItemChanged(DragonListActivity.this.w.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            if (getItemViewType(i) != 1) {
                h hVar = (h) viewHolder;
                if (this.g) {
                    hVar.m();
                }
                if (this.h) {
                    hVar.l();
                    hVar.d.setOnClickListener(new View.OnClickListener() { // from class: tg1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f20981a.f(view);
                        }
                    });
                }
                if (this.i) {
                    hVar.n();
                    return;
                }
                return;
            }
            g gVar = (g) viewHolder;
            if (gVar != null) {
                DragonItem dragonItem = (DragonItem) DragonListActivity.this.w.get(i);
                gVar.e.setText(dragonItem.publisherName);
                gVar.f.setText(pc0.b(dragonItem.publishTime));
                gVar.j.setText("" + dragonItem.joinCount + "人已参与");
                gVar.k.setVisibility(i == DragonListActivity.this.w.size() - 1 ? 8 : 0);
                if (dragonItem.getToTop() == 1) {
                    SpannableString spannableString = new SpannableString(" " + dragonItem.content);
                    Drawable drawable = DragonListActivity.this.getResources().getDrawable(R.drawable.circle_dragon_top);
                    drawable.setBounds(0, 0, w86.a(this.f, 37.0f), w86.a(this.f, 17.0f));
                    spannableString.setSpan(new pr2(drawable, 0, w86.a(this.f, 12.0f)), 0, 1, 33);
                    gVar.d.setText(spannableString);
                } else {
                    gVar.d.setText(dragonItem.content);
                }
                if (dragonItem.joinCount == 0) {
                    gVar.j.setText("还无人参与");
                }
                gVar.h.setOnClickListener(new a(dragonItem, i));
                if (dragonItem.type == 1) {
                    gVar.i.setImageResource(R.drawable.circle_common_dragon);
                }
                if (dragonItem.type == 2) {
                    gVar.i.setImageResource(R.drawable.circle_words_dragon);
                }
                gVar.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: rg1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f20464a.d(i, view);
                    }
                });
                gVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: sg1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f20735a.e(i, view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return i == 1 ? new g(this.e.inflate(R.layout.list_item_circle_dragon, (ViewGroup) null)) : new h(this.e.inflate(R.layout.layout_rv_loading_more_footer, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends RecyclerView.ViewHolder {
        public TextView d;
        public TextView e;
        public TextView f;
        public ImageView g;
        public RelativeLayout h;
        public ImageView i;
        public TextView j;
        public View k;

        public g(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.circle_dragon_list_content);
            this.e = (TextView) view.findViewById(R.id.circle_dragon_list_name);
            this.h = (RelativeLayout) view.findViewById(R.id.circle_dragon_list_downarrow);
            this.i = (ImageView) view.findViewById(R.id.circle_dragon_list_type);
            this.j = (TextView) view.findViewById(R.id.circle_dragon_list_count);
            this.f = (TextView) view.findViewById(R.id.circle_dragon_list_date);
            this.g = (ImageView) view.findViewById(R.id.circle_dragon_list_top);
            this.k = view.findViewById(R.id.circle_dragon_view_line_divider);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h extends RecyclerView.ViewHolder {
        public TextView d;
        public ProgressBar e;

        public h(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.tv_refreshing_indicator);
            this.e = (ProgressBar) view.findViewById(R.id.pb_loading);
        }

        public void l() {
            this.d.setText("加载失败，点击重试");
            this.e.setVisibility(8);
        }

        public void m() {
            this.d.setText(R.string.loading_more);
            this.e.setVisibility(0);
        }

        public void n() {
            this.d.setText("没有更多了~");
            this.e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1() {
        this.y = 1;
        R1(1);
        this.A.e();
        this.v.j();
    }

    public final void R1(int i) {
        this.B = true;
        lg1.c().g(this.s, true, i, new d());
    }

    public final void S1(DragonItem dragonItem) {
        Intent intent = new Intent();
        intent.setClass(this, DragonCreatorActivity.class);
        intent.putExtra(j70.b, this.x);
        if (dragonItem != null) {
            intent.putExtra(j70.e, dragonItem);
        }
        intent.putExtra(j70.f18338a, this.s);
        startActivity(intent);
    }

    public final void U1() {
        f fVar = this.v;
        if (fVar != null) {
            fVar.h();
        }
        this.y = 1;
        R1(1);
    }

    public final void V1() {
        R1(this.y);
        this.A.f();
        this.v.i();
    }

    public final void W1(DragonItem dragonItem, int i) {
        td3.c cVar = new td3.c(this);
        String[] strArr = new String[2];
        strArr[0] = dragonItem.getToTop() == 1 ? "取消置顶" : "群接龙置顶";
        strArr[1] = "删除群接龙";
        cVar.c(strArr).d(new e(dragonItem, i)).a().b();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_dragon_list);
        Toolbar toolbarInitToolbar = initToolbar("");
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("群接龙");
        setSupportActionBar(this.q);
        TextView textView = (TextView) this.q.findViewById(R.id.action_button);
        this.r = textView;
        textView.setText("新建");
        this.r.setOnClickListener(new a());
        this.s = getIntent().getStringExtra(j70.f18338a);
        this.t = findViewById(R.id.layout_circle_dragon_empty);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        this.z = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: qg1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f20245a.T1();
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cirle_dragon_listview);
        this.u = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.u;
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(new b());
        this.A = endlessScrollListener;
        recyclerView2.addOnScrollListener(endlessScrollListener);
        f fVar = new f(this);
        this.v = fVar;
        this.u.setAdapter(fVar);
        ((TextView) findViewById(R.id.circle_dragon_create)).setOnClickListener(new c());
        this.x = AccountUtils.p(AppContext.getContext());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        U1();
    }
}
