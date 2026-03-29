package com.zenmen.palmchat.widget.horizontalgridpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.qb4;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PageGridAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<T> e;
    public qb4 f;
    public int g;
    public int h;
    public int i;
    public int j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PageGridAdapter.this.f.d(view, ((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PageGridAdapter.this.f.b(view, ((Integer) view.getTag()).intValue());
            return true;
        }
    }

    public PageGridAdapter(qb4 qb4Var) {
        this(null, qb4Var);
    }

    public final ArrayList<T> b(ArrayList<T> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<T> arrayList2 = new ArrayList<>();
        int i = this.h * this.i;
        int iCeil = (int) Math.ceil(((double) arrayList.size()) / ((double) i));
        for (int i2 = 0; i2 < iCeil; i2++) {
            for (int i3 = 0; i3 < this.i; i3++) {
                for (int i4 = 0; i4 < this.h; i4++) {
                    int i5 = (this.i * i4) + i3 + (i2 * i);
                    if (i5 < arrayList.size()) {
                        arrayList2.add(arrayList.get(i5));
                    } else {
                        arrayList2.add(null);
                    }
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<T> c() {
        return this.e;
    }

    public void d(com.zenmen.palmchat.widget.horizontalgridpager.a aVar) {
        this.h = aVar.a()[0];
        this.i = aVar.a()[1];
        this.j = aVar.f();
    }

    public void e(ArrayList<T> arrayList) {
        this.e.clear();
        this.e.addAll(b(arrayList));
        notifyDataSetChanged();
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new a());
        viewHolder.itemView.setOnLongClickListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = this.i;
        if (i2 == 1) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            int i3 = this.g;
            int i4 = this.j;
            layoutParams.width = i3 + (i4 * 2);
            viewHolder.itemView.setPadding(i4, 0, i4, 0);
        } else {
            int i5 = this.h;
            int i6 = i % (i5 * i2);
            if (i6 < i5) {
                ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
                int i7 = this.g;
                int i8 = this.j;
                layoutParams2.width = i7 + i8;
                viewHolder.itemView.setPadding(i8, 0, 0, 0);
            } else if (i6 >= (i2 * i5) - i5) {
                ViewGroup.LayoutParams layoutParams3 = viewHolder.itemView.getLayoutParams();
                int i9 = this.g;
                int i10 = this.j;
                layoutParams3.width = i9 + i10;
                viewHolder.itemView.setPadding(0, 0, i10, 0);
            } else {
                viewHolder.itemView.getLayoutParams().width = this.g;
                viewHolder.itemView.setPadding(0, 0, 0, 0);
            }
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
        f(viewHolder);
        if (i >= this.e.size() || this.e.get(i) == null) {
            viewHolder.itemView.setVisibility(8);
        } else {
            viewHolder.itemView.setVisibility(0);
            this.f.c(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.g <= 0) {
            this.g = (viewGroup.getMeasuredWidth() - (this.j * 2)) / this.i;
        }
        RecyclerView.ViewHolder viewHolderA = this.f.a(viewGroup, i);
        viewHolderA.itemView.measure(0, 0);
        viewHolderA.itemView.getLayoutParams().width = this.g;
        viewHolderA.itemView.getLayoutParams().height = viewHolderA.itemView.getMeasuredHeight();
        return viewHolderA;
    }

    public PageGridAdapter(ArrayList<T> arrayList, qb4 qb4Var) {
        this.e = b(arrayList);
        this.f = qb4Var;
    }
}
