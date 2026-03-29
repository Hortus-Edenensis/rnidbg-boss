package defpackage;

import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.wallet.WalletActivity;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gi6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<WalletActivity> f17736a;

    public gi6(WalletActivity walletActivity) {
        this.f17736a = new WeakReference<>(walletActivity);
    }

    public void a(String str, String str2) {
        WalletActivity walletActivity;
        if (l50.a() || (walletActivity = this.f17736a.get()) == null || walletActivity.isFinishing()) {
            return;
        }
        try {
            new JSONObject(str).optInt(az.at, -1);
        } catch (JSONException e) {
            LogUtil.e("LxWallet", e);
            walletActivity.O1(str2, fi6.a(4002));
        }
    }

    public void b() {
    }
}
