package defpackage;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.MaterialDialog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x93 extends MaterialDialog {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends sd3 {
        public a(@NonNull Context context) {
            super(context);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.d
        public MaterialDialog e() {
            return new x93(this);
        }
    }

    public x93(MaterialDialog.d dVar) {
        super(dVar);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if ((this.d.w() instanceof Activity) && ((Activity) this.d.w()).isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override // com.afollestad.materialdialogs.MaterialDialog, android.app.Dialog
    public void show() {
        if ((this.d.w() instanceof Activity) && ((Activity) this.d.w()).isFinishing()) {
            return;
        }
        super.show();
    }
}
