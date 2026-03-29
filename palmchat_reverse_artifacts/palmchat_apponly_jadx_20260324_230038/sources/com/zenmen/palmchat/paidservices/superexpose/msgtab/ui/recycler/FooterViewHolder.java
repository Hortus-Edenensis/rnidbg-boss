package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.databinding.NewPeopleMatchLikedLoadingFooterBinding;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import defpackage.hs3;
import defpackage.xo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FooterViewHolder extends BaseRecyclerViewHolder<SuperExposeNumItem> {
    public ItemAdapter f;
    public xo2 g;
    public int h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperExposeNumItem f14870a;

        public a(SuperExposeNumItem superExposeNumItem) {
            this.f14870a = superExposeNumItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14870a.footerStatus = SuperExposeNumItem.FooterStatus.LOADING;
            FooterViewHolder.this.f.notifyDataSetChanged();
            hs3.c(FooterViewHolder.this.g, FooterViewHolder.this.h, FooterViewHolder.this.f.r());
        }
    }

    public FooterViewHolder(Context context, ViewGroup viewGroup, ItemAdapter itemAdapter, xo2 xo2Var, int i) {
        super(NewPeopleMatchLikedLoadingFooterBinding.b(LayoutInflater.from(context), null, false));
        this.f = itemAdapter;
        this.g = xo2Var;
        this.h = i;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void o(SuperExposeNumItem superExposeNumItem, int i) {
        NewPeopleMatchLikedLoadingFooterBinding newPeopleMatchLikedLoadingFooterBinding = (NewPeopleMatchLikedLoadingFooterBinding) this.e;
        SuperExposeNumItem.FooterStatus footerStatus = superExposeNumItem.footerStatus;
        if (footerStatus == SuperExposeNumItem.FooterStatus.LOADING) {
            newPeopleMatchLikedLoadingFooterBinding.c.setVisibility(0);
            newPeopleMatchLikedLoadingFooterBinding.f13913a.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.b.setVisibility(8);
            return;
        }
        if (footerStatus == SuperExposeNumItem.FooterStatus.ERROR) {
            newPeopleMatchLikedLoadingFooterBinding.c.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.f13913a.setVisibility(0);
            newPeopleMatchLikedLoadingFooterBinding.b.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.f13913a.setOnClickListener(new a(superExposeNumItem));
            return;
        }
        if (footerStatus == SuperExposeNumItem.FooterStatus.LOADED_ALL) {
            newPeopleMatchLikedLoadingFooterBinding.c.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.f13913a.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.b.setVisibility(0);
        } else if (footerStatus == SuperExposeNumItem.FooterStatus.LOADED) {
            newPeopleMatchLikedLoadingFooterBinding.c.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.f13913a.setVisibility(8);
            newPeopleMatchLikedLoadingFooterBinding.b.setVisibility(8);
        }
    }
}
