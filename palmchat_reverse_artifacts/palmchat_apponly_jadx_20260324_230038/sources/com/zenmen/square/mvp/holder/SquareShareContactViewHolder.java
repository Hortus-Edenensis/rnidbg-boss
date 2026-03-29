package com.zenmen.square.mvp.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.adapter.SquareShareContactsAdapter;
import com.zenmen.square.bean.SquareContactBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareContactViewHolder extends BaseRecyclerViewHolder<SquareContactBean> {
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public SquareShareContactsAdapter.a j;
    public SquareContactBean k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareShareContactViewHolder.this.k == null || SquareShareContactViewHolder.this.j == null) {
                return;
            }
            SquareShareContactViewHolder.this.j.a(SquareShareContactViewHolder.this.k, SquareShareContactViewHolder.this.itemView);
        }
    }

    public SquareShareContactViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.f = (TextView) s(this.f, R$id.first_name);
        this.g = (TextView) s(this.g, R$id.title);
        this.h = (TextView) s(this.h, R$id.sub_title);
        this.i = (ImageView) s(this.i, R$id.choice);
        this.itemView.setOnClickListener(new a());
    }

    public final View s(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void o(SquareContactBean squareContactBean, int i) {
        this.k = squareContactBean;
        if (squareContactBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(squareContactBean.name) && this.k.name.trim().length() > 0) {
            this.f.setText(this.k.name.trim().substring(0, 1));
        }
        this.g.setText(this.k.name);
        this.h.setText(this.k.displayNumber);
        this.i.setImageResource(this.k.selected ? R$drawable.square_share_selected : R$drawable.square_share_unselected);
    }

    public void u(SquareShareContactsAdapter.a aVar) {
        this.j = aVar;
    }
}
