package com.zenmen.palmchat.utils.ImageUtils;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase;
import com.zenmen.palmchat.utils.ImageUtils.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a63;
import defpackage.ir5;
import defpackage.uy4;
import defpackage.w56;
import defpackage.xt;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CropImageActivity extends com.zenmen.palmchat.utils.ImageUtils.c {
    public static final String H = "CropImageActivity";
    public static final boolean I = false;
    public boolean A;
    public int B;
    public uy4 C;
    public CropImageView E;
    public com.zenmen.palmchat.utils.ImageUtils.b F;
    public TextView G;
    public final Handler r = new Handler();
    public int s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public Uri y;
    public Uri z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ImageViewTouchBase.c {
        public a() {
        }

        @Override // com.zenmen.palmchat.utils.ImageUtils.ImageViewTouchBase.c
        public void a(Bitmap bitmap) {
            bitmap.recycle();
            System.gc();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CropImageActivity.this.Y1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f15695a;

            public a(CountDownLatch countDownLatch) {
                this.f15695a = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CropImageActivity.this.E.getScale() == 1.0f) {
                    CropImageActivity.this.E.center(true, true);
                }
                this.f15695a.countDown();
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            CropImageActivity.this.r.post(new a(countDownLatch));
            try {
                countDownLatch.await();
                new h().b();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<Bitmap, Void, Bitmap> {
        public ProgressDialog m;
        public final /* synthetic */ Rect n;

        public d(Rect rect) {
            this.n = rect;
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            CropImageActivity cropImageActivity = CropImageActivity.this;
            this.m = ProgressDialog.show(cropImageActivity, null, cropImageActivity.getResources().getString(R.string.crop__saving), true, false);
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Bitmap g(Bitmap... bitmapArr) {
            try {
                return CropImageActivity.this.S1(bitmapArr[0], this.n);
            } catch (IllegalArgumentException e) {
                CropImageActivity.this.d2(e);
                return null;
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Bitmap bitmap) {
            if (bitmap == null) {
                this.m.dismiss();
                CropImageActivity.this.finish();
            } else {
                CropImageActivity.this.E.setImageRotateBitmapResetBase(new uy4(bitmap, CropImageActivity.this.x), true);
                CropImageActivity.this.E.center(true, true);
                CropImageActivity.this.E.highlightViews.clear();
                CropImageActivity.this.a2(bitmap, this.m);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f15696a;

        public e(Bitmap bitmap) {
            this.f15696a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            CropImageActivity.this.b2(this.f15696a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f15697a;

        public f(Bitmap bitmap) {
            this.f15697a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            CropImageActivity.this.b2(this.f15697a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f15698a;

        public g(Bitmap bitmap) {
            this.f15698a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageActivity.this.E.clear();
            this.f15698a.recycle();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
                CropImageActivity.this.E.invalidate();
                if (CropImageActivity.this.E.highlightViews.size() == 1) {
                    CropImageActivity cropImageActivity = CropImageActivity.this;
                    cropImageActivity.F = cropImageActivity.E.highlightViews.get(0);
                    CropImageActivity.this.F.p(true);
                }
            }
        }

        public void b() {
            CropImageActivity.this.r.post(new a());
        }

        public final void c() {
            int i;
            if (CropImageActivity.this.C == null) {
                return;
            }
            com.zenmen.palmchat.utils.ImageUtils.b bVar = new com.zenmen.palmchat.utils.ImageUtils.b(CropImageActivity.this.E);
            int iE = CropImageActivity.this.C.e();
            int iB = CropImageActivity.this.C.b();
            boolean z = false;
            Rect rect = new Rect(0, 0, iE, iB);
            int iMin = (Math.min(iE, iB) * 4) / 5;
            if (CropImageActivity.this.s == 0 || CropImageActivity.this.t == 0) {
                i = iMin;
            } else if (CropImageActivity.this.s > CropImageActivity.this.t) {
                i = (CropImageActivity.this.t * iMin) / CropImageActivity.this.s;
            } else {
                i = iMin;
                iMin = (CropImageActivity.this.s * iMin) / CropImageActivity.this.t;
            }
            RectF rectF = new RectF((iE - iMin) / 2, (iB - i) / 2, r1 + iMin, r2 + i);
            Matrix unrotatedMatrix = CropImageActivity.this.E.getUnrotatedMatrix();
            if (CropImageActivity.this.s != 0 && CropImageActivity.this.t != 0) {
                z = true;
            }
            bVar.r(unrotatedMatrix, rect, rectF, z);
            CropImageActivity.this.E.add(bVar);
        }

        public h() {
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c
    public /* bridge */ /* synthetic */ void A1(c.b bVar) {
        super.A1(bVar);
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c
    public /* bridge */ /* synthetic */ void B1(c.b bVar) {
        super.B1(bVar);
    }

    public final byte[] P1(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final int Q1(Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                com.zenmen.palmchat.utils.ImageUtils.a.a(inputStreamOpenInputStream);
                int iT1 = T1();
                while (true) {
                    if (options.outHeight / i <= iT1 && options.outWidth / i <= iT1) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                com.zenmen.palmchat.utils.ImageUtils.a.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void R1() {
        this.E.clear();
        uy4 uy4Var = this.C;
        if (uy4Var != null) {
            uy4Var.g();
        }
        System.gc();
    }

    @TargetApi(10)
    public final Bitmap S1(Bitmap bitmap, Rect rect) {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                try {
                    try {
                        inputStreamOpenInputStream = getContentResolver().openInputStream(this.y);
                        long jB = ir5.b();
                        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                        LogUtil.i(H + "-new", ir5.e(jB) + "");
                    } catch (OutOfMemoryError e2) {
                        a63.a("OOM cropping image: " + e2.getMessage(), e2);
                        d2(e2);
                    }
                } catch (IOException unused) {
                    bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(P1(BitmapFactory.decodeFile(w56.d(this, this.y))), 0, r4.length - 1, false);
                }
                int width = bitmapRegionDecoderNewInstance.getWidth();
                int height = bitmapRegionDecoderNewInstance.getHeight();
                if (this.x != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(-this.x);
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, new RectF(rect));
                    rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                    rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                }
                try {
                    long jB2 = ir5.b();
                    bitmap = bitmapRegionDecoderNewInstance.decodeRegion(rect, new BitmapFactory.Options());
                    LogUtil.i(H + "-decodeRegion", ir5.e(jB2) + "");
                } catch (IllegalArgumentException e3) {
                    throw new IllegalArgumentException("Rectangle " + rect + " is outside of the image (" + width + "," + height + "," + this.x + ")", e3);
                }
            } catch (IOException e4) {
                a63.a("Error cropping image: " + e4.getMessage(), e4);
                finish();
            }
            return bitmap;
        } finally {
            com.zenmen.palmchat.utils.ImageUtils.a.a(inputStreamOpenInputStream);
        }
    }

    public final int T1() {
        int iU1 = U1();
        if (iU1 == 0) {
            return 2048;
        }
        return Math.min(iU1, 4096);
    }

    public final int U1() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    public final Bitmap V1(uy4 uy4Var, Bitmap bitmap, Rect rect, int i, int i2, int i3, int i4) {
        System.gc();
        try {
            bitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.FILL);
            matrix.preConcat(uy4Var.c());
            canvas.drawBitmap(uy4Var.a(), matrix, null);
        } catch (OutOfMemoryError e2) {
            a63.a("OOM cropping image: " + e2.getMessage(), e2);
            d2(e2);
            System.gc();
        }
        R1();
        return bitmap;
    }

    public final void W1() {
        CropImageView cropImageView = (CropImageView) findViewById(R.id.crop_image);
        this.E = cropImageView;
        cropImageView.context = this;
        cropImageView.setRecycler(new a());
    }

    public boolean X1() {
        return this.A;
    }

    public final void Y1() {
        int i;
        int i2;
        uy4 uy4Var;
        int i3;
        com.zenmen.palmchat.utils.ImageUtils.b bVar = this.F;
        if (bVar == null || this.A) {
            return;
        }
        this.A = true;
        Rect rectH = bVar.h(this.B);
        int iWidth = rectH.width();
        int iHeight = rectH.height();
        int i4 = this.u;
        if (i4 <= 0 || (i3 = this.v) <= 0 || (iWidth <= i4 && iHeight <= i3)) {
            i = iWidth;
            i2 = iHeight;
        } else {
            float f2 = iWidth / iHeight;
            if (i4 / i3 > f2) {
                i4 = (int) ((i3 * f2) + 0.5f);
            } else {
                i3 = (int) ((i4 / f2) + 0.5f);
            }
            i = i4;
            i2 = i3;
        }
        if (!I || (uy4Var = this.C) == null) {
            new d(rectH).h(null);
            return;
        }
        Bitmap bitmapV1 = V1(uy4Var, null, rectH, iWidth, iHeight, i, i2);
        if (bitmapV1 != null) {
            this.E.setImageBitmapResetBase(bitmapV1, true);
            this.E.center(true, true);
            this.E.highlightViews.clear();
        }
        Z1(bitmapV1);
    }

    public final void Z1(Bitmap bitmap) {
        if (bitmap != null) {
            com.zenmen.palmchat.utils.ImageUtils.a.e(this, null, getResources().getString(R.string.crop__saving), new e(bitmap), this.r);
        } else {
            finish();
        }
    }

    public final void a2(Bitmap bitmap, ProgressDialog progressDialog) {
        if (bitmap != null) {
            com.zenmen.palmchat.utils.ImageUtils.a.f(this, null, getResources().getString(R.string.crop__saving), new f(bitmap), this.r, progressDialog);
        } else {
            finish();
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x005c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:93), block:B:23:0x005c */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[Catch: all -> 0x005b, IOException -> 0x005e, TryCatch #3 {all -> 0x005b, blocks: (B:8:0x0012, B:9:0x0019, B:16:0x0034, B:18:0x0038, B:20:0x0041, B:19:0x003d, B:15:0x0023, B:25:0x005f), top: B:38:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[Catch: all -> 0x005b, IOException -> 0x005e, TryCatch #3 {all -> 0x005b, blocks: (B:8:0x0012, B:9:0x0019, B:16:0x0034, B:18:0x0038, B:20:0x0041, B:19:0x003d, B:15:0x0023, B:25:0x005f), top: B:38:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b2(Bitmap bitmap) throws Throwable {
        OutputStream fileOutputStream;
        Closeable closeable;
        if (this.z != null) {
            Closeable closeable2 = null;
            IOException e2 = null;
            try {
                try {
                    fileOutputStream = getContentResolver().openOutputStream(this.z);
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    com.zenmen.palmchat.utils.ImageUtils.a.a(closeable2);
                    throw th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException e3) {
                fileOutputStream = null;
                e2 = e3;
            } catch (Throwable th2) {
                th = th2;
                com.zenmen.palmchat.utils.ImageUtils.a.a(closeable2);
                throw th;
            }
            if (fileOutputStream != null) {
                boolean zI = !this.w ? xt.i(bitmap, fileOutputStream) : xt.g(bitmap, fileOutputStream);
                LogUtil.e(H, "compressBitmap2OutPutSteam result:" + zI);
                com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
                if (!I) {
                    com.zenmen.palmchat.utils.ImageUtils.a.b(com.zenmen.palmchat.utils.ImageUtils.a.d(getContentResolver(), this.y), com.zenmen.palmchat.utils.ImageUtils.a.d(getContentResolver(), this.z));
                }
                c2(this.z, e2);
            } else {
                try {
                    try {
                        throw new FileNotFoundException("outputStream is null");
                    } catch (FileNotFoundException unused2) {
                        fileOutputStream = new FileOutputStream(new File(this.z.getPath()));
                        if (!this.w) {
                        }
                        LogUtil.e(H, "compressBitmap2OutPutSteam result:" + zI);
                        com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
                        if (!I) {
                        }
                        c2(this.z, e2);
                        this.r.post(new g(bitmap));
                        finish();
                    }
                } catch (IOException e4) {
                    e2 = e4;
                }
            }
            e2 = e4;
            d2(e2);
            a63.a("Cannot open file: " + this.z, e2);
            com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
            if (!I) {
            }
            c2(this.z, e2);
        }
        this.r.post(new g(bitmap));
        finish();
    }

    public final void c2(Uri uri, Throwable th) {
        Intent intent = new Intent();
        intent.putExtra("output", uri);
        intent.putExtra("error", th);
        setResult(-1, intent);
    }

    public final void d2(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final void e2() throws Throwable {
        Throwable th;
        InputStream inputStreamOpenInputStream;
        OutOfMemoryError e2;
        IOException e3;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.s = extras.getInt("aspect_x");
            this.t = extras.getInt("aspect_y");
            this.u = extras.getInt("max_x");
            this.v = extras.getInt("max_y");
            this.w = extras.getBoolean("head_portrait", false);
            this.z = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.y = data;
        if (data != null) {
            ContentResolver contentResolver = getContentResolver();
            ?? r1 = this.y;
            this.x = com.zenmen.palmchat.utils.ImageUtils.a.c(com.zenmen.palmchat.utils.ImageUtils.a.d(contentResolver, r1));
            try {
                try {
                    this.B = Q1(this.y);
                    inputStreamOpenInputStream = getContentResolver().openInputStream(this.y);
                } catch (Throwable th2) {
                    th = th2;
                    com.zenmen.palmchat.utils.ImageUtils.a.a(r1);
                    throw th;
                }
            } catch (IOException e4) {
                inputStreamOpenInputStream = null;
                e3 = e4;
            } catch (OutOfMemoryError e5) {
                inputStreamOpenInputStream = null;
                e2 = e5;
            } catch (Throwable th3) {
                r1 = 0;
                th = th3;
                com.zenmen.palmchat.utils.ImageUtils.a.a(r1);
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.B;
                this.C = new uy4(BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options), this.x);
                r1 = inputStreamOpenInputStream;
            } catch (IOException e6) {
                e3 = e6;
                a63.a("Error reading image: " + e3.getMessage(), e3);
                d2(e3);
                r1 = inputStreamOpenInputStream;
            } catch (OutOfMemoryError e7) {
                e2 = e7;
                a63.a("OOM reading image: " + e2.getMessage(), e2);
                d2(e2);
                r1 = inputStreamOpenInputStream;
            }
            com.zenmen.palmchat.utils.ImageUtils.a.a(r1);
        }
    }

    public final void f2() {
        if (isFinishing()) {
            return;
        }
        this.E.setImageRotateBitmapResetBase(this.C, true);
        com.zenmen.palmchat.utils.ImageUtils.a.e(this, null, getResources().getString(R.string.crop__wait), new c(), this.r);
    }

    public final void initActionBar() {
        initToolbar(-1);
        ((TextView) getToolbar().findViewById(R.id.title)).setText(R.string.media_pick_activity_title);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.G = textView;
        textView.setText(R.string.string_use);
        this.G.setOnClickListener(new b());
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c, com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_image_crop);
        W1();
        initActionBar();
        e2();
        if (this.C == null) {
            finish();
        } else {
            f2();
        }
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        uy4 uy4Var = this.C;
        if (uy4Var != null) {
            uy4Var.g();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        setResult(0);
        finish();
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }
}
