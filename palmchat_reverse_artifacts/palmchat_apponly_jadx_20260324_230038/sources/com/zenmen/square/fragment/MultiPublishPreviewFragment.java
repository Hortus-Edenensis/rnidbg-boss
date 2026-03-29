package com.zenmen.square.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.byakugallery.TouchImageView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.palmchat.widget.photoview.a;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.activity.SquareMultiPublishPreviewActivity;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hr2;
import defpackage.jr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.or2;
import defpackage.px5;
import defpackage.sd1;
import defpackage.xt;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class MultiPublishPreviewFragment extends Fragment {
    public static final String p = "MultiPublishPreviewFragment";
    public or2 d;
    public View e;
    public TouchImageView f;
    public PhotoView g;
    public ProgressBar h;
    public View i;
    public View j;
    public MediaItem k = new MediaItem();
    public String l;
    public boolean m;
    public String n;
    public SquareDetailVideoView o;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jr2 {
        public a() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            LogUtil.i(MultiPublishPreviewFragment.p, "onLoadingCancelled ");
            MultiPublishPreviewFragment.this.h.setVisibility(8);
            MultiPublishPreviewFragment.this.i.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MultiPublishPreviewFragment.this.h.setVisibility(8);
            MultiPublishPreviewFragment.this.i.setVisibility(8);
            if (bitmap == null) {
                LogUtil.i(MultiPublishPreviewFragment.p, "onLoadingComplete big bitmap failed");
                MultiPublishPreviewFragment.this.g.setImageResource(R$drawable.delete_default);
                return;
            }
            MultiPublishPreviewFragment.this.g.setScaleType(PhotoView.getPhotoViewScaleType(MultiPublishPreviewFragment.this.T(), bitmap));
            MultiPublishPreviewFragment.this.g.setMaxScale(PhotoView.getMaxScaleSize(MultiPublishPreviewFragment.this.T(), bitmap));
            LogUtil.i(MultiPublishPreviewFragment.p, "onLoadingComplete big bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
            if (MultiPublishPreviewFragment.this.m) {
                MultiPublishPreviewFragment multiPublishPreviewFragment = MultiPublishPreviewFragment.this;
                multiPublishPreviewFragment.V(multiPublishPreviewFragment.l, MultiPublishPreviewFragment.this.f, MultiPublishPreviewFragment.this.g);
                return;
            }
            File fileB = sd1.b(MultiPublishPreviewFragment.this.n);
            if (fileB != null) {
                String absolutePath = fileB.getAbsolutePath();
                if (TextUtils.isEmpty(absolutePath)) {
                    return;
                }
                MultiPublishPreviewFragment multiPublishPreviewFragment2 = MultiPublishPreviewFragment.this;
                multiPublishPreviewFragment2.V(absolutePath, multiPublishPreviewFragment2.f, MultiPublishPreviewFragment.this.g);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.i(MultiPublishPreviewFragment.p, "onLoadingComplete big bitmap failed" + failReason.a());
            MultiPublishPreviewFragment.this.h.setVisibility(8);
            MultiPublishPreviewFragment.this.i.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            LogUtil.i(MultiPublishPreviewFragment.p, "onLoadingStarted " + MultiPublishPreviewFragment.this.n);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareMultiPublishPreviewActivity f16308a;

        public b(SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivity) {
            this.f16308a = squareMultiPublishPreviewActivity;
        }

        @Override // com.zenmen.palmchat.widget.photoview.a.g
        public void onViewTap(View view, float f, float f2) {
            LogUtil.i(MultiPublishPreviewFragment.p, "onViewTap ");
            this.f16308a.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareMultiPublishPreviewActivity f16309a;

        public c(SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivity) {
            this.f16309a = squareMultiPublishPreviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = MultiPublishPreviewFragment.p;
            LogUtil.i(str, "onClick ");
            LogUtil.i(str, "onViewTap ");
            this.f16309a.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareMultiPublishPreviewActivity f16310a;

        public d(SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivity) {
            this.f16310a = squareMultiPublishPreviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16310a.O1();
            MultiPublishPreviewFragment.this.o.toggleState();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareMultiPublishPreviewActivity f16311a;

        public e(SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivity) {
            this.f16311a = squareMultiPublishPreviewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16311a.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends BitmapImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f16313a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ImageView imageView, PhotoView photoView, boolean z) {
            super(imageView);
            this.f16313a = photoView;
            this.b = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                if (bitmap.getHeight() >= xt.p() || bitmap.getWidth() >= xt.p()) {
                    this.f16313a.setLayerType(1, null);
                }
                LogUtil.i(MultiPublishPreviewFragment.p, "updateImageViewWithLocalImage origin bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
                if (this.b) {
                    this.f16313a.setScaleType(PhotoView.getPhotoViewScaleType(MultiPublishPreviewFragment.this.T(), bitmap));
                    this.f16313a.setMaxScale(PhotoView.getMaxScaleSize(MultiPublishPreviewFragment.this.T(), bitmap));
                }
                this.f16313a.setImageBitmap(bitmap);
            }
        }
    }

    public final SquareMultiPublishPreviewActivity P() {
        return (SquareMultiPublishPreviewActivity) getActivity();
    }

    public Bitmap R(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public final or2 T() {
        or2 or2Var = PhotoView.sImageSize;
        if (or2Var != null) {
            this.d = or2Var;
        }
        return this.d;
    }

    public final void V(String str, TouchImageView touchImageView, PhotoView photoView) {
        W(str, touchImageView, photoView, false);
    }

    public final void W(String str, TouchImageView touchImageView, PhotoView photoView, boolean z) {
        Bitmap bitmapR = R(photoView);
        String strP = k86.p(str);
        or2 or2VarM = xt.m(str);
        if (or2VarM == null || or2VarM.b() <= 0 || or2VarM.a() <= 0) {
            return;
        }
        String str2 = p;
        LogUtil.i(str2, "updateImageViewWithLocalImage srcImageSize bitmap" + or2VarM.b() + "*" + or2VarM.a() + " max =" + xt.p());
        if (bitmapR == null || or2VarM.b() > bitmapR.getWidth()) {
            if ((or2VarM.a() >= xt.p() || or2VarM.b() >= xt.p()) && !xt.q(str)) {
                LogUtil.i(str2, "updateImageViewWithLocalImage TileBitmapDrawable");
                px5.e(bitmapR, touchImageView, str, null, new f(touchImageView, photoView));
            } else {
                LogUtil.i(str2, "updateImageViewWithLocalImage load with getOriginDisplayImageOptions");
                if (getContext() == null) {
                    return;
                }
                hc2.a(getContext()).asBitmap().load(strP).diskCacheStrategy(!this.m ? DiskCacheStrategy.DATA : DiskCacheStrategy.NONE).error(R$drawable.ic_gallery_background).into(new g(photoView, photoView, z));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new or2(me1.g(), me1.f());
        this.k = (MediaItem) getArguments().getParcelable(SquareDetailVideoView.KEY_ITEM);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().getLayoutInflater().inflate(R$layout.item_photo_view, (ViewGroup) null);
        if (this.k == null) {
            return relativeLayout;
        }
        this.e = relativeLayout;
        this.h = (ProgressBar) relativeLayout.findViewById(R$id.prsbar);
        this.i = relativeLayout.findViewById(R$id.mask);
        this.g = (PhotoView) relativeLayout.findViewById(R$id.photoview);
        this.f = (TouchImageView) relativeLayout.findViewById(R$id.photoview_big);
        SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivityP = P();
        MediaItem mediaItem = this.k;
        int i = mediaItem.mimeType;
        if (i == 0) {
            String strI1 = squareMultiPublishPreviewActivityP.I1(mediaItem.fileFullPath, mediaItem.localPath);
            this.l = strI1;
            this.m = k86.J(strI1);
            this.n = k86.p(this.l);
            gr2.j().i(this.n, this.g, hr2.b(true ^ this.m), new a());
            this.g.setOnViewTapListener(new b(squareMultiPublishPreviewActivityP));
            this.f.setOnClickListener(new c(squareMultiPublishPreviewActivityP));
        } else {
            if (i == 1) {
                SquareFeed squareFeed = new SquareFeed();
                squareFeed.id = 1000L;
                squareFeed.mediaList = new ArrayList();
                Media media = new Media();
                MediaItem mediaItem2 = this.k;
                media.localPath = mediaItem2.localPath;
                media.url = mediaItem2.thumbnailPath;
                media.width = this.k.width + "";
                media.height = this.k.height + "";
                squareFeed.mediaList.add(media);
                SquareDetailVideoView squareDetailVideoView = new SquareDetailVideoView(getContext());
                this.o = squareDetailVideoView;
                relativeLayout.addView(squareDetailVideoView, -1, -1);
                this.o.setFeed(squareFeed, isResumed());
                View view = new View(getContext());
                this.j = view;
                relativeLayout.addView(view, -1, -1);
                this.j.setOnClickListener(new d(squareMultiPublishPreviewActivityP));
            }
            this.e.postDelayed(new e(squareMultiPublishPreviewActivityP), 500L);
        }
        return this.e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SquareDetailVideoView squareDetailVideoView = this.o;
        if (squareDetailVideoView != null) {
            squareDetailVideoView.pausePlayer();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SquareDetailVideoView squareDetailVideoView = this.o;
        if (squareDetailVideoView != null) {
            squareDetailVideoView.startPlay();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements px5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f16312a;
        public final /* synthetic */ PhotoView b;

        public f(TouchImageView touchImageView, PhotoView photoView) {
            this.f16312a = touchImageView;
            this.b = photoView;
        }

        @Override // px5.d
        public void b() {
            this.f16312a.setVisibility(0);
            this.b.setVisibility(8);
        }

        @Override // px5.d
        public void onError(Exception exc) {
            LogUtil.i(MultiPublishPreviewFragment.p, "TileBitmapDrawable attachTileBitmapDrawable onError" + exc);
        }

        @Override // px5.d
        public void a() {
        }
    }
}
