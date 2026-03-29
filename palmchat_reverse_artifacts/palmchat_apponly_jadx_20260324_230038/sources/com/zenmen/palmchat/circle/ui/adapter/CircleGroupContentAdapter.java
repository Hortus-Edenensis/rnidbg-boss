package com.zenmen.palmchat.circle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.ExpandSecondLevelData;
import com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleGroupContentAdapter extends RecyclerView.Adapter<a> {
    public List<ExpandSecondLevelData> e;
    public CircleGroupTypeAdapter.a f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.ViewHolder {
        public TextView d;

        public a(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.item_text);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(ExpandSecondLevelData expandSecondLevelData, View view) {
            if (CircleGroupContentAdapter.this.f != null) {
                CircleGroupContentAdapter.this.f.l1(expandSecondLevelData.getId());
            }
        }

        public void m(final ExpandSecondLevelData expandSecondLevelData, int i) {
            this.d.setText(expandSecondLevelData.getCateName());
            if (CircleGroupContentAdapter.this.f.getCurrentId() == expandSecondLevelData.getId()) {
                this.d.setSelected(true);
            } else {
                this.d.setSelected(false);
            }
            this.d.setOnClickListener(new View.OnClickListener() { // from class: p90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19964a.n(expandSecondLevelData, view);
                }
            });
        }
    }

    public CircleGroupContentAdapter(List<ExpandSecondLevelData> list, CircleGroupTypeAdapter.a aVar) {
        this.e = list;
        this.f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null) {
            aVar.m(this.e.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.e == null) {
            return null;
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_group_type_content, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ExpandSecondLevelData> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
