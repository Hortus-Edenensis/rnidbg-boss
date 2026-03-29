package com.zenmen.palmchat.friendcircle.video;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.media.player.MediaPlayerNotificationInfo;
import com.zenmen.media.player.OnStateChangeListener;
import com.zenmen.media.player.ZMAudioFocusMgr;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.video.a;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.photoview.PhotoViewActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import com.zenmen.palmchat.widget.DownloadProgressBar;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.ds0;
import defpackage.g22;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hr2;
import defpackage.hx3;
import defpackage.i9;
import defpackage.je1;
import defpackage.jr2;
import defpackage.k86;
import defpackage.lq3;
import defpackage.me1;
import defpackage.pu1;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.st1;
import defpackage.sy5;
import defpackage.td3;
import defpackage.tg4;
import defpackage.tq3;
import defpackage.uq3;
import defpackage.v4;
import defpackage.we6;
import defpackage.xm;
import defpackage.xm3;
import defpackage.yy2;
import defpackage.zq3;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VideoViewFragment extends Fragment implements AudioManager.OnAudioFocusChangeListener {
    public static final String E = "VideoViewFragment";
    public FeedBean e;
    public int f;
    public int g;
    public int i;
    public AspectRatioFrameLayout j;
    public MagicTextureMediaPlayer k;
    public ImageView l;
    public ImageView m;
    public DownloadProgressBar n;
    public long p;
    public a.b q;
    public String r;
    public boolean s;
    public ProgressBar t;
    public View u;
    public ZMAudioFocusMgr w;
    public String x;
    public MediaItem d = new MediaItem();
    public boolean h = true;
    public boolean o = false;
    public boolean v = false;
    public jr2 y = new d();
    public View.OnClickListener z = new e();
    public OnStateChangeListener A = new f();
    public a.b B = new g();
    public View.OnLongClickListener C = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14032a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.friendcircle.video.VideoViewFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ViewOnClickListenerC1049a implements View.OnClickListener {
            public ViewOnClickListenerC1049a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoViewFragment.this.getActivity().finish();
            }
        }

        public a(View view) {
            this.f14032a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14032a.setOnClickListener(new ViewOnClickListenerC1049a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a.b f14034a = new C1050b();

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {
            public a() {
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    b.this.h();
                } else if (i == 1) {
                    b.this.g();
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.friendcircle.video.VideoViewFragment$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1050b implements a.b {

            /* JADX INFO: renamed from: com.zenmen.palmchat.friendcircle.video.VideoViewFragment$b$b$a */
            /* JADX INFO: compiled from: SearchBox */
            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f14037a;

                public a(String str) {
                    this.f14037a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(this.f14037a);
                    if (file.exists()) {
                        b.this.i(this.f14037a, file);
                    }
                }
            }

            public C1050b() {
            }

            @Override // com.zenmen.palmchat.friendcircle.video.a.b
            public void a(String str, String str2) {
                LogUtil.i(VideoViewFragment.E, "onDownloadingComplete, path = " + str2);
                VideoViewFragment.this.l0().runOnUiThread(new a(str2));
            }

            @Override // com.zenmen.palmchat.friendcircle.video.a.b
            public void b(String str) {
                LogUtil.i(VideoViewFragment.E, "onDownloadingStarted, mid = " + str);
            }

            @Override // com.zenmen.palmchat.friendcircle.video.a.b
            public void g(Exception exc) {
                LogUtil.i(VideoViewFragment.E, "onDownloadFail, Exception = " + exc);
            }

            @Override // com.zenmen.palmchat.friendcircle.video.a.b
            public void i(int i) {
                LogUtil.i(VideoViewFragment.E, "onDownloading, progress = " + i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends AsyncTask<Void, Void, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14038a;
            public final /* synthetic */ File b;
            public final /* synthetic */ File c;
            public final /* synthetic */ String d;

            public c(String str, File file, File file2, String str2) {
                this.f14038a = str;
                this.b = file;
                this.c = file2;
                this.d = str2;
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(Void... voidArr) throws Throwable {
                boolean zF;
                if (TextUtils.isEmpty(this.f14038a) || !new File(this.f14038a).exists()) {
                    File file = this.c;
                    zF = (file == null || !file.exists()) ? false : pu1.f(this.c, this.b);
                } else {
                    zF = pu1.f(new File(this.f14038a), this.b);
                }
                return Boolean.valueOf(zF);
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                super.onPostExecute(bool);
                if (bool.booleanValue()) {
                    xm3.a(this.d);
                    if (VideoViewFragment.this.getActivity() == null || !VideoViewFragment.this.isAdded()) {
                        return;
                    }
                    sy5.f(VideoViewFragment.this.l0(), VideoViewFragment.this.getResources().getString(R$string.save_video_to_dir, pu1.m()), 1).g();
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends MaterialDialog.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Feed f14039a;

            public d(Feed feed) {
                this.f14039a = feed;
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                b.this.f(this.f14039a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements FeedNetDao.FeedNetListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Feed f14040a;

            public e(Feed feed) {
                this.f14040a = feed;
            }

            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            public void onFail(Exception exc) {
                if (VideoViewFragment.this.l0() != null) {
                    VideoViewFragment.this.l0().hideBaseProgressBar();
                    uq3.a(VideoViewFragment.this.l0());
                }
                Log.d(VideoViewFragment.E, "deleteFeed fail, error is " + exc.toString());
            }

            @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
            public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
                if (VideoViewFragment.this.l0() == null) {
                    return;
                }
                VideoViewFragment.this.l0().hideBaseProgressBar();
                if (netResponse == null) {
                    uq3.a(VideoViewFragment.this.l0());
                    Log.d(VideoViewFragment.E, "deleteFeed fail, oriData is null");
                    return;
                }
                if (netResponse.resultCode == 0) {
                    tq3.e().b(this.f14040a);
                    if (VideoViewFragment.this.l0() != null) {
                        VideoViewFragment.this.l0().b2(this.f14040a.getFeedId().longValue());
                    }
                    lq3.f(this.f14040a);
                    return;
                }
                uq3.a(VideoViewFragment.this.l0());
                Log.d(VideoViewFragment.E, "deleteFeed fail, resultCode is " + netResponse.resultCode);
            }
        }

        public b() {
        }

        public void e(String str, File file, File file2, String str2) {
            new c(str, file2, file, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        public final void f(Feed feed) {
            try {
                VideoViewFragment.this.l0().showBaseProgressBar(R$string.deleting, false);
            } catch (NullPointerException unused) {
            }
            if (feed.getStatus() != tq3.h && feed.getStatus() != tq3.g) {
                FeedNetDao.deleteFeed(feed.getFeedId().longValue(), feed.getFeedSource(), new e(feed));
                return;
            }
            LogUtil.i(VideoViewFragment.E, "deleteMoments from local");
            if (VideoViewFragment.this.l0() != null) {
                VideoViewFragment.this.l0().hideBaseProgressBar();
            }
            tq3.e().b(feed);
            zq3.l().s(feed);
            VideoViewFragment.this.l0().b2(feed.getFeedId().longValue());
            if (feed.getStatus() == tq3.h) {
                LocalBroadcastManager.getInstance(VideoViewFragment.this.getContext()).sendBroadcast(new Intent(tq3.k));
            }
            lq3.f(feed);
        }

        public final void g() {
            Feed feedH = st1.f().h(VideoViewFragment.this.e.getFeedId());
            if (feedH == null) {
                feedH = i9.d().e(VideoViewFragment.this.e.getUid(), VideoViewFragment.this.e.getFeedId());
            }
            if (feedH == null) {
                LogUtil.i(VideoViewFragment.E, "deleteFeed feed is null");
            } else {
                new sd3(VideoViewFragment.this.l0()).j(R$string.string_dialog_content_delete_video).O(R$string.string_dialog_positive).M(VideoViewFragment.this.getResources().getColor(R$color.color_e6433e)).K(R$string.string_dialog_negative).I(VideoViewFragment.this.getResources().getColor(R$color.color_7e7e7e)).f(new d(feedH)).e().show();
            }
        }

        public final void h() {
            if (VideoViewFragment.this.m0() != null) {
                FragmentActivity activity = VideoViewFragment.this.getActivity();
                BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
                if (!tg4.b(activity, permissionType.permissionList)) {
                    BaseActivityPermissionDispatcher.b(VideoViewFragment.this.m0(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
                    return;
                }
            }
            if (VideoViewFragment.this.d.localPath == null) {
                VideoViewFragment.this.u0(this.f14034a);
                return;
            }
            File file = new File(VideoViewFragment.this.d.localPath);
            if (file.exists()) {
                i(VideoViewFragment.this.d.localPath, file);
            }
        }

        public final void i(String str, File file) {
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
                e(str, file, file3, str3);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!VideoViewFragment.this.s) {
                return true;
            }
            new td3.c(VideoViewFragment.this.l0()).c(VideoViewFragment.this.e.getUid().equals(v4.e(com.zenmen.palmchat.c.b())) ? new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone), com.zenmen.palmchat.c.b().getResources().getString(R$string.delete)} : new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)}).d(new a()).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = VideoViewFragment.this.getActivity();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
            if (tg4.b(activity, permissionType.permissionList)) {
                VideoViewFragment.this.x0();
            } else {
                BaseActivityPermissionDispatcher.b(VideoViewFragment.this.m0(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements jr2 {
        public d() {
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            VideoViewFragment.this.t.setVisibility(8);
            VideoViewFragment.this.u.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            VideoViewFragment.this.t.setVisibility(8);
            VideoViewFragment.this.u.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            VideoViewFragment.this.t.setVisibility(8);
            VideoViewFragment.this.u.setVisibility(8);
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            VideoViewFragment.this.t.setVisibility(0);
            VideoViewFragment.this.u.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = VideoViewFragment.E;
            LogUtil.i(str, "onClick ");
            LogUtil.i(str, "onViewTap ");
            if (VideoViewFragment.this.l0().Z1()) {
                VideoViewFragment.this.l0().u2();
            } else {
                VideoViewFragment.this.l0().finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements a.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "view_video_feed");
                put("status", WfConstant.EVENT_ID_DOWNLOAD_START);
                put("type", 3);
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14049a;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {
                public a() {
                    put("action", "view_video_feed");
                    put("status", "view_succ");
                    put("type", 3);
                    put(TKDownloadReason.KSAD_TK_NET, hx3.h());
                }
            }

            public b(String str) {
                this.f14049a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (new File(this.f14049a).exists()) {
                    VideoViewFragment.this.k.setVideo(this.f14049a);
                    int iJ2 = VideoViewFragment.this.g;
                    if (VideoViewFragment.this.getActivity() != null) {
                        iJ2 = ((PhotoViewActivity) VideoViewFragment.this.getActivity()).j2();
                    }
                    String str = VideoViewFragment.E;
                    LogUtil.i(str, "onDownloadingComplete  initPosition = " + VideoViewFragment.this.g + ", mPosition = " + VideoViewFragment.this.f + ", currentIndex= " + iJ2);
                    if (VideoViewFragment.this.f == iJ2) {
                        VideoViewFragment.this.k.start();
                        VideoViewFragment.this.k.mute(false);
                    } else {
                        VideoViewFragment.this.k.pause();
                        VideoViewFragment.this.k.mute(true);
                    }
                    LogUtil.i(str, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
                    VideoViewFragment.this.l.setVisibility(8);
                    hc2.a(VideoViewFragment.this.l.getContext()).clear(VideoViewFragment.this.l);
                    VideoViewFragment.this.n.setVisibility(8);
                    VideoViewFragment.this.m.setVisibility(8);
                    VideoViewFragment.this.t0(this.f14049a);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f14051a;

            public c(int i) {
                this.f14051a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoViewFragment.this.n.setProgress(this.f14051a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {
            public d() {
                put("action", "view_video_feed");
                put("status", WfConstant.EVENT_ID_DOWNLOAD_FAIL);
                put("type", 3);
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        public g() {
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void a(String str, String str2) {
            LogUtil.i(VideoViewFragment.E, "onDownloadingComplete, path = " + str2);
            VideoViewFragment.this.getActivity().runOnUiThread(new b(str2));
            if (VideoViewFragment.this.q != null) {
                VideoViewFragment.this.q.a(str, str2);
            }
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void b(String str) {
            String str2 = VideoViewFragment.E;
            LogUtil.i(str2, "onDownloadingStarted, mid = " + str);
            if (VideoViewFragment.this.q != null) {
                VideoViewFragment.this.q.b(str);
            }
            LogUtil.i(str2, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void g(Exception exc) {
            VideoViewFragment.this.w0(true);
            String str = VideoViewFragment.E;
            LogUtil.i(str, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new d(), (Throwable) null);
            LogUtil.i(str, "onDownloadFail e = " + exc);
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void i(int i) {
            LogUtil.i(VideoViewFragment.E, "onDownloading, progress = " + i);
            VideoViewFragment.this.getActivity().runOnUiThread(new c(i));
            if (VideoViewFragment.this.q != null) {
                VideoViewFragment.this.q.i(i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14053a;

        public h(boolean z) {
            this.f14053a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoViewFragment.this.isAdded()) {
                if (this.f14053a && tg4.b(VideoViewFragment.this.getActivity(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
                    sy5.f(VideoViewFragment.this.l0(), com.zenmen.palmchat.c.b().getResources().getString(R$string.download_video_fail), 1).g();
                }
                VideoViewFragment.this.m.setVisibility(0);
                VideoViewFragment.this.n.setVisibility(8);
                VideoViewFragment.this.m.setImageResource(R$drawable.video_error);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xm f14054a;

        public i(xm xmVar) {
            this.f14054a = xmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            xm xmVar = this.f14054a;
            if (xmVar == null || xmVar.a() != 3) {
                return;
            }
            VideoViewFragment.this.r0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g22 f14055a;

        public j(g22 g22Var) {
            this.f14055a = g22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14055a.a() != VideoViewFragment.this.f) {
                VideoViewFragment.this.r0();
            } else {
                VideoViewFragment.this.s0();
                VideoViewFragment.this.k.start();
            }
        }
    }

    public final void k0() {
        LogUtil.i(E, "downLoadVideo");
        this.l.setVisibility(0);
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        MediaItem mediaItem = this.d;
        if (mediaItem.mid == null) {
            mediaItem.mid = String.valueOf(this.e.getFeedId());
        }
        com.zenmen.palmchat.friendcircle.video.a aVarC = com.zenmen.palmchat.friendcircle.video.a.c();
        FragmentActivity activity = getActivity();
        MediaItem mediaItem2 = this.d;
        aVarC.a(activity, mediaItem2.mid, mediaItem2.fileFullPath, mediaItem2.thumbnailPath, this.B);
    }

    public final PhotoViewActivity l0() {
        return (PhotoViewActivity) getActivity();
    }

    public final PhotoViewActivity m0() {
        if (getActivity() != null) {
            return (PhotoViewActivity) getActivity();
        }
        return null;
    }

    public final int n0() {
        return R$layout.activity_sight_video;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f == this.g) {
            BaseActivityPermissionDispatcher.b(m0(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
        }
    }

    @qm5
    public void onAutoPlayEvent(xm xmVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new i(xmVar));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = (FeedBean) getArguments().getParcelable(SquareDetailVideoView.KEY_ITEM);
        this.f = getArguments().getInt(SquareDetailVideoView.KEY_POSITION);
        this.g = getArguments().getInt(SquareDetailVideoView.KEY_INIT_POSITION);
        this.i = getArguments().getInt(SquareDetailVideoView.KEY_VIDEO_POSITION, 0);
        if (this.f == this.g) {
            this.h = false;
        }
        this.d = this.e.getMediaItem();
        this.r = getArguments().getString("KEY_FROM");
        this.s = getArguments().getBoolean("long_click");
        ds0.a().c(this);
        LogUtil.i(E, " onCreate mPosition = " + this.f + ", initPosition = " + this.g + ", this = " + this);
        try {
            this.w = new ZMAudioFocusMgr(getActivity(), this, 3, 2);
            if (this.f == this.g && "from_only_preview".equals(this.r)) {
                we6.a(getActivity());
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(n0(), (ViewGroup) null);
        viewInflate.postDelayed(new a(viewInflate), 500L);
        this.l = (ImageView) viewInflate.findViewById(R$id.video_thumbnail);
        this.m = (ImageView) viewInflate.findViewById(R$id.video_play);
        this.n = (DownloadProgressBar) viewInflate.findViewById(R$id.status_downloading);
        this.k = (MagicTextureMediaPlayer) viewInflate.findViewById(R$id.video);
        this.j = (AspectRatioFrameLayout) viewInflate.findViewById(R$id.video_content);
        this.l.setVisibility(0);
        je1 je1VarL = hr2.l();
        MediaItem mediaItem = this.d;
        String str = mediaItem.thumbnailPath;
        if (mediaItem.localThumbPath != null && new File(this.d.localThumbPath).exists()) {
            str = this.d.localThumbPath;
        }
        this.t = (ProgressBar) viewInflate.findViewById(R$id.prsbar);
        this.u = viewInflate.findViewById(R$id.mask);
        gr2.j().i(k86.p(str), this.l, je1VarL, this.y);
        this.k.setOnStateChangeListener(this.A);
        this.k.setFixedSize(true);
        if (this.i > 0) {
            LogUtil.d("logvideof", "player: seek=" + this.i);
            this.k.forceSeek((long) this.i);
            this.i = 0;
        }
        FeedBean feedBean = this.e;
        if (feedBean != null && this.j != null) {
            int i2 = feedBean.getWidth() != null ? Integer.parseInt(this.e.getWidth()) : 0;
            int i3 = this.e.getHeight() != null ? Integer.parseInt(this.e.getHeight()) : 0;
            int iG = me1.g();
            int iF = me1.f();
            if (i2 > 0 && i3 > 0 && iG > 0 && iF > 0) {
                this.j.setAspectRatio((i2 * 1.0f) / i3);
                this.j.setResizeMode(1);
            }
        }
        if (l0().Y1()) {
            this.k.setOnLongClickListener(this.C);
        }
        this.k.setOnClickListener(this.z);
        x0();
        this.m.setOnClickListener(new c());
        this.m.setVisibility(8);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.k;
        if (magicTextureMediaPlayer != null) {
            magicTextureMediaPlayer.release();
        }
    }

    @qm5
    public void onFragmentChanged(g22 g22Var) {
        LogUtil.i(E, "onFragmentChanged, postion = " + g22Var.a() + ", mPosition = " + this.f + ",mInitPosition = " + this.g + ",this =  " + this);
        getActivity().runOnUiThread(new j(g22Var));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        r0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        s0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.o) {
            this.p = System.currentTimeMillis();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public final String p0(MediaItem mediaItem) {
        if (mediaItem == null || TextUtils.isEmpty(mediaItem.fileFullPath)) {
            return null;
        }
        return pu1.l + File.separator + rb3.c(mediaItem.fileFullPath);
    }

    public final void r0() {
        LogUtil.d("logvideof", "pausePlayer: " + this.v);
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.k;
        if (magicTextureMediaPlayer == null) {
            return;
        }
        if (magicTextureMediaPlayer.isPlaying()) {
            this.k.pause();
            this.v = true;
        }
        this.h = true;
        ZMAudioFocusMgr zMAudioFocusMgr = this.w;
        if (zMAudioFocusMgr != null) {
            zMAudioFocusMgr.abandonAudioFocus();
        }
        this.k.mute(true);
    }

    public final void s0() {
        LogUtil.d("logvideof", "host: resume=" + this.v);
        MagicTextureMediaPlayer magicTextureMediaPlayer = this.k;
        if (magicTextureMediaPlayer == null) {
            return;
        }
        if (this.v) {
            this.v = false;
            magicTextureMediaPlayer.pause();
        }
        this.h = false;
        ZMAudioFocusMgr zMAudioFocusMgr = this.w;
        if (zMAudioFocusMgr != null) {
            zMAudioFocusMgr.requestAudioFocuse();
        }
        this.k.mute(false);
    }

    public final void t0(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            if (this.e != null) {
                Feed feedH = st1.f().h(this.e.getFeedId());
                if (feedH == null) {
                    feedH = i9.d().e(this.e.getUid(), this.e.getFeedId());
                }
                if (feedH != null && feedH.getMediaList() != null && feedH.getMediaList().size() > 0) {
                    feedH.getMediaList().get(0).localPath = str;
                    tq3.e().m(feedH, true, false);
                }
            }
            MediaItem mediaItem = this.d;
            if (mediaItem != null) {
                mediaItem.localPath = str;
            }
        }
    }

    public void u0(a.b bVar) {
        this.q = bVar;
    }

    public final void w0(boolean z) {
        if (l0() != null) {
            l0().runOnUiThread(new h(z));
        }
    }

    public final void x0() {
        String strP0;
        String str = E;
        LogUtil.i(str, "startPlayVideo");
        if (this.d != null) {
            String str2 = null;
            String str3 = com.zenmen.palmchat.friendcircle.video.a.c().b(this.d.localPath) ? this.d.localPath : null;
            if (TextUtils.isEmpty(str3)) {
                MediaItem mediaItem = this.d;
                String str4 = mediaItem.fileFullPath;
                strP0 = p0(mediaItem);
                str2 = str4;
            } else {
                strP0 = null;
            }
            if (!((TextUtils.isEmpty(str3) && (TextUtils.isEmpty(str2) || TextUtils.isEmpty(strP0))) ? false : true)) {
                k0();
                return;
            }
            if (TextUtils.isEmpty(str3)) {
                LogUtil.d("logvideof", "host: stream url=" + str2 + ", cache=" + strP0);
                this.k.setCachePath(strP0);
                this.k.setVideo(str2);
                this.n.setVisibility(0);
                this.x = strP0;
            } else {
                LogUtil.d("logvideof", "host: local path=" + str3);
                this.k.setVideo(str3);
            }
            this.l.setVisibility(8);
            hc2.a(this.l.getContext()).clear(this.l);
            int iJ2 = this.g;
            if (getActivity() != null) {
                iJ2 = ((PhotoViewActivity) getActivity()).j2();
            }
            LogUtil.i(str, "startPlayVideo  initPosition = " + this.g + ", mPosition = " + this.f + ", currentIndex= " + iJ2);
            if (this.f == iJ2) {
                this.k.start();
                this.k.mute(false);
            } else {
                this.k.pause();
                this.k.mute(true);
            }
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i2) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements OnStateChangeListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "view_video_feed");
                put("status", "view_succ");
                put("type", 3);
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "view_video_feed");
                put("status", "play_fail");
                put("type", 3);
                put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            }
        }

        public f() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferFinished() {
            VideoViewFragment.this.n.setVisibility(8);
            VideoViewFragment videoViewFragment = VideoViewFragment.this;
            videoViewFragment.t0(videoViewFragment.x);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingDone() {
            VideoViewFragment.this.n.setVisibility(8);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onBufferingStarted() {
            VideoViewFragment.this.n.setVisibility(0);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            LogUtil.i(VideoViewFragment.E, "onVideoCompleted");
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onError(int i, int i2, MediaPlayerNotificationInfo mediaPlayerNotificationInfo) {
            LogUtil.i(VideoViewFragment.E, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            if ("from_only_preview".equals(VideoViewFragment.this.r)) {
                JSONObject jSONObject = new JSONObject();
                if (VideoViewFragment.this.e != null) {
                    try {
                        jSONObject.put("feed_id", VideoViewFragment.this.e.getFeedId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                LogUtil.onClickEvent("M35", "2", jSONObject.toString());
            }
            VideoViewFragment.this.w0(false);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            LogUtil.i(VideoViewFragment.E, "onFragmentChanged onVideoStarted  initPosition = " + VideoViewFragment.this.g + ", postion = " + VideoViewFragment.this.f);
            if (VideoViewFragment.this.f == VideoViewFragment.this.g) {
                VideoViewFragment.this.k.mute(false);
            }
            if ("from_only_preview".equals(VideoViewFragment.this.r)) {
                JSONObject jSONObject = new JSONObject();
                if (VideoViewFragment.this.e != null) {
                    try {
                        jSONObject.put("feed_id", VideoViewFragment.this.e.getFeedId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                LogUtil.onClickEvent("M35", "1", jSONObject.toString());
            }
            LogUtil.i(VideoViewFragment.E, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
            VideoViewFragment.this.n.setVisibility(8);
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onSeekCompleted() {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
        }

        @Override // com.zenmen.media.player.OnStateChangeListener
        public void onVideoFormatchanged(int i, int i2) {
        }
    }
}
