package com.zenmen.palmchat.videocall;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.common.C;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.igexin.sdk.PushConsts;
import com.oplus.tbl.exoplayer2.Renderer;
import com.zenmen.media.rtc.CameraRecorder;
import com.zenmen.media.rtc.CameraView;
import com.zenmen.media.rtc.ZMRtcAppState;
import com.zenmen.media.rtc.ZMRtcMediaType;
import com.zenmen.media.rtc.ZMRtcParamID;
import com.zenmen.media.rtc.ZMRtcSDK;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.AudioVoiceSelection;
import com.zenmen.palmchat.videocall.a;
import com.zenmen.palmchat.videocall.c;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bc1;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.cc1;
import defpackage.ea5;
import defpackage.g13;
import defpackage.gr2;
import defpackage.gu;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.it0;
import defpackage.k86;
import defpackage.me1;
import defpackage.ny;
import defpackage.pa6;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.ua6;
import defpackage.vk3;
import defpackage.xn3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VideoCallActivity extends BaseActionBarActivity implements SurfaceHolder.Callback {
    public static final String b1 = "VideoCallActivity";
    public static VideoCallActivity c1 = null;
    public static boolean d1 = false;
    public static boolean e1 = false;
    public static List<Message> f1;
    public boolean A;
    public ImageView B0;
    public FrameLayout C;
    public TextView C0;
    public View D0;
    public LinearLayout E;
    public LinearLayout E0;
    public ImageView F;
    public ImageView F0;
    public TextView G;
    public TextView G0;
    public TextView H;
    public LinearLayout H0;
    public ImageView I0;
    public LinearLayout J0;
    public View K;
    public ImageView K0;
    public com.zenmen.palmchat.videocall.a L;
    public LinearLayout L0;
    public TextView M0;
    public LinearLayout N0;
    public LinearLayout O0;
    public ImageView P0;
    public ImageView Q0;
    public TextView R0;
    public LinearLayout S0;
    public int T;
    public LinearLayout T0;
    public ImageView U0;
    public ImageView V0;
    public CallingStatus W0;
    public ChatItem X;
    public boolean Y;
    public boolean Z;
    public boolean Z0;
    public Timer g0;
    public Timer h0;
    public long j0;
    public FrameLayout k0;
    public SurfaceView l0;
    public SurfaceView m0;
    public ImageView n0;
    public ImageView o0;
    public FrameLayout p0;
    public FrameLayout q0;
    public CameraView r0;
    public LinearLayout s0;
    public LinearLayout t0;
    public View.OnTouchListener u;
    public EffectiveShapeView u0;
    public TranslateAnimation v;
    public TextView v0;
    public TextView w0;
    public EffectiveShapeView x0;
    public TextView y0;
    public AudioManager z;
    public TextView z0;
    public boolean q = false;
    public boolean r = true;
    public boolean s = false;
    public boolean t = false;
    public ea5 w = null;
    public boolean x = false;
    public boolean y = true;
    public boolean B = false;
    public WindowManager I = null;
    public WindowManager.LayoutParams J = null;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = true;
    public int U = 0;
    public int V = 0;
    public final BroadcastReceiver W = new u();
    public boolean e0 = false;
    public int f0 = 0;
    public int i0 = 0;
    public boolean A0 = true;
    public e0 X0 = new e0(this);
    public boolean Y0 = false;
    public AudioVoiceSelection a1 = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum CallingStatus {
        CALLING,
        INCOMING,
        CONNECTING,
        CONNECTED,
        DISCONNECTED
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.e3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoCallActivity.this.l0.setOnTouchListener(null);
                VideoCallActivity.this.r0.setOnTouchListener(VideoCallActivity.this.u);
                ((ImageView) VideoCallActivity.this.findViewById(R.id.surface_cover_view)).setVisibility(8);
                VideoCallActivity videoCallActivity = VideoCallActivity.this;
                videoCallActivity.Q = false;
                videoCallActivity.X0.sendEmptyMessageDelayed(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, 300L);
            }
        }

        public a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(me1.b(VideoCallActivity.this, 66), me1.b(VideoCallActivity.this, 127));
            layoutParams.topMargin = VideoCallActivity.this.T;
            if (VideoCallActivity.this.R) {
                layoutParams.rightMargin = me1.b(VideoCallActivity.this, 12);
            } else if (VideoCallActivity.this.S) {
                layoutParams.rightMargin = 0;
            } else {
                layoutParams.rightMargin = VideoCallActivity.this.getWindow().getDecorView().getWidth() - me1.b(VideoCallActivity.this, 66);
            }
            layoutParams.gravity = 5;
            try {
                VideoCallActivity.this.q0.removeView(VideoCallActivity.this.l0);
                pa6.p().h();
                VideoCallActivity.this.l0.setLayoutParams(VideoCallActivity.this.r0.getLayoutParams());
                VideoCallActivity.this.l0.setZOrderOnTop(false);
                VideoCallActivity.this.l0.setZOrderMediaOverlay(false);
                if (VideoCallActivity.this.l0.getParent() != null) {
                    ((ViewGroup) VideoCallActivity.this.l0.getParent()).removeView(VideoCallActivity.this.l0);
                }
                VideoCallActivity.this.k0.addView(VideoCallActivity.this.l0);
                VideoCallActivity.this.k0.removeView(VideoCallActivity.this.r0);
                VideoCallActivity.this.r0.setZOrderOnTop(true);
                VideoCallActivity.this.r0.setZOrderMediaOverlay(true);
                if (VideoCallActivity.this.r0.getParent() != null) {
                    ((ViewGroup) VideoCallActivity.this.r0.getParent()).removeView(VideoCallActivity.this.r0);
                }
                VideoCallActivity.this.q0.addView(VideoCallActivity.this.r0);
                VideoCallActivity.this.r0.setLayoutParams(layoutParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
            VideoCallActivity.this.N3();
            new Handler().postDelayed(new a(), 200L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            VideoCallActivity.this.T3("77");
            VideoCallActivity videoCallActivity = VideoCallActivity.this;
            if (!videoCallActivity.Y && videoCallActivity.t) {
                VideoCallActivity.this.B0.setEnabled(false);
                sy5.d(VideoCallActivity.this, R.string.video_call_end_toast, 0).g();
                if (pa6.p().v() < 1) {
                    VideoCallActivity.this.finish();
                    return;
                }
            } else if (VideoCallActivity.this.W0 != CallingStatus.CALLING) {
                VideoCallActivity videoCallActivity2 = VideoCallActivity.this;
                if (videoCallActivity2.Y && videoCallActivity2.W0 == CallingStatus.CONNECTING) {
                    Log.i(VideoCallActivity.b1, "[mHangupBtn] CallingStatus.CALLING");
                    VideoCallActivity.this.B0.setEnabled(false);
                    sy5.d(VideoCallActivity.this, R.string.video_cancel, 500).g();
                    VideoCallActivity.this.X0.sendEmptyMessageDelayed(10012, 500L);
                } else if (VideoCallActivity.this.W0 != CallingStatus.INCOMING) {
                    VideoCallActivity videoCallActivity3 = VideoCallActivity.this;
                    if (!videoCallActivity3.Y && videoCallActivity3.W0 == CallingStatus.CONNECTING) {
                        Log.i(VideoCallActivity.b1, "[mHangupBtn] CallingStatus.INCOMING");
                        VideoCallActivity.this.B0.setEnabled(false);
                        if (pa6.p().F() < 1) {
                            VideoCallActivity.this.finish();
                            return;
                        } else {
                            VideoCallActivity videoCallActivity4 = VideoCallActivity.this;
                            videoCallActivity4.t3(videoCallActivity4.getString(R.string.video_call_msg_refused));
                        }
                    } else if (VideoCallActivity.this.W0 == CallingStatus.CONNECTED) {
                        Log.i(VideoCallActivity.b1, "[mHangupBtn] CallingStatus.CONNECTED");
                        VideoCallActivity.this.B0.setEnabled(false);
                        sy5.d(VideoCallActivity.this, R.string.video_call_end_toast, 0).g();
                        if (pa6.p().v() < 1) {
                            VideoCallActivity.this.finish();
                            return;
                        }
                    }
                }
            }
            VideoCallActivity.this.s = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f15825a;
        public final /* synthetic */ FrameLayout.LayoutParams b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoCallActivity.this.l0.setVisibility(8);
                VideoCallActivity.this.l0.setVisibility(0);
                VideoCallActivity.this.l0.setLayoutParams(b0.this.b);
                VideoCallActivity.this.l0.setZOrderOnTop(true);
                VideoCallActivity.this.l0.setZOrderMediaOverlay(true);
                VideoCallActivity.this.l0.setOnTouchListener(VideoCallActivity.this.u);
                VideoCallActivity.this.r0.setOnTouchListener(null);
                VideoCallActivity.this.Q = true;
            }
        }

        public b0(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2) {
            this.f15825a = layoutParams;
            this.b = layoutParams2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VideoCallActivity.this.r0.setLayoutParams(this.f15825a);
                VideoCallActivity.this.r0.setZOrderOnTop(false);
                VideoCallActivity.this.r0.setZOrderMediaOverlay(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(new a(), 100L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.T3("78");
            ny.a();
            if (pa6.p().d() < 1) {
                VideoCallActivity.this.finish();
                return;
            }
            VideoCallActivity.this.E0.setVisibility(8);
            VideoCallActivity.this.D0.setVisibility(8);
            VideoCallActivity.this.J0.setVisibility(8);
            VideoCallActivity.this.M3(false);
            VideoCallActivity videoCallActivity = VideoCallActivity.this;
            if (videoCallActivity.Y) {
                return;
            }
            videoCallActivity.t = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f15828a;
        public final /* synthetic */ FrameLayout.LayoutParams b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoCallActivity.this.r0.setZOrderOnTop(true);
                VideoCallActivity.this.r0.setZOrderMediaOverlay(true);
                VideoCallActivity.this.r0.setLayoutParams(c0.this.b);
                VideoCallActivity.this.l0.setOnTouchListener(null);
                VideoCallActivity.this.r0.setOnTouchListener(VideoCallActivity.this.u);
                VideoCallActivity.this.Q = true;
            }
        }

        public c0(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2) {
            this.f15828a = layoutParams;
            this.b = layoutParams2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VideoCallActivity.this.l0.setVisibility(8);
                VideoCallActivity.this.l0.setVisibility(0);
                VideoCallActivity.this.l0.setLayoutParams(this.f15828a);
                VideoCallActivity.this.l0.setZOrderOnTop(false);
                VideoCallActivity.this.l0.setZOrderMediaOverlay(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(new a(), 100L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.T3("76");
            try {
                VideoCallActivity.this.a1.J(AudioVoiceSelection.AudioProfile.Audio_only);
            } catch (Exception e) {
                e.printStackTrace();
            }
            VideoCallActivity.this.e0 = true;
            r75.o(AppContext.getContext(), k86.a("Is_Audio"), VideoCallActivity.this.e0);
            VideoCallActivity.this.x = true;
            pa6.p().L(ZMRtcMediaType.RtcMedia_Audio);
            pa6.p().j(false);
            VideoCallActivity.this.q0.setVisibility(8);
            VideoCallActivity.this.l0.setVisibility(8);
            VideoCallActivity.this.H0.setVisibility(8);
            sy5.d(VideoCallActivity.this, R.string.self_side_change_toaudio_toast, 20000).g();
            VideoCallActivity.this.N0.setVisibility(0);
            VideoCallActivity.this.O0.setVisibility(0);
            VideoCallActivity.this.V0.setVisibility(0);
            VideoCallActivity.this.s0.setVisibility(8);
            VideoCallActivity.this.t0.setVisibility(0);
            VideoCallActivity.this.S0.setVisibility(8);
            VideoCallActivity.this.E.setVisibility(8);
            VideoCallActivity.this.k0.setVisibility(8);
            VideoCallActivity.this.O0.setVisibility(0);
            VideoCallActivity.this.H3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.T3("76");
            VideoCallActivity.this.e0 = true;
            r75.o(AppContext.getContext(), k86.a("Is_Audio"), VideoCallActivity.this.e0);
            VideoCallActivity.this.x = true;
            pa6.p().L(ZMRtcMediaType.RtcMedia_Audio);
            pa6.p().j(false);
            VideoCallActivity.this.q0.setVisibility(8);
            VideoCallActivity.this.H0.setVisibility(8);
            sy5.d(VideoCallActivity.this, R.string.self_side_change_toaudio_toast, 20000).g();
            VideoCallActivity.this.N0.setVisibility(0);
            VideoCallActivity.this.O0.setVisibility(0);
            VideoCallActivity.this.V0.setVisibility(0);
            VideoCallActivity.this.s0.setVisibility(8);
            VideoCallActivity.this.t0.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<VideoCallActivity> f15833a;

        public e0(VideoCallActivity videoCallActivity) {
            this.f15833a = new WeakReference<>(videoCallActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            boolean z;
            VideoCallActivity videoCallActivity = this.f15833a.get();
            if (videoCallActivity != null) {
                try {
                    i = message.what;
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i == 1) {
                    int i2 = message.arg1;
                    if (i2 == 1) {
                        videoCallActivity.w0.setText(R.string.waiting_for_accepting);
                        videoCallActivity.x3(videoCallActivity.w0);
                        videoCallActivity.z0.setText(R.string.waiting_for_accepting);
                        videoCallActivity.x3(videoCallActivity.z0);
                        return;
                    }
                    if (i2 == -107) {
                        if (videoCallActivity.e0) {
                            videoCallActivity.L3(R.string.audio_not_friend_toast);
                            return;
                        } else {
                            videoCallActivity.L3(R.string.video_not_friend_toast);
                            return;
                        }
                    }
                    if (i2 == -108) {
                        videoCallActivity.L3(R.string.video_low_version_toast);
                        return;
                    } else {
                        if (i2 == -109) {
                            videoCallActivity.L3(R.string.video_low_version_toast);
                            return;
                        }
                        return;
                    }
                }
                if (i == 6) {
                    CallingStatus callingStatus = videoCallActivity.W0;
                    videoCallActivity.I3(CallingStatus.DISCONNECTED);
                    videoCallActivity.s = true;
                    if (callingStatus == CallingStatus.CONNECTED) {
                        videoCallActivity.S3(false);
                        videoCallActivity.t3(videoCallActivity.getString(R.string.video_call_msg_chat_duration) + " " + videoCallActivity.n3(videoCallActivity.i0));
                    } else {
                        videoCallActivity.u3(videoCallActivity.getString(R.string.video_call_msg_callee_cancelled));
                        videoCallActivity.E3();
                    }
                    sy5.d(videoCallActivity, R.string.video_call_hangupped, 0).g();
                    videoCallActivity.finish();
                    return;
                }
                if (i == 22) {
                    videoCallActivity.finish();
                    return;
                }
                if (i == 200) {
                    videoCallActivity.G3((String) message.obj);
                    return;
                }
                if (i == 10012) {
                    videoCallActivity.s = true;
                    if (pa6.p().g() < 1) {
                        videoCallActivity.finish();
                        return;
                    } else {
                        videoCallActivity.t3(AppContext.getContext().getString(R.string.video_call_msg_cancelled));
                        return;
                    }
                }
                if (i == 11001) {
                    videoCallActivity.Q = true;
                    return;
                }
                if (i == 3) {
                    removeMessages(10002);
                    removeMessages(10003);
                    removeMessages(10007);
                    if (message.arg1 == 1) {
                        videoCallActivity.I3(CallingStatus.CONNECTING);
                        videoCallActivity.w0.setText(R.string.video_call_connecting);
                        videoCallActivity.x3(videoCallActivity.w0);
                        videoCallActivity.z0.setText(R.string.video_call_connecting);
                        videoCallActivity.x3(videoCallActivity.z0);
                        videoCallActivity.p3(2000L);
                        return;
                    }
                    return;
                }
                if (i == 4) {
                    int i3 = message.arg1;
                    if (i3 == 1) {
                        videoCallActivity.w0.setText(R.string.video_call_connecting);
                        videoCallActivity.x3(videoCallActivity.w0);
                        videoCallActivity.z0.setText(R.string.video_call_connecting);
                        videoCallActivity.x3(videoCallActivity.z0);
                        videoCallActivity.p3(2000L);
                        return;
                    }
                    if (i3 == -201) {
                        if (videoCallActivity.e0) {
                            sy5.e(videoCallActivity, R.string.video_callee_audio_refused, 0).g();
                        } else {
                            sy5.e(videoCallActivity, R.string.video_callee_refused, 1).g();
                        }
                        videoCallActivity.t3(videoCallActivity.getString(R.string.video_call_msg_callee_refused));
                        videoCallActivity.finish();
                        return;
                    }
                    if (i3 == -203) {
                        sy5.e(videoCallActivity, R.string.video_call_msg_callee_busy, 0).g();
                        videoCallActivity.X0.sendEmptyMessageDelayed(10006, 2000L);
                        return;
                    } else {
                        if (i3 == -302) {
                            return;
                        }
                        sy5.e(videoCallActivity, R.string.video_call_failed, 0).g();
                        videoCallActivity.finish();
                        return;
                    }
                }
                if (i == 18) {
                    if (videoCallActivity.W0 == CallingStatus.CONNECTED) {
                        if (videoCallActivity.H.getText().equals(AppContext.getContext().getString(R.string.video_net_warning))) {
                            if (message.arg1 == ZMRtcSDK.RtcNetStatus_Reconnected) {
                                videoCallActivity.H.setVisibility(8);
                                videoCallActivity.H.setText(R.string.video_call_connection_toast);
                                return;
                            }
                            return;
                        }
                        int i4 = message.arg1;
                        int i5 = ZMRtcSDK.RtcNetStatus_Bad;
                        if (i4 != i5 && i4 != i5) {
                            if (i4 != ZMRtcSDK.RtcNetStatus_Maybe_Disconnected) {
                                if (videoCallActivity.H.getVisibility() == 0) {
                                    videoCallActivity.H.setVisibility(8);
                                    return;
                                }
                                return;
                            }
                            videoCallActivity.H.setText(R.string.video_net_warning);
                            videoCallActivity.H.setVisibility(0);
                            try {
                                if (videoCallActivity.a1 != null) {
                                    videoCallActivity.a1.v();
                                    return;
                                }
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        videoCallActivity.H.setText(R.string.video_call_connection_toast);
                        if (videoCallActivity.H.getVisibility() == 8) {
                            videoCallActivity.H.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i != 19) {
                    switch (i) {
                        case 8:
                            CallingStatus callingStatus2 = videoCallActivity.W0;
                            CallingStatus callingStatus3 = CallingStatus.CONNECTED;
                            if (callingStatus2 != callingStatus3) {
                                if (!videoCallActivity.e0) {
                                    int i6 = message.arg2;
                                    if (i6 == 0) {
                                        videoCallActivity.p3(2000L);
                                    } else if (i6 == 1) {
                                        videoCallActivity.I3(callingStatus3);
                                        videoCallActivity.c3();
                                        removeMessages(8);
                                        videoCallActivity.A3();
                                    }
                                } else {
                                    videoCallActivity.I3(callingStatus3);
                                    videoCallActivity.c3();
                                    removeMessages(8);
                                    videoCallActivity.z3();
                                }
                            }
                            break;
                        case 9:
                            videoCallActivity.Z = true;
                            break;
                        case 10:
                            if (videoCallActivity.l0 != null) {
                                videoCallActivity.l0.setBackgroundColor(0);
                            }
                            break;
                        case 11:
                            if (message.arg1 != 1) {
                                sy5.e(videoCallActivity, R.string.video_call_msg_callee_cancelled, 1).g();
                                videoCallActivity.t3(videoCallActivity.getString(R.string.video_call_msg_callee_cancelled));
                                videoCallActivity.finish();
                            }
                            break;
                        default:
                            switch (i) {
                                case 13:
                                    break;
                                case 14:
                                    if (message.arg1 == 0) {
                                        if (!videoCallActivity.N) {
                                            try {
                                                Thread.sleep(2000L);
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        }
                                        if (videoCallActivity.r0 != null) {
                                            pa6.p().h();
                                        }
                                        videoCallActivity.e0 = true;
                                        r75.o(AppContext.getContext(), k86.a("Is_Audio"), videoCallActivity.e0);
                                        if (videoCallActivity.Y0) {
                                            ny.m(1);
                                        }
                                        if (!videoCallActivity.x) {
                                            sy5.d(videoCallActivity, R.string.other_side_change_toaudio_toast, 500).g();
                                            if (videoCallActivity.W0 == CallingStatus.CONNECTED && !videoCallActivity.A0) {
                                                videoCallActivity.K3();
                                            }
                                        }
                                        videoCallActivity.f3();
                                    }
                                    break;
                                case 15:
                                    videoCallActivity.J3();
                                    break;
                                default:
                                    switch (i) {
                                        case 100:
                                            if (message.arg1 == 1) {
                                                videoCallActivity.G3((String) message.obj);
                                            }
                                            break;
                                        case 101:
                                            if (message.arg1 == 1) {
                                                videoCallActivity.G3((String) message.obj);
                                            }
                                            break;
                                        case 102:
                                            if (message.arg1 == 1) {
                                                if (hx3.m(videoCallActivity)) {
                                                    sy5.d(videoCallActivity, R.string.video_call_refused, 1).g();
                                                } else {
                                                    sy5.d(videoCallActivity, R.string.video_net_error, 1).g();
                                                }
                                                videoCallActivity.finish();
                                            }
                                            break;
                                        case 103:
                                            if (message.arg1 == 1) {
                                                videoCallActivity.G3((String) message.obj);
                                                videoCallActivity.finish();
                                            }
                                            break;
                                        case 104:
                                            if (message.arg1 == 1) {
                                                videoCallActivity.s = true;
                                                if (videoCallActivity.W0 == CallingStatus.CONNECTED) {
                                                    videoCallActivity.S3(true);
                                                } else {
                                                    z = false;
                                                }
                                                videoCallActivity.I3(CallingStatus.DISCONNECTED);
                                                videoCallActivity.G3((String) message.obj);
                                                if (z) {
                                                    videoCallActivity.t3(videoCallActivity.getString(R.string.video_call_msg_chat_duration) + " " + videoCallActivity.n3(videoCallActivity.i0));
                                                } else {
                                                    videoCallActivity.t3(videoCallActivity.getString(R.string.video_call_msg_callee_no_response));
                                                }
                                                videoCallActivity.finish();
                                            }
                                            break;
                                        case 105:
                                            videoCallActivity.G3((String) message.obj);
                                            break;
                                        default:
                                            switch (i) {
                                                case 10000:
                                                    videoCallActivity.I3(CallingStatus.CALLING);
                                                    pa6.p().f(videoCallActivity.X.getChatId(), ZMRtcMediaType.RtcMedia_Video);
                                                    sendEmptyMessageDelayed(10002, 20000L);
                                                    sendEmptyMessageDelayed(10003, 60000L);
                                                    break;
                                                case 10001:
                                                    videoCallActivity.R3();
                                                    break;
                                                case 10002:
                                                    videoCallActivity.G.setVisibility(0);
                                                    sendEmptyMessageDelayed(10007, 20000L);
                                                    break;
                                                case 10003:
                                                    videoCallActivity.s = true;
                                                    videoCallActivity.B0.setEnabled(false);
                                                    if (hx3.m(videoCallActivity)) {
                                                        sy5.d(videoCallActivity, R.string.video_call_msg_callee_no_action, 1).g();
                                                    } else {
                                                        sy5.d(videoCallActivity, R.string.video_net_error, 1).g();
                                                    }
                                                    videoCallActivity.X0.sendEmptyMessageDelayed(10004, 1L);
                                                    break;
                                                case 10004:
                                                    videoCallActivity.s = true;
                                                    if (pa6.p().g() >= 1) {
                                                        videoCallActivity.t3(AppContext.getContext().getString(R.string.video_call_msg_callee_no_response));
                                                    } else {
                                                        videoCallActivity.finish();
                                                    }
                                                    break;
                                                case 10005:
                                                    videoCallActivity.s = true;
                                                    if (pa6.p().g() >= 1) {
                                                        videoCallActivity.t3(AppContext.getContext().getString(R.string.video_call_msg_callee_no_response));
                                                    } else {
                                                        videoCallActivity.finish();
                                                    }
                                                    break;
                                                case 10006:
                                                    videoCallActivity.s = true;
                                                    if (pa6.p().g() >= 1) {
                                                        videoCallActivity.t3(AppContext.getContext().getString(R.string.video_call_msg_callee_busy_voip));
                                                        videoCallActivity.finish();
                                                    } else {
                                                        videoCallActivity.finish();
                                                    }
                                                    break;
                                                case 10007:
                                                    videoCallActivity.G.setVisibility(8);
                                                    break;
                                                case 10008:
                                                    Log.i(VideoCallActivity.b1, "MESSAGE_RECEIVER_HANGUP_LATER ");
                                                    videoCallActivity.s = true;
                                                    videoCallActivity.B0.setEnabled(false);
                                                    if (pa6.p().E() >= 1) {
                                                        videoCallActivity.t3(AppContext.getContext().getString(R.string.video_no_response_toast));
                                                        videoCallActivity.E3();
                                                    } else {
                                                        videoCallActivity.finish();
                                                    }
                                                    break;
                                                case PushConsts.SET_TAG_RESULT /* 10009 */:
                                                    videoCallActivity.e3();
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                }
                Log.i(VideoCallActivity.b1, "通话过程中网络断了 ");
                sy5.d(videoCallActivity, R.string.video_net_error, 1).g();
                pa6.p().v();
                return;
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.T3("76");
            pa6.p().L(ZMRtcMediaType.RtcMedia_Audio);
            VideoCallActivity.this.e0 = true;
            r75.o(AppContext.getContext(), k86.a("Is_Audio"), VideoCallActivity.this.e0);
            VideoCallActivity.this.x = true;
            pa6.p().j(false);
            ny.a();
            if (pa6.p().d() < 1) {
                VideoCallActivity.this.finish();
                return;
            }
            VideoCallActivity.this.q0.setVisibility(8);
            VideoCallActivity.this.l0.setVisibility(8);
            VideoCallActivity.this.J0.setVisibility(8);
            VideoCallActivity.this.H0.setVisibility(8);
            sy5.d(VideoCallActivity.this, R.string.self_side_change_toaudio_toast, 20000).g();
            VideoCallActivity.this.N0.setVisibility(0);
            VideoCallActivity.this.O0.setVisibility(0);
            VideoCallActivity.this.V0.setVisibility(0);
            VideoCallActivity.this.s0.setVisibility(8);
            VideoCallActivity.this.t0.setVisibility(0);
            VideoCallActivity.this.S0.setVisibility(8);
            VideoCallActivity.this.E.setVisibility(8);
            VideoCallActivity.this.E0.setVisibility(8);
            VideoCallActivity.this.D0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoCallActivity.this.B) {
                VideoCallActivity.this.P0.setImageResource(R.drawable.selector_video_call_silence);
            } else {
                VideoCallActivity.this.P0.setImageResource(R.drawable.video_call_voiceban_off);
            }
            VideoCallActivity.this.B = !r2.B;
            pa6.p().A(VideoCallActivity.this.B);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                VideoCallActivity.this.a1.L(!VideoCallActivity.this.a1.q());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallActivity.this.r = !r2.r;
            pa6.p().W();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            VideoCallActivity.this.moveTaskToBack(true);
            r75.o(AppContext.getContext(), k86.a("is_show_float_view"), true);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AppContext.isFloatWindowOpAllowed(VideoCallActivity.this)) {
                VideoCallActivity.this.showFloatAllow(new View.OnClickListener() { // from class: z96
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f22382a.b(view2);
                    }
                });
                return;
            }
            VideoCallActivity.this.moveTaskToBack(true);
            LogUtil.i(VideoCallActivity.b1, "moveTaskToBack: isTaskRoot " + VideoCallActivity.this.isTaskRoot());
            r75.o(AppContext.getContext(), k86.a("is_show_float_view"), true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements c.e {
        public k() {
        }

        @Override // com.zenmen.palmchat.videocall.c.e
        public void a(int i) {
            LogUtil.i(VideoCallActivity.b1, "DISTANCE: " + String.valueOf(i));
            if (i == 1) {
                VideoCallActivity.this.q = true;
            } else {
                VideoCallActivity.this.q = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends TimerTask {
        public l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            pa6.p().r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends TimerTask {
        public m() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 8;
            message.arg2 = !VideoCallActivity.this.e0 ? 1 : 0;
            VideoCallActivity.this.X0.sendMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends MaterialDialog.e {
        public n() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15843a;

        public o(String str) {
            this.f15843a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageVo messageVo = new MessageVo();
            messageVo.mid = xn3.a();
            messageVo.time = ir5.b();
            messageVo.contactRelate = VideoCallActivity.this.X.getChatId();
            messageVo.to = VideoCallActivity.this.X.getChatId();
            VideoCallActivity videoCallActivity = VideoCallActivity.this;
            messageVo.text = videoCallActivity.getString(videoCallActivity.f0 == 0 ? R.string.message_type_video_call : R.string.message_type_voice_call);
            messageVo.mimeType = 30;
            messageVo.status = 2;
            messageVo.sendFlag = String.valueOf(0);
            messageVo.from = AccountUtils.p(AppContext.getContext());
            VideoCallActivity videoCallActivity2 = VideoCallActivity.this;
            messageVo.isSend = videoCallActivity2.Y;
            messageVo.isRead = true;
            messageVo.extention = "";
            messageVo.data1 = this.f15843a;
            messageVo.data2 = String.valueOf(videoCallActivity2.f0);
            com.zenmen.palmchat.database.b.t(messageVo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15844a;

        public p(String str) {
            this.f15844a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageVo messageVo = new MessageVo();
            messageVo.mid = xn3.a();
            messageVo.time = ir5.b();
            messageVo.contactRelate = VideoCallActivity.this.X.getChatId();
            messageVo.to = VideoCallActivity.this.X.getChatId();
            VideoCallActivity videoCallActivity = VideoCallActivity.this;
            messageVo.text = videoCallActivity.getString(videoCallActivity.f0 == 0 ? R.string.message_type_video_call : R.string.message_type_voice_call);
            messageVo.mimeType = 30;
            messageVo.status = 2;
            messageVo.sendFlag = String.valueOf(0);
            messageVo.from = AccountUtils.p(AppContext.getContext());
            VideoCallActivity videoCallActivity2 = VideoCallActivity.this;
            messageVo.isSend = videoCallActivity2.Y;
            messageVo.isRead = false;
            messageVo.extention = "";
            messageVo.data1 = this.f15844a;
            messageVo.data2 = String.valueOf(videoCallActivity2.f0);
            com.zenmen.palmchat.database.b.t(messageVo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends MaterialDialog.e {
        public q() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraView f15846a;

        public r(CameraView cameraView) {
            this.f15846a = cameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15846a.setVisibility(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements a.InterfaceC1128a {
        public s() {
        }

        @Override // com.zenmen.palmchat.videocall.a.InterfaceC1128a
        public void a(int i, int i2) {
            VideoCallActivity.this.U = i;
            VideoCallActivity.this.V = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends MaterialDialog.e {
        public t() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends BroadcastReceiver {
        public u() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String str = VideoCallActivity.b1;
            LogUtil.i(str, "receive INTENT_ACTION_FLOATVIEW_PERMISSION_READY");
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_FLOATVIEW_PERMISSION_READY)) {
                if (((!VideoCallActivity.this.e0 || VideoCallActivity.this.A) && VideoCallActivity.this.W0 != CallingStatus.CONNECTED) || VideoCallActivity.this.q || VideoCallActivity.this.K != null) {
                    return;
                }
                LogUtil.i(str, "Float view permission was granted and restore the VOIP video in float view mode");
                VideoCallActivity.this.K3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements Runnable {
        public v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pa6.p().D(VideoCallActivity.this.getIntent().getStringExtra("room_id"))) {
                Log.i(VideoCallActivity.b1, "room " + VideoCallActivity.this.getIntent().getStringExtra("room_id") + " is already closed.");
                Message message = new Message();
                message.what = 6;
                VideoCallActivity.this.X0.handleMessage(message);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            VideoCallActivity.F3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x extends MaterialDialog.e {
        public x() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            VideoCallActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15852a;
        public int b;
        public int c;
        public int d;
        public int e;
        public DisplayMetrics f;
        public int g;
        public int h;

        public y() {
            DisplayMetrics displayMetrics = VideoCallActivity.this.getResources().getDisplayMetrics();
            this.f = displayMetrics;
            this.g = displayMetrics.widthPixels;
            this.h = displayMetrics.heightPixels;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f15852a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                this.g = VideoCallActivity.this.q0.getWidth();
                this.h = VideoCallActivity.this.q0.getHeight();
                this.e = view.getWidth();
                this.c = (int) motionEvent.getRawX();
                this.d = (int) motionEvent.getRawY();
                LogUtil.i(VideoCallActivity.b1, "ACTION_DOWN : " + this.f15852a + "," + this.b);
            } else if (action == 2) {
                int rawX = ((int) motionEvent.getRawX()) - this.f15852a;
                int rawY = ((int) motionEvent.getRawY()) - this.b;
                LogUtil.i(VideoCallActivity.b1, "ACTION_MOVE : " + rawX + "," + rawY);
                int left = view.getLeft() + rawX;
                int top = view.getTop() + rawY;
                int right = view.getRight() + rawX;
                int bottom = view.getBottom() + rawY;
                if (left < 0) {
                    right = view.getWidth() + 0;
                }
                int i = this.g;
                if (right > i) {
                    view.getWidth();
                    right = i;
                }
                if (top < 0) {
                    bottom = view.getHeight() + 0;
                    top = 0;
                }
                int i2 = this.h;
                if (bottom > i2) {
                    top = i2 - view.getHeight();
                }
                try {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.topMargin = top;
                    layoutParams.rightMargin = VideoCallActivity.this.getWindow().getDecorView().getWidth() - right;
                    view.setLayoutParams(layoutParams);
                } catch (Exception unused) {
                }
                LogUtil.i(VideoCallActivity.b1, "ACTION_MOVE : " + this.f15852a + "," + this.b);
                this.f15852a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
            } else if (action == 1) {
                LogUtil.i(VideoCallActivity.b1, "ACTION_UP : " + this.f15852a + "," + this.b);
                int rawX2 = ((int) motionEvent.getRawX()) - this.f15852a;
                motionEvent.getRawY();
                int rawX3 = ((int) motionEvent.getRawX()) - this.c;
                int rawY2 = ((int) motionEvent.getRawY()) - this.d;
                if ((rawX3 * rawX3) + (rawY2 * rawY2) >= 150) {
                    if (view.getLeft() + rawX2 + (view.getWidth() / 2) < this.g / 2) {
                        VideoCallActivity.this.h3(view, -view.getLeft());
                    } else {
                        VideoCallActivity.this.h3(view, r0 - view.getRight());
                    }
                } else if (Build.BRAND.toLowerCase().equals("oppo")) {
                    VideoCallActivity.this.C3();
                } else {
                    VideoCallActivity.this.B3();
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((ImageView) VideoCallActivity.this.findViewById(R.id.surface_cover_view)).setVisibility(8);
                VideoCallActivity.this.l0.setOnTouchListener(VideoCallActivity.this.u);
                VideoCallActivity.this.r0.setOnTouchListener(null);
                VideoCallActivity videoCallActivity = VideoCallActivity.this;
                videoCallActivity.Q = false;
                videoCallActivity.X0.sendEmptyMessageDelayed(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, 300L);
            }
        }

        public z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(me1.b(VideoCallActivity.this, 66), me1.b(VideoCallActivity.this, 127));
            layoutParams.topMargin = VideoCallActivity.this.T;
            if (VideoCallActivity.this.R) {
                layoutParams.rightMargin = me1.b(VideoCallActivity.this, 12);
            } else if (VideoCallActivity.this.S) {
                layoutParams.rightMargin = 0;
            } else {
                layoutParams.rightMargin = VideoCallActivity.this.getWindow().getDecorView().getWidth() - me1.b(VideoCallActivity.this, 66);
            }
            layoutParams.gravity = 5;
            ViewGroup.LayoutParams layoutParams2 = VideoCallActivity.this.l0.getLayoutParams();
            pa6.p().h();
            try {
                VideoCallActivity.this.q0.removeView(VideoCallActivity.this.r0);
                VideoCallActivity.this.k0.removeView(VideoCallActivity.this.l0);
                VideoCallActivity.this.r0.setZOrderOnTop(false);
                VideoCallActivity.this.r0.setZOrderMediaOverlay(false);
                VideoCallActivity.this.r0.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                VideoCallActivity.this.k0.addView(VideoCallActivity.this.r0);
                VideoCallActivity.this.l0.setZOrderOnTop(true);
                VideoCallActivity.this.l0.setZOrderMediaOverlay(true);
                VideoCallActivity.this.l0.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                if (VideoCallActivity.this.l0.getParent() != null) {
                    ((ViewGroup) VideoCallActivity.this.l0.getParent()).removeView(VideoCallActivity.this.l0);
                }
                VideoCallActivity.this.q0.addView(VideoCallActivity.this.l0);
                VideoCallActivity.this.r0.setLayoutParams(layoutParams2);
                VideoCallActivity.this.l0.setLayoutParams(layoutParams);
                VideoCallActivity.this.l0.getHolder().setFormat(-3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            VideoCallActivity.this.N3();
            new Handler().postDelayed(new a(), 200L);
        }
    }

    public static void F3() {
        try {
            if (f1 != null) {
                if (o3().X0 == null) {
                    Thread.sleep(20L);
                    new g13(new w()).start();
                } else {
                    while (!f1.isEmpty()) {
                        o3().X0.sendMessage(f1.get(0));
                        f1.remove(0);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void b3(Message message) {
        if (f1 == null) {
            f1 = new ArrayList();
        }
        f1.add(message);
        F3();
    }

    public static VideoCallActivity o3() {
        return c1;
    }

    public final void A3() {
        this.T = me1.b(this, 37);
        try {
            AudioVoiceSelection audioVoiceSelection = this.a1;
            if (audioVoiceSelection != null) {
                audioVoiceSelection.I();
                this.a1.J(AudioVoiceSelection.AudioProfile.AUTO);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TextView textView = this.G;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.X0.sendEmptyMessageDelayed(PushConsts.SET_TAG_RESULT, 10000L);
        this.X0.removeMessages(10002);
        this.X0.removeMessages(10003);
        if (!this.Y) {
            this.X0.removeMessages(10008);
        }
        ImageView imageView = this.n0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.o0;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        EffectiveShapeView effectiveShapeView = this.u0;
        if (effectiveShapeView != null) {
            effectiveShapeView.setVisibility(8);
        }
        try {
            this.v0.setVisibility(8);
            this.w0.setVisibility(8);
            this.z0.setVisibility(8);
            this.V0.setVisibility(0);
            this.P0.setEnabled(true);
            this.P0.setAlpha(1.0f);
            this.P0.setImageResource(R.drawable.selector_video_call_silence);
            this.G0.setText("00:00");
            this.G0.setVisibility(0);
            this.j0 = System.currentTimeMillis();
            this.X0.sendEmptyMessageDelayed(10001, 1000L);
            if (!this.e0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(me1.b(this, 66), me1.b(this, 127));
                layoutParams.topMargin = me1.b(this, 37);
                layoutParams.rightMargin = me1.b(this, 12);
                layoutParams.gravity = 5;
                CameraView cameraView = this.r0;
                if (cameraView == null) {
                    CameraView cameraView2 = new CameraView(this);
                    this.r0 = cameraView2;
                    cameraView2.setZOrderOnTop(true);
                    this.r0.setZOrderMediaOverlay(true);
                    this.r0.setLayoutParams(layoutParams);
                    this.q0.addView(this.r0);
                    if (pa6.p().T(this.r0, getWindowManager().getDefaultDisplay().getRotation(), this.r ? CameraRecorder.CAMERA_TYPE.CAMERA_FRONT : CameraRecorder.CAMERA_TYPE.CAMERA_BACK) != 0) {
                        Intent intent = new Intent(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION);
                        intent.putExtra(this.INTENT_KEY_VOIP_PERMISSION, 1);
                        sendLocalBroadcast(intent);
                        Log.e(b1, "Open Camera Error");
                        new sd3(this).T(R.string.dialog_note).j(R.string.dialog_content_camera_fail).O(R.string.alert_dialog_ok).f(new q()).e().show();
                    }
                    pa6.p().U();
                } else {
                    cameraView.setLayoutParams(layoutParams);
                }
                this.r0.setOnTouchListener(this.u);
            }
            this.C0.setText(R.string.video_call_hangup);
            this.H0.setVisibility(8);
            this.S0.setVisibility(0);
            this.J0.setVisibility(8);
            this.E.setVisibility(0);
            AudioVoiceSelection audioVoiceSelection2 = this.a1;
            if (audioVoiceSelection2 != null) {
                audioVoiceSelection2.u();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void B3() {
        if (this.W0 == CallingStatus.CONNECTED && this.Q) {
            if (this.y) {
                ImageView imageView = (ImageView) findViewById(R.id.surface_cover_view);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                hc2.a(AppContext.getContext()).load(k86.p(this.X.getIconURL())).placeholder(R.drawable.video_call_icon_loading_fail_bg).error(R.drawable.video_call_icon_loading_fail_bg).transition(DrawableTransitionOptions.withCrossFade()).transform(new gu(14, 3)).into(imageView);
                imageView.setVisibility(0);
                new Handler().postDelayed(new z(), 50L);
            } else {
                ((ImageView) findViewById(R.id.surface_cover_view)).setVisibility(0);
                new Handler().postDelayed(new a0(), 50L);
            }
            this.y = !this.y;
        }
    }

    public final synchronized void C3() {
        if (this.W0 != CallingStatus.CONNECTED) {
            return;
        }
        if (this.Q) {
            this.Q = false;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(me1.b(this, 66), me1.b(this, 127));
            layoutParams.topMargin = this.T;
            if (this.R) {
                layoutParams.rightMargin = me1.b(this, 12);
            } else if (this.S) {
                layoutParams.rightMargin = 0;
            } else {
                layoutParams.rightMargin = getWindow().getDecorView().getWidth() - me1.b(this, 66);
            }
            layoutParams.gravity = 5;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 112);
            if (this.y) {
                new Handler().postDelayed(new b0(layoutParams2, layoutParams), 100L);
            } else {
                new Handler().postDelayed(new c0(layoutParams2, layoutParams), 100L);
            }
            this.y = this.y ? false : true;
        }
    }

    public void D3() {
        View view;
        WindowManager windowManager = this.I;
        if (windowManager == null || (view = this.K) == null) {
            return;
        }
        windowManager.removeView(view);
        this.K = null;
        this.A0 = true;
    }

    public final void E3() {
        boolean z2 = this.e0;
        ny.n(z2 ? 1 : 0, this.X.getChatName(), this.X.getChatId());
    }

    public final void G3(String str) {
        pa6.p().I(str);
    }

    public final void H3() {
        ChatItem chatItem = this.X;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getIconURL()) || this.X.getIconURL().toLowerCase().contains("/default/")) {
            hc2.a(AppContext.getContext()).load(Integer.valueOf(R.drawable.video_call_icon_loading_fail_bg)).into(this.n0);
        } else {
            hc2.a(AppContext.getContext()).load(k86.p(this.X.getIconURL())).error(R.drawable.video_call_icon_loading_fail_bg).transition(DrawableTransitionOptions.withCrossFade()).transform(new gu(14, 3)).into(this.n0);
        }
        this.n0.setVisibility(0);
    }

    public final void I3(CallingStatus callingStatus) {
        this.W0 = callingStatus;
        try {
            AudioVoiceSelection audioVoiceSelection = this.a1;
            if (audioVoiceSelection != null) {
                audioVoiceSelection.B(callingStatus);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void J3() {
        Intent intent = new Intent(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION);
        intent.putExtra(this.INTENT_KEY_VOIP_PERMISSION, 2);
        sendLocalBroadcast(intent);
        new sd3(this).T(R.string.dialog_note).j(R.string.video_call_get_audio_data_failed).O(R.string.alert_dialog_ok).f(new t()).e().show();
    }

    public void K3() {
        View view = this.K;
        if (view != null) {
            this.I.removeView(view);
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.view_float_voip, (ViewGroup) null);
        this.K = viewInflate;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.float_audio);
        FrameLayout frameLayout = (FrameLayout) this.K.findViewById(R.id.float_video);
        this.R0 = (TextView) this.K.findViewById(R.id.audio_time);
        this.L0 = (LinearLayout) this.K.findViewById(R.id.float_remote);
        CameraView cameraView = (CameraView) this.K.findViewById(R.id.float_local);
        if (this.i0 < 1) {
            this.R0.setText(R.string.video_call_waiting);
        }
        if (this.e0) {
            frameLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            if (!this.O) {
                pa6.p().h();
            }
            if (!this.O) {
                O3(cameraView);
            }
            cameraView.setZOrderOnTop(true);
            cameraView.setZOrderMediaOverlay(true);
            new Handler().postDelayed(new r(cameraView), 3000L);
            if (this.y) {
                this.k0.removeView(this.l0);
            } else {
                this.q0.removeView(this.l0);
            }
            this.l0.setZOrderOnTop(false);
            this.l0.setZOrderMediaOverlay(false);
            this.l0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            if (this.l0.getParent() != null) {
                ((ViewGroup) this.l0.getParent()).removeView(this.l0);
            }
            this.L0.addView(this.l0);
            this.l0.setOnTouchListener(null);
        }
        this.J = ((AppContext) getApplication()).getMywmParams();
        com.zenmen.palmchat.videocall.a aVar = new com.zenmen.palmchat.videocall.a(getApplicationContext(), this.K, this.I, this.J, new s());
        this.L = aVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.J.type = 2038;
        } else {
            this.J.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.J;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 53;
        layoutParams.x = this.U;
        layoutParams.y = this.V;
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.K.setOnTouchListener(aVar);
        this.I.addView(this.K, this.J);
        this.A0 = false;
    }

    public final void L3(int i2) {
        new sd3(this).j(i2).h(false).O(R.string.alert_dialog_ok).f(new x()).e().show();
    }

    public final void M3(boolean z2) {
        try {
            if (z2) {
                if (this.w == null) {
                    this.w = new ea5(this.F0);
                }
                this.w.c();
            } else {
                ea5 ea5Var = this.w;
                if (ea5Var != null) {
                    ea5Var.d();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N3() {
        pa6.p().T(this.r0, getWindowManager().getDefaultDisplay().getRotation(), this.r ? CameraRecorder.CAMERA_TYPE.CAMERA_FRONT : CameraRecorder.CAMERA_TYPE.CAMERA_BACK);
    }

    public final void O3(CameraView cameraView) {
        pa6.p().T(cameraView, getWindowManager().getDefaultDisplay().getRotation(), this.r ? CameraRecorder.CAMERA_TYPE.CAMERA_FRONT : CameraRecorder.CAMERA_TYPE.CAMERA_BACK);
    }

    public final void P3() {
        if (this.e0) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL);
        } else {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_CALL);
        }
    }

    public void Q3() {
        if (this.Y) {
            pa6.p().k();
            return;
        }
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !(str.toLowerCase().equals("oppo") || str.toLowerCase().equals("vivo"))) {
                pa6.p().k();
            } else if (v3()) {
                pa6.p().k();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void R3() {
        if (this.W0 == CallingStatus.CONNECTED) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.j0) / 1000);
            this.i0 = iCurrentTimeMillis;
            if (iCurrentTimeMillis == 0) {
                this.i0 = 1;
            }
            this.G0.setText(n3(this.i0));
            TextView textView = this.R0;
            if (textView != null) {
                textView.setText(m3(this.i0));
            }
            this.X0.removeMessages(10001);
            this.X0.sendEmptyMessageDelayed(10001, 1000L);
        }
    }

    public final void S3(boolean z2) {
        JSONObject jSONObject = new JSONObject();
        String strP = AccountUtils.p(this);
        try {
            jSONObject.put("time", this.i0);
            jSONObject.put("roomId", pa6.p().t());
            jSONObject.put("hangupReason", this.Z ? 3 : 2);
            jSONObject.put("handleUid", z2 ? strP : this.X.getChatId());
            jSONObject.put("type", this.e0 ? 1 : 0);
            jSONObject.put("callingUid", this.Y ? strP : this.X.getChatId());
            LogUtil.uploadInfoImmediate(strP, "75", null, null, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void T3(String str) {
        LogUtil.onClickEvent(str, null, null);
    }

    public final void c3() {
        Timer timer = this.h0;
        if (timer != null) {
            timer.cancel();
            this.h0 = null;
        }
    }

    public final void d3(boolean z2) {
        View decorView = getWindow().getDecorView();
        if (z2) {
            getWindow().getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | (!cc1.b().equals("OPPO") ? 5380 : 5376));
        } else {
            decorView.getSystemUiVisibility();
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    public final void e3() {
        if (this.W0 != CallingStatus.CONNECTED || this.e0) {
            return;
        }
        try {
            LinearLayout linearLayout = this.T0;
            if (linearLayout == null || linearLayout.getVisibility() != 0) {
                l3();
            } else {
                k3();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f3() {
        if (this.W0 == CallingStatus.CONNECTED) {
            try {
                this.a1.l(AudioVoiceSelection.i.RECEIVER);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            pa6.p().V();
            try {
                this.t0.setVisibility(0);
                this.l0.setVisibility(8);
                this.q0.setVisibility(8);
                this.N0.setVisibility(0);
                this.O0.setVisibility(0);
                this.E.setVisibility(8);
                this.S0.setVisibility(8);
                this.V0.setVisibility(0);
                this.z0.setText("");
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
            H3();
            if (this.T0.getVisibility() != 0) {
                l3();
            }
        } else {
            try {
                LinearLayout linearLayout = this.t0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.s0;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                if (!this.Y) {
                    this.N0.setVisibility(8);
                    this.O0.setVisibility(8);
                    this.z0.setText(R.string.invite_audio_call);
                    x3(this.z0);
                }
                this.H0.setVisibility(8);
                this.J0.setVisibility(8);
                this.V0.setVisibility(0);
                this.q0.setVisibility(8);
                H3();
            } catch (NullPointerException e4) {
                e4.printStackTrace();
            }
        }
        pa6.p().L(ZMRtcMediaType.RtcMedia_Audio);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        Log.i(b1, "[finish]");
        this.A = true;
        try {
            Thread.sleep(200L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.Z0) {
            try {
                AudioVoiceSelection audioVoiceSelection = this.a1;
                if (audioVoiceSelection != null) {
                    audioVoiceSelection.I();
                    this.a1.u();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.X0.removeMessages(10008);
            this.P = true;
            this.X0.removeMessages(10002);
            this.X0.removeMessages(10003);
            this.X0.removeMessages(10001);
            Timer timer = this.g0;
            if (timer != null) {
                timer.cancel();
            }
            c3();
            Q3();
            pa6.p().G();
        }
        try {
            AudioVoiceSelection audioVoiceSelection2 = this.a1;
            if (audioVoiceSelection2 != null) {
                audioVoiceSelection2.y();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        finishAndRemoveTask();
        super.finish();
    }

    public final boolean g3() {
        long longExtra = getIntent().getLongExtra("call_time", -1L);
        if (longExtra == pa6.p().q()) {
            this.Z0 = true;
        } else {
            pa6.p().P(longExtra);
            this.Z0 = false;
        }
        return !this.Z0;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 117;
    }

    public final void h3(View view, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, f2, 1.0f, 0.0f);
        this.v = translateAnimation;
        translateAnimation.setDuration(200L);
        this.v.setInterpolator(new DecelerateInterpolator());
        this.v.setFillAfter(true);
        this.v.setAnimationListener(new d0(view, f2));
        view.startAnimation(this.v);
    }

    public final void i3() {
        if (this.e0) {
            if (!this.Y) {
                this.X0.sendEmptyMessageDelayed(10008, 65000L);
                return;
            }
            I3(CallingStatus.CALLING);
            pa6.p().f(this.X.getChatId(), ZMRtcMediaType.RtcMedia_Audio);
            this.X0.sendEmptyMessageDelayed(10002, 20000L);
            this.X0.sendEmptyMessageDelayed(10003, 60000L);
            return;
        }
        pa6.p().j(true);
        if (!this.Y) {
            this.X0.sendEmptyMessageDelayed(10008, 65000L);
            return;
        }
        if (pa6.p().T(this.r0, getWindowManager().getDefaultDisplay().getRotation(), this.r ? CameraRecorder.CAMERA_TYPE.CAMERA_FRONT : CameraRecorder.CAMERA_TYPE.CAMERA_BACK) != 0) {
            Intent intent = new Intent(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION);
            intent.putExtra(this.INTENT_KEY_VOIP_PERMISSION, 1);
            sendLocalBroadcast(intent);
            Log.e(b1, "Open Camera Error");
            new sd3(this).T(R.string.dialog_note).j(R.string.dialog_content_camera_fail).O(R.string.alert_dialog_ok).f(new n()).e().show();
        }
        pa6.p().U();
        this.X0.sendEmptyMessageDelayed(10000, 500L);
    }

    public final void j3() {
        if (!this.e0 && this.W0 == CallingStatus.CONNECTED) {
            if (this.A0) {
                return;
            }
            if (!this.O) {
                pa6.p().h();
            }
            this.L0.removeView(this.l0);
            this.r0.setZOrderOnTop(true);
            this.r0.setZOrderMediaOverlay(true);
            if (!this.O) {
                N3();
            }
            this.l0.setZOrderOnTop(true);
            this.l0.setZOrderMediaOverlay(true);
            if (this.y) {
                this.l0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.k0.addView(this.l0);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 > 26 || (i2 >= 23 && Build.MANUFACTURER.toLowerCase().equals("oneplus"))) {
                    this.q0.removeView(this.r0);
                    this.q0.addView(this.r0);
                    N3();
                }
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(me1.b(this, 66), me1.b(this, 127));
                layoutParams.topMargin = this.T;
                if (this.R) {
                    layoutParams.rightMargin = me1.b(this, 12);
                } else if (this.S) {
                    layoutParams.rightMargin = 0;
                } else {
                    layoutParams.rightMargin = getWindow().getDecorView().getWidth() - me1.b(this, 66);
                }
                layoutParams.gravity = 5;
                this.l0.setLayoutParams(layoutParams);
                this.q0.addView(this.l0);
                this.l0.setOnTouchListener(this.u);
            }
        }
        D3();
    }

    public final void k3() {
        this.X0.removeMessages(PushConsts.SET_TAG_RESULT);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        LinearLayout linearLayout = this.T0;
        if (linearLayout != null) {
            linearLayout.setAnimation(alphaAnimation);
            this.T0.setVisibility(8);
        }
        d3(true);
    }

    public final void l3() {
        this.X0.sendEmptyMessageDelayed(PushConsts.SET_TAG_RESULT, 10000L);
        d3(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(500L);
        LinearLayout linearLayout = this.T0;
        if (linearLayout != null) {
            linearLayout.setAnimation(alphaAnimation);
            this.T0.setVisibility(0);
        }
    }

    public final String m3(int i2) {
        int i3 = i2 / 3600;
        int i4 = i2 - (i3 * 3600);
        int i5 = i4 / 60;
        int i6 = i4 - (i5 * 60);
        return i3 == 0 ? String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public final String n3(int i2) {
        int i3 = i2 / 60;
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2 - (i3 * 60)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        List<ActivityManager.AppTask> appTasks;
        this.N = false;
        super.onCreate(bundle);
        Log.i(b1, "[onCreate]");
        setContentView(R.layout.activity_video_call_shake);
        getWindow().addFlags(6815872);
        this.s = false;
        this.Y = getIntent().getBooleanExtra("is_caller", false);
        try {
            AudioVoiceSelection audioVoiceSelectionM = AudioVoiceSelection.m();
            this.a1 = audioVoiceSelectionM;
            audioVoiceSelectionM.M();
            this.a1.C((ImageView) findViewById(R.id.handsfree_btn));
            this.a1.p(AppContext.getContext(), this.Y);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        y3();
        P3();
        this.M = false;
        c1 = this;
        try {
            Intent intent = new Intent(this, (Class<?>) VideoCallService.class);
            intent.setAction("action_foreground");
            intent.putExtra("call_type", getIntent().getIntExtra("call_type", 0));
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
            this.M = true;
        } catch (SecurityException unused) {
            Log.i(b1, "Failed to start forground service because of SecurityException.");
        }
        registerLocalReceiver(this.W, new IntentFilter(FrameworkBaseActivity.INTENT_ACTION_FLOATVIEW_PERMISSION_READY));
        if (!g3()) {
            Log.i(b1, "checkCallValidation failed");
            ActivityManager activityManager = (ActivityManager) getSystemService("activity");
            if (activityManager != null && (appTasks = activityManager.getAppTasks()) != null && appTasks.size() > 0) {
                appTasks.get(0).setExcludeFromRecents(true);
            }
            Intent intent2 = new Intent(this, (Class<?>) MainTabsActivity.class);
            k86.X(intent2);
            startActivity(intent2);
            finish();
            return;
        }
        pa6.p().Q(it0.k().f());
        r3();
        s3();
        q3();
        i3();
        com.zenmen.palmchat.videocall.c.c().d(new k());
        vk3.a();
        try {
            this.a1.J(AudioVoiceSelection.AudioProfile.AUTO);
            this.a1.H(0);
            this.a1.x();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        d1 = true;
        pa6.p().R(ZMRtcParamID.RtcParamID_Update_App_State, Integer.valueOf(ZMRtcAppState.RtcApp_State_Created.ordinal()));
        if (!this.Y) {
            new Handler().postDelayed(new v(), 300L);
        }
        M3(true);
        this.N = true;
        try {
            if (bc1.b().equals("Vivo V1838T")) {
                this.O = true;
            } else {
                this.O = false;
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.i(b1, "[onDestroy]");
        this.N = false;
        super.onDestroy();
        d1 = false;
        if (this.M) {
            stopService(new Intent(this, (Class<?>) VideoCallService.class));
            this.M = false;
        }
        pa6.p().R(ZMRtcParamID.RtcParamID_Update_App_State, Integer.valueOf(ZMRtcAppState.RecApp_State_Destroyed.ordinal()));
        if (!this.Z0) {
            if (!this.A) {
                try {
                    AudioVoiceSelection audioVoiceSelection = this.a1;
                    if (audioVoiceSelection != null) {
                        audioVoiceSelection.I();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.X0.removeMessages(10008);
                this.X0.removeMessages(10002);
                this.X0.removeMessages(10003);
                this.X0.removeMessages(10001);
                Timer timer = this.g0;
                if (timer != null) {
                    timer.cancel();
                }
                c3();
                Q3();
            }
            pa6.p().K(null);
            pa6.p().G();
            D3();
        }
        try {
            AudioVoiceSelection audioVoiceSelection2 = this.a1;
            if (audioVoiceSelection2 != null) {
                audioVoiceSelection2.M();
                this.a1 = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        unregisterLocalReceiver(this.W);
        com.zenmen.palmchat.videocall.c.c().l();
        M3(false);
        List<Message> list = f1;
        if (list != null) {
            list.clear();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 24:
            case 25:
            case 26:
                try {
                    this.a1.D(i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                break;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Log.i(b1, "[onNewIntent]");
        j3();
        super.onNewIntent(intent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pa6.p().R(ZMRtcParamID.RtcParamID_Update_App_State, Integer.valueOf(ZMRtcAppState.RtcApp_State_InVisible.ordinal()));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDialogCancel(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDialogCancel(permissionType, permissionUsage);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        super.onPermissionGrant(permissionType, permissionUsage, z2);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.zenmen.palmchat.videocall.c.c().k();
        String str = b1;
        LogUtil.i(str, "onResume");
        if (!this.A0 && this.K != null) {
            LogUtil.i(str, "onResume doResume");
            j3();
        }
        com.zenmen.palmchat.videocall.a.c();
        pa6.p().R(ZMRtcParamID.RtcParamID_Update_App_State, Integer.valueOf(ZMRtcAppState.RtcApp_State_Visible.ordinal()));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.Y0 = false;
        Log.i(b1, "[onStart]");
        bindMessagingService();
        com.zenmen.palmchat.videocall.a.c();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.Y0 = true;
        if (this.e0 && this.W0 == CallingStatus.CONNECTED) {
            try {
                this.a1.J(AudioVoiceSelection.AudioProfile.AUTO);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        com.zenmen.palmchat.videocall.c.c().m();
        unBindMessagingService();
        ImageView imageView = this.B0;
        if (imageView == null || !imageView.isEnabled() || this.P) {
            return;
        }
        if (!this.q) {
            if (this.e0) {
                ny.m(1);
            } else {
                ny.m(0);
            }
        }
        if ((this.e0 || this.W0 == CallingStatus.CONNECTED) && !this.q) {
            AppContext.getContext();
            if (!AppContext.isFloatWindowOpAllowed(this)) {
                r75.o(AppContext.getContext(), k86.a("is_show_float_view"), true);
            } else {
                K3();
                r75.o(AppContext.getContext(), k86.a("is_show_float_view"), false);
            }
        }
    }

    public final void p3(long j2) {
        c3();
        Timer timer = new Timer();
        this.h0 = timer;
        timer.schedule(new m(), j2);
    }

    public final void q3() {
        Timer timer = new Timer();
        this.g0 = timer;
        timer.schedule(new l(), C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    public final void r3() {
        this.u = new y();
    }

    public final void s3() {
        this.I = (WindowManager) getApplicationContext().getSystemService("window");
        this.z = (AudioManager) getSystemService("audio");
        d3(false);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.video_full_screen);
        this.C = frameLayout;
        frameLayout.setOnClickListener(new a());
        this.G = (TextView) findViewById(R.id.twenty_toast_content);
        this.H = (TextView) findViewById(R.id.connection_quality_toast);
        this.s0 = (LinearLayout) findViewById(R.id.video_headimage_area);
        this.t0 = (LinearLayout) findViewById(R.id.audio_headimage_area);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.portrait);
        this.u0 = effectiveShapeView;
        effectiveShapeView.changeShapeType(1);
        this.u0.setDegreeForRoundRectangle(13, 13);
        gr2.j().h(this.X.getIconURL(), this.u0, bq6.s());
        TextView textView = (TextView) findViewById(R.id.name);
        this.v0 = textView;
        textView.setText(this.X.getChatName());
        EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) findViewById(R.id.audio_portrait);
        this.x0 = effectiveShapeView2;
        effectiveShapeView2.changeShapeType(1);
        this.x0.setDegreeForRoundRectangle(13, 13);
        gr2.j().h(this.X.getIconURL(), this.x0, bq6.s());
        this.z0 = (TextView) findViewById(R.id.audio_description);
        TextView textView2 = (TextView) findViewById(R.id.audio_name);
        this.y0 = textView2;
        textView2.setText(this.X.getChatName());
        this.w0 = (TextView) findViewById(R.id.description);
        this.G0 = (TextView) findViewById(R.id.video_call_duration_text);
        ImageView imageView = (ImageView) findViewById(R.id.hangup_btn);
        this.B0 = imageView;
        imageView.setOnClickListener(new b());
        this.C0 = (TextView) findViewById(R.id.hangup_text);
        ImageView imageView2 = (ImageView) findViewById(R.id.accept_btn);
        this.F0 = imageView2;
        imageView2.setOnClickListener(new c());
        this.E0 = (LinearLayout) findViewById(R.id.accept_btn_container);
        this.D0 = findViewById(R.id.view_stub);
        this.N0 = (LinearLayout) findViewById(R.id.silence_area);
        this.O0 = (LinearLayout) findViewById(R.id.handsfree_area);
        this.E = (LinearLayout) findViewById(R.id.switch_audio_bottom_container);
        ImageView imageView3 = (ImageView) findViewById(R.id.switch_audio_bottom_button);
        this.F = imageView3;
        imageView3.setOnClickListener(new d());
        this.H0 = (LinearLayout) findViewById(R.id.switch_audio_container);
        ImageView imageView4 = (ImageView) findViewById(R.id.switch_audio_button);
        this.I0 = imageView4;
        imageView4.setOnClickListener(new e());
        this.J0 = (LinearLayout) findViewById(R.id.right_switch_audio_container);
        ImageView imageView5 = (ImageView) findViewById(R.id.right_switch_audio_button);
        this.K0 = imageView5;
        imageView5.setOnClickListener(new f());
        this.M0 = (TextView) findViewById(R.id.switch_audio_text);
        ImageView imageView6 = (ImageView) findViewById(R.id.silence_btn);
        this.P0 = imageView6;
        imageView6.setAlpha(0.6f);
        this.P0.setImageResource(R.drawable.video_call_silence_pressed);
        this.P0.setEnabled(false);
        this.P0.setOnClickListener(new g());
        ImageView imageView7 = (ImageView) findViewById(R.id.handsfree_btn);
        this.Q0 = imageView7;
        imageView7.setEnabled(false);
        this.Q0.setImageResource(R.drawable.video_call_handfree_disable);
        this.Q0.setOnClickListener(new h());
        this.S0 = (LinearLayout) findViewById(R.id.switch_camera_container);
        ImageView imageView8 = (ImageView) findViewById(R.id.switch_camera_button);
        this.U0 = imageView8;
        imageView8.setOnClickListener(new i());
        this.T0 = (LinearLayout) findViewById(R.id.video_bottom_container);
        ImageView imageView9 = (ImageView) findViewById(R.id.swap_screen_btn);
        this.V0 = imageView9;
        imageView9.setOnClickListener(new j());
        this.n0 = (ImageView) findViewById(R.id.callee_background_image);
        this.o0 = (ImageView) findViewById(R.id.callee_background_blur);
        this.q0 = (FrameLayout) findViewById(R.id.local_view_container);
        this.p0 = (FrameLayout) findViewById(R.id.deep_local_view_container);
        if (this.e0) {
            H3();
            this.s0.setVisibility(8);
            this.t0.setVisibility(0);
            this.V0.setVisibility(0);
            this.H0.setVisibility(8);
            this.J0.setVisibility(8);
            if (this.Y) {
                this.N0.setVisibility(0);
                this.O0.setVisibility(0);
            } else {
                this.N0.setVisibility(8);
                this.O0.setVisibility(8);
            }
        } else {
            this.k0 = (FrameLayout) findViewById(R.id.remote_view_container);
            SurfaceView surfaceView = (SurfaceView) findViewById(R.id.remote_view);
            this.l0 = surfaceView;
            surfaceView.getHolder().addCallback(this);
            this.m0 = (SurfaceView) findViewById(R.id.up_remote_view);
            this.s0.setVisibility(0);
            this.t0.setVisibility(4);
            this.V0.setVisibility(8);
            this.H0.setVisibility(0);
            this.N0.setVisibility(8);
            this.O0.setVisibility(8);
        }
        if (this.Y) {
            this.z0.setText(R.string.video_calling);
            x3(this.z0);
            this.w0.setText(R.string.video_calling);
            x3(this.w0);
            this.C0.setText(R.string.dialog_cancel);
            if (this.e0) {
                this.H0.setVisibility(8);
                this.J0.setVisibility(8);
            } else {
                CameraView cameraView = new CameraView(this);
                this.r0 = cameraView;
                cameraView.setZOrderOnTop(true);
                this.r0.setZOrderMediaOverlay(true);
                this.r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.q0.addView(this.r0);
                this.H0.setVisibility(0);
                this.J0.setVisibility(8);
            }
            this.E0.setVisibility(8);
            this.D0.setVisibility(8);
        } else {
            if (this.e0) {
                this.H0.setVisibility(8);
                this.J0.setVisibility(8);
                this.z0.setText(R.string.invite_audio_call);
                x3(this.z0);
            } else {
                this.H0.setVisibility(8);
                this.J0.setVisibility(0);
            }
            H3();
            I3(CallingStatus.INCOMING);
            this.w0.setText(R.string.invite_video_call);
            x3(this.w0);
            this.C0.setText(R.string.video_call_hangup);
        }
        pa6.p().N(this.X0);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i(b1, "[surfaceCreated]");
        this.l0.setBackgroundColor(-16777216);
        pa6.p().S(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i(b1, "[surfaceDestroyed]");
        pa6.p().H();
    }

    public final void t3(String str) {
        new g13(new o(str)).start();
        if (str == null || !str.contains(getString(R.string.video_call_msg_callee_cancelled))) {
            return;
        }
        ua6.g(this, this.X.getChatId());
    }

    public final void u3(String str) {
        new g13(new p(str)).start();
        if (str == null || !str.contains(getString(R.string.video_call_msg_callee_cancelled))) {
            return;
        }
        ua6.g(this, this.X.getChatId());
    }

    public final boolean v3() {
        Log.i(b1, "mIsHangup_True:" + this.s);
        return this.s;
    }

    public boolean w3() {
        return this.W0 == CallingStatus.CONNECTED;
    }

    public void x3(TextView textView) {
        com.zenmen.palmchat.videocall.jumpingbeans.a.a(textView).a().c();
    }

    public final void y3() {
        this.Y = getIntent().getBooleanExtra("is_caller", false);
        int intExtra = getIntent().getIntExtra("call_type", 0);
        this.f0 = intExtra;
        this.e0 = intExtra == 1;
        r75.o(AppContext.getContext(), k86.a("Is_Audio"), this.e0);
        if (this.e0) {
            pa6.p().L(ZMRtcMediaType.RtcMedia_Audio);
        } else {
            pa6.p().L(ZMRtcMediaType.RtcMedia_Video);
        }
        if (this.Y) {
            this.X = (ChatItem) getIntent().getParcelableExtra("opposite_chat_item");
        } else {
            ContactInfoItem contactInfoItemL = bo0.r().l(getIntent().getStringExtra("caller_uid"));
            this.X = contactInfoItemL;
            if (contactInfoItemL == null) {
                this.X = new ContactInfoItem();
            }
        }
        if (this.X != null) {
            pa6.p().K(this.X.getChatId());
        }
    }

    public final void z3() {
        if (this.A) {
            return;
        }
        try {
            this.a1.I();
            this.a1.J(AudioVoiceSelection.AudioProfile.Audio_only);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.G.setVisibility(8);
        this.X0.sendEmptyMessageDelayed(PushConsts.SET_TAG_RESULT, 10000L);
        this.X0.removeMessages(10002);
        this.X0.removeMessages(10003);
        try {
            if (!this.a1.s() && !this.a1.t()) {
                if (this.f0 == 1) {
                    sy5.d(this, R.string.accept_audio_toast, 0).g();
                } else if (this.Y) {
                    sy5.d(this, R.string.other_side_accept_audio_toast, 0).g();
                } else {
                    sy5.d(this, R.string.self_side_accept_audio_toast, 0).g();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (!this.Y) {
            this.X0.removeMessages(10008);
        }
        this.n0.setVisibility(0);
        this.s0.setVisibility(8);
        this.t0.setVisibility(0);
        this.V0.setVisibility(0);
        this.z0.setText("");
        this.w0.setVisibility(8);
        this.P0.setEnabled(true);
        this.P0.setAlpha(1.0f);
        this.P0.setImageResource(R.drawable.selector_video_call_silence);
        this.G0.setText("00:00");
        this.G0.setVisibility(0);
        this.j0 = System.currentTimeMillis();
        this.X0.sendEmptyMessageDelayed(10001, 1000L);
        this.C0.setText(R.string.video_call_hangup);
        this.H0.setVisibility(8);
        this.J0.setVisibility(8);
        this.S0.setVisibility(8);
        this.E.setVisibility(8);
        this.N0.setVisibility(0);
        this.O0.setVisibility(0);
        try {
            this.a1.u();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15831a;
        public final /* synthetic */ float b;

        public d0(View view, float f) {
            this.f15831a = view;
            this.b = f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            try {
                int left = this.f15831a.getLeft() + ((int) this.b);
                int top = this.f15831a.getTop();
                int width = this.f15831a.getWidth();
                this.f15831a.getHeight();
                this.f15831a.clearAnimation();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15831a.getLayoutParams();
                layoutParams.topMargin = top;
                layoutParams.rightMargin = (VideoCallActivity.this.getWindow().getDecorView().getWidth() - left) - width;
                this.f15831a.setLayoutParams(layoutParams);
                VideoCallActivity.this.R = false;
                VideoCallActivity.this.S = left != 0;
                VideoCallActivity.this.T = top;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }
}
