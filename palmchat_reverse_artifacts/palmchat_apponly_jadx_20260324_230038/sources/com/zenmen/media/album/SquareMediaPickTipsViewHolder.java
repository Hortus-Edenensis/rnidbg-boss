package com.zenmen.media.album;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.dj5;
import defpackage.qk3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaPickTipsViewHolder extends BaseRecyclerViewHolder<qk3> {
    public SquareMediaPickTipsViewHolder(View view, int i) {
        super(view, i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(qk3 qk3Var, int i) {
        ((TextView) l(R.id.tips)).setText(dj5.a());
    }
}
