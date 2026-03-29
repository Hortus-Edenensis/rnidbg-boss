package com.zenmen.palmchat.media.file;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fu1;
import defpackage.gu1;
import defpackage.k86;
import defpackage.o86;
import defpackage.rl0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.ue6;
import defpackage.wh2;
import defpackage.xn3;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FileSelectActivity extends BaseActionBarActivity {
    public static int G = 104857600;
    public ChatItem A;
    public int E;
    public View F;
    public Toolbar q;
    public gu1 t;
    public ListView u;
    public File v;
    public TextView x;
    public TextView y;
    public TextView z;
    public ArrayList<fu1> r = new ArrayList<>();
    public ArrayList<wh2> s = new ArrayList<>();
    public ArrayList<fu1> w = new ArrayList<>();
    public int B = 0;
    public int C = 1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FileSelectActivity.this.R1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FileSelectActivity.this.z.setEnabled(false);
            for (fu1 fu1Var : FileSelectActivity.this.w) {
                if (fu1Var.f != null) {
                    int i = FileSelectActivity.this.B;
                    if (i == 0) {
                        FileSelectActivity.this.X1(fu1Var.f.getAbsolutePath());
                    } else if (i == 1) {
                        FileSelectActivity.this.Q1(fu1Var.f.getAbsolutePath());
                    }
                }
            }
            FileSelectActivity.this.setResult(-1);
            FileSelectActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "send_message");
            put("status", "sendFile");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<String, Void, Void> {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(String... strArr) throws Throwable {
            BufferedOutputStream bufferedOutputStream;
            String str = strArr[0];
            String str2 = str + ".thumbnail";
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
            BufferedOutputStream bufferedOutputStream2 = null;
            if (!TextUtils.isEmpty(strExtractMetadata) && strExtractMetadata.equals("video/mp4")) {
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(9);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                        try {
                            try {
                                frameAtTime.compress(Bitmap.CompressFormat.JPEG, 30, bufferedOutputStream);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(TECameraSettings.Parameters.VIDEO_PATH, str);
                                contentValues.put("video_thumbnail", str2);
                                contentValues.put("video_type", (Integer) 0);
                                contentValues.put("video_play_length", strExtractMetadata2);
                                contentValues.put("video_modify_time", Long.valueOf(System.currentTimeMillis()));
                                FileSelectActivity.this.getContentResolver().insert(ue6.f21200a, contentValues);
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                frameAtTime.recycle();
                                mediaMetadataRetriever.release();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                frameAtTime.recycle();
                                mediaMetadataRetriever.release();
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            frameAtTime.recycle();
                            try {
                                mediaMetadataRetriever.release();
                                throw th;
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream2 != null) {
                    }
                    frameAtTime.recycle();
                    mediaMetadataRetriever.release();
                    throw th;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0 || i >= FileSelectActivity.this.r.size()) {
                return;
            }
            fu1 fu1Var = (fu1) FileSelectActivity.this.r.get(i);
            File file = fu1Var.f;
            if (file == null) {
                wh2 wh2Var = (wh2) FileSelectActivity.this.s.remove(FileSelectActivity.this.s.size() - 1);
                FileSelectActivity.this.y.setText(wh2Var.d);
                File file2 = wh2Var.c;
                if (file2 != null) {
                    FileSelectActivity.this.V1(file2);
                } else {
                    FileSelectActivity.this.W1();
                }
                FileSelectActivity.this.u.setSelectionFromTop(wh2Var.f21702a, wh2Var.b);
                return;
            }
            if (file.isDirectory()) {
                wh2 wh2Var2 = new wh2();
                wh2Var2.f21702a = FileSelectActivity.this.u.getFirstVisiblePosition();
                wh2Var2.b = FileSelectActivity.this.u.getChildAt(0).getTop();
                wh2Var2.c = FileSelectActivity.this.v;
                wh2Var2.d = FileSelectActivity.this.y.getText().toString();
                FileSelectActivity.this.s.add(wh2Var2);
                if (!FileSelectActivity.this.V1(file)) {
                    FileSelectActivity.this.s.remove(wh2Var2);
                    return;
                } else {
                    FileSelectActivity.this.y.setText(fu1Var.b);
                    FileSelectActivity.this.u.setSelection(0);
                    return;
                }
            }
            if (fu1Var.g) {
                fu1Var.g = false;
                Iterator it = FileSelectActivity.this.w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    fu1 fu1Var2 = (fu1) it.next();
                    if (fu1Var2.f.getAbsolutePath().equals(fu1Var.f.getAbsolutePath())) {
                        FileSelectActivity.this.w.remove(fu1Var2);
                        break;
                    }
                }
                FileSelectActivity.this.Z1();
            } else {
                if (FileSelectActivity.this.w.size() == 9) {
                    FileSelectActivity fileSelectActivity = FileSelectActivity.this;
                    fileSelectActivity.Y1(fileSelectActivity.getString(R.string.file_select_reach_limit));
                    return;
                }
                long length = file.length();
                int i2 = FileSelectActivity.G;
                if (length >= i2) {
                    FileSelectActivity fileSelectActivity2 = FileSelectActivity.this;
                    fileSelectActivity2.Y1(fileSelectActivity2.getString(R.string.file_select_reach_length_limit, Integer.valueOf(i2 / 1048576)));
                    return;
                } else {
                    fu1Var.g = true;
                    FileSelectActivity.this.w.add(fu1Var);
                    FileSelectActivity.this.Z1();
                }
            }
            FileSelectActivity.this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Comparator<File> {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.isDirectory() != file2.isDirectory() ? file.isDirectory() ? -1 : 1 : file.getName().compareToIgnoreCase(file2.getName());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Comparator<File> {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    public final void Q1(String str) {
        if (new File(str).exists()) {
            new d().execute(str);
        } else {
            sy5.e(this, R.string.send_file_delete, 0).g();
        }
    }

    public final boolean R1(boolean z) {
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            return true;
        }
        if (z) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 10001);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public final Comparator<File> S1() {
        int i = this.C;
        if (i == 0) {
            return new g();
        }
        if (i == 1) {
            return new h();
        }
        return null;
    }

    public final void T1() {
        this.u.setOnItemClickListener(new e());
    }

    public final void U1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        TextView textView = (TextView) this.q.findViewById(R.id.title);
        this.y = textView;
        textView.setText(R.string.app_name);
        TextView textView2 = (TextView) this.q.findViewById(R.id.action_button);
        this.z = textView2;
        textView2.setText(R.string.alert_dialog_ok);
        this.z.setOnClickListener(new b());
    }

    public final boolean V1(File file) {
        if (!file.canRead()) {
            if ((!file.getAbsolutePath().startsWith(Environment.getExternalStorageDirectory().toString()) && !file.getAbsolutePath().startsWith("/sdcard") && !file.getAbsolutePath().startsWith("/mnt/sdcard")) || Environment.getExternalStorageState().equals("mounted") || Environment.getExternalStorageState().equals("mounted_ro")) {
                Y1(getString(R.string.access_error));
                return false;
            }
            this.v = file;
            a2();
            TextView textView = this.x;
            if (textView != null) {
                textView.setText(R.string.file_dir_empty);
            }
            this.t.notifyDataSetChanged();
            return true;
        }
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Y1(getString(R.string.access_error));
                return false;
            }
            this.v = file;
            a2();
            Arrays.sort(fileArrListFiles, S1());
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().startsWith(".")) {
                    fu1 fu1Var = new fu1();
                    fu1Var.b = file2.getName();
                    fu1Var.f = file2;
                    if (file2.isDirectory()) {
                        fu1Var.f17598a = R.drawable.input_add_icon_wenjian;
                        fu1Var.c = getString(R.string.folder);
                        this.r.add(fu1Var);
                    } else {
                        String name = file2.getName();
                        fu1Var.d = o86.e(name);
                        fu1Var.c = o86.b(file2.length());
                        String lowerCase = name.toLowerCase();
                        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".jpeg")) {
                            fu1Var.e = k86.p(file2.getAbsolutePath());
                        }
                        Iterator<fu1> it = this.w.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().f.getAbsolutePath().equals(fu1Var.f.getAbsolutePath())) {
                                fu1Var.g = true;
                                break;
                            }
                        }
                        if (file2.length() != 0) {
                            this.r.add(fu1Var);
                        }
                    }
                }
            }
            fu1 fu1Var2 = new fu1();
            fu1Var2.b = "..";
            if (this.s.size() > 0) {
                ArrayList<wh2> arrayList = this.s;
                File file3 = arrayList.get(arrayList.size() - 1).c;
                if (file3 != null) {
                    fu1Var2.c = file3.toString();
                    fu1Var2.f17598a = R.drawable.input_add_icon_wenjian;
                    fu1Var2.f = null;
                    this.r.add(0, fu1Var2);
                }
            }
            this.t.notifyDataSetChanged();
            return true;
        } catch (Exception e2) {
            Y1(e2.getLocalizedMessage());
            return false;
        }
    }

    public final void W1() {
        a2();
        V1(new File(Environment.getExternalStorageDirectory().getAbsolutePath()));
    }

    public final void X1(String str) {
        String strA = xn3.a();
        ChatItem chatItem = this.A;
        if (chatItem == null || TextUtils.isEmpty(chatItem.getChatId())) {
            return;
        }
        String strE = DomainHelper.e(this.A);
        try {
            if (new File(str).exists()) {
                getMessagingServiceInterface().r(MessageVo.buildFileMessage(strA, strE, str, 0).setThreadBizType(this, this.E));
            } else {
                sy5.e(AppContext.getContext(), R.string.send_file_delete, 0).g();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(BaseActionBarActivity.TAG, 3, new c(), e2);
        }
    }

    public final void Y1(String str) {
        sd3 sd3Var = new sd3(this);
        sd3Var.T(R.string.update_install_dialog_title).k(str).O(R.string.alert_dialog_ok).h(false).f(new f());
        sd3Var.e().show();
    }

    public final void Z1() {
        String string = getResources().getString(R.string.file_select_activity_send);
        if (this.w.size() > 0) {
            string = getResources().getString(R.string.file_select_activity_send_with_number, Integer.valueOf(this.w.size()));
        }
        this.z.setText(string);
        if (this.w.size() > 0) {
            this.z.setEnabled(true);
        } else {
            this.z.setEnabled(false);
        }
    }

    public final void a2() {
        this.r.clear();
        Z1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.s.size() <= 0) {
            super.onBackPressed();
            return;
        }
        wh2 wh2VarRemove = this.s.remove(r0.size() - 1);
        this.y.setText(wh2VarRemove.d);
        File file = wh2VarRemove.c;
        if (file != null) {
            V1(file);
        } else {
            W1();
        }
        this.u.setSelectionFromTop(wh2VarRemove.f21702a, wh2VarRemove.b);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        G = rl0.h().e().f();
        setContentView(R.layout.layout_activity_file_select);
        Intent intent = getIntent();
        this.A = (ChatItem) intent.getParcelableExtra("chat_item");
        this.E = intent.getIntExtra("thread_biz_type", 0);
        this.B = intent.getIntExtra("use_mode", 0);
        U1();
        this.t = new gu1(this, this.r);
        ListView listView = (ListView) findViewById(R.id.file_list_view);
        this.u = listView;
        listView.setAdapter((ListAdapter) this.t);
        View viewInflate = getLayoutInflater().inflate(R.layout.empty_view_file_select, (ViewGroup) null);
        this.u.setEmptyView(viewInflate);
        this.x = (TextView) viewInflate.findViewById(R.id.empty_view);
        T1();
        this.F = findViewById(R.id.permission_layout);
        findViewById(R.id.action_btn_permission).setOnClickListener(new a());
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!R1(false)) {
            this.F.setVisibility(0);
            this.u.setVisibility(8);
            a2();
        } else {
            if (this.s.size() > 0) {
                V1(this.s.get(r1.size() - 1).c);
            } else {
                W1();
            }
            this.F.setVisibility(8);
            this.u.setVisibility(0);
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
}
