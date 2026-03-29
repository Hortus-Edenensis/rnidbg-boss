package com.zenmen.square.dynamiclife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.igexin.push.config.c;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.bean.SquareDynamicLifeBeanInfo;
import com.zenmen.square.dynamiclife.DynamicCornerImageView;
import com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment;
import defpackage.a46;
import defpackage.hc2;
import defpackage.kj1;
import defpackage.vl1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DynamicLifePictureAdapter extends RecyclerView.Adapter<GridViewHolder> {
    public Context e;
    public int f;
    public List<SquareDynamicLifeBeanInfo> g;
    public PersonalDynamicLifeFragment.k h;

    /* JADX INFO: compiled from: SearchBox */
    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public DynamicCornerImageView d;
        public ImageView e;
        public ImageView f;
        public LeftDrawableText g;
        public ImageView h;
        public ImageView i;
        public AppCompatTextView j;
        public View k;
        public RelativeLayout l;
        public TranslateAnimation m;
        public TextView n;
        public LinearLayout o;

        public GridViewHolder(View view) {
            super(view);
            this.d = (DynamicCornerImageView) view.findViewById(R$id.iv_iamge);
            this.e = (ImageView) view.findViewById(R$id.iv_video);
            this.f = (ImageView) view.findViewById(R$id.iv_dynamic_life_remember);
            this.g = (LeftDrawableText) view.findViewById(R$id.iv_pic_count);
            this.h = (ImageView) view.findViewById(R$id.publish);
            this.j = (AppCompatTextView) view.findViewById(R$id.tv_content);
            this.k = view.findViewById(R$id.thumb_content);
            this.l = (RelativeLayout) view.findViewById(R$id.rl_super_expose_item_enter);
            this.i = (ImageView) view.findViewById(R$id.iv_super_expose_item_enter_arrow);
            this.n = (TextView) view.findViewById(R$id.view_num);
            this.o = (LinearLayout) view.findViewById(R$id.view_num_layout);
            this.d.setOnClickListener(this);
            this.h.setOnClickListener(this);
        }

        public void l(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
            if (squareDynamicLifeBeanInfo.isPublish) {
                this.h.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                this.f.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            if (squareDynamicLifeBeanInfo.feedType == 3) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            this.f.setVisibility(squareDynamicLifeBeanInfo.getPicSource() == 0 ? 0 : 8);
            int iB = a46.b(DynamicLifePictureAdapter.this.e, 80.0f);
            int iB2 = a46.b(DynamicLifePictureAdapter.this.e, 80.0f);
            if (squareDynamicLifeBeanInfo.feedType == 1) {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
                String str = squareDynamicLifeBeanInfo.content;
                if (str != null) {
                    this.j.setText(vl1.c(str.trim(), this.j.getContext(), vl1.j));
                }
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                hc2.a(DynamicLifePictureAdapter.this.e).load(a46.g(iB, iB2, squareDynamicLifeBeanInfo.thumbUrl)).error(R$drawable.icon_default_thumbnail).into(this.d);
            }
            if (squareDynamicLifeBeanInfo.mediaSize > 1) {
                this.g.setVisibility(0);
                this.g.setText(String.valueOf(squareDynamicLifeBeanInfo.mediaSize));
            } else {
                this.g.setVisibility(8);
            }
            if (squareDynamicLifeBeanInfo.superShowType != 0) {
                this.l.setVisibility(0);
                this.g.setVisibility(8);
                if (this.m == null) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -1.0f);
                    this.m = translateAnimation;
                    translateAnimation.setDuration(c.j);
                    this.m.setRepeatCount(-1);
                    this.m.setInterpolator(new LinearInterpolator());
                }
                this.m.cancel();
                this.i.startAnimation(this.m);
            } else {
                this.l.setVisibility(8);
                this.g.setVisibility(0);
            }
            this.n.setText(DynamicLifePictureAdapter.this.c(squareDynamicLifeBeanInfo.views));
            if (kj1.b().c().booleanValue()) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DynamicLifePictureAdapter.this.h != null) {
                int adapterPosition = getAdapterPosition();
                DynamicLifePictureAdapter dynamicLifePictureAdapter = DynamicLifePictureAdapter.this;
                dynamicLifePictureAdapter.h.a((SquareDynamicLifeBeanInfo) dynamicLifePictureAdapter.g.get(adapterPosition));
            }
        }
    }

    public DynamicLifePictureAdapter(Context context, int i, List<SquareDynamicLifeBeanInfo> list, PersonalDynamicLifeFragment.k kVar) {
        this.e = context;
        this.f = i;
        this.g = list;
        this.h = kVar;
    }

    public String c(int i) {
        return i <= 999 ? String.valueOf(i) : i <= 9999 ? String.format("%.1fk", Double.valueOf(((double) i) / 1000.0d)) : String.format("%.1fw", Double.valueOf(((double) i) / 10000.0d));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(GridViewHolder gridViewHolder, int i) {
        gridViewHolder.l(this.g.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GridViewHolder(View.inflate(this.e, R$layout.dynamic_life_picture_item, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SquareDynamicLifeBeanInfo> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
