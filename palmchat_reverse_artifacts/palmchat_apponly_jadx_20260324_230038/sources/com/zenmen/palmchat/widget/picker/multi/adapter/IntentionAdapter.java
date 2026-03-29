package com.zenmen.palmchat.widget.picker.multi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.widget.picker.multi.IntentionPicker;
import com.zenmen.palmchat.widget.picker.multi.viewholder.IntentionViewHolder;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class IntentionAdapter extends RecyclerView.Adapter<IntentionViewHolder> {
    public Context e;
    public List<IntentionPicker.a> f;
    public LayoutInflater g;
    public int h = 0;
    public IntentionPicker.b i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.picker.multi.adapter.IntentionAdapter.b
        public void a(IntentionPicker.a aVar, View view) {
            IntentionAdapter intentionAdapter;
            IntentionPicker.b bVar;
            if (!IntentionAdapter.this.f(aVar) || (bVar = (intentionAdapter = IntentionAdapter.this).i) == null) {
                return;
            }
            bVar.a(intentionAdapter.a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(IntentionPicker.a aVar, View view);
    }

    public IntentionAdapter(@NonNull Context context, List<IntentionPicker.a> list) {
        this.e = context;
        this.f = list;
        if (list != null) {
            this.f = new ArrayList(list);
        } else {
            this.f = new ArrayList();
        }
        this.g = LayoutInflater.from(context);
    }

    public ArrayList<Integer> a() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (IntentionPicker.a aVar : this.f) {
            if (aVar.b()) {
                arrayList.add(Integer.valueOf(aVar.b.getId()));
            }
        }
        return arrayList;
    }

    public void b(List<Integer> list) {
        if (list == null || this.f == null) {
            return;
        }
        int i = 0;
        for (Integer num : list) {
            Iterator<IntentionPicker.a> it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IntentionPicker.a next = it.next();
                if (next != null && next.a() != null && next.a().getId() == num.intValue()) {
                    next.d(true);
                    i++;
                    break;
                }
            }
            if (i >= this.h) {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(IntentionViewHolder intentionViewHolder, int i) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        intentionViewHolder.o(this.f.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public IntentionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IntentionViewHolder intentionViewHolder = new IntentionViewHolder(this.g.inflate(R$layout.view_intention_picker_item, viewGroup, false));
        intentionViewHolder.p(new a());
        return intentionViewHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        notifyDataSetChanged();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(IntentionPicker.a aVar) {
        int size = a().size();
        Iterator<IntentionPicker.a> it = this.f.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            IntentionPicker.a next = it.next();
            if (next != null && next == aVar) {
                if (next.b()) {
                    next.d(false);
                } else {
                    if (size >= this.h) {
                        sy5.f(this.e, "最多可以选择3项", 0).g();
                        return false;
                    }
                    next.d(true);
                }
                z = true;
            }
        }
    }

    public void g(IntentionPicker.b bVar) {
        this.i = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<IntentionPicker.a> list = this.f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void h(int i) {
        this.h = i;
    }
}
