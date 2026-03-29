package com.ss.android.downloadlib.fx;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.nr;
import com.ss.android.downloadlib.x.t;
import com.ss.android.socialbase.appdownloader.fx.l;
import com.ss.android.socialbase.appdownloader.fx.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x extends com.ss.android.socialbase.appdownloader.fx.u {
    private static String u = "x";

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements l {
        private Dialog u;

        public u(Dialog dialog) {
            if (dialog != null) {
                this.u = dialog;
                u();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.fx.l
        public boolean nr() {
            Dialog dialog = this.u;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.fx.l
        public void u() {
            Dialog dialog = this.u;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.u, com.ss.android.socialbase.appdownloader.fx.b
    public mv u(Context context) {
        return new mv(context) { // from class: com.ss.android.downloadlib.fx.x.1
            private DialogInterface.OnClickListener b;
            private nr.u fx;
            private DialogInterface.OnCancelListener iz;
            private DialogInterface.OnClickListener pn;
            final /* synthetic */ Context u;

            {
                this.u = context;
                this.fx = new nr.u(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv nr(int i, DialogInterface.OnClickListener onClickListener) {
                this.fx.b(this.u.getResources().getString(i));
                this.pn = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv u(int i) {
                this.fx.u(this.u.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv u(String str) {
                this.fx.nr(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv u(int i, DialogInterface.OnClickListener onClickListener) {
                this.fx.fx(this.u.getResources().getString(i));
                this.b = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv u(DialogInterface.OnCancelListener onCancelListener) {
                this.iz = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public mv u(boolean z) {
                this.fx.u(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.fx.mv
            public l u() {
                this.fx.u(new nr.InterfaceC0840nr() { // from class: com.ss.android.downloadlib.fx.x.1.1
                    @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
                    public void fx(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.iz == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.iz.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
                    public void nr(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pn != null) {
                            AnonymousClass1.this.pn.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
                    public void u(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.b != null) {
                            AnonymousClass1.this.b.onClick(dialogInterface, -1);
                        }
                    }
                });
                t.u(x.u, "getThemedAlertDlgBuilder", null);
                this.fx.u(3);
                return new u(com.ss.android.downloadlib.addownload.l.fx().nr(this.fx.u()));
            }
        };
    }
}
