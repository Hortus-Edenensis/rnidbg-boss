package com.zenmen.media.album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.qk3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaPickAdapter extends BaseRecyclerViewAdapter<qk3> {
    public a j;
    public boolean k;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a(MediaItem mediaItem);

        void b(MediaItem mediaItem, boolean z);

        void c(MediaItem mediaItem);

        void d(MediaItem mediaItem, View view);

        boolean e(MediaItem mediaItem);
    }

    public SquareMediaPickAdapter(@NonNull Context context, @NonNull List<qk3> list) {
        super(context, list);
        this.k = false;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        if (i == 0) {
            return R.layout.grid_item_media_pick_square;
        }
        if (i == 1) {
            return R.layout.layout_item_square_media_pick_tips;
        }
        if (i == 2) {
            return R.layout.grid_item_media_pick_camera;
        }
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        if (i == 0) {
            SquareMediaPickViewHolder squareMediaPickViewHolder = new SquareMediaPickViewHolder(view, i);
            squareMediaPickViewHolder.x(this.j);
            return squareMediaPickViewHolder;
        }
        if (i == 1) {
            return new SquareMediaPickTipsViewHolder(view, i);
        }
        if (i != 2) {
            return null;
        }
        SquareMediaCameraViewHolder squareMediaCameraViewHolder = new SquareMediaCameraViewHolder(view, i);
        squareMediaCameraViewHolder.s(this.j);
        return squareMediaCameraViewHolder;
    }

    public void r(MediaItem mediaItem) {
        qk3 qk3Var = new qk3();
        qk3Var.f20270a = 0;
        qk3Var.b = mediaItem;
        ArrayList arrayList = new ArrayList();
        arrayList.add(qk3Var);
        c(arrayList);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull qk3 qk3Var) {
        return qk3Var.f20270a;
    }

    public void t(ArrayList<MediaItem> arrayList) {
        u(arrayList, true);
    }

    public void u(ArrayList<MediaItem> arrayList, boolean z) {
        if (arrayList == null) {
            q(new ArrayList());
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        qk3 qk3Var = new qk3();
        if (z) {
            qk3Var.f20270a = 1;
            arrayList2.add(qk3Var);
        }
        qk3 qk3Var2 = new qk3();
        qk3Var2.f20270a = 2;
        MediaItem mediaItem = new MediaItem();
        mediaItem.mimeType = 10086;
        qk3Var2.b = mediaItem;
        arrayList2.add(qk3Var2);
        for (MediaItem mediaItem2 : arrayList) {
            qk3 qk3Var3 = new qk3();
            qk3Var3.f20270a = 0;
            qk3Var3.b = mediaItem2;
            arrayList2.add(qk3Var3);
        }
        q(arrayList2);
    }

    public void v(a aVar) {
        this.j = aVar;
    }
}
