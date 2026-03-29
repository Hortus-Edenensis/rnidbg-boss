package com.zenmen.imageeditengine.views.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.zenmen.imageeditengine.views.cropimage.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class b extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<CropImageView> f11829a;
    public final Uri b;
    public final Context c;
    public final int d;
    public final int e;

    public b(CropImageView cropImageView, Uri uri) {
        this.b = uri;
        this.f11829a = new WeakReference<>(cropImageView);
        this.c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d = displayMetrics.density > 1.0f ? 1.0f / r6 : 1.0d;
        this.d = (int) (((double) displayMetrics.widthPixels) * d);
        this.e = (int) (((double) displayMetrics.heightPixels) * d);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) throws Throwable {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a aVarL = c.l(this.c, this.b, this.d, this.e);
            if (isCancelled()) {
                return null;
            }
            c.b bVarA = c.A(aVarL.f11832a, this.c, this.b);
            return new a(this.b, bVarA.f11833a, aVarL.b, bVarA.b);
        } catch (Exception e) {
            return new a(this.b, e);
        }
    }

    public Uri b() {
        return this.b;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        boolean z;
        Bitmap bitmap;
        CropImageView cropImageView;
        if (aVar != null) {
            if (isCancelled() || (cropImageView = this.f11829a.get()) == null) {
                z = false;
            } else {
                cropImageView.onSetImageUriAsyncComplete(aVar);
                z = true;
            }
            if (z || (bitmap = aVar.b) == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f11830a;
        public final Bitmap b;
        public final int c;
        public final int d;
        public final Exception e;

        public a(Uri uri, Bitmap bitmap, int i, int i2) {
            this.f11830a = uri;
            this.b = bitmap;
            this.c = i;
            this.d = i2;
            this.e = null;
        }

        public a(Uri uri, Exception exc) {
            this.f11830a = uri;
            this.b = null;
            this.c = 0;
            this.d = 0;
            this.e = exc;
        }
    }
}
