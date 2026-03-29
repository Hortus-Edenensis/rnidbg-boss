package com.zenmen.palmchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import defpackage.az2;
import defpackage.b05;
import defpackage.w42;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FunctionRecommendRecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public List<w42> e;
    public Context f;

    /* JADX INFO: compiled from: SearchBox */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12465a;
        public final /* synthetic */ w42 b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.adapter.FunctionRecommendRecycleAdapter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0967a extends HashMap<String, Object> {
            public C0967a() {
                put("order", Integer.valueOf(a.this.f12465a));
                put("url", a.this.b.f21614a);
            }
        }

        public a(int i, w42 w42Var) {
            this.f12465a = i;
            this.b = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("pagemsg_newfrd_recommendfunc", "click", new C0967a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        b05.d("mList======>" + az2.c(this.e));
        myViewHolder.itemView.setOnClickListener(new a(i, this.e.get(i)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.f).inflate(R.layout.function_recommend_recycleview_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        b05.d("mList======>" + az2.c(this.e));
        List<w42> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
