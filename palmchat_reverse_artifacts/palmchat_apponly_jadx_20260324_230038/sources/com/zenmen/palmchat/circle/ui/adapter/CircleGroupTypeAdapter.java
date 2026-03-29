package com.zenmen.palmchat.circle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bean.ExpandSecondLevelData;
import defpackage.bq6;
import defpackage.gr2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleGroupTypeAdapter extends RecyclerView.Adapter<b> {
    public List<ExpandFirstLevelData> e;
    public a f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        int getCurrentId();

        void l1(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.ViewHolder {
        public ImageView d;
        public TextView e;
        public RecyclerView f;

        public b(View view) {
            super(view);
            this.d = (ImageView) view.findViewById(R.id.image);
            this.e = (TextView) view.findViewById(R.id.tv_title);
            this.f = (RecyclerView) view.findViewById(R.id.child_recycler);
        }

        public void l(Context context, ExpandFirstLevelData expandFirstLevelData, boolean z) {
            gr2.j().h(expandFirstLevelData.getCateIcon(), this.d, bq6.s());
            this.e.setText(expandFirstLevelData.cateName);
            List<ExpandSecondLevelData> secondCate = expandFirstLevelData.getSecondCate();
            if (secondCate == null || secondCate.isEmpty()) {
                return;
            }
            if (this.f.getAdapter() != null) {
                this.f.getAdapter().notifyDataSetChanged();
                return;
            }
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            gridLayoutManager.setAutoMeasureEnabled(true);
            this.f.setLayoutManager(gridLayoutManager);
            this.f.addItemDecoration(new CircleContentDecoration(z));
            this.f.setAdapter(new CircleGroupContentAdapter(expandFirstLevelData.secondCate, CircleGroupTypeAdapter.this.f));
        }
    }

    public CircleGroupTypeAdapter(List<ExpandFirstLevelData> list, a aVar) {
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        if (i < this.e.size()) {
            bVar.l(bVar.itemView.getContext(), this.e.get(i), i == this.e.size() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_group_type_title, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }
}
