package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleMemberItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.cb0;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.j70;
import defpackage.k80;
import defpackage.k86;
import defpackage.l50;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.wi0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNoteDetailActivity extends BaseActionBarActivity {
    public g A;
    public String B;
    public long C;
    public CircleNoticeItem E;
    public GroupInfoItem F;
    public List<ContactInfoItem> G;
    public int H = 0;
    public View I;
    public TextView J;
    public k80 K;
    public ImageView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public View v;
    public View w;
    public TextView x;
    public TextView y;
    public RecyclerView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || CircleNoteDetailActivity.this.H == 0) {
                return;
            }
            CircleNoteDetailActivity.this.H = 0;
            CircleNoteDetailActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || CircleNoteDetailActivity.this.H == 1) {
                return;
            }
            CircleNoteDetailActivity.this.H = 1;
            CircleNoteDetailActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                if (baseResponse.getResultCode() == 0) {
                    CircleNoteDetailActivity.this.hideBaseProgressBar();
                    CircleNoteDetailActivity.this.finish();
                } else {
                    CircleNoteDetailActivity.this.hideBaseProgressBar();
                    CircleNoteDetailActivity.this.K.d(CircleNoteDetailActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg());
                }
            }
        }

        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            CircleNoteDetailActivity.this.showBaseProgressBar();
            cb0.c().b(CircleNoteDetailActivity.this.B, CircleNoteDetailActivity.this.C, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<CircleNoticeItem>> {
        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleNoticeItem> baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                CircleNoteDetailActivity.this.E = baseResponse.getData();
                CircleNoteDetailActivity.this.updateViews();
            } else {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    return;
                }
                ry5.a(baseResponse.getErrorMsg());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements dv0<GroupInfoItem> {
        public e() {
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(GroupInfoItem groupInfoItem) {
            CircleNoteDetailActivity.this.F = groupInfoItem;
            CircleNoteDetailActivity.this.O1();
            CircleNoteDetailActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements dv0<List<ContactInfoItem>> {
        public f() {
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(List<ContactInfoItem> list) {
            if (list != null) {
                CircleNoteDetailActivity.this.G = list;
                CircleNoteDetailActivity.this.Q1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends RecyclerView.Adapter<a> {
        public Context e;
        public List<ContactInfoItem> f;

        /* JADX INFO: compiled from: SearchBox */
        public static class a extends RecyclerView.ViewHolder {
            public EffectiveShapeView d;
            public TextView e;

            public a(View view) {
                super(view);
                this.d = (EffectiveShapeView) view.findViewById(R.id.avatar);
                this.e = (TextView) view.findViewById(R.id.name);
            }
        }

        public g(Context context, List<ContactInfoItem> list) {
            this.e = context;
            this.f = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i) {
            if (i < 0 || i >= this.f.size()) {
                return;
            }
            gr2.j().h(k86.p(this.f.get(i).getIconURL()), aVar.d, bq6.s());
            aVar.e.setText(this.f.get(i).getNameForShow());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(this.e).inflate(R.layout.layout_item_circle_note_member, viewGroup, false));
        }

        public void c(List<ContactInfoItem> list) {
            this.f = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(View view) {
        P1();
    }

    public final void N1() {
        cb0.c().d(this.B, this.C, new d());
        if (this.F == null) {
            c70.R().K(this.B, new e());
        }
    }

    public final void O1() {
        c70.R().M(this.B, new f());
    }

    public final void P1() {
        new sd3(this).k("是否删除该公告？").O(R.string.dialog_confirm).K(R.string.sr_cancel_str).h(false).f(new c()).e().show();
    }

    public final void Q1() {
        boolean z;
        if (this.G == null || this.E == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ContactInfoItem contactInfoItem : this.G) {
            if (this.E.getMembersList() != null) {
                Iterator<CircleMemberItem> it = this.E.getMembersList().iterator();
                while (it.hasNext()) {
                    if (contactInfoItem.getUid().equals(it.next().getId())) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            int i = this.H;
            if ((i == 0 && z) || (i == 1 && !z)) {
                arrayList.add(contactInfoItem);
            }
        }
        this.A.c(arrayList);
    }

    public final void R1() {
        if (this.H == 0) {
            findViewById(R.id.bg_circle_note_gap).setVisibility(this.E.getReadCount() <= 0 ? 8 : 0);
            this.x.setTextColor(Color.parseColor("#222222"));
            this.y.setTextColor(Color.parseColor("#666666"));
        } else {
            findViewById(R.id.bg_circle_note_gap).setVisibility(this.G.size() - this.E.getReadCount() <= 0 ? 8 : 0);
            this.y.setTextColor(Color.parseColor("#222222"));
            this.x.setTextColor(Color.parseColor("#666666"));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 111 && intent != null && i2 == -1) {
            this.E = (CircleNoticeItem) intent.getParcelableExtra(j70.f);
            updateViews();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_note_detail);
        setSupportActionBar(initToolbar("公告详情"));
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.J = textView;
        textView.setTextColor(getResources().getColor(R.color.color_262626));
        this.J.setBackgroundDrawable(null);
        this.J.setText(R.string.delete);
        this.J.setVisibility(8);
        this.J.setOnClickListener(new View.OnClickListener() { // from class: za0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22384a.M1(view);
            }
        });
        this.E = (CircleNoticeItem) getIntent().getParcelableExtra(j70.f);
        this.C = getIntent().getLongExtra(j70.g, -1L);
        String stringExtra = getIntent().getStringExtra(j70.f18338a);
        this.B = stringExtra;
        if (this.E == null && this.C == -1) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        CircleNoticeItem circleNoticeItem = this.E;
        if (circleNoticeItem != null) {
            this.C = circleNoticeItem.getNoticeId();
        }
        this.q = (ImageView) findViewById(R.id.layout_circle_notedetail_head);
        this.r = (TextView) findViewById(R.id.layout_circle_notedetail_name);
        this.s = (TextView) findViewById(R.id.layout_circle_notedetail_time);
        this.t = (TextView) findViewById(R.id.layout_circle_notedetail_content);
        this.u = (ImageView) findViewById(R.id.layout_circle_notedetail_img);
        this.v = findViewById(R.id.layout_circle_notedetail_divider);
        this.w = findViewById(R.id.layout_circle_notedetail_tab);
        this.x = (TextView) findViewById(R.id.layout_circle_notedetail_confirm);
        this.y = (TextView) findViewById(R.id.layout_circle_notedetail_not_confirm);
        this.z = (RecyclerView) findViewById(R.id.layout_circle_notedetail_list);
        this.I = findViewById(R.id.circle_note_edit_btn);
        this.z.setLayoutManager(new GridLayoutManager(this, 6));
        g gVar = new g(this, new ArrayList());
        this.A = gVar;
        this.z.setAdapter(gVar);
        this.x.setOnClickListener(new a());
        this.y.setOnClickListener(new b());
        updateViews();
        N1();
        this.K = new k80(this.B);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void toEditCircleNote(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CircleEditNoteActivity.class);
        intent.putExtra(j70.f18338a, this.B);
        intent.putExtra(j70.f, this.E);
        startActivityForResult(intent, 111);
    }

    public final void updateViews() {
        CircleNoticeItem circleNoticeItem = this.E;
        if (circleNoticeItem == null || this.F == null) {
            return;
        }
        this.r.setText(circleNoticeItem.getAuthorNickname() != null ? this.E.getAuthorNickname() : "");
        gr2.j().h(k86.p(this.E.getAvatarUrl()), this.q, bq6.s());
        String str = new SimpleDateFormat("yyyy.M.d HH:mm").format(Long.valueOf(this.E.getReleaseTime()));
        this.s.setText("修改于" + str);
        if (TextUtils.isEmpty(this.E.getContent())) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(this.E.getContent());
            this.t.setVisibility(0);
        }
        if (this.E.getMediaType() != 1 || TextUtils.isEmpty(this.E.getMediaUrl())) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
            gr2.j().h(k86.p(this.E.getMediaUrl()), this.u, bq6.s());
        }
        this.v.setVisibility((this.t.getVisibility() == 0 && this.u.getVisibility() == 0) ? 0 : 8);
        if (this.F.getRoleType() == 3 || this.G == null || this.E.getConfirm() == 0) {
            this.w.setVisibility(8);
            this.z.setVisibility(8);
            findViewById(R.id.bg_circle_note_gap).setVisibility(8);
            findViewById(R.id.circle_notice_bottom_divider).setVisibility(8);
        } else {
            this.w.setVisibility(0);
            this.z.setVisibility(0);
            this.x.setText(this.E.getReadCount() + "人已阅读");
            this.y.setText((this.G.size() - this.E.getReadCount()) + "人未阅读");
        }
        this.J.setVisibility(this.F.getRoleType() == 3 ? 8 : 0);
        this.I.setVisibility(this.F.getRoleType() == 3 ? 8 : 0);
        R1();
        Q1();
        CircleNoticeItem.markLocalShownStatus(this.E.getNoticeId());
    }
}
