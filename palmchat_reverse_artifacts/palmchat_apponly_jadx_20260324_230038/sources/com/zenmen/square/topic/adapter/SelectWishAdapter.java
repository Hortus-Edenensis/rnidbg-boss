package com.zenmen.square.topic.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import defpackage.gr2;
import defpackage.je1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SelectWishAdapter extends RecyclerView.Adapter<SelectWishViewHolder> {
    public Context e;
    public List<TopicListBean.Ae> f;
    public LayoutInflater g;
    public a h;

    /* JADX INFO: compiled from: SearchBox */
    public class SelectWishViewHolder extends RecyclerView.ViewHolder {
        public int d;
        public View e;
        public ImageView f;
        public TextView g;
        public a h;
        public TopicListBean.Ae i;
        public je1 j;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SelectWishAdapter f16500a;

            public a(SelectWishAdapter selectWishAdapter) {
                this.f16500a = selectWishAdapter;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogUtil.d("SelectWishAdapter", "OnClickListener = ");
                if (SelectWishViewHolder.this.i == null || SelectWishViewHolder.this.h == null) {
                    return;
                }
                SelectWishViewHolder.this.h.a(SelectWishViewHolder.this.i, SelectWishViewHolder.this.itemView);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SelectWishAdapter f16501a;

            public b(SelectWishAdapter selectWishAdapter) {
                this.f16501a = selectWishAdapter;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                LogUtil.d("SelectWishAdapter", "onTouch = " + motionEvent.getAction());
                int action = motionEvent.getAction();
                if (action == 0) {
                    SelectWishViewHolder.this.g.setTextColor(Color.parseColor("#ffffff"));
                    SelectWishViewHolder.this.f.setColorFilter(Color.parseColor("#ffffff"));
                    SelectWishViewHolder.this.e.setBackgroundResource(R$drawable.square_wish_item_bg_pressed);
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                SelectWishViewHolder.this.g.setTextColor(Color.parseColor("#666666"));
                SelectWishViewHolder.this.f.setColorFilter(Color.parseColor("#666666"));
                SelectWishViewHolder.this.e.setBackgroundResource(R$drawable.square_wish_item_bg_normal);
                return false;
            }
        }

        public SelectWishViewHolder(View view, int i) {
            super(view);
            this.d = i;
            this.e = q(this.e, R$id.bg);
            this.f = (ImageView) q(this.f, R$id.icon);
            this.g = (TextView) q(this.g, R$id.title);
            this.j = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
            this.itemView.setOnClickListener(new a(SelectWishAdapter.this));
            this.itemView.setOnTouchListener(new b(SelectWishAdapter.this));
        }

        public final View q(View view, int i) {
            View view2;
            return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
        }

        public void r(TopicListBean.Ae ae, int i) {
            this.i = ae;
            if (ae == null) {
                return;
            }
            gr2.j().h(ae.aeIcon, this.f, this.j);
            this.g.setText(ae.aeName);
        }

        public void s(a aVar) {
            this.h = aVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(TopicListBean.Ae ae, View view);
    }

    public SelectWishAdapter(@NonNull Context context, List<TopicListBean.Ae> list) {
        this.e = context;
        this.f = list;
        if (list != null) {
            this.f = new ArrayList(list);
        } else {
            this.f = new ArrayList();
        }
        this.g = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(SelectWishViewHolder selectWishViewHolder, int i) {
        LogUtil.d("SelectWishAdapter", "onBindViewHolder = " + i);
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        selectWishViewHolder.r(this.f.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SelectWishViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LogUtil.d("SelectWishAdapter", "onCreateViewHolder = " + i);
        SelectWishViewHolder selectWishViewHolder = new SelectWishViewHolder(this.g.inflate(R$layout.square_layout_wish_select_item, viewGroup, false), i);
        selectWishViewHolder.s(this.h);
        return selectWishViewHolder;
    }

    public void c(a aVar) {
        this.h = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        StringBuilder sb = new StringBuilder();
        sb.append("getItemCount() = ");
        List<TopicListBean.Ae> list = this.f;
        sb.append(list == null ? 0 : list.size());
        LogUtil.d("SelectWishAdapter", sb.toString());
        List<TopicListBean.Ae> list2 = this.f;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }
}
