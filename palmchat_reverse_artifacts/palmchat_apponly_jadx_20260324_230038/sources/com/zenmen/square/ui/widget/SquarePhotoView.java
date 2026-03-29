package com.zenmen.square.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.byakugallery.TouchImageView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.Media;
import defpackage.hc2;
import defpackage.k86;
import defpackage.me1;
import defpackage.or2;
import defpackage.px5;
import defpackage.xt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquarePhotoView extends LxRelativeLayout {
    private static final String TAG = "SquarePhotoView";
    private TouchImageView bigPhotoView;
    private boolean isNeedClear;
    private Media mMedia;
    private or2 mScreenSize;
    private View mask;
    private PhotoView photoView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends DrawableImageViewTarget {
        public a(ImageView imageView) {
            super(imageView);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            SquarePhotoView.this.mask.setVisibility(8);
            if (drawable != null) {
                SquarePhotoView.this.photoView.setScaleType(PhotoView.getSquarePhotoViewScaleType(SquarePhotoView.this.getPreviewSize(), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                SquarePhotoView.this.photoView.setMaxScale(PhotoView.getMaxScaleSize(SquarePhotoView.this.getPreviewSize(), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
            }
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            super.onLoadFailed(drawable);
            SquarePhotoView.this.mask.setVisibility(8);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            SquarePhotoView.this.mask.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BitmapImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f16572a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView, PhotoView photoView, boolean z) {
            super(imageView);
            this.f16572a = photoView;
            this.b = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                if (bitmap.getHeight() >= xt.p() || bitmap.getWidth() >= xt.p()) {
                    this.f16572a.setLayerType(1, null);
                }
                LogUtil.i(SquarePhotoView.TAG, "updateImageViewWithLocalImage origin bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
                if (this.b) {
                    this.f16572a.setScaleType(PhotoView.getPhotoViewScaleType(SquarePhotoView.this.getPreviewSize(), bitmap));
                    this.f16572a.setMaxScale(PhotoView.getMaxScaleSize(SquarePhotoView.this.getPreviewSize(), bitmap));
                }
                this.f16572a.setImageBitmap(bitmap);
            }
        }
    }

    public SquarePhotoView(Context context) {
        super(context);
        this.isNeedClear = true;
    }

    private void displayImage() {
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isDestroyed()) {
            return;
        }
        hc2.a(getContext()).load(k86.p(this.mMedia.url)).diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.IMMEDIATE).error(R$drawable.ic_image_full_error).transition(DrawableTransitionOptions.withCrossFade()).downsample(DownsampleStrategy.CENTER_INSIDE).into(new a(this.photoView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public or2 getPreviewSize() {
        or2 or2Var = PhotoView.sImageSize;
        if (or2Var != null) {
            this.mScreenSize = or2Var;
        }
        return this.mScreenSize;
    }

    private void initView() {
        this.mask = findViewById(R$id.mask);
        PhotoView photoView = (PhotoView) findViewById(R$id.photoview);
        this.photoView = photoView;
        photoView.setNeedClear(this.isNeedClear);
        this.bigPhotoView = (TouchImageView) findViewById(R$id.photoview_big);
        this.mScreenSize = new or2(me1.g(), me1.f());
    }

    private void updateImageViewWithLocalImage(String str, TouchImageView touchImageView, PhotoView photoView) {
        updateImageViewWithLocalImage(str, touchImageView, photoView, false);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        addView(LayoutInflater.from(context).inflate(R$layout.layout_square_detail_photo_view, (ViewGroup) this, false));
        initView();
    }

    public Bitmap getBitmapFromImageView(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public PhotoView getPhotoView() {
        return this.photoView;
    }

    public void setMedia(Media media) {
        this.mMedia = media;
        displayImage();
    }

    public void setNeedClear(boolean z) {
        this.isNeedClear = z;
    }

    private void updateImageViewWithLocalImage(String str, TouchImageView touchImageView, PhotoView photoView, boolean z) {
        Bitmap bitmapFromImageView = getBitmapFromImageView(photoView);
        String strP = k86.p(str);
        or2 or2VarM = xt.m(str);
        if (or2VarM == null || or2VarM.b() <= 0 || or2VarM.a() <= 0) {
            return;
        }
        String str2 = TAG;
        LogUtil.i(str2, "updateImageViewWithLocalImage srcImageSize bitmap" + or2VarM.b() + "*" + or2VarM.a() + " max =" + xt.p());
        if (bitmapFromImageView == null || or2VarM.b() > bitmapFromImageView.getWidth()) {
            if ((or2VarM.a() >= xt.p() || or2VarM.b() >= xt.p()) && !xt.q(str)) {
                LogUtil.i(str2, "updateImageViewWithLocalImage TileBitmapDrawable");
                px5.e(bitmapFromImageView, touchImageView, str, null, new b(touchImageView, photoView));
            } else {
                LogUtil.i(str2, "updateImageViewWithLocalImage load with getOriginDisplayImageOptions");
                if (getContext() == null) {
                    return;
                }
                hc2.a(getContext()).asBitmap().load(strP).diskCacheStrategy(DiskCacheStrategy.DATA).error(R$drawable.ic_gallery_background).into(new c(photoView, photoView, z));
            }
        }
    }

    public SquarePhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isNeedClear = true;
    }

    public SquarePhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNeedClear = true;
    }

    @RequiresApi(api = 21)
    public SquarePhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isNeedClear = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements px5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f16571a;
        public final /* synthetic */ PhotoView b;

        public b(TouchImageView touchImageView, PhotoView photoView) {
            this.f16571a = touchImageView;
            this.b = photoView;
        }

        @Override // px5.d
        public void b() {
            this.f16571a.setVisibility(0);
            this.b.setVisibility(8);
        }

        @Override // px5.d
        public void onError(Exception exc) {
            LogUtil.i(SquarePhotoView.TAG, "TileBitmapDrawable attachTileBitmapDrawable onError" + exc);
        }

        @Override // px5.d
        public void a() {
        }
    }
}
