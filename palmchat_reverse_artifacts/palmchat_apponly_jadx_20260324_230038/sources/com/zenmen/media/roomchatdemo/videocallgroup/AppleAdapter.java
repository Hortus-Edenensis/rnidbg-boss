package com.zenmen.media.roomchatdemo.videocallgroup;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupUserAttribute;
import com.zenmen.palmchat.R;
import defpackage.bz4;
import defpackage.gh;
import defpackage.ir2;
import defpackage.qy4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AppleAdapter extends RecyclerView.Adapter<b> {
    public static String g = "AppleAdapter";
    public List<gh> e;
    public GridLayoutManager f;

    /* JADX INFO: compiled from: SearchBox */
    public enum PayloadsTypes {
        firstframe,
        voicedected,
        detachsurface,
        stopped,
        videoopen,
        videoclose
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11979a;

        static {
            int[] iArr = new int[PayloadsTypes.values().length];
            f11979a = iArr;
            try {
                iArr[PayloadsTypes.firstframe.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11979a[PayloadsTypes.voicedected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11979a[PayloadsTypes.videoopen.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11979a[PayloadsTypes.videoclose.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.ViewHolder implements SurfaceHolder.Callback {
        public int A;
        public boolean B;
        public HandlerC0936b C;
        public boolean E;
        public int F;
        public Surface d;
        public SurfaceView e;
        public ImageView f;
        public ImageView g;
        public ImageView h;
        public ImageView i;
        public LinearLayout j;
        public View k;
        public LinearLayout l;
        public long m;
        public TextView n;
        public LinearLayout o;
        public VideoCallGroupUserAttribute.b p;
        public TextView q;
        public Context r;
        public int s;
        public boolean t;
        public VideoCallGroupUserAttribute u;
        public boolean v;
        public boolean w;
        public boolean x;
        public int y;
        public boolean z;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoCallGroupChattingUIActivity.w2() != null) {
                    VideoCallGroupChattingUIActivity.w2().J2(b.this.u);
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.media.roomchatdemo.videocallgroup.AppleAdapter$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class HandlerC0936b extends Handler {
            public HandlerC0936b() {
                sendEmptyMessageDelayed(5, 10000L);
            }

            public void a() {
                removeMessages(1);
                removeMessages(2);
                removeMessages(5);
            }

            public void finalize() throws Throwable {
                a();
                bz4.a(AppleAdapter.g, "CallingItemControlHandler finalize ");
                super.finalize();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (b.this.t) {
                    return;
                }
                try {
                    int i = message.what;
                    if (i == 1) {
                        bz4.a(AppleAdapter.g, "MESSAGE_INNER_UPDATE_WAITING " + b.this.m);
                        b.this.K();
                        if (!b.this.z || b.this.t) {
                            removeMessages(1);
                            return;
                        } else {
                            sendEmptyMessageDelayed(1, 300L);
                            return;
                        }
                    }
                    if (i == 2) {
                        bz4.a(AppleAdapter.g, "MESSAGE_INNER_UPDATE_TALKING " + b.this.m);
                        if (b.this.w) {
                            if (RTCParameters.k.h) {
                                b.this.j.setVisibility(0);
                            }
                            if (RTCParameters.k.g) {
                                b bVar = b.this;
                                bVar.J(bVar.A);
                                b.this.h.setVisibility(0);
                            }
                            sendEmptyMessageDelayed(2, 300L);
                            return;
                        }
                        return;
                    }
                    if (i == 3) {
                        b.this.w = false;
                        b.this.h.setVisibility(4);
                        b.this.j.setVisibility(4);
                        return;
                    }
                    if (i != 5) {
                        return;
                    }
                    bz4.a(AppleAdapter.g, "MESSAGE_INNER_UPDATE_NO_VIDEO " + b.this.m + " " + b.this.F);
                    b bVar2 = b.this;
                    int i2 = bVar2.F;
                    bVar2.F = i2 + (-1);
                    if (i2 <= 0) {
                        bVar2.f.setAlpha(1.0f);
                        b.this.e.setVisibility(4);
                        b.this.F = 0;
                    }
                    sendEmptyMessageDelayed(5, 10000L);
                } catch (Exception unused) {
                }
            }
        }

        public b(Context context, View view) {
            super(view);
            this.d = null;
            this.m = 1L;
            this.p = VideoCallGroupUserAttribute.b.idle;
            this.t = false;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = 1;
            this.z = false;
            this.A = 1;
            this.B = false;
            this.C = new HandlerC0936b();
            this.E = false;
            this.F = 2;
            x(view);
            this.r = context;
            bz4.a(AppleAdapter.g, "ViewHolder construct");
        }

        public void A(boolean z) {
            this.v = z;
        }

        public final void B(boolean z) {
            if (z) {
                D(false);
                I();
            }
        }

        public void C(boolean z) {
            HandlerC0936b handlerC0936b;
            if (this.x || !z) {
                this.j.setVisibility(4);
                HandlerC0936b handlerC0936b2 = this.C;
                if (handlerC0936b2 != null) {
                    handlerC0936b2.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            if (!this.w && (handlerC0936b = this.C) != null) {
                handlerC0936b.removeMessages(2);
                this.C.sendEmptyMessage(2);
            }
            this.w = true;
            HandlerC0936b handlerC0936b3 = this.C;
            if (handlerC0936b3 != null) {
                handlerC0936b3.removeMessages(3);
            }
        }

        public final void D(boolean z) {
            if (this.z != z && z) {
                HandlerC0936b handlerC0936b = this.C;
                if (handlerC0936b != null) {
                    handlerC0936b.sendEmptyMessageDelayed(1, 300L);
                }
            } else if (!z) {
                this.g.setVisibility(8);
                this.l.setVisibility(8);
                HandlerC0936b handlerC0936b2 = this.C;
                if (handlerC0936b2 != null) {
                    handlerC0936b2.removeMessages(1);
                }
            }
            this.z = z;
        }

        public boolean E(VideoCallGroupUserAttribute videoCallGroupUserAttribute) {
            try {
                this.u = videoCallGroupUserAttribute;
            } catch (Exception unused) {
            }
            if (videoCallGroupUserAttribute == null) {
                H(8);
                D(false);
                C(false);
                B(true);
                this.p = VideoCallGroupUserAttribute.b.idle;
                this.t = true;
                HandlerC0936b handlerC0936b = this.C;
                if (handlerC0936b != null) {
                    handlerC0936b.a();
                }
                return true;
            }
            this.t = videoCallGroupUserAttribute.bstopped;
            this.s = videoCallGroupUserAttribute.ctrlId;
            this.p = videoCallGroupUserAttribute.usertype;
            if (!VideoCallGroupChattingUIActivity.w2().I2()) {
                VideoCallGroupUserAttribute videoCallGroupUserAttribute2 = this.u;
                videoCallGroupUserAttribute2.cameraon = 0;
                videoCallGroupUserAttribute2.mute = 0;
                this.n.setVisibility(4);
            } else if (RTCParameters.k.f) {
                this.n.setVisibility(0);
                this.n.setMaxWidth(this.k.getWidth() - (this.k.getWidth() / 4));
            }
            if (videoCallGroupUserAttribute.firstframe) {
                y();
            } else {
                VideoCallGroupUserAttribute videoCallGroupUserAttribute3 = this.u;
                if (videoCallGroupUserAttribute3.cameraon == 0 || videoCallGroupUserAttribute3.userId == RTCParameters.l()) {
                    this.E = false;
                    this.q.setVisibility(4);
                } else if (!this.E) {
                    this.q.setVisibility(0);
                }
            }
            VideoCallGroupUserAttribute videoCallGroupUserAttribute4 = this.u;
            this.m = videoCallGroupUserAttribute4.userCId;
            this.n.setText(videoCallGroupUserAttribute4.userName);
            if (this.u.userId == RTCParameters.l()) {
                this.n.setTextColor(this.k.getResources().getColor(R.color.green));
            } else {
                this.n.setTextColor(this.k.getResources().getColor(R.color.white));
            }
            G(videoCallGroupUserAttribute.cameraon);
            if (videoCallGroupUserAttribute.cameraon != 0) {
                this.f.setAlpha(0.0f);
            } else if (videoCallGroupUserAttribute.iconId > 0 || !TextUtils.isEmpty(videoCallGroupUserAttribute.iconUrl)) {
                this.f.setAlpha(1.0f);
            } else {
                this.f.setAlpha(0.0f);
            }
            A(videoCallGroupUserAttribute.meetingStart);
            if (this.v) {
                ir2.a(this.r, this.f, videoCallGroupUserAttribute.iconId, videoCallGroupUserAttribute.iconUrl);
            } else {
                ir2.b(this.f, videoCallGroupUserAttribute.iconId, videoCallGroupUserAttribute.iconUrl, 10);
            }
            if (videoCallGroupUserAttribute.mute == 0) {
                this.i.setVisibility(4);
                this.x = false;
            } else if (RTCParameters.k.e) {
                this.i.setVisibility(0);
                this.x = true;
            }
            VideoCallGroupUserAttribute.a aVar = videoCallGroupUserAttribute.status;
            if (aVar == VideoCallGroupUserAttribute.a.disable_gone) {
                H(8);
                D(false);
                C(false);
                B(true);
            } else if (aVar == VideoCallGroupUserAttribute.a.disable_visible) {
                B(true);
                C(false);
                D(false);
                H(0);
            } else if (aVar == VideoCallGroupUserAttribute.a.connected) {
                B(false);
                D(false);
                C(false);
                H(0);
            } else if (aVar == VideoCallGroupUserAttribute.a.connecting) {
                D(true);
                C(false);
                B(false);
                H(0);
            }
            C(videoCallGroupUserAttribute.voiceDec);
            qy4.b().s(this.s, this.m, this.d);
            return true;
        }

        public void F(boolean z) {
            try {
                if (z) {
                    this.f.setAlpha(0.0f);
                    qy4.b().s(this.s, this.m, this.d);
                } else {
                    this.f.setAlpha(1.0f);
                    qy4.b().s(this.s, this.m, null);
                }
            } catch (Exception unused) {
            }
        }

        public void G(int i) {
            int i2 = i == 1 ? 0 : 4;
            try {
                if (VideoCallGroupChattingUIActivity.w2().I2() && this.e.getVisibility() != i2) {
                    this.e.setVisibility(i2);
                }
            } catch (Exception unused) {
            }
        }

        public void H(int i) {
            View view = this.k;
            if (view != null) {
                view.setVisibility(i);
            }
        }

        public final void I() {
            this.h.setVisibility(8);
            this.B = true;
        }

        public final void J(int i) {
            int i2 = R.drawable.manychats_video_call_group_voice001;
            if (i != 0) {
                if (i == 1) {
                    i2 = R.drawable.manychats_video_call_group_voice002;
                } else if (i == 2 || i == 3) {
                    i2 = R.drawable.manychats_video_call_group_voice003;
                }
            }
            try {
                this.h.setImageResource(i2);
            } catch (Exception unused) {
            }
            int i3 = this.A + 1;
            this.A = i3;
            this.A = i3 % 4;
        }

        public final void K() {
            if (this.v) {
                this.g.setVisibility(0);
                this.l.setVisibility(0);
            } else {
                this.g.setVisibility(4);
                this.l.setVisibility(4);
            }
            int i = this.y;
            try {
                this.g.setImageResource(i == 1 ? R.drawable.manychats_ic_video_call_dot1 : i == 2 ? R.drawable.manychats_ic_video_call_dot2 : i == 3 ? R.drawable.manychats_ic_video_call_dot3 : i == 4 ? R.drawable.manychats_ic_video_call_dot4 : i == 5 ? R.drawable.manychats_ic_video_call_dot5 : i == 6 ? R.drawable.manychats_ic_video_call_dot6 : i == 7 ? R.drawable.manychats_ic_video_call_dot7 : i == 8 ? R.drawable.manychats_ic_video_call_dot8 : R.drawable.manychats_ic_video_call_dot0);
                this.g.setAlpha(150);
            } catch (Exception unused) {
            }
            int i2 = this.y + 1;
            this.y = i2;
            this.y = i2 % 8;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            bz4.a("ChattingItemControl", this.s + " surfaceChanged" + surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            bz4.a("ChattingItemControl", this.s + " " + this.m + " surfaceCreated " + surfaceHolder.getSurface());
            this.d = surfaceHolder.getSurface();
            qy4.b().s(this.s, this.m, this.d);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            bz4.a("ChattingItemControl", this.s + " surfaceDestroyed" + surfaceHolder.getSurface());
            this.d = null;
            qy4.b().s(this.s, this.m, this.d);
        }

        public void x(View view) {
            this.k = view;
            if (view != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.group_chatting_head_image);
                this.f = imageView;
                imageView.setCropToPadding(true);
                this.f.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f.setVisibility(0);
                this.q = (TextView) this.k.findViewById(R.id.group_chatting_waiting_video);
                this.g = (ImageView) this.k.findViewById(R.id.group_chatting_dot);
                this.h = (ImageView) this.k.findViewById(R.id.group_chatting_talking);
                ImageView imageView2 = (ImageView) this.k.findViewById(R.id.group_chatting_mute);
                this.i = imageView2;
                imageView2.setVisibility(4);
                this.n = (TextView) this.k.findViewById(R.id.group_chatting_username);
                this.o = (LinearLayout) this.k.findViewById(R.id.group_chatting_bottom_linearlayout);
                LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.group_chatting_hide);
                this.l = linearLayout;
                linearLayout.setVisibility(4);
                this.j = (LinearLayout) this.k.findViewById(R.id.group_chatting_voice_detect);
                SurfaceView surfaceView = (SurfaceView) this.k.findViewById(R.id.group_chatting_video_view);
                this.e = surfaceView;
                surfaceView.getHolder().addCallback(this);
                this.e.setOnClickListener(new a());
                this.e.setVisibility(4);
            }
        }

        public void y() {
            bz4.a(AppleAdapter.g, "onFirstFrame :" + this.s);
            this.f.setAlpha(0.0f);
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
            }
            this.q.setVisibility(4);
            this.E = true;
            this.F = 2;
        }

        public void z(int i) {
            this.s = i;
        }
    }

    public AppleAdapter(List<gh> list, GridLayoutManager gridLayoutManager) {
        this.f = gridLayoutManager;
        this.e = list;
    }

    public final void b(b bVar, int i) {
        if (VideoCallGroupChattingUIActivity.w2() == null) {
            return;
        }
        try {
            gh ghVar = this.e.get(i);
            bVar.z(ghVar.a().ctrlId);
            bVar.r = VideoCallGroupChattingUIActivity.w2();
            if (bVar.E(ghVar.a())) {
                ViewGroup.LayoutParams layoutParams = bVar.f.getLayoutParams();
                layoutParams.height = (this.f.getWidth() / this.f.getSpanCount()) - bVar.f.getPaddingLeft();
                bVar.f.setLayoutParams(layoutParams);
                return;
            }
            bz4.a(g, "holderChanged:" + i + " " + ghVar.a().firstframe);
            if (ghVar.a().firstframe) {
                bVar.y();
            }
            bVar.A(ghVar.a().meetingStart);
            bVar.C(ghVar.a().voiceDec);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i, List<Object> list) {
        super.onBindViewHolder(bVar, i, list);
        if (list.isEmpty()) {
            if (this.e.size() >= i) {
                b(bVar, i);
                return;
            }
            return;
        }
        int i2 = a.f11979a[((PayloadsTypes) list.get(0)).ordinal()];
        if (i2 == 1) {
            bVar.y();
            return;
        }
        if (i2 == 2) {
            bVar.C(this.e.get(i).a().voiceDec);
        } else if (i2 == 3) {
            bVar.F(true);
        } else {
            if (i2 != 4) {
                return;
            }
            bVar.F(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        try {
            return new b(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.manychats_video_call_group_chatting_item_control, viewGroup, false));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(b bVar) {
        bz4.a(g, "onViewDetachedFromWindow:" + bVar.s);
        super.onViewDetachedFromWindow(bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(b bVar) {
        super.onViewRecycled(bVar);
        try {
            bz4.a(g, "onViewRecycled:" + bVar.s + " " + bVar);
            bVar.E(null);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    public void h(List<gh> list) {
        this.e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
    }
}
