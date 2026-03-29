package com.zenmen.palmchat.utils.ImageUtils;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.ImageUtils.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a63;
import defpackage.xt;
import io.togoto.imagezoomcrop.cropoverlay.CropOverlayView;
import io.togoto.imagezoomcrop.photoview.PhotoView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NewCropImageActivity extends com.zenmen.palmchat.utils.ImageUtils.c {
    public static final String C = "NewCropImageActivity";
    public AsyncTask B;
    public ContentResolver r;
    public Uri s;
    public Uri t;
    public boolean u;
    public PhotoView x;
    public CropOverlayView y;
    public boolean z;
    public int v = 0;
    public float w = 1.0f;
    public final Handler A = new Handler();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewCropImageActivity.this.K1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Bitmap bitmapH1 = NewCropImageActivity.this.H1();
            if (bitmapH1 != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(NewCropImageActivity.this.getResources(), bitmapH1);
                float minimumScaleToFit = NewCropImageActivity.this.x.setMinimumScaleToFit(bitmapDrawable);
                NewCropImageActivity.this.x.setMaximumScale(9.0f * minimumScaleToFit);
                NewCropImageActivity.this.x.setMediumScale(5.0f * minimumScaleToFit);
                NewCropImageActivity.this.x.setScale(minimumScaleToFit);
                NewCropImageActivity.this.x.setImageDrawable(bitmapDrawable);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<Bitmap, Void, Bitmap> {
        public ProgressDialog m;

        public c() {
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            NewCropImageActivity newCropImageActivity = NewCropImageActivity.this;
            this.m = ProgressDialog.show(newCropImageActivity, null, newCropImageActivity.getResources().getString(R.string.crop__saving), true, false);
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Bitmap g(Bitmap... bitmapArr) {
            try {
                return NewCropImageActivity.this.x.getCroppedImage();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Bitmap bitmap) {
            NewCropImageActivity.this.M1(bitmap, this.m);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f15705a;

        public d(Bitmap bitmap) {
            this.f15705a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            NewCropImageActivity.this.N1(this.f15705a);
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

    public final int G1(Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = this.r.openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                com.zenmen.palmchat.utils.ImageUtils.a.a(inputStreamOpenInputStream);
                int iI1 = I1();
                while (true) {
                    if (options.outHeight / i <= iI1 && options.outWidth / i <= iI1) {
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

    public final Bitmap H1() throws Throwable {
        InputStream inputStreamOpenInputStream;
        int iG1;
        Uri uri = this.s;
        InputStream inputStream = null;
        bitmapDecodeStream = null;
        Bitmap bitmapDecodeStream = null;
        try {
            if (uri == null) {
                return null;
            }
            try {
                iG1 = G1(uri);
                inputStreamOpenInputStream = this.r.openInputStream(this.s);
            } catch (IOException e) {
                e = e;
                inputStreamOpenInputStream = null;
            } catch (OutOfMemoryError e2) {
                e = e2;
                inputStreamOpenInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = iG1;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            } catch (IOException e3) {
                e = e3;
                a63.a("Error reading image: " + e.getMessage(), e);
                P1(e);
            } catch (OutOfMemoryError e4) {
                e = e4;
                a63.a("OOM reading image: " + e.getMessage(), e);
                P1(e);
            }
            com.zenmen.palmchat.utils.ImageUtils.a.a(inputStreamOpenInputStream);
            int iC = com.zenmen.palmchat.utils.ImageUtils.a.c(com.zenmen.palmchat.utils.ImageUtils.a.d(this.r, this.s));
            if (bitmapDecodeStream == null || iC == 0) {
                return bitmapDecodeStream;
            }
            Bitmap bitmapL1 = L1(bitmapDecodeStream, iC);
            bitmapDecodeStream.recycle();
            return bitmapL1;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
        }
        com.zenmen.palmchat.utils.ImageUtils.a.a(inputStream);
        throw th;
    }

    public final int I1() {
        int iJ1 = J1();
        if (iJ1 == 0) {
            return 2048;
        }
        return Math.min(iJ1, 4096);
    }

    public final int J1() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    public final void K1() {
        if (this.z) {
            return;
        }
        this.z = true;
        this.B = new c().h(new Bitmap[0]);
    }

    public final Bitmap L1(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public final void M1(Bitmap bitmap, ProgressDialog progressDialog) {
        if (bitmap != null) {
            com.zenmen.palmchat.utils.ImageUtils.a.f(this, null, getResources().getString(R.string.crop__saving), new d(bitmap), this.A, progressDialog);
        } else {
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[Catch: all -> 0x005f, IOException -> 0x0062, TryCatch #3 {IOException -> 0x0062, blocks: (B:8:0x000e, B:9:0x0015, B:17:0x002f, B:19:0x0033, B:24:0x0045, B:20:0x0038, B:22:0x003c, B:23:0x0041, B:16:0x001e), top: B:38:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038 A[Catch: all -> 0x005f, IOException -> 0x0062, TryCatch #3 {IOException -> 0x0062, blocks: (B:8:0x000e, B:9:0x0015, B:17:0x002f, B:19:0x0033, B:24:0x0045, B:20:0x0038, B:22:0x003c, B:23:0x0041, B:16:0x001e), top: B:38:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N1(Bitmap bitmap) throws Throwable {
        OutputStream fileOutputStream;
        boolean zH;
        Uri uri = this.t;
        if (uri != null) {
            OutputStream outputStream = null;
            IOException iOException = null;
            try {
                fileOutputStream = this.r.openOutputStream(uri);
            } catch (FileNotFoundException unused) {
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                com.zenmen.palmchat.utils.ImageUtils.a.a(outputStream);
                throw th;
            }
            if (fileOutputStream == null) {
                try {
                    try {
                        try {
                            throw new FileNotFoundException("outputStream is null");
                        } catch (FileNotFoundException unused2) {
                            fileOutputStream = new FileOutputStream(new File(this.t.getPath()));
                            if (this.u) {
                            }
                            LogUtil.e(C, "result:" + zH);
                            com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
                            O1(this.t, iOException);
                            finish();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        iOException = e;
                        P1(iOException);
                        a63.a("Cannot open file: " + this.t, iOException);
                        com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
                        O1(this.t, iOException);
                        finish();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    com.zenmen.palmchat.utils.ImageUtils.a.a(outputStream);
                    throw th;
                }
            }
            if (this.u) {
                int i = this.v;
                zH = i > 0 ? xt.h(bitmap, fileOutputStream, i) : xt.g(bitmap, fileOutputStream);
            } else {
                zH = xt.i(bitmap, fileOutputStream);
            }
            LogUtil.e(C, "result:" + zH);
            com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
            O1(this.t, iOException);
            e = e2;
            iOException = e;
            P1(iOException);
            a63.a("Cannot open file: " + this.t, iOException);
            com.zenmen.palmchat.utils.ImageUtils.a.a(fileOutputStream);
            O1(this.t, iOException);
        }
        finish();
    }

    public final void O1(Uri uri, Throwable th) {
        Intent intent = new Intent();
        intent.putExtra("output", uri);
        intent.putExtra("error", th);
        setResult(-1, intent);
    }

    public final void P1(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }

    public final void Q1() {
        Intent intent = getIntent();
        this.s = getIntent().getData();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.t = (Uri) extras.getParcelable("output");
            this.u = extras.getBoolean("head_portrait", false);
            this.v = extras.getInt("max_size", 0);
            this.w = extras.getFloat("ratio", 1.0f);
        }
        this.y.post(new b());
        this.y.setRatio(this.w);
    }

    public final void initActionBar() {
        initToolbar(-1);
        ((TextView) getToolbar().findViewById(R.id.title)).setText(R.string.media_pick_activity_title);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        textView.setText(R.string.string_use);
        textView.setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c, com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_crop);
        this.r = getContentResolver();
        this.x = (PhotoView) findViewById(R.id.iv_photo);
        CropOverlayView cropOverlayView = (CropOverlayView) findViewById(R.id.crop_overlay);
        this.y = cropOverlayView;
        this.x.setImageBoundsListener(cropOverlayView);
        Q1();
        initActionBar();
    }

    @Override // com.zenmen.palmchat.utils.ImageUtils.c, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.B;
        if (asyncTask != null) {
            asyncTask.f(true);
        }
    }
}
