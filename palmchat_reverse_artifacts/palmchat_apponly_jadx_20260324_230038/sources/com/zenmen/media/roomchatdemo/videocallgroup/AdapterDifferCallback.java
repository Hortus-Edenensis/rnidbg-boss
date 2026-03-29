package com.zenmen.media.roomchatdemo.videocallgroup;

import androidx.recyclerview.widget.DiffUtil;
import defpackage.gh;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdapterDifferCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<gh> f11978a;
    public List<gh> b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return this.f11978a.get(i).a().isSame(this.b.get(i2).a());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.f11978a.get(i).getClass().equals(this.b.get(i2).getClass());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        List<gh> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        List<gh> list = this.f11978a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
