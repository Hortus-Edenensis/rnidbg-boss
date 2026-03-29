package defpackage;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class qy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toast f20355a;

    public void a(Context context, String str, int i) {
        try {
            Toast toast = this.f20355a;
            if (toast == null) {
                Toast toastMakeText = Toast.makeText(context, str, i);
                this.f20355a = toastMakeText;
                toastMakeText.setText(str);
            } else {
                toast.cancel();
                Toast toastMakeText2 = Toast.makeText(context, str, i);
                this.f20355a = toastMakeText2;
                toastMakeText2.setDuration(i);
                this.f20355a.setText(str);
            }
            this.f20355a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
