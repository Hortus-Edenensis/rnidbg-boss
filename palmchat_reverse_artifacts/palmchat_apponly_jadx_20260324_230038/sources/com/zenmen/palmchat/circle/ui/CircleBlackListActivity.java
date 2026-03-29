package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.BlackUser;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gr2;
import defpackage.k80;
import defpackage.ry5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleBlackListActivity extends BaseActionBarActivity {
    public GroupInfoItem q;
    public ListView r;
    public c s;
    public TextView t;
    public k80 u;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<ArrayList<BlackUser>>> {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleBlackListActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1010a extends MaterialDialog.e {
            public C1010a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                CircleBlackListActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<BlackUser>> baseResponse) {
            CircleBlackListActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                ry5.a(CircleBlackListActivity.this.getString(R.string.send_failed));
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                if (CircleBlackListActivity.this.u.e(CircleBlackListActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg(), new C1010a())) {
                    return;
                }
                ry5.a(TextUtils.isEmpty(baseResponse.getErrorMsg()) ? CircleBlackListActivity.this.getString(R.string.send_failed) : baseResponse.getErrorMsg());
            } else {
                ArrayList<BlackUser> data = baseResponse.getData();
                CircleBlackListActivity.this.s.f(data);
                CircleBlackListActivity.this.s.notifyDataSetChanged();
                if (CollectionUtils.isEmpty(data)) {
                    CircleBlackListActivity.this.findViewById(R.id.tv_empty).setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13080a;

        public b(List list) {
            this.f13080a = list;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null) {
                ry5.a(CircleBlackListActivity.this.getString(R.string.send_failed));
            } else if (baseResponse.getResultCode() == 0) {
                CircleBlackListActivity.this.s.e(this.f13080a);
            } else {
                if (CircleBlackListActivity.this.u.d(CircleBlackListActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                ry5.a(TextUtils.isEmpty(baseResponse.getErrorMsg()) ? CircleBlackListActivity.this.getString(R.string.send_failed) : baseResponse.getErrorMsg());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<Long> f13081a = new ArrayList();
        public final Context b;
        public List<BlackUser> c;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public EffectiveShapeView f13082a;
            public TextView b;
            public View c;

            public a() {
            }
        }

        public c(Context context) {
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(BlackUser blackUser, View view) {
            if (this.f13081a.contains(Long.valueOf(blackUser.getId()))) {
                this.f13081a.remove(Long.valueOf(blackUser.getId()));
            } else {
                this.f13081a.add(Long.valueOf(blackUser.getId()));
            }
            g();
            notifyDataSetChanged();
        }

        public List<Long> b() {
            return this.f13081a;
        }

        public void e(List<Long> list) {
            if (!CollectionUtils.isEmpty(this.c)) {
                Iterator<BlackUser> it = this.c.iterator();
                while (it.hasNext()) {
                    if (list.contains(Long.valueOf(it.next().getId()))) {
                        it.remove();
                    }
                }
            }
            this.f13081a.clear();
            notifyDataSetChanged();
            g();
        }

        public void f(List<BlackUser> list) {
            this.c = list;
        }

        public final void g() {
            Context context = this.b;
            if (context instanceof CircleBlackListActivity) {
                ((CircleBlackListActivity) context).J1(!CollectionUtils.isEmpty(this.f13081a));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (CollectionUtils.isEmpty(this.c)) {
                return 0;
            }
            return this.c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (CollectionUtils.isEmpty(this.c)) {
                return null;
            }
            return this.c.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.b).inflate(R.layout.item_circle_blacklist_layout, (ViewGroup) null);
                aVar = new a();
                EffectiveShapeView effectiveShapeView = (EffectiveShapeView) view.findViewById(R.id.portrait);
                aVar.f13082a = effectiveShapeView;
                effectiveShapeView.setDegreeForRoundRectangle(10, 10);
                aVar.b = (TextView) view.findViewById(R.id.name);
                aVar.c = view.findViewById(R.id.btn_check);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final BlackUser blackUser = this.c.get(i);
            aVar.b.setText(blackUser.getNickName());
            gr2.j().h(blackUser.getHeadIconUrl(), aVar.f13082a, bq6.s());
            aVar.c.setSelected(this.f13081a.contains(Long.valueOf(blackUser.getId())));
            aVar.c.setOnClickListener(new View.OnClickListener() { // from class: t60
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f20911a.c(blackUser, view2);
                }
            });
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(View view) {
        I1();
    }

    public final void E1() {
        this.q = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
    }

    public final void G1() {
        showBaseProgressBar();
        c70.R().l0(this.q.getGroupId(), new a());
    }

    public final void H1() {
        Toolbar toolbarInitToolbar = initToolbar(0);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(this.q.getNameForShow());
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.t = textView;
        textView.setText("移除");
        this.t.setTextColor(getResources().getColorStateList(R.color.toolbar_btn_text_color_btn));
        this.t.setBackgroundDrawable(null);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: s60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20673a.F1(view);
            }
        });
        this.t.setEnabled(false);
        setSupportActionBar(toolbarInitToolbar);
        ListView listView = (ListView) findViewById(R.id.lv_black_list);
        this.r = listView;
        c cVar = new c(this);
        this.s = cVar;
        listView.setAdapter((ListAdapter) cVar);
    }

    public final void I1() {
        List<Long> listB = this.s.b();
        c70.R().p0(listB, new b(listB));
    }

    public final void J1(boolean z) {
        this.t.setEnabled(z);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_black_list_layout);
        E1();
        H1();
        G1();
        this.u = new k80(this.q);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
