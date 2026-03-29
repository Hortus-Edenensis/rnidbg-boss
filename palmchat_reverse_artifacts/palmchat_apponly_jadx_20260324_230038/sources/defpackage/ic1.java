package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ic1 extends Dialog implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnShowListener f18146a;
    public boolean b;

    public ic1(Context context, int i) {
        super(context, i);
        this.b = true;
    }

    public final void a(Field field) throws Exception {
        field.setAccessible(true);
        Object obj = field.get(this);
        if (obj != null) {
            ((Message) obj).recycle();
            field.set(this, null);
        }
    }

    public final void b() {
        super.setOnShowListener(this);
    }

    public void c(boolean z) {
        this.b = z;
    }

    public final void d(View view) {
        setContentView(view);
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = this.f18146a;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        if (this.b) {
            try {
                Class<? super Object> superclass = getClass().getSuperclass().getSuperclass();
                a(superclass.getDeclaredField("mCancelMessage"));
                a(superclass.getDeclaredField("mDismissMessage"));
                a(superclass.getDeclaredField("mShowMessage"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f18146a = onShowListener;
    }
}
