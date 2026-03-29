package com.zenmen.palmchat.activity.photoview;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.toolbox.Volley;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.photoview.a;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.ChatPhotoGridActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.br2;
import defpackage.ch;
import defpackage.cq6;
import defpackage.cr2;
import defpackage.dm1;
import defpackage.dr2;
import defpackage.ds0;
import defpackage.dt0;
import defpackage.g13;
import defpackage.gi4;
import defpackage.gl2;
import defpackage.h22;
import defpackage.ho3;
import defpackage.il5;
import defpackage.is0;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.o86;
import defpackage.pu1;
import defpackage.px5;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.sd1;
import defpackage.sd3;
import defpackage.sn2;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tk3;
import defpackage.u92;
import defpackage.uk5;
import defpackage.wf1;
import defpackage.wm3;
import defpackage.wv;
import defpackage.xa6;
import defpackage.xn3;
import defpackage.yy3;
import defpackage.zs0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhotoViewActivity extends BasePreviewActivity implements Animation.AnimationListener, gl2, a.b {
    public static final String T0 = "PhotoViewActivity";
    public boolean A;
    public boolean B;
    public boolean C;
    public int D0;
    public int F0;
    public String G0;
    public View K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public SeekBar O0;
    public gi4 Q0;
    public boolean R;
    public Toolbar S;
    public TextView T;
    public TextView U;
    public View V;
    public View W;
    public RelativeLayout X;
    public View Y;
    public TextView Z;
    public ImageView e0;
    public TextView f0;
    public TextView g0;
    public ImageView h0;
    public ImageView i0;
    public ImageView j0;
    public View k0;
    public TextView l0;
    public PhotoViewFragmentAdapter n0;
    public Animation o0;
    public Animation p0;
    public ViewPager q;
    public HorizontalScrollView q0;
    public ChatItem r;
    public LinearLayout r0;
    public com.zenmen.palmchat.activity.photoview.a s0;
    public ArrayList<MediaItem> w0;
    public boolean y;
    public boolean z;
    public ArrayList<MediaItem> s = new ArrayList<>();
    public ArrayList<MediaItem> t = new ArrayList<>();
    public ArrayList<a.c> u = new ArrayList<>();
    public int v = 9;
    public int w = 0;
    public int x = 0;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public String H = null;
    public String I = null;
    public int J = 0;
    public String K = null;
    public MessageVo L = null;
    public MediaItem M = null;
    public boolean N = false;
    public boolean O = false;
    public boolean P = true;
    public ArrayList<MediaItem> Q = new ArrayList<>();
    public ArrayList<MediaItem> m0 = new ArrayList<>();
    public String[] t0 = {AppContext.getContext().getResources().getString(R.string.select_from_album), AppContext.getContext().getResources().getString(R.string.save_to_phone)};
    public boolean u0 = false;
    public boolean v0 = true;
    public HashMap<String, Integer> x0 = new HashMap<>();
    public int y0 = 0;
    public boolean z0 = false;
    public boolean A0 = false;
    public int B0 = 0;
    public l0 C0 = new l0(this);
    public boolean E0 = true;
    public boolean H0 = false;
    public long I0 = ((wv.a() + 1) * 1000) - 1;
    public long J0 = 1000;
    public boolean P0 = false;
    public boolean R0 = false;
    public is0.f S0 = new z();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewActivity.this.s == null || PhotoViewActivity.this.s.size() <= PhotoViewActivity.this.x) {
                return;
            }
            MediaItem mediaItem = (MediaItem) PhotoViewActivity.this.s.get(PhotoViewActivity.this.x);
            if (PhotoViewActivity.this.w0.contains(mediaItem)) {
                PhotoViewActivity.this.w0.remove(mediaItem);
                PhotoViewActivity.this.j0.setImageResource(R.drawable.icon_white_uncheck);
            } else {
                PhotoViewActivity.this.w0.add(mediaItem);
                PhotoViewActivity.this.j0.setImageResource(R.drawable.icon_green_checked);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12294a;

        public a0(uk5 uk5Var) {
            this.f12294a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (this.f12294a.f21235a == 7 && PhotoViewActivity.this.s != null && PhotoViewActivity.this.s.size() > PhotoViewActivity.this.q.getCurrentItem()) {
                MediaItem mediaItem = (MediaItem) PhotoViewActivity.this.s.get(PhotoViewActivity.this.q.getCurrentItem());
                ArrayList<T> arrayList = this.f12294a.c;
                if (arrayList == 0 || !arrayList.contains(mediaItem.mid)) {
                    return;
                }
                PhotoViewActivity.this.w3(mediaItem.mid);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewActivity.this.i0.getVisibility() != 0) {
                PhotoViewActivity.this.i0.startAnimation(PhotoViewActivity.this.o0);
            }
            if (PhotoViewActivity.this.u0) {
                Intent intent = new Intent();
                intent.putExtra("current_viewing_photo_index", PhotoViewActivity.this.x);
                PhotoViewActivity.this.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent(PhotoViewActivity.this, (Class<?>) ChatPhotoGridActivity.class);
                intent2.putExtra("info_item", PhotoViewActivity.this.r);
                intent2.putExtra("need_start_photo_view_activity", true);
                intent2.putExtra("current_viewing_photo_index", PhotoViewActivity.this.x);
                if (PhotoViewActivity.this.J == 1) {
                    PhotoViewActivity.this.getWindow().setFlags(2048, 2048);
                }
                PhotoViewActivity.this.startActivity(intent2);
            }
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 extends MaterialDialog.e {
        public b0() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.l3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.m3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 extends AsyncTask<Void, Void, ArrayList<MediaItem>> {
        public d0() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00dd A[Catch: all -> 0x013a, TryCatch #0 {all -> 0x013a, blocks: (B:12:0x00b5, B:14:0x00cf, B:17:0x00d7, B:19:0x00dd, B:23:0x0113, B:26:0x0127, B:29:0x012c), top: B:37:0x00b5 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x012c A[Catch: all -> 0x013a, TRY_LEAVE, TryCatch #0 {all -> 0x013a, blocks: (B:12:0x00b5, B:14:0x00cf, B:17:0x00d7, B:19:0x00dd, B:23:0x0113, B:26:0x0127, B:29:0x012c), top: B:37:0x00b5 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0136 A[DONT_GENERATE] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ArrayList<MediaItem> doInBackground(Void... voidArr) {
            String str;
            String[] strArr;
            String str2;
            String[] strArr2;
            ArrayList<MediaItem> arrayList = new ArrayList<>();
            if (PhotoViewActivity.this.r != null) {
                String[] strArr3 = {"_id", "packet_id", "data1", "data3", "data4", "msg_type", "attach_status", "data6"};
                Cursor cursorQuery = null;
                int i = 0;
                try {
                    if (PhotoViewActivity.this.r.getChatType() == 0) {
                        strArr2 = new String[]{DomainHelper.a(PhotoViewActivity.this.r, false)};
                        str2 = "contact_relate=? and (msg_type=2 or msg_type=4)";
                    } else if (PhotoViewActivity.this.r.getChatType() == 1) {
                        boolean zC = com.zenmen.palmchat.database.a.c();
                        str2 = "contact_relate" + com.zenmen.palmchat.database.a.b(zC) + " and (msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + "2 or msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + "4)";
                        strArr2 = new String[]{DomainHelper.e(PhotoViewActivity.this.r) + com.zenmen.palmchat.database.a.a(zC)};
                    } else {
                        str = null;
                        strArr = null;
                        cursorQuery = PhotoViewActivity.this.getContentResolver().query(DBUriManager.b(ho3.class, PhotoViewActivity.this.r), strArr3, str, strArr, "_id ASC");
                        if (cursorQuery != null && cursorQuery.getCount() > 0) {
                            int i2 = 0;
                            int i3 = 0;
                            while (cursorQuery.moveToNext()) {
                                MediaItem mediaItem = new MediaItem();
                                mediaItem.mid = cursorQuery.getString(1);
                                mediaItem.localPath = cursorQuery.getString(2);
                                mediaItem.fileFullPath = cursorQuery.getString(3);
                                mediaItem.extension = cursorQuery.getString(4);
                                mediaItem.mimeType = cursorQuery.getInt(5);
                                int i4 = cursorQuery.getInt(6);
                                mediaItem.playLength = cursorQuery.getLong(7);
                                mediaItem.isFileExpired = i4 == 5;
                                arrayList.add(mediaItem);
                                if (mediaItem.mid.equals(PhotoViewActivity.this.I)) {
                                    i2 = i3;
                                }
                                i3++;
                            }
                            i = i2;
                        }
                        if (i != 0) {
                            PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                            photoViewActivity.w = i;
                            photoViewActivity.x = i;
                        }
                    }
                    cursorQuery = PhotoViewActivity.this.getContentResolver().query(DBUriManager.b(ho3.class, PhotoViewActivity.this.r), strArr3, str, strArr, "_id ASC");
                    if (cursorQuery != null) {
                        int i22 = 0;
                        int i32 = 0;
                        while (cursorQuery.moveToNext()) {
                        }
                        i = i22;
                    }
                    if (i != 0) {
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
                strArr = strArr2;
                str = str2;
            }
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<MediaItem> arrayList) {
            if (PhotoViewActivity.this.isDestroyed() || PhotoViewActivity.this.isFinishing()) {
                return;
            }
            PhotoViewActivity.this.s = arrayList;
            PhotoViewActivity.this.B3();
            PhotoViewActivity.this.G3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaItem mediaItemW2 = PhotoViewActivity.this.W2();
            if (mediaItemW2 != null) {
                int i = mediaItemW2.mimeType;
                if (i == 1) {
                    PhotoViewActivity.this.m3();
                } else if (i == 0) {
                    PhotoViewActivity.this.n3();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 extends AsyncTask<Void, Void, ArrayList<MediaItem>> {
        public e0() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<MediaItem> doInBackground(Void... voidArr) {
            String str;
            String[] strArr;
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = {"_id", "_data", "_display_name", "date_modified", "_size", "bucket_id", "bucket_display_name"};
            if (TextUtils.isEmpty(PhotoViewActivity.this.H)) {
                str = null;
                strArr = null;
            } else {
                strArr = new String[]{PhotoViewActivity.this.H};
                str = "bucket_id=?";
            }
            Cursor cursorQuery = PhotoViewActivity.this.getContentResolver().query(uri, strArr2, str, strArr, "date_modified DESC");
            ArrayList<MediaItem> arrayList = new ArrayList<>();
            int i = 0;
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        int i2 = 0;
                        int i3 = 0;
                        while (cursorQuery.moveToNext()) {
                            int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("date_modified"));
                            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                            int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("bucket_id"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                            if (j2 != 0 && !TextUtils.isEmpty(string) && new File(string).exists()) {
                                MediaItem mediaItem = new MediaItem();
                                mediaItem.fileID = i4;
                                mediaItem.fileFullPath = string;
                                mediaItem.fileName = string2;
                                mediaItem.modifyTime = j;
                                mediaItem.fileSize = j2;
                                mediaItem.mid = String.valueOf(i5);
                                mediaItem.extension = string3;
                                mediaItem.mimeType = 0;
                                arrayList.add(mediaItem);
                                if (mediaItem.fileFullPath.equals(PhotoViewActivity.this.K)) {
                                    i2 = i3;
                                }
                                i3++;
                            }
                        }
                        i = i2;
                    }
                } finally {
                    cursorQuery.close();
                }
            }
            PhotoViewActivity.this.x = i;
            LogUtil.d(PhotoViewActivity.T0, "loadBucketPhotos size = " + arrayList.size());
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<MediaItem> arrayList) {
            String str = PhotoViewActivity.T0;
            LogUtil.d(str, "loadBucketPhotos finished， size = " + arrayList.size());
            if (PhotoViewActivity.this.isDestroyed() || PhotoViewActivity.this.isFinishing()) {
                return;
            }
            PhotoViewActivity.this.A0 = true;
            if ("from_moment".equals(PhotoViewActivity.this.G0) || !PhotoViewActivity.this.G) {
                PhotoViewActivity.this.H0 = true;
            } else if (PhotoViewActivity.this.G && PhotoViewActivity.this.z0) {
                PhotoViewActivity.this.H0 = true;
            }
            if (arrayList.size() > 0) {
                PhotoViewActivity.this.t.addAll(arrayList);
            }
            PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
            if (photoViewActivity.H0 && !"from_moment".equals(photoViewActivity.G0)) {
                PhotoViewActivity photoViewActivity2 = PhotoViewActivity.this;
                photoViewActivity2.s = photoViewActivity2.t;
                PhotoViewActivity.this.y3();
            }
            PhotoViewActivity photoViewActivity3 = PhotoViewActivity.this;
            if (photoViewActivity3.H0) {
                photoViewActivity3.s = photoViewActivity3.t;
                LogUtil.i(str, "loadBucketPhotos loadFinished, size = " + PhotoViewActivity.this.s.size());
                PhotoViewActivity.this.B3();
                PhotoViewActivity.this.G3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 extends AsyncTask<Void, Void, ArrayList<MediaItem>> {
        public f0() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0130 A[Catch: Exception -> 0x01ea, all -> 0x0221, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0221, blocks: (B:16:0x00af, B:27:0x00fe, B:31:0x010b, B:33:0x0111, B:42:0x018a, B:44:0x0190, B:46:0x019b, B:48:0x01c1, B:51:0x01d4, B:35:0x0130, B:37:0x015d, B:39:0x017d, B:57:0x01e6, B:58:0x01e9, B:63:0x0201, B:62:0x01f6), top: B:92:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x015d A[Catch: Exception -> 0x0102, all -> 0x0221, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0221, blocks: (B:16:0x00af, B:27:0x00fe, B:31:0x010b, B:33:0x0111, B:42:0x018a, B:44:0x0190, B:46:0x019b, B:48:0x01c1, B:51:0x01d4, B:35:0x0130, B:37:0x015d, B:39:0x017d, B:57:0x01e6, B:58:0x01e9, B:63:0x0201, B:62:0x01f6), top: B:92:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x017d A[Catch: Exception -> 0x01ea, all -> 0x0221, TRY_ENTER, TryCatch #1 {all -> 0x0221, blocks: (B:16:0x00af, B:27:0x00fe, B:31:0x010b, B:33:0x0111, B:42:0x018a, B:44:0x0190, B:46:0x019b, B:48:0x01c1, B:51:0x01d4, B:35:0x0130, B:37:0x015d, B:39:0x017d, B:57:0x01e6, B:58:0x01e9, B:63:0x0201, B:62:0x01f6), top: B:92:0x004d }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0246  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList<com.zenmen.palmchat.framework.mediapick.MediaItem>] */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v35 */
        /* JADX WARN: Type inference failed for: r3v36 */
        /* JADX WARN: Type inference failed for: r3v37 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [int] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ArrayList<MediaItem> doInBackground(Void... voidArr) throws Throwable {
            String str;
            String[] strArr;
            Cursor cursor;
            ?? r3;
            Cursor cursor2;
            Cursor cursor3;
            ?? count;
            Cursor cursor4;
            ArrayList arrayList;
            int i;
            Cursor cursor5;
            String string;
            String str2;
            ArrayList arrayList2;
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = {"_id", "_data", "_display_name", "date_modified", "_size", "bucket_id", "bucket_display_name", "duration"};
            if (TextUtils.isEmpty(PhotoViewActivity.this.H)) {
                str = null;
                strArr = null;
            } else {
                str = "bucket_id=?";
                strArr = new String[]{PhotoViewActivity.this.H};
            }
            ArrayList arrayList3 = new ArrayList();
            try {
                Cursor cursorQuery = PhotoViewActivity.this.getContentResolver().query(uri, strArr2, str, strArr, "date_modified DESC");
                if (cursorQuery != null) {
                    try {
                        count = cursorQuery.getCount();
                        try {
                            try {
                                if (count > 0) {
                                    int i2 = 0;
                                    int i3 = 0;
                                    while (cursorQuery.moveToNext()) {
                                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("date_modified"));
                                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                                        int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("bucket_id"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                                        int i6 = i2;
                                        long j3 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("duration"));
                                        cursor3 = cursorQuery;
                                        ArrayList arrayList4 = arrayList3;
                                        try {
                                            try {
                                                Cursor cursorQuery2 = PhotoViewActivity.this.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "video_id"}, "video_id=?", new String[]{i4 + ""}, null);
                                                if (cursorQuery2 != null) {
                                                    try {
                                                        string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data")) : null;
                                                        if (cursorQuery2 != null) {
                                                            try {
                                                                cursorQuery2.close();
                                                            } catch (Exception e) {
                                                                e = e;
                                                                cursor = cursor3;
                                                                r3 = arrayList4;
                                                                try {
                                                                    e.printStackTrace();
                                                                    if (cursor != null) {
                                                                    }
                                                                    return r3;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    if (cursor != null) {
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                        if (string == null && pu1.b(string)) {
                                                            LogUtil.d(PhotoViewActivity.T0, "getthumbnailfrom storage, index = " + i3 + "path = " + string);
                                                        } else {
                                                            str2 = (pu1.f + File.separator) + i4 + ".thumbnail";
                                                            if (pu1.b(str2)) {
                                                                LogUtil.d(PhotoViewActivity.T0, "getthumbnailfrom null");
                                                            } else {
                                                                LogUtil.d(PhotoViewActivity.T0, "getthumbnailfrom cache, index = " + i3 + ",path = " + str2);
                                                                string = str2;
                                                            }
                                                        }
                                                        if (j2 == 0 && !TextUtils.isEmpty(string2) && new File(string2).exists()) {
                                                            MediaItem mediaItem = new MediaItem();
                                                            mediaItem.fileID = i4;
                                                            mediaItem.fileFullPath = string2;
                                                            mediaItem.fileName = string3;
                                                            mediaItem.modifyTime = j;
                                                            mediaItem.fileSize = j2;
                                                            mediaItem.mid = String.valueOf(i5);
                                                            mediaItem.extension = string4;
                                                            mediaItem.playLength = j3;
                                                            mediaItem.mimeType = 1;
                                                            mediaItem.thumbnailPath = string;
                                                            mediaItem.localPath = string2;
                                                            mediaItem.localThumbPath = string;
                                                            arrayList2 = arrayList4;
                                                            arrayList2.add(mediaItem);
                                                            if (mediaItem.fileFullPath.equals(PhotoViewActivity.this.K)) {
                                                                i6 = i3;
                                                            }
                                                            i3++;
                                                        } else {
                                                            arrayList2 = arrayList4;
                                                        }
                                                        arrayList3 = arrayList2;
                                                        i2 = i6;
                                                        cursorQuery = cursor3;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        cursor5 = cursorQuery2;
                                                        if (cursor5 != null) {
                                                            cursor5.close();
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (cursorQuery2 != null) {
                                                }
                                                if (string == null) {
                                                    str2 = (pu1.f + File.separator) + i4 + ".thumbnail";
                                                    if (pu1.b(str2)) {
                                                    }
                                                }
                                                if (j2 == 0) {
                                                    arrayList2 = arrayList4;
                                                }
                                                arrayList3 = arrayList2;
                                                i2 = i6;
                                                cursorQuery = cursor3;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                cursor5 = null;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            count = arrayList4;
                                            cursor = cursor3;
                                            r3 = count;
                                            e.printStackTrace();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            return r3;
                                        }
                                    }
                                    cursor4 = cursorQuery;
                                    int i7 = i2;
                                    arrayList = arrayList3;
                                    i = i7;
                                } else {
                                    cursor4 = cursorQuery;
                                    arrayList = arrayList3;
                                    LogUtil.d(PhotoViewActivity.T0, "loadBucketVideos cursor is null ");
                                    i = 0;
                                }
                                LogUtil.d(PhotoViewActivity.T0, "loadBucketVideos listsize = " + arrayList.size());
                                PhotoViewActivity.this.x = i;
                                r3 = arrayList;
                            } catch (Throwable th4) {
                                th = th4;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cursor3 = cursorQuery;
                        count = arrayList3;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursorQuery;
                    }
                } else {
                    cursor4 = cursorQuery;
                    r3 = arrayList3;
                }
                if (cursor4 != null) {
                    cursor4.close();
                }
            } catch (Exception e5) {
                e = e5;
                r3 = arrayList3;
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
            return r3;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<MediaItem> arrayList) {
            String str = PhotoViewActivity.T0;
            LogUtil.d(str, "loadBucketVideos finished");
            if (PhotoViewActivity.this.isDestroyed() || PhotoViewActivity.this.isFinishing()) {
                return;
            }
            PhotoViewActivity.this.z0 = true;
            if ("from_moment".equals(PhotoViewActivity.this.G0) || !PhotoViewActivity.this.F) {
                PhotoViewActivity.this.H0 = true;
            } else if (PhotoViewActivity.this.F && PhotoViewActivity.this.A0) {
                PhotoViewActivity.this.H0 = true;
            }
            if (arrayList != null && arrayList.size() > 0) {
                PhotoViewActivity.this.t.addAll(arrayList);
            }
            PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
            if (photoViewActivity.H0 && !"from_moment".equals(photoViewActivity.G0)) {
                PhotoViewActivity photoViewActivity2 = PhotoViewActivity.this;
                photoViewActivity2.s = photoViewActivity2.t;
                PhotoViewActivity.this.y3();
            }
            PhotoViewActivity photoViewActivity3 = PhotoViewActivity.this;
            if (photoViewActivity3.H0) {
                photoViewActivity3.s = photoViewActivity3.t;
                LogUtil.i(str, "loadBucketVideos loadFinished, size = " + PhotoViewActivity.this.s.size());
                PhotoViewActivity.this.F3();
                PhotoViewActivity.this.B3();
                PhotoViewActivity.this.G3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12305a;

        public g(MediaItem mediaItem) {
            this.f12305a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i != 0) {
                com.zenmen.palmchat.chat.h.h(PhotoViewActivity.this, i);
            } else {
                tk3.k(PhotoViewActivity.this, this.f12305a, ErrorCode.DETAIL_HTTP_TIMEOUT);
                LogUtil.onClickEvent("M311", null, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements Comparator<MediaItem> {
        public g0() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return new Long(mediaItem2.modifyTime).compareTo(new Long(mediaItem.modifyTime));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12307a;

        public h(MediaItem mediaItem) {
            this.f12307a = mediaItem;
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            if (i != 0) {
                com.zenmen.palmchat.chat.h.h(PhotoViewActivity.this, i);
            } else if (u92.a(this.f12307a) == 0 || !"from_chat".equals(PhotoViewActivity.this.G0)) {
                PhotoViewActivity.this.m0.add(this.f12307a);
                if (PhotoViewActivity.this.u.size() == 0) {
                    PhotoViewActivity.this.q0.setVisibility(0);
                }
                PhotoViewActivity.this.u.add(new a.c(this.f12307a));
                PhotoViewActivity.this.s0.e((a.c) PhotoViewActivity.this.u.get(PhotoViewActivity.this.u.size() - 1));
                PhotoViewActivity.this.s0.h(PhotoViewActivity.this.u.size() - 1);
                PhotoViewActivity.this.h0.setSelected(true);
            } else {
                u92.c(PhotoViewActivity.this, i);
            }
            PhotoViewActivity.this.u3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements View.OnClickListener {
        public h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoViewActivity.this.m0.size() == 0 && !PhotoViewActivity.this.R) {
                PhotoViewActivity.this.k3();
            }
            if (PhotoViewActivity.this.R) {
                PhotoViewActivity.this.f0.setSelected(false);
            } else {
                PhotoViewActivity.this.f0.setSelected(true);
            }
            PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
            photoViewActivity.R = true ^ photoViewActivity.R;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12309a;
        public final /* synthetic */ int b;

        public i(String str, int i) {
            this.f12309a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoViewActivity.this.x0.put(this.f12309a, 0);
            if (this.b == PhotoViewActivity.this.q.getCurrentItem()) {
                PhotoViewActivity.this.Z.setText(0 + AppContext.getContext().getResources().getString(R.string.download_percent));
                PhotoViewActivity.this.e0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements View.OnClickListener {
        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.k3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12311a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public j(String str, int i, int i2, int i3) {
            this.f12311a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = (Integer) PhotoViewActivity.this.x0.get(this.f12311a);
            if (num == null || num.intValue() != -1) {
                PhotoViewActivity.this.x0.put(this.f12311a, Integer.valueOf(this.b));
                if (this.c == PhotoViewActivity.this.q.getCurrentItem()) {
                    TextView textView = PhotoViewActivity.this.Z;
                    textView.setText(((int) ((this.b / this.d) * 100.0f)) + PhotoViewActivity.this.getString(R.string.download_percent));
                    PhotoViewActivity.this.e0.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 extends g13 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<k0> f12312a;

        public j0(ArrayList<k0> arrayList) {
            this.f12312a = arrayList;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                for (k0 k0Var : this.f12312a) {
                    Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(k0Var.f12314a.fileFullPath, 1);
                    if (bitmapCreateVideoThumbnail != null) {
                        File file = new File(pu1.f);
                        if (!file.exists()) {
                            file.mkdirs();
                            LogUtil.i(PhotoViewActivity.T0, "create dir");
                        }
                        File fileC = pu1.c((pu1.f + File.separator) + k0Var.f12314a.fileID + ".thumbnail");
                        FileOutputStream fileOutputStream = new FileOutputStream(fileC);
                        bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        k0Var.f12314a.thumbnailPath = fileC.getAbsolutePath();
                        k0Var.f12314a.localThumbPath = fileC.getAbsolutePath();
                        LogUtil.i(PhotoViewActivity.T0, "CreateThumbThread, index = " + k0Var.b + "， path = " + fileC.getAbsolutePath());
                        Message message = new Message();
                        message.what = 2;
                        message.obj = k0Var;
                        PhotoViewActivity.this.C0.sendMessage(message);
                    }
                }
            } catch (Exception e) {
                LogUtil.i(PhotoViewActivity.T0, "CreateThumbThread, error = " + e);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ds0.a().b(new xa6(PhotoViewActivity.this.x, 0, 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaItem f12314a;
        public int b;

        public k0(MediaItem mediaItem, int i) {
            this.b = i;
            this.f12314a = mediaItem;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12315a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public l(String str, int i, int i2) {
            this.f12315a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoViewActivity.this.x0.put(this.f12315a, -1);
            if (this.b == PhotoViewActivity.this.q.getCurrentItem()) {
                PhotoViewActivity.this.Z.setText(AppContext.getContext().getResources().getString(R.string.image_download_origin, il5.a(AppContext.getContext(), this.c)));
                PhotoViewActivity.this.e0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<PhotoViewActivity> f12316a;

        public l0(PhotoViewActivity photoViewActivity) {
            this.f12316a = new WeakReference<>(photoViewActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f12316a.get() != null) {
                    this.f12316a.get().i0.setVisibility(8);
                    this.f12316a.get().K0.setVisibility(8);
                    return;
                }
                return;
            }
            if (i == 1) {
                if (this.f12316a.get() != null) {
                    this.f12316a.get().K0.setVisibility(8);
                    this.f12316a.get().i0.setVisibility(8);
                    return;
                }
                return;
            }
            if (i != 2 || this.f12316a.get() == null || this.f12316a.get().s == null) {
                return;
            }
            PhotoViewActivity photoViewActivity = this.f12316a.get();
            k0 k0Var = (k0) message.obj;
            if (photoViewActivity.s.size() > k0Var.b) {
                photoViewActivity.s.set(k0Var.b, k0Var.f12314a);
            } else {
                photoViewActivity.s.add(k0Var.f12314a);
            }
            if (photoViewActivity.n0 == null) {
                photoViewActivity.n0 = new PhotoViewFragmentAdapter(photoViewActivity.getSupportFragmentManager(), photoViewActivity.r, photoViewActivity.s, photoViewActivity.y, photoViewActivity.z, photoViewActivity.A, photoViewActivity.C, photoViewActivity.G0, photoViewActivity.J, photoViewActivity.v0);
            }
            photoViewActivity.n0.h(photoViewActivity.s);
            if (photoViewActivity.f3()) {
                return;
            }
            photoViewActivity.n0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12317a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public m(String str, int i, int i2) {
            this.f12317a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoViewActivity.this.x0.put(this.f12317a, -1);
            if (this.b == PhotoViewActivity.this.q.getCurrentItem()) {
                PhotoViewActivity.this.Z.setText(AppContext.getContext().getResources().getString(R.string.image_download_origin, il5.a(AppContext.getContext(), this.c)));
                PhotoViewActivity.this.e0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f12318a;
        public final /* synthetic */ int b;

        public n(File file, int i) {
            this.f12318a = file;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12318a != null) {
                ds0.a().b(br2.a(0, (MediaItem) PhotoViewActivity.this.s.get(this.b)));
                if (this.b == PhotoViewActivity.this.q.getCurrentItem()) {
                    PhotoViewActivity.this.Y.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12319a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "img_load_fail");
                put("reason", "expired");
                put("scene", 2);
                put("url", o.this.b);
            }
        }

        public o(int i, String str, int i2) {
            this.f12319a = i;
            this.b = str;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12319a == PhotoViewActivity.this.q.getCurrentItem()) {
                PhotoViewActivity.this.x0.put(this.b, -1);
                PhotoViewActivity.this.Z.setText(PhotoViewActivity.this.getResources().getString(R.string.image_download_origin, il5.a(PhotoViewActivity.this, PhotoViewActivity.X2((MediaItem) r5.s.get(this.f12319a)))));
                PhotoViewActivity.this.e0.setVisibility(8);
            }
            if (!zs0.a(this.c)) {
                sy5.e(AppContext.getContext(), R.string.network_exception_title, 0).g();
                return;
            }
            sy5.e(AppContext.getContext(), R.string.image_load_fail_404, 0).g();
            LogUtil.i(PhotoViewActivity.T0, LogUtil.LogType.LOG_TYPE_IMG_LOAD_EXPIRE, 3, new a(), (Throwable) null);
            if (this.c == 404) {
                dr2.a();
            }
            if (this.c == 403) {
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.F1(((MediaItem) photoViewActivity.s.get(this.f12319a)).mid, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements h.f {
        public p() {
        }

        @Override // com.zenmen.palmchat.chat.h.f
        public void a(int i) {
            PhotoViewActivity.this.g0.setText(PhotoViewActivity.this.getResources().getString(i == -1 ? R.string.video_filter_large : i == -2 ? R.string.video_filter_long : i == -3 ? R.string.video_filter_short : i == -4 ? R.string.video_filter_unsupport : i == -5 ? R.string.video_filter_not_exit : R.string.photo_preview_video_edit));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12322a;

        public q(int i) {
            this.f12322a = i;
            put("type", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Comparator<MediaItem> {
        public r() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return Long.valueOf(mediaItem2.modifyTime).compareTo(Long.valueOf(mediaItem.modifyTime));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends HashMap<String, Object> {
        public s() {
            put("action", "send_message");
            put("status", "sendImageInMediaPick");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends HashMap<String, Object> {
        public t() {
            put("action", "send_message");
            put("status", "sendImageInPhotoView");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaItem f12327a;

            public a(MediaItem mediaItem) {
                this.f12327a = mediaItem;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    com.zenmen.palmchat.chat.h.h(PhotoViewActivity.this, i);
                    return;
                }
                if (u92.a(this.f12327a) != 0 && "from_chat".equals(PhotoViewActivity.this.G0)) {
                    u92.c(PhotoViewActivity.this, i);
                    return;
                }
                PhotoViewActivity.this.Q.add(this.f12327a);
                if (PhotoViewActivity.this.Q.size() > 0) {
                    PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                    photoViewActivity.q3(photoViewActivity.Q, PhotoViewActivity.this.R);
                }
                PhotoViewActivity.this.finish();
            }
        }

        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PhotoViewActivity.this.N = true;
            PhotoViewActivity.this.Q.clear();
            PhotoViewActivity.this.Q.addAll(PhotoViewActivity.this.m0);
            PhotoViewActivity.this.u.clear();
            if (PhotoViewActivity.this.B0 != 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, PhotoViewActivity.this.B0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("M226", null, jSONObject.toString());
            }
            if (PhotoViewActivity.this.Q.size() == 0) {
                MediaItem mediaItemW2 = PhotoViewActivity.this.W2();
                if (mediaItemW2 == null) {
                    return;
                }
                com.zenmen.palmchat.chat.h.c(PhotoViewActivity.this, mediaItemW2, new a(mediaItemW2));
                return;
            }
            if (PhotoViewActivity.this.Q.size() > 0) {
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                photoViewActivity.q3(photoViewActivity.Q, PhotoViewActivity.this.R);
            }
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements SeekBar.OnSeekBarChangeListener {
        public v() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                PhotoViewActivity.this.M0.setText(o86.d(i));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            ds0.a().b(new xa6(PhotoViewActivity.this.x, 1, 0));
            PhotoViewActivity.this.C0.removeMessages(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ds0.a().b(new xa6(PhotoViewActivity.this.x, 2, seekBar.getProgress()));
            PhotoViewActivity.this.C0.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x extends MaterialDialog.e {
        public x() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            PhotoViewActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12331a;
        public final /* synthetic */ File b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        public y(String str, File file, File file2, String str2) {
            this.f12331a = str;
            this.b = file;
            this.c = file2;
            this.d = str2;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            boolean zF;
            if (TextUtils.isEmpty(this.f12331a) || !new File(this.f12331a).exists()) {
                File file = this.c;
                zF = (file == null || !file.exists()) ? false : pu1.f(this.c, this.b);
            } else {
                zF = pu1.f(new File(this.f12331a), this.b);
            }
            return Boolean.valueOf(zF);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                wm3.a(this.d);
                PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                sy5.f(photoViewActivity, photoViewActivity.getResources().getString(R.string.save_to_dir, pu1.m()), 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements is0.f {
        public z() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                Intent intent = new Intent(PhotoViewActivity.this, (Class<?>) MediaPickActivity.class);
                intent.putExtra("select_mode_key", 1);
                PhotoViewActivity.this.startActivityForResult(intent, 1);
            } else {
                if (i != 1) {
                    return;
                }
                if (((MediaItem) PhotoViewActivity.this.s.get(PhotoViewActivity.this.x)).fileFullPath == null && ((MediaItem) PhotoViewActivity.this.s.get(PhotoViewActivity.this.x)).localPath == null) {
                    return;
                }
                try {
                    File fileB = sd1.b(((MediaItem) PhotoViewActivity.this.s.get(PhotoViewActivity.this.x)).fileFullPath);
                    PhotoViewActivity photoViewActivity = PhotoViewActivity.this;
                    photoViewActivity.E1(((MediaItem) photoViewActivity.s.get(PhotoViewActivity.this.x)).localPath, fileB);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int X2(MediaItem mediaItem) {
        String str = mediaItem.extension;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).optInt("hdSize");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String Y2(String str, String str2) {
        return !TextUtils.isEmpty(str2) && new File(str2).exists() ? str2 : str;
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void A1(MediaItem mediaItem) throws Throwable {
        MessageVo messageVoD = com.zenmen.palmchat.database.b.d(mediaItem.mid, this.r);
        if (messageVoD != null) {
            Intent intent = new Intent();
            intent.setClass(this, SendMessageActivity.class);
            intent.putExtra("message_vo", messageVoD);
            startActivity(intent);
        }
    }

    public void A3(boolean z2) {
        ImageView imageView = this.L0;
        if (imageView != null) {
            if (z2) {
                imageView.setImageResource(R.drawable.ic_video_control_pause);
            } else {
                imageView.setImageResource(R.drawable.ic_video_control_play);
            }
        }
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public int B1() {
        return this.J;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B3() {
        this.U = (TextView) findViewById(R.id.title);
        ArrayList<MediaItem> arrayList = this.s;
        this.U.setText(String.format("%d/%d", Integer.valueOf(this.w + 1), Integer.valueOf((arrayList == null || arrayList.size() == 0) ? this.y0 : this.s.size())));
        findViewById(R.id.action_button).setVisibility(8);
        u3();
        MediaItem mediaItemW2 = W2();
        if (mediaItemW2 == null) {
            return;
        }
        if (mediaItemW2.mimeType == 1 && "from_moment".equals(this.G0)) {
            long j2 = mediaItemW2.playLength;
            if (j2 > this.I0 || j2 < this.J0) {
                this.T.setEnabled(false);
            }
        } else {
            this.T.setEnabled(true);
        }
        this.T.setOnClickListener(new u());
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void C1() {
        LogUtil.i(T0, "onViewTap ");
        int i2 = this.J;
        if (i2 == 2) {
            G1();
            return;
        }
        if (i2 == 1) {
            if (this.i0.getVisibility() != 0) {
                this.i0.setVisibility(0);
                this.K0.setVisibility(0);
                this.C0.removeMessages(1);
                this.C0.sendEmptyMessageDelayed(1, 3000L);
                return;
            }
            if (this.K0.getVisibility() == 0) {
                this.i0.setVisibility(8);
                this.K0.setVisibility(8);
            } else {
                this.i0.setVisibility(0);
                this.K0.setVisibility(0);
                this.C0.removeMessages(1);
                this.C0.sendEmptyMessageDelayed(1, 3000L);
            }
        }
    }

    public final void C3() {
        if (this.J == 1) {
            this.k0.setVisibility(8);
            this.V.setVisibility(8);
            return;
        }
        MediaItem mediaItemW2 = W2();
        if (mediaItemW2 == null) {
            return;
        }
        if (mediaItemW2.mimeType == 0) {
            this.g0.setVisibility(0);
        }
        if (mediaItemW2.mimeType != 1) {
            if ("from_moment".equals(this.G0)) {
                this.f0.setVisibility(8);
                this.h0.setVisibility(0);
                this.l0.setVisibility(8);
            } else {
                this.l0.setVisibility(8);
                this.h0.setVisibility(0);
                String str = mediaItemW2.fileFullPath;
                if (str == null || !str.toLowerCase().endsWith(".gif")) {
                    this.f0.setVisibility(0);
                } else {
                    this.f0.setVisibility(8);
                    this.g0.setVisibility(8);
                }
            }
            this.k0.setVisibility(8);
            if (this.J != 2) {
                this.V.setVisibility(8);
            } else {
                this.V.setVisibility(0);
            }
            gi4 gi4Var = this.Q0;
            if (gi4Var != null) {
                gi4Var.g(this.V);
                return;
            }
            return;
        }
        if (!"from_moment".equals(this.G0)) {
            this.g0.setVisibility(8);
            this.f0.setVisibility(8);
            this.h0.setVisibility(0);
            this.l0.setVisibility(8);
            this.k0.setVisibility(8);
            this.V.setVisibility(0);
            gi4 gi4Var2 = this.Q0;
            if (gi4Var2 != null) {
                gi4Var2.g(this.V);
                return;
            }
            return;
        }
        long j2 = mediaItemW2.playLength;
        if (j2 > this.I0 && j2 < 301000) {
            this.k0.setVisibility(0);
            this.V.setVisibility(8);
            gi4 gi4Var3 = this.Q0;
            if (gi4Var3 != null) {
                gi4Var3.g(this.k0);
                return;
            }
            return;
        }
        this.k0.setVisibility(8);
        this.V.setVisibility(0);
        gi4 gi4Var4 = this.Q0;
        if (gi4Var4 != null) {
            gi4Var4.g(this.V);
        }
        this.g0.setVisibility(0);
        this.h0.setVisibility(8);
        this.f0.setVisibility(8);
        com.zenmen.palmchat.chat.h.c(this, mediaItemW2, new p());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D1(String str) {
        boolean z2;
        super.D1(str);
        ChatItem chatItem = this.r;
        if (chatItem != null) {
            z2 = chatItem.getChatType() == 1;
        }
        cq6.b(this, str, z2 ? 3 : 2);
    }

    public final void D3(int i2) {
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || arrayList.size() <= 0 || this.s.size() <= i2) {
            return;
        }
        MediaItem mediaItem = this.s.get(i2);
        if (mediaItem.mimeType == 4 || mediaItem.isFileExpired) {
            this.Y.setVisibility(8);
            return;
        }
        boolean zJ = k86.J(Y2(mediaItem.fileFullPath, mediaItem.localPath));
        String strB3 = b3(mediaItem.extension);
        int iX2 = X2(mediaItem);
        boolean z2 = (zJ || TextUtils.isEmpty(strB3) || iX2 <= 0) ? false : true;
        String str = mediaItem.mid;
        String str2 = pu1.f20095a;
        String str3 = File.separator;
        if (z2) {
            this.Y.setVisibility(0);
            Integer num = this.x0.get(strB3);
            if (num == null || num.intValue() < 0) {
                this.Z.setText(getResources().getString(R.string.image_download_origin, il5.a(this, iX2)));
                this.e0.setVisibility(8);
            } else {
                dt0.l(AppContext.getContext(), Volley.getUserAgent()).o(strB3, new wf1(new WeakReference(this), str, i2, strB3, iX2));
                int iIntValue = (int) ((num.intValue() / iX2) * 100.0f);
                this.Z.setText(iIntValue + getString(R.string.download_percent));
                this.e0.setVisibility(0);
            }
        } else {
            this.Y.setVisibility(8);
        }
        this.F0 = -1;
    }

    @Override // defpackage.gl2
    public void E(int i2, int i3, String str, int i4) {
        this.C0.post(new j(str, i2, i3, i4));
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void E1(String str, File file) throws IOException {
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
        T2(str, file, file3, str3);
    }

    public void E3(int i2, long j2, long j3) {
        if (this.K0 == null || i2 != this.x) {
            return;
        }
        this.O0.setMax((int) j3);
        this.N0.setText(o86.d(j3));
        this.O0.setProgress((int) j2);
        this.M0.setText(o86.d(j2));
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void F1(String str, boolean z2) {
        String str2;
        MediaItem mediaItemW2 = W2();
        if (mediaItemW2 != null && (str2 = mediaItemW2.mid) != null && str2.equals(str)) {
            this.Y.setVisibility(8);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("attach_status", (Integer) 5);
        if (z2) {
            contentValues.put("data1", "http://res_error?code=403");
        }
        getContentResolver().update(DBUriManager.b(ho3.class, this.r), contentValues, "packet_id=?", new String[]{str});
    }

    public final void F3() {
        String str;
        if (this.s == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            MediaItem mediaItem = this.s.get(i2);
            if (mediaItem.mimeType == 1 && (((str = mediaItem.thumbnailPath) == null || !pu1.b(str)) && mediaItem.fileFullPath.toLowerCase().endsWith("mp4"))) {
                arrayList.add(new k0(mediaItem, i2));
            }
        }
        if (arrayList.size() != 0) {
            LogUtil.i(T0, "updateThumbForVideo ， size = " + arrayList.size());
            new j0(arrayList).start();
        }
    }

    @Override // defpackage.gl2
    public void G0(int i2, int i3, String str) {
        this.C0.post(new o(i2, str, i3));
    }

    @Override // com.zenmen.palmchat.activity.photoview.BasePreviewActivity
    public void G1() {
        gi4 gi4Var = this.Q0;
        if (gi4Var != null) {
            gi4Var.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G3() {
        boolean z2;
        LogUtil.i(T0, "updataUI");
        ArrayList<Integer> integerArrayListExtra = getIntent().getIntegerArrayListExtra("extra_checked_item_indexes");
        if (integerArrayListExtra != null) {
            this.w0 = new ArrayList<>();
            if (this.s != null) {
                for (Integer num : integerArrayListExtra) {
                    if (num.intValue() < this.s.size()) {
                        this.w0.add(this.s.get(num.intValue()));
                    }
                }
            }
        }
        if (this.J != 2) {
            this.V.setVisibility(8);
        } else {
            this.V.setVisibility(0);
        }
        this.f0.setSelected(this.R);
        this.f0.setOnClickListener(new h0());
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || arrayList.size() <= 0) {
            z2 = false;
        } else {
            LogUtil.d(T0, "updateUI mMediaItems = " + this.s.size());
            if (a3(this.m0, this.s.get(this.x)) != -1) {
                z2 = true;
            }
        }
        this.h0.setSelected(z2);
        this.h0.setOnClickListener(new i0());
        ArrayList<MediaItem> arrayList2 = this.s;
        if (arrayList2 == null || arrayList2.size() <= 1) {
            this.h0.setVisibility(8);
        } else {
            this.h0.setVisibility(0);
        }
        ArrayList<MediaItem> arrayList3 = this.s;
        PhotoViewFragmentAdapter photoViewFragmentAdapter = this.n0;
        if (photoViewFragmentAdapter == null) {
            this.n0 = new PhotoViewFragmentAdapter(getSupportFragmentManager(), this.r, this.s, this.y, this.z, this.A, this.C, this.G0, this.J, this.v0);
        } else {
            photoViewFragmentAdapter.h(arrayList3);
        }
        ArrayList<MediaItem> arrayList4 = this.s;
        if (arrayList4 == null || arrayList4.size() == 0) {
            this.n0.f(this.M);
        } else {
            LogUtil.i(T0, "updateUI,size = " + this.s.size());
        }
        this.n0.g(this.w);
        this.q.setAdapter(this.n0);
        this.q.setCurrentItem(this.w, false);
        if (this.J == 1) {
            if (g3()) {
                this.j0.setVisibility(0);
                this.j0.setOnClickListener(new a());
                ArrayList<MediaItem> arrayList5 = this.s;
                if (arrayList5 != null && arrayList5.size() > 0 && this.w0.contains(this.s.get(this.x))) {
                    this.j0.setImageResource(R.drawable.icon_green_checked);
                }
            } else {
                this.i0.setVisibility(0);
                this.i0.setOnClickListener(new b());
                this.C0.sendEmptyMessageDelayed(0, 6000L);
            }
        }
        this.Y.setOnClickListener(new c());
        if (!"from_moment".equals(this.G0)) {
            D3(this.w);
            x3();
        }
        C3();
        try {
            TextView textView = (TextView) findViewById(R.id.editVideoTips);
            textView.setText(textView.getText().toString().replace("10", Integer.toString(wv.a())));
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.activity.photoview.a.b
    public void J(a.c cVar, View view, int i2, int i3) {
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || cVar == null) {
            return;
        }
        Iterator<MediaItem> it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (cVar.f12364a.fileFullPath.equals(it.next().fileFullPath)) {
                this.x = i4;
                ViewPager viewPager = this.q;
                if (viewPager != null) {
                    viewPager.setCurrentItem(i4, false);
                }
            }
            i4++;
        }
        V0(view, i2);
    }

    @Override // defpackage.gl2
    public void L(File file, int i2, String str, int i3) {
        for (int i4 = 0; i4 < this.s.size(); i4++) {
            String strB3 = b3(this.s.get(i4).extension);
            if (strB3 != null && str != null && strB3.equals(str)) {
                try {
                    String strOptString = new JSONObject(this.s.get(i4).extension).optString("md5", "");
                    if (!TextUtils.isEmpty(strOptString) && !strOptString.equals(rb3.b(file))) {
                        file.delete();
                        this.C0.post(new m(str, i4, i3));
                        return;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.zenmen.palmchat.database.b.K(this.r, this.s.get(i4).mid, file.getAbsolutePath());
                this.s.get(i4).localPath = file.getAbsolutePath();
                this.C0.post(new n(file, i4));
            }
        }
    }

    @Override // defpackage.gl2
    public void T(int i2, String str) {
        this.C0.post(new i(str, i2));
    }

    public void T2(String str, File file, File file2, String str2) {
        new y(str, file2, file, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final boolean U2() {
        return this.J == 2;
    }

    @Override // com.zenmen.palmchat.activity.photoview.a.b
    public void V0(View view, int i2) {
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int width = view.getWidth();
        if (i3 == 0 || width == 0) {
            return;
        }
        this.q0.smoothScrollTo((view.getLeft() - (((i3 / width) * width) / 2)) + (width / 2), 0);
    }

    public final void V2(View view, RelativeLayout.LayoutParams layoutParams) {
        if (dm1.d() && yy3.a.b(this)) {
            int[] iArrA = yy3.a.a(this);
            int i2 = iArrA[0];
            layoutParams.topMargin = iArrA[1] + me1.b(this, 17);
            view.setLayoutParams(layoutParams);
        }
    }

    public final MediaItem W2() {
        MediaItem mediaItem = this.M;
        if (mediaItem == null) {
            mediaItem = null;
        }
        if (this.G || this.F) {
            ArrayList<MediaItem> arrayList = this.s;
            return (arrayList == null || arrayList.size() <= this.q.getCurrentItem() || !this.H0) ? mediaItem : this.s.get(this.q.getCurrentItem());
        }
        ArrayList<MediaItem> arrayList2 = this.s;
        return (arrayList2 == null || arrayList2.size() <= this.q.getCurrentItem()) ? mediaItem : this.s.get(this.q.getCurrentItem());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z2() {
        int i2;
        Intent intent = getIntent();
        int i3 = 1;
        this.P = intent.getBooleanExtra("isNeedShowSendCount", true);
        this.r = (ChatItem) intent.getParcelableExtra("info_item");
        int i4 = 0;
        this.E = intent.getBooleanExtra("need_load_chat_image_list", false);
        this.F = intent.getBooleanExtra("need_load_bucket_image_list", false);
        this.G = intent.getBooleanExtra("need_load_bucket_video_list", false);
        this.H = intent.getStringExtra("bucket_id");
        this.R = intent.getBooleanExtra("sendOriginImage", false);
        this.I = intent.getStringExtra("first_item_mid");
        this.s = intent.getParcelableArrayListExtra("mediaList");
        this.B0 = intent.getIntExtra(az.at, 0);
        ArrayList<MediaItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectlist");
        this.m0 = parcelableArrayListExtra;
        if (parcelableArrayListExtra == null) {
            this.m0 = new ArrayList<>();
        } else {
            for (MediaItem mediaItem : parcelableArrayListExtra) {
                mediaItem.editedImagePath = null;
                mediaItem.cropRect = null;
                mediaItem.degree = 0;
            }
        }
        this.K = intent.getStringExtra("firset_item_path");
        this.y0 = intent.getIntExtra("total_size", 0);
        this.M = (MediaItem) intent.getParcelableExtra("first_item");
        this.L = (MessageVo) intent.getParcelableExtra("message_vo");
        this.w = intent.getIntExtra("selectIndex", 0);
        this.y = intent.getBooleanExtra("from_portrait", false);
        this.z = intent.getBooleanExtra("from_user_portrait", false);
        this.A = intent.getBooleanExtra("extra_is_friend", true);
        this.B = intent.getBooleanExtra("from_personal_info", false);
        this.C = intent.getBooleanExtra("long_click", true);
        this.x = this.w;
        this.J = intent.getIntExtra("show_mode", 0);
        this.u0 = intent.getBooleanExtra("start_from_chat_photo_grid_activity", false);
        this.v0 = intent.getBooleanExtra("init_item_auto_play", true);
        this.D0 = intent.getIntExtra("thread_biz_type", 0);
        this.G0 = intent.getStringExtra("from");
        this.v = intent.getIntExtra("extra_key_max_num", 9);
        int i5 = this.J;
        if (i5 == 1) {
            MessageVo messageVo = this.L;
            if (messageVo != null) {
                if (messageVo.mimeType == 2) {
                    i3 = 0;
                }
                i4 = i3;
            }
        } else if (i5 != 0 && i5 == 2) {
            MediaItem mediaItem2 = this.M;
            if (mediaItem2 != null) {
                if (mediaItem2.mimeType == 0) {
                }
                i4 = i3;
            } else {
                try {
                    ArrayList<MediaItem> arrayList = this.m0;
                    if (arrayList != null && arrayList.size() > 0 && this.w < this.m0.size() && (i2 = this.w) > 0) {
                        if (this.m0.get(i2).mimeType == 0) {
                        }
                        i4 = i3;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        updateCurrentPageInfo(this, new q(i4));
    }

    public final int a3(ArrayList<MediaItem> arrayList, MediaItem mediaItem) {
        if (arrayList != null && mediaItem != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = arrayList.get(i2).fileFullPath;
                if (str != null && str.equals(mediaItem.fileFullPath)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public String b3(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str).optString("hdUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void c3() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.o0 = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.o0.setFillAfter(true);
        this.o0.setAnimationListener(this);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.p0 = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.p0.setFillAfter(true);
        this.p0.setAnimationListener(this);
    }

    public final void d3() {
        this.K0 = findViewById(R.id.playLayout);
        ImageView imageView = (ImageView) findViewById(R.id.playBtn);
        this.L0 = imageView;
        imageView.setOnClickListener(new k());
        this.M0 = (TextView) findViewById(R.id.currentPosition);
        this.N0 = (TextView) findViewById(R.id.totalLength);
        SeekBar seekBar = (SeekBar) findViewById(R.id.activity_play_seek_bar);
        this.O0 = seekBar;
        seekBar.setEnabled(true);
        this.O0.setOnSeekBarChangeListener(new v());
        View viewFindViewById = findViewById(R.id.close_video);
        viewFindViewById.setOnClickListener(new c0());
        View viewFindViewById2 = findViewById(R.id.more_pics_btn);
        V2(viewFindViewById, (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams());
        V2(viewFindViewById2, (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams());
    }

    public final void e3() {
        this.T = (TextView) findViewById(R.id.tv_action);
        this.W = findViewById(R.id.toolbar_area);
        this.V = findViewById(R.id.bottomContainer);
        this.f0 = (TextView) findViewById(R.id.originSizeTv);
        this.g0 = (TextView) findViewById(R.id.edit);
        this.Z = (TextView) findViewById(R.id.download_text);
        this.e0 = (ImageView) findViewById(R.id.download_stop);
        this.Y = findViewById(R.id.download_container);
        this.j0 = (ImageView) findViewById(R.id.check_image);
        this.i0 = (ImageView) findViewById(R.id.more_pics_btn);
        this.q = (ViewPager) findViewById(R.id.viewpager);
        this.k0 = findViewById(R.id.bottomContainerMoment);
        this.l0 = (TextView) findViewById(R.id.edit_moment);
        this.q0 = (HorizontalScrollView) findViewById(R.id.scrollView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scrollContentView);
        this.r0 = linearLayout;
        this.s0 = new com.zenmen.palmchat.activity.photoview.a(this, this, linearLayout);
        this.l0.setOnClickListener(new d());
        this.g0.setOnClickListener(new e());
        ArrayList<MediaItem> arrayList = this.s;
        PhotoViewFragmentAdapter photoViewFragmentAdapter = this.n0;
        if (photoViewFragmentAdapter == null) {
            this.n0 = new PhotoViewFragmentAdapter(getSupportFragmentManager(), this.r, this.s, this.y, this.z, this.A, this.C, this.G0, this.J, this.v0);
        } else {
            photoViewFragmentAdapter.h(arrayList);
        }
        ArrayList<MediaItem> arrayList2 = this.s;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.n0.f(this.M);
        }
        this.n0.g(this.w);
        this.q.setAdapter(this.n0);
        this.q.setBackgroundColor(-16777216);
        this.q.setCurrentItem(this.w, true);
        this.q.addOnPageChangeListener(new f());
    }

    public final boolean f3() {
        return isFinishing() || isDestroyed();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.O) {
            Intent intent = new Intent();
            intent.putExtra("sendOriginImage", this.R);
            setResult(-1, intent);
            super.finish();
            return;
        }
        if (!this.N) {
            Intent intent2 = new Intent();
            intent2.putExtra("sendOriginImage", this.R);
            intent2.putParcelableArrayListExtra("selectlist", this.m0);
            setResult(0, intent2);
        } else if (this.Q.size() > 0) {
            Intent intent3 = new Intent();
            intent3.putParcelableArrayListExtra("sendPendingList", this.Q);
            intent3.putExtra("sendOriginImage", this.R);
            setResult(-1, intent3);
        }
        if (this.J == 1 && g3()) {
            Intent intent4 = new Intent();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.w0.size(); i2++) {
                arrayList.add(Integer.valueOf(this.s.indexOf(this.w0.get(i2))));
            }
            intent4.putIntegerArrayListExtra("extra_checked_item_indexes", arrayList);
            setResult(-1, intent4);
        }
        super.finish();
    }

    public final boolean g3() {
        return this.w0 != null;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 106;
    }

    @Override // defpackage.gl2
    public void h0(int i2, String str, int i3) {
        this.C0.post(new l(str, i2, i3));
    }

    public final void h3() {
        LogUtil.d(T0, "loadBucketPhotos start");
        new e0().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void i3() {
        LogUtil.d(T0, "loadBucketVideos start");
        new f0().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void initActionBar() {
        this.X = (RelativeLayout) findViewById(R.id.rootView);
        Toolbar toolbarInitToolbar = initToolbar(-1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        this.S = toolbar;
        toolbar.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = toolbarInitToolbar.getLayoutParams();
        layoutParams.height = me1.h(this) + me1.b(this, 48);
        this.S.setLayoutParams(layoutParams);
        this.S.setBackgroundResource(R.color.Gb);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        toolbar2.setBackgroundResource(R.color.Gb);
        toolbar2.setNavigationIcon(R.drawable.icon_back_arrow_white_normal);
        if (this.B) {
            toolbarInitToolbar.setVisibility(8);
            this.S.setTitle(getString(R.string.settings_portrait));
            this.S.setNavigationIcon(R.drawable.icon_back_arrow_white_normal);
            this.S.setNavigationOnClickListener(new w());
            setSupportActionBar(this.S);
        } else {
            this.S.setVisibility(8);
            setSupportActionBar(toolbarInitToolbar);
        }
        if (this.J != 2) {
            if (this.B) {
                return;
            }
            toolbarInitToolbar.setVisibility(8);
            if (this.J != 0) {
                getWindow().setFlags(1024, 1024);
                return;
            }
            return;
        }
        if (U2()) {
            View view = this.W;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams2);
            this.Q0 = new gi4(this.X, this.W, this.V);
        }
    }

    public final void j3() {
        LogUtil.d(T0, "loadPhotos start");
        new d0().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void k3() {
        a.c cVarRemove;
        MediaItem mediaItemW2 = W2();
        int iA3 = a3(this.m0, mediaItemW2);
        if (iA3 != -1) {
            if (this.m0.size() > iA3) {
                this.m0.remove(iA3);
            }
            if (this.u.size() > iA3 && (cVarRemove = this.u.remove(iA3)) != null) {
                this.s0.g(cVarRemove);
            }
            if (this.u.size() == 0) {
                this.q0.setVisibility(8);
            }
            this.h0.setSelected(false);
        } else if (this.m0.size() >= this.v) {
            sy5.f(this, getResources().getString(R.string.media_pick_reach_limit, Integer.valueOf(this.v)), 1).g();
        } else {
            com.zenmen.palmchat.chat.h.c(this, mediaItemW2, new h(mediaItemW2));
        }
        u3();
    }

    public final void l3() {
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        if (!tg4.b(this, permissionType.permissionList)) {
            BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
            return;
        }
        int currentItem = this.q.getCurrentItem();
        String strB3 = b3(this.s.get(currentItem).extension);
        String str = this.s.get(currentItem).mid;
        int iX2 = X2(this.s.get(currentItem));
        int iLastIndexOf = this.s.get(currentItem).fileFullPath.lastIndexOf("mid=") + 4;
        int i2 = iLastIndexOf + 64;
        String strA = this.s.get(currentItem).fileFullPath.length() < i2 ? o86.a(this.s.get(currentItem).fileFullPath) : o86.a(this.s.get(currentItem).fileFullPath.substring(iLastIndexOf, i2));
        wf1 wf1Var = new wf1(new WeakReference(this), str, currentItem, strB3, iX2);
        Integer num = this.x0.get(strB3);
        if (num != null && num.intValue() >= 0) {
            this.F0 = 0;
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).h(strB3);
        } else {
            if (this.e0.getVisibility() == 0) {
                return;
            }
            dt0.l(AppContext.getContext(), Volley.getUserAgent()).e(strB3, pu1.f, strA, wf1Var);
        }
    }

    public final void m3() {
        MediaItem mediaItemW2 = W2();
        if (mediaItemW2 == null) {
            return;
        }
        com.zenmen.palmchat.chat.h.c(this, mediaItemW2, new g(mediaItemW2));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n3() {
        boolean z2;
        MediaItem mediaItemW2 = W2();
        if (mediaItemW2 == null) {
            return;
        }
        String str = this.G0;
        if (str == null || !str.equals("from_moment")) {
            z2 = this.m0.size() <= 1;
        }
        Log.e("rxx", "photo view activity current rect: " + mediaItemW2.cropRect);
        new cr2(this, mediaItemW2.fileFullPath, mediaItemW2.editedImagePath).b(mediaItemW2.cropRect).c(mediaItemW2.degree).d(z2).e("stickers").a();
    }

    public final void o3(int i2) {
        this.x = i2;
        if (this.J == 1 && g3()) {
            if (this.w0.contains(this.s.get(i2))) {
                this.j0.setImageResource(R.drawable.icon_green_checked);
            } else {
                this.j0.setImageResource(R.drawable.icon_white_uncheck);
            }
        }
        this.U.setText(String.format("%d/%d", Integer.valueOf(i2 + 1), Integer.valueOf(this.s.size())));
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || arrayList.get(this.x).mimeType != 1 || !"from_moment".equals(this.G0) || (this.s.get(this.x).playLength <= this.I0 && this.s.get(this.x).playLength >= this.J0)) {
            this.T.setEnabled(true);
        } else {
            this.T.setEnabled(false);
        }
        if (a3(this.m0, this.s.get(i2)) == -1) {
            this.h0.setSelected(false);
        } else {
            this.h0.setSelected(true);
        }
        this.n0.g(i2);
        ds0.a().b(new h22(i2));
        if (!"from_moment".equals(this.G0)) {
            D3(i2);
            x3();
        }
        C3();
        View view = this.K0;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.u.size() <= 0 || this.s.size() <= 0) {
            return;
        }
        this.s0.i(this.s.get(i2));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z2;
        LogUtil.i(T0, "onActivityResult");
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("media_pick_photo_key", intent.getStringExtra("media_pick_photo_key"));
            setResult(-1, intent2);
            super.finish();
            return;
        }
        if (i2 == 998 && i3 == -1) {
            MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("EXTRA_CROP_ITEM");
            this.N = true;
            this.Q.clear();
            this.Q.add(mediaItem);
            finish();
            return;
        }
        if (i2 == 52 && i3 == -1) {
            String stringExtra = intent.getStringExtra("EXTRA_EDITED_SRC_PATH");
            String stringExtra2 = intent.getStringExtra("EXTRA_EDITED_PATH");
            Rect rect = (Rect) intent.getParcelableExtra("EXTRA_CROP_RECT");
            int intExtra = intent.getIntExtra("EXTRA_CROP_ROTATION", 0);
            boolean booleanExtra = intent.getBooleanExtra("EXTRA_SEND_IMAGE", false);
            Log.e("rxx", "srcPath :" + stringExtra);
            Log.e("rxx", "tmppath :" + stringExtra2);
            Log.e("rxx", "photo view activity rect: " + rect);
            if (stringExtra2.equals(stringExtra)) {
                if (booleanExtra) {
                    this.O = true;
                    p3(stringExtra2, false);
                    finish();
                    return;
                }
                return;
            }
            Iterator<a.c> it = this.u.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                a.c next = it.next();
                if (next.f12364a.fileFullPath.equals(stringExtra)) {
                    next.b = stringExtra2;
                    MediaItem mediaItem2 = next.f12364a;
                    mediaItem2.editedImagePath = stringExtra2;
                    mediaItem2.cropRect = rect;
                    mediaItem2.degree = intExtra;
                    this.s0.e(next);
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (booleanExtra) {
                if (z2) {
                    this.u.remove(i4);
                }
                this.O = true;
                sn2.a(this, stringExtra2);
                p3(stringExtra2, false);
                finish();
                return;
            }
            if (this.m0 == null) {
                this.m0 = new ArrayList<>();
            }
            for (MediaItem mediaItem3 : this.m0) {
                if (mediaItem3.fileFullPath.equals(stringExtra)) {
                    mediaItem3.editedImagePath = stringExtra2;
                    mediaItem3.cropRect = rect;
                    mediaItem3.degree = intExtra;
                }
            }
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            ArrayList<MediaItem> arrayList = this.s;
            if (arrayList != null) {
                for (MediaItem mediaItem4 : arrayList) {
                    if (mediaItem4.fileFullPath.equals(stringExtra)) {
                        mediaItem4.editedImagePath = stringExtra2;
                        mediaItem4.cropRect = rect;
                        mediaItem4.degree = intExtra;
                        if (!z2 && !booleanExtra) {
                            a.c cVar = new a.c(mediaItem4);
                            cVar.b = stringExtra2;
                            mediaItem4.cropRect = rect;
                            mediaItem4.degree = intExtra;
                            this.u.add(cVar);
                        }
                    }
                }
            }
            this.n0.notifyDataSetChanged();
            ViewPager viewPager = this.q;
            if (viewPager != null) {
                viewPager.setCurrentItem(this.x, false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.p0) {
            this.i0.setVisibility(4);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (animation == this.o0) {
            this.i0.setVisibility(0);
        }
        if (this.C) {
            return;
        }
        this.i0.setVisibility(8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new ArrayList<>();
        Z2();
        if (U2()) {
            setRequestedOrientation(1);
            setContentView(R.layout.activity_photo_preview);
        } else {
            setContentView(R.layout.activity_photo_view);
            d3();
        }
        e3();
        c3();
        initActionBar();
        ImageView imageView = (ImageView) findViewById(R.id.selectTv);
        this.h0 = imageView;
        imageView.setBackgroundResource(R.drawable.selector_btn_green_checkbox);
        ArrayList<MediaItem> arrayList = this.m0;
        if (arrayList == null || arrayList.size() <= 0) {
            this.q0.setVisibility(8);
        } else {
            Iterator<MediaItem> it = this.m0.iterator();
            while (it.hasNext()) {
                a.c cVar = new a.c(it.next());
                this.u.add(cVar);
                this.s0.e(cVar);
            }
            if (this.u.size() > 0) {
                this.s0.h(0);
            }
        }
        if (this.E) {
            j3();
        }
        if (this.F) {
            h3();
        }
        if (this.G) {
            i3();
        }
        B3();
        G3();
        ch.s().r().j(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.B) {
            return true;
        }
        getMenuInflater().inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        z3();
        px5.g();
        ch.s().r().l(this);
        t3();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (!this.B) {
            return true;
        }
        ArrayList<MediaItem> arrayList = this.s;
        String str = arrayList != null ? arrayList.get(this.x).fileFullPath : "";
        if (str == null || TextUtils.isEmpty(str) || str.contains(MapController.DEFAULT_LAYER_TAG)) {
            showPopupMenu(this, this.S, new String[]{this.t0[0]}, null, this.S0, null);
        } else {
            showPopupMenu(this, this.S, this.t0, null, this.S0, null);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_more) {
            ArrayList<MediaItem> arrayList = this.s;
            String str = arrayList != null ? arrayList.get(this.x).fileFullPath : "";
            if (str == null || TextUtils.isEmpty(str) || str.contains(MapController.DEFAULT_LAYER_TAG)) {
                showPopupMenu(this, this.S, new String[]{this.t0[0]}, null, this.S0, null);
            } else {
                showPopupMenu(this, this.S, this.t0, null, this.S0, null);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        this.C0.post(new a0(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    public final void p3(String str, boolean z2) {
        String strA = xn3.a();
        ChatItem chatItem = this.r;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strE = DomainHelper.e(this.r);
        try {
            if (!new File(str).exists()) {
                sy5.e(AppContext.getContext(), R.string.send_image_file_delete, 0).g();
            } else if (str.toLowerCase().endsWith(".gif")) {
                ExpressionObject expressionObject = new ExpressionObject();
                expressionObject.path = str;
                expressionObject.coverPath = str;
                expressionObject.md5 = rb3.c(str);
                getMessagingServiceInterface().r(MessageVo.buildGifExpressionMessage(strA, strE, expressionObject, 0).setThreadBizType(this, this.D0));
            } else {
                PhotoObject photoObject = new PhotoObject();
                photoObject.path = str;
                getMessagingServiceInterface().r(MessageVo.buildImageMessage(strA, strE, photoObject, z2, 0, null).setThreadBizType(this, this.D0));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(T0, 3, new t(), e2);
        }
    }

    public final void q3(ArrayList<MediaItem> arrayList, boolean z2) {
        if (arrayList != null) {
            Collections.sort(arrayList, new r());
            r3(arrayList, z2);
        }
    }

    public final void r3(ArrayList<MediaItem> arrayList, boolean z2) {
        for (MediaItem mediaItem : arrayList) {
            int i2 = mediaItem.mimeType;
            if (i2 == 0) {
                String str = mediaItem.editedImagePath;
                if (str != null) {
                    sn2.a(this, str);
                    p3(mediaItem.editedImagePath, false);
                } else {
                    p3(mediaItem.fileFullPath, z2);
                }
            } else if (i2 == 1) {
                s3(mediaItem);
            }
        }
    }

    public final void s3(MediaItem mediaItem) {
        String strE;
        String strA = xn3.a();
        ChatItem chatItem = this.r;
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
            MessageVo threadBizType = MessageVo.buildVideoMessage(strA, DomainHelper.e(this.r), mediaItem.localPath, mediaItem.thumbnailPath, mediaItem.playLength, 0).setThreadBizType(this, this.D0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("video", threadBizType.data5);
                jSONObject.put("envir", this.r.getChatType() == 1 ? "2" : threadBizType.bizType == 0 ? "1" : "3");
                jSONObject.put("qua", "1");
                threadBizType.logExtension = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            getMessagingServiceInterface().r(threadBizType);
        } catch (Exception e3) {
            e3.printStackTrace();
            LogUtil.i(T0, 3, new s(), e3);
        }
    }

    public void t3() {
        if ("from_moment".equals(this.G0)) {
            Iterator<a.c> it = this.u.iterator();
            while (it.hasNext()) {
                sn2.a(this, it.next().b);
            }
            return;
        }
        for (a.c cVar : this.u) {
            if (cVar.b != null) {
                File file = new File(cVar.b);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public final void u3() {
        String string;
        int size = this.m0.size();
        if (this.P) {
            string = "from_moment".equals(this.G0) ? getResources().getString(R.string.media_pick_activity_finish) : getResources().getString(R.string.media_pick_activity_send);
            if (size != 0) {
                string = "from_moment".equals(this.G0) ? this.m0.get(0).mimeType != 1 ? getResources().getString(R.string.media_pick_activity_finish_with_number, Integer.valueOf(size), Integer.valueOf(this.v)) : getResources().getString(R.string.media_pick_activity_finish) : getResources().getString(R.string.media_pick_activity_send_with_number, Integer.valueOf(size), Integer.valueOf(this.v));
            }
        } else {
            string = "from_moment".equals(this.G0) ? getResources().getString(R.string.media_pick_activity_finish) : getResources().getString(R.string.media_pick_activity_send);
        }
        this.T.setText(string);
    }

    public void v3(int i2) {
        MediaItem mediaItem;
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || arrayList.size() <= i2 || (mediaItem = this.s.get(i2)) == null || mediaItem.mimeType != 4) {
            return;
        }
        mediaItem.isFileExpired = true;
        x3();
    }

    public void w3(String str) throws Throwable {
        String strD = com.zenmen.palmchat.database.b.D(this.r, str);
        if (TextUtils.isEmpty(strD)) {
            strD = getString(R.string.message_revoke_default_des);
        }
        if (isFinishing() || TextUtils.isEmpty(strD)) {
            return;
        }
        new sd3(this).k(strD).O(R.string.alert_dialog_ok).h(false).f(new b0()).e().show();
    }

    public final void x3() {
        MediaItem mediaItem;
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null || arrayList.size() <= this.q.getCurrentItem() || (mediaItem = this.s.get(this.q.getCurrentItem())) == null || mediaItem.mimeType != 4 || !mediaItem.isFileExpired || this.R0) {
            return;
        }
        this.R0 = true;
        new sd3(this).j(R.string.video_play_fail_content).T(R.string.video_play_fail).h(false).O(R.string.alert_dialog_ok).f(new x()).e().show();
    }

    public final void y3() {
        LogUtil.i(T0, "sortMeidaList");
        ArrayList<MediaItem> arrayList = this.s;
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, new g0());
        int i2 = 0;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            String str = this.s.get(i3).fileFullPath;
            if (str != null && str.equals(this.K)) {
                i2 = i3;
            }
        }
        this.x = i2;
    }

    public final void z3() {
        for (Map.Entry<String, Integer> entry : this.x0.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().intValue() >= 0) {
                dt0.l(AppContext.getContext(), Volley.getUserAgent()).h(key);
            }
        }
        this.x0.clear();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements ViewPager.OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PhotoViewActivity.this.J != 1 || PhotoViewActivity.this.g3()) {
                return;
            }
            PhotoViewActivity.this.C0.removeMessages(0);
            PhotoViewActivity.this.i0.setVisibility(0);
            PhotoViewActivity.this.C0.sendEmptyMessageDelayed(0, 6000L);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PhotoViewActivity.this.o3(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
