package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.NestTagFeedsActivity;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.activity.SquareDetailHalfActivity;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.databinding.LayoutSquareDetailHalfBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.is0;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class lo0 implements sl2<SquareFeed>, fa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SquareDetailHalfActivity f19037a;
    public LayoutSquareDetailHalfBinding b;
    public no0 c;
    public ContactInfoItem d;
    public rq3 f;
    public SquareFeed g;
    public int h;
    public boolean e = false;
    public boolean i = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements is0.f {
        public a() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                return;
            }
            lo0.this.u();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements is0.f {
        public b() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                return;
            }
            zn6.c("pagediscover_feedpagedetail_morepopup_complaint", "click");
            bj5.b().a().z(lo0.this.h(), 901, lo0.this.g.exid, 8, 8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            lo0.this.i().f();
        }
    }

    public lo0(SquareDetailHalfActivity squareDetailHalfActivity) {
        this.f19037a = squareDetailHalfActivity;
        LayoutSquareDetailHalfBinding layoutSquareDetailHalfBinding = (LayoutSquareDetailHalfBinding) DataBindingUtil.setContentView(squareDetailHalfActivity, R$layout.layout_square_detail_half);
        this.b = layoutSquareDetailHalfBinding;
        layoutSquareDetailHalfBinding.p(this);
        this.b.getRoot().setAlpha(0.0f);
        an1.c().p(this);
        this.h = squareDetailHalfActivity.getIntent().getIntExtra("key_from", 0);
    }

    public final void d(SquareFeed squareFeed) {
        this.b.getRoot().setAlpha(1.0f);
        if (this.i) {
            qj5.t(this.h, squareFeed, 1, null, null);
            this.i = false;
        }
        ContactInfoItem contactInfoItemA = dn0.a(squareFeed.getUid());
        this.d = contactInfoItemA;
        if (contactInfoItemA == null) {
            this.d = dn0.b(squareFeed.getExid());
        }
        if (this.d != null) {
            this.e = !r0.getIsStranger();
        }
        this.b.q(squareFeed);
        this.b.executePendingBindings();
        this.g = squareFeed;
        t();
        s();
        k();
    }

    public final void e(View view) {
        a46.C(this.b.l, R$anim.square_click_like_anim);
        qj5.d0((SquareFeed) this.b.o(), 4, this.h, 0);
        i().c();
    }

    public void f() {
        this.f19037a.finish();
    }

    public void g() {
        SquareDetailHalfActivity squareDetailHalfActivity = this.f19037a;
        if (squareDetailHalfActivity != null) {
            squareDetailHalfActivity.finish();
        }
    }

    public Context h() {
        return this.f19037a;
    }

    public final rl2 i() {
        return this.f19037a.B1();
    }

    public void j() {
        this.f19037a.hideSimpleProgressBar();
    }

    public final void k() {
        SquareFeed squareFeed = (SquareFeed) this.b.o();
        squareFeed.businessFrom = 0;
        rq3 rq3Var = this.f;
        if (rq3Var != null) {
            rq3Var.O(squareFeed);
            return;
        }
        rq3 rq3Var2 = new rq3(this.f19037a, (SquareFeed) this.b.o());
        this.f = rq3Var2;
        rq3Var2.F(this.b.getRoot());
        this.f.P(new ResultBean(), this.h, 4);
    }

    public void l(SquareFeed squareFeed) {
        i().i();
        if (squareFeed == null || squareFeed.isEmptyFeed()) {
            this.f19037a.showSimpleProgressBar();
        } else {
            d(squareFeed);
        }
    }

    public void m(SquareTagBean squareTagBean, ContactInfoItem contactInfoItem) {
        if (this.f19037a.isDestroyed()) {
            return;
        }
        j();
        NestTagFeedsActivity.L1(this.f19037a, contactInfoItem, squareTagBean, 4);
    }

    public void n(ContactInfoItem contactInfoItem) {
        SquareFeed squareFeed = (SquareFeed) this.b.o();
        if (contactInfoItem == null) {
            qj5.g0(squareFeed, 0, this.h);
            return;
        }
        String strC = az2.c(SquareFeedForChatCard.parse(squareFeed));
        if (contactInfoItem.getIsStranger()) {
            qj5.g0(squareFeed, 0, this.h);
            bj5.b().a().r(this.f19037a, contactInfoItem, strC);
        } else {
            qj5.g0(squareFeed, 1, this.h);
            bj5.b().a().B(this.f19037a, contactInfoItem, strC);
        }
    }

    public final void o() {
        if (this.h == 16) {
            this.f19037a.finish();
        } else {
            i().h();
        }
    }

    public void onChatBtnClick(View view) {
        i().j();
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        if (i != 1) {
            if (i == 2) {
                r();
            }
        } else {
            int i2 = this.h;
            if (i2 == 6 || i2 == 7) {
                g();
            } else {
                ((xu3) i()).l((SquareFeed) this.b.o());
            }
        }
    }

    public void onMoreBtnClick(View view) {
        zn6.c("pagediscover_feedpagedetail_more", "click");
        a aVar = new a();
        if (TextUtils.equals(this.b.o().getUid(), v4.e(h()))) {
            SquareDetailHalfActivity squareDetailHalfActivity = this.f19037a;
            squareDetailHalfActivity.showPopupMenu(squareDetailHalfActivity, view, new String[]{squareDetailHalfActivity.getString(R$string.delete)}, new int[]{R$drawable.ic_square_media_view_delete}, aVar, null);
        } else {
            SquareDetailHalfActivity squareDetailHalfActivity2 = this.f19037a;
            squareDetailHalfActivity2.showPopupMenu(squareDetailHalfActivity2, view, new String[]{l36.b().getString(R$string.complaint)}, new int[]{R$drawable.ic_square_media_view_complaint}, new b(), null);
        }
    }

    @Override // defpackage.sl2
    public void onViewClick(View view) {
        LayoutSquareDetailHalfBinding layoutSquareDetailHalfBinding;
        if (l50.a() || (layoutSquareDetailHalfBinding = this.b) == null || layoutSquareDetailHalfBinding.o() == null) {
            return;
        }
        LayoutSquareDetailHalfBinding layoutSquareDetailHalfBinding2 = this.b;
        if (view == layoutSquareDetailHalfBinding2.f16226a) {
            i().j();
            return;
        }
        if (view == layoutSquareDetailHalfBinding2.h) {
            o();
        } else if (view == layoutSquareDetailHalfBinding2.b) {
            onMoreBtnClick(view);
        } else if (view == layoutSquareDetailHalfBinding2.p) {
            e(view);
        }
    }

    public void p(SquareFeed squareFeed) {
        this.f19037a.hideSimpleProgressBar();
        d(squareFeed);
    }

    public void q() {
        an1.c().r(this);
    }

    public final void r() {
        if (this.h == 5) {
            this.f19037a.finish();
        } else {
            ((xu3) i()).k();
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void receiveSquareFeedEvent(SquareFeedEvent squareFeedEvent) {
        int i = squareFeedEvent.eventType;
        if (i == 2) {
            if (((SquareFeed) this.b.o()).mergeByNewUpdate(squareFeedEvent.feed)) {
                p((SquareFeed) this.b.o());
            }
        } else if (i == 3 && squareFeedEvent.feed.id == this.g.id) {
            g();
        }
    }

    public final void s() {
        if (this.c != null) {
            return;
        }
        if (this.b.o().getFeedType() == 1) {
            nu5 nu5Var = new nu5(this.b.f);
            this.c = nu5Var;
            nu5Var.d(this);
        }
        no0 no0Var = this.c;
        if (no0Var != null) {
            no0Var.a(this.b.o());
        }
    }

    public final void t() {
        this.b.h.setBorderColor(Color.parseColor("#ffffff"));
        gr2.j().h(k86.p(this.b.o().getAvatar()), this.b.h, a46.l());
        LayoutSquareDetailHalfBinding layoutSquareDetailHalfBinding = this.b;
        layoutSquareDetailHalfBinding.d.setText(cy5.h(layoutSquareDetailHalfBinding.o().getCreateTime()));
        if (this.b.o().canDelete()) {
            this.b.f16226a.setVisibility(8);
        } else {
            this.b.f16226a.setVisibility(0);
            this.b.f16226a.setText(this.e ? this.f19037a.getString(R$string.square_btn_go_normal_chat) : ai5.k().g().getSquareChatText(this.b.f16226a.getContext()));
        }
        int iH = fg6.h(this.g.userExt);
        if (this.g.official) {
            this.b.z.setVisibility(0);
            this.b.r.setTextColor(this.f19037a.getResources().getColor(R$color.Gg));
        } else {
            this.b.z.setVisibility(8);
            this.b.r.setTextColor(fg6.n(h(), iH));
        }
        if (!fg6.q(iH)) {
            this.b.m.setVisibility(8);
        } else {
            this.b.m.setImageResource(fg6.e(iH));
            this.b.m.setVisibility(0);
        }
    }

    public final void u() {
        new sd3(this.f19037a).U("提示").k("确定删除吗？").N(com.zenmen.palmchat.friendcircle.R$color.gen_dialogPositiveColor).L("取消").P("确定").f(new c()).e().show();
    }

    public void v() {
        this.f19037a.showSimpleProgressBar();
    }

    public void w(String str) {
        sy5.f(this.f19037a, str, 0).g();
    }
}
