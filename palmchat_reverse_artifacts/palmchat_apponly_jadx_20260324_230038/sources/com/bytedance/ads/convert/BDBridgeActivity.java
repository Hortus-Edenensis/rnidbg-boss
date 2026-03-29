package com.bytedance.ads.convert;

import a.a.b.a.d.c;
import a.a.b.a.d.d;
import a.a.b.a.d.f;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import defpackage.pn;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ads/convert/BDBridgeActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "a", "()V", "", t.l, "()Z", "c", "d", "<init>", "convert_release"}, k = 1, mv = {1, 4, 0})
public final class BDBridgeActivity extends Activity {
    public final void a() {
        Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
        Intrinsics.checkNotNullParameter("auto jump by bridge", "msg");
        if (pn.d.a().getEnableLog()) {
            Log.d("Convert:BridgeActivity", "auto jump by bridge");
        }
        if (b()) {
            return;
        }
        c();
    }

    public final boolean b() {
        String stringExtra = getIntent().getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        Uri uri = Uri.parse(stringExtra);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, stringExtra);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("is_convert_bridge", true);
        try {
            startActivity(intent);
            Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
            Intrinsics.checkNotNullParameter("jumpByDeeplink: ", "msg");
            if (pn.d.a().getEnableLog()) {
                Log.d("Convert:BridgeActivity", "jumpByDeeplink: ");
            }
            return true;
        } catch (ActivityNotFoundException e) {
            Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
            Intrinsics.checkNotNullParameter("jumpByDeeplink: ", "msg");
            if (!pn.d.a().getEnableLog()) {
                return false;
            }
            Log.e("Convert:BridgeActivity", "jumpByDeeplink: ", e);
            return false;
        }
    }

    public final void c() {
        String packageName = getPackageName();
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(packageName);
        Intrinsics.checkNotNull(launchIntentForPackage);
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        launchIntentForPackage.putExtra("is_convert_bridge", true);
        startActivity(launchIntentForPackage);
        String msg = "jumpByPackage: " + packageName;
        Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (pn.d.a().getEnableLog()) {
            Log.d("Convert:BridgeActivity", msg);
        }
    }

    public final void d() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID);
        String stringExtra2 = intent.getStringExtra("click_id_nature");
        String stringExtra3 = intent.getStringExtra("hume_channel_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            d.f1082a.a(this, new c(stringExtra, stringExtra2, stringExtra3, f.Jump));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
        Intrinsics.checkNotNullParameter("onCreate: BDBridgeActivity", "msg");
        if (pn.d.a().getEnableLog()) {
            Log.d("Convert:BridgeActivity", "onCreate: BDBridgeActivity");
        }
        try {
            d();
        } catch (Throwable th) {
            Intrinsics.checkNotNullParameter("Convert:BridgeActivity", "tag");
            Intrinsics.checkNotNullParameter("onCreate: ", "msg");
            if (pn.d.a().getEnableLog()) {
                Log.e("Convert:BridgeActivity", "onCreate: ", th);
            }
        }
        a();
        finish();
        super.onCreate(savedInstanceState);
    }
}
