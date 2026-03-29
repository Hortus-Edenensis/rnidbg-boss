package com.ss.android.socialbase.appdownloader.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.fx.l;
import com.ss.android.socialbase.appdownloader.fx.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends com.ss.android.socialbase.appdownloader.fx.nr {
    private AlertDialog.Builder u;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.b.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0855u implements l {
        private AlertDialog u;

        public C0855u(AlertDialog.Builder builder) {
            if (builder != null) {
                this.u = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.fx.l
        public boolean nr() {
            AlertDialog alertDialog = this.u;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.fx.l
        public void u() {
            AlertDialog alertDialog = this.u;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public u(Context context) {
        this.u = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public mv nr(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.u;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public mv u(int i) {
        AlertDialog.Builder builder = this.u;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public mv u(String str) {
        AlertDialog.Builder builder = this.u;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public mv u(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.u;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public mv u(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.u;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.mv
    public l u() {
        return new C0855u(this.u);
    }
}
