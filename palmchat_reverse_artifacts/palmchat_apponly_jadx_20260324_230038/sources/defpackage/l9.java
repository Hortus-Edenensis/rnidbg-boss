package defpackage;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.app.PayTask;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class l9 extends t0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f18929a;
    public za3 b;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<String, Integer, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18930a;
        public int b;

        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(String... strArr) {
            String str = new PayTask(l9.this.f18929a).payV2(strArr[0], true).get("resultStatus");
            if (TextUtils.equals(str, "9000")) {
                this.b = 0;
                this.f18930a = "支付成功";
                return null;
            }
            if (TextUtils.equals(str, "8000")) {
                this.b = -1;
                this.f18930a = "支付中";
                return null;
            }
            if (TextUtils.equals(str, "6001")) {
                this.b = -3;
                this.f18930a = "用户取消";
                return null;
            }
            if (!TextUtils.equals(str, "5000")) {
                this.b = -2;
                this.f18930a = "支付失败";
                return null;
            }
            this.b = -3;
            this.f18930a = "3s 内重复支付";
            HashMap map = new HashMap();
            map.put("subCode", String.valueOf(5000));
            return map;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            l9.this.b.onPayBack(this.b, this.f18930a, obj);
        }
    }

    public l9(Activity activity) {
        this.f18929a = activity;
    }

    @Override // defpackage.zn2
    public void a(String str, za3 za3Var) {
        this.b = za3Var;
        new b().executeOnExecutor(ax2.a(), str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }
}
