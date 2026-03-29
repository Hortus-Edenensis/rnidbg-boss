package com.zenmen.media.roomchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.zenmen.media.roomchat.floatingview.FloatingMagnetView;
import defpackage.ay1;
import defpackage.yb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class noPermissionFloatingView extends Activity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements yb3 {
        public a() {
        }

        @Override // defpackage.yb3
        public void a(FloatingMagnetView floatingMagnetView) {
            com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_FLOATVIEW_CLICK"));
            ay1.k().p();
            noPermissionFloatingView.this.finish();
        }

        @Override // defpackage.yb3
        public void b(FloatingMagnetView floatingMagnetView) {
            Toast.makeText(RTCParameters.c(), "我没了", 0).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags |= 16;
        getWindow().setAttributes(layoutParams);
        super.onCreate(bundle);
        ay1.k().h(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        ay1.k().f(this);
        ay1.k().o(new a());
        ay1.k().d();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ay1.k().p();
        ay1.k().h(this);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
