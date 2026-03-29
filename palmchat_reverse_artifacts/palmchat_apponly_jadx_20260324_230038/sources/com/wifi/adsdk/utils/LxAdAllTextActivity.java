package com.wifi.adsdk.utils;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdAllTextActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(getApplicationContext());
        frameLayout.setBackgroundColor(-1);
        setContentView(frameLayout);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            TextView textView = new TextView(getApplicationContext());
            textView.setPadding(0, BLUtils.dp2px(getApplicationContext(), 50.0f), 0, 0);
            textView.setTextColor(-16777216);
            textView.setText(stringExtra);
            textView.setTextSize(1, 12.0f);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
