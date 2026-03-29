package defpackage;

import android.app.Activity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wc1 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    public static void a(Activity activity, String str) {
        new sd3(activity).k(str).O(R.string.red_packet_timeout_know).f(new a()).e().show();
    }
}
