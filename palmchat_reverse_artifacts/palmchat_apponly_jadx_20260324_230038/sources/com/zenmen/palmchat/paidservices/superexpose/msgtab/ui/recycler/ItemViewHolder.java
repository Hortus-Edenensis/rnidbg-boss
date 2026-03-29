package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import defpackage.hc2;
import defpackage.k86;
import defpackage.l50;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ItemViewHolder extends BaseRecyclerViewHolder<SuperExposeNumItem> {
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public View k;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public TextView p;
    public SuperExposeTabRecyclerItemLayout q;
    public ItemAdapter r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ItemViewHolder.this.q.onItemClick();
        }
    }

    public ItemViewHolder(Context context, ViewGroup viewGroup, ItemAdapter itemAdapter) {
        super(context, viewGroup, R.layout.super_expose_num_layout_item);
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = itemAdapter;
        SuperExposeTabRecyclerItemLayout superExposeTabRecyclerItemLayout = (SuperExposeTabRecyclerItemLayout) l(R.id.item_root);
        this.q = superExposeTabRecyclerItemLayout;
        superExposeTabRecyclerItemLayout.setOnClickListener(new a());
        this.f = (LinearLayout) l(R.id.tag_layout);
        this.g = (TextView) l(R.id.age);
        this.h = (TextView) l(R.id.name);
        this.i = (ImageView) l(R.id.img);
        this.j = (TextView) l(R.id.distance);
        this.k = l(R.id.tag_layout_1);
        this.l = l(R.id.tag_layout_2);
        this.m = l(R.id.tag_green_bg_1);
        this.n = l(R.id.tag_green_bg_2);
        this.o = (TextView) l(R.id.item_tag_1);
        this.p = (TextView) l(R.id.item_tag_2);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void o(SuperExposeNumItem superExposeNumItem, int i) {
        if (superExposeNumItem == null) {
            return;
        }
        superExposeNumItem.position = i;
        this.q.setItemData(superExposeNumItem);
        if (TextUtils.isEmpty(superExposeNumItem.age)) {
            this.g.setVisibility(8);
            this.g.setText("");
        } else {
            this.g.setVisibility(0);
            this.g.setText(superExposeNumItem.age + "岁");
        }
        if (TextUtils.isEmpty(superExposeNumItem.nickname)) {
            this.h.setVisibility(8);
            this.h.setText("");
        } else {
            this.h.setVisibility(0);
            this.h.setText(superExposeNumItem.nickname);
        }
        if (TextUtils.isEmpty(superExposeNumItem.distanceKm) || "-1".equals(superExposeNumItem.distanceKm)) {
            this.j.setVisibility(8);
            this.j.setText("");
        } else {
            this.j.setVisibility(0);
            this.j.setText(superExposeNumItem.distanceKm + "km");
        }
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setTextColor(Color.parseColor("#FFFFFF"));
        this.p.setTextColor(Color.parseColor("#FFFFFF"));
        List<String> list = superExposeNumItem.tagList;
        if (list != null) {
            if (list.size() > 0) {
                String str = list.get(0);
                if (!TextUtils.isEmpty(str)) {
                    this.k.setVisibility(0);
                    this.o.setText(str);
                    if (str.contains("在线")) {
                        this.m.setVisibility(0);
                        this.o.setTextColor(Color.parseColor("#14CD64"));
                        this.o.setText("在线");
                    }
                }
            }
            if (list.size() > 1) {
                String str2 = list.get(1);
                if (!TextUtils.isEmpty(str2)) {
                    this.l.setVisibility(0);
                    this.p.setText(str2);
                    if (str2.contains("在线")) {
                        this.n.setVisibility(0);
                        this.p.setTextColor(Color.parseColor("#14CD64"));
                        this.p.setText("在线");
                    }
                }
            }
        }
        if (TextUtils.isEmpty(superExposeNumItem.avatar)) {
            this.i.setImageResource(R.drawable.super_num_item_icon_dft_bg);
        } else {
            hc2.a(m()).load(k86.p(superExposeNumItem.avatar)).placeholder(R.drawable.super_num_item_icon_dft_bg).error(R.drawable.super_num_item_icon_dft_bg).into(this.i);
        }
    }
}
