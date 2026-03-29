package com.zenmen.square.tag.viewholder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagViewHolder extends RecyclerView.ViewHolder {
    public int d;
    public View e;
    public ImageView f;
    public TextView g;
    public ImageView h;
    public SquareTagAdapter.b i;
    public SquareTagAdapter.a j;
    public je1 k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareTagViewHolder.this.j == null || SquareTagViewHolder.this.i == null) {
                return;
            }
            SquareTagViewHolder.this.i.a(SquareTagViewHolder.this.j, SquareTagViewHolder.this.itemView);
        }
    }

    public SquareTagViewHolder(View view, int i) {
        super(view);
        this.d = i;
        if (i == 0 || i == 1) {
            this.e = n(this.e, R$id.bg);
            this.f = (ImageView) n(this.f, R$id.icon);
            this.g = (TextView) n(this.g, R$id.title);
            this.k = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        } else if (i == 100) {
            this.g = (TextView) n(this.g, R$id.title);
        } else if (i == 101) {
            this.e = n(this.e, R$id.bg);
            this.f = (ImageView) n(this.f, R$id.icon);
            this.g = (TextView) n(this.g, R$id.title);
            this.k = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
            this.h = (ImageView) n(this.h, com.zenmen.square.R$id.check_image);
        }
        this.itemView.setOnClickListener(new a());
    }

    public final View n(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    public int o() {
        return this.d;
    }

    public void p(SquareTagAdapter.a aVar, int i) {
        this.j = aVar;
        if (aVar == null) {
            return;
        }
        if (o() == 100) {
            this.g.setText("全部");
            return;
        }
        if (aVar.b() == null) {
            return;
        }
        gr2.j().h(aVar.b().getPicUrl(), this.f, this.k);
        this.g.setText(aVar.b().getName());
        if (aVar.d()) {
            if (o() == 0) {
                this.e.setBackgroundResource(R$drawable.square_tag_small_bg_selected);
            } else if (o() == 1) {
                this.e.setBackgroundResource(R$drawable.square_tag_large_bg_selected);
            } else if (o() == 101) {
                this.e.setBackgroundResource(com.zenmen.square.R$drawable.square_tag_dialog_bg_selected);
                this.g.setTextColor(Color.parseColor("#14CD64"));
                this.f.setColorFilter(Color.parseColor("#14CD64"));
                this.h.setImageResource(com.zenmen.square.R$drawable.square_tag_choose_checked);
                return;
            }
            this.g.setTextColor(Color.parseColor("#ffffff"));
            this.f.setColorFilter(Color.parseColor("#ffffff"));
            return;
        }
        if (o() == 0) {
            this.e.setBackgroundResource(R$drawable.square_tag_small_bg);
        } else if (o() == 1) {
            this.e.setBackgroundResource(R$drawable.square_tag_large_bg);
        } else if (o() == 101) {
            this.e.setBackgroundResource(com.zenmen.square.R$drawable.square_tag_dialog_bg);
            this.g.setTextColor(Color.parseColor("#222222"));
            this.f.setColorFilter(Color.parseColor("#222222"));
            this.h.setImageResource(com.zenmen.square.R$drawable.square_tag_choose);
            return;
        }
        this.g.setTextColor(Color.parseColor("#444444"));
        this.f.setColorFilter(Color.parseColor("#666666"));
    }

    public void q(SquareTagAdapter.b bVar) {
        this.i = bVar;
    }
}
