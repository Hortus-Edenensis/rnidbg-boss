package com.zenmen.square.fragment.online;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$layout;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<OnLineItemData> e;
    public Context f;
    public Activity g;

    public OnLineAdapter(Context context, Activity activity) {
        this.f = context;
        this.g = activity;
    }

    public List<OnLineItemData> a() {
        return this.e;
    }

    public void b(List<OnLineItemData> list) {
        this.e = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<OnLineItemData> list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<OnLineItemData> list = this.e;
        return (list == null || list.size() < i || this.e.get(i).mineType != 1) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        List<OnLineItemData> list = this.e;
        if (list == null || list.size() < i) {
            return;
        }
        if (viewHolder instanceof OnLineItemMineHolder) {
            ((OnLineItemMineHolder) viewHolder).l(this.e.get(i));
        } else if (viewHolder instanceof OnLineItemHolder) {
            ((OnLineItemHolder) viewHolder).l(this.e.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 1 ? new OnLineItemMineHolder(LayoutInflater.from(this.f).inflate(R$layout.layout_online_mine_status_item, viewGroup, false), this.g) : new OnLineItemHolder(LayoutInflater.from(this.f).inflate(R$layout.layout_online_status_item, viewGroup, false), this.g);
    }
}
