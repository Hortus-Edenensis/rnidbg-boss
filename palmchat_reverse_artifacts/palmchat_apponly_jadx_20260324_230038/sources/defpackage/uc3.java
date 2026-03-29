package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uc3 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21189a;
    public Activity b;

    public uc3(Context context, View view) {
        super(context, R.style.AdSDKFullScreenDialog);
        this.f21189a = null;
        this.b = null;
        setCanceledOnTouchOutside(false);
        this.f21189a = view;
        if (context instanceof Activity) {
            this.b = (Activity) context;
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f21189a);
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        super.show();
    }
}
