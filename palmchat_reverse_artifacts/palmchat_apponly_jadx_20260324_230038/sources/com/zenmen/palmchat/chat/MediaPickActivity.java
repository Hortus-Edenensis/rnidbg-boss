package com.zenmen.palmchat.chat;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.QRCodeScan.ResultActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.expression.ExpressionPreviewActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
import defpackage.bo2;
import defpackage.br3;
import defpackage.cq6;
import defpackage.dr0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l50;
import defpackage.lf5;
import defpackage.n71;
import defpackage.nk3;
import defpackage.op4;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.sk3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tk3;
import defpackage.u92;
import defpackage.ug3;
import defpackage.wm3;
import defpackage.wv;
import defpackage.xn3;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MediaPickActivity extends BaseActivityWithoutCheckAccount implements sk3, AbsListView.OnScrollListener, Observer {
    public static final String f0 = k86.i("INTENT_ACTION_VIDEO_PICK_FINISH");
    public static String g0 = "";
    public int F;
    public ChatItem G;
    public TextView J;
    public ViewGroup K;
    public View L;
    public View M;
    public ListView N;
    public ug3 O;
    public TextView Q;
    public TextView R;
    public View S;
    public Animation T;
    public Animation U;
    public int V;
    public TextView W;
    public GridView q;
    public com.zenmen.palmchat.chat.e r;
    public TextView s;
    public int y;
    public ArrayList<MediaItem> t = new ArrayList<>();
    public HashMap<String, ArrayList<MediaItem>> u = new HashMap<>();
    public long v = 3000;
    public long w = 3600000;
    public boolean x = false;
    public boolean z = true;
    public int A = 0;
    public float B = 1.0f;
    public String C = "";
    public int E = 9;
    public int H = 0;
    public boolean I = false;
    public boolean P = false;
    public int X = 0;
    public p Y = new p(this);
    public final BroadcastReceiver Z = new m();
    public boolean e0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "send_message");
            put("status", "sendImageInMediaPick");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12665a;

        public b(MediaItem mediaItem) {
            this.f12665a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i == 0) {
                lf5.i(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(Long.toString(this.f12665a.fileID)).build());
                return;
            }
            sd3 sd3Var = new sd3(MediaPickActivity.this);
            String string = AppContext.getContext().getString(R.string.video_filter_large);
            if (i == -2) {
                string = AppContext.getContext().getString(R.string.video_max);
            } else if (i == -3) {
                string = MediaPickActivity.this.getString(R.string.video_min, Integer.valueOf((int) (MediaPickActivity.this.v / 1000)));
            } else if (i == -4) {
                string = MediaPickActivity.this.getString(R.string.video_filter_unsupport);
            } else if (i == -5) {
                string = MediaPickActivity.this.getString(R.string.video_filter_not_exit);
            }
            sd3Var.k(string).O(R.string.alert_dialog_ok).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Comparator<MediaItem> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12667a;

        public d(MediaItem mediaItem) {
            this.f12667a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i != 0) {
                com.zenmen.palmchat.chat.h.h(MediaPickActivity.this, i);
            } else {
                tk3.k(MediaPickActivity.this, this.f12667a, 12);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Comparator<MediaItem> {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AsyncTask<Void, Void, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12669a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements bo2.a {
            public a() {
            }

            @Override // bo2.a
            public void onFinish(boolean z) {
                MediaPickActivity.this.setResult(-1);
                MediaPickActivity.this.finish();
            }
        }

        public f(String str) {
            this.f12669a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0025 A[DONT_GENERATE, PHI: r3
          0x0025: PHI (r3v5 android.graphics.Bitmap) = (r3v4 android.graphics.Bitmap), (r3v7 android.graphics.Bitmap) binds: [B:16:0x0023, B:11:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(Void... voidArr) {
            Bitmap bitmapDecodeFile;
            if (!TextUtils.isEmpty(this.f12669a)) {
                try {
                    bitmapDecodeFile = BitmapFactory.decodeFile(this.f12669a);
                } catch (Throwable th) {
                    th = th;
                    bitmapDecodeFile = null;
                }
                if (bitmapDecodeFile != null) {
                    try {
                        String strA = op4.a(bitmapDecodeFile);
                        bitmapDecodeFile.recycle();
                        return strA;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            return null;
                        } finally {
                            if (bitmapDecodeFile != null) {
                                bitmapDecodeFile.recycle();
                            }
                        }
                    }
                }
                if (bitmapDecodeFile != null) {
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            MediaPickActivity.this.hideBaseProgressBar();
            if (TextUtils.isEmpty(str)) {
                MediaPickActivity.this.Y1(3);
                Intent intent = new Intent(MediaPickActivity.this, (Class<?>) ResultActivity.class);
                intent.putExtra("mode", 1);
                MediaPickActivity.this.startActivity(intent);
                MediaPickActivity.this.setResult(-1);
                MediaPickActivity.this.finish();
                return;
            }
            bo2 bo2VarA = cq6.a(MediaPickActivity.this, str, 1, new a());
            if (bo2VarA == null) {
                MediaPickActivity.this.Y1(3);
            } else if (bo2VarA instanceof n71) {
                MediaPickActivity.this.Y1(2);
            } else {
                MediaPickActivity.this.Y1(1);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            MediaPickActivity.this.showBaseProgressBar(R.string.loading_qrcode, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaPickActivity mediaPickActivity = MediaPickActivity.this;
            mediaPickActivity.f2(mediaPickActivity.K.getVisibility() != 0, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaPickActivity.this.f2(false, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements AdapterView.OnItemClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<MediaItem> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
                return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
            }
        }

        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MediaPickActivity.this.f2(false, true);
            MediaPickActivity.this.O.a(i);
            bn2.c cVar = (bn2.c) MediaPickActivity.this.O.getItem(i);
            MediaPickActivity.this.J.setText(cVar.c);
            if (TextUtils.isEmpty(cVar.f1775a)) {
                MediaPickActivity.this.r.s(null, null);
                return;
            }
            ArrayList<MediaItem> arrayList = (ArrayList) MediaPickActivity.this.u.get(cVar.f1775a);
            Collections.sort(arrayList, new a());
            MediaPickActivity.this.r.s(cVar.f1775a, arrayList);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaPickActivity.this.I) {
                MediaPickActivity.this.W.setSelected(false);
            } else {
                MediaPickActivity.this.W.setSelected(true);
            }
            MediaPickActivity mediaPickActivity = MediaPickActivity.this;
            mediaPickActivity.I = true ^ mediaPickActivity.I;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends BroadcastReceiver {
        public m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(MediaPickActivity.f0)) {
                MediaPickActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<MediaItem> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
                return Long.valueOf(mediaItem.getSelectTime()).compareTo(Long.valueOf(mediaItem2.getSelectTime()));
            }
        }

        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, MediaPickActivity.this.H);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("M226", null, jSONObject.toString());
            MediaPickActivity.this.s.setEnabled(false);
            MediaPickActivity.this.f2(false, false);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(MediaPickActivity.this.r.k);
            Collections.sort(arrayList, new a());
            MediaPickActivity mediaPickActivity = MediaPickActivity.this;
            mediaPickActivity.d2(arrayList, mediaPickActivity.I);
            if ("from_moment".equals(MediaPickActivity.this.C)) {
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("select_picture", arrayList);
                MediaPickActivity.this.setResult(-1, intent);
            } else if ("from_chat".equals(MediaPickActivity.this.C)) {
                MediaPickActivity.this.setResult(-1);
            }
            MediaPickActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends HashMap<String, Object> {
        public o() {
            put("action", "send_message");
            put("status", "sendImageInMediaPick");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<MediaPickActivity> f12682a;

        public p(MediaPickActivity mediaPickActivity) {
            this.f12682a = new WeakReference<>(mediaPickActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f12682a.get() != null) {
                    this.f12682a.get().R.startAnimation(this.f12682a.get().T);
                }
            } else if (i == 1 && this.f12682a.get() != null) {
                this.f12682a.get().R.startAnimation(this.f12682a.get().U);
            }
        }
    }

    @Override // defpackage.sk3
    public void I0(int i2) {
        if (i2 != 0) {
            u92.c(this, i2);
        }
    }

    public final boolean U1() {
        int i2 = this.y;
        return (i2 == 0 && this.F == 0) || i2 == 3;
    }

    public final String V1(long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return calendar.get(3) == calendar2.get(3) ? getString(R.string.current_week) : calendar.get(2) == calendar2.get(2) ? getString(R.string.current_month) : String.format("%d/%d", Integer.valueOf(calendar2.get(1)), Integer.valueOf(calendar2.get(2) + 1));
    }

    public final void W1(MediaItem mediaItem) {
        if (mediaItem == null) {
            return;
        }
        com.zenmen.palmchat.chat.h.c(this, mediaItem, new d(mediaItem));
    }

    public final void X1(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("choice", z ? 1 : 2);
            LogUtil.uploadInfoImmediate("sysxc2", null, null, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void Y1(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            LogUtil.uploadInfoImmediate("sysxc3", null, null, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.sk3
    public void Z(int i2) {
        if (i2 != 0) {
            com.zenmen.palmchat.chat.h.h(this, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z1(MediaItem mediaItem) {
        boolean z;
        if (mediaItem == null) {
            return;
        }
        int i2 = 0;
        f2(false, false);
        long jA = ((wv.a() + 1) * 1000) - 1;
        if (jo6.J() && br3.b() && "from_moment".equals(this.C) && mediaItem.mimeType == 1) {
            long j2 = mediaItem.playLength;
            if (j2 > jA && j2 < 301000) {
                z = true;
            }
        } else {
            z = false;
        }
        if (z) {
            W1(mediaItem);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.addAll(this.r.k);
        Collections.sort(arrayList, new c());
        intent.putParcelableArrayListExtra("selectlist", arrayList);
        intent.putExtra(az.at, this.H);
        ArrayList<MediaItem> arrayListP = this.r.p();
        if ("from_moment".equals(this.C)) {
            int i3 = mediaItem.mimeType;
            if (i3 == 1) {
                intent.putExtra("need_load_bucket_video_list", true);
                intent.putExtra("firset_item_path", mediaItem.thumbnailPath);
                ArrayList arrayList2 = new ArrayList();
                if (arrayListP != null) {
                    for (int i4 = 0; i4 < arrayListP.size(); i4++) {
                        MediaItem mediaItem2 = arrayListP.get(i4);
                        if (mediaItem2.mimeType == 1) {
                            arrayList2.add(mediaItem2);
                        }
                    }
                }
                int i5 = 0;
                while (i2 < arrayList2.size()) {
                    if (((MediaItem) arrayList2.get(i2)).fileFullPath.equals(mediaItem.fileFullPath)) {
                        i5 = i2;
                    }
                    i2++;
                }
                intent.putExtra("total_size", arrayList2.size());
                intent.putExtra("selectIndex", i5);
            } else if (i3 == 0) {
                intent.putExtra("need_load_bucket_image_list", true);
                intent.putExtra("firset_item_path", mediaItem.fileFullPath);
                ArrayList arrayList3 = new ArrayList();
                if (arrayListP != null) {
                    for (int i6 = 0; i6 < arrayListP.size(); i6++) {
                        MediaItem mediaItem3 = arrayListP.get(i6);
                        if (mediaItem3.mimeType == 0) {
                            arrayList3.add(mediaItem3);
                        }
                    }
                }
                int i7 = 0;
                while (i2 < arrayList3.size()) {
                    if (((MediaItem) arrayList3.get(i2)).fileFullPath.equals(mediaItem.fileFullPath)) {
                        i7 = i2;
                    }
                    i2++;
                }
                intent.putExtra("total_size", arrayList3.size());
                intent.putExtra("selectIndex", i7);
            }
        } else {
            intent.putExtra("firset_item_path", mediaItem.fileFullPath);
            intent.putExtra("need_load_bucket_video_list", true);
            intent.putExtra("need_load_bucket_image_list", true);
            if (arrayListP != null) {
                int size = arrayListP.size();
                int i8 = 0;
                while (i8 < arrayListP.size()) {
                    if (arrayListP.get(i8).fileFullPath.equals(mediaItem.fileFullPath)) {
                        i2 = size;
                        break;
                    }
                    i8++;
                }
                i2 = size;
                i8 = 0;
                intent.putExtra("total_size", i2);
                intent.putExtra("selectIndex", i8);
            } else {
                i8 = 0;
                intent.putExtra("total_size", i2);
                intent.putExtra("selectIndex", i8);
            }
        }
        intent.putExtra("first_item", mediaItem);
        intent.putExtra("bucket_id", this.r.m());
        intent.putExtra("show_mode", 2);
        intent.putExtra("sendOriginImage", this.I);
        intent.putExtra("info_item", this.G);
        intent.putExtra("thread_biz_type", this.V);
        intent.putExtra("from", this.C);
        intent.putExtra("extra_key_max_num", this.E);
        startActivityForResult(intent, 10);
    }

    public final void a2() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, this.H);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("M225", null, jSONObject.toString());
    }

    public final void b2(String str) {
        X1(true);
        new f(str).execute(new Void[0]);
    }

    public final void c2(String str, boolean z) {
        String strA = xn3.a();
        ChatItem chatItem = this.G;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strE = DomainHelper.e(this.G);
        try {
            File file = new File(str);
            LogUtil.i("MediaPickActivity", "publishImage path = " + str);
            if (!file.exists()) {
                sy5.e(AppContext.getContext(), R.string.send_image_file_delete, 0).g();
            } else if (str.toLowerCase().endsWith(".gif")) {
                ExpressionObject expressionObject = new ExpressionObject();
                expressionObject.path = str;
                expressionObject.coverPath = str;
                expressionObject.md5 = rb3.c(str);
                getMessagingServiceInterface().r(MessageVo.buildGifExpressionMessage(strA, strE, expressionObject, 0).setThreadBizType(this, this.V));
            } else {
                PhotoObject photoObject = new PhotoObject();
                photoObject.path = str;
                getMessagingServiceInterface().r(MessageVo.buildImageMessage(strA, strE, photoObject, z, 0, null).setThreadBizType(this, this.V));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i("MediaPickActivity", 3, new a(), e2);
        }
    }

    public final void d2(ArrayList<MediaItem> arrayList, boolean z) {
        for (MediaItem mediaItem : arrayList) {
            int i2 = mediaItem.mimeType;
            if (i2 == 0) {
                c2(mediaItem.fileFullPath, z);
            } else if (i2 == 1) {
                e2(mediaItem);
            }
        }
    }

    public final void e2(MediaItem mediaItem) {
        String strE;
        String strA = xn3.a();
        ChatItem chatItem = this.G;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        try {
            if (com.zenmen.palmchat.chat.h.g(mediaItem.localPath) && !com.zenmen.palmchat.chat.h.g(mediaItem.thumbnailPath) && (strE = com.zenmen.palmchat.chat.h.e(mediaItem.localPath)) != null) {
                mediaItem.thumbnailPath = strE;
            }
            if (!com.zenmen.palmchat.chat.h.g(mediaItem.localPath) || !com.zenmen.palmchat.chat.h.g(mediaItem.thumbnailPath)) {
                sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
                return;
            }
            MessageVo threadBizType = MessageVo.buildVideoMessage(strA, DomainHelper.e(this.G), mediaItem.localPath, mediaItem.thumbnailPath, mediaItem.playLength, 0).setThreadBizType(this, this.V);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("video", threadBizType.data5);
                jSONObject.put("envir", this.G.getChatType() == 1 ? "2" : threadBizType.bizType == 0 ? "1" : "3");
                jSONObject.put("qua", "1");
                threadBizType.logExtension = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            getMessagingServiceInterface().r(threadBizType);
        } catch (Exception e3) {
            e3.printStackTrace();
            LogUtil.i("MediaPickActivity", 3, new o(), e3);
        }
    }

    public final void f2(boolean z, boolean z2) {
        this.P = z;
        if (!z2) {
            this.M.setVisibility(z ? 0 : 8);
            this.K.setVisibility(z ? 0 : 8);
        } else if (!z) {
            this.K.animate().yBy(this.K.getHeight()).start();
            this.M.setAlpha(1.0f);
            this.M.animate().alpha(0.0f).start();
        } else {
            this.K.setY(this.S.getY());
            this.K.animate().yBy(0.0f - this.K.getHeight()).start();
            this.M.setAlpha(0.0f);
            this.M.animate().alpha(1.0f).start();
        }
    }

    public final void g2() {
        if (!tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList) || this.e0) {
            return;
        }
        this.e0 = true;
        nk3.i().l(this);
    }

    @Override // defpackage.sk3
    public void h1(MediaItem mediaItem) {
        Z1(mediaItem);
    }

    public final void h2() {
        int size = this.r.k.size();
        String string = "from_moment".equals(this.C) ? getResources().getString(R.string.media_pick_activity_finish) : getResources().getString(R.string.media_pick_activity_send);
        if (size > 0) {
            string = "from_moment".equals(this.C) ? getResources().getString(R.string.media_pick_activity_finish_with_number, Integer.valueOf(size), Integer.valueOf(this.E)) : getResources().getString(R.string.media_pick_activity_send_with_number, Integer.valueOf(size), Integer.valueOf(this.E));
        }
        this.s.setText(string);
        if (size > 0) {
            this.Q.setText(getString(R.string.photo_grid_preview_number, Integer.valueOf(size)));
            this.Q.setEnabled(true);
            this.s.setEnabled(true);
        } else {
            this.Q.setText(getString(R.string.photo_grid_preview));
            this.Q.setEnabled(false);
            this.s.setEnabled(false);
        }
        if (U1()) {
            this.J.setText(getString(R.string.photo_grid_all));
        } else {
            this.J.setText(getString(R.string.photo_grid_all_image));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    @Override // defpackage.sk3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i1(MediaItem mediaItem) throws Throwable {
        Uri uriFromFile;
        int i2 = this.y;
        if (i2 == 0) {
            com.zenmen.palmchat.chat.e eVar = this.r;
            if (eVar == null || eVar.k == null) {
                return;
            }
            h2();
            return;
        }
        if (i2 == 1) {
            if (mediaItem != null) {
                if (mediaItem.fileFullPath != null) {
                    File file = new File(mediaItem.fileFullPath);
                    uriFromFile = file.exists() ? Uri.fromFile(file) : null;
                }
                if (uriFromFile != null) {
                    Uri uriFromFile2 = Uri.fromFile(new File(pu1.j()));
                    if ("from_square_publish".equals(this.C)) {
                        new dr0(uriFromFile).d(uriFromFile2).c(1440).e(0.75f).f(this);
                        return;
                    } else {
                        new dr0(uriFromFile).d(uriFromFile2).a(this.z).c(this.A).e(this.B).f(this);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (mediaItem != null) {
                String strO = k86.o(getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(Long.toString(mediaItem.fileID)).build());
                Intent intent = new Intent();
                intent.setClass(this, ExpressionPreviewActivity.class);
                intent.putExtra("file_path", strO);
                startActivityForResult(intent, 2);
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (mediaItem != null) {
                com.zenmen.palmchat.chat.h.b(this, mediaItem, this.v, this.w, new b(mediaItem));
            }
        } else {
            if (i2 != 4 || mediaItem == null || l50.a()) {
                return;
            }
            String strO2 = k86.o(getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(Long.toString(mediaItem.fileID)).build());
            if (this.C.equals("from_qrcode_scanner")) {
                b2(strO2);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("file_path", strO2);
            setResult(-1, intent2);
            finish();
        }
    }

    public final void i2() {
        this.W.setSelected(this.I);
        h2();
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        TextView textView = (TextView) getToolbar().findViewById(R.id.title);
        if (this.y == 3) {
            textView.setText(R.string.media_pick_activity_title_video);
        } else {
            textView.setText(R.string.media_pick_activity_title);
        }
        toolbarInitToolbar.findViewById(R.id.action_button).setVisibility(8);
        TextView textView2 = (TextView) toolbarInitToolbar.findViewById(R.id.photo_grid_preview);
        this.Q = textView2;
        textView2.setVisibility(0);
        this.s = (TextView) findViewById(R.id.tv_action);
        if ("from_moment".equals(this.C)) {
            this.s.setText(R.string.media_pick_activity_finish);
        } else {
            this.s.setText(R.string.media_pick_activity_send);
        }
        this.s.setEnabled(false);
        int i2 = this.y;
        if (i2 == 0) {
            this.s.setOnClickListener(new n());
        } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            this.s.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i2, int i3, Intent intent) throws Throwable {
        MediaItem mediaItem;
        Uri uriFromFile;
        if (i2 == 9162 && i3 == -1) {
            return;
        }
        if (i2 == 6709 && i3 == -1 && intent != null) {
            Intent intent2 = new Intent();
            Uri uri = (Uri) intent.getParcelableExtra("output");
            if (uri != null) {
                String path = uri.getPath();
                intent2.putExtra("media_pick_photo_key", path);
                intent2.putExtra("media_pick_photo_key_error", intent.getSerializableExtra("error"));
                setResult(-1, intent2);
                c2(path, this.I);
                finish();
                return;
            }
            return;
        }
        if (i2 == 1 && i3 == -1) {
            if (g0 != null) {
                File file = new File(g0);
                uriFromFile = file.exists() ? Uri.fromFile(file) : null;
            }
            wm3.a(g0);
            int i4 = this.y;
            if (i4 == 1) {
                if (uriFromFile != null) {
                    new dr0(uriFromFile).d(Uri.fromFile(new File(pu1.j()))).a(this.z).c(this.A).e(this.B).f(this);
                    return;
                }
                return;
            }
            if (i4 != 0) {
                if (i4 != 2 || uriFromFile == null) {
                    return;
                }
                String strO = k86.o(getContentResolver(), uriFromFile);
                Intent intent3 = new Intent();
                intent3.setClass(this, ExpressionPreviewActivity.class);
                intent3.putExtra("file_path", strO);
                startActivityForResult(intent3, 2);
                return;
            }
            Intent intent4 = new Intent();
            intent4.setClass(this, PhotoViewActivity.class);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            MediaItem mediaItem2 = new MediaItem();
            mediaItem2.fileFullPath = g0;
            mediaItem2.fileSize = new File(g0).length();
            arrayList.add(mediaItem2);
            intent4.putParcelableArrayListExtra("mediaList", arrayList);
            intent4.putParcelableArrayListExtra("selectlist", arrayList);
            intent4.putExtra("selectIndex", 0);
            intent4.putExtra(az.at, this.H);
            intent4.putExtra("show_mode", 2);
            intent4.putExtra("info_item", this.G);
            intent4.putExtra("sendOriginImage", this.I);
            intent4.putExtra("thread_biz_type", this.V);
            intent4.putExtra("from", this.C);
            startActivityForResult(intent4, 11);
            return;
        }
        if ((i2 == 10 || i2 == 11) && i3 == 0) {
            if (intent != null) {
                this.I = intent.getBooleanExtra("sendOriginImage", false);
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectlist");
                if (parcelableArrayListExtra == null || i2 != 10) {
                    return;
                }
                this.r.k.clear();
                this.r.k.addAll(parcelableArrayListExtra);
                this.r.notifyDataSetChanged();
                com.zenmen.palmchat.chat.e eVar = this.r;
                if (eVar == null || eVar.k == null) {
                    return;
                }
                i2();
                return;
            }
            return;
        }
        if (i2 == 10 && i3 == -1) {
            if ("from_moment".equals(this.C)) {
                Intent intent5 = new Intent();
                if (intent != null) {
                    intent5.putParcelableArrayListExtra("select_picture", intent.getParcelableArrayListExtra("sendPendingList"));
                }
                setResult(-1, intent5);
            } else if ("from_chat".equals(this.C)) {
                setResult(-1);
            }
            finish();
            return;
        }
        if (i2 == 11 && i3 == -1) {
            if ("from_moment".equals(this.C)) {
                Intent intent6 = new Intent();
                if (intent != null) {
                    intent6.putParcelableArrayListExtra("select_picture", intent.getParcelableArrayListExtra("sendPendingList"));
                }
                setResult(-1, intent6);
            }
            finish();
            return;
        }
        if (i2 == 2 && i3 == -1) {
            setResult(-1, intent);
            finish();
            return;
        }
        if (i2 == 106 && i3 == -1) {
            if ("from_moment".equals(this.C)) {
                Intent intent7 = new Intent();
                intent7.setClass(this, PhotoViewActivity.class);
                intent7.putExtra(az.at, this.H);
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.r.k);
                if (intent != null) {
                    arrayList2.add((MediaItem) intent.getParcelableExtra("EXTRA_RECORD_ITEM"));
                }
                intent7.putParcelableArrayListExtra("select_picture", arrayList2);
                setResult(-1, intent7);
                finish();
                return;
            }
            return;
        }
        if (i2 == 12 && i3 == -1) {
            if ("from_moment".equals(this.C) && intent != null && (mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_CROP_ITEM")) != null) {
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                arrayList3.add(mediaItem);
                Intent intent8 = new Intent();
                intent8.putParcelableArrayListExtra("select_picture", arrayList3);
                setResult(-1, intent8);
            }
            finish();
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LogUtil.i("MediaPickActivity", "onCreate");
        super.onCreate(bundle);
        if (bundle != null) {
            String string = bundle.getString("mCurrentPhotoPath");
            if (!TextUtils.isEmpty(string)) {
                g0 = string;
            }
        }
        setContentView(R.layout.layout_activity_media_pick);
        Intent intent = getIntent();
        this.C = intent.getStringExtra("from");
        this.E = intent.getIntExtra("extra_key_max_num", 9);
        this.F = intent.getIntExtra("extra_key_mode", 0);
        this.y = intent.getIntExtra("select_mode_key", 0);
        this.z = intent.getBooleanExtra("crop_portrait", true);
        this.A = intent.getIntExtra("crop_max_size", 0);
        this.B = intent.getFloatExtra("crop_ratio", 1.0f);
        this.G = (ChatItem) intent.getParcelableExtra("chat_item");
        this.V = intent.getIntExtra("thread_biz_type", 0);
        this.H = intent.getIntExtra(az.at, 0);
        this.X = intent.getIntExtra("toast_layout", 0);
        this.x = intent.getBooleanExtra("extra_key_video_filter_time", false);
        this.v = intent.getLongExtra("extra_key_video_min_time", this.v);
        initActionBar();
        this.q = (GridView) findViewById(R.id.media_grid_view);
        com.zenmen.palmchat.chat.e eVar = new com.zenmen.palmchat.chat.e(this, this, this.y, this.E, this.C, this.x, this.v, this.w);
        this.r = eVar;
        this.q.setAdapter((ListAdapter) eVar);
        this.q.setOnScrollListener(this);
        int i2 = this.y;
        if (i2 == 1 || i2 == 2 || i2 == 4) {
            this.Q.setVisibility(8);
        }
        this.S = findViewById(R.id.bottomContainer);
        this.J = (TextView) findViewById(R.id.media_folder_pick_btn);
        View viewFindViewById = findViewById(R.id.media_folder_pick_area);
        this.L = viewFindViewById;
        viewFindViewById.setOnClickListener(new g());
        View viewFindViewById2 = findViewById(R.id.media_folder_pick_bg_view);
        this.M = viewFindViewById2;
        viewFindViewById2.animate().setDuration(300L);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.media_folder_pick_layout);
        this.K = viewGroup;
        viewGroup.setOnClickListener(new h());
        this.K.animate().setDuration(300L).setListener(new i());
        this.N = (ListView) findViewById(R.id.media_folder_pick_list);
        ug3 ug3Var = new ug3(this, null);
        this.O = ug3Var;
        this.N.setAdapter((ListAdapter) ug3Var);
        this.N.setOnItemClickListener(new j());
        this.R = (TextView) findViewById(R.id.date_text);
        this.T = AnimationUtils.loadAnimation(this, R.anim.alpha_fade_in);
        this.U = AnimationUtils.loadAnimation(this, R.anim.alpha_fade_out);
        k kVar = new k();
        this.T.setAnimationListener(kVar);
        this.U.setAnimationListener(kVar);
        TextView textView = (TextView) findViewById(R.id.originSizeTv);
        this.W = textView;
        int i3 = this.y;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            textView.setVisibility(8);
        }
        if ("from_moment".equals(this.C)) {
            this.W.setVisibility(8);
        }
        this.W.setOnClickListener(new l());
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.toast_container);
        if (this.X != 0) {
            LayoutInflater.from(this).inflate(this.X, viewGroup2, true);
            viewGroup2.setVisibility(0);
        }
        i2();
        nk3.i().addObserver(this);
        a2();
        String str = this.C;
        if (str == null || !(str.equals("from_js") || this.C.equals("from_person_info"))) {
            String str2 = this.C;
            if (str2 == null || !str2.equals("from_qrcode_scanner")) {
                BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_STORAGE);
            } else {
                BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_QRCODE);
            }
        } else {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_STORAGE_HEADICON);
        }
        if (this.y == 3) {
            this.S.setVisibility(8);
        }
        registerLocalReceiver(this.Z, new IntentFilter(f0));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        nk3.i().deleteObserver(this);
        unregisterLocalReceiver(this.Z);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        String str;
        if (i2 == 4 && this.K.getVisibility() == 0) {
            f2(false, true);
            return true;
        }
        if (i2 == 4 && (str = this.C) != null && str.equals("from_qrcode_scanner")) {
            X1(false);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.K.getVisibility() == 0) {
            f2(false, true);
        } else {
            String str = this.C;
            if (str != null && str.equals("from_qrcode_scanner")) {
                X1(false);
            }
            finish();
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_QRCODE) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType != BaseActivityPermissionDispatcher.PermissionType.CAMERA) {
            if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
                g2();
                return;
            }
            if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_RECORD) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, this.H);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("M221", null, jSONObject.toString());
                if (this.E == 9 && this.r.k.isEmpty()) {
                    tk3.f(this, 0, 106, this.H);
                    return;
                } else {
                    tk3.f(this, 1, 106, this.H);
                    return;
                }
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(az.at, this.H);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("M221", null, jSONObject2.toString());
        g0 = pu1.o(this);
        try {
            pu1.t();
            File file = new File(pu1.j);
            if (file.exists() || file.mkdir()) {
                Uri uriForFile = FileProvider.getUriForFile(this, "com.zenmen.palmchat.webplatform.file.provider", new File(g0));
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.addFlags(3);
                intent.putExtra("output", uriForFile);
                startActivityForResult(intent, 1);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void onPreviewClick(View view) {
        f2(false, false);
        Intent intent = new Intent();
        intent.setClass(this, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.addAll(this.r.k);
        Collections.sort(arrayList, new e());
        intent.putExtra(az.at, this.H);
        intent.putParcelableArrayListExtra("mediaList", arrayList);
        intent.putParcelableArrayListExtra("selectlist", arrayList);
        intent.putExtra("selectIndex", 0);
        intent.putExtra("show_mode", 2);
        intent.putExtra("sendOriginImage", this.I);
        intent.putExtra("info_item", this.G);
        intent.putExtra("thread_biz_type", this.V);
        intent.putExtra("from", this.C);
        intent.putExtra("extra_key_max_num", this.E);
        startActivityForResult(intent, 10);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g2();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCurrentPhotoPath", g0);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        MediaItem mediaItemO = this.r.getItem(i2);
        if (mediaItemO == null) {
            mediaItemO = this.r.getItem(i2 + 1);
        }
        if (mediaItemO != null) {
            TextView textView = this.R;
            long j2 = mediaItemO.modifyTime;
            if (j2 < 2147483647L) {
                j2 *= 1000;
            }
            textView.setText(V1(j2));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            this.Y.sendEmptyMessageDelayed(1, 1000L);
            return;
        }
        this.Y.removeMessages(1);
        if (this.R.getVisibility() != 0) {
            this.Y.removeMessages(0);
            this.Y.sendEmptyMessage(0);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    @Override // defpackage.sk3
    public void r0() {
        if (com.zenmen.palmchat.videocall.c.f()) {
            return;
        }
        if (!"from_moment".equals(this.C) || this.y == 1) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_CAMERA);
        } else {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.VIDEO_RECORD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_MOMENT_CAMERA);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        LogUtil.d("MediaPickActivity", "observable update");
        Log.i("MediaPickActivity", "observable  update");
        bn2.b bVar = (bn2.b) obj;
        bn2.a aVar = U1() ? bVar.b : bVar.c;
        this.t.clear();
        if (this.y == 3 || this.x) {
            ArrayList arrayList = new ArrayList();
            for (MediaItem mediaItem : aVar.f1773a) {
                if (mediaItem.mimeType == 1) {
                    arrayList.add(mediaItem);
                }
            }
            this.t.addAll(arrayList);
        } else {
            this.t.addAll(aVar.f1773a);
        }
        this.r.u(this.t);
        this.J.setEnabled(true);
        this.u.clear();
        this.u.putAll(aVar.c);
        this.O.b(aVar.b);
        nk3.i().deleteObserver(this);
        nk3.i().addObserver(this);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Animator.AnimatorListener {
        public i() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MediaPickActivity.this.P) {
                return;
            }
            MediaPickActivity.this.K.setVisibility(8);
            MediaPickActivity.this.M.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (MediaPickActivity.this.P) {
                MediaPickActivity.this.M.setVisibility(0);
                MediaPickActivity.this.K.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Animation.AnimationListener {
        public k() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation == MediaPickActivity.this.U) {
                MediaPickActivity.this.R.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (animation == MediaPickActivity.this.T) {
                MediaPickActivity.this.R.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
