package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.service.MessageAdapter;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.c65;
import defpackage.cn2;
import defpackage.d65;
import defpackage.fn0;
import defpackage.gr2;
import defpackage.qm5;
import defpackage.rb4;
import defpackage.sd3;
import defpackage.v43;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ServiceAccountDetailActivity extends BaseActionBarActivity {
    public cn2 A;
    public MessageAdapter B;
    public MaterialDialog C;
    public i E;
    public TextView q;
    public View r;
    public View s;
    public TextView t;
    public TextView u;
    public RecyclerView v;
    public int w;
    public boolean x;
    public boolean y;
    public ContactInfoItem z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL = bo0.r().l(ServiceAccountDetailActivity.this.z.getChatId());
            if (contactInfoItemL != null) {
                contactInfoItemL.setIdentifyCode(ServiceAccountDetailActivity.this.z.getIdentifyCode());
                ServiceAccountDetailActivity.this.z = contactInfoItemL;
                ServiceAccountDetailActivity serviceAccountDetailActivity = ServiceAccountDetailActivity.this;
                serviceAccountDetailActivity.Z1(d65.c(serviceAccountDetailActivity.z));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c65.a("account_p_b04");
            ServiceAccountDetailActivity.this.W1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ServiceAccountDetailActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            int iComputeVerticalScrollOffset = ServiceAccountDetailActivity.this.v.computeVerticalScrollOffset();
            ServiceAccountDetailActivity.this.S1(iComputeVerticalScrollOffset >= ServiceAccountDetailActivity.this.P1(), false);
            ServiceAccountDetailActivity.this.R1(iComputeVerticalScrollOffset >= ServiceAccountDetailActivity.this.s.getHeight());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ServiceAccountDetailActivity.this.y) {
                c65.c("account_p_b06", ServiceAccountDetailActivity.this.z.getUid());
                ServiceAccountDetailActivity.this.X1();
            } else {
                c65.a("account_p_b02");
                ServiceAccountDetailActivity.this.O1(true);
                ServiceAccountDetailActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements cn2.a {
        public f() {
        }

        @Override // cn2.a
        public void a(rb4 rb4Var) {
            ServiceAccountDetailActivity.this.B.e(rb4Var.f20434a);
            if (rb4Var.b) {
                ServiceAccountDetailActivity.this.B.m(MessageAdapter.LoadMoreStatus.END);
            } else {
                ServiceAccountDetailActivity.this.B.m(MessageAdapter.LoadMoreStatus.COMPLETE);
            }
            ServiceAccountDetailActivity.this.B.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements MessageAdapter.c {
        public g() {
        }

        @Override // com.zenmen.palmchat.contacts.service.MessageAdapter.c
        public void a() {
            ServiceAccountDetailActivity.this.A.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {
        public h() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            c65.c("account_p_b08", ServiceAccountDetailActivity.this.z.getUid());
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ServiceAccountDetailActivity.this.O1(false);
            c65.c("account_p_b10", ServiceAccountDetailActivity.this.z.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends BottomSheetDialog implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13463a;

        public i(Context context) {
            super(context, R.style.ServiceAccountBottomDialog);
            c65.c("account_p_a03", ServiceAccountDetailActivity.this.z.getUid());
            c65.c("account_p_b17", ServiceAccountDetailActivity.this.z.getUid());
            TextView textView = null;
            View viewInflate = getLayoutInflater().inflate(R.layout.layout_service_account_bottom_dialog, (ViewGroup) null);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_top_set);
            this.f13463a = d65.i(ServiceAccountDetailActivity.this.z);
            if (d65.j(ServiceAccountDetailActivity.this.z)) {
                textView2.setOnClickListener(this);
                if (this.f13463a) {
                    textView2.setText(R.string.service_top_unset);
                } else {
                    c65.c("account_p_b11", ServiceAccountDetailActivity.this.z.getUid());
                    textView2.setText(R.string.service_top_set);
                }
                textView = textView2;
            } else {
                textView2.setVisibility(8);
            }
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_settings);
            if (ServiceAccountSettingsActivity.D1(ServiceAccountDetailActivity.this.z)) {
                c65.c("account_p_b15", ServiceAccountDetailActivity.this.z.getUid());
                textView3.setOnClickListener(this);
                if (textView == null) {
                    textView = textView3;
                }
            } else {
                textView3.setVisibility(8);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_change_follow);
            viewInflate.findViewById(R.id.tv_cancel).setOnClickListener(this);
            textView4.setOnClickListener(this);
            if (d65.d(ServiceAccountDetailActivity.this.z)) {
                if (ServiceAccountDetailActivity.this.y) {
                    c65.c("account_p_b13", ServiceAccountDetailActivity.this.z.getUid());
                    textView4.setText(R.string.service_account_unfollow_ok);
                } else {
                    textView4.setText(R.string.service_account_follow);
                }
                if (textView == null) {
                    textView = textView4;
                }
            } else {
                textView4.setVisibility(8);
            }
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.selector_settings_item_background_top_corner15);
            }
            setContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_cancel /* 2131367863 */:
                    c65.c("account_p_b18", ServiceAccountDetailActivity.this.z.getUid());
                    break;
                case R.id.tv_change_follow /* 2131367866 */:
                    if (!ServiceAccountDetailActivity.this.y) {
                        c65.a("account_p_b02");
                        ServiceAccountDetailActivity.this.O1(true);
                        ServiceAccountDetailActivity.this.finish();
                    } else {
                        c65.c("account_p_b14", ServiceAccountDetailActivity.this.z.getUid());
                        ServiceAccountDetailActivity.this.X1();
                    }
                    break;
                case R.id.tv_settings /* 2131368067 */:
                    c65.c("account_p_b16", ServiceAccountDetailActivity.this.z.getUid());
                    ServiceAccountSettingsActivity.G1(getContext(), ServiceAccountDetailActivity.this.z);
                    break;
                case R.id.tv_top_set /* 2131368106 */:
                    if (!this.f13463a) {
                        c65.c("account_p_b12", ServiceAccountDetailActivity.this.z.getUid());
                        d65.n(ServiceAccountDetailActivity.this.z, true);
                    } else {
                        d65.n(ServiceAccountDetailActivity.this.z, false);
                    }
                    break;
            }
            dismiss();
        }
    }

    public static void Y1(Context context, ContactInfoItem contactInfoItem) {
        Intent intent = new Intent(context, (Class<?>) ServiceAccountDetailActivity.class);
        intent.putExtra("key_contact_info", contactInfoItem);
        context.startActivity(intent);
    }

    public final void O1(boolean z) {
        Z1(z);
        if (z) {
            d65.k(this.z, true, null);
            return;
        }
        d65.k(this.z, false, null);
        c65.c("c_follow_uv01", this.z.getUid());
        Q1();
    }

    public final int P1() {
        int i2 = this.w;
        if (i2 > 0) {
            return i2;
        }
        int height = this.u.getHeight();
        float y = this.u.getY();
        float y2 = ((View) this.u.getParent()).getY();
        if (height == 0) {
            return 0;
        }
        int i3 = (int) (height + y + y2);
        this.w = i3;
        return i3;
    }

    public final void Q1() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, MainTabsActivity.class);
        intent.putExtra("new_intent_position", "tab_msg");
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    public final void R1(boolean z) {
        int i2 = z ? 0 : 8;
        if (this.r.getVisibility() != i2) {
            this.r.setVisibility(i2);
        }
    }

    public final void S1(boolean z, boolean z2) {
        if (z != this.x || z2) {
            this.x = z;
            if (z) {
                this.q.setText(this.z.getNickName());
            } else {
                this.q.setText(R.string.add_contact_item_office);
            }
        }
    }

    public final void T1() {
        ContactInfoItem contactInfoItem = this.z;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_service_account_header, (ViewGroup) this.v, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ic_head_portrait);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_service_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_lx_name);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_service_desc);
        gr2.j().h(contactInfoItem.getIconURL(), imageView, bq6.s());
        textView.setText(contactInfoItem.getNickName());
        String introduction = contactInfoItem.getIntroduction();
        if (TextUtils.isEmpty(introduction)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(introduction);
            textView3.setVisibility(0);
        }
        String account = contactInfoItem.getAccount();
        if (TextUtils.isEmpty(account)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(getString(R.string.user_detail_accout, account));
            textView2.setVisibility(0);
        }
        this.u = textView;
        this.s = viewInflate;
        this.t = (TextView) viewInflate.findViewById(R.id.tv_follow_state);
        if (d65.d(contactInfoItem)) {
            boolean zC = d65.c(this.z);
            Z1(zC);
            if (zC) {
                c65.c("account_p_b05", this.z.getUid());
            } else {
                c65.a("account_p_b01");
            }
            this.t.setOnClickListener(new e());
        } else {
            this.t.setVisibility(8);
        }
        this.B.l(viewInflate);
    }

    public final void U1() {
        cn2 cn2VarG = v43.g(this, this.z);
        this.A = cn2VarG;
        cn2VarG.c(new f());
        this.B.n(new g());
        this.A.b();
    }

    public final void V1() {
        this.q = (TextView) findViewById(R.id.top_title);
        this.r = findViewById(R.id.top_divider);
        View viewFindViewById = findViewById(R.id.top_more);
        c65.a("account_p_b03");
        if (ServiceAccountSettingsActivity.D1(this.z) || d65.d(this.z)) {
            viewFindViewById.setOnClickListener(new b());
        } else {
            viewFindViewById.setVisibility(8);
        }
        findViewById(R.id.top_back).setOnClickListener(new c());
        S1(false, true);
        R1(false);
        this.v = (RecyclerView) findViewById(R.id.recycler_view);
        this.B = new MessageAdapter(this, this.z);
        this.v.setLayoutManager(new LinearLayoutManager(this));
        T1();
        this.v.setAdapter(this.B);
        this.v.addOnScrollListener(new d());
        c65.a("account_p01");
    }

    public final void W1() {
        i iVar = this.E;
        if (iVar == null || !iVar.isShowing()) {
            i iVar2 = new i(this);
            this.E = iVar2;
            iVar2.show();
        }
    }

    public final void X1() {
        MaterialDialog materialDialog = this.C;
        if (materialDialog == null || !materialDialog.isShowing()) {
            c65.c("account_p_a03", this.z.getUid());
            c65.c("account_p_b07", this.z.getUid());
            c65.c("account_p_b09", this.z.getUid());
            sd3 sd3Var = new sd3(this);
            sd3Var.k(getString(R.string.service_account_unfollow_title, this.z.getNickName()) + "\n\n" + getString(R.string.service_account_unfollow_content)).N(R.color.Ga).O(R.string.service_account_unfollow_ok).K(R.string.service_account_unfollow_cancel).f(new h());
            MaterialDialog materialDialogE = sd3Var.e();
            this.C = materialDialogE;
            materialDialogE.show();
        }
    }

    public final void Z1(boolean z) {
        this.y = z;
        if (z) {
            this.t.setText(R.string.service_account_has_follow);
            this.t.setTextColor(Color.parseColor("#9B9B9B"));
            this.t.setBackgroundResource(R.drawable.shape_grey_rectangle_corner14);
        } else {
            this.t.setText(R.string.service_account_follow);
            this.t.setTextColor(-1);
            this.t.setBackgroundResource(R.drawable.shape_green_rectangle_corner14);
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.z = (ContactInfoItem) getIntent().getParcelableExtra("key_contact_info");
        setContentView(R.layout.layout_activity_service_account_detail);
        V1();
        U1();
        bo0.r().i().j(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bo0.r().i().l(this);
    }
}
