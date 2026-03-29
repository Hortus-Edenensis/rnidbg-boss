package com.wifi.ad.core.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.g;
import com.wifi.ad.core.R;
import com.wifi.ad.core.utils.NestPermissionUtils;
import com.wifi.ad.core.utils.PermissionObservable;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J-\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/wifi/ad/core/delegate/NestDelegateActivity;", "Landroid/app/Activity;", "()V", "permissionType", "", "getPermissionType", "()I", "setPermissionType", "(I)V", "initData", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", az.G, "requestPhoneState", "requestStorage", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestDelegateActivity extends Activity {
    private static final int PERMISSION_LOCATION = 0;
    private HashMap _$_findViewCache;
    private int permissionType = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PERMISSION_STORAGE = 1;
    private static final int PERMISSION_PHONE_STATE = 2;
    private static final String KEY_TYPE = "type";

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/wifi/ad/core/delegate/NestDelegateActivity$Companion;", "", "()V", "KEY_TYPE", "", "getKEY_TYPE", "()Ljava/lang/String;", "PERMISSION_LOCATION", "", "getPERMISSION_LOCATION", "()I", "PERMISSION_PHONE_STATE", "getPERMISSION_PHONE_STATE", "PERMISSION_STORAGE", "getPERMISSION_STORAGE", "getIntentDate", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "type", bq.f.s, "Lcom/wifi/ad/core/utils/NestPermissionUtils$OnPermissionResult;", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final Intent getIntentDate(Context context, int type) {
            Intent intent = new Intent(context, (Class<?>) NestDelegateActivity.class);
            intent.setFlags(536870912);
            intent.setAction(String.valueOf(System.currentTimeMillis()));
            intent.putExtra(getKEY_TYPE(), type);
            return intent;
        }

        public final String getKEY_TYPE() {
            return NestDelegateActivity.KEY_TYPE;
        }

        public final int getPERMISSION_LOCATION() {
            return NestDelegateActivity.PERMISSION_LOCATION;
        }

        public final int getPERMISSION_PHONE_STATE() {
            return NestDelegateActivity.PERMISSION_PHONE_STATE;
        }

        public final int getPERMISSION_STORAGE() {
            return NestDelegateActivity.PERMISSION_STORAGE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getIntentDate(Context context, int type, NestPermissionUtils.OnPermissionResult listener) {
            Intent intent = new Intent(context, (Class<?>) NestDelegateActivity.class);
            intent.setFlags(536870912);
            intent.putExtra(getKEY_TYPE(), type);
            return intent;
        }
    }

    private final void initData(Intent intent) {
        Bundle extras = intent != null ? intent.getExtras() : null;
        int i = extras != null ? extras.getInt(KEY_TYPE) : this.permissionType;
        this.permissionType = i;
        if (i == PERMISSION_LOCATION) {
            requestLocation();
            return;
        }
        if (i == PERMISSION_PHONE_STATE) {
            requestPhoneState();
        } else if (i == PERMISSION_STORAGE) {
            requestStorage();
        } else {
            finish();
        }
    }

    private final void requestLocation() {
        WifiLog.d("NestDelegateActivity requestLocation");
        ActivityCompat.requestPermissions(this, new String[]{g.g, g.h}, PERMISSION_LOCATION);
    }

    private final void requestPhoneState() {
        WifiLog.d("NestDelegateActivity requestPhoneState");
        ActivityCompat.requestPermissions(this, new String[]{g.c}, PERMISSION_PHONE_STATE);
    }

    private final void requestStorage() {
        WifiLog.d("NestDelegateActivity requestStorage");
        ActivityCompat.requestPermissions(this, new String[]{g.j}, PERMISSION_STORAGE);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final int getPermissionType() {
        return this.permissionType;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_delegate);
        WifiLog.d("NestDelegateActivity onCreate");
        initData(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WifiLog.d("NestDelegateActivity onNewIntent");
        initData(intent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        WifiLog.d("NestDelegateActivity onRequestPermissionsResult permissions = " + permissions + " grantResults = " + grantResults);
        PermissionObservable.getInstance().notifyPermission(new PermissionObservable.PermissionMsg(requestCode, ((grantResults.length == 0) ^ true) && grantResults[0] == 0));
        finish();
    }

    public final void setPermissionType(int i) {
        this.permissionType = i;
    }
}
