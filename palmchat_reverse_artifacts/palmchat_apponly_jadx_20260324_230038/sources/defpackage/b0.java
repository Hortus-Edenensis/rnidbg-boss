package defpackage;

import android.app.Fragment;
import android.content.Intent;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b0 extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f1615a;

    public void a(c0 c0Var) {
        this.f1615a = c0Var;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtil.i("AResultFragment", "requestCode=" + i + " resultCode=" + i2);
        c0 c0Var = this.f1615a;
        if (c0Var == null || i != 10086) {
            return;
        }
        c0Var.a(i2, intent);
    }
}
