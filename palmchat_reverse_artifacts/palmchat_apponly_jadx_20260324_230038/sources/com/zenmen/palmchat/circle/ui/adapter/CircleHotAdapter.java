package com.zenmen.palmchat.circle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleHotAdapter extends RecyclerView.Adapter<a> {
    public List<String> e;
    public b f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.ViewHolder {
        public TextView d;
        public View e;

        public a(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.text_hot);
            this.e = view.findViewById(R.id.view_line);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(String str, View view) {
            if (CircleHotAdapter.this.f != null) {
                CircleHotAdapter.this.f.K(str);
            }
        }

        public void m(final String str, int i) {
            this.d.setText(str);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: t90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20925a.n(str, view);
                }
            });
            if (i % 2 == 0) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void K(String str);
    }

    public CircleHotAdapter(List<String> list, b bVar) {
        this.e = list;
        this.f = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        aVar.m(this.e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_circle_hot_word, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
