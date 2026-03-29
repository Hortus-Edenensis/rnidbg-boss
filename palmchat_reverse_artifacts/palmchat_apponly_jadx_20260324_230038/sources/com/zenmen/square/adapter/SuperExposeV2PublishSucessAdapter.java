package com.zenmen.square.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SuperExposeV2PublishSucessAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public List<String> e;
    public Context f;

    /* JADX INFO: compiled from: SearchBox */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView d;
        public View e;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.d = (TextView) view.findViewById(R$id.content);
            this.e = view.findViewById(R$id.driver);
        }
    }

    public SuperExposeV2PublishSucessAdapter(List<String> list, Context context) {
        this.e = list;
        this.f = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.d.setText(this.e.get(i));
        myViewHolder.e.setVisibility(i == this.e.size() + (-1) ? 8 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.f).inflate(R$layout.super_expose_v2_publish_success_item, viewGroup, false));
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
