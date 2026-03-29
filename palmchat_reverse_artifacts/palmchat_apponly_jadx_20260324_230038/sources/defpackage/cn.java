package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.litesuits.async.AsyncTask;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cn extends AsyncTask<Void, Void, Bitmap> {
    public static Executor r = vw5.a(cn.class.getSimpleName());
    public rn m;
    public LoadCountBean.MarkerBean n;
    public Bitmap o;
    public Bitmap p;
    public boolean q;

    public cn(LoadCountBean.MarkerBean markerBean, Bitmap bitmap, rn rnVar, Bitmap bitmap2, boolean z) {
        this.m = rnVar;
        this.o = bitmap;
        this.n = markerBean;
        this.p = bitmap2;
        this.q = z;
    }

    public static void v(LoadCountBean.MarkerBean markerBean, Bitmap bitmap, rn rnVar, Bitmap bitmap2, boolean z) {
        new cn(markerBean, bitmap, rnVar, bitmap2, z).i(r, new Void[0]);
    }

    @Override // com.litesuits.async.AsyncTask
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Bitmap g(Void... voidArr) {
        return t(this.n.avatarBitmap);
    }

    public final Bitmap t(Bitmap bitmap) {
        if (this.q) {
            return ew1.v(bitmap, this.n, 0);
        }
        int iB = a46.b(AppContext.getContext(), 61.0f);
        int iB2 = a46.b(AppContext.getContext(), 65.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, Bitmap.Config.ARGB_8888);
        int iB3 = iB2 - a46.b(AppContext.getContext(), 10.0f);
        int iMin = Math.min(bitmap.getHeight(), bitmap.getWidth());
        int width = (bitmap.getWidth() * iB3) / iMin;
        int height = (iB3 * bitmap.getHeight()) / iMin;
        ma3.a("avatar.getHeight():" + bitmap.getHeight() + " avatar.getWidth():" + bitmap.getWidth() + " targetWidth:" + width + " targetHeight:" + height + " minSize" + iMin, new Object[0]);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        if (this.n.isBlur) {
            bitmapCreateScaledBitmap = ft1.a(bitmapCreateScaledBitmap, 10, true);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(this.o, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateScaledBitmap, tileMode, tileMode));
        canvas.drawCircle(a46.b(AppContext.getContext(), 30.5f), a46.b(AppContext.getContext(), 30.5f), a46.b(AppContext.getContext(), 21.0f), paint);
        if (vc3.c()) {
            int i = this.n.gender;
            LogUtil.d("MapPendantManager", "genAvatarMark gender " + i + " portraitBitmap " + this.p);
            if (i != -1) {
                int iB4 = a46.b(AppContext.getContext(), 14.0f);
                int iB5 = a46.b(AppContext.getContext(), 14.0f);
                int iB6 = a46.b(AppContext.getContext(), 38.0f);
                try {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(AppContext.getContext().getResources(), i == 0 ? R.drawable.map_sex_male : R.drawable.map_sex_female);
                    Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeResource, iB4, iB5, false);
                    float f = iB6;
                    canvas.drawBitmap(bitmapCreateScaledBitmap2, f, f, (Paint) null);
                    bitmapDecodeResource.recycle();
                    bitmapCreateScaledBitmap2.recycle();
                } catch (Exception e) {
                    LogUtil.d("MapPendantManager", "genAvatarMark Exception " + e.toString());
                }
            }
            Bitmap bitmap2 = this.p;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap3 = Bitmap.createScaledBitmap(this.p, iB, iB2, false);
                canvas.drawBitmap(bitmapCreateScaledBitmap3, 0.0f, 0.0f, (Paint) null);
                bitmapCreateScaledBitmap3.recycle();
            }
        }
        bitmapCreateScaledBitmap.recycle();
        return bitmapCreateBitmap;
    }

    @Override // com.litesuits.async.AsyncTask
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void n(Bitmap bitmap) {
        rn rnVar = this.m;
        if (rnVar != null) {
            rnVar.run(1, null, bitmap);
        }
    }
}
