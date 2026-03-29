package com.zenmen.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.fragment.NestTagFeedsFragment;
import com.zenmen.square.mvp.holder.NestTagHeaderViewHolder;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.ui.widget.NestTagInfoView;
import defpackage.a46;
import defpackage.ai5;
import defpackage.gu;
import defpackage.hc2;
import defpackage.me1;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTagFeedsActivity extends FrameworkBaseActivity implements NestTagFeedsFragment.b {
    public ContactInfoItem q;
    public ImageView r;
    public Toolbar s;
    public View t;
    public NestTagInfoView u;
    public SquareTagBean v;
    public NestTagFeedsFragment w;
    public View x;
    public View y;
    public RecyclerView.OnScrollListener z = new d();
    public View.OnLayoutChangeListener A = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            NestTagFeedsActivity.this.M1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NestTagFeedsActivity.this.M1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((zt1) NestTagFeedsActivity.this.w.e0()).F(NestTagFeedsActivity.this.q, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (NestTagFeedsActivity.this.x == null || NestTagFeedsActivity.this.y == null) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
                if (viewHolderFindViewHolderForAdapterPosition instanceof NestTagHeaderViewHolder) {
                    NestTagHeaderViewHolder nestTagHeaderViewHolder = (NestTagHeaderViewHolder) viewHolderFindViewHolderForAdapterPosition;
                    NestTagFeedsActivity.this.x = nestTagHeaderViewHolder.p().b;
                    NestTagFeedsActivity.this.y = nestTagHeaderViewHolder.p().g;
                    recyclerView.addOnLayoutChangeListener(NestTagFeedsActivity.this.A);
                }
            }
            NestTagFeedsActivity.this.M1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            NestTagFeedsActivity.this.M1();
        }
    }

    public static void L1(Context context, ContactInfoItem contactInfoItem, SquareTagBean squareTagBean, int i) {
        Intent intent = new Intent(context, (Class<?>) NestTagFeedsActivity.class);
        intent.putExtra("key_contact_info", contactInfoItem);
        intent.putExtra("key_square_tag", squareTagBean);
        intent.putExtra("key_scene", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final String I1(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }

    public final void J1() {
        hc2.b(this).load(I1(this.q)).transform(new gu(10, 5)).into(this.r);
    }

    public final void K1() {
        Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, "", true);
        this.s = toolbarInitToolbar;
        toolbarInitToolbar.setNavigationIcon(R$drawable.arrow_back_round_32dp);
        this.s.setBackgroundResource(R$color.color_trans);
        this.s.setPadding(me1.b(this, 10), this.s.getPaddingTop(), 0, 0);
        setSupportActionBar(this.s);
        this.t = findViewById(R$id.rl_second_toolbar);
        NestTagInfoView nestTagInfoView = (NestTagInfoView) findViewById(R$id.rl_tag_tool_bar);
        this.u = nestTagInfoView;
        nestTagInfoView.setSquareTag(this.v);
        this.t.setPadding(0, a46.n(this), 0, 0);
        ((TextView) findViewById(R$id.tv_second_title_name)).setText(this.q.getNameForShow());
        TextView textView = (TextView) findViewById(R$id.btn_second_title_private_chat);
        if (this.q.getIsStranger()) {
            textView.setText(ai5.k().g().getUserHomeChatText(this));
        } else {
            textView.setText(R$string.square_btn_go_normal_chat);
        }
        textView.setOnClickListener(new c());
    }

    public final void M1() {
        View view = this.x;
        if (view == null || this.y == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        O1(iArr[1]);
        int[] iArr2 = new int[2];
        this.y.getLocationOnScreen(iArr2);
        N1(iArr2[1]);
    }

    public final void N1(int i) {
        if (i - this.t.getMeasuredHeight() > 0) {
            this.u.setVisibility(4);
        } else {
            this.u.setVisibility(0);
        }
    }

    public final void O1(int i) {
        int measuredHeight = (i - this.t.getMeasuredHeight()) + this.x.getMeasuredHeight();
        if (measuredHeight > 10) {
            this.t.setVisibility(4);
            this.s.setVisibility(0);
            return;
        }
        this.t.setVisibility(0);
        if (measuredHeight > 0) {
            this.t.setAlpha(1.0f - (measuredHeight / 10.0f));
        } else {
            this.t.setAlpha(1.0f);
        }
        this.s.setVisibility(8);
    }

    @Override // com.zenmen.square.fragment.NestTagFeedsFragment.b
    public void V(SquareTagBean squareTagBean) {
        NestTagInfoView nestTagInfoView = this.u;
        if (nestTagInfoView != null) {
            nestTagInfoView.setSquareTag(squareTagBean);
            this.v = squareTagBean;
        }
    }

    public void onBackClick(View view) {
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.q = (ContactInfoItem) getIntent().getParcelableExtra("key_contact_info");
        this.v = (SquareTagBean) getIntent().getParcelableExtra("key_square_tag");
        setContentView(R$layout.square_layout_activity_nest_tag);
        K1();
        this.r = (ImageView) findViewById(R$id.portrait_blur);
        this.w = new NestTagFeedsFragment();
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        this.w.setArguments(getIntent().getExtras());
        fragmentTransactionBeginTransaction.replace(R$id.rl_nest_tag_list_container, this.w, "NestTagFeedsFragment");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        J1();
        this.w.n(this.z);
        ViewTreeObserver viewTreeObserver = findViewById(R$id.root_view).getViewTreeObserver();
        viewTreeObserver.addOnScrollChangedListener(new a());
        viewTreeObserver.addOnGlobalLayoutListener(new b());
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
