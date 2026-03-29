package androidx.core.app;

import androidx.core.app.JobIntentService;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class SafeJobIntentService extends JobIntentService {
    public static final String TAG = "SafeJobIntentService";

    @Override // androidx.core.app.JobIntentService
    public JobIntentService.GenericWorkItem dequeueWork() {
        try {
            return super.dequeueWork();
        } catch (Exception e) {
            if (e instanceof SecurityException) {
                return null;
            }
            LogUtil.i(TAG, "dequeueWork" + e.getMessage());
            return null;
        }
    }
}
