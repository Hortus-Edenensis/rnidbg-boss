package com.zenmen.palmchat.photoview;

import android.content.res.Configuration;
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
import com.zenmen.palmchat.friendcircle.R$dimen;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.byakugallery.TouchImageView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.palmchat.widget.photoview.a;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import defpackage.ap3;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hr2;
import defpackage.hx3;
import defpackage.jr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.op4;
import defpackage.or2;
import defpackage.px5;
import defpackage.sd1;
import defpackage.td3;
import defpackage.xt;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public final class PhotoViewFragment extends Fragment {
    public static final String s = "PhotoViewFragment";
    public or2 d;
    public or2 e;
    public View f;
    public TouchImageView g;
    public PhotoView h;
    public boolean i;
    public ProgressBar j;
    public View k;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public String q;
    public MediaItem l = new MediaItem();
    public View.OnLongClickListener r = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jr2 {
        public a() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            LogUtil.i(PhotoViewFragment.s, "onLoadingCancelled ");
            PhotoViewFragment.this.j.setVisibility(8);
            PhotoViewFragment.this.k.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            PhotoViewFragment.this.j.setVisibility(8);
            PhotoViewFragment.this.k.setVisibility(8);
            if (bitmap == null) {
                LogUtil.i(PhotoViewFragment.s, "onLoadingComplete big bitmap failed");
                PhotoViewFragment.this.h.setImageResource(R$drawable.delete_default);
                return;
            }
            PhotoViewFragment.this.h.setScaleType(PhotoView.getPhotoViewScaleType(PhotoViewFragment.this.Y(), bitmap));
            PhotoViewFragment.this.h.setMaxScale(PhotoView.getMaxScaleSize(PhotoViewFragment.this.Y(), bitmap));
            LogUtil.i(PhotoViewFragment.s, "onLoadingComplete big bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
            if (PhotoViewFragment.this.n) {
                PhotoViewFragment photoViewFragment = PhotoViewFragment.this;
                photoViewFragment.e0(photoViewFragment.m, PhotoViewFragment.this.g, PhotoViewFragment.this.h);
                return;
            }
            File fileB = sd1.b(PhotoViewFragment.this.q);
            if (fileB != null) {
                String absolutePath = fileB.getAbsolutePath();
                if (TextUtils.isEmpty(absolutePath)) {
                    return;
                }
                PhotoViewFragment photoViewFragment2 = PhotoViewFragment.this;
                photoViewFragment2.e0(absolutePath, photoViewFragment2.g, PhotoViewFragment.this.h);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.i(PhotoViewFragment.s, "onLoadingComplete big bitmap failed" + failReason.a());
            PhotoViewFragment.this.j.setVisibility(8);
            PhotoViewFragment.this.k.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            LogUtil.i(PhotoViewFragment.s, "onLoadingStarted " + PhotoViewFragment.this.q);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoViewActivity f15016a;

        public b(PhotoViewActivity photoViewActivity) {
            this.f15016a = photoViewActivity;
        }

        @Override // com.zenmen.palmchat.widget.photoview.a.g
        public void onViewTap(View view, float f, float f2) {
            LogUtil.i(PhotoViewFragment.s, "onViewTap ");
            if (this.f15016a.Z1()) {
                this.f15016a.u2();
            } else {
                this.f15016a.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoViewActivity f15017a;

        public c(PhotoViewActivity photoViewActivity) {
            this.f15017a = photoViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = PhotoViewFragment.s;
            LogUtil.i(str, "onClick ");
            LogUtil.i(str, "onViewTap ");
            if (this.f15017a.Z1()) {
                this.f15017a.u2();
            } else {
                this.f15017a.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15019a;

            public a(String str) {
                this.f15019a = str;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    if (PhotoViewFragment.this.l == null || PhotoViewFragment.this.V() == null) {
                        return;
                    }
                    PhotoViewFragment.this.V().g2(PhotoViewFragment.this.l);
                    return;
                }
                if (i != 1) {
                    if (i != 2 || PhotoViewFragment.this.V() == null) {
                        return;
                    }
                    ap3.u(PhotoViewFragment.this.V(), this.f15019a);
                    return;
                }
                if (PhotoViewFragment.this.l == null) {
                    return;
                }
                try {
                    PhotoViewFragment.this.V().p2(PhotoViewFragment.this.l.localPath, TextUtils.isEmpty(PhotoViewFragment.this.l.fileFullPath) ? sd1.b(PhotoViewFragment.this.l.localPath) : sd1.b(PhotoViewFragment.this.l.fileFullPath));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements td3.f {
            public b() {
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    try {
                        PhotoViewFragment.this.V().p2(PhotoViewFragment.this.l.localPath, sd1.b(PhotoViewFragment.this.l.fileFullPath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PhotoViewFragment.this.i) {
                return true;
            }
            if (PhotoViewFragment.this.l.fileFullPath == null && PhotoViewFragment.this.l.localPath == null) {
                return true;
            }
            if (PhotoViewFragment.this.V().Y1()) {
                String strC0 = hx3.m(PhotoViewFragment.this.V()) ? PhotoViewFragment.this.c0() : null;
                new td3.c(PhotoViewFragment.this.V()).c(strC0 != null ? new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.string_forward), com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone), com.zenmen.palmchat.c.b().getResources().getString(R$string.recognize_qr_code)} : new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.string_forward), com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)}).d(new a(strC0)).a().b();
                return true;
            }
            if (!PhotoViewFragment.this.V().Y1()) {
                return true;
            }
            new td3.c(PhotoViewFragment.this.V()).c(new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)}).d(new b()).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BitmapImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f15022a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ImageView imageView, PhotoView photoView, boolean z) {
            super(imageView);
            this.f15022a = photoView;
            this.b = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                if (bitmap.getHeight() >= xt.p() || bitmap.getWidth() >= xt.p()) {
                    this.f15022a.setLayerType(1, null);
                }
                LogUtil.i(PhotoViewFragment.s, "updateImageViewWithLocalImage origin bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
                if (this.b) {
                    this.f15022a.setScaleType(PhotoView.getPhotoViewScaleType(PhotoViewFragment.this.Y(), bitmap));
                    this.f15022a.setMaxScale(PhotoView.getMaxScaleSize(PhotoViewFragment.this.Y(), bitmap));
                }
                this.f15022a.setImageBitmap(bitmap);
            }
        }
    }

    public final PhotoViewActivity V() {
        return (PhotoViewActivity) getActivity();
    }

    public Bitmap W(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public final or2 Y() {
        or2 or2Var = PhotoView.sImageSize;
        if (or2Var != null) {
            this.d = or2Var;
        }
        return this.d;
    }

    public void Z(boolean z) {
        Bitmap bitmapW = W(this.h);
        if (bitmapW != null) {
            this.h.setScaleType(PhotoView.getPhotoViewScaleType(this.d, bitmapW, z));
            this.h.setMaxScale(PhotoView.getMaxScaleSize(this.d, bitmapW));
        }
    }

    public final String c0() {
        Bitmap bitmap;
        if (this.h.getDrawable() == null || !(this.h.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) this.h.getDrawable()).getBitmap()) == null) {
            return null;
        }
        return op4.a(bitmap);
    }

    public final void e0(String str, TouchImageView touchImageView, PhotoView photoView) {
        h0(str, touchImageView, photoView, false);
    }

    public final void h0(String str, TouchImageView touchImageView, PhotoView photoView, boolean z) {
        Bitmap bitmapW = W(photoView);
        String strP = k86.p(str);
        or2 or2VarM = xt.m(str);
        if (or2VarM == null || or2VarM.b() <= 0 || or2VarM.a() <= 0) {
            return;
        }
        String str2 = s;
        LogUtil.i(str2, "updateImageViewWithLocalImage srcImageSize bitmap" + or2VarM.b() + "*" + or2VarM.a() + " max =" + xt.p());
        if (bitmapW == null || or2VarM.b() > bitmapW.getWidth()) {
            if ((or2VarM.a() >= xt.p() || or2VarM.b() >= xt.p()) && !xt.q(str)) {
                LogUtil.i(str2, "updateImageViewWithLocalImage TileBitmapDrawable");
                px5.e(bitmapW, touchImageView, str, null, new e(touchImageView, photoView));
            } else {
                LogUtil.i(str2, "updateImageViewWithLocalImage load with getOriginDisplayImageOptions");
                if (getContext() == null) {
                    return;
                }
                hc2.a(getContext()).asBitmap().load(strP).diskCacheStrategy(!this.n ? DiskCacheStrategy.DATA : DiskCacheStrategy.NONE).error(R$drawable.ic_gallery_background).into(new f(photoView, photoView, z));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Z(configuration.orientation != 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new or2(me1.g(), me1.f());
        int dimension = (int) getActivity().getResources().getDimension(R$dimen.chat_image_size);
        this.e = new or2(dimension, dimension);
        this.l = (MediaItem) getArguments().getParcelable(SquareDetailVideoView.KEY_ITEM);
        this.i = getArguments().getBoolean("long_click");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().getLayoutInflater().inflate(R$layout.item_photo_view, (ViewGroup) null);
        if (this.l == null) {
            return relativeLayout;
        }
        this.j = (ProgressBar) relativeLayout.findViewById(R$id.prsbar);
        this.k = relativeLayout.findViewById(R$id.mask);
        this.h = (PhotoView) relativeLayout.findViewById(R$id.photoview);
        this.g = (TouchImageView) relativeLayout.findViewById(R$id.photoview_big);
        PhotoViewActivity photoViewActivityV = V();
        MediaItem mediaItem = this.l;
        String strH2 = photoViewActivityV.h2(mediaItem.fileFullPath, mediaItem.localPath);
        this.m = strH2;
        this.n = k86.J(strH2);
        this.q = k86.p(this.m);
        MediaItem mediaItem2 = this.l;
        String strH22 = photoViewActivityV.h2(mediaItem2.thumbnailPath, mediaItem2.localPath);
        this.o = strH22;
        this.p = k86.p(strH22);
        if (!hx3.m(getActivity()) && (((str = this.q) == null || sd1.b(str) == null) && !TextUtils.isEmpty(this.p) && sd1.b(this.p) != null)) {
            this.q = this.p;
        }
        gr2.j().i(this.q, this.h, hr2.b(!this.n), new a());
        this.h.setOnViewTapListener(new b(photoViewActivityV));
        this.g.setOnClickListener(new c(photoViewActivityV));
        this.h.setOnLongClickListener(this.r);
        this.g.setOnLongClickListener(this.r);
        this.f = relativeLayout;
        return relativeLayout;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements px5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f15021a;
        public final /* synthetic */ PhotoView b;

        public e(TouchImageView touchImageView, PhotoView photoView) {
            this.f15021a = touchImageView;
            this.b = photoView;
        }

        @Override // px5.d
        public void b() {
            this.f15021a.setVisibility(0);
            this.b.setVisibility(8);
        }

        @Override // px5.d
        public void onError(Exception exc) {
            LogUtil.i(PhotoViewFragment.s, "TileBitmapDrawable attachTileBitmapDrawable onError" + exc);
        }

        @Override // px5.d
        public void a() {
        }
    }
}
