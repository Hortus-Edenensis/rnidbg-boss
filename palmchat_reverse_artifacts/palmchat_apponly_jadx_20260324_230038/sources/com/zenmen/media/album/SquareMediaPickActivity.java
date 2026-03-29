package com.zenmen.media.album;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lantern.auth.android.BLUtils;
import com.zenmen.media.SquareCameraActivity;
import com.zenmen.media.album.SquareMediaPickAdapter;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.activity.SquareMultiPublishActivity;
import defpackage.b05;
import defpackage.bn2;
import defpackage.cj5;
import defpackage.dj5;
import defpackage.ds0;
import defpackage.iv0;
import defpackage.k86;
import defpackage.l50;
import defpackage.lj5;
import defpackage.ma3;
import defpackage.me1;
import defpackage.ms1;
import defpackage.ng3;
import defpackage.nk3;
import defpackage.qk3;
import defpackage.qm5;
import defpackage.tg4;
import defpackage.u92;
import defpackage.vs0;
import defpackage.ww5;
import defpackage.yk3;
import defpackage.zn6;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareMediaPickActivity extends BaseActivityWithoutCheckAccount implements Observer, ng3 {
    public RecyclerView A;
    public SquareMediaPickAdapter B;
    public ArrayList<MediaItem> C = new ArrayList<>();
    public ArrayList<MediaItem> E = new ArrayList<>();
    public LinkedHashMap<String, MediaItem> F = new LinkedHashMap<>();
    public boolean G = false;
    public boolean H = false;
    public Executor I = ww5.b().a();
    public transient int J = 0;
    public boolean K = true;
    public int L = 9;
    public boolean M = false;
    public int N = -1;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public View w;
    public View x;
    public View y;
    public TextView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yk3 f11906a;

        public a(yk3 yk3Var) {
            this.f11906a = yk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareMediaPickActivity squareMediaPickActivity = SquareMediaPickActivity.this;
            yk3 yk3Var = this.f11906a;
            squareMediaPickActivity.X1(yk3Var.f22214a, yk3Var.b);
            SquareMediaPickActivity.this.B.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<MediaItem> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return Long.compare(mediaItem2.modifyTime, mediaItem.modifyTime);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11908a;
        public final /* synthetic */ MediaItem b;

        public c(int i, MediaItem mediaItem) {
            this.f11908a = i;
            this.b = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f11908a == SquareMediaPickActivity.this.J) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.b);
                    SquareMediaPickActivity.this.Z1(arrayList);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11909a;
        public final /* synthetic */ MediaItem b;

        public d(int i, MediaItem mediaItem) {
            this.f11909a = i;
            this.b = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f11909a == SquareMediaPickActivity.this.J) {
                    SquareMediaPickActivity.this.E.add(this.b);
                    if (!SquareMediaPickActivity.this.M || SquareMediaPickActivity.this.L >= 9 || this.b.mimeType == 0) {
                        SquareMediaPickActivity.this.B.r(this.b);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11910a;

        public e(int i) {
            this.f11910a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f11910a == SquareMediaPickActivity.this.J) {
                    SquareMediaPickActivity squareMediaPickActivity = SquareMediaPickActivity.this;
                    squareMediaPickActivity.H = squareMediaPickActivity.B.getItemCount() == 0;
                    if (SquareMediaPickActivity.this.H) {
                        SquareMediaPickActivity.this.Z1(new ArrayList());
                    }
                    SquareMediaPickActivity.this.a2();
                    SquareMediaPickActivity.this.c2();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11911a;
        public final /* synthetic */ ArrayList b;

        public f(int i, ArrayList arrayList) {
            this.f11911a = i;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f11911a == SquareMediaPickActivity.this.J) {
                    SquareMediaPickActivity.this.Z1(this.b);
                    SquareMediaPickActivity.this.S1();
                    SquareMediaPickActivity.this.a2();
                    SquareMediaPickActivity.this.c2();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPickActivity.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPickActivity.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.c("pagephotochoose_downright_next", "click");
            SquareMediaPickActivity.this.W1(new Intent(), false, 77);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends GridLayoutManager.SpanSizeLookup {
        public j() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return i == 0 ? 3 : 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends RecyclerView.ItemDecoration {
        public k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            if (viewLayoutPosition == 0) {
                rect.set(0, 0, 0, 0);
                return;
            }
            int i = (viewLayoutPosition - 1) % 3;
            if (i == 0) {
                rect.set(me1.b(SquareMediaPickActivity.this.T1(), 3), 0, me1.b(SquareMediaPickActivity.this.T1(), 1), me1.b(SquareMediaPickActivity.this.T1(), 3));
            } else if (i == 1) {
                rect.set(me1.b(SquareMediaPickActivity.this.T1(), 2), 0, me1.b(SquareMediaPickActivity.this.T1(), 2), me1.b(SquareMediaPickActivity.this.T1(), 3));
            } else if (i == 2) {
                rect.set(me1.b(SquareMediaPickActivity.this.T1(), 1), 0, me1.b(SquareMediaPickActivity.this.T1(), 3), me1.b(SquareMediaPickActivity.this.T1(), 3));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements SquareMediaPickAdapter.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaItem f11917a;

            public a(MediaItem mediaItem) {
                this.f11917a = mediaItem;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    com.zenmen.palmchat.chat.h.h(SquareMediaPickActivity.this, i);
                } else {
                    SquareMediaPickActivity.this.V1(this.f11917a);
                }
            }
        }

        public l() {
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public boolean a(MediaItem mediaItem) {
            if (mediaItem == null) {
                return false;
            }
            return SquareMediaPickActivity.this.F.containsKey(mediaItem.fileFullPath);
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public void b(MediaItem mediaItem, boolean z) {
            SquareMediaPickActivity.this.X1(mediaItem, z);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clicktype", z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagephotochoose_select", "click", jSONObject);
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public void c(MediaItem mediaItem) {
            cj5.c().b(mediaItem, false);
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public void d(MediaItem mediaItem, View view) {
            if (l50.a()) {
                return;
            }
            if (mediaItem.mimeType == 10086) {
                SquareMediaPickActivity.this.U1();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clicktype", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagephotochoose_choice", "click", jSONObject);
            com.zenmen.palmchat.chat.h.c(SquareMediaPickActivity.this, mediaItem, new a(mediaItem));
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public boolean e(MediaItem mediaItem) {
            boolean z = mediaItem.mimeType == 1;
            if (SquareMediaPickActivity.this.F.size() >= SquareMediaPickActivity.this.L) {
                return false;
            }
            if (z && (!f() || SquareMediaPickActivity.this.L < 9)) {
                return false;
            }
            if (SquareMediaPickActivity.this.F.size() != 0) {
                Iterator it = SquareMediaPickActivity.this.F.entrySet().iterator();
                while (it.hasNext()) {
                    if (((MediaItem) ((Map.Entry) it.next()).getValue()).mimeType == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean f() {
            return SquareMediaPickActivity.this.F.isEmpty();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (tg4.b(SquareMediaPickActivity.this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
                SquareMediaPickActivity.this.finish();
                return;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", SquareMediaPickActivity.this.getPackageName(), null));
            SquareMediaPickActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMediaPickActivity.this.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("pagephotochoose_top_back", "click");
            SquareMediaPickActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p implements Runnable {
        public static String e = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DCIM/Camera";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11921a;
        public WeakReference<ng3> b;
        public ArrayList<MediaItem> c;
        public boolean d;

        public p(int i, ArrayList<MediaItem> arrayList, boolean z, ng3 ng3Var) {
            this.f11921a = i;
            ArrayList<MediaItem> arrayList2 = new ArrayList<>();
            this.c = arrayList2;
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            this.d = z;
            this.b = new WeakReference<>(ng3Var);
            JSONObject config = vs0.a().getConfig("albumscreen");
            if (config != null) {
                LogUtil.json("logmedia", config.toString(), "DHIDConfig: albumscreen");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<MediaItem> arrayList;
            WeakReference<ng3> weakReference;
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList<MediaItem> arrayList2 = new ArrayList<>();
            int i = 0;
            int i2 = 0;
            int i3 = 1;
            while (true) {
                WeakReference<ng3> weakReference2 = this.b;
                if (weakReference2 == null || weakReference2.get() == null || !this.b.get().y0(this.f11921a) || (arrayList = this.c) == null || i < 0 || i >= arrayList.size()) {
                    break;
                }
                MediaItem mediaItem = this.c.get(i);
                i++;
                if (!TextUtils.isEmpty(mediaItem.fileFullPath) && (mediaItem.mimeType != 0 || !u92.b(mediaItem.fileFullPath))) {
                    if (dj5.c() == 1) {
                        if (!e.equals(new File(mediaItem.fileFullPath).getParent())) {
                        }
                    }
                    int i4 = mediaItem.mimeType;
                    MediaItem.ExtractInfo extractInfoA = i4 == 0 ? ms1.a(mediaItem.fileFullPath) : i4 == 1 ? ms1.b(mediaItem.fileFullPath) : null;
                    if ((extractInfoA != null && extractInfoA.time > 0) || dj5.e() != 1) {
                        if ((extractInfoA != null && !TextUtils.isEmpty(extractInfoA.deviceModel)) || dj5.b() != 1) {
                            if ((extractInfoA != null && k86.K(extractInfoA.lat, extractInfoA.lng)) || dj5.d() != 1) {
                                mediaItem.extractInfo = extractInfoA;
                                if (!this.d) {
                                    arrayList2.add(mediaItem);
                                    if (arrayList2.size() >= 100 * i3 && (weakReference = this.b) != null && weakReference.get() != null) {
                                        this.b.get().L0(this.f11921a, (ArrayList) arrayList2.clone());
                                        i3++;
                                    }
                                } else if (this.b.get() != null) {
                                    if (i2 == 0) {
                                        this.b.get().e1(this.f11921a, mediaItem);
                                    } else {
                                        this.b.get().G(this.f11921a, mediaItem);
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
            if (this.d) {
                WeakReference<ng3> weakReference3 = this.b;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.b.get().C0(this.f11921a);
                }
            } else {
                WeakReference<ng3> weakReference4 = this.b;
                if (weakReference4 != null && weakReference4.get() != null) {
                    this.b.get().L0(this.f11921a, arrayList2);
                }
            }
            LogUtil.d("logmedia", "count = " + i2 + ", totalTime = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    @Override // defpackage.ng3
    public void C0(int i2) {
        runOnUiThread(new e(i2));
    }

    @Override // defpackage.ng3
    public void G(int i2, MediaItem mediaItem) {
        runOnUiThread(new d(i2, mediaItem));
    }

    @Override // defpackage.ng3
    public void L0(int i2, ArrayList<MediaItem> arrayList) {
        runOnUiThread(new f(i2, arrayList));
    }

    public final void S1() {
        boolean z;
        Iterator<MediaItem> it = this.E.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().mimeType == 0) {
                z = false;
                break;
            }
        }
        this.H = z;
    }

    public final void U1() {
        Intent intent = getIntent();
        Intent intent2 = intent == null ? new Intent() : new Intent(intent);
        intent2.putExtra("key_from", 77);
        intent2.putExtra("extra_only_photo", this.L < 9);
        intent2.setClass(this, SquareCameraActivity.class);
        intent2.putExtra("extra_need_feedback", true);
        startActivityForResult(intent2, 101);
    }

    public final void V1(MediaItem mediaItem) {
        MediaItem mediaItem2;
        Intent intent = new Intent();
        intent.setClass(this, SquareMediaPreviewActivity.class);
        int i2 = 0;
        boolean z = mediaItem.mimeType == 1;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (!z) {
            arrayList.addAll(this.F.values());
            Collections.sort(arrayList, new b());
        }
        intent.putParcelableArrayListExtra("selectlist", arrayList);
        List<qk3> listF = this.B.f();
        ArrayList<MediaItem> arrayList2 = new ArrayList<>();
        int i3 = 0;
        for (qk3 qk3Var : listF) {
            if (qk3Var != null && (mediaItem2 = qk3Var.b) != null && mediaItem2.mimeType == mediaItem.mimeType) {
                arrayList2.add(mediaItem2);
                if (qk3Var.b.fileFullPath.equals(mediaItem.fileFullPath)) {
                    i2 = i3;
                }
                i3++;
            }
        }
        intent.putExtra("firset_item_path", mediaItem.fileFullPath);
        intent.putExtra("total_size", arrayList2.size());
        intent.putExtra("selectIndex", i2);
        intent.putExtra("multi_select", !z);
        intent.putExtra("extra_key_max_num", this.L);
        SquareMediaPreviewActivity.h0 = arrayList2;
        intent.putExtra("first_item", mediaItem);
        intent.putExtra("show_mode", 2);
        intent.putExtra("enter_type", 2);
        startActivityForResult(intent, 100);
    }

    public final void W1(Intent intent, boolean z, int i2) {
        MediaItem mediaItem;
        ArrayList<? extends Parcelable> arrayList;
        if (this.M) {
            Intent intent2 = getIntent();
            if (intent2 == null) {
                intent2 = new Intent();
            }
            if (this.F.size() < 1 || z) {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                MediaItem mediaItem2 = (MediaItem) intent.getParcelableExtra("result_media");
                if (mediaItem2 != null) {
                    arrayList2.add(mediaItem2);
                }
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList<>(this.F.values());
            }
            intent2.putParcelableArrayListExtra("select_picture", arrayList);
            setResult(-1, intent2);
            finish();
            return;
        }
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        if (this.F.size() > 0 && !z) {
            arrayList3.addAll(this.F.values());
        }
        if (arrayList3.isEmpty() && (mediaItem = (MediaItem) intent.getParcelableExtra("result_media")) != null) {
            arrayList3.add(mediaItem);
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        Intent intent3 = getIntent();
        Intent intent4 = intent3 == null ? new Intent() : new Intent(intent3);
        intent4.putExtra("key_from", i2);
        if (arrayList3.size() == 1 && ((MediaItem) arrayList3.get(0)).mimeType == 1) {
            intent4.putExtra("key_publish_video", arrayList3.get(0));
            intent4.putExtra("key_media_type", 3);
        } else {
            intent4.putParcelableArrayListExtra("key_publish_pictures", arrayList3);
            intent4.putExtra("key_media_type", 2);
        }
        intent4.putExtra("key_publish_time", iv0.a(System.currentTimeMillis(), "yyyy·MM·dd HH:mm"));
        intent4.putExtra("clear_media", false);
        intent4.putExtra("key_media_source", 2);
        intent4.putExtra("key_init_text", getIntent().getStringExtra("key_init_text"));
        intent4.setClass(this, SquareMultiPublishActivity.class);
        startActivity(intent4);
        finish();
    }

    public final void X1(MediaItem mediaItem, boolean z) {
        if (mediaItem == null) {
            return;
        }
        if (!z) {
            this.F.remove(mediaItem.fileFullPath);
        } else if (this.F.size() < this.L) {
            this.F.put(mediaItem.fileFullPath, mediaItem);
        }
        d2();
        b2();
    }

    public final void Y1() {
        if (!this.G && tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
            this.G = true;
            nk3.i().l(this);
        }
    }

    public final void Z1(ArrayList<MediaItem> arrayList) {
        this.E = arrayList;
        if (!this.M || this.L >= 9) {
            ma3.a("updateRecycler show all", new Object[0]);
            this.B.t(this.E);
            return;
        }
        ma3.a("updateRecycler is addMode", new Object[0]);
        ArrayList<MediaItem> arrayList2 = new ArrayList<>();
        for (MediaItem mediaItem : this.E) {
            if (mediaItem.mimeType == 0) {
                arrayList2.add(mediaItem);
            }
        }
        this.B.t(arrayList2);
    }

    public final void a2() {
        SquareMediaPickAdapter squareMediaPickAdapter = this.B;
        if (squareMediaPickAdapter == null) {
            return;
        }
        List<qk3> listF = squareMediaPickAdapter.f();
        LinkedHashMap<String, MediaItem> linkedHashMap = new LinkedHashMap<>();
        for (qk3 qk3Var : listF) {
            MediaItem mediaItem = qk3Var.b;
            if (mediaItem != null && this.F.containsKey(mediaItem.fileFullPath)) {
                MediaItem mediaItem2 = qk3Var.b;
                linkedHashMap.put(mediaItem2.fileFullPath, mediaItem2);
            }
        }
        this.F = linkedHashMap;
    }

    public final void b2() {
        this.w.setSelected(true);
        this.w.setEnabled(!this.M);
        this.z.setVisibility(0);
        int size = this.F.size();
        if (size == 0) {
            this.z.setEnabled(false);
            this.z.setText("下一步");
        } else {
            this.z.setEnabled(true);
            this.z.setText(T1().getResources().getString(R.string.square_media_pick_next, Integer.valueOf(size)));
        }
    }

    public final void c2() {
        if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
            this.q.setVisibility(8);
            if (this.H) {
                this.r.setVisibility(0);
                this.A.setVisibility(0);
                this.v.setVisibility(8);
                this.t.setVisibility(0);
                this.s.setText("你的相册中无可用内容");
                this.t.setText("返回拍摄界面");
                this.u.setVisibility(8);
            } else {
                this.r.setVisibility(8);
                this.A.setVisibility(0);
                this.v.setVisibility(0);
                this.t.setVisibility(8);
                this.u.setVisibility(8);
            }
        } else {
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.A.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setVisibility(0);
            this.t.setVisibility(0);
            this.t.setText("前往系统设置");
        }
        b2();
    }

    public final void d2() {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.A.getLayoutManager();
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.A.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition);
            if (viewHolderFindViewHolderForLayoutPosition instanceof BaseRecyclerViewHolder) {
                this.B.onBindViewHolder((BaseRecyclerViewHolder) viewHolderFindViewHolderForLayoutPosition, iFindFirstVisibleItemPosition);
            }
            for (RecyclerView.ViewHolder viewHolder : (ArrayList) BLUtils.invokePrivateValue((RecyclerView.Recycler) BLUtils.invokePrivateValue(this.A, "mRecycler"), "mCachedViews")) {
                if (viewHolder instanceof SquareMediaPickViewHolder) {
                    ((SquareMediaPickViewHolder) viewHolder).v();
                }
            }
        }
    }

    @Override // defpackage.ng3
    public void e1(int i2, MediaItem mediaItem) {
        runOnUiThread(new c(i2, mediaItem));
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) getToolbar().findViewById(R.id.title)).setText("我的回忆");
        toolbarInitToolbar.findViewById(R.id.action_button).setVisibility(8);
        toolbarInitToolbar.setNavigationOnClickListener(new o());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1 && intent != null) {
            W1(intent, false, 78);
        } else if (i2 == 101 && i3 == -1 && intent != null) {
            W1(intent, true, 44);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        zn6.c("pagephotochoose_top_back", "click");
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LogUtil.i("SquareMediaPickActivity", "onCreate");
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_square_media_pick);
        if (getIntent() != null) {
            Intent intent = getIntent();
            this.N = intent.getIntExtra("key_from", -1);
            boolean zEquals = "from_square_add".equals(intent.getStringExtra("from"));
            this.M = zEquals;
            if (zEquals) {
                this.L = 9 - intent.getIntExtra("key_photo_num", 0);
            }
        }
        initActionBar();
        b05.d("from=====>" + this.N);
        lj5.c().f19012a = this.N;
        this.q = findViewById(R.id.no_permission);
        this.r = findViewById(R.id.empty);
        this.s = (TextView) findViewById(R.id.empty_title);
        this.t = (TextView) findViewById(R.id.action);
        this.u = (TextView) findViewById(R.id.open_camera);
        this.A = (RecyclerView) findViewById(R.id.media_grid_view);
        this.v = findViewById(R.id.media_select);
        this.w = findViewById(R.id.media_select_icon);
        this.x = findViewById(R.id.media_select_title);
        this.z = (TextView) findViewById(R.id.media_select_action);
        View viewFindViewById = findViewById(R.id.tv_multi_prompt);
        this.y = viewFindViewById;
        if (this.M && this.L < 9) {
            viewFindViewById.setVisibility(8);
        }
        this.w.setOnClickListener(new g());
        this.x.setOnClickListener(new h());
        this.z.setOnClickListener(new i());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new j());
        this.A.setLayoutManager(gridLayoutManager);
        this.A.addItemDecoration(new k());
        this.A.setItemAnimator(null);
        this.A.setNestedScrollingEnabled(false);
        SquareMediaPickAdapter squareMediaPickAdapter = new SquareMediaPickAdapter(this, null);
        this.B = squareMediaPickAdapter;
        this.A.setAdapter(squareMediaPickAdapter);
        this.B.v(new l());
        this.t.setOnClickListener(new m());
        this.u.setOnClickListener(new n());
        c2();
        nk3.i().addObserver(this);
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_ALBUM);
        HashMap map = new HashMap();
        int i2 = this.N;
        if (i2 > -1) {
            map.put("from", Integer.valueOf(i2));
        }
        zn6.j("pagephotochoose", "view", map);
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        synchronized (this) {
            this.J = 0;
        }
        nk3.i().deleteObserver(this);
        ds0.a().d(this);
    }

    @qm5
    public void onMediaSelectEvent(yk3 yk3Var) {
        runOnUiThread(new a(yk3Var));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            c2();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            c2();
            Y1();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c2();
        Y1();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean z;
        LogUtil.d("logmedia", "observable update");
        bn2.b bVar = (bn2.b) obj;
        if (bVar.e || bVar.b.f1773a.size() != 0) {
            bn2.a aVar = bVar.b;
            LogUtil.d("logmedia", "update: new = " + aVar.f1773a.size() + ", old = " + this.C.size());
            boolean z2 = true;
            if (aVar.f1773a.size() > 0 && aVar.f1773a.size() == this.C.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= aVar.f1773a.size()) {
                        z = true;
                        break;
                    }
                    if (!TextUtils.equals(aVar.f1773a.get(i2).fileFullPath, this.C.get(i2).fileFullPath)) {
                        LogUtil.d("logmedia", "update: diff = " + aVar.f1773a.get(i2).fileFullPath);
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return;
                }
            }
            synchronized (this) {
                this.J++;
                this.C.clear();
                this.C.addAll(aVar.f1773a);
                if (this.C.size() != 0) {
                    z2 = false;
                }
                this.H = z2;
                if (z2) {
                    Z1(new ArrayList<>());
                } else {
                    this.I.execute(new p(this.J, this.C, this.K, this));
                    this.K = false;
                }
                c2();
            }
            nk3.i().deleteObserver(this);
            nk3.i().addObserver(this);
        }
    }

    @Override // defpackage.ng3
    public boolean y0(int i2) {
        synchronized (this) {
            return i2 == this.J;
        }
    }

    public final void R1() {
    }

    public Context T1() {
        return this;
    }
}
