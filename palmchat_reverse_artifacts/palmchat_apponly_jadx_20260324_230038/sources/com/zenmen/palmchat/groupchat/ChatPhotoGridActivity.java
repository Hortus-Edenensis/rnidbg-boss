package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.framework.common.ContainerUtils;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.bq6;
import defpackage.eb6;
import defpackage.gr2;
import defpackage.ho3;
import defpackage.je1;
import defpackage.jr2;
import defpackage.k86;
import defpackage.pu1;
import defpackage.sd1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.wm3;
import defpackage.xt;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChatPhotoGridActivity extends BaseActionBarActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener {
    public ImageView A;
    public ImageView B;
    public ImageView C;
    public Animation E;
    public Animation F;
    public ChatItem H;
    public Toolbar s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public GridView x;
    public f y;
    public ViewGroup z;
    public int q = 0;
    public int r = 0;
    public boolean G = false;
    public ArrayList<MediaItem> I = new ArrayList<>();
    public ArrayList<MediaItem> J = new ArrayList<>();
    public g K = new g(this);
    public boolean L = false;
    public int M = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ChatPhotoGridActivity.this.Z1();
            ChatPhotoGridActivity.this.m2();
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<Void, Void, Cursor> {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00d8  */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Cursor doInBackground(Void... voidArr) {
            String str;
            String[] strArr;
            String str2;
            String[] strArr2;
            Cursor cursorQuery;
            if (ChatPhotoGridActivity.this.H != null) {
                String[] strArr3 = {"_id", "packet_id", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "data1", "data2", "data3", "data4", "msg_type", "data6", "data10", "message", "data5", "attach_status"};
                if (ChatPhotoGridActivity.this.H.getChatType() == 0) {
                    strArr2 = new String[]{DomainHelper.a(ChatPhotoGridActivity.this.H, false)};
                    str2 = "contact_relate=? and  (msg_type=2 or msg_type=4)";
                } else if (ChatPhotoGridActivity.this.H.getChatType() == 1) {
                    boolean zC = com.zenmen.palmchat.database.a.c();
                    str2 = "contact_relate" + com.zenmen.palmchat.database.a.b(zC) + " and (msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + "2 or msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + "4)";
                    strArr2 = new String[]{DomainHelper.e(ChatPhotoGridActivity.this.H) + com.zenmen.palmchat.database.a.a(zC)};
                } else {
                    str = null;
                    strArr = null;
                    cursorQuery = ChatPhotoGridActivity.this.getContentResolver().query(DBUriManager.b(ho3.class, ChatPhotoGridActivity.this.H), strArr3, str, strArr, "_id ASC");
                    if (cursorQuery != null) {
                        if (cursorQuery.getCount() > 0) {
                            ChatPhotoGridActivity.this.I.clear();
                            while (cursorQuery.moveToNext()) {
                                MediaItem mediaItem = new MediaItem();
                                mediaItem.mid = cursorQuery.getString(1);
                                mediaItem.modifyTime = (int) (cursorQuery.getLong(2) / 1000);
                                mediaItem.localPath = cursorQuery.getString(3);
                                mediaItem.thumbnailPath = cursorQuery.getString(4);
                                mediaItem.fileFullPath = cursorQuery.getString(5);
                                mediaItem.extension = cursorQuery.getString(6);
                                mediaItem.mimeType = cursorQuery.getInt(7);
                                mediaItem.text = cursorQuery.getString(10);
                                if (mediaItem.mimeType == 4) {
                                    mediaItem.fileSize = cursorQuery.getLong(9);
                                    mediaItem.playLength = cursorQuery.getLong(8);
                                    mediaItem.fileMD5 = cursorQuery.getString(11);
                                } else {
                                    mediaItem.extype = cursorQuery.getString(11);
                                }
                                mediaItem.isFileExpired = cursorQuery.getInt(12) == 5;
                                ChatPhotoGridActivity.this.I.add(mediaItem);
                            }
                            ChatPhotoGridActivity.this.J.clear();
                        }
                        cursorQuery.close();
                    }
                }
                strArr = strArr2;
                str = str2;
                cursorQuery = ChatPhotoGridActivity.this.getContentResolver().query(DBUriManager.b(ho3.class, ChatPhotoGridActivity.this.H), strArr3, str, strArr, "_id ASC");
                if (cursorQuery != null) {
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Cursor cursor) {
            if (ChatPhotoGridActivity.this.I == null || ChatPhotoGridActivity.this.I.size() == 0) {
                ChatPhotoGridActivity.this.v.setVisibility(0);
                ChatPhotoGridActivity.this.u.setVisibility(4);
                return;
            }
            ChatPhotoGridActivity.this.y = new f();
            ChatPhotoGridActivity.this.x.setAdapter((ListAdapter) ChatPhotoGridActivity.this.y);
            ChatPhotoGridActivity.this.x.setSelection(ChatPhotoGridActivity.this.M);
            ChatPhotoGridActivity.this.u.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements eb6.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                sy5.e(ChatPhotoGridActivity.this, R.string.start_downloading_video, 0).g();
            }
        }

        public e() {
        }

        @Override // eb6.a
        public void a(String str, String str2) {
            Message message = new Message();
            message.what = 2;
            if (!TextUtils.isEmpty(str2)) {
                message.obj = new Pair(str, str2);
            }
            ChatPhotoGridActivity.this.K.sendMessage(message);
        }

        @Override // eb6.a
        public void b(String str) {
            ChatPhotoGridActivity.this.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BaseAdapter implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public je1 f14227a;
        public je1 b;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f14228a;
            public ImageView b;
            public ImageView c;
            public String d;
            public RelativeLayout e;
            public int f;
            public View g;

            public a() {
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ChatPhotoGridActivity.this.I.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ChatPhotoGridActivity.this.I.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean zB;
            String str;
            if (view == null) {
                view = LayoutInflater.from(ChatPhotoGridActivity.this).inflate(R.layout.grid_item_media_pick, (ViewGroup) null);
                aVar = new a();
                aVar.f14228a = (ImageView) view.findViewById(R.id.image);
                aVar.b = (ImageView) view.findViewById(R.id.check_image);
                aVar.c = (ImageView) view.findViewById(R.id.file_type_indicator_image);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.check_image_area);
                aVar.e = relativeLayout;
                relativeLayout.setOnClickListener(this);
                aVar.g = view.findViewById(R.id.global_background);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f = i;
            if (ChatPhotoGridActivity.this.G) {
                aVar.b.setVisibility(0);
                aVar.e.setVisibility(0);
                if (ChatPhotoGridActivity.this.J.contains(getItem(i))) {
                    aVar.b.setImageResource(R.drawable.icon_green_checked);
                    aVar.g.setBackgroundColor(ChatPhotoGridActivity.this.r);
                } else {
                    aVar.g.setBackgroundColor(ChatPhotoGridActivity.this.q);
                    aVar.b.setImageResource(R.drawable.icon_white_uncheck);
                }
            } else {
                aVar.g.setBackgroundColor(ChatPhotoGridActivity.this.q);
                aVar.b.setVisibility(8);
                aVar.e.setVisibility(8);
            }
            MediaItem mediaItem = (MediaItem) ChatPhotoGridActivity.this.I.get(i);
            if (mediaItem.mimeType == 4) {
                aVar.c.setImageResource(R.drawable.icon_file_type_video);
                aVar.c.setVisibility(0);
                zB = pu1.b(mediaItem.thumbnailPath);
                if (zB) {
                    str = "file://" + mediaItem.thumbnailPath;
                } else {
                    str = mediaItem.extension;
                }
            } else {
                aVar.c.setVisibility(8);
                zB = pu1.b(mediaItem.localPath);
                if (zB) {
                    str = "file://" + mediaItem.localPath;
                } else {
                    str = mediaItem.thumbnailPath;
                }
            }
            if (aVar.d != str) {
                aVar.d = str;
                gr2.j().h(str, aVar.f14228a, zB ? this.b : this.f14227a);
            }
            return view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = (a) ((View) view.getParent()).getTag();
            MediaItem mediaItem = (MediaItem) getItem(aVar.f);
            if (ChatPhotoGridActivity.this.J.contains(mediaItem)) {
                ChatPhotoGridActivity.this.J.remove(mediaItem);
                aVar.b.setImageResource(R.drawable.icon_white_uncheck);
            } else {
                ChatPhotoGridActivity.this.J.add(mediaItem);
                aVar.b.setImageResource(R.drawable.icon_green_checked);
            }
            notifyDataSetChanged();
            int size = ChatPhotoGridActivity.this.J.size();
            ChatPhotoGridActivity.this.t.setText(String.format(ChatPhotoGridActivity.this.getString(R.string.select_photos), Integer.valueOf(size)));
            ChatPhotoGridActivity.this.k2(size > 0);
        }

        public f() {
            je1.a aVarA = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).A(R.drawable.media_pick_grid_item_background);
            ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
            this.f14227a = aVarA.w(imageScaleType).r();
            this.b = new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).A(R.drawable.media_pick_grid_item_background).w(imageScaleType).r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ChatPhotoGridActivity> f14229a;

        public g(ChatPhotoGridActivity chatPhotoGridActivity) {
            this.f14229a = new WeakReference<>(chatPhotoGridActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f14229a.get() != null) {
                    this.f14229a.get().w.startAnimation(this.f14229a.get().E);
                    return;
                }
                return;
            }
            if (i == 1) {
                if (this.f14229a.get() != null) {
                    this.f14229a.get().w.startAnimation(this.f14229a.get().F);
                    return;
                }
                return;
            }
            if (i == 2 && this.f14229a.get() != null) {
                ChatPhotoGridActivity chatPhotoGridActivity = this.f14229a.get();
                Pair pair = (Pair) message.obj;
                if (pair != null) {
                    for (MediaItem mediaItem : chatPhotoGridActivity.I) {
                        if (mediaItem.mimeType == 4 && mediaItem.mid.equals(pair.first)) {
                            mediaItem.localPath = (String) pair.second;
                            mediaItem.thumbnailPath = ((String) pair.second) + ".thumbnail";
                            chatPhotoGridActivity.j2((String) pair.second);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static boolean d2(MediaItem mediaItem) {
        File fileB;
        boolean z = !TextUtils.isEmpty(mediaItem.localPath) && new File(mediaItem.localPath).exists();
        if (z || TextUtils.isEmpty(mediaItem.fileFullPath) || (fileB = sd1.b(mediaItem.fileFullPath)) == null || !fileB.exists() || fileB.length() <= 0) {
            return z;
        }
        return true;
    }

    public final String W1(long j) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        return calendar.get(3) == calendar2.get(3) ? getString(R.string.current_week) : calendar.get(2) == calendar2.get(2) ? getString(R.string.current_month) : String.format("%d/%d", Integer.valueOf(calendar2.get(1)), Integer.valueOf(calendar2.get(2) + 1));
    }

    public final MessageVo X1(MediaItem mediaItem) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = mediaItem.mid;
        messageVo.data1 = mediaItem.localPath;
        messageVo.data2 = mediaItem.thumbnailPath;
        messageVo.data3 = mediaItem.fileFullPath;
        messageVo.data4 = mediaItem.extension;
        int i = mediaItem.mimeType;
        messageVo.mimeType = i;
        String str = mediaItem.text;
        if (str == null) {
            str = "";
        }
        messageVo.text = str;
        if (i == 4) {
            messageVo.data6 = String.valueOf(mediaItem.playLength);
            messageVo.data10 = String.valueOf(mediaItem.fileSize);
        } else {
            messageVo.data5 = mediaItem.extype;
        }
        return messageVo;
    }

    public final void Y1(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                sb.append("packet_id=?");
            } else {
                sb.append("packet_id=? or ");
            }
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, this.H), sb.toString(), strArr);
    }

    public final void Z1() {
        String[] strArr = new String[this.J.size()];
        for (int i = 0; i < this.J.size(); i++) {
            strArr[i] = this.J.get(i).mid;
        }
        Y1(strArr);
        this.I.removeAll(this.J);
        this.J.clear();
        if (this.I.isEmpty()) {
            this.L = false;
        }
    }

    public final String a2(String str) {
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

    public final void b2() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.s = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.chat_photo);
        TextView textView = (TextView) this.s.findViewById(R.id.action_button);
        this.u = textView;
        textView.setText(R.string.photo_preview_choose);
        this.u.setVisibility(8);
        this.u.setOnClickListener(this);
        setSupportActionBar(this.s);
    }

    public final void c2() {
        this.t = (TextView) findViewById(R.id.title);
        this.v = (TextView) findViewById(R.id.no_photo_text);
        this.w = (TextView) findViewById(R.id.date_text);
        GridView gridView = (GridView) findViewById(R.id.photo_grid_view);
        this.x = gridView;
        gridView.setOnItemClickListener(this);
        this.x.setOnScrollListener(this);
        this.z = (ViewGroup) findViewById(R.id.bottom_tool_bar);
        ImageView imageView = (ImageView) findViewById(R.id.bottom_tool_item_forward);
        this.A = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.bottom_tool_item_delete);
        this.B = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.bottom_tool_item_download);
        this.C = imageView3;
        imageView3.setOnClickListener(this);
        k2(false);
        this.E = AnimationUtils.loadAnimation(this, R.anim.alpha_fade_in);
        this.F = AnimationUtils.loadAnimation(this, R.anim.alpha_fade_out);
        b bVar = new b();
        this.E.setAnimationListener(bVar);
        this.F.setAnimationListener(bVar);
    }

    public final void e2() {
        new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void f2(Intent intent) {
        this.H = (ChatItem) intent.getParcelableExtra("info_item");
        this.L = intent.getBooleanExtra("need_start_photo_view_activity", false);
        this.M = intent.getIntExtra("current_viewing_photo_index", Integer.MAX_VALUE);
    }

    public final String g2(String str, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        String strX = xt.x(bitmap, String.valueOf(System.currentTimeMillis()));
        com.zenmen.palmchat.database.b.K(this.H, str, strX);
        if (!z) {
            return strX;
        }
        wm3.a(strX);
        sy5.f(this, getString(R.string.save_to_dir, pu1.m()), 0).g();
        return strX;
    }

    public final void h2(String str, String str2, boolean z) {
        gr2.j().k(k86.p(str2), bq6.r(), new d(str, z));
    }

    public final void i2(MediaItem mediaItem) {
        if (eb6.e().d(mediaItem.localPath)) {
            j2(mediaItem.localPath);
        } else {
            eb6.e().c(this, this.H.getChatId(), mediaItem.mid, mediaItem.fileFullPath, mediaItem.extension, mediaItem.fileMD5, new e());
        }
    }

    public final void j2(String str) {
        try {
            String str2 = (pu1.m() + File.separator) + System.currentTimeMillis() + ".mp4";
            if (pu1.f(new File(str), pu1.c(str2))) {
                wm3.a(str2);
                sy5.f(this, getString(R.string.save_to_video_dir, pu1.m()), 0).g();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void k2(boolean z) {
        this.A.setEnabled(z);
        this.B.setEnabled(z);
        this.C.setEnabled(z);
    }

    public final void l2(int i, boolean z) {
        if (i < 0 || i >= this.I.size()) {
            return;
        }
        MediaItem mediaItem = this.I.get(i);
        Intent intent = new Intent(this, (Class<?>) PhotoViewActivity.class);
        intent.putExtra("info_item", this.H);
        intent.putExtra("need_load_chat_image_list", true);
        intent.putExtra("first_item_mid", mediaItem.mid);
        intent.putExtra("show_mode", 1);
        intent.putExtra("message_vo", X1(mediaItem));
        if (z) {
            intent.putExtra("start_from_chat_photo_grid_activity", true);
        }
        intent.putExtra("init_item_auto_play", z);
        if (this.G) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.J.size(); i2++) {
                arrayList.add(Integer.valueOf(this.I.indexOf(this.J.get(i2))));
            }
            intent.putIntegerArrayListExtra("extra_checked_item_indexes", arrayList);
        }
        startActivityForResult(intent, 1001);
    }

    public final void m2() {
        boolean z = !this.G;
        this.G = z;
        if (z) {
            this.t.setText(String.format(getString(R.string.select_photos), 0));
            this.u.setText(R.string.action_sheet_cancel);
            k2(false);
            this.z.setVisibility(0);
        } else {
            this.t.setText(R.string.chat_photo);
            this.u.setText(R.string.photo_preview_choose);
            this.z.setVisibility(8);
            if (this.I.size() == 0) {
                this.v.setVisibility(0);
                this.u.setVisibility(4);
            } else {
                this.J.clear();
            }
        }
        f fVar = this.y;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            m2();
            return;
        }
        if (i == 1001 && i2 == -1) {
            if (!this.G) {
                this.M = intent.getIntExtra("current_viewing_photo_index", Integer.MAX_VALUE);
                this.L = true;
                return;
            }
            ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("extra_checked_item_indexes");
            this.J.clear();
            for (Integer num : integerArrayListExtra) {
                if (this.I.size() > num.intValue()) {
                    this.J.add(this.I.get(num.intValue()));
                }
            }
            this.y.notifyDataSetChanged();
            int size = this.J.size();
            this.t.setText(String.format(getString(R.string.select_photos), Integer.valueOf(size)));
            k2(size > 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.u) {
            m2();
            return;
        }
        if (view == this.A) {
            ArrayList arrayList = new ArrayList();
            for (MediaItem mediaItem : this.J) {
                if ((mediaItem.mimeType != 2 || !d2(mediaItem)) && (mediaItem.mimeType != 4 || !eb6.e().d(mediaItem.localPath))) {
                    new sd3(this).j(R.string.downloading_before_forward).O(R.string.alert_dialog_ok).e().show();
                    return;
                }
                arrayList.add(X1(mediaItem));
            }
            Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
            intent.putExtra("message_vo_list", arrayList);
            startActivityForResult(intent, 1000);
            return;
        }
        if (view == this.B) {
            new sd3(this).j(R.string.confirm_delete).O(R.string.string_delete).K(R.string.alert_dialog_cancel).f(new a()).e().show();
            return;
        }
        if (view == this.C) {
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
            if (!tg4.b(this, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_SAVE);
                return;
            }
            for (MediaItem mediaItem2 : this.J) {
                if (!mediaItem2.isFileExpired) {
                    int i = mediaItem2.mimeType;
                    if (i == 2) {
                        String strA2 = a2(mediaItem2.extension);
                        if (TextUtils.isEmpty(strA2)) {
                            h2(mediaItem2.mid, mediaItem2.fileFullPath, true);
                        } else {
                            h2(mediaItem2.mid, strA2, true);
                        }
                    } else if (i == 4) {
                        i2(mediaItem2);
                    }
                }
            }
            m2();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = getResources().getColor(R.color.media_pick_bg_normal);
        this.r = getResources().getColor(R.color.media_pick_bg_select);
        f2(getIntent());
        setContentView(R.layout.activity_chat_photo_grid);
        b2();
        c2();
        e2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.L = false;
        l2(i, true);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.G) {
            m2();
        } else {
            if (this.L) {
                if (this.M >= this.I.size()) {
                    this.M = this.I.size() - 1;
                }
                l2(this.M, false);
            }
            finish();
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.G) {
            m2();
        } else {
            if (this.L) {
                if (this.M >= this.I.size()) {
                    this.M = this.I.size() - 1;
                }
                l2(this.M, false);
            }
            finish();
        }
        return true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ArrayList<MediaItem> arrayList = this.I;
        if (arrayList == null || i2 <= 0) {
            return;
        }
        long j = arrayList.get(i).modifyTime;
        TextView textView = this.w;
        if (j < 2147483647L) {
            j *= 1000;
        }
        textView.setText(W1(j));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.K.sendEmptyMessageDelayed(1, 1000L);
            return;
        }
        this.K.removeMessages(1);
        if (this.w.getVisibility() != 0) {
            this.K.removeMessages(0);
            this.K.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation == ChatPhotoGridActivity.this.F) {
                ChatPhotoGridActivity.this.w.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (animation == ChatPhotoGridActivity.this.E) {
                ChatPhotoGridActivity.this.w.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14224a;
        public final /* synthetic */ boolean b;

        public d(String str, boolean z) {
            this.f14224a = str;
            this.b = z;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatPhotoGridActivity.this.g2(this.f14224a, bitmap, this.b);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
