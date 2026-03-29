package com.zenmen.palmchat.photoview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.baidu.platform.comapi.map.MapController;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.R$menu;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.friendcircle.video.VideoViewFragment;
import com.zenmen.palmchat.friendcircle.video.a;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.photoview.a;
import com.zenmen.palmchat.publish.CommentActivity;
import com.zenmen.palmchat.ui.widget.FeedBottomBannerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cy5;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.g22;
import defpackage.i9;
import defpackage.is0;
import defpackage.j23;
import defpackage.k23;
import defpackage.lq3;
import defpackage.me1;
import defpackage.pu1;
import defpackage.px5;
import defpackage.sd1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.td3;
import defpackage.tg4;
import defpackage.tk3;
import defpackage.tq3;
import defpackage.uq3;
import defpackage.x64;
import defpackage.xm;
import defpackage.xm3;
import defpackage.yy2;
import defpackage.yy3;
import defpackage.zq3;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhotoViewActivity extends FrameworkBaseActivity {
    public static final String V = "PhotoViewActivity";
    public RelativeLayout A;
    public LinearLayout B;
    public PhotoViewFragmentAdapter C;
    public String F;
    public Rect L;
    public int M;
    public AnimatorSet N;
    public com.zenmen.palmchat.photoview.a S;
    public View q;
    public ViewPager r;
    public int s;
    public int t;
    public boolean u;
    public Toolbar v;
    public TextView w;
    public TextView x;
    public FeedBottomBannerView y;
    public View z;
    public String[] E = {com.zenmen.palmchat.c.b().getResources().getString(R$string.select_from_album), com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)};
    public boolean G = false;
    public boolean H = false;
    public boolean I = true;
    public boolean J = false;
    public ArrayList<FeedBean> K = new ArrayList<>();
    public boolean O = false;
    public boolean P = false;
    public boolean Q = true;
    public s R = new s(this);
    public a.b T = new c();
    public is0.f U = new h();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements td3.f {
        public a() {
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                PhotoViewActivity.this.q2();
            } else if (i == 1) {
                PhotoViewActivity.this.e2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements td3.f {
        public b() {
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (i == 0) {
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.g2(((FeedBean) photoViewActivity.K.get(PhotoViewActivity.this.t)).getMediaItem());
                return;
            }
            if (i != 1) {
                if (i == 2) {
                    PhotoViewActivity.this.d2();
                    return;
                }
                return;
            }
            try {
                File fileB = TextUtils.isEmpty(((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().fileFullPath) ? sd1.b(((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().localPath) : sd1.b(((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().fileFullPath);
                PhotoViewActivity photoViewActivity2 = PhotoViewActivity.this;
                photoViewActivity2.p2(((FeedBean) photoViewActivity2.K.get(PhotoViewActivity.this.t)).getMediaItem().localPath, fileB);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14994a;

            public a(String str) {
                this.f14994a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                File file = new File(this.f14994a);
                if (file.exists()) {
                    PhotoViewActivity.this.r2(this.f14994a, file);
                }
            }
        }

        public c() {
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void a(String str, String str2) {
            LogUtil.i(PhotoViewActivity.V, "onDownloadingComplete, path = " + str2);
            PhotoViewActivity.this.runOnUiThread(new a(str2));
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void b(String str) {
            LogUtil.i(PhotoViewActivity.V, "onDownloadingStarted, mid = " + str);
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void g(Exception exc) {
            LogUtil.i(PhotoViewActivity.V, "onDownloadFail, Exception = " + exc);
        }

        @Override // com.zenmen.palmchat.friendcircle.video.a.b
        public void i(int i) {
            LogUtil.i(PhotoViewActivity.V, "onDownloading, progress = " + i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14995a;
        public final /* synthetic */ File b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        public d(String str, File file, File file2, String str2) {
            this.f14995a = str;
            this.b = file;
            this.c = file2;
            this.d = str2;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            boolean zF;
            if (TextUtils.isEmpty(this.f14995a) || !new File(this.f14995a).exists()) {
                File file = this.c;
                zF = (file == null || !file.exists()) ? false : pu1.f(this.c, this.b);
            } else {
                zF = pu1.f(new File(this.f14995a), this.b);
            }
            return Boolean.valueOf(zF);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                xm3.a(this.d);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                sy5.f(photoViewActivity, photoViewActivity.getResources().getString(R$string.save_video_to_dir, pu1.m()), 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f14996a;

        public e(Feed feed) {
            this.f14996a = feed;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            PhotoViewActivity.this.a2(this.f14996a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f14997a;

        public f(Feed feed) {
            this.f14997a = feed;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            PhotoViewActivity.this.a2(this.f14997a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Feed f14998a;

        public g(Feed feed) {
            this.f14998a = feed;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            PhotoViewActivity.this.hideBaseProgressBar();
            uq3.a(PhotoViewActivity.this);
            Log.d(PhotoViewActivity.V, "deleteFeed fail, error is " + exc.toString());
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            PhotoViewActivity.this.hideBaseProgressBar();
            if (netResponse == null) {
                uq3.a(PhotoViewActivity.this);
                Log.d(PhotoViewActivity.V, "deleteFeed fail, oriData is null");
                return;
            }
            if (netResponse.resultCode == 0) {
                tq3.e().b(this.f14998a);
                PhotoViewActivity.this.b2(this.f14998a.getFeedId().longValue());
                lq3.f(this.f14998a);
            } else {
                uq3.a(PhotoViewActivity.this);
                Log.d(PhotoViewActivity.V, "deleteFeed fail, resultCode is " + netResponse.resultCode);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements is0.f {
        public h() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 1) {
                return;
            }
            if (((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().fileFullPath == null && ((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().localPath == null) {
                return;
            }
            try {
                File fileB = sd1.b(((FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t)).getMediaItem().fileFullPath);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.p2(((FeedBean) photoViewActivity.K.get(PhotoViewActivity.this.t)).getMediaItem().localPath, fileB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PhotoViewActivity.this.C = new PhotoViewFragmentAdapter(PhotoViewActivity.this.getSupportFragmentManager(), PhotoViewActivity.this.K, PhotoViewActivity.this.u, PhotoViewActivity.this.F);
                PhotoViewActivity.this.r.setAdapter(PhotoViewActivity.this.C);
                PhotoViewActivity.this.C.f(PhotoViewActivity.this.t);
                PhotoViewActivity.this.r.setCurrentItem(PhotoViewActivity.this.t, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnLayoutChangeListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PhotoViewActivity.this.s2();
            }
        }

        public k() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (PhotoViewActivity.this.O) {
                PhotoViewActivity.this.O = false;
                PhotoViewActivity.this.r.post(new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.c2(photoViewActivity.t);
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewActivity.this.K.size() == 0) {
                return;
            }
            FeedBean feedBean = (FeedBean) PhotoViewActivity.this.K.get(0);
            int i = R$string.string_dialog_content_delete_photo;
            if (feedBean.getMediaItem().mimeType == 1) {
                i = R$string.string_dialog_content_delete_video;
            }
            new sd3(PhotoViewActivity.this).T(R$string.string_dialog_title_tips).j(i).O(R$string.string_dialog_positive).K(R$string.string_dialog_negative).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements a.d {
        public o() {
        }

        @Override // com.zenmen.palmchat.photoview.a.d
        public void a(boolean z) {
            if (z) {
                PhotoViewActivity.this.y.setBottomVisibility(0);
            } else {
                PhotoViewActivity.this.y.setBottomVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends AnimatorListenerAdapter {
        public p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            xm xmVar = new xm();
            xmVar.b(2);
            ds0.a().b(xmVar);
            PhotoViewActivity.this.N = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends AnimatorListenerAdapter {
        public q() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PhotoViewActivity.super.finish();
            PhotoViewActivity.this.overridePendingTransition(0, 0);
            PhotoViewActivity.this.N = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15013a;
        public final /* synthetic */ File b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        public r(String str, File file, File file2, String str2) {
            this.f15013a = str;
            this.b = file;
            this.c = file2;
            this.d = str2;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            boolean zF;
            if (TextUtils.isEmpty(this.f15013a) || !new File(this.f15013a).exists()) {
                File file = this.c;
                zF = (file == null || !file.exists()) ? false : pu1.f(this.c, this.b);
            } else {
                zF = pu1.f(new File(this.f15013a), this.b);
            }
            return Boolean.valueOf(zF);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                xm3.a(this.d);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                sy5.f(photoViewActivity, photoViewActivity.getResources().getString(R$string.save_to_dir, pu1.m()), 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class s extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<PhotoViewActivity> f15014a;

        public s(PhotoViewActivity photoViewActivity) {
            this.f15014a = new WeakReference<>(photoViewActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
        }
    }

    public void W1(String str, File file, File file2, String str2) {
        new r(str, file2, file, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @TargetApi(11)
    public void X1(String str, File file, File file2, String str2) {
        new d(str, file2, file, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public boolean Y1() {
        return this.P;
    }

    public boolean Z1() {
        return this.Q;
    }

    public final void a2(Feed feed) {
        if (feed == null) {
            return;
        }
        showBaseProgressBar(R$string.deleting, false);
        if (feed.getStatus() != tq3.h && feed.getStatus() != tq3.g) {
            FeedNetDao.deleteFeed(feed.getFeedId().longValue(), feed.getFeedSource(), new g(feed));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M41", null, jSONObject.toString());
            return;
        }
        LogUtil.i(V, "deleteMoments from local");
        hideBaseProgressBar();
        tq3.e().b(feed);
        zq3.l().s(feed);
        b2(feed.getFeedId().longValue());
        if (feed.getStatus() == tq3.h) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(tq3.k));
        }
        lq3.f(feed);
    }

    public void b2(long j2) {
        String str = V;
        LogUtil.i(str, "deleteFeedUpdate");
        if (m2()) {
            LogUtil.i(str, "isActivityDestroyed");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (int i3 = 0; i3 < this.K.size(); i3++) {
            if (this.K.get(i3).getFeedId() != j2) {
                arrayList.add(this.K.get(i3));
            } else if (i2 == -1) {
                i2 = i3;
            }
        }
        if (arrayList.isEmpty()) {
            finish();
            return;
        }
        if (i2 > arrayList.size() - 1) {
            this.t = arrayList.size() - 1;
        } else {
            this.t = i2;
        }
        this.K.clear();
        this.K.addAll(arrayList);
        PhotoViewFragmentAdapter photoViewFragmentAdapter = new PhotoViewFragmentAdapter(getSupportFragmentManager(), this.K, this.u, this.F);
        this.C = photoViewFragmentAdapter;
        this.r.setAdapter(photoViewFragmentAdapter);
        this.r.setCurrentItem(this.t, true);
        o2(this.t);
    }

    public final void c2(int i2) {
        if (i2 >= this.K.size()) {
            return;
        }
        this.K.remove(i2);
        PhotoViewFragmentAdapter photoViewFragmentAdapter = new PhotoViewFragmentAdapter(getSupportFragmentManager(), this.K, this.u, this.F);
        this.C = photoViewFragmentAdapter;
        this.r.setAdapter(photoViewFragmentAdapter);
        if (this.K.size() != i2) {
            this.r.setCurrentItem(i2, true);
            o2(i2);
        } else {
            if (this.K.size() == 0) {
                finish();
                return;
            }
            int i3 = i2 - 1;
            this.r.setCurrentItem(i3, true);
            o2(i3);
        }
    }

    public final void d2() {
        FeedBean feedBean = this.K.get(this.t);
        Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
        if (feedF == null) {
            return;
        }
        boolean z = feedF.getMediaList().size() != 1;
        new sd3(this).j(z ? R$string.string_dialog_content_delete_photos : R$string.string_dialog_content_delete_photo).O(z ? R$string.string_dialog_positive_all_delete : R$string.string_dialog_positive).M(getResources().getColor(R$color.color_e6433e)).K(R$string.string_dialog_negative).I(getResources().getColor(R$color.color_7e7e7e)).f(new f(feedF)).e().show();
    }

    public final void e2() {
        FeedBean feedBean = this.K.get(this.t);
        new sd3(this).j(R$string.string_dialog_content_delete_video).O(R$string.string_dialog_positive).M(getResources().getColor(R$color.color_e6433e)).K(R$string.string_dialog_negative).I(getResources().getColor(R$color.color_7e7e7e)).f(new e(i9.d().f(feedBean.getUid(), feedBean.getFeedId()))).e().show();
    }

    public final boolean f2() {
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (n2()) {
            return;
        }
        if ("from_publish_preview".equals(this.F)) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_key_feeds", this.K);
            setResult(-1, intent);
        }
        if (this.L == null || this.r == null) {
            super.finish();
            return;
        }
        xm xmVar = new xm();
        xmVar.b(3);
        ds0.a().b(xmVar);
        t2();
    }

    public void g2(MediaItem mediaItem) {
        FeedBean feedBean = this.K.get(this.t);
        if (feedBean == null || TextUtils.isEmpty(mediaItem.fileFullPath) || TextUtils.isEmpty(feedBean.getWidth()) || TextUtils.isEmpty(feedBean.getHeight())) {
            return;
        }
        tk3.b(this, mediaItem.fileFullPath, Integer.valueOf(feedBean.getWidth()).intValue(), Integer.valueOf(feedBean.getHeight()).intValue());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        Intent intent = getIntent();
        if ("from_publish_comment".equals(intent != null ? intent.getStringExtra("KEY_FROM") : null)) {
            return 602;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP;
    }

    public String h2(String str, String str2) {
        return !TextUtils.isEmpty(str2) && new File(str2).exists() ? str2 : str;
    }

    public final void i2() {
        Intent intent = getIntent();
        this.F = intent.getStringExtra("KEY_FROM");
        this.s = intent.getIntExtra("selectIndex", 0);
        this.u = intent.getBooleanExtra("long_click", true);
        this.t = this.s;
        this.H = intent.getBooleanExtra("extra_key_show_comment", false);
        this.K = intent.getParcelableArrayListExtra("extra_key_feeds");
        this.G = intent.getBooleanExtra("EXTRA_KEY_FULL_WINDOW", false);
        this.I = intent.getBooleanExtra("extra_key_back", true);
        this.J = intent.getBooleanExtra("extra_key_show_delete", false);
        this.L = (Rect) intent.getParcelableExtra("extra_key_transition_rect");
        this.M = intent.getIntExtra("extra_key_video_position", 0);
    }

    public int j2() {
        return this.t;
    }

    public final void k2(int i2) {
        this.B.removeAllViews();
        if (i2 > 1) {
            for (int i3 = 0; i3 < i2; i3++) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, me1.b(this, 10), 0);
                imageView.setImageResource(R$drawable.state_ball_selector);
                imageView.setLayoutParams(layoutParams);
                if (i3 == this.s) {
                    imageView.setSelected(false);
                } else {
                    imageView.setSelected(true);
                }
                this.B.addView(imageView);
            }
        }
    }

    public final void l2() {
        yy3.a(this);
        if ("from_only_preview".equals(this.F) || "from_publish_video_only_preview".equals(this.F) || "from_square_publish_preview".equals(this.F) || "from_publish_preview".equals(this.F) || "from_publish_share".equals(this.F) || "from_publish_comment".equals(this.F)) {
            setContentView(R$layout.activity_moment_photo_preview);
        } else {
            setContentView(R$layout.activity_moment_photo_preview);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.facePagerIndicator);
        this.B = linearLayout;
        linearLayout.setVisibility(8);
        this.z = findViewById(R$id.toolbar_area);
        this.q = findViewById(R$id.background);
        this.r = (ViewPager) findViewById(R$id.viewpager);
        this.A = (RelativeLayout) findViewById(R$id.rootView);
        FeedBottomBannerView feedBottomBannerView = (FeedBottomBannerView) findViewById(R$id.view_bottom_banner);
        this.y = feedBottomBannerView;
        feedBottomBannerView.setVisibility(8);
        if ("from_only_preview".equals(this.F) || "from_square_publish_preview".equals(this.F)) {
            this.B.setVisibility(0);
            this.P = true;
            if ("from_square_publish_preview".equals(this.F)) {
                this.P = false;
            }
            this.Q = false;
            this.y.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            if (this.L != null) {
                this.O = true;
                this.r.setAlpha(0.0f);
                this.q.setAlpha(0.0f);
                this.r.addOnLayoutChangeListener(new k());
            }
            initToolbar(R$id.toolbar, "", true).setVisibility(8);
            Toolbar toolbar = (Toolbar) findViewById(R$id.toolbar1);
            this.v = toolbar;
            toolbar.setVisibility(8);
        } else if ("from_publish_video_only_preview".equals(this.F)) {
            LinearLayout linearLayout2 = this.B;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            this.P = false;
            this.Q = false;
            FeedBottomBannerView feedBottomBannerView2 = this.y;
            if (feedBottomBannerView2 != null) {
                feedBottomBannerView2.setVisibility(8);
            }
            getWindow().setFlags(1024, 1024);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, "", true);
            if (toolbarInitToolbar != null) {
                toolbarInitToolbar.setVisibility(8);
            }
            Toolbar toolbar2 = (Toolbar) findViewById(R$id.toolbar1);
            this.v = toolbar2;
            if (toolbar2 != null) {
                toolbar2.setVisibility(8);
            }
        } else if ("from_publish_preview".equals(this.F) || "from_publish_share".equals(this.F)) {
            this.P = false;
            this.Q = true;
            this.z.setVisibility(0);
            initToolbar(R$id.toolbar, "", true);
            this.v = (Toolbar) findViewById(R$id.toolbar1);
            if (f2()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
                layoutParams.setMargins(0, me1.i(this), 0, 0);
                this.z.setLayoutParams(layoutParams);
                this.S = new com.zenmen.palmchat.photoview.a(this.A, this.z);
            }
            TextView textView = (TextView) findViewById(R$id.title);
            this.x = textView;
            if (this.K != null) {
                textView.setText(String.format("%d/%d", Integer.valueOf(this.s + 1), Integer.valueOf(this.K.size())));
            }
            TextView textView2 = (TextView) findViewById(R$id.action_button);
            this.w = textView2;
            textView2.setText("删除");
            if ("from_publish_share".equals(this.F)) {
                this.w.setVisibility(8);
            }
            this.w.setOnClickListener(new l());
        } else if ("from_publish_comment".equals(this.F)) {
            this.P = true;
            this.Q = true;
            this.y.setVisibility(0);
            w2(this.t);
            this.y.setOnClickListener(new m());
            this.z.setVisibility(0);
            initToolbar(R$id.toolbar, "", true).setVisibility(8);
            this.v = (Toolbar) findViewById(R$id.toolbar1);
            int size = this.K.size();
            int i2 = this.t;
            if (size <= i2) {
                finish();
                return;
            }
            FeedBean feedBean = this.K.get(i2);
            Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
            if (feedF == null) {
                finish();
                return;
            }
            setStatusBarColor(com.zenmen.palmchat.c.a().getStatusBarColor());
            this.v.setTitle(cy5.b(feedF.getCreateDt().longValue()));
            this.v.setSubtitle(feedBean.getSubTitle());
            this.v.setNavigationIcon(R$drawable.selector_arrow_back);
            this.v.setNavigationOnClickListener(new n());
            if (f2()) {
                this.z.setPadding(0, me1.i(this), 0, 0);
                this.z.setBackgroundResource(R$drawable.ic_top_bg);
                this.S = new com.zenmen.palmchat.photoview.a(this.A, this.z);
                if (dn0.d(feedF.getUid())) {
                    this.S.f(new o());
                }
            }
        }
        ArrayList<FeedBean> arrayList = this.K;
        if (arrayList != null) {
            k2(arrayList.size());
        }
        Toolbar toolbar3 = this.v;
        if (toolbar3 != null) {
            toolbar3.setBackgroundColor(0);
            setSupportActionBar(this.v);
        }
    }

    public final boolean m2() {
        return isFinishing() || isDestroyed();
    }

    public boolean n2() {
        AnimatorSet animatorSet = this.N;
        return animatorSet != null && animatorSet.isRunning();
    }

    public final void o2(int i2) {
        this.t = i2;
        if ("from_publish_comment".equals(this.F)) {
            FeedBean feedBean = this.K.get(i2);
            Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
            if (feedF != null) {
                this.v.setTitle(cy5.b(feedF.getCreateDt().longValue()));
            }
            this.v.setSubtitle(feedBean.getSubTitle());
        } else {
            this.x.setText(String.format("%d/%d", Integer.valueOf(i2 + 1), Integer.valueOf(this.K.size())));
        }
        this.C.f(i2);
        ds0.a().b(new g22(i2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.R.postDelayed(new i(), 100L);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i2();
        l2();
        v2();
        y2();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.menu_user_album, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        px5.g();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        ArrayList<FeedBean> arrayList = this.K;
        String str = arrayList != null ? arrayList.get(this.t).getMediaItem().fileFullPath : "";
        if (str == null || TextUtils.isEmpty(str) || str.contains(MapController.DEFAULT_LAYER_TAG)) {
            showPopupMenu(this, this.v, new String[]{this.E[0]}, null, this.U, null);
            return true;
        }
        showPopupMenu(this, this.v, this.E, null, this.U, null);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R$id.menu_more_moment) {
            FeedBean feedBean = this.K.get(this.t);
            Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
            if (feedF != null && (feedF.getStatus() == tq3.g || feedF.getStatus() == tq3.h)) {
                return true;
            }
            if (feedBean.getMediaItem().mimeType == 1) {
                try {
                    new td3.c(this).c(this.J ? new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone), com.zenmen.palmchat.c.b().getResources().getString(R$string.delete)} : new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)}).d(new a()).a().b();
                } catch (Exception unused) {
                }
            } else {
                try {
                    new td3.c(this).c(this.J ? new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.string_forward), com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone), com.zenmen.palmchat.c.b().getResources().getString(R$string.delete)} : new String[]{com.zenmen.palmchat.c.b().getResources().getString(R$string.string_forward), com.zenmen.palmchat.c.b().getResources().getString(R$string.save_to_phone)}).d(new b()).a().b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        w2(this.t);
    }

    public void p2(String str, File file) throws IOException {
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        if (!tg4.b(this, permissionType.permissionList)) {
            BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
            return;
        }
        String str2 = pu1.m() + File.separator;
        String str3 = str2 + System.currentTimeMillis() + ".jpg";
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(str3);
        if (file3.exists()) {
            file3.delete();
        }
        file3.createNewFile();
        W1(str, file, file3, str3);
    }

    public final void q2() {
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        if (!tg4.b(this, permissionType.permissionList)) {
            BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
            return;
        }
        if (this.K.get(this.t).getMediaItem().localPath != null) {
            File file = new File(this.K.get(this.t).getMediaItem().localPath);
            if (file.exists()) {
                r2(this.K.get(this.t).getMediaItem().localPath, file);
                return;
            }
            return;
        }
        if (this.C.getItem(this.t) == null || !(this.C.getItem(this.t) instanceof VideoViewFragment)) {
            return;
        }
        ((VideoViewFragment) this.C.getItem(this.t)).u0(this.T);
    }

    public final void r2(String str, File file) {
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
            X1(str, file, file3, str3);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void s2() {
        float fWidth = this.L.width();
        float fHeight = this.L.height();
        float width = this.r.getWidth();
        float height = this.r.getHeight();
        if (width <= 0.0f) {
            width = Math.max(1, me1.g());
        }
        if (height <= 0.0f) {
            height = Math.max(1, me1.f());
        }
        float fMin = Math.min(1.0f, Math.max(fWidth / width, fHeight / height));
        Rect rect = this.L;
        float f2 = rect.left + (fWidth / 2.0f);
        float f3 = rect.top + (fHeight / 2.0f);
        this.r.getLocationOnScreen(new int[2]);
        this.r.setScaleX(fMin);
        this.r.setScaleY(fMin);
        this.r.setTranslationX(f2 - (r8[0] + (width / 2.0f)));
        this.r.setTranslationY(f3 - (r8[1] + (height / 2.0f)));
        this.r.setAlpha(1.0f);
        ViewPager viewPager = this.r;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewPager, PropertyValuesHolder.ofFloat("scaleX", viewPager.getScaleX(), 1.0f), PropertyValuesHolder.ofFloat("scaleY", this.r.getScaleY(), 1.0f), PropertyValuesHolder.ofFloat("translationX", this.r.getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat("translationY", this.r.getTranslationY(), 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(300L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.q, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(300L);
        AnimatorSet animatorSet = this.N;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.N = animatorSet2;
        animatorSet2.addListener(new p());
        this.N.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        this.N.setStartDelay(100L);
        this.N.setInterpolator(new DecelerateInterpolator());
        this.N.start();
    }

    public final void t2() {
        float f2;
        float f3;
        float f4;
        float fWidth = this.L.width();
        float fHeight = this.L.height();
        float width = this.r.getWidth();
        float height = this.r.getHeight();
        if (width <= 0.0f) {
            width = Math.max(1, me1.g());
        }
        if (height <= 0.0f) {
            height = Math.max(1, me1.f());
        }
        float f5 = fWidth * height;
        float f6 = fHeight * width;
        if (f5 < f6) {
            f4 = f5 / fHeight;
            f3 = fHeight / height;
            f2 = height;
        } else {
            f2 = f6 / fWidth;
            f3 = fWidth / width;
            f4 = width;
        }
        Rect rect = this.L;
        float f7 = rect.left + (fWidth / 2.0f);
        float f8 = rect.top + (fHeight / 2.0f);
        this.r.getLocationOnScreen(new int[2]);
        float f9 = (width - f4) / 2.0f;
        float f10 = (height - f2) / 2.0f;
        this.r.setClipBounds(new Rect((int) f9, (int) f10, (int) (f9 + f4), (int) (f10 + f2)));
        ViewPager viewPager = this.r;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewPager, PropertyValuesHolder.ofFloat("scaleX", viewPager.getScaleX(), f3), PropertyValuesHolder.ofFloat("scaleY", this.r.getScaleY(), f3), PropertyValuesHolder.ofFloat("translationX", this.r.getTranslationX(), f7 - (r10[0] + (width / 2.0f))), PropertyValuesHolder.ofFloat("translationY", this.r.getTranslationY(), f8 - (r10[1] + (height / 2.0f))));
        objectAnimatorOfPropertyValuesHolder.setDuration(250L);
        View view = this.q;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", view.getAlpha(), 0.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(250L);
        AnimatorSet animatorSet = this.N;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.N = animatorSet2;
        animatorSet2.addListener(new q());
        this.N.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        this.N.setInterpolator(new DecelerateInterpolator());
        this.N.start();
    }

    public void u2() {
        com.zenmen.palmchat.photoview.a aVar = this.S;
        if (aVar != null) {
            aVar.h();
        }
    }

    public final void v2() {
        TextView textView = (TextView) findViewById(R$id.title);
        this.x = textView;
        if (this.K != null) {
            textView.setText(String.format("%d/%d", Integer.valueOf(this.s + 1), Integer.valueOf(this.K.size())));
        }
        TextView textView2 = (TextView) findViewById(R$id.action_button);
        this.w = textView2;
        textView2.setText("删除");
    }

    public final void w2(int i2) {
        ArrayList<FeedBean> arrayList;
        if (!"from_publish_comment".equals(this.F) || (arrayList = this.K) == null || i2 >= arrayList.size()) {
            return;
        }
        FeedBean feedBean = this.K.get(i2);
        Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
        if (feedF == null) {
            finish();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (feedF.getLikesList() != null) {
            for (Comment comment : feedF.getLikesList()) {
                if (dn0.d(comment.getFromUid())) {
                    arrayList2.add(comment);
                }
            }
        }
        if (feedF.getCommentList() != null) {
            for (Comment comment2 : feedF.getCommentList()) {
                if (dn0.d(comment2.getFromUid())) {
                    arrayList3.add(comment2);
                }
            }
        }
        this.y.initData(feedF.getContent(), j23.b(feedF), arrayList2.size(), arrayList3.size());
        if (!dn0.d(feedF.getUid())) {
            this.y.setBottomVisibility(8);
        }
        if (feedF.getStatus() == tq3.h) {
            this.y.showSendFail(true);
        } else {
            this.y.showSendFail(false);
        }
    }

    public final void x2(int i2) {
        for (int i3 = 0; i3 < this.B.getChildCount(); i3++) {
            View childAt = this.B.getChildAt(i3);
            if (i3 == i2) {
                childAt.setSelected(false);
            } else {
                childAt.setSelected(true);
            }
        }
    }

    public final void y2() {
        PhotoViewFragmentAdapter photoViewFragmentAdapter = new PhotoViewFragmentAdapter(getSupportFragmentManager(), this.K, this.u, this.F);
        this.C = photoViewFragmentAdapter;
        photoViewFragmentAdapter.f(this.s);
        this.C.g(this.M);
        this.r.setAdapter(this.C);
        this.r.setCurrentItem(this.s, true);
        this.r.setPageMargin(me1.b(this, 17));
        this.r.addOnPageChangeListener(new j());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements FeedBottomBannerView.d {
        public m() {
        }

        @Override // com.zenmen.palmchat.ui.widget.FeedBottomBannerView.d
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 3);
                jSONObject.put("type", 1);
            } catch (Exception unused) {
            }
            if (PhotoViewActivity.this.K == null || PhotoViewActivity.this.K.size() == 0) {
                return;
            }
            LogUtil.uploadInfoImmediate("M242", "1", null, jSONObject.toString());
            FeedBean feedBean = (FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t);
            Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
            if (feedF == null || feedF.getStatus() == tq3.g || feedF.getStatus() == tq3.h) {
                return;
            }
            Intent intent = new Intent(PhotoViewActivity.this, (Class<?>) CommentActivity.class);
            intent.putExtra("extra_feed_bean", (Parcelable) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t));
            PhotoViewActivity.this.startActivity(intent);
        }

        @Override // com.zenmen.palmchat.ui.widget.FeedBottomBannerView.d
        public void c() {
            if (PhotoViewActivity.this.K == null || PhotoViewActivity.this.K.size() == 0) {
                return;
            }
            FeedBean feedBean = (FeedBean) PhotoViewActivity.this.K.get(PhotoViewActivity.this.t);
            Feed feedF = i9.d().f(feedBean.getUid(), feedBean.getFeedId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 3);
                jSONObject.put("type", (feedF == null || !j23.b(feedF)) ? 1 : 2);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M241", "1", null, jSONObject.toString());
            if (feedF == null || feedF.getStatus() == tq3.g || feedF.getStatus() == tq3.h) {
                return;
            }
            k23 k23Var = new k23(PhotoViewActivity.this);
            if (j23.b(feedF)) {
                k23Var.c(feedF, Long.valueOf(j23.a(feedF)), new a());
            } else {
                k23Var.b(feedF, new b());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements x64 {
            public a() {
            }

            @Override // defpackage.x64
            public void a(NetResponseData netResponseData) {
                tq3.e().k(netResponseData);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.w2(photoViewActivity.t);
            }

            @Override // defpackage.x64
            public void b(NetResponseData netResponseData) {
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements x64 {
            public b() {
            }

            @Override // defpackage.x64
            public void b(NetResponseData netResponseData) {
                tq3.e().k(netResponseData);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.w2(photoViewActivity.t);
            }

            @Override // defpackage.x64
            public void a(NetResponseData netResponseData) {
            }
        }

        @Override // com.zenmen.palmchat.ui.widget.FeedBottomBannerView.d
        public void b() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements ViewPager.OnPageChangeListener {
        public j() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PhotoViewActivity.this.o2(i);
            PhotoViewActivity.this.x2(i);
            PhotoViewActivity.this.w2(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
