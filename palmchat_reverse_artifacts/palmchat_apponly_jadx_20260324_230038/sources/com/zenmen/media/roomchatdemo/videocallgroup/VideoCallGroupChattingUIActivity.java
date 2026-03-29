package com.zenmen.media.roomchatdemo.videocallgroup;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.zenmen.media.common.NiceImageView;
import com.zenmen.media.roomchat.AudioVoiceSelection;
import com.zenmen.media.roomchat.NetworkUtil;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.ZMRtcParseRoomInfo;
import com.zenmen.media.roomchat.a;
import com.zenmen.media.roomchat.permission.PermissionRequestActivity;
import com.zenmen.media.roomchatdemo.videocallgroup.AppleAdapter;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupUserAttribute;
import com.zenmen.media.roomchatdemo.videocallgroup.d;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bz4;
import defpackage.cs0;
import defpackage.g13;
import defpackage.gh;
import defpackage.ir2;
import defpackage.ka6;
import defpackage.me1;
import defpackage.na6;
import defpackage.oa6;
import defpackage.rg4;
import defpackage.s55;
import defpackage.t35;
import defpackage.ty5;
import defpackage.w86;
import defpackage.we2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoCallGroupChattingUIActivity extends PermissionRequestActivity implements a.b {
    public static String K0 = "VideoCallGroupChattingUIActivity";
    public static ZMRtcParseRoomInfo M0;
    public static ArrayList<VideoCallGroupUserAttribute> N0;
    public static d.c T0;
    public RecyclerView A0;
    public CustomGridLayoutManager C0;
    public SpaceItemDecoration D0;
    public LinearLayout F;
    public ImageView G;
    public LinearLayout H;
    public ImageView I;
    public LinearLayout J;
    public ImageView K;
    public TextView L;
    public LinearLayout N;
    public ImageView O;
    public TextView P;
    public ImageView R;
    public LinearLayout S;
    public ImageView T;
    public TextView U;
    public LinearLayout W;
    public ImageView X;
    public ImageView Y;
    public TextView Z;
    public TextView e0;
    public RecyclerView w0;
    public CustomGridLayoutManager y0;
    public SpaceItemDecoration z0;
    public static RTCParameters.MY_NAME L0 = RTCParameters.MY_NAME.I_AM_NONE;
    public static VideoCallGroupChattingUIActivity O0 = null;
    public static long P0 = -1;
    public static int Q0 = 3;
    public static int R0 = 3;
    public static int S0 = 3 * 3;
    public boolean w = false;
    public long x = 0;
    public boolean y = false;
    public boolean z = false;
    public int A = 0;
    public int B = 0;
    public int C = 0;
    public AudioVoiceSelection E = null;
    public boolean M = false;
    public boolean Q = false;
    public boolean V = true;
    public long f0 = 0;
    public LinearLayout g0 = null;
    public TextView h0 = null;
    public TextView i0 = null;
    public int j0 = 2;
    public int k0 = 2;
    public FrameLayout l0 = null;
    public List<VideoCallGroupUserAttribute> m0 = null;
    public boolean n0 = false;
    public boolean o0 = false;
    public boolean p0 = false;
    public boolean q0 = false;
    public boolean r0 = false;
    public boolean s0 = false;
    public boolean t0 = false;
    public boolean u0 = false;
    public ka6 v0 = null;
    public AppleAdapter x0 = null;
    public AppleAdapter B0 = null;
    public boolean E0 = false;
    public boolean F0 = false;
    public Handler G0 = new q();
    public ContentObserver H0 = new g(null);
    public List<gh> I0 = new ArrayList();
    public boolean J0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallGroupChattingUIActivity.this.P2(23, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends g13 {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!VideoCallGroupChattingUIActivity.this.y) {
                try {
                    Thread.sleep(6000L);
                } catch (Exception unused) {
                }
                VideoCallGroupChattingUIActivity.this.P2(2, 0);
                VideoCallGroupChattingUIActivity.this.f3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewTreeObserver.OnDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            LinearLayout linearLayout = (LinearLayout) VideoCallGroupChattingUIActivity.this.findViewById(R.id.group_chatting_head_scroll_layout);
            int bottom = VideoCallGroupChattingUIActivity.this.W.getBottom();
            boolean z = false;
            if (VideoCallGroupChattingUIActivity.this.H2()) {
                bottom = 0;
            }
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity = VideoCallGroupChattingUIActivity.this;
            if (!videoCallGroupChattingUIActivity.z && VideoCallGroupChattingUIActivity.L0 == RTCParameters.MY_NAME.I_AM_BOB) {
                z = true;
            }
            if (z) {
                bottom = videoCallGroupChattingUIActivity.l0.getBottom();
            }
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity2 = VideoCallGroupChattingUIActivity.this;
            videoCallGroupChattingUIActivity2.S2(-1, 0, bottom, videoCallGroupChattingUIActivity2.u2(), VideoCallGroupChattingUIActivity.this.u2(), linearLayout);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity = VideoCallGroupChattingUIActivity.this;
                if (videoCallGroupChattingUIActivity.w0 == null) {
                    videoCallGroupChattingUIActivity.w0 = (RecyclerView) videoCallGroupChattingUIActivity.findViewById(R.id.group_chatting_item_control_container);
                    VideoCallGroupChattingUIActivity.this.w0.getItemAnimator().setAddDuration(0L);
                    VideoCallGroupChattingUIActivity.this.w0.getItemAnimator().setChangeDuration(0L);
                    VideoCallGroupChattingUIActivity.this.w0.getItemAnimator().setMoveDuration(0L);
                    VideoCallGroupChattingUIActivity.this.w0.getItemAnimator().setRemoveDuration(0L);
                    ((SimpleItemAnimator) VideoCallGroupChattingUIActivity.this.w0.getItemAnimator()).setSupportsChangeAnimations(false);
                    VideoCallGroupChattingUIActivity.this.w0.setItemAnimator(null);
                }
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity2 = VideoCallGroupChattingUIActivity.this;
                if (videoCallGroupChattingUIActivity2.A0 == null) {
                    videoCallGroupChattingUIActivity2.A0 = (RecyclerView) videoCallGroupChattingUIActivity2.findViewById(R.id.group_chatting_recyclerview_bob);
                    VideoCallGroupChattingUIActivity.this.A0.getItemAnimator().setAddDuration(0L);
                    VideoCallGroupChattingUIActivity.this.A0.getItemAnimator().setChangeDuration(0L);
                    VideoCallGroupChattingUIActivity.this.A0.getItemAnimator().setMoveDuration(0L);
                    VideoCallGroupChattingUIActivity.this.A0.getItemAnimator().setRemoveDuration(0L);
                    ((SimpleItemAnimator) VideoCallGroupChattingUIActivity.this.A0.getItemAnimator()).setSupportsChangeAnimations(false);
                }
            } catch (Exception unused) {
            }
            synchronized (VideoCallGroupChattingUIActivity.this.w0) {
                if (VideoCallGroupChattingUIActivity.L0 == RTCParameters.MY_NAME.I_AM_ALICE || VideoCallGroupChattingUIActivity.L0 == RTCParameters.MY_NAME.I_AM_CHARLIE) {
                    VideoCallGroupChattingUIActivity.this.g3();
                } else {
                    VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity3 = VideoCallGroupChattingUIActivity.this;
                    if (videoCallGroupChattingUIActivity3.z) {
                        videoCallGroupChattingUIActivity3.g3();
                    } else {
                        videoCallGroupChattingUIActivity3.h3();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCallGroupUserAttribute f11986a;

        public e(VideoCallGroupUserAttribute videoCallGroupUserAttribute) {
            this.f11986a = videoCallGroupUserAttribute;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (VideoCallGroupChattingUIActivity.this.w0) {
                FrameLayout frameLayout = VideoCallGroupChattingUIActivity.this.l0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                VideoCallGroupChattingUIActivity.this.g0.setVisibility(8);
                VideoCallGroupChattingUIActivity.this.I0.size();
                VideoCallGroupChattingUIActivity.this.I0.clear();
                VideoCallGroupUserAttribute videoCallGroupUserAttribute = this.f11986a;
                VideoCallGroupChattingUIActivity.this.I0.add(new gh(videoCallGroupUserAttribute.userName, videoCallGroupUserAttribute.iconUrl, videoCallGroupUserAttribute));
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity = VideoCallGroupChattingUIActivity.this;
                if (videoCallGroupChattingUIActivity.y0 == null) {
                    videoCallGroupChattingUIActivity.y0 = new CustomGridLayoutManager(VideoCallGroupChattingUIActivity.O0, 1);
                    VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity2 = VideoCallGroupChattingUIActivity.this;
                    videoCallGroupChattingUIActivity2.w0.setLayoutManager(videoCallGroupChattingUIActivity2.y0);
                }
                if (VideoCallGroupChattingUIActivity.this.y0.getSpanCount() != 1) {
                    VideoCallGroupChattingUIActivity.this.y0.setSpanCount(1);
                }
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity3 = VideoCallGroupChattingUIActivity.this;
                if (videoCallGroupChattingUIActivity3.x0 == null) {
                    videoCallGroupChattingUIActivity3.x0 = new AppleAdapter(VideoCallGroupChattingUIActivity.this.I0, VideoCallGroupChattingUIActivity.this.y0);
                    VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity4 = VideoCallGroupChattingUIActivity.this;
                    videoCallGroupChattingUIActivity4.w0.setAdapter(videoCallGroupChattingUIActivity4.x0);
                }
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity5 = VideoCallGroupChattingUIActivity.this;
                SpaceItemDecoration spaceItemDecoration = videoCallGroupChattingUIActivity5.z0;
                if (spaceItemDecoration != null) {
                    videoCallGroupChattingUIActivity5.w0.removeItemDecoration(spaceItemDecoration);
                }
                VideoCallGroupChattingUIActivity.this.z0 = new SpaceItemDecoration(0);
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity6 = VideoCallGroupChattingUIActivity.this;
                videoCallGroupChattingUIActivity6.w0.addItemDecoration(videoCallGroupChattingUIActivity6.z0);
                VideoCallGroupChattingUIActivity.this.x0.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCallGroupChattingUIActivity.this.I0.remove(0);
            VideoCallGroupChattingUIActivity.this.x0.notifyDataSetChanged();
            VideoCallGroupChattingUIActivity.this.f3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends ContentObserver {
        public g(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            VideoCallGroupChattingUIActivity.this.G0.sendEmptyMessage(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallGroupChattingUIActivity.this.j2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallGroupChattingUIActivity.this.n2(R.string.manychats_video_call_group_finish_call);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements ViewTreeObserver.OnPreDrawListener {
        public o() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            LinearLayout linearLayout = (LinearLayout) VideoCallGroupChattingUIActivity.this.findViewById(R.id.group_chatting_head_scroll_layout);
            if (VideoCallGroupChattingUIActivity.this.H2()) {
                VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity = VideoCallGroupChattingUIActivity.this;
                videoCallGroupChattingUIActivity.S2(-1, 0, 0, videoCallGroupChattingUIActivity.u2(), VideoCallGroupChattingUIActivity.this.u2(), linearLayout);
                return true;
            }
            int bottom = VideoCallGroupChattingUIActivity.this.W.getBottom();
            VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity2 = VideoCallGroupChattingUIActivity.this;
            videoCallGroupChattingUIActivity2.S2(-1, 0, bottom, videoCallGroupChattingUIActivity2.u2(), VideoCallGroupChattingUIActivity.this.u2(), linearLayout);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallGroupChattingUIActivity.this.o2();
            VideoCallGroupChattingUIActivity.this.o0 = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        VideoCallGroupChattingUIActivity.this.y2();
                        break;
                    case 1:
                        VideoCallGroupChattingUIActivity.this.f3();
                        break;
                    case 2:
                        VideoCallGroupChattingUIActivity.this.Z.setText(Long.toString(VideoCallGroupChattingUIActivity.x2()));
                        break;
                    case 3:
                        VideoCallGroupChattingUIActivity.this.e0.setText(RTCParameters.f().c());
                        break;
                    case 4:
                        we2.c(VideoCallGroupChattingUIActivity.this.f0, RTCParameters.l());
                        break;
                    case 5:
                        VideoCallGroupChattingUIActivity.this.b3();
                        break;
                    case 6:
                        if (!VideoCallGroupChattingUIActivity.this.r0) {
                            VideoCallGroupChattingUIActivity.this.y2();
                        }
                        VideoCallGroupChattingUIActivity videoCallGroupChattingUIActivity = VideoCallGroupChattingUIActivity.this;
                        videoCallGroupChattingUIActivity.z = true;
                        videoCallGroupChattingUIActivity.j2();
                        VideoCallGroupChattingUIActivity.this.i0.setVisibility(4);
                        break;
                    case 7:
                        TextView textView = (TextView) VideoCallGroupChattingUIActivity.this.findViewById(R.id.manychats_globle_toast);
                        if (message.arg1 != 1) {
                            textView.setVisibility(4);
                        } else {
                            textView.setText(R.string.manychats_video_net_warning);
                            textView.setVisibility(0);
                            VideoCallGroupChattingUIActivity.this.E.s();
                        }
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.handleMessage(message);
        }

        public q() {
        }
    }

    public static void Q2(ArrayList<VideoCallGroupUserAttribute> arrayList) {
        N0 = arrayList;
    }

    public static void R2(d.c cVar) {
        T0 = cVar;
    }

    public static void U2(RTCParameters.MY_NAME my_name) {
        L0 = my_name;
    }

    public static void V2(ZMRtcParseRoomInfo zMRtcParseRoomInfo) {
        M0 = zMRtcParseRoomInfo;
    }

    public static void W2(long j2) {
        P0 = j2;
        if (j2 == -1 || w2() == null) {
            return;
        }
        w2().G0.sendEmptyMessage(2);
    }

    public static VideoCallGroupChattingUIActivity w2() {
        return O0;
    }

    public static long x2() {
        return P0;
    }

    public final void A2() {
        this.I0.clear();
        for (int i2 = 0; i2 < com.zenmen.media.roomchatdemo.videocallgroup.b.e().g(); i2++) {
            VideoCallGroupUserAttribute videoCallGroupUserAttributeB = com.zenmen.media.roomchatdemo.videocallgroup.b.e().b(i2);
            try {
                if (videoCallGroupUserAttributeB.usertype != VideoCallGroupUserAttribute.b.idle) {
                    VideoCallGroupUserAttribute videoCallGroupUserAttribute = (VideoCallGroupUserAttribute) videoCallGroupUserAttributeB.clone();
                    boolean z = this.z;
                    videoCallGroupUserAttribute.meetingStart = z;
                    VideoCallGroupUserAttribute.b bVar = videoCallGroupUserAttribute.usertype;
                    boolean z2 = true;
                    if (bVar == VideoCallGroupUserAttribute.b.myself) {
                        videoCallGroupUserAttribute.cameraon = this.Q ? 1 : 0;
                    }
                    if (z || L0 != RTCParameters.MY_NAME.I_AM_BOB) {
                        z2 = false;
                    }
                    if (!z2 || bVar != VideoCallGroupUserAttribute.b.myinviter) {
                        this.I0.add(new gh(videoCallGroupUserAttribute.userName, videoCallGroupUserAttribute.iconUrl, videoCallGroupUserAttribute));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void B2() {
        RTCParameters.MY_NAME my_name = L0;
        RTCParameters.MY_NAME my_name2 = RTCParameters.MY_NAME.I_AM_ALICE;
        boolean z = my_name == my_name2;
        if (this.E == null) {
            this.E = new AudioVoiceSelection();
        }
        this.E.m(this, z, this.T);
        if (L0 == my_name2) {
            this.E.x(AudioVoiceSelection.VoiceRouterType.RECEIVER);
        }
        this.E.B(AudioVoiceSelection.AudioProfile.AUTO);
        if (L0 != RTCParameters.MY_NAME.I_AM_CHARLIE) {
            this.E.t();
        }
        this.E.u();
    }

    public final void C2() {
        if (!this.z) {
            this.S.setVisibility(4);
            this.J.setVisibility(4);
            this.N.setVisibility(4);
            this.e0.setVisibility(4);
            return;
        }
        this.F.setVisibility(8);
        this.H.setVisibility(0);
        this.S.setVisibility(0);
        this.J.setVisibility(0);
        this.N.setVisibility(0);
        this.e0.setVisibility(0);
        this.W.setVisibility(0);
        this.X.setVisibility(0);
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void D1() {
        q2(true);
    }

    public final void D2() {
        if (L0 == RTCParameters.MY_NAME.I_AM_CHARLIE) {
            this.F.setVisibility(8);
            this.H.setVisibility(0);
            this.S.setVisibility(0);
            this.J.setVisibility(0);
            this.N.setVisibility(0);
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void E1() {
        super.E1();
    }

    public final void E2() {
        int iU2 = u2() / Q0;
        this.C = iU2;
        this.B = iU2;
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.group_chatting_item_control_container_bob);
        this.l0 = frameLayout;
        frameLayout.getViewTreeObserver().addOnDrawListener(new c());
        if (RTCParameters.k.l) {
            ((FrameLayout) findViewById(R.id.group_chatting_head_layout)).setBackgroundColor(-16776961);
            ((LinearLayout) findViewById(R.id.group_chatting_head_scroll_layout)).setBackgroundColor(-7829368);
            this.l0.setBackgroundColor(Color.rgb(100, 150, 100));
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void F1() {
        P2(15, 0);
    }

    public final void F2() {
        this.F = (LinearLayout) findViewById(R.id.group_chatting_accept_btn_container);
        ImageView imageView = (ImageView) findViewById(R.id.group_chatting_accept_btn);
        this.G = imageView;
        imageView.setOnClickListener(new i());
        this.H = (LinearLayout) findViewById(R.id.group_chatting_hangup_btn_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.group_chatting_hangup_btn);
        this.I = imageView2;
        imageView2.setOnClickListener(new j());
        this.J = (LinearLayout) findViewById(R.id.group_chatting_mute_btn_container);
        this.K = (ImageView) findViewById(R.id.group_chatting_mute_btn);
        TextView textView = (TextView) findViewById(R.id.group_chatting_mute_text);
        this.L = textView;
        textView.setText(R.string.manychats_voice_unmute);
        this.K.setImageResource(R.drawable.ic_voip_voice_ban_normal_3x);
        this.K.setOnClickListener(new k());
        this.N = (LinearLayout) findViewById(R.id.group_chatting_open_camera_btn_container);
        this.O = (ImageView) findViewById(R.id.group_chatting_open_camera_btn);
        TextView textView2 = (TextView) findViewById(R.id.group_chatting_open_camera_text);
        this.P = textView2;
        textView2.setText(R.string.manychats_video_unopen);
        this.O.setImageResource(R.drawable.ic_voip_video_tape_normal_3x);
        if (RTCParameters.k.i) {
            this.O.setEnabled(true);
            this.O.setOnClickListener(new l());
        } else {
            this.O.setEnabled(false);
            this.O.setColorFilter(Color.parseColor("#55ffffff"), PorterDuff.Mode.MULTIPLY);
            this.P.setTextColor(Color.parseColor("#55ffffff"));
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.group_chatting_camera_swap);
        this.R = imageView3;
        imageView3.setOnClickListener(new m());
        this.S = (LinearLayout) findViewById(R.id.group_chatting_handsfree_btn_container);
        this.T = (ImageView) findViewById(R.id.group_chatting_handsfree_btn);
        this.U = (TextView) findViewById(R.id.group_chatting_handsfree_text);
        this.T.setImageResource(R.drawable.manychats_video_call_handfree_on);
        this.T.setOnClickListener(new n());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.group_chatting_invite_btn_container);
        this.W = linearLayout;
        linearLayout.getViewTreeObserver().addOnPreDrawListener(new o());
        ImageView imageView4 = (ImageView) findViewById(R.id.group_chatting_invite_btn);
        this.X = imageView4;
        imageView4.setOnClickListener(new p());
        ImageView imageView5 = (ImageView) findViewById(R.id.manychats_small_screen);
        this.Y = imageView5;
        imageView5.setOnClickListener(new a());
        TextView textView3 = (TextView) findViewById(R.id.manychats_meeting_no);
        this.Z = textView3;
        if (!RTCParameters.k.d) {
            textView3.setVisibility(4);
        }
        TextView textView4 = (TextView) findViewById(R.id.group_chatting_duration_text);
        this.e0 = textView4;
        textView4.setSaveEnabled(false);
        TextView textView5 = (TextView) findViewById(R.id.group_chatting_join_ing);
        this.i0 = textView5;
        textView5.setVisibility(4);
        if (L0 == RTCParameters.MY_NAME.I_AM_BOB) {
            this.T.setImageResource(R.drawable.manychats_video_call_handfree_on);
            this.O.setImageResource(R.drawable.ic_voip_video_tape_normal_3x);
            this.K.setImageResource(R.drawable.ic_voip_voice_ban_normal_3x);
            this.K.setEnabled(false);
            this.O.setEnabled(false);
            this.X.setVisibility(4);
            this.W.setVisibility(0);
            this.J.setVisibility(4);
            this.S.setVisibility(4);
            this.N.setVisibility(4);
        } else if (L0 == RTCParameters.MY_NAME.I_AM_ALICE) {
            this.F.setVisibility(8);
        } else if (L0 == RTCParameters.MY_NAME.I_AM_CHARLIE) {
            this.F.setVisibility(8);
            this.e0.setText(getResources().getString(R.string.manychats_waiting_join_room));
            this.i0.setVisibility(0);
        }
        this.g0 = (LinearLayout) findViewById(R.id.group_chatting_invite_describe_container);
        this.h0 = (TextView) findViewById(R.id.group_chatting_invite_describe_name);
        this.g0.setVisibility(8);
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void G1() {
        P2(21, 0);
    }

    public final void G2() {
        T0 = com.zenmen.media.roomchatdemo.videocallgroup.d.P().N();
    }

    public final boolean H2() {
        return ((double) ((float) ((((double) u2()) * 1.0d) / ((double) t2())))) > 0.59d;
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void I() {
        super.I();
    }

    public boolean I2() {
        return this.z;
    }

    public void J2(VideoCallGroupUserAttribute videoCallGroupUserAttribute) {
        Log.i(K0, "normalVideoViewClick");
        if (this.n0) {
            this.n0 = false;
            runOnUiThread(new f());
        } else {
            this.n0 = true;
            e3(videoCallGroupUserAttribute);
        }
    }

    public void K2() {
        this.I.callOnClick();
    }

    public void L2(int i2) {
        synchronized (this.w0) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.I0.size()) {
                    break;
                }
                if (this.I0.get(i3).a().ctrlId == i2) {
                    this.I0.get(i3).a().firstframe = true;
                    this.x0.notifyItemChanged(i3, AppleAdapter.PayloadsTypes.firstframe);
                    bz4.a(K0, "onFirstFrame notifyItemChanged:" + i3);
                    break;
                }
                i3++;
            }
        }
    }

    public void M2() {
        this.G0.sendEmptyMessage(6);
    }

    public final void N2() {
        ArrayList<VideoCallGroupUserAttribute> arrayList = N0;
        if (arrayList != null) {
            if (arrayList != null) {
                com.zenmen.media.roomchatdemo.videocallgroup.b.e().l(arrayList);
            }
            this.m0 = com.zenmen.media.roomchatdemo.videocallgroup.b.e().c();
        }
        k3(M0);
        N0 = null;
        M0 = null;
    }

    public final void O2() {
        getContentResolver().registerContentObserver(we2.e, false, this.H0);
    }

    public final void P2(int i2, int i3) {
        Message message = new Message();
        message.what = i2;
        if (i2 == 15) {
            message.arg1 = (this.o0 || this.t0) ? 0 : 1;
        } else if (i2 == 20 || i2 == 21) {
            message.arg1 = L0.ordinal();
        }
        T0.sendMessageDelayed(message, i3);
    }

    public final void S2(int i2, int i3, int i4, int i5, int i6, View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.height = i6;
        layoutParams.width = i5;
        view.setLayoutParams(layoutParams);
        view.setVisibility(0);
        view.postInvalidate();
    }

    public final void T2(boolean z) {
        f3();
    }

    public void X2(boolean z) {
        Message message = new Message();
        message.what = 7;
        message.arg1 = z ? 1 : 0;
        this.G0.sendMessage(message);
    }

    public final void Y2() {
        try {
            Intent intent = new Intent(this, (Class<?>) VideoCallGroupService.class);
            intent.setAction("group_action_foreground");
            synchronized (this) {
                if (Build.VERSION.SDK_INT >= 26) {
                    startForegroundService(intent);
                } else {
                    startService(intent);
                }
                this.q0 = true;
            }
        } catch (SecurityException unused) {
            Log.i(K0, "Failed to start forground service because of SecurityException.");
        }
    }

    public void Z2() {
        AudioVoiceSelection audioVoiceSelection = this.E;
        if (audioVoiceSelection != null) {
            audioVoiceSelection.A();
        }
    }

    public final void a3() {
        synchronized (this) {
            if (this.q0) {
                stopService(new Intent(this, (Class<?>) VideoCallGroupService.class));
                this.q0 = false;
            }
        }
    }

    public final void b3() {
        boolean z;
        Log.i(K0, "stopping +");
        this.e0.setText(getResources().getString(R.string.manychats_video_call_group_finish_call));
        h2();
        if (!this.E0) {
            RTCParameters.MY_NAME my_name = L0;
            RTCParameters.MY_NAME my_name2 = RTCParameters.MY_NAME.I_AM_ALICE;
            if (my_name == my_name2 || (z = this.z)) {
                if (L0 != my_name2) {
                    na6.o(RTCParameters.l(), this.f0, P0, RTCParameters.f().b());
                } else if (this.A <= 2) {
                    na6.b(RTCParameters.l(), this.f0, P0, RTCParameters.f().a());
                }
                if (!this.u0) {
                    com.zenmen.media.roomchatdemo.videocallgroup.d.P().C(P0, this.f0);
                }
            } else {
                RTCParameters.MY_NAME my_name3 = L0;
                RTCParameters.MY_NAME my_name4 = RTCParameters.MY_NAME.I_AM_BOB;
                if ((my_name3 == my_name4 || L0 == RTCParameters.MY_NAME.I_AM_CHARLIE) && !z) {
                    if (L0 == my_name4) {
                        na6.h(RTCParameters.l(), this.f0, P0);
                    }
                    if (!this.u0) {
                        com.zenmen.media.roomchatdemo.videocallgroup.d.P().F(P0);
                    }
                }
            }
        }
        setResult(-1, getIntent());
        finish();
        Log.i(K0, "stopping -");
    }

    public final void c3() {
        try {
            AudioVoiceSelection audioVoiceSelection = this.E;
            if (audioVoiceSelection != null) {
                audioVoiceSelection.x(AudioVoiceSelection.VoiceRouterType.SPEAKER);
                this.E.B(AudioVoiceSelection.AudioProfile.AUTO);
                this.E.A();
                this.E.r();
                AudioVoiceSelection audioVoiceSelection2 = this.E;
                if (audioVoiceSelection2 != null) {
                    audioVoiceSelection2.v();
                }
                AudioVoiceSelection audioVoiceSelection3 = this.E;
                if (audioVoiceSelection3 != null) {
                    audioVoiceSelection3.E();
                    this.E = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d3() {
        getContentResolver().unregisterContentObserver(this.H0);
    }

    public final void e2() {
        new b().start();
    }

    public final void e3(VideoCallGroupUserAttribute videoCallGroupUserAttribute) {
        runOnUiThread(new e(videoCallGroupUserAttribute));
    }

    public final void f2() {
        if (Build.VERSION.SDK_INT >= 26) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    public void f3() {
        if (this.n0) {
            return;
        }
        LogUtil.i(K0, "updateHeadOrder: from " + new Exception().getStackTrace()[1].getMethodName());
        runOnUiThread(new d());
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        try {
            Log.i(K0, "call finish isFinishing+" + isFinishing());
            a3();
            if (this.s0) {
                return;
            }
            this.s0 = true;
            Log.i(K0, "call finish +");
            getLoaderManager().destroyLoader(we2.d);
            d3();
            h2();
            com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_CALL_FINISH"));
            com.zenmen.media.roomchatdemo.videocallgroup.d.P().x();
            if (s55.c(this) != null) {
                s55.c(this).a();
                s55.c(this).b();
            }
            this.r0 = false;
            P2(17, 0);
            com.zenmen.media.roomchat.a.f(this);
            t35.a().c();
            P0 = -1L;
            try {
                if (this.x0 != null) {
                    this.w0.setItemViewCacheSize(0);
                    for (int i2 = 0; i2 < this.I0.size(); i2++) {
                        this.I0.get(i2).a().bstopped = true;
                        this.x0.notifyItemChanged(i2, AppleAdapter.PayloadsTypes.stopped);
                    }
                }
                if (this.B0 != null) {
                    while (true) {
                        List<gh> list = this.I0;
                        if (list == null || list.size() < 1) {
                            break;
                        }
                        this.I0.remove(0);
                        this.B0.notifyItemRemoved(0);
                        this.B0.notifyItemRangeChanged(0, this.I0.size());
                    }
                    this.B0.notifyDataSetChanged();
                    this.B0 = null;
                    this.A0.setAdapter(null);
                    this.A0 = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                bz4.a(K0, "RecyclerView release fail.");
            }
        } catch (Exception unused) {
        }
        finishAndRemoveTask();
        super.finish();
        f2();
        Log.i(K0, "call finish - ");
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void g1() {
        P2(21, 0);
    }

    public final void g2(int i2) {
        if (i2 <= 1) {
            P2(6, 2000);
        }
    }

    public final void g3() {
        try {
            FrameLayout frameLayout = this.l0;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            this.g0.setVisibility(8);
            this.A0.setVisibility(8);
            this.w0.setVisibility(0);
            ((ImageView) findViewById(R.id.group_chatting_bob_calling_alice)).setVisibility(8);
            int size = this.I0.size();
            A2();
            int i2 = this.I0.size() <= 4 ? 2 : 3;
            if (this.y0 == null) {
                CustomGridLayoutManager customGridLayoutManager = new CustomGridLayoutManager(O0, i2);
                this.y0 = customGridLayoutManager;
                this.w0.setLayoutManager(customGridLayoutManager);
            }
            if (this.y0.getSpanCount() != i2) {
                this.y0.setSpanCount(i2);
            }
            if (this.x0 == null) {
                AppleAdapter appleAdapter = new AppleAdapter(this.I0, this.y0);
                this.x0 = appleAdapter;
                this.w0.setAdapter(appleAdapter);
            }
            this.x0.h(this.I0);
            int i3 = getResources().getDisplayMetrics().widthPixels;
            int i4 = i3 / i2;
            int size2 = this.I0.size() % i2;
            int i5 = size2 == 0 ? 0 : (i3 - (i4 * size2)) / 2;
            SpaceItemDecoration spaceItemDecoration = this.z0;
            if (spaceItemDecoration != null) {
                this.w0.removeItemDecoration(spaceItemDecoration);
            }
            SpaceItemDecoration spaceItemDecoration2 = new SpaceItemDecoration(i5);
            this.z0 = spaceItemDecoration2;
            this.w0.addItemDecoration(spaceItemDecoration2);
            LogUtil.i(K0, "old:" + size + " new:" + this.I0.size());
            if (size <= this.I0.size()) {
                this.x0.notifyItemRangeChanged(0, size);
                this.x0.notifyItemRangeInserted(size - 1, this.I0.size() - size);
            } else {
                this.x0.notifyItemRangeRemoved(this.I0.size() - 1, size - this.I0.size());
                this.x0.notifyItemRangeChanged(0, this.I0.size());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 123;
    }

    public void h2() {
        Log.i(K0, "close +");
        this.y = true;
        c3();
        ka6 ka6Var = this.v0;
        if (ka6Var != null) {
            ka6Var.m();
        }
        this.v0 = null;
        synchronized (this) {
            O0 = null;
        }
        Log.i(K0, "close -");
    }

    public final void h3() {
        try {
            i3();
            this.w0.setVisibility(8);
            this.A0.setVisibility(0);
            int size = this.I0.size();
            A2();
            if (this.C0 == null) {
                CustomGridLayoutManager customGridLayoutManager = new CustomGridLayoutManager(O0, 6);
                this.C0 = customGridLayoutManager;
                this.A0.setLayoutManager(customGridLayoutManager);
            }
            if (this.C0.getSpanCount() != 6) {
                this.C0.setSpanCount(6);
            }
            if (this.B0 == null) {
                AppleAdapter appleAdapter = new AppleAdapter(this.I0, this.C0);
                this.B0 = appleAdapter;
                this.A0.setAdapter(appleAdapter);
            }
            int width = this.A0.getWidth();
            int i2 = width / 6;
            int size2 = this.I0.size() % 6;
            int i3 = size2 == 0 ? 0 : (width - (i2 * size2)) / 2;
            SpaceItemDecoration spaceItemDecoration = this.D0;
            if (spaceItemDecoration != null) {
                this.A0.removeItemDecoration(spaceItemDecoration);
            }
            SpaceItemDecoration spaceItemDecoration2 = new SpaceItemDecoration(i3);
            this.D0 = spaceItemDecoration2;
            this.A0.addItemDecoration(spaceItemDecoration2);
            if (size <= this.I0.size()) {
                this.B0.notifyItemRangeChanged(0, size);
                this.B0.notifyItemRangeInserted(size - 1, this.I0.size() - size);
            } else {
                this.B0.notifyItemRangeRemoved(this.I0.size() - 1, size - this.I0.size());
                this.B0.notifyItemRangeChanged(0, this.I0.size());
            }
        } catch (Exception unused) {
        }
    }

    public final void i2() {
        if (this.J0) {
            return;
        }
        this.J0 = true;
        finish();
    }

    public final void i3() {
        try {
            NiceImageView niceImageView = (NiceImageView) findViewById(R.id.group_chatting_bob_calling_alice);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(niceImageView.getLayoutParams());
            int iU2 = u2() / 2;
            layoutParams.width = iU2;
            layoutParams.height = iU2;
            layoutParams.gravity = 1;
            layoutParams.topMargin = w86.a(this, 50.0f);
            niceImageView.setLayoutParams(layoutParams);
            niceImageView.setCornerBottomLeftRadius(2);
            niceImageView.setCornerBottomRightRadius(2);
            niceImageView.setCornerTopLeftRadius(2);
            niceImageView.setCornerTopRightRadius(2);
            ir2.a(this, niceImageView, 0, com.zenmen.media.roomchatdemo.videocallgroup.b.e().f().iconUrl);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g0.getLayoutParams();
            marginLayoutParams.topMargin = layoutParams.height + layoutParams.topMargin;
            this.g0.setLayoutParams(marginLayoutParams);
            this.g0.setVisibility(0);
            this.h0.setText(String.valueOf(com.zenmen.media.roomchatdemo.videocallgroup.b.e().f().userName));
        } catch (Exception unused) {
        }
    }

    public final void j2() {
        this.z = true;
        this.F.setVisibility(8);
        AudioVoiceSelection audioVoiceSelection = this.E;
        if (audioVoiceSelection != null) {
            audioVoiceSelection.A();
            this.E.q();
        }
        P2(25, 0);
        T2(this.z);
        this.p0 = true;
        this.O.setImageResource(R.drawable.ic_voip_video_tape_normal_3x);
        this.K.setImageResource(R.drawable.ic_voip_voice_ban_normal_3x);
        this.K.setEnabled(true);
        if (RTCParameters.k.i) {
            this.O.setEnabled(true);
        }
        if (L0 == RTCParameters.MY_NAME.I_AM_BOB) {
            com.zenmen.media.roomchatdemo.videocallgroup.d.P().A(P0);
            na6.d(RTCParameters.l(), this.f0, P0);
        }
        j3();
        if (L0 != RTCParameters.MY_NAME.I_AM_CHARLIE) {
            f3();
        }
        oa6.k(0);
    }

    public void j3() {
        if (L0 == RTCParameters.MY_NAME.I_AM_ALICE) {
            z2();
        } else {
            C2();
        }
        D2();
    }

    @Override // com.zenmen.media.roomchat.a.b
    public void k0(Intent intent) {
        if (intent.getAction().equals("INTENT_ACTION_UPDATE_CALLING_DURATION")) {
            this.G0.sendEmptyMessage(3);
        }
    }

    public final void k2() {
        ka6 ka6Var = this.v0;
        if (ka6Var != null) {
            ka6Var.o();
        }
    }

    public void k3(ZMRtcParseRoomInfo zMRtcParseRoomInfo) {
        if (zMRtcParseRoomInfo != null) {
            W2(zMRtcParseRoomInfo.mRoomid);
            com.zenmen.media.roomchatdemo.videocallgroup.b.e().k(zMRtcParseRoomInfo);
            this.A = com.zenmen.media.roomchatdemo.videocallgroup.b.e().d();
            this.m0 = com.zenmen.media.roomchatdemo.videocallgroup.b.e().c();
            if (this.A >= 2 && !this.p0 && L0 == RTCParameters.MY_NAME.I_AM_ALICE) {
                P2(25, 0);
                if (this.V) {
                    l2();
                }
                this.p0 = true;
            }
            g2(com.zenmen.media.roomchatdemo.videocallgroup.b.e().i());
            f3();
            com.zenmen.media.roomchat.a.e(new Intent("INTENT_ACTION_USER_LIST_FOR_SELECTION_UPDATE"));
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void l() {
        q2(false);
        Toast.makeText(this, R.string.manychats_video_call_group_camera_permission_no_granted, 0).show();
    }

    public final void l2() {
        boolean z = !this.V;
        this.V = z;
        if (z) {
            this.U.setText(R.string.manychats_voice_hands_off_open);
        } else {
            this.U.setText(R.string.manychats_voice_hands_off_close);
        }
        if (this.E == null || !this.T.isEnabled()) {
            return;
        }
        this.E.D(!r0.n());
    }

    public void l3(long j2, boolean z) {
        if (this.p0) {
            synchronized (this.w0) {
                for (int i2 = 0; i2 < this.I0.size(); i2++) {
                    VideoCallGroupUserAttribute videoCallGroupUserAttributeA = this.I0.get(i2).a();
                    if (videoCallGroupUserAttributeA.userCId != j2 && (j2 != 99999 || videoCallGroupUserAttributeA.usertype != VideoCallGroupUserAttribute.b.myself)) {
                    }
                    videoCallGroupUserAttributeA.voiceDec = z;
                    this.x0.notifyItemChanged(i2, AppleAdapter.PayloadsTypes.voicedected);
                }
            }
        }
    }

    public void m2(int i2) {
        if (this.t0) {
            return;
        }
        Log.i(K0, getResources().getString(R.string.manychats_call_end));
        Log.i(K0, "Hangup Reason:" + getResources().getString(i2));
        if (RTCParameters.k.b && !getResources().getString(i2).isEmpty()) {
            ty5.b(this, i2, 1).show();
        }
        this.t0 = true;
        q2(false);
        b3();
    }

    public void n2(int i2) {
        if (this.t0) {
            return;
        }
        Log.i(K0, getResources().getString(R.string.manychats_call_end) + "+");
        Log.i(K0, "Hangup Reason:" + getResources().getString(i2));
        if (getResources().getString(i2).equals(getResources().getString(R.string.manychats_video_call_group_timeout_server_keeplive))) {
            this.u0 = true;
        }
        if (RTCParameters.k.b && !getResources().getString(i2).isEmpty()) {
            ty5.b(this, i2, 1).show();
        }
        this.t0 = true;
        q2(false);
        Log.i(K0, getResources().getString(R.string.manychats_call_end) + "-");
        this.G0.sendEmptyMessage(5);
    }

    public final void o2() {
        Intent intent = new Intent(this, (Class<?>) VideoCallGroupSelectionActivity.class);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < com.zenmen.media.roomchatdemo.videocallgroup.b.e().g(); i2++) {
            VideoCallGroupUserAttribute videoCallGroupUserAttributeB = com.zenmen.media.roomchatdemo.videocallgroup.b.e().b(i2);
            if (videoCallGroupUserAttributeB.usertype != VideoCallGroupUserAttribute.b.idle) {
                userInfo userinfo = new userInfo();
                userinfo.id = videoCallGroupUserAttributeB.userId;
                userinfo.icon = videoCallGroupUserAttributeB.iconId;
                userinfo.name = videoCallGroupUserAttributeB.userName;
                arrayList.add(userinfo);
            }
        }
        intent.putExtra("USER_LIST_FOR_SELECTION", arrayList);
        intent.putExtra("IS_INVITE_MODE", 1);
        startActivityForResult(intent, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (L0 == RTCParameters.MY_NAME.I_AM_NONE) {
            Log.i(K0, "invalid call this activity,just finish");
            finish();
        }
        setContentView(R.layout.manychats_activity_video_call_group_chatting_ui);
        getWindow().addFlags(6815872);
        f2();
        super.onCreate(bundle);
        int i2 = Build.VERSION.SDK_INT;
        findViewById(R.id.rootFrameLayout).setPadding(0, me1.h(this), 0, 0);
        if (i2 >= 23) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
        if (!com.zenmen.media.roomchatdemo.videocallgroup.d.P().a0("onCreate")) {
            Log.i(K0, "to call finish");
            finish();
        }
        O0 = this;
        this.f0 = com.zenmen.media.roomchatdemo.videocallgroup.d.P().O();
        RTCParameters.MY_NAME my_name = L0;
        RTCParameters.MY_NAME my_name2 = RTCParameters.MY_NAME.I_AM_ALICE;
        if (my_name == my_name2 || L0 == RTCParameters.MY_NAME.I_AM_CHARLIE) {
            this.z = true;
        } else {
            this.z = false;
        }
        if (L0 == RTCParameters.MY_NAME.I_AM_BOB) {
            NetworkUtil.c(this, new h());
        }
        Y2();
        G2();
        F2();
        if (my_name2 == L0) {
            y2();
        } else {
            getLoaderManager().initLoader(0, null, new we2(this, this.f0).c);
        }
        com.zenmen.media.roomchat.a.d(this);
        t35.a().b();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Log.i(K0, "onDestroy +");
        i2();
        Log.i(K0, "onDestroy -");
        super.onDestroy();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ka6 ka6Var;
        super.onPause();
        if (RTCParameters.k.k && (ka6Var = this.v0) != null) {
            ka6Var.k(false);
        }
        if (s55.c(this) != null) {
            s55.c(this).a();
        }
        f2();
        this.F0 = false;
        Log.i(K0, "onPause");
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.o0 = false;
        P2(16, 0);
        ka6 ka6Var = this.v0;
        if (ka6Var != null) {
            ka6Var.k(true);
        }
        if (s55.c(this) != null) {
            s55.c(this).d();
        }
        f2();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Log.i(K0, "onStop");
        if (s55.c(this) != null && !s55.c(this).f) {
            if (rg4.c(this)) {
                if (!this.o0 && !this.t0 && Build.BRAND.toLowerCase().equals("vivo")) {
                    moveTaskToBack(true);
                }
                P2(15, 0);
            }
            if (!this.o0 && !this.t0 && Build.BRAND.toLowerCase().equals("vivo")) {
                moveTaskToBack(true);
            }
            this.F0 = true;
        }
        if (s55.c(this) != null) {
            s55.c(this).a();
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void p1() {
        super.p1();
    }

    public final void p2() {
        boolean z = !this.M;
        this.M = z;
        if (z) {
            this.K.setImageResource(R.drawable.ic_voip_voice_ban_off_3x);
            this.L.setText(R.string.manychats_voice_mute);
        } else {
            this.K.setImageResource(R.drawable.ic_voip_voice_ban_normal_3x);
            this.L.setText(R.string.manychats_voice_unmute);
        }
        na6.k(RTCParameters.l(), this.f0, P0, !this.M);
        com.zenmen.media.roomchatdemo.videocallgroup.d.P().E(this.M);
    }

    public final void q2(boolean z) {
        if (z) {
            try {
                if (!rg4.b(this)) {
                    rg4.e(this);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (com.zenmen.media.roomchatdemo.videocallgroup.d.P().M(R.string.manychats_video_call_group_network_disconnect)) {
            this.Q = z;
            int i2 = 0;
            if (z) {
                this.O.setImageResource(R.drawable.ic_voip_video_tape_off_3x);
                this.P.setText(R.string.manychats_video_open);
                this.R.setVisibility(0);
            } else {
                this.O.setImageResource(R.drawable.ic_voip_video_tape_normal_3x);
                this.P.setText(R.string.manychats_video_unopen);
                this.R.setVisibility(4);
            }
            if (this.v0 == null && this.Q) {
                this.v0 = new ka6();
            }
            if (this.Q) {
                ka6 ka6Var = this.v0;
                if (ka6Var != null) {
                    ka6Var.j();
                }
            } else {
                ka6 ka6Var2 = this.v0;
                if (ka6Var2 != null) {
                    ka6Var2.m();
                }
            }
            try {
                synchronized (this.w0) {
                    while (true) {
                        if (i2 >= this.I0.size()) {
                            break;
                        }
                        if (this.I0.get(i2).a().userId != RTCParameters.l()) {
                            i2++;
                        } else if (this.Q) {
                            this.x0.notifyItemChanged(i2, AppleAdapter.PayloadsTypes.videoopen);
                        } else {
                            this.x0.notifyItemChanged(i2, AppleAdapter.PayloadsTypes.videoclose);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (this.t0) {
                return;
            }
            com.zenmen.media.roomchatdemo.videocallgroup.d.P().v(z);
        }
    }

    public void r2(int i2) {
        this.t0 = true;
        ty5.b(this, i2, 1).show();
        q2(false);
        h2();
        com.zenmen.media.roomchatdemo.videocallgroup.d.P().H(P0);
        setResult(-1, getIntent());
        finish();
    }

    public long s2() {
        return com.zenmen.media.roomchatdemo.videocallgroup.b.e().h();
    }

    public final int t2() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        RTCParameters.s(point.y);
        return point.y;
    }

    public final int u2() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        RTCParameters.t(point.x);
        return point.x;
    }

    public List<userInfo> v2() {
        if (com.zenmen.media.roomchatdemo.videocallgroup.b.e().c() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < com.zenmen.media.roomchatdemo.videocallgroup.b.e().g(); i2++) {
            VideoCallGroupUserAttribute videoCallGroupUserAttributeB = com.zenmen.media.roomchatdemo.videocallgroup.b.e().b(i2);
            if (videoCallGroupUserAttributeB.usertype != VideoCallGroupUserAttribute.b.idle) {
                userInfo userinfo = new userInfo();
                userinfo.id = videoCallGroupUserAttributeB.userId;
                userinfo.icon = videoCallGroupUserAttributeB.iconId;
                userinfo.name = videoCallGroupUserAttributeB.userName;
                arrayList.add(userinfo);
            }
        }
        return arrayList;
    }

    public void y2() {
        if (!this.r0) {
            E2();
            N2();
            j3();
            B2();
            f3();
            T2(this.z);
            s55.c(this);
            if (this.w) {
                e2();
            }
            O2();
            P2(20, 0);
        }
        this.r0 = true;
        if (L0 == RTCParameters.MY_NAME.I_AM_BOB) {
            na6.e(RTCParameters.l(), this.f0, P0);
        }
        Log.i(K0, "initActivity ok");
    }

    public final void z2() {
        this.F.setVisibility(8);
        this.H.setVisibility(0);
        this.S.setVisibility(0);
        this.J.setVisibility(0);
        this.N.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements NetworkUtil.c {
        public h() {
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void onStop() {
            VideoCallGroupChattingUIActivity.this.n2(R.string.manychats_dialog_video_call_network_cancel);
        }

        @Override // com.zenmen.media.roomchat.NetworkUtil.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends cs0 {
        public k() {
        }

        @Override // defpackage.cs0
        public void b() {
            VideoCallGroupChattingUIActivity.this.p2();
        }

        @Override // defpackage.cs0
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends cs0 {
        public l() {
        }

        @Override // defpackage.cs0
        public void b() {
            na6.q(RTCParameters.l(), VideoCallGroupChattingUIActivity.this.f0, VideoCallGroupChattingUIActivity.P0, !VideoCallGroupChattingUIActivity.this.Q);
            VideoCallGroupChattingUIActivity.this.q2(!r0.Q);
        }

        @Override // defpackage.cs0
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends cs0 {
        public m() {
        }

        @Override // defpackage.cs0
        public void b() {
            VideoCallGroupChattingUIActivity.this.k2();
        }

        @Override // defpackage.cs0
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends cs0 {
        public n() {
        }

        @Override // defpackage.cs0
        public void b() {
            VideoCallGroupChattingUIActivity.this.l2();
        }

        @Override // defpackage.cs0
        public void a() {
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
