package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo2;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class el6 extends bo2 {
    public static final String d = "el6";
    public Context c;

    public el6(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strC = zy4.c(str);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return strC.endsWith("opensns.youni.im") || strC.endsWith("opensns.lianxinapp.com");
    }

    @Override // defpackage.bo2
    public void a(String str) {
        if (nl0.f()) {
            str = zy4.a(str, "from", "zenmen");
            try {
                str = k86.Z(str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        LogUtil.i(d, str);
        this.c.startActivity(tj6.b(this.c, str));
        this.f1790a.onFinish(true);
    }
}
