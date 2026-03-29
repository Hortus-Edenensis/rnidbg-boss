package com.heytap.pictorial.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.util.Log;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.heytap.pictorial.a.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0011"}, d2 = {"Lcom/heytap/pictorial/sdk/PictorialSDK;", "", "Landroid/content/Context;", "context", "Landroid/os/ResultReceiver;", "resultReceiver", "", "dismissKeyGuard", "", "queryUnlock", "queryVerify", "", WfConstant.EVENT_KEY_APP_NAME, "verify", "<init>", "()V", "Companion", "pictorial_sdk_debug"}, k = 1, mv = {1, 6, 0})
public final class PictorialSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6428a = new a(null);

    /* JADX INFO: renamed from: com.heytap.pictorial.a.a$a */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/heytap/pictorial/sdk/PictorialSDK$Companion;", "", "()V", "PROVIDER_URI", "", "RESULT_RECEIVER_KEY", "TAG", "isSupport", "", "context", "Landroid/content/Context;", "transResultReceiver", "Landroid/os/ResultReceiver;", "actualReceiver", "pictorial_sdk_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResultReceiver a(ResultReceiver actualReceiver) {
            Intrinsics.checkNotNullParameter(actualReceiver, "actualReceiver");
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
            actualReceiver.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            ResultReceiver receiverForSending = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            Intrinsics.checkNotNullExpressionValue(receiverForSending, "receiverForSending");
            return receiverForSending;
        }

        public final boolean a(Context context) {
            PackageInfo packageInfo;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    Log.d("PictorialSDK", "isSupport Build.VERSION.SDK_INT < Build.VERSION_CODES.O...");
                    return false;
                }
                if (context.checkSelfPermission("oppo.permission.OPPO_COMPONENT_SAFE") != 0 && context.checkSelfPermission("com.oplus.permission.safe.SECURITY") != 0) {
                    Log.d("PictorialSDK", "isSupport checkSelfPermission not support...");
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo("com.heytap.pictorial", 0);
                } catch (Throwable unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    packageInfo = context.getPackageManager().getPackageInfo("com.coloros.pictorial", 0);
                    Log.d("PictorialSDK", "isSupport com.heytap.pictorial is null");
                }
                if (packageInfo == null) {
                    return false;
                }
                Log.d("PictorialSDK", Intrinsics.stringPlus("isSupport info code = ", Integer.valueOf(packageInfo.versionCode)));
                return packageInfo.versionCode >= 500091500;
            } catch (Throwable th) {
                Log.d("PictorialSDK", Intrinsics.stringPlus("isSupport Throwable ", th.getMessage()));
                return false;
            }
        }
    }

    public final void a(Context context, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intent intent = new Intent();
        intent.setAction("com.heytap.pictorial.UnlockActivity");
        intent.putExtra("result_receiver", f6428a.a(resultReceiver));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final void a(Context context, String appName, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intent intent = new Intent();
        intent.putExtra("APP_NAME", appName);
        intent.setAction("com.heytap.pictorial.action.VerifyActivity");
        intent.putExtra("result_receiver", f6428a.a(resultReceiver));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Boolean boolValueOf = null;
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.heytap.pictorial.data.provider.PictorialUIProvider"), "queryVerify", (String) null, (Bundle) null);
            if (bundleCall != null) {
                boolValueOf = Boolean.valueOf(bundleCall.getBoolean("queryVerifyResult"));
            }
            if (boolValueOf == null) {
                return true;
            }
            boolValueOf.booleanValue();
            return boolValueOf.booleanValue();
        } catch (Throwable th) {
            Log.e("PictorialSDK", Intrinsics.stringPlus("error call queryVerify ", th.getMessage()));
            return true;
        }
    }
}
