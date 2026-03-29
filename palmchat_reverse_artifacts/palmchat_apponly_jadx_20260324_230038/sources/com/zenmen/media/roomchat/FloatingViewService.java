package com.zenmen.media.roomchat;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.media.roomchat.a;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FloatingViewService extends Service implements a.b {
    public static FloatingViewService g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager f11956a;
    public WindowManager.LayoutParams b;
    public int c;
    public int d;
    public LinearLayout e;
    public TextView f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11957a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.d = motionEvent.getRawX();
            this.e = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                FloatingViewService.this.e.setAlpha(1.0f);
                this.f = this.d;
                this.g = this.e;
                this.b = motionEvent.getRawX();
                this.c = motionEvent.getRawY();
            } else {
                if (action == 1) {
                    if (Math.abs(this.d - this.f) < 1.5d && Math.abs(this.e - this.g) < 1.5d) {
                        return false;
                    }
                    if (FloatingViewService.this.b.x > this.f11957a) {
                        FloatingViewService.this.b.x = FloatingViewService.this.d - (FloatingViewService.this.e.getMeasuredWidth() / 2);
                    } else {
                        FloatingViewService.this.b.x = 0;
                    }
                    FloatingViewService.this.f11956a.updateViewLayout(FloatingViewService.this.e, FloatingViewService.this.b);
                    return true;
                }
                if (action == 2) {
                    int rawX = (int) (motionEvent.getRawX() - this.b);
                    int rawY = (int) (motionEvent.getRawY() - this.c);
                    this.f11957a = ((int) motionEvent.getRawX()) + (FloatingViewService.this.e.getMeasuredWidth() / 2);
                    FloatingViewService.this.b.x -= rawX;
                    FloatingViewService.this.b.y += rawY;
                    FloatingViewService.this.f11956a.updateViewLayout(FloatingViewService.this.e, FloatingViewService.this.b);
                    this.b = motionEvent.getRawX();
                    this.c = motionEvent.getRawY();
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_FLOATVIEW_CLICK"));
        }
    }

    @Override // com.zenmen.media.roomchat.a.b
    public void k0(Intent intent) {
        if (intent.getAction().equals("INTENT_ACTION_UPDATE_CALLING_DURATION")) {
            this.f.setText(RTCParameters.f().c());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.e = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.manychats_view_float_voip, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 262440, -3);
        this.b = layoutParams;
        layoutParams.gravity = 53;
        layoutParams.x = 10;
        layoutParams.y = 100;
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.f11956a = windowManager;
        windowManager.addView(this.e, this.b);
        this.c = RTCParameters.i();
        this.d = RTCParameters.j();
        ImageView imageView = (ImageView) this.e.findViewById(R.id.float_audio);
        imageView.setOnTouchListener(new a());
        imageView.setOnClickListener(new b());
        this.f = (TextView) this.e.findViewById(R.id.audio_time);
        g = this;
        com.zenmen.media.roomchat.a.d(this);
        String strC = RTCParameters.f().c();
        if (strC != null) {
            this.f.setText(strC);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            this.f11956a.removeView(linearLayout);
        }
        g = null;
        com.zenmen.media.roomchat.a.f(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
