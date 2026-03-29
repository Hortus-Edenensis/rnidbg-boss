package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeList;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.cb0;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.j70;
import defpackage.k86;
import defpackage.l50;
import defpackage.sy5;
import defpackage.wi0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNoteActivity extends BaseActionBarActivity {
    public Toolbar q;
    public ListView r;
    public View s;
    public TextView t;
    public TextView u;
    public g v;
    public String x;
    public GroupInfoItem y;
    public List<CircleNoticeItem> w = new ArrayList();
    public boolean z = false;
    public boolean A = false;
    public boolean B = true;
    public int C = 1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleNoteActivity.this.N1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleNoteActivity.this.N1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Comparator<CircleNoticeItem> {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CircleNoticeItem circleNoticeItem, CircleNoticeItem circleNoticeItem2) {
            if (circleNoticeItem.getToTop() == 1 && circleNoticeItem2.getToTop() != 1) {
                return -1;
            }
            if (circleNoticeItem.getToTop() == 1 || circleNoticeItem2.getToTop() != 1) {
                return Long.compare(circleNoticeItem2.getReleaseTime(), circleNoticeItem.getReleaseTime());
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements dv0<GroupInfoItem> {
        public e() {
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(GroupInfoItem groupInfoItem) {
            CircleNoteActivity.this.y = groupInfoItem;
            if (CircleNoteActivity.this.y == null) {
                CircleNoteActivity.this.finish();
            } else {
                CircleNoteActivity.this.updateViews();
                CircleNoteActivity.this.P1(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse<CircleNoticeList>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13205a;

        public f(boolean z) {
            this.f13205a = z;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleNoticeList> baseResponse) {
            boolean z = false;
            CircleNoteActivity.this.A = false;
            if (baseResponse.getResultCode() != 0) {
                String errorMsg = baseResponse.getErrorMsg();
                CircleNoteActivity circleNoteActivity = CircleNoteActivity.this;
                if (TextUtils.isEmpty(errorMsg)) {
                    errorMsg = CircleNoteActivity.this.getString(R.string.network_error);
                }
                sy5.f(circleNoteActivity, errorMsg, 1).g();
                return;
            }
            CircleNoteActivity.this.z = true;
            CircleNoticeList data = baseResponse.getData();
            List<CircleNoticeItem> detailVOList = data != null ? data.getDetailVOList() : null;
            if (this.f13205a) {
                CircleNoteActivity.this.w.clear();
                CircleNoteActivity.this.C = 2;
            } else {
                CircleNoteActivity.this.C++;
            }
            CircleNoteActivity circleNoteActivity2 = CircleNoteActivity.this;
            if (detailVOList != null && detailVOList.size() >= 10) {
                z = true;
            }
            circleNoteActivity2.B = z;
            if (detailVOList != null) {
                CircleNoteActivity.this.w.addAll(detailVOList);
            }
            CircleNoteActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LayoutInflater f13206a;
        public Context b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CircleNoticeItem f13207a;

            public a(CircleNoticeItem circleNoticeItem) {
                this.f13207a = circleNoticeItem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(CircleNoteActivity.this, CircleNoteDetailActivity.class);
                intent.putExtra(j70.f, this.f13207a);
                intent.putExtra(j70.f18338a, CircleNoteActivity.this.y.getGroupId());
                CircleNoteActivity.this.startActivity(intent);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public EffectiveShapeView f13208a;
            public TextView b;
            public TextView c;
            public TextView d;
            public ImageView e;
            public TextView f;
            public TextView g;
            public View h;
            public TextView i;

            public b() {
            }
        }

        public g(Context context) {
            this.b = context;
            this.f13206a = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CircleNoteActivity.this.w.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return CircleNoteActivity.this.w.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            b bVar;
            if (view == null) {
                bVar = new b();
                viewInflate = this.f13206a.inflate(R.layout.list_item_circle_note, (ViewGroup) null);
                bVar.f13208a = (EffectiveShapeView) viewInflate.findViewById(R.id.groupIconIv);
                bVar.b = (TextView) viewInflate.findViewById(R.id.circle_note_list_content);
                bVar.c = (TextView) viewInflate.findViewById(R.id.circle_note_list_name);
                bVar.e = (ImageView) viewInflate.findViewById(R.id.circle_note_list_img);
                bVar.f = (TextView) viewInflate.findViewById(R.id.circle_note_list_overlay);
                bVar.g = (TextView) viewInflate.findViewById(R.id.circle_note_list_count);
                bVar.d = (TextView) viewInflate.findViewById(R.id.circle_note_list_date);
                bVar.h = viewInflate.findViewById(R.id.ll_circle_note_bottom_opt_block);
                bVar.i = (TextView) viewInflate.findViewById(R.id.circle_note_list_auditing_status);
                viewInflate.setTag(bVar);
            } else {
                viewInflate = view;
                bVar = (b) view.getTag();
            }
            CircleNoticeItem circleNoticeItem = (CircleNoticeItem) CircleNoteActivity.this.w.get(i);
            gr2.j().h(k86.p(circleNoticeItem.getAvatarUrl()), bVar.f13208a, bq6.s());
            bVar.b.setText(circleNoticeItem.getContent());
            bVar.c.setText(circleNoticeItem.getAuthorNickname() != null ? circleNoticeItem.getAuthorNickname() : "");
            String str = new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(circleNoticeItem.getReleaseTime()));
            bVar.d.setText("修改于" + str);
            if (circleNoticeItem.getMediaType() != 1 || TextUtils.isEmpty(circleNoticeItem.getMediaUrl())) {
                bVar.e.setVisibility(8);
            } else {
                bVar.e.setVisibility(0);
                gr2.j().h(k86.p(circleNoticeItem.getMediaUrl()), bVar.e, bq6.s());
            }
            if (circleNoticeItem.getTopChatWindow() == 1) {
                bVar.f.setVisibility(0);
            } else {
                bVar.f.setVisibility(8);
            }
            if (circleNoticeItem.getConfirm() == 1) {
                bVar.g.setText(circleNoticeItem.getConfirmCount() + "人已查收");
            } else {
                bVar.g.setText(circleNoticeItem.getReadCount() + "人已阅读");
            }
            viewInflate.setOnClickListener(new a(circleNoticeItem));
            bVar.h.setVisibility(1 == circleNoticeItem.getConfirm() ? 0 : 8);
            if (1 == circleNoticeItem.getStatus()) {
                bVar.i.setVisibility(0);
                bVar.i.setBackgroundResource(R.drawable.shape_red_round_corner_8dp);
                bVar.i.setText("审核中");
            } else if (3 == circleNoticeItem.getStatus()) {
                bVar.i.setVisibility(0);
                bVar.i.setBackgroundResource(R.drawable.shape_lightred_round_corner_8dp);
                bVar.i.setText("审核失败");
            } else {
                bVar.i.setVisibility(8);
            }
            return viewInflate;
        }
    }

    public final void M1() {
        if (this.r.getLastVisiblePosition() <= this.r.getCount() - 3 || !this.B) {
            return;
        }
        P1(false);
    }

    public final void N1() {
        Intent intent = new Intent();
        intent.setClass(this, CircleEditNoteActivity.class);
        intent.putExtra(j70.f18338a, this.x);
        startActivityForResult(intent, 111);
    }

    public final void O1() {
        c70.R().K(this.x, new e());
    }

    public final synchronized void P1(boolean z) {
        if (this.A) {
            return;
        }
        int i = 1;
        this.A = true;
        cb0 cb0VarC = cb0.c();
        String str = this.x;
        if (!z) {
            i = this.C;
        }
        cb0VarC.e(str, i, 10, new f(z));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_note);
        Toolbar toolbarInitToolbar = initToolbar("");
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_publish_note);
        setSupportActionBar(this.q);
        TextView textView = (TextView) this.q.findViewById(R.id.action_button);
        this.t = textView;
        textView.setTextColor(getResources().getColor(R.color.color_262626));
        this.t.setBackgroundDrawable(null);
        this.t.setText("添加公告");
        this.t.setOnClickListener(new a());
        this.s = findViewById(R.id.layout_circle_note_empty);
        this.r = (ListView) findViewById(R.id.cirle_note_listview);
        g gVar = new g(this);
        this.v = gVar;
        this.r.setAdapter((ListAdapter) gVar);
        TextView textView2 = (TextView) findViewById(R.id.circle_note_create);
        this.u = textView2;
        textView2.setOnClickListener(new b());
        String stringExtra = getIntent().getStringExtra(j70.f18338a);
        this.x = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        } else {
            this.r.setOnScrollListener(new c());
            O1();
        }
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
        P1(true);
    }

    public final void updateViews() {
        GroupInfoItem groupInfoItem = this.y;
        if (groupInfoItem == null) {
            return;
        }
        if (groupInfoItem.getRoleType() == 3) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        } else {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
        }
        if (!this.z) {
            this.s.setVisibility(8);
            this.r.setVisibility(8);
        } else if (this.w.size() <= 0) {
            this.s.setVisibility(0);
            this.r.setVisibility(8);
        } else {
            this.s.setVisibility(8);
            this.r.setVisibility(0);
        }
        Collections.sort(this.w, new d());
        this.v.notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                CircleNoteActivity.this.M1();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
