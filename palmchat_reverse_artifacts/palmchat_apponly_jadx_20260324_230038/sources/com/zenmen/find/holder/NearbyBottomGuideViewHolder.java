package com.zenmen.find.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.iu3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class NearbyBottomGuideViewHolder extends BaseViewHolder<NearByBean, ViewDataBinding, iu3> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((iu3) NearbyBottomGuideViewHolder.this.e).K();
        }
    }

    public NearbyBottomGuideViewHolder(View view) {
        super(view);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ((ViewGroup) this.itemView).addView(LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_square_nearby_bottom_guide, (ViewGroup) this.itemView, false));
        this.itemView.findViewById(R$id.btn_condition).setOnClickListener(new a());
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
    }
}
