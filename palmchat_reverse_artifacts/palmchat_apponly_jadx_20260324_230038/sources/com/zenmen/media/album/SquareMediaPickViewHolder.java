package com.zenmen.media.album;

import android.graphics.Outline;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.zenmen.media.album.SquareMediaPickAdapter;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import defpackage.a46;
import defpackage.hc2;
import defpackage.k86;
import defpackage.qk3;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaPickViewHolder extends BaseRecyclerViewHolder<qk3> {
    public ImageView f;
    public View g;
    public TextView h;
    public View i;
    public View j;
    public SquareMediaPickAdapter.a k;
    public qk3 l;
    public ViewOutlineProvider m;
    public int n;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), SquareMediaPickViewHolder.this.n);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11923a;

        public b(View view) {
            this.f11923a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareMediaPickViewHolder.this.l == null || SquareMediaPickViewHolder.this.l.b == null || SquareMediaPickViewHolder.this.k == null || SquareMediaPickViewHolder.this.j.getVisibility() == 0) {
                return;
            }
            SquareMediaPickViewHolder.this.k.d(SquareMediaPickViewHolder.this.l.b, this.f11923a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPickViewHolder.this.i.setSelected(!SquareMediaPickViewHolder.this.i.isSelected());
            if (SquareMediaPickViewHolder.this.l == null || SquareMediaPickViewHolder.this.l.b == null || SquareMediaPickViewHolder.this.k == null) {
                return;
            }
            SquareMediaPickViewHolder.this.k.b(SquareMediaPickViewHolder.this.l.b, SquareMediaPickViewHolder.this.i.isSelected());
        }
    }

    public SquareMediaPickViewHolder(View view, int i) {
        super(view, i);
        this.n = 0;
        this.n = a46.b(m(), 4.0f);
        this.f = (ImageView) l(R.id.image);
        a aVar = new a();
        this.m = aVar;
        this.f.setOutlineProvider(aVar);
        this.f.setClipToOutline(true);
        this.g = (ImageView) l(R.id.file_type_indicator_image);
        this.h = (TextView) l(R.id.time);
        this.i = l(R.id.select);
        this.j = l(R.id.cover);
        view.setOnClickListener(new b(view));
        this.i.setOnClickListener(new c());
    }

    public void v() {
        if (this.k != null) {
            this.i.setVisibility(0);
            if (this.k.a(this.l.b)) {
                this.i.setSelected(true);
                this.j.setVisibility(8);
            } else {
                this.i.setSelected(false);
                this.i.setVisibility((!this.k.e(this.l.b) || this.l.b.mimeType == 1) ? 8 : 0);
                this.j.setVisibility(this.k.e(this.l.b) ? 8 : 0);
            }
        } else {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
        SquareMediaPickAdapter.a aVar = this.k;
        if (aVar != null) {
            aVar.c(this.l.b);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void o(qk3 qk3Var, int i) {
        MediaItem mediaItem;
        this.l = null;
        if (qk3Var == null || (mediaItem = qk3Var.b) == null) {
            return;
        }
        this.l = qk3Var;
        MediaItem.ExtractInfo extractInfo = mediaItem.extractInfo;
        String timeStr = extractInfo != null ? extractInfo.getTimeStr() : null;
        if (TextUtils.isEmpty(timeStr)) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(timeStr);
        }
        int i2 = mediaItem.mimeType;
        if (i2 == 0) {
            this.g.setVisibility(8);
            hc2.a(m()).asBitmap().load(k86.p(mediaItem.fileFullPath)).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.media_pick_grid_item_background).error(R.drawable.media_pick_grid_item_background).transition(BitmapTransitionOptions.withCrossFade()).transform(new MultiTransformation(new CenterCrop(), new RoundedCornersTransformation(4, 0))).into(this.f);
        } else if (i2 == 1) {
            this.g.setVisibility(0);
            hc2.a(m()).asBitmap().load(k86.p(mediaItem.localThumbPath)).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.media_pick_grid_item_background).error(R.drawable.media_pick_grid_item_background).transition(BitmapTransitionOptions.withCrossFade()).transform(new MultiTransformation(new CenterCrop(), new RoundedCornersTransformation(4, 0))).into(this.f);
        }
        v();
    }

    public void x(SquareMediaPickAdapter.a aVar) {
        this.k = aVar;
    }
}
