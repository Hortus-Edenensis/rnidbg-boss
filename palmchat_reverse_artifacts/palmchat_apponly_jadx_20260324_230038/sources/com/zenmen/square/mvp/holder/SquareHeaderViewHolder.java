package com.zenmen.square.mvp.holder;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.R$drawable;
import com.zenmen.square.databinding.SquareInteractHeaderBinding;
import com.zenmen.square.dynamiclife.DynamicSuperExposeV1Config;
import com.zenmen.square.mvp.model.bean.SquareBean;
import com.zenmen.square.mvp.model.bean.SquareUserPostStatisticsBean;
import defpackage.bj5;
import defpackage.kj1;
import defpackage.q05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareHeaderViewHolder extends BaseViewHolder<SquareBean, SquareInteractHeaderBinding, com.zenmen.listui.list.a> {
    public DynamicSuperExposeV1Config f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f16446a;
        public final /* synthetic */ String b;

        public a(String[] strArr, String str) {
            this.f16446a = strArr;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            this.f16446a[0] = q05.h(((SquareInteractHeaderBinding) SquareHeaderViewHolder.this.d).m, this.f16446a[0]);
            TextView textView = ((SquareInteractHeaderBinding) SquareHeaderViewHolder.this.d).m;
            SpannableString spannableString = new SpannableString(this.f16446a[0]);
            int color = Color.parseColor("#14CD64");
            if (this.f16446a[0].contains(this.b + "%")) {
                str = this.b + "%";
            } else {
                str = this.b;
            }
            q05.B(textView, spannableString, color, str, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_interactSummary", 2, null);
            bj5.b().a().K(SquareHeaderViewHolder.this.itemView.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS, null);
        }
    }

    public SquareHeaderViewHolder(View view) {
        super(view);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        SquareInteractHeaderBinding squareInteractHeaderBindingB = SquareInteractHeaderBinding.b(((Activity) this.itemView.getContext()).getLayoutInflater(), (ViewGroup) this.itemView, false);
        this.d = squareInteractHeaderBindingB;
        ((ViewGroup) this.itemView).addView(squareInteractHeaderBindingB.getRoot());
        this.f = kj1.b().a();
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(SquareBean squareBean, int i) {
        SquareUserPostStatisticsBean squareUserPostStatisticsBean = squareBean.squareUserPostStatisticsBean;
        if (squareUserPostStatisticsBean != null) {
            ((SquareInteractHeaderBinding) this.d).j.setText(r(squareUserPostStatisticsBean.showCount));
            ((SquareInteractHeaderBinding) this.d).n.setText(r(squareBean.squareUserPostStatisticsBean.showChainBase));
            ((SquareInteractHeaderBinding) this.d).k.setText(r(squareBean.squareUserPostStatisticsBean.likeCount));
            ((SquareInteractHeaderBinding) this.d).o.setText(r(squareBean.squareUserPostStatisticsBean.likeChainBase));
            ((SquareInteractHeaderBinding) this.d).l.setText(r(squareBean.squareUserPostStatisticsBean.commentCount));
            ((SquareInteractHeaderBinding) this.d).p.setText(r(squareBean.squareUserPostStatisticsBean.commentChainBase));
            int i2 = squareBean.squareUserPostStatisticsBean.showChainBase;
            if (i2 > 0) {
                ((SquareInteractHeaderBinding) this.d).g.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).d.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).d.setBackgroundResource(R$drawable.super_expose_v2_up_bg);
                ((SquareInteractHeaderBinding) this.d).n.setVisibility(0);
            } else if (i2 < 0) {
                ((SquareInteractHeaderBinding) this.d).g.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).d.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).d.setBackgroundResource(R$drawable.super_expose_v2_down_bg);
                ((SquareInteractHeaderBinding) this.d).n.setVisibility(0);
            } else {
                ((SquareInteractHeaderBinding) this.d).g.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).d.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).n.setVisibility(8);
            }
            int i3 = squareBean.squareUserPostStatisticsBean.likeChainBase;
            if (i3 > 0) {
                ((SquareInteractHeaderBinding) this.d).h.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).e.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).e.setBackgroundResource(R$drawable.super_expose_v2_up_bg);
                ((SquareInteractHeaderBinding) this.d).o.setVisibility(0);
            } else if (i3 < 0) {
                ((SquareInteractHeaderBinding) this.d).h.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).e.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).e.setBackgroundResource(R$drawable.super_expose_v2_down_bg);
                ((SquareInteractHeaderBinding) this.d).o.setVisibility(0);
            } else {
                ((SquareInteractHeaderBinding) this.d).h.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).e.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).o.setVisibility(8);
            }
            int i4 = squareBean.squareUserPostStatisticsBean.commentChainBase;
            if (i4 > 0) {
                ((SquareInteractHeaderBinding) this.d).i.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).f.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).f.setBackgroundResource(R$drawable.super_expose_v2_up_bg);
                ((SquareInteractHeaderBinding) this.d).p.setVisibility(0);
            } else if (i4 < 0) {
                ((SquareInteractHeaderBinding) this.d).i.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).f.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).f.setBackgroundResource(R$drawable.super_expose_v2_down_bg);
                ((SquareInteractHeaderBinding) this.d).p.setVisibility(0);
            } else {
                ((SquareInteractHeaderBinding) this.d).i.setVisibility(0);
                ((SquareInteractHeaderBinding) this.d).f.setVisibility(8);
                ((SquareInteractHeaderBinding) this.d).p.setVisibility(8);
            }
            String[] strArr = {""};
            String str = String.format("%.1f", Double.valueOf(squareBean.squareUserPostStatisticsBean.sort));
            DynamicSuperExposeV1Config dynamicSuperExposeV1Config = this.f;
            if (dynamicSuperExposeV1Config != null) {
                ((SquareInteractHeaderBinding) this.d).b.setText(dynamicSuperExposeV1Config.getPost_interact_button_text());
                strArr[0] = this.f.getPost_interact_exceed_text().replace("s", str + "%");
            } else {
                ((SquareInteractHeaderBinding) this.d).b.setText("立即曝光");
                strArr[0] = "超过了s的用户，上推荐提升曝光".replace("s", str + "%");
            }
            ((SquareInteractHeaderBinding) this.d).m.post(new a(strArr, str));
            ((SquareInteractHeaderBinding) this.d).f16239a.setOnClickListener(new b());
            q05.n(((SquareInteractHeaderBinding) this.d).c, "super_expose_v2_hot.svga");
        }
    }

    public String r(int i) {
        int iAbs = Math.abs(i);
        return iAbs <= 999 ? String.valueOf(iAbs) : iAbs <= 9999 ? String.format("%.1fk", Double.valueOf(((double) iAbs) / 1000.0d)) : String.format("%.1fw", Double.valueOf(((double) iAbs) / 10000.0d));
    }
}
