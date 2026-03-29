package com.zenmen.media.album;

import android.view.View;
import com.zenmen.media.album.SquareMediaPickAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.qk3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaCameraViewHolder extends BaseRecyclerViewHolder<qk3> {
    public SquareMediaPickAdapter.a f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qk3 f11905a;

        public a(qk3 qk3Var) {
            this.f11905a = qk3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaCameraViewHolder.this.f.d(this.f11905a.b, SquareMediaCameraViewHolder.this.itemView);
        }
    }

    public SquareMediaCameraViewHolder(View view, int i) {
        super(view, i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void o(qk3 qk3Var, int i) {
        this.itemView.setOnClickListener(new a(qk3Var));
    }

    public void s(SquareMediaPickAdapter.a aVar) {
        this.f = aVar;
    }
}
