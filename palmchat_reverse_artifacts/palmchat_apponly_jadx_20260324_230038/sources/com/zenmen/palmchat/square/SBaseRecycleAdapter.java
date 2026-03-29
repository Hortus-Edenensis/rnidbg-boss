package com.zenmen.palmchat.square;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.square.SBaseViewHolder;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SBaseRecycleAdapter<T, VH extends SBaseViewHolder> extends RecyclerView.Adapter<VH> {
    public List<T> e;
    public Context f;

    public SBaseRecycleAdapter(Context context, List<T> list) {
        this.e = list;
        this.f = context;
    }

    public abstract VH a(@NonNull ViewGroup viewGroup, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.l(vh, this.e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return (VH) a(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
