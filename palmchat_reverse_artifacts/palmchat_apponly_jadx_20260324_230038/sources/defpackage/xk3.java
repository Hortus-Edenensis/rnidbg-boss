package defpackage;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface xk3 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(ArrayList<MediaItem> arrayList);
    }

    void a(FrameworkBaseActivity frameworkBaseActivity, a aVar);

    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage);

    void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z);

    void onResume();

    void show();
}
