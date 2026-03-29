package defpackage;

import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wt0 {
    public static final int RETRY_INTERVAL_SK_INVALID_WAIT_TIME = 15000;
    private static final String TAG = "Dao";
    protected static float backoffMultiplier = 0.5f;
    protected static int futureWaitTime = 10000 * 3;
    protected static int retryCount = 3;
    protected static int waitTime = 10000;
    protected List<Request> mRequests = new ArrayList();
    private String requestId = null;

    public static DefaultRetryPolicy genRetryPolicy() {
        return new DefaultRetryPolicy(waitTime, retryCount, backoffMultiplier);
    }

    public static String generateEncodedURL(String str) throws UnsupportedEncodingException {
        return k86.Z(str);
    }

    public final String getRequestId() {
        if (TextUtils.isEmpty(this.requestId)) {
            this.requestId = xn3.a();
        }
        return this.requestId;
    }

    public void onCancel() {
        for (Request request : this.mRequests) {
            if (request != null) {
                request.cancel();
            }
        }
        this.mRequests.clear();
    }
}
