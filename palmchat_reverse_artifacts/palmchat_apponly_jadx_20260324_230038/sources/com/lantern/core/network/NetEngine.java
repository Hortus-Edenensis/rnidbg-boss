package com.lantern.core.network;

import android.text.TextUtils;
import android.util.Log;
import com.lantern.core.network.utils.NECallback;
import com.lantern.core.network.utils.NEPBUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NetEngine {
    private static NetEngine sInstance;
    private OnEventListener mEventListener;
    private final NECallback mNetErrCallback = new NECallback() { // from class: com.lantern.core.network.NetEngine.1
        @Override // com.lantern.core.network.utils.NECallback
        public void run(int i, String str, Object obj) {
            if (i == 0 && (obj instanceof Integer) && NetEngine.this.mEventListener != null) {
                NetEngine.this.mEventListener.onUploadNetErr(str, ((Integer) obj).intValue());
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface OnEventListener {
        void onUploadNetErr(String str, int i);
    }

    public static NetEngine getInstance() {
        if (sInstance == null) {
            sInstance = new NetEngine();
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.lantern.core.network.utils.NECallback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$httpPost$0(String str, byte[] bArr, String str2, NECallback nECallback) {
        char c;
        NEPBResponse response;
        ?? IsSuccess;
        try {
            byte[] serverData = null;
            byte[] request = !TextUtils.isEmpty(str) ? NEPBUtils.getRequest("a", str, bArr) : null;
            if (request == null || request.length <= 0) {
                c = 0;
            } else {
                byte[] bArrPost = NEHttp.post(str2, request, this.mNetErrCallback);
                if (bArrPost != null && bArrPost.length != 0) {
                    try {
                        response = NEPBUtils.getResponse(bArrPost);
                    } catch (Exception e) {
                        e = e;
                        response = null;
                    }
                    try {
                        IsSuccess = response.isSuccess();
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("CX_EVENT", "NetEngine resp exception:" + e.getMessage());
                        IsSuccess = 30;
                    }
                    if (nECallback == 0) {
                        if (response != null) {
                            serverData = response.getServerData();
                        }
                        nECallback.run(IsSuccess, "", serverData);
                        return;
                    }
                    return;
                }
                c = '\n';
            }
            response = null;
            IsSuccess = c;
            if (nECallback == 0) {
            }
        } catch (Exception e3) {
            Log.e("CX_EVENT", "NetEngine post exception:" + e3.getMessage());
        }
    }

    public void httpPost(final String str, final String str2, final byte[] bArr, final NECallback nECallback) {
        ThreadManager.execute(new Runnable() { // from class: kw3
            @Override // java.lang.Runnable
            public final void run() {
                this.f18841a.lambda$httpPost$0(str2, bArr, str, nECallback);
            }
        });
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        this.mEventListener = onEventListener;
    }
}
