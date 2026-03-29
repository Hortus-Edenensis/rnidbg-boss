package com.zenmen.palmchat.chat.viewadapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.az;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.oplus.tblplayer.Constants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.CircleGuide;
import com.zenmen.palmchat.Vo.CircleNotice;
import com.zenmen.palmchat.Vo.ImageExtensionVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.VideoViewFragment;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.circle.app.dragon.DragonConfirmItem;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ConfigInfoVo;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationImageView;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.media.file.FileProgressView;
import com.zenmen.palmchat.redpacket.data.RedPacketVo;
import com.zenmen.palmchat.transfer.bean.TransferVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AutoResizeGifImageView;
import com.zenmen.palmchat.widget.AutoResizeImageView;
import defpackage.a65;
import defpackage.az2;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.bs0;
import defpackage.c92;
import defpackage.dr2;
import defpackage.dw1;
import defpackage.eb6;
import defpackage.gr2;
import defpackage.h50;
import defpackage.hc2;
import defpackage.ho3;
import defpackage.hx3;
import defpackage.if6;
import defpackage.il5;
import defpackage.je1;
import defpackage.jr2;
import defpackage.k86;
import defpackage.ku4;
import defpackage.l50;
import defpackage.mb4;
import defpackage.me1;
import defpackage.o86;
import defpackage.p40;
import defpackage.pt1;
import defpackage.pu1;
import defpackage.q05;
import defpackage.r75;
import defpackage.rl0;
import defpackage.s34;
import defpackage.sd1;
import defpackage.sy5;
import defpackage.u93;
import defpackage.v06;
import defpackage.v10;
import defpackage.v4;
import defpackage.v8;
import defpackage.vk3;
import defpackage.vl1;
import defpackage.x20;
import defpackage.x36;
import defpackage.y5;
import defpackage.y56;
import defpackage.yk6;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b extends DefaultChatViewAdapter {
    public String j;
    public je1 l;
    public boolean k = false;
    public HashSet<String> m = new HashSet<>();
    public HashSet<String> n = new HashSet<>();
    public SeekBar.OnSeekBarChangeListener o = new r();

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1005b implements View.OnClickListener {
        public ViewOnClickListenerC1005b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            b bVar = b.this;
            bVar.v0(bVar.o().getChatId(), 190103, b.this.o().getBizType());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12937a;

        public c(MessageVo messageVo) {
            this.f12937a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX != null) {
                hVarX.H(this.f12937a, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12938a;
        public final /* synthetic */ h50 b;

        public c0(MessageVo messageVo, h50 h50Var) {
            this.f12938a = messageVo;
            this.b = h50Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            String strF = com.zenmen.palmchat.expression.a.f(this.f12938a);
            AutoResizeGifImageView autoResizeGifImageView = (AutoResizeGifImageView) this.b.u;
            if (b.this.k0(this.f12938a) || b.this.n0(this.f12938a) || (i = this.f12938a.attachStatus) == 2 || i == 5) {
                b.this.o0(this.f12938a, null);
                return;
            }
            LogUtil.i("MyChatterViewAdapter", "handleExpressionMessage download gif, url = " + strF);
            b.this.J(strF, autoResizeGifImageView, this.b, this.f12938a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12939a;

        public d(MessageVo messageVo) {
            this.f12939a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX == null) {
                return true;
            }
            hVarX.m(this.f12939a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12940a;

        public d0(MessageVo messageVo) {
            this.f12940a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12940a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12941a;

        public e(MessageVo messageVo) {
            this.f12941a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.x().J0(ChatterAdapter.OtherViewType.SendImageToMoments, this.f12941a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements bs0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12942a;
        public final /* synthetic */ h50 b;

        public e0(MessageVo messageVo, h50 h50Var) {
            this.f12942a = messageVo;
            this.b = h50Var;
        }

        @Override // bs0.a
        public void a() {
            com.zenmen.palmchat.database.b.T(this.f12942a, 1);
            String str = this.b.r;
            if (str == null || !str.equals(this.f12942a.mid)) {
                return;
            }
            this.b.c0.setImageResource(pt1.c(this.f12942a.data5));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strP = AccountUtils.p(AppContext.getContext());
            if (TextUtils.isEmpty(strP)) {
                return;
            }
            r75.o(AppContext.getContext(), strP + "sp_image_notice_enable", false);
            sy5.f(view.getContext(), view.getResources().getString(R.string.message_image_notice_switch), 0).g();
            LogUtil.onImmediateClickEvent("M184", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12944a;
        public final /* synthetic */ h50 b;
        public final /* synthetic */ AutoResizeGifImageView c;
        public final /* synthetic */ String d;

        public f0(MessageVo messageVo, h50 h50Var, AutoResizeGifImageView autoResizeGifImageView, String str) {
            this.f12944a = messageVo;
            this.b = h50Var;
            this.c = autoResizeGifImageView;
            this.d = str;
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
            LogUtil.i("MyChatterViewAdapter", "downloadGif onLoadingCancelled, mid = " + this.f12944a.mid);
            ContentValues contentValues = new ContentValues();
            contentValues.put("attach_status", (Integer) 0);
            b.this.f.getContentResolver().update(DBUriManager.c(ho3.class, this.f12944a.contactRelate), contentValues, "packet_id=?", new String[]{this.f12944a.mid});
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            File fileB;
            LogUtil.i("MyChatterViewAdapter", "downloadGif onLoadingComplete, mid = " + this.f12944a.mid);
            if (((String) this.c.getTag()).equals(this.d) && (fileB = sd1.b(this.d)) != null && fileB.exists()) {
                this.b.k0.setVisibility(8);
                this.b.D0.setVisibility(8);
                this.b.D.setBackgroundColor(0);
                this.b.E0.setVisibility(8);
                String absolutePath = fileB.getAbsolutePath();
                String str2 = this.b.d0;
                if (str2 == null || !str2.equals(absolutePath)) {
                    try {
                        this.c.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
                        this.b.d0 = absolutePath;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("attach_status", (Integer) 2);
                b.this.f.getContentResolver().update(DBUriManager.c(ho3.class, this.f12944a.contactRelate), contentValues, "packet_id=?", new String[]{this.f12944a.mid});
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.i("MyChatterViewAdapter", "downloadGif onLoadingFailed");
            this.b.C0.setImageResource(R.drawable.video_error);
            this.b.C0.setVisibility(0);
            this.b.k0.setVisibility(8);
            ContentValues contentValues = new ContentValues();
            contentValues.put("attach_status", Integer.valueOf(FailReason.c(failReason) ? 5 : 4));
            b.this.f.getContentResolver().update(DBUriManager.c(ho3.class, this.f12944a.contactRelate), contentValues, "packet_id=?", new String[]{this.f12944a.mid});
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            LogUtil.i("MyChatterViewAdapter", "downloadGif onLoadingStarted, mid = " + this.f12944a.mid);
            this.b.k0.setVisibility(0);
            this.b.C0.setVisibility(8);
            if (this.f12944a.attachStatus != 1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("attach_status", (Integer) 1);
                b.this.f.getContentResolver().update(DBUriManager.c(ho3.class, this.f12944a.contactRelate), contentValues, "packet_id=?", new String[]{this.f12944a.mid});
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12945a;

        public g(MessageVo messageVo) {
            this.f12945a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12945a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12946a;

        public g0(MessageVo messageVo) {
            this.f12946a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zenmen.palmchat.database.b.L(b.this.o(), this.f12946a, "1");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12947a;

        public h(MessageVo messageVo) {
            this.f12947a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12947a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements SimpleChatViewAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12949a;
        public final /* synthetic */ MessageVo b;

        public i(h50 h50Var, MessageVo messageVo) {
            this.f12949a = h50Var;
            this.b = messageVo;
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void a(int i) {
            this.f12949a.L.setTextColor(i);
            if (this.f12949a.K.getProgressDrawable() != null) {
                this.f12949a.K.getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
            }
            if (this.f12949a.K.getThumb() != null) {
                this.f12949a.K.getThumb().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
            }
            this.f12949a.J.setColorFilter(i);
            this.f12949a.v.setColorFilter(i);
            this.f12949a.G.setTextColor(i);
            this.f12949a.H.setTextColor(i);
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void onReset() {
            Resources resources;
            int i;
            TextView textView = this.f12949a.L;
            if (this.b.isSend) {
                resources = b.this.f.getResources();
                i = R.color.Ab;
            } else {
                resources = b.this.f.getResources();
                i = R.color.Gb;
            }
            textView.setTextColor(resources.getColor(i));
            if (this.f12949a.K.getProgressDrawable() != null) {
                this.f12949a.K.getProgressDrawable().setColorFilter(null);
            }
            if (this.f12949a.K.getThumb() != null) {
                this.f12949a.K.getThumb().setColorFilter(null);
            }
            this.f12949a.J.setColorFilter((ColorFilter) null);
            this.f12949a.v.setColorFilter((ColorFilter) null);
            this.f12949a.G.setTextColor(this.b.isSend ? Color.parseColor("#FFFFFF") : Color.parseColor("#222222"));
            this.f12949a.H.setTextColor(this.b.isSend ? Color.parseColor("#FFFFFF") : Color.parseColor("#222222"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12950a;
        public final /* synthetic */ String b;

        public i0(MessageVo messageVo, String str) {
            this.f12950a = messageVo;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12950a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12951a;

        public j(String str) {
            this.f12951a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            b bVar = b.this;
            bVar.v0(this.f12951a, 190104, bVar.o().getBizType());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12952a;

        public j0(MessageVo messageVo) {
            this.f12952a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12952a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12953a;

        public k(h50 h50Var) {
            this.f12953a = h50Var;
            put(DeviceInfoUtil.UID_TAG, v4.e(h50Var.y.getContext()));
            put("chatuid", b.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12955a;

        public l(MessageVo messageVo) {
            this.f12955a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12955a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12956a;

        public l0(String str) {
            this.f12956a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            b bVar = b.this;
            bVar.v0(this.f12956a, 190105, bVar.o().getBizType());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12957a;

        public m(MessageVo messageVo) {
            this.f12957a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12957a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12958a;

        public m0(MessageVo messageVo) {
            this.f12958a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            MessageVo messageVo = this.f12958a;
            bVar.o0(messageVo, messageVo.mid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12959a;

        public n(MessageVo messageVo) {
            this.f12959a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12959a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12960a;

        public n0(MessageVo messageVo) {
            this.f12960a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b bVar = b.this;
            MessageVo messageVo = this.f12960a;
            bVar.p0(messageVo, messageVo.mid);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12961a;

        public o(MessageVo messageVo) {
            this.f12961a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12961a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12962a;

        public o0(MessageVo messageVo) {
            this.f12962a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12962a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12963a;

        public p(MessageVo messageVo) {
            this.f12963a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12963a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12964a;

        public p0(MessageVo messageVo) {
            this.f12964a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12964a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12965a;

        public q(MessageVo messageVo) {
            this.f12965a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12965a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12966a;

        public q0(MessageVo messageVo) {
            this.f12966a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12966a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12967a = 0;
        public int b = 0;
        public boolean c = true;

        public r() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int i2;
            if (!z || (i2 = this.b) <= 0) {
                return;
            }
            this.b = i2 - 1;
            seekBar.setProgress(this.f12967a);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f12967a = seekBar.getProgress();
            if (this.c) {
                this.b = 3;
            }
            MessageVo messageVo = (MessageVo) seekBar.getTag();
            boolean zO0 = AudioController.b0().o0(messageVo.mid);
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX != null) {
                AudioController.p pVar = new AudioController.p();
                pVar.f14641a = zO0;
                pVar.b = AudioController.p.d;
                hVarX.H(messageVo, pVar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MessageVo messageVo = (MessageVo) seekBar.getTag();
            int progress = seekBar.getProgress();
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX != null) {
                AudioController.p pVar = new AudioController.p();
                pVar.b = this.b > 0 ? AudioController.p.f : AudioController.p.e;
                pVar.c = progress;
                hVarX.H(messageVo, pVar);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12968a;

        public r0(MessageVo messageVo) {
            this.f12968a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zenmen.palmchat.database.b.L(b.this.o(), this.f12968a, "1");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12969a;
        public final /* synthetic */ h50 b;

        public s(MessageVo messageVo, h50 h50Var) {
            this.f12969a = messageVo;
            this.b = h50Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f12969a.attachStatus != 1) {
                this.b.A.setImageResource(R.drawable.icon_message_file_pause);
                ChatterAdapter.h hVarX = b.this.x();
                if (hVarX != null) {
                    hVarX.o0(this.f12969a);
                    return;
                }
                return;
            }
            this.b.A.setVisibility(8);
            this.b.Q.setVisibility(8);
            ChatterAdapter.h hVarX2 = b.this.x();
            if (hVarX2 != null) {
                hVarX2.N(this.f12969a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12970a;

        public s0(MessageVo messageVo) {
            this.f12970a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12970a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12971a;

        public t(MessageVo messageVo) {
            this.f12971a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12971a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12972a;

        public t0(MessageVo messageVo) {
            this.f12972a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            MessageVo messageVo = this.f12972a;
            bVar.o0(messageVo, messageVo.mid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12973a;

        public u(MessageVo messageVo) {
            this.f12973a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12973a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12974a;

        public u0(MessageVo messageVo) {
            this.f12974a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b bVar = b.this;
            MessageVo messageVo = this.f12974a;
            bVar.p0(messageVo, messageVo.mid);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends HashMap<String, Object> {
        public v() {
            put("type", 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v0 implements SimpleChatViewAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12976a;
        public final /* synthetic */ MessageVo b;

        public v0(h50 h50Var, MessageVo messageVo) {
            this.f12976a = h50Var;
            this.b = messageVo;
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void a(int i) {
            this.f12976a.t.setTextColor(i);
            if (this.f12976a.t.getCompoundDrawables() != null) {
                for (Drawable drawable : this.f12976a.t.getCompoundDrawables()) {
                    if (drawable != null) {
                        drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void onReset() {
            Resources resources;
            int i;
            TextView textView = this.f12976a.t;
            if (this.b.isSend) {
                resources = b.this.f.getResources();
                i = R.color.Ab;
            } else {
                resources = b.this.f.getResources();
                i = R.color.Gb;
            }
            textView.setTextColor(resources.getColor(i));
            if (this.f12976a.t.getCompoundDrawables() != null) {
                for (Drawable drawable : this.f12976a.t.getCompoundDrawables()) {
                    if (drawable != null) {
                        drawable.setColorFilter(null);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12978a;

        public w0(MessageVo messageVo) {
            this.f12978a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.x().J0(ChatterAdapter.OtherViewType.ReSendRedPacket, this.f12978a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12979a;

        public x(MessageVo messageVo) {
            this.f12979a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dw1.v("click", this.f12979a.mid);
            b.this.o0(this.f12979a, "nearbyItem");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x0 implements SimpleChatViewAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12980a;
        public final /* synthetic */ MessageVo b;

        public x0(h50 h50Var, MessageVo messageVo) {
            this.f12980a = h50Var;
            this.b = messageVo;
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void a(int i) {
            this.f12980a.t.setTextColor(i);
        }

        @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter.b
        public void onReset() {
            Resources resources;
            int i;
            TextView textView = this.f12980a.t;
            if (this.b.isSend) {
                resources = b.this.f.getResources();
                i = R.color.Ab;
            } else {
                resources = b.this.f.getResources();
                i = R.color.Gb;
            }
            textView.setTextColor(resources.getColor(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12981a;

        public y(MessageVo messageVo) {
            this.f12981a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o0(this.f12981a, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y0 implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12982a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ int c;

        public y0(h50 h50Var, MessageVo messageVo, int i) {
            this.f12982a = h50Var;
            this.b = messageVo;
            this.c = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.f12982a.t.setTag("onLongClick");
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX != null) {
                MessageVo messageVoM791clone = this.b.m791clone();
                if (1 == this.c) {
                    messageVoM791clone.text = a65.b(messageVoM791clone.text);
                }
                hVarX.m(messageVoM791clone, null);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12983a;

        public z(MessageVo messageVo) {
            this.f12983a = messageVo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.p0(this.f12983a, null);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z0 extends c92.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12984a;
        public final /* synthetic */ int b;

        public z0(MessageVo messageVo, int i) {
            this.f12984a = messageVo;
            this.b = i;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ChatterAdapter.h hVarX = b.this.x();
            if (hVarX != null) {
                MessageVo messageVoM791clone = this.f12984a.m791clone();
                if (1 == this.b) {
                    messageVoM791clone.text = a65.b(messageVoM791clone.text);
                }
                hVarX.o1(messageVoM791clone);
            }
            return true;
        }
    }

    public static long M(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getInt("hdSize");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static int O(String str) {
        return ChatterAdapter.M(str);
    }

    public static float P(String str, boolean z2) {
        return ChatterAdapter.P(str, z2);
    }

    public static int Q(String str) {
        return ChatterAdapter.R(str);
    }

    public final void I(String str) {
        List<String> listQ = r().q();
        if (listQ.contains(str)) {
            return;
        }
        listQ.add(str);
    }

    public final void J(String str, AutoResizeGifImageView autoResizeGifImageView, h50 h50Var, MessageVo messageVo) {
        LogUtil.i("MyChatterViewAdapter", "downloadGif status = " + messageVo.attachStatus + ", mid = " + messageVo.mid);
        je1 je1VarR = new je1.a().s(false).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY).r();
        autoResizeGifImageView.setTag(str);
        gr2.j().k(str, je1VarR, new f0(messageVo, h50Var, autoResizeGifImageView, str));
    }

    public final void K(String str, AutoResizeGifImageView autoResizeGifImageView, h50 h50Var) {
        gr2.j().i(str, autoResizeGifImageView, bq6.j(), new h0(h50Var, str, autoResizeGifImageView));
    }

    public final String L(int i2) {
        if (i2 < 10) {
            return "0:0" + i2;
        }
        if (i2 >= 60) {
            if (i2 >= 60) {
                return "1:00";
            }
            return null;
        }
        return "0:" + i2;
    }

    public ImageExtensionVo N(MessageVo messageVo) {
        if (messageVo == null || messageVo.mimeType != 2 || TextUtils.isEmpty(messageVo.extention)) {
            return null;
        }
        return (ImageExtensionVo) az2.a(messageVo.extention, ImageExtensionVo.class);
    }

    public final void R(MessageVo messageVo, h50 h50Var) {
        String str;
        View view;
        String str2 = messageVo.data1;
        int iA0 = !TextUtils.isEmpty(str2) ? AudioController.a0(Long.valueOf(str2).longValue()) : 1;
        g gVar = new g(messageVo);
        h hVar = new h(messageVo);
        t0(h50Var.x, iA0, false);
        u(messageVo, h50Var.x, h50Var.i, new i(h50Var, messageVo));
        if (this.k) {
            h50Var.G.setVisibility(8);
            h50Var.I.setVisibility(0);
            h50Var.v.setVisibility(8);
            h50Var.K.setMax(100);
            h50Var.L.setText(L(iA0));
            h50Var.J.setOnClickListener(gVar);
            h50Var.J.setOnLongClickListener(hVar);
            if (!AudioController.b0().o0(messageVo.mid)) {
                AudioController.b0().l0();
                AudioController.b0().i0(messageVo.mid);
            }
            h50Var.K.setEnabled(true);
            h50Var.x.setOnClickListener(gVar);
            SeekBar seekBar = h50Var.K;
            if (seekBar != null) {
                seekBar.setTag(messageVo);
            }
            if (messageVo.attachPlaying == 1) {
                h50Var.K.setProgress(AudioController.b0().c0(messageVo.mid));
                if (messageVo.isSend) {
                    h50Var.J.setImageResource(R.drawable.ic_audio_bg_pause_press);
                    bs0 bs0Var = new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_chat_voice_right));
                    h50Var.v.setImageDrawable(bs0Var);
                    h50Var.O = bs0Var;
                    bs0Var.start();
                } else {
                    h50Var.J.setImageResource(R.drawable.ic_audio_bg_pause_normal);
                    bs0 bs0Var2 = new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_chat_voice_left));
                    h50Var.v.setImageDrawable(bs0Var2);
                    h50Var.O = bs0Var2;
                    bs0Var2.start();
                }
            } else {
                h50Var.K.setProgress(AudioController.b0().i0(messageVo.mid));
                if (messageVo.isSend) {
                    h50Var.v.setImageResource(R.drawable.animation_chat_voice_right3);
                    h50Var.J.setImageResource(R.drawable.ic_audio_bg_play_press);
                } else {
                    h50Var.J.setImageResource(R.drawable.ic_audio_bg_play_normal);
                    h50Var.v.setImageResource(R.drawable.animation_chat_voice_left3);
                }
            }
            h50Var.K.setOnSeekBarChangeListener(this.o);
        } else {
            h50Var.I.setVisibility(8);
            h50Var.v.setVisibility(0);
            if (TextUtils.isEmpty(str2)) {
                h50Var.G.setVisibility(8);
                h50Var.H.setVisibility(8);
            } else {
                h50Var.G.setText(iA0 + "");
                h50Var.G.setVisibility(0);
                h50Var.H.setVisibility(0);
            }
            h50Var.x.setOnClickListener(gVar);
            if (messageVo.attachPlaying != 1) {
                bs0 bs0Var3 = h50Var.O;
                if (bs0Var3 != null) {
                    bs0Var3.stop();
                    h50Var.O = null;
                }
                if (messageVo.isSend) {
                    h50Var.v.setImageResource(R.drawable.animation_chat_voice_right3);
                } else {
                    h50Var.v.setImageResource(R.drawable.animation_chat_voice_left3);
                }
            } else if (messageVo.isSend) {
                h50Var.J.setImageResource(R.drawable.ic_audio_bg_pause_press);
                bs0 bs0Var4 = new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_chat_voice_right));
                h50Var.v.setImageDrawable(bs0Var4);
                h50Var.O = bs0Var4;
                bs0Var4.start();
            } else {
                h50Var.J.setImageResource(R.drawable.ic_audio_bg_pause_normal);
                bs0 bs0Var5 = new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_chat_voice_left));
                h50Var.v.setImageDrawable(bs0Var5);
                h50Var.O = bs0Var5;
                bs0Var5.start();
            }
        }
        h50Var.x.setOnLongClickListener(hVar);
        if (messageVo.isSend) {
            int i2 = messageVo.status;
            if (i2 == 1) {
                this.j = messageVo.mid;
            } else if (i2 == 2 && (str = this.j) != null && messageVo.mid.equals(str)) {
                this.j = null;
                vk3.c(this.f, "sound/after_upload_voice.mp3", false, null);
            }
        } else {
            String str3 = messageVo.data2;
            boolean z2 = !TextUtils.isEmpty(str3) && new File(str3).exists();
            int i3 = messageVo.attachStatus;
            if (i3 == 2 && z2) {
                h50Var.h.setVisibility(8);
                h50Var.B.setVisibility(8);
                if (messageVo.isRead) {
                    h50Var.f.setVisibility(8);
                } else {
                    h50Var.f.setVisibility(0);
                }
            } else if (i3 == 1 || i3 == 3) {
                h50Var.h.setVisibility(0);
                h50Var.B.setVisibility(8);
                h50Var.f.setVisibility(8);
            } else {
                h50Var.h.setVisibility(8);
                h50Var.B.setVisibility(0);
                h50Var.B.setOnClickListener(gVar);
                h50Var.f.setVisibility(8);
            }
        }
        if (!v8.h() || o() == null) {
            return;
        }
        String chatId = o().getChatId();
        boolean zC = v8.C(chatId);
        int iN = n();
        if (!zC || (view = h50Var.N0) == null) {
            return;
        }
        if (iN == 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            h50Var.N0.setOnClickListener(new j(chatId));
        }
    }

    public final void S(MessageVo messageVo, h50 h50Var) {
        CircleGuide circleGuide = (messageVo == null || TextUtils.isEmpty(messageVo.extention)) ? null : (CircleGuide) az2.a(messageVo.extention, CircleGuide.class);
        if (circleGuide != null && circleGuide.a() != null) {
            h50Var.w0.setText(messageVo.text);
            h50Var.x0.setText(circleGuide.a().a());
        }
        h50Var.i.getPortraitView().setImageResource(R.drawable.circle_helper_round);
        h50Var.c.setVisibility(0);
        h50Var.c.setText("群助手");
        h50Var.m0.setOnClickListener(new o0(messageVo));
        h50Var.m0.setOnLongClickListener(new p0(messageVo));
    }

    public final void T(MessageVo messageVo, h50 h50Var) {
        CircleNotice circleNotice = (messageVo == null || TextUtils.isEmpty(messageVo.extention)) ? null : (CircleNotice) az2.a(messageVo.extention, CircleNotice.class);
        if (circleNotice != null && circleNotice.getNotice() != null) {
            h50Var.y0.setVisibility(0);
            h50Var.y0.setText("群公告\n" + circleNotice.getNotice().getContent());
            if (circleNotice.getNotice().getMediaType() != 1 || TextUtils.isEmpty(circleNotice.getNotice().getMediaUrl())) {
                h50Var.z0.setVisibility(8);
            } else {
                h50Var.z0.setVisibility(0);
                gr2.j().h(circleNotice.getNotice().getMediaUrl(), h50Var.z0, bq6.s());
            }
            if (messageVo.isSend) {
                h50Var.A0.setVisibility(8);
            } else {
                h50Var.A0.setText("去确认");
            }
        }
        h50Var.m0.setOnClickListener(new q0(messageVo));
        h50Var.m0.setOnLongClickListener(new s0(messageVo));
    }

    public final void U(MessageVo messageVo, h50 h50Var) {
        boolean z2;
        boolean z3;
        String str;
        DragonItem dragonItemBuildFromMessageVo = DragonItem.buildFromMessageVo(messageVo);
        if (dragonItemBuildFromMessageVo != null) {
            ((TextView) h50Var.l0.findViewById(R.id.dragon_title)).setText(dragonItemBuildFromMessageVo.content);
            ((TextView) h50Var.l0.findViewById(R.id.dragon_publisher)).setText(dragonItemBuildFromMessageVo.publisherName);
            ((TextView) h50Var.l0.findViewById(R.id.dragon_publish_time)).setText(new SimpleDateFormat("yyyy年M月d日 HH:mm", Locale.getDefault()).format(Long.valueOf(dragonItemBuildFromMessageVo.publishTime)));
            TextView textView = (TextView) h50Var.l0.findViewById(R.id.dragon_join_content);
            TextView textView2 = (TextView) h50Var.l0.findViewById(R.id.dragon_join);
            ArrayList<DragonConfirmItem> items = dragonItemBuildFromMessageVo.getItems();
            if (CollectionUtils.isEmpty(items)) {
                textView.setVisibility(8);
                z2 = false;
            } else {
                StringBuilder sb = new StringBuilder();
                textView.setVisibility(0);
                int size = items.size();
                int i2 = 0;
                z2 = false;
                while (i2 < size) {
                    DragonConfirmItem dragonConfirmItem = items.get(i2);
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append(".");
                    sb.append(dragonConfirmItem.uname);
                    sb.append(":");
                    sb.append(dragonConfirmItem.content);
                    if (i2 != size - 1) {
                        sb.append("\n");
                    }
                    if (AccountUtils.p(this.f).equals(dragonConfirmItem.uid)) {
                        z2 = true;
                    }
                    i2 = i3;
                }
                textView.setText(sb.toString());
            }
            TextView textView3 = (TextView) h50Var.l0.findViewById(R.id.dragon_end_time);
            long j2 = dragonItemBuildFromMessageVo.timeDeadLine;
            if (j2 != 0) {
                long jCurrentTimeMillis = j2 - System.currentTimeMillis();
                long j3 = jCurrentTimeMillis / 86400000;
                long j4 = (jCurrentTimeMillis % 86400000) / 3600000;
                long j5 = (jCurrentTimeMillis % 3600000) / 60000;
                if (jCurrentTimeMillis > 0) {
                    str = "还剩";
                    if (j3 > 0) {
                        str = "还剩" + j3 + "天";
                    }
                    if (j4 > 0) {
                        str = str + j4 + "小时";
                    }
                    if (j5 > 0) {
                        str = str + j5 + "分";
                    }
                    z3 = false;
                } else {
                    str = "已过期";
                    z3 = true;
                }
                textView3.setText(str);
            } else {
                textView3.setVisibility(8);
                z3 = false;
            }
            h50Var.l0.findViewById(R.id.line_divider_bottom).setVisibility((CollectionUtils.isEmpty(items) && dragonItemBuildFromMessageVo.timeDeadLine == 0) ? 8 : 0);
            textView2.setText(z3 ? "已过期" : z2 ? "已参与" : "未参与");
        }
        h50Var.l0.setOnClickListener(new n(messageVo));
        h50Var.l0.setOnLongClickListener(new o(messageVo));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(MessageVo messageVo, h50 h50Var) {
        String absolutePath;
        h50Var.b0.setVisibility(8);
        String str = messageVo.data5;
        if (str == null || !(str.startsWith("jsb") || messageVo.data5.startsWith("dice"))) {
            h50Var.c0.setVisibility(8);
            h50Var.u.setVisibility(0);
            h50Var.k0.setVisibility(8);
            h50Var.D0.setVisibility(8);
            h50Var.C0.setVisibility(8);
            h50Var.E0.setVisibility(8);
            h50Var.D.setBackgroundColor(0);
            AutoResizeGifImageView autoResizeGifImageView = (AutoResizeGifImageView) h50Var.u;
            String strF = com.zenmen.palmchat.expression.a.f(messageVo);
            if (messageVo.data4 != null) {
                s0(messageVo, h50Var);
                int iQ = Q(messageVo.data4);
                int iO = O(messageVo.data4);
                if (iQ <= 0 || iO <= 0) {
                    iQ = (int) this.f.getResources().getDimension(R.dimen.chat_static_expression_max_width);
                    iO = (int) this.f.getResources().getDimension(R.dimen.chat_static_expression_max_height);
                }
                autoResizeGifImageView.setDisplaySize(iQ, iO);
            }
            if (r().q().contains(messageVo.mid)) {
                messageVo.attachStatus = 5;
            }
            boolean z2 = (TextUtils.isEmpty(messageVo.data1) || messageVo.attachStatus == 5 || !new File(messageVo.data1).exists()) ? false : true;
            if (messageVo.attachStatus == 5) {
                h50Var.b0.setVisibility(0);
                h50Var.b0.setImageResource(R.drawable.icon_express_expired);
                h50Var.u.setImageDrawable(null);
                h50Var.D.setBackgroundColor(Color.parseColor("#e1e1e1"));
                h50Var.d0 = null;
            } else {
                if (z2) {
                    absolutePath = messageVo.data1;
                } else if (TextUtils.isEmpty(strF)) {
                    h50Var.b0.setVisibility(0);
                    h50Var.b0.setImageResource(R.drawable.icon_express_expired);
                    h50Var.u.setImageDrawable(null);
                    h50Var.D.setBackgroundColor(Color.parseColor("#e1e1e1"));
                    h50Var.d0 = null;
                } else {
                    File fileB = sd1.b(strF);
                    if (fileB == null || !fileB.exists() || fileB.length() <= 0) {
                        h50Var.D.setBackgroundColor(Color.parseColor("#d5d5d5"));
                        h50Var.d0 = null;
                        gr2.j().i(messageVo.data2, autoResizeGifImageView, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.gif_default).A(R.drawable.gif_default).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r(), new a0(messageVo, h50Var, strF, autoResizeGifImageView));
                        absolutePath = null;
                        z2 = false;
                    } else {
                        absolutePath = fileB.getAbsolutePath();
                        z2 = true;
                    }
                }
                if (z2) {
                    try {
                        String str2 = h50Var.d0;
                        if (str2 == null || !str2.equals(absolutePath)) {
                            autoResizeGifImageView.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
                            h50Var.d0 = absolutePath;
                        }
                    } catch (IOException unused) {
                        h50Var.d0 = null;
                        gr2.j().i(k86.p(absolutePath), h50Var.u, bq6.d(false), new b0(messageVo, h50Var));
                    }
                }
            }
            absolutePath = null;
            if (z2) {
            }
        } else {
            q0(messageVo, h50Var);
        }
        h50Var.D.setOnClickListener(new c0(messageVo, h50Var));
        h50Var.D.setOnLongClickListener(new d0(messageVo));
        if (messageVo.isSend) {
            if (messageVo.status == 1) {
                h50Var.h.setVisibility(0);
            } else {
                h50Var.h.setVisibility(8);
            }
        }
    }

    public final void W(MessageVo messageVo, h50 h50Var) {
        String str = messageVo.data3;
        if (TextUtils.isEmpty(str)) {
            str = Constants.STRING_VALUE_UNSET;
        }
        int iH = o86.h(str);
        h50Var.P.setBackgroundResource(iH);
        if (iH == R.drawable.file_blue_rectangle) {
            String upperCase = o86.e(str).toUpperCase();
            if (upperCase.length() > 3) {
                h50Var.P.setText(upperCase.substring(0, 3) + "...");
                h50Var.P.setTextSize(0, (float) this.f.getResources().getDimensionPixelSize(R.dimen.ext_smail_text_size));
            } else {
                h50Var.P.setTextSize(0, this.f.getResources().getDimensionPixelSize(R.dimen.ext_big_text_size));
                h50Var.P.setText(upperCase);
            }
        } else {
            h50Var.P.setText("");
        }
        h50Var.R.setText(str);
        int i2 = !TextUtils.isEmpty(messageVo.data4) ? Integer.parseInt(messageVo.data4) : 0;
        h50Var.S.setText(o86.b(i2));
        if (!messageVo.isSend) {
            int i3 = messageVo.attachStatus;
            if (i3 == 1 || i3 == 3) {
                if (i3 == 1) {
                    h50Var.A.setVisibility(0);
                    h50Var.A.setImageResource(R.drawable.icon_message_file_pause);
                    u0(messageVo, h50Var.Q, i2);
                } else {
                    h50Var.A.setVisibility(8);
                    h50Var.Q.setVisibility(8);
                }
                h50Var.C.setVisibility(0);
                h50Var.C.setOnClickListener(new s(messageVo, h50Var));
            } else {
                h50Var.C.setVisibility(8);
                h50Var.Q.setVisibility(8);
            }
        } else if (messageVo.status == 2) {
            h50Var.Q.setVisibility(8);
        } else {
            u0(messageVo, h50Var.Q, i2);
        }
        h50Var.U.setOnClickListener(new t(messageVo));
        h50Var.U.setOnLongClickListener(new u(messageVo));
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(MessageVo messageVo, h50 h50Var) {
        String str;
        String str2;
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        boolean zC;
        String str3;
        boolean z2;
        float fP = P(messageVo.data4, false);
        ((AutoResizeImageView) h50Var.u).setRatio(fP);
        if (r().q().contains(messageVo.mid)) {
            messageVo.attachStatus = 5;
        }
        boolean z3 = (TextUtils.isEmpty(messageVo.data1) || messageVo.attachStatus == 5 || !new File(messageVo.data1).exists()) ? false : true;
        String str4 = null;
        if (z3) {
            str = messageVo.data1;
        } else {
            if (!((TextUtils.isEmpty(messageVo.data3) || sd1.b(messageVo.data3) == null) ? false : true)) {
                str = messageVo.data2;
                if (hx3.g() > 2) {
                    str2 = messageVo.data3;
                }
                if (messageVo.attachStatus != 5) {
                    if (TextUtils.isEmpty(messageVo.data3)) {
                        str3 = null;
                        z2 = false;
                    } else {
                        z2 = sd1.b(messageVo.data3) != null;
                        str3 = messageVo.data3;
                    }
                    if (!z2 && !TextUtils.isEmpty(messageVo.data2)) {
                        z2 = sd1.b(messageVo.data2) != null;
                        str3 = messageVo.data2;
                    }
                    str = str3;
                    if (dr2.a() && z2 && !dr2.b(messageVo.data1)) {
                        h50Var.b0.setVisibility(8);
                        gr2.j().i(pu1.a(str), h50Var.u, bq6.d(!z2), new a1(h50Var));
                    } else {
                        h50Var.b0.setVisibility(0);
                        h50Var.b0.setImageResource(R.drawable.icon_image_expired);
                        gr2.j().c(h50Var.u);
                        h50Var.u.setImageResource(R.drawable.icon_loading_fail_bg);
                    }
                } else {
                    h50Var.b0.setVisibility(8);
                    gr2.j().i(pu1.a(str), h50Var.u, bq6.d(!z3), new a(messageVo, h50Var, str2));
                }
                if (v8.h() && o() != null) {
                    zC = v8.C(o().getChatId());
                    int iN = n();
                    if (zC) {
                        LogUtil.d("AiChatPeopleManagerTag", "MyChatterViewAdapter handleImageMessage CheckOpenGuard result " + iN);
                        if (iN != 1) {
                            View view = h50Var.K0;
                            if (view != null) {
                                view.setVisibility(0);
                                h50Var.K0.setOnClickListener(new ViewOnClickListenerC1005b());
                                View view2 = h50Var.L0;
                                if (view2 != null) {
                                    view2.setVisibility(8);
                                }
                                if (!TextUtils.isEmpty(str) && h50Var.M0 != null) {
                                    hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(str)).placeholder(R.drawable.default_portrait).transform(new y5(10, 1)).into(h50Var.M0);
                                    h50Var.M0.setRatio(fP);
                                }
                            }
                        } else {
                            View view3 = h50Var.K0;
                            if (view3 != null) {
                                view3.setVisibility(8);
                                View view4 = h50Var.L0;
                                if (view4 != null) {
                                    view4.setVisibility(0);
                                }
                            }
                        }
                    }
                }
                h50Var.D.setOnClickListener(new c(messageVo));
                h50Var.D.setOnLongClickListener(new d(messageVo));
                if (messageVo.isSend) {
                    if (messageVo.status == 1) {
                        h50Var.E.setText(String.valueOf(messageVo.sendingProgress) + "%");
                        h50Var.F.setVisibility(0);
                        h50Var.D.setBackgroundResource(R.drawable.transparent_shape_20);
                    } else {
                        h50Var.F.setVisibility(8);
                        h50Var.D.setBackgroundResource(R.drawable.selector_message_mask_right_item_background);
                    }
                }
                if (h50Var.F0 != null) {
                    ImageExtensionVo imageExtensionVoN = N(messageVo);
                    if (imageExtensionVoN == null || imageExtensionVoN.getExtraType() != 1 || TextUtils.isEmpty(imageExtensionVoN.getExtraTitle())) {
                        h50Var.F0.setVisibility(8);
                    } else {
                        h50Var.F0.setVisibility(0);
                        if (v10.a()) {
                            h50Var.F0.setBackgroundResource(R.drawable.gray_round_rect_2);
                        }
                        TextView textView = h50Var.y;
                        if (textView != null) {
                            textView.setText(Html.fromHtml(imageExtensionVoN.getExtraTitle()));
                            h50Var.y.setOnClickListener(new e(messageVo));
                        }
                        if (h50Var.z != null) {
                            if (MomentsConfig.j() && rl0.h().i().g() && rl0.h().i().h()) {
                                h50Var.z.setVisibility(0);
                                h50Var.z.setText(Html.fromHtml("<u>不再提醒</u>"));
                                h50Var.z.setOnClickListener(new f());
                            } else {
                                h50Var.z.setVisibility(8);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(messageVo.extention)) {
                    try {
                        jSONObjectOptJSONObject = new JSONObject(messageVo.extention).optJSONObject("appMsg");
                    } catch (JSONException e2) {
                        e = e2;
                        strOptString = null;
                    }
                    if (jSONObjectOptJSONObject != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(az.at)) != null) {
                        strOptString = jSONObjectOptJSONObject2.optString("name");
                        try {
                            strOptString2 = jSONObjectOptJSONObject2.optString("icon");
                        } catch (JSONException e3) {
                            e = e3;
                            e.printStackTrace();
                            strOptString2 = null;
                        }
                        str4 = strOptString;
                    }
                    strOptString2 = null;
                } else {
                    strOptString2 = null;
                }
                if (!TextUtils.isEmpty(str4) || TextUtils.isEmpty(strOptString2)) {
                    h50Var.s0.setVisibility(8);
                }
                h50Var.t0.setText(str4);
                gr2.j().h(strOptString2, h50Var.u0, bq6.l());
                h50Var.s0.setVisibility(0);
                return;
            }
            str = messageVo.data3;
        }
        str2 = null;
        if (messageVo.attachStatus != 5) {
        }
        if (v8.h()) {
            zC = v8.C(o().getChatId());
            int iN2 = n();
            if (zC) {
            }
        }
        h50Var.D.setOnClickListener(new c(messageVo));
        h50Var.D.setOnLongClickListener(new d(messageVo));
        if (messageVo.isSend) {
        }
        if (h50Var.F0 != null) {
        }
        if (TextUtils.isEmpty(messageVo.extention)) {
        }
        if (TextUtils.isEmpty(str4)) {
        }
        h50Var.s0.setVisibility(8);
    }

    public final void Y(MessageVo messageVo, h50 h50Var) {
        com.zenmen.palmchat.chat.g.b(this.f, messageVo, h50Var, x(), r().i());
    }

    public final void Z(MessageVo messageVo, h50 h50Var) {
        gr2.j().i(messageVo.data2, h50Var.w, bq6.o(), new w(h50Var, messageVo));
        try {
            JSONObject jSONObject = new JSONObject(messageVo.data1);
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("address");
            String strOptString = jSONObject.optString("nearbyCount");
            if (dw1.l() && dw1.k && !TextUtils.isEmpty(strOptString)) {
                View view = h50Var.N;
                if (view != null) {
                    view.setVisibility(0);
                    h50Var.N.setOnClickListener(new x(messageVo));
                    dw1.v("view", messageVo.mid);
                }
                if (h50Var.M != null && !TextUtils.isEmpty(dw1.l)) {
                    h50Var.M.setText(dw1.l.replace("xx", strOptString));
                }
            } else {
                View view2 = h50Var.N;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            if (TextUtils.isEmpty(string)) {
                h50Var.t.setText(string2);
                h50Var.t.setSingleLine(false);
                h50Var.V.setVisibility(8);
            } else {
                h50Var.t.setText(string);
                h50Var.t.setSingleLine(true);
                h50Var.V.setText(string2);
                h50Var.V.setVisibility(0);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((LocationImageView) h50Var.w).setmTextAreaHeight(h50Var.W);
        h50Var.D.setOnClickListener(new y(messageVo));
        h50Var.D.setOnLongClickListener(new z(messageVo));
    }

    public final boolean a0(h50 h50Var, Spanned spanned, MessageVo messageVo) {
        LogUtil.d("tang", "actionBody is " + spanned.toString());
        if (!spanned.toString().equals(this.f.getString(R.string.re_send_rp))) {
            r0(h50Var, messageVo);
            return false;
        }
        h50Var.y.setBackgroundColor(Color.parseColor("#21E96038"));
        h50Var.y.getPaint().setFlags(8);
        h50Var.y.getPaint().setAntiAlias(true);
        h50Var.y.setTextColor(Color.parseColor("#FFE35547"));
        h50Var.y.setOnClickListener(new w0(messageVo));
        h50Var.y.setText(spanned.toString());
        return true;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter, defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        View viewInflate;
        boolean z2 = messageVo.isSend;
        char c2 = z2 ? (char) 2 : (char) 1;
        int i2 = messageVo.mimeType;
        if (i2 != 1) {
            if (i2 == 2) {
                viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_image : R.layout.list_item_chat_left_image, (ViewGroup) null);
            } else {
                if (i2 == 3) {
                    View viewInflate2 = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_audio : R.layout.list_item_chat_left_audio, (ViewGroup) null);
                    if (!v10.a()) {
                        return viewInflate2;
                    }
                    viewInflate2.findViewById(R.id.audioContainer).setBackgroundResource(c2 == 2 ? R.drawable.selector_message_right_item_background_2 : R.drawable.selector_message_left_item_background_2);
                    return viewInflate2;
                }
                if (i2 != 4) {
                    int i3 = R.drawable.selector_message_file_right_item_background_2;
                    if (i2 == 6) {
                        View viewInflate3 = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_file : R.layout.list_item_chat_left_file, (ViewGroup) null);
                        if (!v10.a()) {
                            return viewInflate3;
                        }
                        View viewFindViewById = viewInflate3.findViewById(R.id.file_container);
                        if (c2 != 2) {
                            i3 = R.drawable.selector_message_file_left_item_background_2;
                        }
                        viewFindViewById.setBackgroundResource(i3);
                        return viewInflate3;
                    }
                    if (i2 == 7) {
                        viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_location : R.layout.list_item_chat_left_location, (ViewGroup) null);
                    } else {
                        if (i2 == 9) {
                            View viewInflate4 = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_name_card : R.layout.list_item_chat_left_name_card, (ViewGroup) null);
                            if (!v10.a()) {
                                return viewInflate4;
                            }
                            View viewFindViewById2 = viewInflate4.findViewById(R.id.file_container);
                            if (c2 != 2) {
                                i3 = R.drawable.selector_message_file_left_item_background_2;
                            }
                            viewFindViewById2.setBackgroundResource(i3);
                            return viewInflate4;
                        }
                        if (i2 == 14) {
                            viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_expression : R.layout.list_item_chat_left_expression, (ViewGroup) null);
                        } else if (i2 == 28) {
                            viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_link : R.layout.list_item_chat_left_link, (ViewGroup) null);
                        } else if (i2 != 30) {
                            if (i2 == 10005) {
                                return this.e.inflate(R.layout.list_item_chat_left_circle_guide, (ViewGroup) null);
                            }
                            if (i2 == 16) {
                                viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_redpacket : R.layout.list_item_chat_left_redpacket, (ViewGroup) null);
                            } else if (i2 == 17) {
                                viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_transfer : R.layout.list_item_chat_left_transfer, (ViewGroup) null);
                            } else if (i2 == 52) {
                                viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_dragon : R.layout.list_item_chat_left_dragon, (ViewGroup) null);
                            } else if (i2 != 53) {
                                switch (i2) {
                                    case 10000:
                                    case 10001:
                                        View viewInflate5 = this.e.inflate(R.layout.list_item_chat_sys_notifition, (ViewGroup) null);
                                        if (!v10.a()) {
                                            return viewInflate5;
                                        }
                                        viewInflate5.findViewById(R.id.time).setBackgroundResource(R.drawable.gray_round_rect_2);
                                        viewInflate5.findViewById(R.id.sys_notify_textview).setBackgroundResource(R.drawable.gray_round_rect_2);
                                        return viewInflate5;
                                    case 10002:
                                        break;
                                    default:
                                        return null;
                                }
                            } else {
                                viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_circle_notice : R.layout.list_item_chat_left_circle_notice, (ViewGroup) null);
                            }
                        }
                    }
                } else {
                    viewInflate = this.e.inflate(c2 == 2 ? R.layout.list_item_chat_right_video : R.layout.list_item_chat_left_video, (ViewGroup) null);
                }
            }
            return viewInflate;
        }
        return w(z2);
    }

    public final void b0(MessageVo messageVo, h50 h50Var) {
        r0(h50Var, messageVo);
        h50Var.y.setText(messageVo.text);
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter, defpackage.o40
    public if6 c(View view) {
        return h50.g(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SpannableString c0(CharSequence charSequence, Context context, int i2) {
        boolean z2;
        Drawable drawable;
        DefaultChatViewAdapter.ActionSpan[] actionSpanArr;
        DefaultChatViewAdapter.ActionSpan actionSpan;
        SpannableString spannableString = new SpannableString(charSequence);
        String string = charSequence.toString();
        if (string.startsWith("[红包]") || string.startsWith("[RedPacket]") || string.startsWith("[券红包]")) {
            int iIndexOf = string.indexOf("[", 0);
            int iIndexOf2 = string.indexOf("]", iIndexOf + 1);
            int i3 = iIndexOf2 + 5;
            if (string.length() <= i3 || !string.substring(iIndexOf2 + 1).startsWith("手气最佳") || string.substring(i3).contains("领取了") || !string.substring(i3).contains("抢到了")) {
                try {
                    actionSpanArr = (DefaultChatViewAdapter.ActionSpan[]) spannableString.getSpans(0, spannableString.length(), DefaultChatViewAdapter.ActionSpan.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (actionSpanArr == null || actionSpanArr.length <= 0 || (actionSpan = actionSpanArr[0]) == null) {
                    z2 = false;
                    drawable = !z2 ? context.getResources().getDrawable(R.drawable.ic_voucher_red_packet_small) : context.getResources().getDrawable(R.drawable.ic_red_packet_small);
                } else {
                    String url = actionSpan.getURL();
                    if (!TextUtils.isEmpty(url)) {
                        if (url.contains("coupon/info")) {
                            z2 = true;
                        }
                        if (!z2) {
                        }
                    }
                }
            } else {
                drawable = context.getResources().getDrawable(R.drawable.luckiest_rp);
            }
            drawable.setBounds(0, 0, me1.a(context, 19.0f), me1.b(context, 14));
            spannableString.setSpan(new vl1.a(drawable, 100), iIndexOf, iIndexOf2 + 1, 33);
        }
        return spannableString;
    }

    public final void d0(MessageVo messageVo, h50 h50Var) {
        RedPacketVo redPacketVoBuildFromMessageVo = RedPacketVo.buildFromMessageVo(messageVo);
        if (redPacketVoBuildFromMessageVo != null) {
            h50Var.R.setText(redPacketVoBuildFromMessageVo.remark);
        }
        int iA = ku4.a(messageVo);
        if (iA == 0) {
            h50Var.B0.setImageResource(R.drawable.icon_redpacket_thumb_init);
        } else {
            h50Var.B0.setImageResource(R.drawable.icon_redpacket_thumb_opened);
        }
        if (iA != 0) {
            if (messageVo.isSend) {
                h50Var.U.setBackgroundResource(R.drawable.icon_redpacket_open_right);
            } else {
                h50Var.U.setBackgroundResource(R.drawable.icon_redpacket_open_left);
            }
        } else if (messageVo.isSend) {
            h50Var.U.setBackgroundResource(R.drawable.icon_redpacket_normal_right);
        } else {
            h50Var.U.setBackgroundResource(R.drawable.icon_redpacket_normal_left);
        }
        h50Var.U.setPadding(0, 0, 0, 0);
        if (iA == 0) {
            h50Var.S.setText(R.string.text_redpacket_des_check);
        } else if (iA == 1) {
            ChatItem chatItemO = o();
            if (messageVo.isSend || chatItemO == null || chatItemO.getChatType() != 0) {
                h50Var.S.setText(R.string.text_redpacket_des_finish);
            } else {
                h50Var.S.setText(R.string.text_redpacket_des_opened);
            }
        } else if (iA == 2) {
            h50Var.S.setText(R.string.text_redpacket_des_opened);
        } else if (iA == 3) {
            h50Var.S.setText(R.string.text_redpacket_des_expired);
        }
        h50Var.D.setOnClickListener(new l(messageVo));
        h50Var.D.setOnLongClickListener(new m(messageVo));
    }

    public final void e0(MessageVo messageVo, h50 h50Var) {
        CharSequence charSequence;
        TextView textView = h50Var.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        int iOptInt = messageVo.data2 != null ? new JSONObject(messageVo.data2).optInt("linkFlag") : 0;
        u(messageVo, h50Var.t, h50Var.i, new x0(h50Var, messageVo));
        Map<String, y56> mapA = new x36(s(messageVo.text)).a();
        Spanned spannedFromHtml = Html.fromHtml(s(x20.a(this, o(), messageVo, mapA)));
        URLSpan[] uRLSpanArr = (URLSpan[]) spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        if (uRLSpanArr != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
            if (uRLSpanArr.length > 0) {
                ArrayList<DefaultChatViewAdapter.ActionSpan> arrayList = new ArrayList();
                int length = uRLSpanArr.length;
                int i2 = 0;
                while (i2 < length) {
                    URLSpan uRLSpan = uRLSpanArr[i2];
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new DefaultChatViewAdapter.ActionSpan(uRLSpan.getURL(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), this.f.getResources().getColor(R.color.text_color_secretary), mapA.get(uRLSpan.getURL()), messageVo.contactRelate));
                    i2++;
                    arrayList = arrayList2;
                    length = length;
                    spannableStringBuilder = spannableStringBuilder;
                }
                SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                spannableStringBuilder2.clearSpans();
                for (DefaultChatViewAdapter.ActionSpan actionSpan : arrayList) {
                    spannableStringBuilder2.setSpan(actionSpan, actionSpan.start, actionSpan.end, 33);
                }
                charSequence = spannableStringBuilder2;
                h50Var.t.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                charSequence = spannableStringBuilder;
            }
            h50Var.t.setText(c0(charSequence, this.f, vl1.c));
            h50Var.t.setOnClickListener(null);
            h50Var.t.setOnLongClickListener(new y0(h50Var, messageVo, iOptInt));
            c92.a(h50Var.t, new z0(messageVo, iOptInt));
        }
        View view = h50Var.H0;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView2 = h50Var.G0;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view2 = h50Var.J0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView3 = h50Var.I0;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter, defpackage.o40
    public void f(Context context, ChatItem chatItem) {
        super.f(context, chatItem);
        this.l = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).y(false).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(R.drawable.default_portrait).B(R.drawable.default_portrait).r();
    }

    public final void f0(MessageVo messageVo, h50 h50Var) {
        int i2;
        int i3;
        boolean z2;
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        int iOptInt = messageVo.data2 != null ? new JSONObject(messageVo.data2).optInt("linkFlag") : 0;
        if (!BaseWrapper.ENTER_ID_GAME_CENTER.equals(messageVo.data3)) {
            h50Var.y.setVisibility(0);
            h50Var.P0.setVisibility(0);
        } else if (s34.c() == 0) {
            h50Var.P0.setVisibility(0);
            h50Var.y.setVisibility(0);
            if (!this.n.contains(o().getChatId())) {
                q05.a("notify_chat_show", 1, new k(h50Var));
                this.n.add(o().getChatId());
            }
        } else {
            h50Var.P0.setVisibility(8);
            h50Var.y.setVisibility(8);
            if (this.n.contains(o().getChatId())) {
                this.n.remove(o().getChatId());
            }
        }
        ConfigInfoVo configInfoVoJ = yk6.j(messageVo.extention);
        if (configInfoVoJ != null) {
            if (configInfoVoJ.vipStatus) {
                String str = messageVo.data3;
                if (str == null || !str.equals("1")) {
                    q05.a("seeme_notify", 1, new v());
                    messageVo.data3 = "1";
                    u93.e(new g0(messageVo));
                }
            } else {
                String str2 = messageVo.data3;
                if (str2 == null || !str2.equals("1")) {
                    q05.a("seeme_system_msg", 1, null);
                    messageVo.data3 = "1";
                    u93.e(new r0(messageVo));
                }
            }
        }
        if (1 == iOptInt) {
            Spanned spannedFromHtml = Html.fromHtml(s(messageVo.text));
            URLSpan[] uRLSpanArr = (URLSpan[]) spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
            if (uRLSpanArr == null) {
                h50Var.y.setText(spannedFromHtml);
                return;
            }
            Map<String, y56> mapA = new x36(s(messageVo.text)).a();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
            if (uRLSpanArr.length > 0) {
                ArrayList<DefaultChatViewAdapter.ActionSpan> arrayList = new ArrayList();
                for (URLSpan uRLSpan : uRLSpanArr) {
                    arrayList.add(new DefaultChatViewAdapter.ActionSpan(uRLSpan.getURL(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), mapA.get(uRLSpan.getURL())));
                }
                spannableStringBuilder.clearSpans();
                for (DefaultChatViewAdapter.ActionSpan actionSpan : arrayList) {
                    spannableStringBuilder.setSpan(actionSpan, actionSpan.start, actionSpan.end, 33);
                }
                h50Var.y.setMovementMethod(LinkMovementMethod.getInstance());
            }
            h50Var.y.setText(spannableStringBuilder);
            return;
        }
        if ((TextUtils.isEmpty(messageVo.data1) ? 0 : Integer.valueOf(messageVo.data1).intValue()) == 1) {
            try {
                JSONObject jSONObject = new JSONObject(messageVo.data2);
                String string = jSONObject.getString("actionTypes");
                if (mb4.k(string)) {
                    String[] strArr = mb4.b;
                    string.equals(strArr[5]);
                    string.equals(strArr[9]);
                    String string2 = jSONObject.getString("actionBody");
                    if (v8.h() && string2 != null && string2.contains("a0628")) {
                        LogUtil.d("", "messageVo.mid  " + messageVo.mid);
                        if (o() != null && !this.m.contains(messageVo.mid)) {
                            this.m.add(messageVo.mid);
                            v8.m(o().getChatId(), "view");
                        }
                    }
                    if (!string2.contains("a0103")) {
                        string2.contains("a0104");
                    }
                    boolean zContains = string2.contains("a0105");
                    Spanned spannedFromHtml2 = Html.fromHtml(s(jSONObject.getString("actionBody")));
                    if (a0(h50Var, spannedFromHtml2, messageVo)) {
                        return;
                    }
                    URLSpan[] uRLSpanArr2 = (URLSpan[]) spannedFromHtml2.getSpans(0, spannedFromHtml2.length(), URLSpan.class);
                    if (uRLSpanArr2 != null) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannedFromHtml2);
                        if (uRLSpanArr2.length > 0) {
                            ArrayList<DefaultChatViewAdapter.ActionSpan> arrayList2 = new ArrayList();
                            Map<String, y56> mapA2 = new x36(s(jSONObject.getString("actionBody"))).a();
                            int length = uRLSpanArr2.length;
                            int i4 = 0;
                            while (i4 < length) {
                                URLSpan uRLSpan2 = uRLSpanArr2[i4];
                                if (zContains) {
                                    z2 = zContains;
                                    i2 = i4;
                                    i3 = length;
                                    arrayList2.add(new DefaultChatViewAdapter.ActionSpan(uRLSpan2.getURL(), spannableStringBuilder2.getSpanStart(uRLSpan2), spannableStringBuilder2.getSpanEnd(uRLSpan2), this.f.getResources().getColor(R.color.color_message_link_videocall), mapA2.get(uRLSpan2.getURL())));
                                } else {
                                    i2 = i4;
                                    i3 = length;
                                    z2 = zContains;
                                    arrayList2.add(new DefaultChatViewAdapter.ActionSpan(uRLSpan2.getURL(), spannableStringBuilder2.getSpanStart(uRLSpan2), spannableStringBuilder2.getSpanEnd(uRLSpan2), mapA2.get(uRLSpan2.getURL())));
                                }
                                i4 = i2 + 1;
                                length = i3;
                                zContains = z2;
                            }
                            spannableStringBuilder2.clearSpans();
                            for (DefaultChatViewAdapter.ActionSpan actionSpan2 : arrayList2) {
                                spannableStringBuilder2.setSpan(actionSpan2, actionSpan2.start, actionSpan2.end, 33);
                            }
                            h50Var.y.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                        h50Var.y.setText(c0(spannableStringBuilder2, this.f, vl1.c));
                        return;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        r0(h50Var, messageVo);
        h50Var.y.setText(messageVo.text);
        LogUtil.d("tang", "messageVo.text is " + messageVo.text);
    }

    public final void g0(MessageVo messageVo, h50 h50Var) {
        TransferVo transferVoBuildFromMessageVo = TransferVo.buildFromMessageVo(messageVo);
        int iA = v06.a(messageVo);
        if (iA == 0) {
            h50Var.B0.setImageResource(R.drawable.icon_transfer_thumb_init);
        } else {
            h50Var.B0.setImageResource(R.drawable.icon_transfer_success);
        }
        if (iA == 0) {
            if (messageVo.isSend) {
                h50Var.U.setBackgroundResource(R.drawable.transfer_rihgt_click);
            } else {
                h50Var.U.setBackgroundResource(R.drawable.transfer_left_click);
            }
        } else if (messageVo.isSend) {
            h50Var.U.setBackgroundResource(R.drawable.transfer_right_unclick);
        } else {
            h50Var.U.setBackgroundResource(R.drawable.transfer_left_unclick);
        }
        h50Var.U.setPadding(0, 0, 0, 0);
        if (!("2".equals(messageVo.data3) && messageVo.isSend) && (!("1".equals(messageVo.data3) && messageVo.isSend) && ((!"0".equals(messageVo.data3) || messageVo.isSend) && (!"3".equals(messageVo.data3) || messageVo.isSend)))) {
            if (messageVo.isSend) {
                m0(messageVo, h50Var, iA, transferVoBuildFromMessageVo);
            } else {
                l0(h50Var, iA, transferVoBuildFromMessageVo);
            }
        } else if (messageVo.isSend) {
            l0(h50Var, iA, transferVoBuildFromMessageVo);
            if (iA == 0) {
                if (transferVoBuildFromMessageVo == null || TextUtils.isEmpty(transferVoBuildFromMessageVo.remark)) {
                    h50Var.R.setText(this.f.getString(R.string.pay_transferInfo_state_send_waiting_comfirm, messageVo.nickName));
                } else {
                    h50Var.R.setText(this.f.getString(R.string.pay_transferInfo_state_send_waiting_comfirm, messageVo.nickName) + "-" + transferVoBuildFromMessageVo.remark);
                }
            }
        } else {
            m0(messageVo, h50Var, iA, transferVoBuildFromMessageVo);
            if (iA == 0) {
                if (transferVoBuildFromMessageVo == null || TextUtils.isEmpty(transferVoBuildFromMessageVo.remark)) {
                    h50Var.R.setText(R.string.pay_transferInfo_state_receive_waiting_confrim);
                } else {
                    h50Var.R.setText(this.f.getString(R.string.pay_transferInfo_state_receive_waiting_confrim) + "-" + transferVoBuildFromMessageVo.remark);
                }
            }
        }
        h50Var.D.setOnClickListener(new p(messageVo));
        h50Var.D.setOnLongClickListener(new q(messageVo));
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter, defpackage.o40
    public int getViewTypeCount() {
        return 28;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter, defpackage.o40
    public void h(p40 p40Var) {
        super.h(p40Var);
        this.k = p40Var.f();
    }

    public final void h0(MessageVo messageVo, h50 h50Var, String str) {
        ContactInfoItem contactInfoItemL;
        ChatItem chatItemFromNameCardString = MessageVo.parseChatItemFromNameCardString(messageVo.extention);
        if (chatItemFromNameCardString != null) {
            if (chatItemFromNameCardString.getChatType() == 0) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) chatItemFromNameCardString;
                if (messageVo.isSend && (contactInfoItemL = bo0.r().l(chatItemFromNameCardString.getChatId())) != null) {
                    contactInfoItem.setIconURL(contactInfoItemL.getIconURL());
                    if (TextUtils.isEmpty(contactInfoItem.getNickName())) {
                        contactInfoItem.setNickName(contactInfoItemL.getNickName());
                    }
                }
            }
            h50Var.X.setText(chatItemFromNameCardString.getChatName());
            h50Var.Y.setVisibility(0);
            if (chatItemFromNameCardString.getChatType() == 1) {
                h50Var.a0.setText(this.f.getResources().getString(R.string.message_item_group_name_card_title));
                if (chatItemFromNameCardString instanceof GroupInfoItem) {
                    GroupInfoItem groupInfoItem = (GroupInfoItem) chatItemFromNameCardString;
                    if ((groupInfoItem.getRoomType() == 1 || groupInfoItem.getRoomType() == 2) && !TextUtils.isEmpty(groupInfoItem.getDescribe())) {
                        h50Var.Y.setText(groupInfoItem.getDescribe());
                    } else {
                        h50Var.Y.setText(this.f.getResources().getString(R.string.message_item_group_name_card_des));
                    }
                } else {
                    h50Var.Y.setText(this.f.getResources().getString(R.string.message_item_group_name_card_des));
                }
            } else {
                h50Var.a0.setText(this.f.getResources().getString(R.string.message_item_name_card_title));
                h50Var.Y.setText(this.f.getResources().getString(R.string.message_item_group_name_card_des));
            }
            String iconURL = chatItemFromNameCardString.getIconURL();
            h50Var.Z.changeShapeType(1);
            gr2.j().h(iconURL, h50Var.Z, this.l);
        }
        h50Var.U.setOnClickListener(new i0(messageVo, str));
        h50Var.U.setOnLongClickListener(new j0(messageVo));
    }

    public final void i0(MessageVo messageVo, h50 h50Var) {
        TextView textView = h50Var.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
        h50Var.t.setOnClickListener(new t0(messageVo));
        h50Var.t.setOnLongClickListener(new u0(messageVo));
        if (!TextUtils.isEmpty(messageVo.data2)) {
            int iIntValue = Integer.valueOf(messageVo.data2).intValue();
            if (iIntValue == 0) {
                TextView textView2 = h50Var.t;
                boolean z2 = messageVo.isSend;
                textView2.setCompoundDrawablesWithIntrinsicBounds(z2 ? 0 : R.drawable.video_call_left_msg_icon, 0, z2 ? R.drawable.video_call_right_msg_icon : 0, 0);
            } else if (1 == iIntValue) {
                TextView textView3 = h50Var.t;
                boolean z3 = messageVo.isSend;
                textView3.setCompoundDrawablesWithIntrinsicBounds(z3 ? 0 : R.drawable.video_call_cancel_left_msg_icon, 0, z3 ? R.drawable.video_call_cancel_right_msg_icon : 0, 0);
            }
        }
        if (!messageVo.isSend) {
            if (messageVo.isRead) {
                h50Var.f.setVisibility(8);
            } else {
                h50Var.f.setVisibility(0);
            }
        }
        h50Var.t.setCompoundDrawablePadding(me1.b(this.f, 8));
        h50Var.t.setText(messageVo.data1);
        u(messageVo, h50Var.t, h50Var.i, new v0(h50Var, messageVo));
        View view = h50Var.H0;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView4 = h50Var.G0;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        View view2 = h50Var.J0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView5 = h50Var.I0;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:4)(1:5)|6|(3:8|(3:10|(1:12)(1:13)|14)(1:15)|(12:20|27|(2:31|(2:33|(2:35|(4:37|(1:39)|40|(1:44)))(2:45|(2:47|(1:49)))))|50|170|51|168|52|57|(1:64)(1:63)|65|(2:67|(4:69|(3:71|(1:73)|74)(3:75|(1:77)|78)|79|172)(1:(7:(1:108)(1:107)|110|(1:112)|113|(1:115)|116|177)(2:83|(4:85|(1:87)|88|173)(2:89|(2:91|(4:93|(1:95)|96|174)(4:97|(1:99)|100|175))(4:101|(1:103)|104|176)))))(4:117|(3:119|(1:121)|122)(2:123|(2:125|(3:127|(1:129)|130)(3:131|(1:133)|134))(3:135|(1:137)|138))|139|(2:141|(7:(1:154)(2:155|(1:157)(1:158))|159|(1:161)|162|(1:164)|165|180)(2:147|(2:152|179)(2:151|178)))(2:166|167)))(1:19))(3:21|(1:23)(1:24)|25)|26|27|(3:29|31|(0))|50|170|51|168|52|57|(2:59|64)(0)|65|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0154, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0156, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0(MessageVo messageVo, h50 h50Var) {
        String strN0;
        boolean z2;
        long jLongValue;
        int i2;
        boolean zC;
        boolean z3;
        if (messageVo.isSend) {
            h50Var.j0.setText(R.string.tap_to_resend);
        } else {
            h50Var.j0.setText(R.string.tap_to_reload);
        }
        h50Var.f0.setVisibility(0);
        float fP = P(messageVo.hdFlag, true);
        h50Var.f0.setRatio(fP);
        if (messageVo.attachStatus == 5) {
            if (TextUtils.isEmpty(messageVo.data4)) {
                strN0 = null;
                z3 = false;
            } else {
                z3 = sd1.b(messageVo.data4) != null;
                strN0 = messageVo.data4;
            }
            if (!z3 || dr2.b(messageVo.data2)) {
                gr2.j().c(h50Var.f0);
                h50Var.f0.setImageResource(R.drawable.icon_loading_fail_bg);
                z2 = true;
                if (v8.h() && o() != null) {
                    String chatId = o().getChatId();
                    zC = v8.C(chatId);
                    int iN = n();
                    if (zC) {
                        LogUtil.d("AiChatPeopleManagerTag", "handleVideoMessage getAiGuardStatus " + iN);
                        if (iN != 1) {
                            View view = h50Var.K0;
                            if (view != null) {
                                view.setVisibility(0);
                                h50Var.K0.setOnClickListener(new l0(chatId));
                                View view2 = h50Var.O0;
                                if (view2 != null) {
                                    view2.setVisibility(8);
                                }
                                if (!TextUtils.isEmpty(strN0) && h50Var.M0 != null) {
                                    hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(strN0)).placeholder(R.drawable.default_portrait).transform(new y5(10, 1)).into(h50Var.M0);
                                    h50Var.M0.setRatio(fP);
                                }
                            }
                        } else {
                            View view3 = h50Var.K0;
                            if (view3 != null) {
                                view3.setVisibility(8);
                                View view4 = h50Var.O0;
                                if (view4 != null) {
                                    view4.setVisibility(0);
                                }
                            }
                        }
                    }
                }
                h50Var.D.setOnClickListener(new m0(messageVo));
                h50Var.D.setOnLongClickListener(new n0(messageVo));
                jLongValue = Long.valueOf(messageVo.data10).longValue();
                long jLongValue2 = Long.valueOf(messageVo.data6).longValue();
                if (jLongValue > 0 || jLongValue2 <= 0 || messageVo.attachStatus == 5) {
                    h50Var.h0.setVisibility(8);
                    h50Var.i0.setVisibility(8);
                } else {
                    h50Var.h0.setText(o86.b(jLongValue));
                    h50Var.i0.setText(o86.d(jLongValue2));
                    h50Var.h0.setVisibility(8);
                    h50Var.i0.setVisibility(0);
                }
                if (!eb6.e().d(messageVo.data1)) {
                    h50Var.j0.setVisibility(8);
                    if (!messageVo.isSend) {
                        View view5 = h50Var.h;
                        if (view5 != null) {
                            view5.setVisibility(8);
                        }
                        h50Var.k0.setVisibility(8);
                    } else if (messageVo.status != 1) {
                        View view6 = h50Var.h;
                        if (view6 != null) {
                            view6.setVisibility(8);
                        }
                        h50Var.k0.setVisibility(8);
                    } else if (messageVo.sendingProgress == -1) {
                        View view7 = h50Var.h;
                        if (view7 != null) {
                            view7.setVisibility(0);
                        }
                        h50Var.k0.setVisibility(8);
                    } else {
                        View view8 = h50Var.h;
                        if (view8 != null) {
                            view8.setVisibility(8);
                        }
                        h50Var.k0.setVisibility(0);
                        h50Var.k0.setProgress(messageVo.sendingProgress);
                    }
                    if (messageVo.sendingProgress >= 100) {
                        h50Var.j0.setVisibility(8);
                        h50Var.g0.setImageResource(R.drawable.video_play);
                        h50Var.g0.setVisibility(0);
                        return;
                    }
                    int i3 = messageVo.status;
                    if (i3 != 3 && (i2 = messageVo.attachStatus) != 4 && i2 != 5) {
                        h50Var.j0.setVisibility(8);
                        int i4 = messageVo.status;
                        if (i4 == 1 || i4 == 0) {
                            h50Var.g0.setVisibility(8);
                            return;
                        } else {
                            h50Var.g0.setImageResource(R.drawable.video_play);
                            h50Var.g0.setVisibility(0);
                            return;
                        }
                    }
                    if (i3 == 3) {
                        h50Var.g0.setImageResource(R.drawable.video_play);
                    } else if (messageVo.attachStatus == 5) {
                        h50Var.g0.setImageResource(R.drawable.icon_video_expired);
                    } else {
                        h50Var.g0.setImageResource(R.drawable.video_error);
                    }
                    h50Var.g0.setVisibility(0);
                    if (messageVo.attachStatus == 5) {
                        h50Var.j0.setText(R.string.video_load_fail_404);
                    }
                    h50Var.j0.setVisibility(0);
                    View view9 = h50Var.h;
                    if (view9 != null) {
                        view9.setVisibility(8);
                    }
                    h50Var.j0.setVisibility(8);
                    return;
                }
                int i5 = messageVo.attachStatus;
                if (i5 == 1) {
                    h50Var.g0.setVisibility(8);
                    if (messageVo.sendingProgress == -1) {
                        View view10 = h50Var.h;
                        if (view10 != null) {
                            view10.setVisibility(0);
                        }
                        h50Var.k0.setVisibility(8);
                    } else {
                        View view11 = h50Var.h;
                        if (view11 != null) {
                            view11.setVisibility(8);
                        }
                        h50Var.k0.setVisibility(0);
                        h50Var.k0.setProgress(messageVo.sendingProgress);
                    }
                    h50Var.j0.setVisibility(8);
                    return;
                }
                if (i5 == 4 || i5 == 5) {
                    if (i5 == 5 && z2) {
                        h50Var.g0.setImageResource(R.drawable.icon_video_expired);
                    } else {
                        h50Var.g0.setImageResource(R.drawable.video_error);
                    }
                    h50Var.g0.setVisibility(0);
                    View view12 = h50Var.h;
                    if (view12 != null) {
                        view12.setVisibility(8);
                    }
                    h50Var.k0.setVisibility(8);
                    if (messageVo.attachStatus == 5) {
                        h50Var.j0.setText(R.string.video_load_fail_404);
                    }
                    h50Var.j0.setVisibility(8);
                    return;
                }
                h50Var.j0.setVisibility(8);
                if (!messageVo.isSend) {
                    h50Var.g0.setImageResource(R.drawable.video_play);
                    h50Var.g0.setVisibility(0);
                    View view13 = h50Var.h;
                    if (view13 != null) {
                        view13.setVisibility(8);
                    }
                    h50Var.k0.setVisibility(8);
                    return;
                }
                if (messageVo.status != 1) {
                    h50Var.g0.setImageResource(R.drawable.video_play);
                    h50Var.g0.setVisibility(0);
                    View view14 = h50Var.h;
                    if (view14 != null) {
                        view14.setVisibility(8);
                    }
                    h50Var.k0.setVisibility(8);
                    return;
                }
                h50Var.g0.setImageResource(R.drawable.video_play);
                h50Var.g0.setVisibility(8);
                if (messageVo.sendingProgress == -1) {
                    View view15 = h50Var.h;
                    if (view15 != null) {
                        view15.setVisibility(0);
                    }
                    h50Var.k0.setVisibility(8);
                    return;
                }
                View view16 = h50Var.h;
                if (view16 != null) {
                    view16.setVisibility(8);
                }
                h50Var.k0.setVisibility(0);
                h50Var.k0.setProgress(messageVo.sendingProgress);
                return;
            }
            gr2.j().i(pu1.a(strN0), h50Var.f0, bq6.z(), new k0(h50Var));
        } else {
            strN0 = !messageVo.isSend ? messageVo.data4 : VideoViewFragment.n0(messageVo);
            gr2.j().h(strN0, h50Var.f0, bq6.z());
        }
        z2 = false;
        if (v8.h()) {
            String chatId2 = o().getChatId();
            zC = v8.C(chatId2);
            int iN2 = n();
            if (zC) {
            }
        }
        h50Var.D.setOnClickListener(new m0(messageVo));
        h50Var.D.setOnLongClickListener(new n0(messageVo));
        jLongValue = Long.valueOf(messageVo.data10).longValue();
        long jLongValue22 = Long.valueOf(messageVo.data6).longValue();
        if (jLongValue > 0) {
            h50Var.h0.setVisibility(8);
            h50Var.i0.setVisibility(8);
        }
        if (!eb6.e().d(messageVo.data1)) {
        }
    }

    public final boolean k0(MessageVo messageVo) {
        File fileB;
        boolean z2 = !TextUtils.isEmpty(messageVo.data1) && new File(messageVo.data1).exists();
        if (!z2) {
            String strF = com.zenmen.palmchat.expression.a.f(messageVo);
            if (!TextUtils.isEmpty(strF) && (fileB = sd1.b(strF)) != null && fileB.exists() && fileB.length() > 0) {
                return true;
            }
        }
        return z2;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter, defpackage.o40
    public void l(if6 if6Var, MessageVo messageVo) {
        h50 h50Var = (h50) if6Var;
        h50Var.s = messageVo.data2;
        int i2 = messageVo.mimeType;
        if (i2 == 1) {
            y(messageVo, h50Var);
        }
        if (i2 == 2) {
            X(messageVo, h50Var);
            return;
        }
        if (i2 == 3) {
            R(messageVo, h50Var);
            return;
        }
        if (i2 == 4) {
            j0(messageVo, h50Var);
            return;
        }
        if (i2 == 6) {
            W(messageVo, h50Var);
            return;
        }
        if (i2 == 7) {
            Z(messageVo, h50Var);
            return;
        }
        if (i2 == 9) {
            h0(messageVo, h50Var, messageVo.nickName);
            return;
        }
        if (i2 == 14) {
            V(messageVo, h50Var);
            return;
        }
        if (i2 == 28) {
            Y(messageVo, h50Var);
            return;
        }
        if (i2 == 30) {
            i0(messageVo, h50Var);
            return;
        }
        if (i2 == 10005) {
            S(messageVo, h50Var);
            return;
        }
        if (i2 == 16) {
            d0(messageVo, h50Var);
            return;
        }
        if (i2 == 17) {
            g0(messageVo, h50Var);
            return;
        }
        if (i2 == 52) {
            U(messageVo, h50Var);
            return;
        }
        if (i2 == 53) {
            T(messageVo, h50Var);
            return;
        }
        switch (i2) {
            case 10000:
                f0(messageVo, h50Var);
                break;
            case 10001:
                b0(messageVo, h50Var);
                break;
            case 10002:
                e0(messageVo, h50Var);
                break;
            default:
                y(messageVo, h50Var);
                break;
        }
    }

    public final void l0(h50 h50Var, int i2, TransferVo transferVo) {
        String string = i2 != 0 ? i2 != 1 ? (i2 == 2 || i2 == 3) ? this.f.getString(R.string.pay_transferInfo_state_refund) : i2 != 4 ? "" : this.f.getString(R.string.pay_transferInfo_state_receive_confrim_wating_account) : this.f.getString(R.string.pay_transferInfo_state_receive_confrim) : this.f.getString(R.string.pay_transferInfo_state_receive_waiting_confrim);
        if (transferVo == null || TextUtils.isEmpty(transferVo.remark)) {
            h50Var.R.setText(string);
            return;
        }
        h50Var.R.setText(string + "-" + transferVo.remark);
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter, defpackage.o40
    public int m(boolean z2, int i2, MessageVo messageVo) {
        char c2 = z2 ? (char) 2 : (char) 1;
        if (i2 != 1) {
            if (i2 == 2) {
                return c2 == 2 ? 3 : 2;
            }
            int i3 = 4;
            if (i2 != 3) {
                if (i2 == 4) {
                    return c2 == 2 ? 15 : 14;
                }
                i3 = 7;
                if (i2 != 6) {
                    if (i2 == 7) {
                        return c2 != 2 ? 8 : 9;
                    }
                    if (i2 == 9) {
                        return c2 == 2 ? 13 : 12;
                    }
                    if (i2 == 14) {
                        return c2 == 2 ? 11 : 10;
                    }
                    i3 = 17;
                    if (i2 != 28) {
                        if (i2 != 30) {
                            if (i2 == 10005) {
                                return 25;
                            }
                            if (i2 == 16) {
                                return c2 == 2 ? 20 : 19;
                            }
                            if (i2 == 17) {
                                return c2 == 2 ? 22 : 21;
                            }
                            if (i2 == 52) {
                                return c2 == 2 ? 24 : 23;
                            }
                            if (i2 == 53) {
                                return c2 == 2 ? 27 : 26;
                            }
                            switch (i2) {
                                case 10000:
                                case 10001:
                                    return 16;
                                case 10002:
                                    break;
                                default:
                                    return -1;
                            }
                        }
                    } else if (c2 == 2) {
                        i3 = 18;
                    }
                } else if (c2 != 2) {
                    i3 = 6;
                }
            } else if (c2 == 2) {
                i3 = 5;
            }
            return i3;
        }
        return c2 != 2 ? 0 : 1;
    }

    public final void m0(MessageVo messageVo, h50 h50Var, int i2, TransferVo transferVo) {
        String string = i2 != 0 ? i2 != 1 ? (i2 == 2 || i2 == 3) ? this.f.getString(R.string.pay_transferInfo_state_refund) : i2 != 4 ? "" : this.f.getString(R.string.pay_transferInfo_state_send_confrim_wating_account) : this.f.getString(R.string.pay_transferInfo_state_send_confrim_wating_account) : this.f.getString(R.string.pay_transferInfo_state_send_waiting_comfirm, messageVo.nickName);
        if (transferVo == null || TextUtils.isEmpty(transferVo.remark)) {
            h50Var.R.setText(string);
            return;
        }
        h50Var.R.setText(string + "-" + transferVo.remark);
    }

    public final boolean n0(MessageVo messageVo) {
        String str;
        return messageVo == null || messageVo.isSend || (str = messageVo.data4) == null || M(str) <= 1048576;
    }

    public final void o0(MessageVo messageVo, Object obj) {
        ChatterAdapter.h hVarX = x();
        if (hVarX != null) {
            hVarX.H(messageVo, obj);
        }
    }

    public final void p0(MessageVo messageVo, Object obj) {
        ChatterAdapter.h hVarX = x();
        if (hVarX != null) {
            hVarX.m(messageVo, obj);
        }
    }

    public final void q0(MessageVo messageVo, h50 h50Var) {
        h50Var.c0.setVisibility(0);
        if (TextUtils.isEmpty(messageVo.data6)) {
            String str = h50Var.r;
            if (str == null || !str.equals(messageVo.mid)) {
                bs0 bs0Var = messageVo.data5.startsWith("jsb") ? new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_jsb)) : new bs0((AnimationDrawable) this.f.getResources().getDrawable(R.drawable.animation_dice));
                h50Var.c0.setImageDrawable(bs0Var);
                bs0Var.a(new e0(messageVo, h50Var));
                bs0Var.start();
                h50Var.r = messageVo.mid;
            }
        } else {
            h50Var.r = null;
            h50Var.c0.setImageResource(pt1.c(messageVo.data5));
        }
        h50Var.u.setVisibility(8);
    }

    public final void r0(h50 h50Var, MessageVo messageVo) {
        if (String.valueOf(12).equals(messageVo.data3)) {
            h50Var.y.setBackgroundResource(R.drawable.gray_round_rect_systeminfo);
        } else {
            h50Var.y.setBackgroundResource(v10.a() ? R.drawable.gray_round_rect_2 : R.drawable.gray_round_rect);
        }
        h50Var.y.getPaint().setFlags(0);
        h50Var.y.setTextColor(this.f.getResources().getColor(R.color.Gd));
        h50Var.y.setOnClickListener(null);
        h50Var.y.getPaint().setAntiAlias(true);
    }

    public final void s0(MessageVo messageVo, h50 h50Var) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h50Var.D.getLayoutParams();
        int dimension = (int) this.f.getResources().getDimension(R.dimen.chat_static_expression_max_width);
        int dimension2 = (int) this.f.getResources().getDimension(R.dimen.chat_static_expression_max_height);
        int dimension3 = (int) this.f.getResources().getDimension(R.dimen.chat_static_expression_min_width);
        int iQ = Q(messageVo.data4);
        int iO = O(messageVo.data4);
        if (iQ <= 0 || iO <= 0) {
            iQ = dimension;
            iO = dimension2;
        }
        if (iO > iQ) {
            int i2 = (iQ * dimension2) / iO;
            if (i2 >= dimension3) {
                dimension3 = i2;
            }
            layoutParams.width = dimension3;
            layoutParams.height = dimension2;
        } else {
            int i3 = (iO * dimension) / iQ;
            if (i3 >= dimension3) {
                dimension3 = i3;
            }
            layoutParams.width = dimension;
            layoutParams.height = dimension3;
        }
        h50Var.D.setLayoutParams(layoutParams);
    }

    public final void t0(View view, int i2, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z2) {
            layoutParams.width = me1.b(this.f, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM);
        } else {
            int iB = me1.b(this.f, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE);
            int iB2 = me1.b(this.f, 80);
            if (i2 <= 1) {
                layoutParams.width = iB2;
            } else if (1 < i2 && i2 < 60) {
                layoutParams.width = (int) ((((iB - iB2) / 60.0f) * i2) + iB2);
            } else if (i2 >= 60) {
                layoutParams.width = iB;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public final void u0(MessageVo messageVo, FileProgressView fileProgressView, int i2) {
        float f2 = messageVo.sendingProgress / i2;
        if (f2 >= 1.0f) {
            fileProgressView.setVisibility(8);
        } else {
            fileProgressView.setVisibility(0);
            fileProgressView.setProgress(f2);
        }
    }

    public final void v0(String str, int i2, int i3) {
        long j2;
        long j3;
        long j4;
        int i4;
        long j5;
        long j6 = 0;
        int gender = 0;
        try {
            j5 = !TextUtils.isEmpty(str) ? Long.parseLong(str) : 0L;
        } catch (Exception unused) {
            j2 = 0;
        }
        try {
            String strP = AccountUtils.p(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strP)) {
                j6 = Long.parseLong(strP);
                ContactInfoItem contactInfoItemL = bo0.r().l(strP);
                if (contactInfoItemL != null) {
                    gender = contactInfoItemL.getGender();
                }
            }
            j4 = j6;
            i4 = gender;
            j3 = j5;
        } catch (Exception unused2) {
            long j7 = j6;
            j6 = j5;
            j2 = j7;
            j3 = j6;
            j4 = j2;
            i4 = 0;
        }
        v8.N(this.f, i2, j3, j4, i4, i3);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12928a;
        public final /* synthetic */ h50 b;
        public final /* synthetic */ String c;

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1002a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12929a;

            public C1002a(String str) {
                this.f12929a = str;
                put("action", "img_load_fail");
                put("reason", "expired");
                put("scene", 0);
                put("url", str);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1003b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12930a;

            public C1003b(String str) {
                this.f12930a = str;
                put("action", "displayImage");
                put("detail", str);
            }
        }

        public a(MessageVo messageVo, h50 h50Var, String str) {
            this.f12928a = messageVo;
            this.b = h50Var;
            this.c = str;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap == null) {
                this.b.b0.setVisibility(0);
                this.b.u.setImageResource(R.drawable.icon_loading_fail_bg);
                this.b.b0.setImageResource(R.drawable.icon_loading_fail);
                return;
            }
            LogUtil.i("MyChatterViewAdapter", "handleImageMessage first onLoadingComplete" + bitmap.getWidth() + "*" + bitmap.getHeight());
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            gr2.j().i(pu1.a(this.c), this.b.u, bq6.j(), new c());
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (FailReason.c(failReason)) {
                MessageVo messageVo = this.f12928a;
                messageVo.attachStatus = 5;
                b.this.I(messageVo.mid);
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_image_expired);
                LogUtil.i("MyChatterViewAdapter", LogUtil.LogType.LOG_TYPE_IMG_LOAD_EXPIRE, 3, new C1002a(str), (Throwable) null);
            } else {
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_loading_fail);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mid", this.f12928a.mid);
                jSONObject.put("loadLevel", 1);
                jSONObject.put("imageUri", str);
                jSONObject.put("failReasonType", failReason.b());
                jSONObject.put("failReasonCause", failReason.a());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.i("MyChatterViewAdapter", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1003b(jSONObject.toString()), (Throwable) null);
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements jr2 {

            /* JADX INFO: renamed from: com.zenmen.palmchat.chat.viewadapter.b$a$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1004a extends HashMap<String, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12932a;

                public C1004a(String str) {
                    this.f12932a = str;
                    put("action", "displayImage");
                    put("detail", str);
                }
            }

            public c() {
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null) {
                    LogUtil.i("MyChatterViewAdapter", "handleImageMessage second onLoadingComplete " + bitmap.getWidth() + "*" + bitmap.getHeight());
                }
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mid", a.this.f12928a.mid);
                    jSONObject.put("loadLevel", 2);
                    jSONObject.put("imageUri", str);
                    jSONObject.put("failReasonType", failReason.b());
                    jSONObject.put("failReasonCause", failReason.a());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.i("MyChatterViewAdapter", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new C1004a(jSONObject.toString()), (Throwable) null);
            }

            @Override // defpackage.jr2
            public void onLoadingCancelled(String str, View view) {
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str, View view) {
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12933a;
        public final /* synthetic */ h50 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AutoResizeGifImageView d;

        public a0(MessageVo messageVo, h50 h50Var, String str, AutoResizeGifImageView autoResizeGifImageView) {
            this.f12933a = messageVo;
            this.b = h50Var;
            this.c = str;
            this.d = autoResizeGifImageView;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (b.this.k0(this.f12933a) || b.this.n0(this.f12933a)) {
                this.b.D.setBackgroundColor(0);
                b.this.K(this.c, this.d, this.b);
                return;
            }
            LogUtil.i("MyChatterViewAdapter", "gif attatchStatus = " + this.f12933a.attachStatus + ", progress = " + this.f12933a.sendingProgress);
            MessageVo messageVo = this.f12933a;
            int i = messageVo.attachStatus;
            if (i == 0) {
                this.b.E0.setVisibility(0);
                this.b.C0.setVisibility(0);
                if (this.f12933a.data4 != null) {
                    this.b.D0.setVisibility(0);
                    this.b.D0.setText(il5.b(b.this.f, b.M(this.f12933a.data4)));
                    return;
                }
                return;
            }
            if (i == 4) {
                this.b.C0.setImageResource(R.drawable.video_error);
                this.b.C0.setVisibility(0);
                this.b.k0.setVisibility(8);
            } else if (i == 1) {
                b.this.J(this.c, this.d, this.b, messageVo);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (!FailReason.c(failReason)) {
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_loading_fail);
                this.b.u.setImageResource(R.drawable.icon_loading_fail_bg);
            } else {
                this.f12933a.attachStatus = 5;
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_express_expired);
                this.b.u.setImageDrawable(null);
                this.b.D.setBackgroundColor(Color.parseColor("#e1e1e1"));
                b.this.I(this.f12933a.mid);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a1 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12934a;

        public a1(h50 h50Var) {
            this.f12934a = h50Var;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap == null) {
                this.f12934a.b0.setVisibility(0);
                this.f12934a.b0.setImageResource(R.drawable.icon_image_expired);
                this.f12934a.u.setImageResource(R.drawable.icon_loading_fail_bg);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.f12934a.b0.setVisibility(0);
            this.f12934a.b0.setImageResource(R.drawable.icon_image_expired);
            this.f12934a.u.setImageResource(R.drawable.icon_loading_fail_bg);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f12936a;
        public final /* synthetic */ h50 b;

        public b0(MessageVo messageVo, h50 h50Var) {
            this.f12936a = messageVo;
            this.b = h50Var;
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (!FailReason.c(failReason)) {
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_loading_fail);
                this.b.u.setImageResource(R.drawable.icon_loading_fail_bg);
            } else {
                this.f12936a.attachStatus = 5;
                this.b.b0.setVisibility(0);
                this.b.b0.setImageResource(R.drawable.icon_express_expired);
                this.b.u.setImageDrawable(null);
                this.b.D.setBackgroundColor(Color.parseColor("#e1e1e1"));
                b.this.I(this.f12936a.mid);
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12948a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AutoResizeGifImageView c;

        public h0(h50 h50Var, String str, AutoResizeGifImageView autoResizeGifImageView) {
            this.f12948a = h50Var;
            this.b = str;
            this.c = autoResizeGifImageView;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            File fileB = sd1.b(this.b);
            if (fileB == null || !fileB.exists()) {
                return;
            }
            String absolutePath = fileB.getAbsolutePath();
            try {
                this.c.setImageDrawable(new pl.droidsonroids.gif.a(absolutePath));
                this.f12948a.d0 = absolutePath;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.f12948a.b0.setVisibility(0);
            this.f12948a.b0.setImageResource(R.drawable.icon_loading_fail);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12954a;

        public k0(h50 h50Var) {
            this.f12954a = h50Var;
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            gr2.j().c(this.f12954a.f0);
            this.f12954a.f0.setImageResource(R.drawable.icon_loading_fail_bg);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h50 f12977a;
        public final /* synthetic */ MessageVo b;

        public w(h50 h50Var, MessageVo messageVo) {
            this.f12977a = h50Var;
            this.b = messageVo;
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
            String str2 = this.f12977a.r;
            if (str2 == null || !str2.equals(this.b.mid)) {
                this.f12977a.r = this.b.mid;
            }
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
