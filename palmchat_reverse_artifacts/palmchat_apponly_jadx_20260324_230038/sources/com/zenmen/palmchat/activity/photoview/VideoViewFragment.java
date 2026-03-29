package com.zenmen.palmchat.activity.photoview;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.media.player.IMagicMediaPlayer;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.media.player.VideoStateChangeListener;
import com.zenmen.media.player.ZMAudioFocusMgr;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.DownloadProgressBar;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import defpackage.UI;
import defpackage.bq6;
import defpackage.ds0;
import defpackage.eb6;
import defpackage.gr2;
import defpackage.h22;
import defpackage.ho3;
import defpackage.k86;
import defpackage.m40;
import defpackage.pm2;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.td3;
import defpackage.tg4;
import defpackage.xa6;
import defpackage.xm3;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VideoViewFragment extends Fragment implements pm2<Cursor>, AudioManager.OnAudioFocusChangeListener {
    public static final String F = "VideoViewFragment";
    public ImageView A;
    public DownloadProgressBar B;
    public long E;
    public MediaItem d;
    public String e;
    public int f;
    public boolean h;
    public Handler j;
    public ZMAudioFocusMgr l;
    public eb6.a m;
    public String q;
    public ChatItem r;
    public int s;
    public MessageVo t;
    public FrameLayout x;
    public IMagicMediaPlayer y;
    public ImageView z;
    public boolean g = true;
    public boolean i = false;
    public long k = 0;
    public eb6.a n = new l();
    public boolean o = false;
    public boolean p = false;
    public boolean u = true;
    public boolean v = false;
    public boolean w = false;
    public boolean C = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xa6 f12347a;

        public a(xa6 xa6Var) {
            this.f12347a = xa6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12347a.a() == VideoViewFragment.this.s) {
                boolean zD = VideoViewFragment.this.t != null ? eb6.e().d(VideoViewFragment.this.t.data1) : false;
                if (this.f12347a.c() == 0) {
                    if (VideoViewFragment.this.y == null || !VideoViewFragment.this.y.isPlaying()) {
                        VideoViewFragment.this.y0();
                        return;
                    } else {
                        VideoViewFragment.this.u0(true, false);
                        return;
                    }
                }
                if (this.f12347a.c() == 1) {
                    if (zD && VideoViewFragment.this.y != null && VideoViewFragment.this.y.isPlaying()) {
                        VideoViewFragment.this.u0(false, false);
                        return;
                    }
                    return;
                }
                if (this.f12347a.c() == 2) {
                    if (zD) {
                        VideoViewFragment.this.A0(this.f12347a.b());
                    } else {
                        VideoViewFragment.this.y0();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("type", 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h22 f12349a;

        public c(h22 h22Var) {
            this.f12349a = h22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f12349a.a() != VideoViewFragment.this.s) {
                    VideoViewFragment.this.u0(true, true);
                } else if (VideoViewFragment.this.f == 1) {
                    if (VideoViewFragment.this.d != null) {
                        VideoViewFragment videoViewFragment = VideoViewFragment.this;
                        videoViewFragment.k = videoViewFragment.d.playLength;
                    }
                    VideoViewFragment.this.j.sendEmptyMessage(18);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 17) {
                if (i == 18 && VideoViewFragment.this.y != null) {
                    LogUtil.i(VideoViewFragment.F, "current position = " + VideoViewFragment.this.y.getPosition());
                    FragmentActivity activity = VideoViewFragment.this.getActivity();
                    if (activity != null) {
                        ((PhotoViewActivity) activity).E3(VideoViewFragment.this.s, 0L, VideoViewFragment.this.k);
                    }
                }
            } else if (VideoViewFragment.this.y != null) {
                LogUtil.i(VideoViewFragment.F, "current position = " + VideoViewFragment.this.y.getPosition());
                FragmentActivity activity2 = VideoViewFragment.this.getActivity();
                if (activity2 != null) {
                    ((PhotoViewActivity) activity2).E3(VideoViewFragment.this.s, VideoViewFragment.this.y.getPosition(), VideoViewFragment.this.k);
                }
                if (VideoViewFragment.this.y.isPlaying()) {
                    VideoViewFragment.this.j.sendEmptyMessageDelayed(17, 1000L);
                }
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12351a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FragmentActivity activity = VideoViewFragment.this.getActivity();
                if (activity != null) {
                    ((BasePreviewActivity) activity).C1();
                }
            }
        }

        public e(View view) {
            this.f12351a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12351a.setOnClickListener(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {
            public a() {
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    VideoViewFragment.this.w0();
                } else {
                    if (!eb6.e().d(VideoViewFragment.this.t.data1)) {
                        sy5.e(VideoViewFragment.this.getActivity(), R.string.downloading_video_before_forward, 1).g();
                        return;
                    }
                    Intent intent = new Intent(VideoViewFragment.this.getActivity(), (Class<?>) SendMessageActivity.class);
                    intent.putExtra("message_vo", VideoViewFragment.this.t);
                    VideoViewFragment.this.startActivity(intent);
                }
            }
        }

        public f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (VideoViewFragment.this.h && VideoViewFragment.this.f == 1 && VideoViewFragment.this.t != null && VideoViewFragment.this.t.attachStatus != 1) {
                new td3.c(VideoViewFragment.this.getActivity()).c(new String[]{VideoViewFragment.this.getActivity().getString(R.string.chat_item_menu_forward), VideoViewFragment.this.getActivity().getString(R.string.chat_item_menu_save_video)}).d(new a()).a().b();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(FileProvider.getUriForFile(AppContext.getContext(), "com.zenmen.palmchat.webplatform.file.provider", new File(VideoViewFragment.this.d.localPath)), "video/mp4");
                intent.setFlags(268435456);
                intent.addFlags(3);
                VideoViewFragment.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                sy5.f(VideoViewFragment.this.getActivity(), "打开视频失败", 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoViewFragment.this.y0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12359a;
        public final /* synthetic */ File b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        public j(String str, File file, File file2, String str2) {
            this.f12359a = str;
            this.b = file;
            this.c = file2;
            this.d = str2;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            boolean zF;
            if (TextUtils.isEmpty(this.f12359a) || !new File(this.f12359a).exists()) {
                File file = this.c;
                zF = (file == null || !file.exists()) ? false : pu1.f(this.c, this.b);
            } else {
                zF = pu1.f(new File(this.f12359a), this.b);
            }
            return Boolean.valueOf(zF);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                xm3.a(this.d);
                if (VideoViewFragment.this.getActivity() != null) {
                    sy5.f(VideoViewFragment.this.getActivity(), VideoViewFragment.this.getResources().getString(R.string.save_video_to_dir, pu1.m()), 1).g();
                }
            }
        }
    }

    public static String n0(MessageVo messageVo) {
        if (messageVo == null) {
            return null;
        }
        if (messageVo.attachStatus == 5) {
            return "file://file_url_error";
        }
        if (TextUtils.isEmpty(messageVo.data2)) {
            return messageVo.data4;
        }
        return "file://" + messageVo.data2;
    }

    public final void A0(int i2) {
        int i3;
        LogUtil.i(F, "startPlayVideo");
        p0();
        if (!(this.t != null ? eb6.e().d(this.t.data1) : false)) {
            if (this.t != null) {
                if (eb6.e().d(this.t.data1) || TextUtils.isEmpty(this.t.data3) || (i3 = this.t.attachStatus) == 1 || i3 == 5) {
                    if (this.t.attachStatus == 1) {
                        sy5.e(getContext(), R.string.video_des_downloading, 1).g();
                        return;
                    } else {
                        sy5.e(getContext(), R.string.video_des_delete, 1).g();
                        return;
                    }
                }
                this.v = true;
                eb6 eb6VarE = eb6.e();
                FragmentActivity activity = getActivity();
                MessageVo messageVo = this.t;
                eb6VarE.c(activity, messageVo.contactRelate, messageVo.mid, messageVo.data3, messageVo.data4, messageVo.data5, this.n);
                return;
            }
            return;
        }
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.A.setImageResource(R.drawable.square_video_play_icon);
        LogUtil.onClickEvent("V38", null, null);
        C0(true);
        ZMAudioFocusMgr zMAudioFocusMgr = this.l;
        if (zMAudioFocusMgr != null) {
            zMAudioFocusMgr.requestAudioFocuse();
        }
        if (this.o) {
            this.o = false;
            if (i2 >= 0) {
                this.y.seek(i2);
            }
            this.y.pause();
        } else {
            this.k = Long.valueOf(this.t.data6).longValue();
            this.y.setLoop(false);
            this.y.setResumable(false);
            this.y.setVideo(this.t.data1);
            this.y.mute(false);
            IMagicMediaPlayer iMagicMediaPlayer = this.y;
            if (iMagicMediaPlayer instanceof MagicTextureMediaPlayer) {
                ((MagicTextureMediaPlayer) iMagicMediaPlayer).setFixedSize(true);
            }
            this.y.setVideoStateChangeListener(new k());
            if (i2 >= 0) {
                this.y.seek(i2);
            }
            this.y.start();
        }
        this.C = true;
        this.E = System.currentTimeMillis();
        s0(true);
    }

    public final void B0(boolean z) {
        A0(-1);
    }

    public final void C0(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((PhotoViewActivity) activity).A3(z);
        }
    }

    public final void E0() {
        if (getActivity() != null) {
            ((PhotoViewActivity) getActivity()).v3(this.s);
        }
    }

    public void k0(String str, File file, File file2, String str2) {
        new j(str, file2, file, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final BasePreviewActivity l0() {
        if (getActivity() != null) {
            return (BasePreviewActivity) getActivity();
        }
        return null;
    }

    public final int m0() {
        return R.layout.fragment_sight_video;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (r0()) {
            return;
        }
        UI.c(getActivity(), this.s, null, this);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = getArguments().getString(SquareDetailVideoView.KEY_ITEM);
        this.d = (MediaItem) getArguments().getParcelable("key_media_item");
        this.r = (ChatItem) getArguments().getParcelable("chat_item");
        this.s = getArguments().getInt(SquareDetailVideoView.KEY_POSITION);
        this.g = getArguments().getBoolean("key_init_item_auto_play", true);
        if (this.s == getArguments().getInt(SquareDetailVideoView.KEY_INIT_POSITION)) {
            this.u = false;
            this.w = true;
            if (this.g) {
                this.v = true;
            }
        }
        this.h = getArguments().getBoolean("long_click");
        this.e = getArguments().getString("key_from");
        this.f = getArguments().getInt("key_show_mode");
        if ("from_moment".equals(this.e)) {
            this.i = true;
        }
        if (!r0()) {
            ds0.a().c(this);
        }
        this.j = new d(Looper.getMainLooper());
        try {
            this.l = new ZMAudioFocusMgr(getActivity(), this, 3, 2);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        if (i2 != this.s) {
            return null;
        }
        return new CursorLoader(getActivity(), DBUriManager.b(ho3.class, this.r), null, "packet_id=?", new String[]{this.q}, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(m0(), (ViewGroup) null);
        viewInflate.postDelayed(new e(viewInflate), 500L);
        viewInflate.setOnLongClickListener(new f());
        this.z = (ImageView) viewInflate.findViewById(R.id.video_thumbnail);
        this.A = (ImageView) viewInflate.findViewById(R.id.video_play);
        this.B = (DownloadProgressBar) viewInflate.findViewById(R.id.status_downloading);
        this.x = (FrameLayout) viewInflate.findViewById(R.id.video_content);
        if (r0()) {
            if (this.d != null) {
                this.z.setVisibility(0);
                gr2.j().h(k86.p(this.d.localThumbPath), this.z, bq6.z());
                this.A.setVisibility(0);
                this.A.setOnClickListener(new g());
            }
        } else if (this.f == 1) {
            this.A.setOnClickListener(new h());
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (!r0()) {
            ds0.a().d(this);
            getActivity().getSupportLoaderManager().destroyLoader(this.s);
        }
        IMagicMediaPlayer iMagicMediaPlayer = this.y;
        if (iMagicMediaPlayer != null) {
            iMagicMediaPlayer.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @qm5
    public void onFragmentChanged(h22 h22Var) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new c(h22Var));
        }
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        loader.abandon();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        u0(false, true);
        IMagicMediaPlayer iMagicMediaPlayer = this.y;
        if (iMagicMediaPlayer != null && iMagicMediaPlayer.getPosition() > 0) {
            this.z.setVisibility(8);
        }
        ZMAudioFocusMgr zMAudioFocusMgr = this.l;
        if (zMAudioFocusMgr != null) {
            zMAudioFocusMgr.abandonAudioFocus();
        }
        this.j.removeMessages(17);
        this.j.removeMessages(18);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.C) {
            this.E = System.currentTimeMillis();
            s0(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        s0(false);
    }

    @qm5
    public void onVideoControlEvent(xa6 xa6Var) {
        getActivity().runOnUiThread(new a(xa6Var));
    }

    public final void p0() {
        if (this.y != null) {
            return;
        }
        this.y = new MagicTextureMediaPlayer(getContext());
        this.x.addView((View) this.y, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean r0() {
        return this.f == 2;
    }

    public final void s0(boolean z) {
        if (this.t == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("video", this.t.data5);
            jSONObject.put("envir", m40.b(this.t.contactRelate) == 1 ? "2" : this.t.bizType == 0 ? "1" : "3");
            jSONObject.put("fulscr", "1");
            if (z) {
                LogUtil.onEvent("72", null, null, jSONObject.toString());
            } else {
                jSONObject.put("tm", String.valueOf(System.currentTimeMillis() - this.E));
                LogUtil.onEvent("73", null, null, jSONObject.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || l0() == null) {
            return;
        }
        l0().updateCurrentPageInfo(l0(), new b());
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        FragmentActivity activity;
        if (loader.getId() == this.s && cursor != null && cursor.moveToFirst()) {
            MessageVo messageVoBuildFromCursor = MessageVo.buildFromCursor(cursor);
            this.t = messageVoBuildFromCursor;
            int i2 = messageVoBuildFromCursor.mimeType;
            if (i2 != 4) {
                if (i2 == 10001) {
                    getActivity().getSupportLoaderManager().destroyLoader(this.s);
                    IMagicMediaPlayer iMagicMediaPlayer = this.y;
                    if (iMagicMediaPlayer != null) {
                        iMagicMediaPlayer.stop();
                        return;
                    }
                    return;
                }
                return;
            }
            if (!eb6.e().d(this.t.data1)) {
                this.z.setVisibility(0);
                gr2.j().h(n0(this.t), this.z, bq6.z());
                int i3 = this.t.attachStatus;
                if (i3 == 1) {
                    this.A.setVisibility(8);
                    this.B.setVisibility(0);
                    this.B.setProgress(this.t.sendingProgress);
                } else if (i3 == 4) {
                    this.A.setImageResource(R.drawable.square_video_error_icon);
                    this.A.setVisibility(0);
                    this.B.setVisibility(8);
                } else if (i3 == 5) {
                    this.A.setImageResource(R.drawable.square_video_error_icon);
                    this.A.setVisibility(0);
                    this.B.setVisibility(8);
                    E0();
                } else {
                    this.A.setImageResource(R.drawable.square_video_play_icon);
                    this.A.setVisibility(0);
                    this.B.setVisibility(8);
                    MessageVo messageVo = this.t;
                    if (messageVo.isSend && TextUtils.isEmpty(messageVo.data3) && this.v && !this.p) {
                        this.p = true;
                        sy5.e(getContext(), R.string.video_des_delete, 1).g();
                    }
                }
                this.k = Long.valueOf(this.t.data6).longValue();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((PhotoViewActivity) activity2).E3(this.s, 0L, this.k);
                    return;
                }
                return;
            }
            MessageVo messageVo2 = this.t;
            if (!messageVo2.isSend) {
                this.B.setProgress(messageVo2.sendingProgress);
            }
            MessageVo messageVo3 = this.t;
            if (messageVo3.sendingProgress < 100 && !messageVo3.isSend) {
                this.z.setVisibility(0);
                gr2.j().h(n0(this.t), this.z, bq6.z());
                MessageVo messageVo4 = this.t;
                if (messageVo4.status == 3 || messageVo4.attachStatus == 4) {
                    this.A.setImageResource(R.drawable.square_video_error_icon);
                    this.A.setVisibility(0);
                    return;
                }
                return;
            }
            IMagicMediaPlayer iMagicMediaPlayer2 = this.y;
            if (iMagicMediaPlayer2 == null || TextUtils.isEmpty(iMagicMediaPlayer2.getVideoPath())) {
                getArguments().remove(SquareDetailVideoView.KEY_INIT_POSITION);
                this.k = Long.valueOf(this.t.data6).longValue();
                if (this.w && (activity = getActivity()) != null) {
                    ((PhotoViewActivity) activity).E3(this.s, 0L, this.k);
                }
                boolean zB = tg4.b(getActivity(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList);
                if (this.v && zB) {
                    gr2.j().h(n0(this.t), this.z, bq6.z());
                    B0(true);
                    this.v = false;
                } else {
                    this.A.setImageResource(R.drawable.square_video_play_icon);
                    this.A.setVisibility(0);
                    this.z.setVisibility(0);
                    gr2.j().h(n0(this.t), this.z, bq6.z());
                    this.B.setVisibility(8);
                }
            }
        }
    }

    public final void u0(boolean z, boolean z2) {
        ZMAudioFocusMgr zMAudioFocusMgr;
        IMagicMediaPlayer iMagicMediaPlayer = this.y;
        if (iMagicMediaPlayer != null && iMagicMediaPlayer.isPlaying()) {
            C0(false);
            this.o = true;
            if (z && (zMAudioFocusMgr = this.l) != null) {
                zMAudioFocusMgr.abandonAudioFocus();
            }
            this.y.pause();
        }
        if (this.t == null || !z2) {
            return;
        }
        this.z.setVisibility(0);
        gr2.j().h(n0(this.t), this.z, bq6.z());
        if (z) {
            this.A.setVisibility(0);
        }
        this.B.setVisibility(8);
    }

    public final void w0() {
        int i2;
        if (l0() == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        if (!tg4.b(activity, permissionType.permissionList)) {
            BaseActivityPermissionDispatcher.b(l0(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
            return;
        }
        if (eb6.e().d(this.t.data1)) {
            File file = new File(this.t.data1);
            if (file.exists()) {
                x0(this.t.data1, file);
                return;
            }
            return;
        }
        this.m = new i();
        if (eb6.e().d(this.t.data1) || TextUtils.isEmpty(this.t.data3) || (i2 = this.t.attachStatus) == 1 || i2 == 5) {
            if (this.t.attachStatus == 1) {
                sy5.e(getContext(), R.string.video_des_downloading, 1).g();
                return;
            } else {
                sy5.e(getContext(), R.string.video_des_delete, 1).g();
                return;
            }
        }
        eb6 eb6VarE = eb6.e();
        FragmentActivity activity2 = getActivity();
        MessageVo messageVo = this.t;
        eb6VarE.c(activity2, messageVo.contactRelate, messageVo.mid, messageVo.data3, messageVo.data4, messageVo.data5, this.n);
    }

    public final void x0(String str, File file) {
        try {
            String str2 = pu1.m() + File.separator;
            String str3 = str2 + System.currentTimeMillis() + ".mp4";
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(str3);
            if (file3.exists()) {
                file3.delete();
            }
            file3.createNewFile();
            k0(str, file, file3, str3);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void y0() {
        B0(false);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements eb6.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12358a;

            public a(String str) {
                this.f12358a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                File file = new File(this.f12358a);
                if (file.exists()) {
                    VideoViewFragment.this.x0(this.f12358a, file);
                }
            }
        }

        public i() {
        }

        @Override // eb6.a
        public void a(String str, String str2) {
            if (VideoViewFragment.this.getActivity() != null) {
                VideoViewFragment.this.getActivity().runOnUiThread(new a(str2));
            }
        }

        @Override // eb6.a
        public void b(String str) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements VideoStateChangeListener {
        public k() {
        }

        @Override // com.zenmen.media.player.VideoStateChangeListener
        public void onVideoCompleted() {
            VideoViewFragment.this.o = true;
            if (VideoViewFragment.this.t != null) {
                VideoViewFragment.this.z.setVisibility(0);
                gr2.j().h(VideoViewFragment.n0(VideoViewFragment.this.t), VideoViewFragment.this.z, bq6.z());
                VideoViewFragment.this.A.setVisibility(0);
                VideoViewFragment.this.B.setVisibility(8);
                VideoViewFragment.this.j.removeMessages(17);
                VideoViewFragment.this.j.sendEmptyMessage(18);
            }
            VideoViewFragment.this.C0(false);
            if (VideoViewFragment.this.l != null) {
                VideoViewFragment.this.l.abandonAudioFocus();
            }
        }

        @Override // com.zenmen.media.player.VideoStateChangeListener
        public void onVideoError(IMagicMediaPlayer iMagicMediaPlayer, int i) {
            LogUtil.onClickEvent("V38", "2", null);
        }

        @Override // com.zenmen.media.player.VideoStateChangeListener
        public void onVideoStarted(IMagicMediaPlayer iMagicMediaPlayer) {
            if (VideoViewFragment.this.f == 1) {
                VideoViewFragment.this.j.sendEmptyMessage(17);
            }
        }

        @Override // com.zenmen.media.player.VideoStateChangeListener
        public void onVideoFirstFrame(IMagicMediaPlayer iMagicMediaPlayer) {
        }

        @Override // com.zenmen.media.player.VideoStateChangeListener
        public void onVideoStopped(IMagicMediaPlayer iMagicMediaPlayer) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements eb6.a {
        public l() {
        }

        @Override // eb6.a
        public void a(String str, String str2) {
            if (VideoViewFragment.this.m != null) {
                VideoViewFragment.this.m.a(str, str2);
            }
        }

        @Override // eb6.a
        public void b(String str) {
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i2) {
    }
}
