package com.zenmen.palmchat.circle.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.oc0;
import defpackage.v4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleRecommendAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public Context e;
    public LayoutInflater f;
    public List<CircleRecommendItem> g;
    public c h;
    public int j;
    public boolean i = true;
    public boolean k = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;

        public a(View view) {
            super(view);
            this.d = (EffectiveShapeView) view.findViewById(R.id.img_group_head);
            this.e = (TextView) view.findViewById(R.id.text_group_title);
            this.f = (TextView) view.findViewById(R.id.text_member_count);
            this.g = (TextView) view.findViewById(R.id.text_group_introduce);
            this.h = (TextView) view.findViewById(R.id.text_join);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(CircleRecommendItem circleRecommendItem, View view) {
            CircleRecommendAdapter.this.l(circleRecommendItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(CircleRecommendItem circleRecommendItem, int i, View view) {
            if (CircleRecommendAdapter.this.h != null) {
                CircleRecommendAdapter.this.h.a(circleRecommendItem, i);
            }
        }

        public void n(final int i) {
            if (i > CircleRecommendAdapter.this.g.size()) {
                return;
            }
            final CircleRecommendItem circleRecommendItem = (CircleRecommendItem) CircleRecommendAdapter.this.g.get(i);
            HashMap map = new HashMap(3);
            map.put("rid", String.valueOf(circleRecommendItem.id));
            map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
            map.put("fromtype", Integer.valueOf(CircleRecommendAdapter.this.j));
            oc0.h("lx_group_card_show", map);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: nb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19476a.o(circleRecommendItem, view);
                }
            });
            gr2.j().h(circleRecommendItem.headImgUrl, this.d, bq6.s());
            this.e.setText(circleRecommendItem.name);
            this.g.setText(circleRecommendItem.describe);
            this.f.setText(circleRecommendItem.memberNum + "位成员");
            this.h.setOnClickListener(new View.OnClickListener() { // from class: ob0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19731a.p(circleRecommendItem, i, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public List<TextView> h;
        public TextView i;
        public TextView j;
        public TextView k;

        public b(View view) {
            super(view);
            this.d = (EffectiveShapeView) view.findViewById(R.id.img_group_head);
            this.e = (TextView) view.findViewById(R.id.text_group_title);
            this.f = (TextView) view.findViewById(R.id.text_group_title_tag);
            this.g = (TextView) view.findViewById(R.id.text_member_count);
            ArrayList arrayList = new ArrayList();
            this.h = arrayList;
            arrayList.add((TextView) view.findViewById(R.id.text_tags1));
            this.h.add((TextView) view.findViewById(R.id.text_tags2));
            this.h.add((TextView) view.findViewById(R.id.text_tags3));
            this.j = (TextView) view.findViewById(R.id.text_join);
            this.i = (TextView) view.findViewById(R.id.text_group_introduce);
            this.k = (TextView) view.findViewById(R.id.text_distance);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(CircleRecommendItem circleRecommendItem, View view) {
            CircleRecommendAdapter.this.l(circleRecommendItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(CircleRecommendItem circleRecommendItem, int i, View view) {
            if (oc0.e()) {
                CircleRecommendAdapter.this.l(circleRecommendItem);
            } else if (CircleRecommendAdapter.this.h != null) {
                CircleRecommendAdapter.this.h.a(circleRecommendItem, i);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public void n(final int i) {
            if (i > CircleRecommendAdapter.this.g.size()) {
                return;
            }
            final CircleRecommendItem circleRecommendItem = (CircleRecommendItem) CircleRecommendAdapter.this.g.get(i);
            HashMap map = new HashMap(3);
            map.put("rid", String.valueOf(circleRecommendItem.id));
            map.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
            map.put("fromtype", Integer.valueOf(CircleRecommendAdapter.this.j));
            oc0.h("lx_group_card_show", map);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: pb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19984a.o(circleRecommendItem, view);
                }
            });
            if (circleRecommendItem.hasJoined == 0) {
                this.j.setText("加入");
            } else {
                this.j.setText("进入");
            }
            this.j.setOnClickListener(new View.OnClickListener() { // from class: qb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20218a.p(circleRecommendItem, i, view);
                }
            });
            gr2.j().h(circleRecommendItem.headImgUrl, this.d, bq6.s());
            if (TextUtils.isEmpty(circleRecommendItem.describe)) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(circleRecommendItem.describe);
            }
            this.g.setText(circleRecommendItem.memberNum + "");
            if (TextUtils.isEmpty(circleRecommendItem.cateName)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(circleRecommendItem.cateName);
            }
            Iterator<TextView> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
            List<RoomTag> list = circleRecommendItem.tagList;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < Math.min(this.h.size(), circleRecommendItem.tagList.size()); i2++) {
                    RoomTag roomTag = circleRecommendItem.tagList.get(i2);
                    if (roomTag != null && !TextUtils.isEmpty(roomTag.tagName)) {
                        this.h.get(i2).setVisibility(0);
                        this.h.get(i2).setText(roomTag.tagName);
                    }
                }
            }
            if (!CircleRecommendAdapter.this.k || TextUtils.isEmpty(circleRecommendItem.displayDistance)) {
                this.k.setVisibility(8);
                this.e.setMaxWidth(a46.b(AppContext.getContext(), 150.0f));
            } else {
                this.k.setVisibility(0);
                this.k.setText(circleRecommendItem.displayDistance);
                this.e.setMaxWidth(a46.b(AppContext.getContext(), 120.0f));
            }
            this.e.setText(circleRecommendItem.name);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(CircleRecommendItem circleRecommendItem, int i);
    }

    public CircleRecommendAdapter(Context context, List<CircleRecommendItem> list, int i) {
        this.e = context;
        this.g = list;
        this.f = LayoutInflater.from(context);
        this.j = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (getItemViewType(i) == 1 || getItemViewType(i) == 2) {
            return;
        }
        if (getItemViewType(i) == 0) {
            ((a) baseViewHolder).n(i);
        } else if (getItemViewType(i) == 3) {
            ((b) baseViewHolder).n(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new a(this.f.inflate(R.layout.item_circle_recommend_common, viewGroup, false)) : i == 3 ? new b(this.f.inflate(R.layout.item_circle_recommend_common1, viewGroup, false)) : i == 2 ? new BaseViewHolder(this.f.inflate(R.layout.layout_empty_view, viewGroup, false)) : new BaseViewHolder(this.f.inflate(R.layout.layout_rv_loading_more_footer, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.i) {
            if (this.g.size() == 0) {
                return 1;
            }
            return this.g.size() + 1;
        }
        if (this.g.size() == 0) {
            return 1;
        }
        return this.g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.g.size() == 0) {
            return 2;
        }
        if (i < this.g.size()) {
            return oc0.c() ? 3 : 0;
        }
        return 1;
    }

    public void h() {
        this.i = false;
        notifyDataSetChanged();
    }

    public void i() {
        this.i = true;
    }

    public void j(c cVar) {
        this.h = cVar;
    }

    public void k() {
        this.k = true;
    }

    public final void l(CircleRecommendItem circleRecommendItem) {
        if (circleRecommendItem == null) {
            return;
        }
        HashMap map = new HashMap(2);
        map.put("rid", String.valueOf(circleRecommendItem.id));
        map.put("fromtype", Integer.valueOf(this.j));
        oc0.h("lx_group_card_click", map);
        Intent intent = new Intent(this.e, (Class<?>) CircleDetailActivity.class);
        intent.putExtra("key_group_info", circleRecommendItem.copyForGroupInfoItem());
        intent.putExtra("key_apply_group_source", 3);
        intent.putExtra("fromtype", this.j);
        this.e.startActivity(intent);
    }
}
