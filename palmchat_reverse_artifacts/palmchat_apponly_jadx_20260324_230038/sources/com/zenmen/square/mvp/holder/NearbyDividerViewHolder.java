package com.zenmen.square.mvp.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.bj5;
import defpackage.iu3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearbyDividerViewHolder extends BaseViewHolder<NearByBean, ViewDataBinding, iu3> {
    public TextView f;
    public TextView g;
    public View h;
    public View i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bj5.b().a().G((FrameworkBaseActivity) NearbyDividerViewHolder.this.itemView.getContext());
        }
    }

    public NearbyDividerViewHolder(View view) {
        super(view);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_square_nearby_divider, (ViewGroup) this.itemView, false);
        ((ViewGroup) this.itemView).addView(viewInflate);
        this.f = (TextView) viewInflate.findViewById(R$id.tv_nearby_divider_text1);
        this.g = (TextView) viewInflate.findViewById(R$id.tv_nearby_divider_text2);
        this.h = viewInflate.findViewById(R$id.rl_nearby_empty_view);
        View viewFindViewById = viewInflate.findViewById(R$id.rl_nearby_empty_view_ai_quick_match);
        this.i = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        p(true);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        if (TextUtils.isEmpty(nearByBean.text1)) {
            this.f.setVisibility(8);
        } else {
            this.f.setText(nearByBean.text1);
            this.f.setVisibility(0);
        }
        if (TextUtils.isEmpty(nearByBean.text2)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(String.format("—  %s  —", nearByBean.text2));
            this.g.setVisibility(0);
        }
    }

    public void p(boolean z) {
        if (z) {
            if (bj5.b().a().R()) {
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            } else {
                this.i.setVisibility(8);
                this.h.setVisibility(0);
                return;
            }
        }
        if (bj5.b().a().R()) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(8);
            this.h.setVisibility(8);
        }
    }
}
