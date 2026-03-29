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
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.ui.CircleDetailActivity;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.oc0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleSearchGroupAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public Context e;
    public LayoutInflater f;
    public List<CircleRecommendItem> g;
    public b h;
    public boolean i = true;
    public int j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BaseViewHolder {
        public EffectiveShapeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public List<TextView> h;
        public TextView i;
        public TextView j;
        public TextView k;

        public a(View view) {
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
            this.i = (TextView) view.findViewById(R.id.text_group_introduce);
            this.j = (TextView) view.findViewById(R.id.text_join);
            this.k = (TextView) view.findViewById(R.id.text_distance);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(CircleRecommendItem circleRecommendItem, View view) {
            HashMap map = new HashMap(3);
            map.put("member", Integer.valueOf(circleRecommendItem.hasJoined != 1 ? 0 : 1));
            map.put("rid", Long.valueOf(circleRecommendItem.id));
            map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            oc0.h("lx_group_explorepage_card_click", map);
            Intent intent = new Intent(CircleSearchGroupAdapter.this.e, (Class<?>) CircleDetailActivity.class);
            intent.putExtra("key_group_info", circleRecommendItem.copyForGroupInfoItem());
            intent.putExtra("key_apply_group_source", 4);
            intent.putExtra("chat_need_back_to_main", false);
            CircleSearchGroupAdapter.this.e.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(CircleRecommendItem circleRecommendItem, View view) {
            if (CircleSearchGroupAdapter.this.h != null) {
                CircleSearchGroupAdapter.this.h.a(circleRecommendItem);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public void n(final CircleRecommendItem circleRecommendItem) {
            if (CircleSearchGroupAdapter.this.j == 2) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: zb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22387a.o(circleRecommendItem, view);
                }
            });
            gr2.j().h(circleRecommendItem.headImgUrl, this.d, bq6.s());
            this.e.setText(circleRecommendItem.name);
            this.i.setText(circleRecommendItem.describe);
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
                for (int i = 0; i < Math.min(this.h.size(), circleRecommendItem.tagList.size()); i++) {
                    RoomTag roomTag = circleRecommendItem.tagList.get(i);
                    if (roomTag != null && !TextUtils.isEmpty(roomTag.tagName)) {
                        this.h.get(i).setVisibility(0);
                        this.h.get(i).setText(roomTag.tagName);
                    }
                }
            }
            this.j.setText(circleRecommendItem.hasJoined == 0 ? R.string.circle_join : R.string.circle_enter);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: ac0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1193a.p(circleRecommendItem, view);
                }
            });
            if (CircleSearchGroupAdapter.this.j != 1 || TextUtils.isEmpty(circleRecommendItem.displayDistance)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.k.setText(circleRecommendItem.displayDistance);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(CircleRecommendItem circleRecommendItem);
    }

    public CircleSearchGroupAdapter(Context context, List<CircleRecommendItem> list) {
        this.e = context;
        this.g = list;
        this.f = LayoutInflater.from(context);
    }

    public void d() {
        this.i = true;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (getItemViewType(i) != 1 && getItemViewType(i) == 2) {
            ((a) baseViewHolder).n(this.g.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (i == 0 || i == 2) ? new a(this.f.inflate(R.layout.item_circle_recommend_common1, viewGroup, false)) : new BaseViewHolder(this.f.inflate(R.layout.layout_rv_loading_more_footer, viewGroup, false));
    }

    public void g() {
        this.i = false;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return !this.i ? this.g.size() : this.g.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.j;
        return ((i2 == 0 || i2 == 1) && i == this.g.size()) ? 1 : 2;
    }

    public void h(int i) {
        this.j = i;
    }

    public void i(b bVar) {
        this.h = bVar;
    }
}
