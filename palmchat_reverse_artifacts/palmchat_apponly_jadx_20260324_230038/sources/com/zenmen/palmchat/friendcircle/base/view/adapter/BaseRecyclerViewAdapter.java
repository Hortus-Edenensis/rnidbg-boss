package com.zenmen.palmchat.friendcircle.base.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter.c;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.g74;
import defpackage.h74;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRecyclerViewAdapter<T extends c> extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {
    public Context e;
    public List<T> f;
    public LayoutInflater g;
    public g74<T> h;
    public h74<T> i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerViewHolder f13997a;

        public a(BaseRecyclerViewHolder baseRecyclerViewHolder) {
            this.f13997a = baseRecyclerViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = this.f13997a.getAdapterPosition();
            if (adapterPosition < 0 || adapterPosition >= BaseRecyclerViewAdapter.this.f.size()) {
                return;
            }
            BaseRecyclerViewAdapter.this.h.a(this.f13997a.itemView, adapterPosition, BaseRecyclerViewAdapter.this.f.get(adapterPosition));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerViewHolder f13998a;

        public b(BaseRecyclerViewHolder baseRecyclerViewHolder) {
            this.f13998a = baseRecyclerViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int adapterPosition = this.f13998a.getAdapterPosition();
            if (adapterPosition >= 0 && adapterPosition < BaseRecyclerViewAdapter.this.f.size()) {
                BaseRecyclerViewAdapter.this.i.a(this.f13998a.itemView, adapterPosition, BaseRecyclerViewAdapter.this.f.get(adapterPosition));
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public BaseRecyclerViewAdapter(@NonNull Context context, @NonNull List<T> list) {
        this.e = context;
        this.f = list;
        if (list != null) {
            this.f = new ArrayList(list);
        } else {
            this.f = new ArrayList();
        }
        this.g = LayoutInflater.from(context);
    }

    public void c(List<T> list) {
        int size;
        if (j(list)) {
            return;
        }
        if (j(this.f)) {
            this.f = list;
            size = 0;
        } else {
            size = this.f.size();
            this.f.addAll(list);
        }
        notifyItemRangeChanged(size, list.size());
    }

    public void d(int i) {
        List<T> list = this.f;
        if (list == null || list.size() <= i || i < 0) {
            return;
        }
        this.f.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, getItemCount());
    }

    public T e(int i) {
        List<T> list = this.f;
        if (list != null && list.size() > 0) {
            if (i >= 0 && i <= this.f.size()) {
                return this.f.get(i);
            }
            Log.e("BaseRecyclerViewAdapter", "这个position他喵咪的太强大了，我hold不住");
        }
        return null;
    }

    public List<T> f() {
        return this.f;
    }

    public abstract int g(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i(i, this.f.get(i));
    }

    public abstract BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i);

    public abstract int i(int i, @NonNull T t);

    public final boolean j(List<?> list) {
        return list == null || list.size() <= 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseRecyclerViewHolder baseRecyclerViewHolder, int i) {
        T t = this.f.get(i);
        baseRecyclerViewHolder.itemView.setTag(R$id.recycler_view_tag, t);
        baseRecyclerViewHolder.o(t, i);
        k(baseRecyclerViewHolder, t, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return g(i) != 0 ? h(viewGroup, this.g.inflate(g(i), viewGroup, false), i) : h(viewGroup, null, i);
    }

    public void n(g74<T> g74Var) {
        this.h = g74Var;
    }

    public void o(h74<T> h74Var) {
        this.i = h74Var;
    }

    public void p(BaseRecyclerViewHolder baseRecyclerViewHolder) {
        if (this.h != null) {
            baseRecyclerViewHolder.itemView.setOnClickListener(new a(baseRecyclerViewHolder));
        }
        if (this.i != null) {
            baseRecyclerViewHolder.itemView.setOnLongClickListener(new b(baseRecyclerViewHolder));
        }
    }

    public void q(List<T> list) {
        List<T> list2 = this.f;
        if (list2 != null) {
            list2.clear();
            this.f.addAll(list);
        } else {
            this.f = list;
        }
        notifyDataSetChanged();
    }

    public void k(BaseRecyclerViewHolder<T> baseRecyclerViewHolder, T t, int i) {
    }
}
