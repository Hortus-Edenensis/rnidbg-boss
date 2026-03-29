package com.zenmen.media.roomchat;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zenmen.media.roomchat.NetworkUtil;
import defpackage.m5;
import defpackage.tb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PopUpActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11961a = "REQUEST_CODE";
    public static int b = 7000;
    public static int c = 7001;
    public static int d = 7002;
    public static int e = 1001;
    public static int f = 1002;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NetworkUtil.c {
        public a() {
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void a() {
            PopUpActivity.this.setResult(PopUpActivity.e, null);
            PopUpActivity.this.finish();
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void onStop() {
            PopUpActivity.this.setResult(PopUpActivity.f, null);
            PopUpActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NetworkUtil.c {
        public b() {
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void a() {
            PopUpActivity.this.setResult(PopUpActivity.e, null);
            PopUpActivity.this.finish();
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void onStop() {
            PopUpActivity.this.setResult(PopUpActivity.f, null);
            PopUpActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        m5.c(this, bundle);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(f11961a, 0);
        if (intExtra == b) {
            NetworkUtil.c(this, new a());
        } else if (intExtra == c) {
            NetworkUtil.b(this, new b());
        } else if (intExtra == d) {
            tb3.a(this, null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
