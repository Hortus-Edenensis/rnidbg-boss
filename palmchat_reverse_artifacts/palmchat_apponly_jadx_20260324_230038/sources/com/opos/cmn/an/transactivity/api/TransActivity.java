package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TransActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.transactivity.a.a f7815a = null;

    private void a() {
        try {
            finish();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "destroy", e);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.opos.cmn.an.f.a.a("TransActivity", "onActivityResult");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.a(this, i, i2, intent);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onActivityResult", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.a("TransActivity", "onCreate");
        try {
            Intent intent = getIntent();
            if (intent != null) {
                com.opos.cmn.an.transactivity.a.a aVar = (com.opos.cmn.an.transactivity.a.a) intent.getSerializableExtra("extra_key_trans_life_callback");
                this.f7815a = aVar;
                if (aVar != null) {
                    aVar.a(this, bundle);
                    return;
                }
            }
            com.opos.cmn.an.f.a.a("TransActivity", "onCreate ITransLifeCallback cannot be null");
            a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onCreate", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.opos.cmn.an.f.a.a("TransActivity", "onDestroy");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.f(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onDestroy", e);
        }
        this.f7815a = null;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.a("TransActivity", "onNewIntent");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.a(this, intent);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onNewIntent", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.a("TransActivity", "onPause");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.d(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onPause", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.opos.cmn.an.f.a.a("TransActivity", "onRequestPermissionsResult");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.a(this, i, strArr, iArr);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onRequestPermissionsResult", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.opos.cmn.an.f.a.a("TransActivity", "onRestart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onRestart", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.a("TransActivity", "onResume");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onResume", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.a("TransActivity", "onStart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.a(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStart", e);
            a();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.a("TransActivity", "onStop");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f7815a;
            if (aVar != null) {
                aVar.e(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStop", e);
            a();
        }
    }
}
