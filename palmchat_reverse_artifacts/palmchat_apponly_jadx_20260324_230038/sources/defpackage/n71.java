package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zenmen.palmchat.QRCodeScan.ResultActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import defpackage.bo2;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n71 extends bo2 {
    public Context c;
    public int d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19450a;

        public a(String str) {
            this.f19450a = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("content", this.f19450a);
            map.put("scene", Integer.valueOf(n71.this.d));
            return sw4.b(1, nl0.z + "/joke.qr.validate.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            n71.e(n71.this.c, this.f19450a, z && lXBaseNetBean != null && lXBaseNetBean.resultCode == 1);
            n71.this.f1790a.onFinish(true);
        }
    }

    public n71(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar, int i) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
        this.d = i;
    }

    public static void e(Context context, String str, boolean z) {
        Intent intentE = bu3.g().e(context, str);
        if (intentE != null) {
            context.startActivity(intentE);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("result", str);
        if (z) {
            bundle.putInt("mode", 2);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override // defpackage.bo2
    public void a(String str) {
        d(str);
    }

    public final void d(String str) {
        zw4.e(new a(str));
    }
}
