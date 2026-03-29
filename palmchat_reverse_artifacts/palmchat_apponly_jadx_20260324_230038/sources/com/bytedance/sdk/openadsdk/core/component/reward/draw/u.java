package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends RecyclerView.u<pn> {
    private final float b;
    private final float fx;
    private final List<nr> nr = new ArrayList();
    private final List<pn> pn = new ArrayList();
    private final Context u;

    public u(Context context, float f, float f2) {
        this.u = context;
        this.fx = f;
        this.b = f2;
    }

    public void b() {
        Iterator<pn> it = this.pn.iterator();
        while (it.hasNext()) {
            it.next().pb();
        }
        this.pn.clear();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
    public pn u(ViewGroup viewGroup, int i) {
        pn pnVar = new pn(com.bytedance.sdk.openadsdk.res.pn.l(this.u));
        this.pn.add(pnVar);
        return pnVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public long nr(int i) {
        return i;
    }

    public void u(List<nr> list) {
        this.nr.clear();
        this.nr.addAll(list);
        fx();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void u(pn pnVar) {
        super.u(pnVar);
        pnVar.pb();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void u(pn pnVar, int i) {
        List<nr> list = this.nr;
        pnVar.u(list.get(i % list.size()), (int) this.fx, (int) this.b);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public int u() {
        return this.nr.size();
    }
}
