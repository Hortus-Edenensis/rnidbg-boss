package com.zenmen.palmchat.circle.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;
import defpackage.fp2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class FragPageAdapterVp<T> extends BaseFragPageAdapterVp<T, TabViewHolder> implements fp2<T> {
    public FragPageAdapterVp(@NonNull FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
    }

    @Override // defpackage.fp2
    public <W extends PagerAdapter> W d() {
        return this;
    }
}
