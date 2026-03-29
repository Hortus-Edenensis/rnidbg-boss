package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.webkit.WebView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.webplatform.R$string;
import com.zenmen.palmchat.webplatform.miniPrograms.Package;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pp3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }
    }

    public static void a(Context context, Package r3, String str, String str2, String str3) {
        fx4 fx4Var = new fx4();
        fx4Var.f17619a = 0;
        fx4Var.b = str3;
        fx4Var.e = r3;
        fx4Var.c = str;
        fx4Var.d = str2;
        fs3.c(context, fx4Var);
    }

    public static Bitmap b(WebView webView) {
        Picture pictureCapturePicture = webView.capturePicture();
        int width = pictureCapturePicture.getWidth();
        int height = pictureCapturePicture.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static String c(WebView webView) {
        Bitmap bitmapB = b(webView);
        if (bitmapB != null) {
            return d(webView.getContext(), bitmapB);
        }
        return null;
    }

    public static String d(Context context, Bitmap bitmap) {
        File file = new File(context.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                if (bitmap != null) {
                }
                return file.getAbsolutePath();
            }
            bitmap.recycle();
            return file.getAbsolutePath();
        } catch (Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static void e(Context context) {
        new sd3(context).T(R$string.mini_program_load_failed_title).j(R$string.mini_program_load_failed_content).O(R$string.dialog_confirm).f(new a()).Q();
    }
}
