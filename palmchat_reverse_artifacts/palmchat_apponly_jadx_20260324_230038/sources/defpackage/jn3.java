package defpackage;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.zenmen.openapi.comm.widget.LxDialogView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jn3 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fa3 f18440a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements fa3 {
        public a() {
        }

        @Override // defpackage.fa3
        public void onEvent(int i, Object obj) {
            if (jn3.this.f18440a != null) {
                jn3.this.f18440a.onEvent(i, obj);
            }
            jn3.this.dismiss();
            jn3.this.f18440a = null;
        }
    }

    public jn3(@NonNull Context context, int i) {
        super(context, i);
    }

    public void c(LxDialogView lxDialogView, fa3 fa3Var) {
        this.f18440a = fa3Var;
        setContentView(lxDialogView);
        lxDialogView.setEventCallback(new a());
    }
}
