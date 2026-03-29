package cn.wh.auth.server;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import cn.wh.auth.server.ResultRequestService;
import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class OnWHResultDispatcherFragment extends Fragment {
    public static final String TAG = "on_wh_local_result_dispatcher";
    private SparseArray<ResultRequestService.Callback> mCallbacks = new SparseArray<>();

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        JniLib1716343241.cV(this, Integer.valueOf(i), Integer.valueOf(i2), intent, 21);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        JniLib1716343241.cV(this, bundle, 22);
    }

    public void startForResult(Intent intent, ResultRequestService.Callback callback) {
        JniLib1716343241.cV(this, intent, callback, 23);
    }
}
