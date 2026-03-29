package com.zenmen.palmchat.activity.photoview;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.byakugallery.TouchImageView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.palmchat.widget.photoview.a;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import defpackage.bq6;
import defpackage.br2;
import defpackage.dr2;
import defpackage.ds0;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.il5;
import defpackage.jr2;
import defpackage.k86;
import defpackage.me1;
import defpackage.op4;
import defpackage.or2;
import defpackage.px5;
import defpackage.qm5;
import defpackage.sd1;
import defpackage.sy5;
import defpackage.td3;
import defpackage.xt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public final class PhotoViewFragment extends Fragment {
    public static final String B = "PhotoViewFragment";
    public or2 d;
    public or2 e;
    public View f;
    public TouchImageView g;
    public PhotoView h;
    public TextView i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ProgressBar n;
    public View o;
    public View p;
    public TextView q;
    public String s;
    public boolean t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public String y;
    public MediaItem r = new MediaItem();
    public boolean z = false;
    public View.OnLongClickListener A = new h();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BitmapImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f12333a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, PhotoView photoView, boolean z) {
            super(imageView);
            this.f12333a = photoView;
            this.b = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                if (bitmap.getHeight() >= xt.p() || bitmap.getWidth() >= xt.p()) {
                    this.f12333a.setLayerType(1, null);
                }
                LogUtil.i(PhotoViewFragment.B, "updateImageViewWithLocalImage origin bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
                if (this.b) {
                    this.f12333a.setScaleType(PhotoView.getPhotoViewScaleType(PhotoViewFragment.this.n0(), bitmap));
                    this.f12333a.setMaxScale(PhotoView.getMaxScaleSize(PhotoViewFragment.this.n0(), bitmap));
                }
                this.f12333a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jr2 {
        public b() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingCancelled ");
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
            if (bitmap == null) {
                LogUtil.i(PhotoViewFragment.B, "onLoadingComplete big bitmap failed");
                return;
            }
            PhotoViewFragment.this.h.setScaleType(PhotoView.getPhotoViewScaleType(PhotoViewFragment.this.n0(), bitmap));
            PhotoViewFragment.this.h.setMaxScale(PhotoView.getMaxScaleSize(PhotoViewFragment.this.n0(), bitmap));
            LogUtil.i(PhotoViewFragment.B, "onLoadingComplete big bitmap" + bitmap.getWidth() + "*" + bitmap.getHeight());
            if (PhotoViewFragment.this.t) {
                PhotoViewFragment photoViewFragment = PhotoViewFragment.this;
                photoViewFragment.w0(photoViewFragment.s, PhotoViewFragment.this.g, PhotoViewFragment.this.h);
                return;
            }
            try {
                File fileB = sd1.b(PhotoViewFragment.this.w);
                if (fileB != null) {
                    String absolutePath = fileB.getAbsolutePath();
                    if (TextUtils.isEmpty(absolutePath)) {
                        return;
                    }
                    PhotoViewFragment photoViewFragment2 = PhotoViewFragment.this;
                    photoViewFragment2.w0(absolutePath, photoViewFragment2.g, PhotoViewFragment.this.h);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingComplete big bitmap failed" + failReason.a());
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
            if (FailReason.c(failReason)) {
                PhotoViewFragment.this.h.setImageResource(R.drawable.transparent_drawable);
                PhotoViewFragment.this.p.setVisibility(0);
                PhotoViewFragment.this.s0(str, failReason.b() == FailReason.FailType.NET_403);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingStarted " + PhotoViewFragment.this.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePreviewActivity f12335a;

        public c(BasePreviewActivity basePreviewActivity) {
            this.f12335a = basePreviewActivity;
        }

        @Override // com.zenmen.palmchat.widget.photoview.a.g
        public void onViewTap(View view, float f, float f2) {
            LogUtil.i(PhotoViewFragment.B, "onViewTap ");
            if (this.f12335a.B1() != 2) {
                this.f12335a.finish();
            } else {
                this.f12335a.G1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePreviewActivity f12336a;

        public d(BasePreviewActivity basePreviewActivity) {
            this.f12336a = basePreviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.i(PhotoViewFragment.B, "onClick ");
            if (this.f12336a.B1() != 2) {
                this.f12336a.finish();
            } else {
                this.f12336a.G1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ br2 f12337a;

        public e(br2 br2Var) {
            this.f12337a = br2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            br2 br2Var = this.f12337a;
            if (br2Var.f1806a == 0 && br2Var.b.mid.equals(PhotoViewFragment.this.r.mid)) {
                PhotoViewFragment.this.r = this.f12337a.b;
                PhotoViewFragment.this.x = true;
                PhotoViewFragment photoViewFragment = PhotoViewFragment.this;
                photoViewFragment.x0(photoViewFragment.r.localPath, PhotoViewFragment.this.g, PhotoViewFragment.this.h, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12338a;

        public f(String str) {
            this.f12338a = str;
            put("action", "img_load_fail");
            put("reason", "expired");
            put("scene", 1);
            put("url", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements jr2 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements jr2 {
            public a() {
            }

            @Override // defpackage.jr2
            public void onLoadingCancelled(String str, View view) {
                LogUtil.i(PhotoViewFragment.B, "onLoadingCancelled ");
                PhotoViewFragment.this.n.setVisibility(8);
                PhotoViewFragment.this.o.setVisibility(8);
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                PhotoViewFragment.this.n.setVisibility(8);
                PhotoViewFragment.this.o.setVisibility(8);
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                LogUtil.i(PhotoViewFragment.B, "onLoadingComplete big bitmap failed" + failReason.a());
                PhotoViewFragment.this.n.setVisibility(8);
                PhotoViewFragment.this.o.setVisibility(8);
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str, View view) {
                LogUtil.i(PhotoViewFragment.B, "onLoadingStarted " + PhotoViewFragment.this.w);
            }
        }

        public g() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingCancelled ");
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap == null || PhotoViewFragment.this.v.equals(PhotoViewFragment.this.s)) {
                LogUtil.i(PhotoViewFragment.B, "onLoadingComplete big bitmap failed");
                PhotoViewFragment.this.n.setVisibility(8);
                PhotoViewFragment.this.o.setVisibility(8);
                return;
            }
            PhotoViewFragment.this.h.setScaleType(PhotoView.getPhotoViewScaleType(PhotoViewFragment.this.d, bitmap));
            PhotoViewFragment.this.h.setMaxScale(PhotoView.getMaxScaleSize(PhotoViewFragment.this.d, bitmap));
            if (!TextUtils.isEmpty(PhotoViewFragment.this.s) && !PhotoViewFragment.this.p0()) {
                gr2.j().i(PhotoViewFragment.this.w, PhotoViewFragment.this.h, bq6.y(), new a());
                return;
            }
            LogUtil.i(PhotoViewFragment.B, "onLoadingCancelled ");
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingComplete thumbnail bitmap failed" + failReason.a());
            PhotoViewFragment.this.n.setVisibility(8);
            PhotoViewFragment.this.o.setVisibility(8);
            PhotoViewFragment.this.h.setImageResource(R.drawable.default_portrait);
            sy5.e(AppContext.getContext(), R.string.default_response_error, 1).g();
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            LogUtil.i(PhotoViewFragment.B, "onLoadingStarted " + PhotoViewFragment.this.v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12342a;

            public a(String str) {
                this.f12342a = str;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (charSequence.toString().equals(PhotoViewFragment.this.getString(R.string.string_forward))) {
                    PhotoViewFragment.this.l0().A1(PhotoViewFragment.this.r);
                    return;
                }
                if (!charSequence.toString().equals(PhotoViewFragment.this.getString(R.string.save_to_phone))) {
                    if (charSequence.toString().equals(PhotoViewFragment.this.getString(R.string.recognize_qr_code))) {
                        PhotoViewFragment.this.l0().D1(this.f12342a);
                        return;
                    }
                    return;
                }
                try {
                    PhotoViewFragment.this.l0().E1(PhotoViewFragment.this.r.localPath, TextUtils.isEmpty(PhotoViewFragment.this.r.fileFullPath) ? sd1.b(PhotoViewFragment.this.r.localPath) : sd1.b(PhotoViewFragment.this.r.fileFullPath));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
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
                        PhotoViewFragment.this.l0().E1(PhotoViewFragment.this.r.localPath, sd1.b(PhotoViewFragment.this.r.fileFullPath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public h() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PhotoViewFragment.this.m || PhotoViewFragment.this.z) {
                return true;
            }
            if (PhotoViewFragment.this.r.fileFullPath != null || PhotoViewFragment.this.r.localPath != null) {
                if (PhotoViewFragment.this.l0().B1() == 1) {
                    String strU0 = hx3.m(PhotoViewFragment.this.l0()) ? PhotoViewFragment.this.u0() : null;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(AppContext.getContext().getResources().getString(R.string.string_forward));
                    arrayList.add(AppContext.getContext().getResources().getString(R.string.save_to_phone));
                    if (strU0 != null) {
                        arrayList.add(AppContext.getContext().getResources().getString(R.string.recognize_qr_code));
                    }
                    new td3.c(PhotoViewFragment.this.l0()).c((String[]) arrayList.toArray(new String[0])).d(new a(strU0)).a().b();
                } else {
                    if (PhotoViewFragment.this.l0().B1() != 0 || PhotoViewFragment.this.p0()) {
                        return true;
                    }
                    new td3.c(PhotoViewFragment.this.l0()).c(new String[]{AppContext.getContext().getResources().getString(R.string.save_to_phone)}).d(new b()).a().b();
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("type", 0);
        }
    }

    public final BasePreviewActivity l0() {
        return (BasePreviewActivity) getActivity();
    }

    public Bitmap m0(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public final or2 n0() {
        or2 or2Var = PhotoView.sImageSize;
        if (or2Var != null) {
            this.d = or2Var;
        }
        return this.d;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.e("rxx", "photo veiw fragment onActivityCreated");
        if (this.r != null) {
            BasePreviewActivity basePreviewActivityL0 = l0();
            MediaItem mediaItem = this.r;
            String strY2 = PhotoViewActivity.Y2(mediaItem.fileFullPath, mediaItem.localPath);
            this.s = strY2;
            this.t = k86.J(strY2);
            String str = this.r.editedImagePath;
            if (str != null) {
                this.s = str;
            }
            this.w = k86.p(this.s);
            MediaItem mediaItem2 = this.r;
            String strY22 = PhotoViewActivity.Y2(mediaItem2.thumbnailPath, mediaItem2.localPath);
            this.u = strY22;
            this.v = k86.p(strY22);
            String str2 = this.w;
            if (str2 != null && str2.toLowerCase().endsWith(".gif") && "from_chat".equals(this.y)) {
                this.q.setVisibility(0);
                this.q.setText("GIF大小：" + il5.b(basePreviewActivityL0, this.r.fileSize));
            } else {
                this.q.setVisibility(8);
            }
            MediaItem mediaItem3 = this.r;
            String str3 = mediaItem3.extension;
            if (!mediaItem3.isFileExpired && str3 != null) {
                try {
                    String string = new JSONObject(str3).getString("midUrl");
                    if (string != null) {
                        gr2.j().g(string, this.h);
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.r.isFileExpired) {
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.h.setImageResource(R.drawable.transparent_drawable);
                this.p.setVisibility(0);
            } else {
                if (this.k) {
                    r0();
                } else {
                    gr2.j().i(this.w, this.h, this.j ? bq6.s() : bq6.h(!this.t), new b());
                }
                this.h.setOnLongClickListener(this.A);
                this.g.setOnLongClickListener(this.A);
            }
            this.h.setOnViewTapListener(new c(basePreviewActivityL0));
            this.g.setOnClickListener(new d(basePreviewActivityL0));
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t0(configuration.orientation != 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e("rxx", "photo veiw fragment onCreate");
        this.d = new or2(me1.g(), me1.f());
        int dimension = (int) getActivity().getResources().getDimension(R.dimen.chat_image_size);
        this.e = new or2(dimension, dimension);
        this.r = (MediaItem) getArguments().getParcelable(SquareDetailVideoView.KEY_ITEM);
        this.j = getArguments().getBoolean("from_portrait");
        this.m = getArguments().getBoolean("long_click");
        this.k = getArguments().getBoolean("from_user_portrait");
        this.l = getArguments().getBoolean("extra_is_friend");
        this.y = getArguments().getString("key_from");
        ds0.a().c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.e("rxx", "photo veiw fragment on create view");
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().getLayoutInflater().inflate(R.layout.item_photo_view, (ViewGroup) null);
        this.p = relativeLayout.findViewById(R.id.expiredLayout);
        this.n = (ProgressBar) relativeLayout.findViewById(R.id.prsbar);
        this.o = relativeLayout.findViewById(R.id.mask);
        this.h = (PhotoView) relativeLayout.findViewById(R.id.photoview);
        this.i = (TextView) relativeLayout.findViewById(R.id.photo_mask_text);
        this.g = (TouchImageView) relativeLayout.findViewById(R.id.photoview_big);
        this.q = (TextView) relativeLayout.findViewById(R.id.file_type_gif);
        this.f = relativeLayout;
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ds0.a().d(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @qm5
    public void onReceiveEvent(br2 br2Var) {
        View view = this.f;
        if (view != null) {
            view.post(new e(br2Var));
        }
    }

    public final boolean p0() {
        return false;
    }

    public final void r0() {
        gr2.j().i(this.v, this.h, bq6.y(), new g());
    }

    public final void s0(String str, boolean z) {
        this.z = true;
        if (l0() != null) {
            l0().F1(this.r.mid, z);
        }
        if (dr2.a()) {
            LogUtil.i(B, LogUtil.LogType.LOG_TYPE_IMG_LOAD_EXPIRE, 3, new f(str), (Throwable) null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || l0() == null) {
            return;
        }
        l0().updateCurrentPageInfo(l0(), new i());
    }

    public void t0(boolean z) {
        Bitmap bitmapM0 = m0(this.h);
        if (bitmapM0 != null) {
            this.h.setScaleType(PhotoView.getPhotoViewScaleType(this.d, bitmapM0, z));
            this.h.setMaxScale(PhotoView.getMaxScaleSize(this.d, bitmapM0));
        }
    }

    public final String u0() {
        Bitmap bitmap;
        if (this.h.getDrawable() == null || !(this.h.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) this.h.getDrawable()).getBitmap()) == null) {
            return null;
        }
        return op4.a(bitmap);
    }

    public final void w0(String str, TouchImageView touchImageView, PhotoView photoView) {
        x0(str, touchImageView, photoView, false);
    }

    public final void x0(String str, TouchImageView touchImageView, PhotoView photoView, boolean z) {
        Bitmap bitmapM0 = m0(photoView);
        String strP = k86.p(str);
        or2 or2VarM = xt.m(str);
        if (or2VarM == null || or2VarM.b() <= 0 || or2VarM.a() <= 0) {
            return;
        }
        String str2 = B;
        LogUtil.i(str2, "updateImageViewWithLocalImage srcImageSize bitmap" + or2VarM.b() + "*" + or2VarM.a() + " max =" + xt.p());
        if (bitmapM0 == null || or2VarM.b() > bitmapM0.getWidth()) {
            if ((or2VarM.a() >= xt.p() || or2VarM.b() >= xt.p()) && !xt.q(str)) {
                LogUtil.i(str2, "updateImageViewWithLocalImage TileBitmapDrawable");
                px5.e(bitmapM0, touchImageView, str, null, new j(touchImageView, photoView));
            } else if (this.x) {
                LogUtil.i(str2, "updateImageViewWithLocalImage load with getOriginDisplayImageOptions");
                if (getContext() == null) {
                    return;
                }
                hc2.a(getContext()).asBitmap().load(strP).diskCacheStrategy(!this.t ? DiskCacheStrategy.DATA : DiskCacheStrategy.NONE).error(R.drawable.ic_gallery_background).into(new a(photoView, photoView, z));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements px5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchImageView f12345a;
        public final /* synthetic */ PhotoView b;

        public j(TouchImageView touchImageView, PhotoView photoView) {
            this.f12345a = touchImageView;
            this.b = photoView;
        }

        @Override // px5.d
        public void b() {
            this.f12345a.setVisibility(0);
            this.b.setVisibility(8);
        }

        @Override // px5.d
        public void onError(Exception exc) {
            LogUtil.i(PhotoViewFragment.B, "TileBitmapDrawable attachTileBitmapDrawable onError" + exc);
        }

        @Override // px5.d
        public void a() {
        }
    }
}
