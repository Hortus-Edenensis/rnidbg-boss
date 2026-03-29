package com.zenmen.palmchat.settings;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.PieChartView;
import defpackage.is0;
import defpackage.pu1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.ue6;
import java.io.File;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CleanStorageActivity extends BaseActionBarActivity implements is0.f {
    public c A;
    public Toolbar r;
    public PieChartView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public Animation z;
    public String[] q = {AppContext.getContext().getString(R.string.settings_general_clean_storage_clean_old_files)};
    public boolean B = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            File file = new File(pu1.e);
            CleanStorageActivity.this.A = CleanStorageActivity.this.new c(true, true);
            CleanStorageActivity.this.A.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            File file = new File(pu1.e);
            CleanStorageActivity.this.A = CleanStorageActivity.this.new c(true);
            CleanStorageActivity.this.A.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
        }
    }

    public final String M1(long j) {
        return j < 1024 ? String.format("%d B", Long.valueOf(j)) : j < 1048576 ? String.format("%.1f KB", Double.valueOf(j / 1024.0d)) : j < 1073741824 ? String.format("%.1f MB", Double.valueOf((j / 1024.0d) / 1024.0d)) : String.format("%.1f GB", Double.valueOf(((j / 1024.0d) / 1024.0d) / 1024.0d));
    }

    public final void N1() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.z = rotateAnimation;
        rotateAnimation.setDuration(1000L);
        this.z.setRepeatCount(-1);
        this.z.setInterpolator(new LinearInterpolator());
        this.s = (PieChartView) findViewById(R.id.pie_chart);
        this.t = (ImageView) findViewById(R.id.progress_image);
        this.u = (TextView) findViewById(R.id.progress_text);
        this.v = (TextView) findViewById(R.id.palmchat_storage);
        this.w = (TextView) findViewById(R.id.others_storage);
        this.x = (TextView) findViewById(R.id.left_storage);
        this.y = (TextView) findViewById(R.id.clean_tip_text);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.settings_general_clean_storage);
        this.r = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public void onCleanBtnClicked(View view) {
        if (this.B) {
            return;
        }
        new sd3(this).j(R.string.settings_general_clean_storage_confirm).K(R.string.dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new b()).Q();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_clean_storage);
        initActionBar();
        N1();
        File file = new File(pu1.e);
        c cVar = new c();
        this.A = cVar;
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_clean_storage, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.A;
        if (cVar != null) {
            cVar.cancel(false);
        }
    }

    @Override // is0.f
    public void onItemClicked(int i) {
        if (i != 0) {
            return;
        }
        new sd3(this).j(R.string.settings_general_clean_storage_clean_old_files_confirm).K(R.string.dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new a()).Q();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        showPopupMenu(this, this.r, this.q, null, this, null);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<File, Integer, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15177a;
        public boolean b;
        public long c;
        public File d;
        public int e;
        public Queue<File> f;

        public c() {
            this.c = 0L;
            this.e = 0;
            this.f = new ArrayDeque();
            this.f15177a = false;
            this.b = false;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long doInBackground(File... fileArr) {
            HashSet hashSet = new HashSet();
            Cursor cursorQuery = CleanStorageActivity.this.getContentResolver().query(ue6.f21200a, new String[]{TECameraSettings.Parameters.VIDEO_PATH}, "video_type=2", null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    hashSet.add(string);
                    hashSet.add(string + ".thumbnail");
                }
                cursorQuery.close();
            }
            File file = fileArr[0];
            if (file != null && file.exists() && fileArr[0].isDirectory()) {
                File file2 = fileArr[0];
                this.d = file2;
                this.f.add(file2);
            }
            while (true) {
                File filePoll = this.f.poll();
                if (filePoll == null || isCancelled()) {
                    break;
                }
                File[] fileArrListFiles = filePoll.listFiles();
                if (fileArrListFiles != null) {
                    for (int i = 0; i < fileArrListFiles.length; i++) {
                        if (fileArrListFiles[i].isDirectory()) {
                            this.f.add(fileArrListFiles[i]);
                        } else {
                            this.e++;
                        }
                    }
                }
            }
            long j = 0;
            if (this.e > 0) {
                this.f.clear();
                this.f.add(fileArr[0]);
                long jCurrentTimeMillis = System.currentTimeMillis() - 7776000000L;
                int i2 = 0;
                while (true) {
                    File filePoll2 = this.f.poll();
                    if (filePoll2 == null || isCancelled()) {
                        break;
                    }
                    File[] fileArrListFiles2 = filePoll2.listFiles();
                    if (fileArrListFiles2 != null) {
                        for (int i3 = 0; i3 < fileArrListFiles2.length; i3++) {
                            if (fileArrListFiles2[i3].isDirectory()) {
                                this.f.add(fileArrListFiles2[i3]);
                            } else {
                                long length = fileArrListFiles2[i3].length();
                                j += length;
                                if (!this.f15177a) {
                                    i2++;
                                    publishProgress(Integer.valueOf((i2 * 100) / this.e));
                                } else if (!this.b || fileArrListFiles2[i3].lastModified() < jCurrentTimeMillis) {
                                    if (!String.valueOf(filePoll2).equals(pu1.g) && !String.valueOf(filePoll2).equals(pu1.k) && !hashSet.contains(fileArrListFiles2[i3].getAbsolutePath()) && fileArrListFiles2[i3].delete()) {
                                        this.c += length;
                                        d(CleanStorageActivity.this, fileArrListFiles2[i3].getPath());
                                    }
                                    i2++;
                                    publishProgress(Integer.valueOf((i2 * 100) / this.e));
                                } else {
                                    i2++;
                                    publishProgress(Integer.valueOf((i2 * 100) / this.e));
                                }
                            }
                        }
                    }
                }
            }
            if (this.f15177a) {
                if (this.b) {
                    CleanStorageActivity.this.getContentResolver().delete(ue6.f21200a, "video_modify_time<" + String.valueOf(System.currentTimeMillis() - 2592000000L) + " and video_type" + ContainerUtils.KEY_VALUE_DELIMITER + 0, null);
                } else {
                    CleanStorageActivity.this.getContentResolver().delete(ue6.f21200a, "video_type=0", null);
                }
            }
            return Long.valueOf(j);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Long l) {
            if (this.f15177a) {
                CleanStorageActivity.this.hideBaseProgressBar();
                if (this.b && this.c == 0) {
                    sy5.e(CleanStorageActivity.this, R.string.settings_general_clean_storage_no_old_files, 0).g();
                } else {
                    MaterialDialog.d dVarO = new sd3(CleanStorageActivity.this).O(R.string.dialog_confirm);
                    CleanStorageActivity cleanStorageActivity = CleanStorageActivity.this;
                    dVarO.k(cleanStorageActivity.getString(R.string.settings_general_clean_storage_result, cleanStorageActivity.M1(this.c))).Q();
                }
            } else {
                CleanStorageActivity.this.z.cancel();
                CleanStorageActivity.this.t.setAnimation(null);
            }
            if (this.d != null) {
                CleanStorageActivity.this.t.setVisibility(8);
                CleanStorageActivity.this.u.setVisibility(8);
                CleanStorageActivity.this.s.setVisibility(0);
                boolean z = this.f15177a;
                if (!z || this.c > 0) {
                    long jLongValue = l.longValue();
                    if (z) {
                        jLongValue -= this.c;
                    }
                    long totalSpace = this.d.getTotalSpace();
                    long freeSpace = this.d.getFreeSpace();
                    if (totalSpace == 0) {
                        return;
                    }
                    long j = (totalSpace - jLongValue) - freeSpace;
                    CleanStorageActivity.this.s.setBlocks(new PieChartView.a[]{new PieChartView.a(CleanStorageActivity.this.getResources().getColor(R.color.palm_chat_storage_color), jLongValue), new PieChartView.a(CleanStorageActivity.this.getResources().getColor(R.color.others_storage_color), j), new PieChartView.a(CleanStorageActivity.this.getResources().getColor(R.color.left_storage_color), freeSpace)}, 0);
                    CleanStorageActivity.this.s.setSteps(5);
                    CleanStorageActivity.this.s.invalidate();
                    CleanStorageActivity.this.v.setText(CleanStorageActivity.this.M1(jLongValue));
                    CleanStorageActivity.this.w.setText(CleanStorageActivity.this.M1(j));
                    CleanStorageActivity.this.x.setText(CleanStorageActivity.this.M1(freeSpace));
                    double d = totalSpace;
                    if (jLongValue / d < 0.1d) {
                        if (freeSpace / d >= 0.5d) {
                            CleanStorageActivity.this.y.setText(R.string.settings_general_clean_storage_tip_1);
                        } else {
                            CleanStorageActivity.this.y.setText(R.string.settings_general_clean_storage_tip_2);
                        }
                    } else if (freeSpace / d >= 0.5d) {
                        CleanStorageActivity.this.y.setText(CleanStorageActivity.this.getString(R.string.settings_general_clean_storage_tip_3, Long.valueOf((jLongValue * 100) / totalSpace)));
                    } else {
                        CleanStorageActivity.this.y.setText(CleanStorageActivity.this.getString(R.string.settings_general_clean_storage_tip_4, Long.valueOf((jLongValue * 100) / totalSpace)));
                    }
                }
            }
            CleanStorageActivity.this.B = false;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            if (!this.f15177a) {
                CleanStorageActivity.this.u.setText(CleanStorageActivity.this.getString(R.string.settings_general_clean_storage_loading, numArr[0]));
            } else {
                CleanStorageActivity cleanStorageActivity = CleanStorageActivity.this;
                cleanStorageActivity.mBaseProgressDialog.b(cleanStorageActivity.getString(R.string.settings_general_clean_storage_deleting, numArr[0]));
            }
        }

        public void d(Context context, String str) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            CleanStorageActivity.this.B = true;
            if (this.f15177a) {
                CleanStorageActivity cleanStorageActivity = CleanStorageActivity.this;
                cleanStorageActivity.showBaseProgressBar(cleanStorageActivity.getString(R.string.settings_general_clean_storage_deleting, 0), false, false);
                return;
            }
            CleanStorageActivity.this.t.setVisibility(0);
            CleanStorageActivity.this.u.setVisibility(0);
            CleanStorageActivity.this.s.setVisibility(8);
            CleanStorageActivity.this.t.setAnimation(CleanStorageActivity.this.z);
            CleanStorageActivity.this.z.start();
        }

        public c(boolean z) {
            this.c = 0L;
            this.e = 0;
            this.f = new ArrayDeque();
            this.f15177a = z;
            this.b = false;
        }

        public c(boolean z, boolean z2) {
            this.c = 0L;
            this.e = 0;
            this.f = new ArrayDeque();
            this.f15177a = z;
            this.b = z2;
        }
    }
}
