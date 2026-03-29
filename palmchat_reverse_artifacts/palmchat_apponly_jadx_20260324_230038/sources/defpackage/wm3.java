package defpackage;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.Log;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wm3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MediaScannerConnection.OnScanCompletedListener {
        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            Log.i("MediaScannerConnection", "Scanned " + str + ":");
            StringBuilder sb = new StringBuilder();
            sb.append("-> uri=");
            sb.append(uri);
            Log.i("MediaScannerConnection", sb.toString());
        }
    }

    public static void a(String str) {
        MediaScannerConnection.scanFile(c.b(), new String[]{str}, null, new a());
        LogUtil.logStack("MediaScannerConnection" + str);
    }
}
