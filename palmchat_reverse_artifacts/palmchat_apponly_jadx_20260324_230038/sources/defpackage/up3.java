package defpackage;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.common.ids.mitt2.MittIdSupplierv2;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class up3 implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21264a;
    public final LinkedBlockingQueue<String> b = new LinkedBlockingQueue<>(1);

    public up3(Context context) {
        this.f21264a = context;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Exception {
        try {
            int iInitSdk = MdidSdkHelper.InitSdk(this.f21264a, true, new MittIdSupplierv2(this));
            return (iInitSdk == 0 || iInitSdk == 1008614) ? this.b.take() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public void b(IdSupplier idSupplier) {
        try {
            try {
                if (idSupplier == null) {
                    this.b.put("");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String oaid = idSupplier.getOAID();
                String vaid = idSupplier.getVAID();
                String aaid = idSupplier.getAAID();
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObject.put("oaid", oaid);
                }
                if (!TextUtils.isEmpty(vaid)) {
                    jSONObject.put("vaid", vaid);
                }
                if (!TextUtils.isEmpty(aaid)) {
                    jSONObject.put("aaid", aaid);
                }
                this.b.put(jSONObject.toString());
            } catch (Throwable unused) {
                this.b.put("");
            }
        } catch (Throwable unused2) {
        }
    }
}
