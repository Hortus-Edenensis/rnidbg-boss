package com.zenmen.square.mvp.holder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.square.adapter.SquareTagSummaryAdapter;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagSummaryViewHolder extends RecyclerView.ViewHolder {
    public int d;
    public View e;
    public ImageView f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public SquareTagSummaryAdapter.b m;
    public SquareTagSummaryAdapter.a n;
    public je1 o;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareTagSummaryViewHolder.this.n == null || SquareTagSummaryViewHolder.this.m == null) {
                return;
            }
            SquareTagSummaryViewHolder.this.m.a(SquareTagSummaryViewHolder.this.n, SquareTagSummaryViewHolder.this.itemView);
        }
    }

    public SquareTagSummaryViewHolder(View view, int i) {
        super(view);
        this.d = i;
        this.e = n(this.e, R$id.bg);
        this.f = (ImageView) n(this.f, R$id.icon);
        this.g = (TextView) n(this.g, R$id.title);
        this.h = n(this.h, R$id.lock);
        this.i = (TextView) n(this.i, R$id.count);
        this.j = (TextView) n(this.j, R$id.count_plus);
        this.k = n(this.k, R$id.fresh);
        this.l = n(this.l, R$id.hot);
        this.o = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        this.itemView.setOnClickListener(new a());
    }

    public final View n(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    public void o(SquareTagSummaryAdapter.a aVar, int i) {
        String strValueOf;
        this.n = aVar;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        if (aVar.a().getPublishCnt() > 0) {
            this.f.setColorFilter(Color.parseColor("#14CD64"));
            this.g.setTextColor(Color.parseColor("#000000"));
            this.i.setTextColor(Color.parseColor("#000000"));
        } else {
            this.f.setColorFilter(Color.parseColor("#cccccc"));
            this.g.setTextColor(Color.parseColor("#cccccc"));
            this.i.setTextColor(Color.parseColor("#cccccc"));
        }
        this.g.setText(aVar.a().getName());
        gr2.j().h(aVar.a().getPicUrl(), this.f, this.o);
        if (aVar.a().getPublishCnt() > 99) {
            this.j.setVisibility(0);
            strValueOf = "99";
        } else {
            strValueOf = String.valueOf(aVar.a().getPublishCnt());
            this.j.setVisibility(8);
        }
        this.i.setText(strValueOf);
        if (aVar.a().getRank() == 2) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        if (aVar.a().getRank() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (aVar.a().getTagShow() == 2) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void p(SquareTagSummaryAdapter.b bVar) {
        this.m = bVar;
    }
}
