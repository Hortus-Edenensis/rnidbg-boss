package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class y extends LinearLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f3994a;
    private ImageView b;
    private Context c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private int l;
    private boolean m;
    private boolean n;

    @Deprecated
    public y(Context context) {
        super(context);
        this.m = false;
        this.n = false;
        this.c = context;
        a();
        if (this.d == null || this.e == null || this.f == null || this.g == null) {
            return;
        }
        this.f3994a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        this.f3994a.setImageBitmap(this.d);
        this.b.setImageBitmap(this.f);
        this.l = a(this.f.getHeight() / 6);
        a(this.f3994a, "main_topbtn_up.9.png");
        a(this.b, "main_bottombtn_up.9.png");
        this.f3994a.setId(0);
        this.b.setId(1);
        this.f3994a.setClickable(true);
        this.b.setClickable(true);
        this.f3994a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f3994a);
        addView(this.b);
        this.n = true;
    }

    private void a() {
        this.d = a("main_icon_zoomin.png");
        this.e = a("main_icon_zoomin_dis.png");
        this.f = a("main_icon_zoomout.png");
        this.g = a("main_icon_zoomout_dis.png");
    }

    private void b() {
        this.h = a("wear_zoom_in.png");
        this.i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public boolean c() {
        return this.n;
    }

    public void d() {
        Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        Bitmap bitmap3 = this.f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f.recycle();
            this.f = null;
        }
        Bitmap bitmap4 = this.g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        Bitmap bitmap5 = this.h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        Bitmap bitmap6 = this.i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        Bitmap bitmap7 = this.j;
        if (bitmap7 != null && !bitmap7.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        Bitmap bitmap8 = this.k;
        if (bitmap8 == null || bitmap8.isRecycled()) {
            return;
        }
        this.k.recycle();
        this.k = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(view instanceof ImageView)) {
            return false;
        }
        int id = ((ImageView) view).getId();
        if (id == 0) {
            if (motionEvent.getAction() == 0) {
                if (this.m) {
                    this.f3994a.setImageBitmap(this.i);
                    return false;
                }
                a(this.f3994a, "main_topbtn_down.9.png");
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (this.m) {
                this.f3994a.setImageBitmap(this.h);
                return false;
            }
            a(this.f3994a, "main_topbtn_up.9.png");
            return false;
        }
        if (id != 1) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            if (this.m) {
                this.b.setImageBitmap(this.k);
                return false;
            }
            a(this.b, "main_bottombtn_down.9.png");
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (this.m) {
            this.b.setImageBitmap(this.j);
            return false;
        }
        a(this.b, "main_bottombtn_up.9.png");
        return false;
    }

    public void setIsZoomInEnabled(boolean z) {
        ImageView imageView = this.f3994a;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z);
        if (z) {
            this.f3994a.setImageBitmap(this.d);
        } else {
            this.f3994a.setImageBitmap(this.e);
        }
    }

    public void setIsZoomOutEnabled(boolean z) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z);
        if (z) {
            this.b.setImageBitmap(this.f);
        } else {
            this.b.setImageBitmap(this.g);
        }
    }

    public void setOnZoomInClickListener(View.OnClickListener onClickListener) {
        this.f3994a.setOnClickListener(onClickListener);
    }

    public void setOnZoomOutClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    private void a(View view, String str) {
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, this.c);
        byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
        int i = this.l;
        view.setPadding(i, i, i, i);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi > 480) {
            matrix.postScale(1.8f, 1.8f);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            matrix.postScale(1.5f, 1.5f);
        } else {
            matrix.postScale(1.2f, 1.2f);
        }
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, this.c);
        if (bitmapLoadAssetsFile == null) {
            return null;
        }
        return Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
    }

    private int a(int i) {
        return (int) ((this.c.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    public y(Context context, boolean z) {
        super(context);
        this.n = false;
        this.c = context;
        this.m = z;
        this.f3994a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        if (z) {
            b();
            if (this.h == null || this.i == null || this.j == null || this.k == null) {
                return;
            }
            this.f3994a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f3994a.setImageBitmap(this.h);
            this.b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            a();
            Bitmap bitmap = this.d;
            if (bitmap == null || this.e == null || this.f == null || this.g == null) {
                return;
            }
            this.f3994a.setImageBitmap(bitmap);
            this.b.setImageBitmap(this.f);
            this.l = a(this.f.getHeight() / 6);
            a(this.f3994a, "main_topbtn_up.9.png");
            a(this.b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f3994a.setId(0);
        this.b.setId(1);
        this.f3994a.setClickable(true);
        this.b.setClickable(true);
        this.f3994a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        addView(this.f3994a);
        addView(this.b);
        this.n = true;
    }
}
