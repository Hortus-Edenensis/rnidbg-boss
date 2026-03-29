package cn.wh.auth.server;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ResultRequestService {
    private final Activity activity;
    private OnWHResultDispatcherFragment fragment;

    /* JADX INFO: renamed from: cn.wh.auth.server.ResultRequestService$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ ResultRequestService this$0;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Intent val$intent;

        public AnonymousClass1(ResultRequestService resultRequestService, Intent intent, Callback callback) {
            JniLib1716343241.cV(this, resultRequestService, intent, callback, 24);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.fragment == null) {
                ResultRequestService resultRequestService = this.this$0;
                resultRequestService.fragment = resultRequestService.getEventDispatchFragment(resultRequestService.activity);
            }
            this.this$0.fragment.startForResult(this.val$intent, this.val$callback);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback {
        void onActivityResult(int i, int i2, Intent intent);
    }

    public ResultRequestService(Activity activity) {
        JniLib1716343241.cV(this, activity, 26);
    }

    private OnWHResultDispatcherFragment findEventDispatchFragment(FragmentManager fragmentManager) {
        return (OnWHResultDispatcherFragment) JniLib1716343241.cL(this, fragmentManager, 27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnWHResultDispatcherFragment getEventDispatchFragment(Activity activity) {
        return (OnWHResultDispatcherFragment) JniLib1716343241.cL(this, activity, 28);
    }

    public void startForResult(Intent intent, Callback callback) {
        JniLib1716343241.cV(this, intent, callback, 25);
    }
}
