package defpackage;

import android.app.Activity;
import android.graphics.BitmapFactory;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.mediapick.MediaItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u92 {
    public static int a(MediaItem mediaItem) {
        String str;
        if (mediaItem != null && mediaItem.mimeType == 0 && (str = mediaItem.fileFullPath) != null && b(str)) {
            if (mediaItem.fileSize > 10485760) {
                return -1;
            }
            if (!pu1.b(mediaItem.fileFullPath)) {
                return -5;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mediaItem.fileFullPath, options);
            if (options.outWidth > 1280 || options.outHeight > 1280) {
                return -6;
            }
        }
        return 0;
    }

    public static boolean b(String str) {
        if (str != null) {
            return str.toLowerCase().endsWith(".gif");
        }
        return false;
    }

    public static void c(Activity activity, int i) {
        sd3 sd3Var = new sd3(activity);
        int i2 = R.string.gif_filter_large;
        if (i != -1) {
            if (i == -4) {
                i2 = R.string.gif_filter_unsupport;
            } else if (i == -5) {
                i2 = R.string.gif_filter_not_exit;
            } else if (i == -6) {
                i2 = R.string.gif_filter_size_too_large;
            }
        }
        sd3Var.j(i2).O(R.string.alert_dialog_ok).e().show();
    }
}
