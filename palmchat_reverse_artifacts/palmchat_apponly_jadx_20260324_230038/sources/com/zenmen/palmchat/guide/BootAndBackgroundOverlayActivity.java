package com.zenmen.palmchat.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.m5;
import defpackage.ol2;
import defpackage.sb1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BootAndBackgroundOverlayActivity extends Activity {
    public final void a() {
        setContentView(R.layout.activity_boot_and_background_overlay);
        ImageView imageView = (ImageView) findViewById(R.id.switch_image);
        int intExtra = getIntent().getIntExtra("switch_icon_res", 0);
        if (intExtra > 0) {
            imageView.setImageResource(intExtra);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ((TextView) findViewById(R.id.click_text)).setText(Html.fromHtml(getString(R.string.check_this_switch)));
        ((TextView) findViewById(R.id.text2)).setVisibility(8);
        ((TextView) findViewById(R.id.click_text)).setVisibility(0);
        ((ImageView) findViewById(R.id.click_icon)).setVisibility(0);
    }

    public final void b(Spanned spanned) {
        setContentView(R.layout.activity_boot_and_background_overlay_spec);
        ((TextView) findViewById(R.id.overlay_notice)).setText(spanned);
    }

    public final void c() {
        setContentView(R.layout.activity_boot_and_background_overlay);
        ImageView imageView = (ImageView) findViewById(R.id.switch_image);
        int intExtra = getIntent().getIntExtra("switch_icon_res", 0);
        if (intExtra > 0) {
            imageView.setImageResource(intExtra);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ((TextView) findViewById(R.id.text1)).setText("1." + getString(R.string.swipe_list_to_find_palmchat));
        ((TextView) findViewById(R.id.text2)).setVisibility(0);
        ((TextView) findViewById(R.id.text2)).setText(Html.fromHtml(getString(R.string.huawei_boot_background_tips)));
        ((TextView) findViewById(R.id.click_text)).setVisibility(8);
        ((ImageView) findViewById(R.id.click_icon)).setVisibility(8);
    }

    public void onClicked(View view) {
        finish();
        overridePendingTransition(android.R.anim.fade_in, 0);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        m5.c(this, bundle);
        super.onCreate(bundle);
        ol2 ol2VarB = sb1.b(this);
        if (ol2VarB == null) {
            a();
            return;
        }
        if (ol2VarB.getDeviceType() != 2) {
            if (ol2VarB.getDeviceType() == 1) {
                b(Html.fromHtml(getString(R.string.mi_boot_background_tips)));
                return;
            } else if (ol2VarB.getDeviceType() != 3 || ol2VarB.getVersion() < 300) {
                a();
                return;
            } else {
                b(Html.fromHtml(getString(R.string.oppo_boot_background_tips)));
                return;
            }
        }
        Intent permissionActivity = ol2VarB.getPermissionActivity(3);
        if (permissionActivity.getComponent().getClassName().contains("StartupAppControlActivity")) {
            c();
            LogUtil.onImmediateClickEvent("3704", null, null);
        } else {
            if (permissionActivity.getComponent().getClassName().contains("ProtectActivity")) {
                LogUtil.onImmediateClickEvent("3706", null, null);
            } else {
                LogUtil.onImmediateClickEvent("3705", null, null);
            }
            a();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        finish();
        overridePendingTransition(android.R.anim.fade_in, 0);
        return true;
    }
}
