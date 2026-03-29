package com.zenmen.square.mvp.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.adapter.SquareShareFriendsAdapter;
import com.zenmen.square.bean.SquareFriendBean;
import defpackage.a46;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareFriendViewHolder extends BaseRecyclerViewHolder<SquareFriendBean> {
    public EffectiveShapeView f;
    public TextView g;
    public ImageView h;
    public je1 i;
    public SquareShareFriendsAdapter.a j;
    public SquareFriendBean k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareShareFriendViewHolder.this.k == null || SquareShareFriendViewHolder.this.j == null) {
                return;
            }
            SquareShareFriendViewHolder.this.j.a(SquareShareFriendViewHolder.this.k, SquareShareFriendViewHolder.this.itemView);
        }
    }

    public SquareShareFriendViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.f = (EffectiveShapeView) s(this.f, R$id.portrait);
        this.g = (TextView) s(this.g, R$id.title);
        this.h = (ImageView) s(this.h, R$id.choice);
        this.itemView.setOnClickListener(new a());
        je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
        int i2 = R$drawable.default_portrait;
        this.i = aVarQ.B(i2).A(i2).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i2).r();
    }

    public final View s(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void o(SquareFriendBean squareFriendBean, int i) {
        this.k = squareFriendBean;
        if (squareFriendBean == null) {
            return;
        }
        gr2.j().h(this.k.item.getIconURL(), this.f, a46.l());
        this.g.setText(this.k.item.getNameForShow());
        this.h.setImageResource(this.k.selected ? R$drawable.square_share_selected : R$drawable.square_share_unselected);
    }

    public void u(SquareShareFriendsAdapter.a aVar) {
        this.j = aVar;
    }
}
