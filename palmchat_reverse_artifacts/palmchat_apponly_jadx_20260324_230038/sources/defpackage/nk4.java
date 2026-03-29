package defpackage;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.media.SquareCameraActivity;
import com.zenmen.media.album.SquareMediaPickAdapter;
import com.zenmen.media.album.SquareMediaPreviewActivity;
import com.zenmen.media.album.pop.PopMediaDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bn2;
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
public class nk4 implements Observer, ng3 {
    public PopMediaDialog A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f19533a;
    public View b;
    public View c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public TextView k;
    public RecyclerView l;
    public SquareMediaPickAdapter m;
    public ArrayList<MediaItem> n = new ArrayList<>();
    public ArrayList<MediaItem> o = new ArrayList<>();
    public LinkedHashMap<String, MediaItem> p = new LinkedHashMap<>();
    public boolean q = false;
    public boolean r = false;
    public Executor s = ww5.b().a();
    public transient int t = 0;
    public boolean u = true;
    public int v = 9;
    public boolean w = true;
    public int x = -1;
    public FrameworkBaseActivity y;
    public View z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<MediaItem> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaItem mediaItem, MediaItem mediaItem2) {
            return Long.compare(mediaItem2.modifyTime, mediaItem.modifyTime);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19535a;
        public final /* synthetic */ MediaItem b;

        public b(int i, MediaItem mediaItem) {
            this.f19535a = i;
            this.b = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f19535a == nk4.this.t) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.b);
                    nk4.this.H(arrayList);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19536a;
        public final /* synthetic */ MediaItem b;

        public c(int i, MediaItem mediaItem) {
            this.f19536a = i;
            this.b = mediaItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f19536a == nk4.this.t) {
                    nk4.this.o.add(this.b);
                    if (!nk4.this.w || nk4.this.v >= 9 || this.b.mimeType == 0) {
                        nk4.this.m.r(this.b);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19537a;

        public d(int i) {
            this.f19537a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f19537a == nk4.this.t) {
                    nk4 nk4Var = nk4.this;
                    nk4Var.r = nk4Var.m.getItemCount() == 0;
                    if (nk4.this.r) {
                        nk4.this.H(new ArrayList());
                    }
                    nk4.this.I();
                    nk4.this.K();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19538a;
        public final /* synthetic */ ArrayList b;

        public e(int i, ArrayList arrayList) {
            this.f19538a = i;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f19538a == nk4.this.t) {
                    nk4.this.H(this.b);
                    nk4.this.s();
                    nk4.this.I();
                    nk4.this.K();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nk4.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nk4.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.c("pagephotochoose_downright_next", "click");
            nk4.this.x(new Intent(), false, 77);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends GridLayoutManager.SpanSizeLookup {
        public i() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends RecyclerView.ItemDecoration {
        public j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition() % 3;
            if (viewLayoutPosition == 0) {
                rect.set(me1.b(nk4.this.t(), 3), 0, me1.b(nk4.this.t(), 1), me1.b(nk4.this.t(), 3));
            } else if (viewLayoutPosition == 1) {
                rect.set(me1.b(nk4.this.t(), 2), 0, me1.b(nk4.this.t(), 2), me1.b(nk4.this.t(), 3));
            } else if (viewLayoutPosition == 2) {
                rect.set(me1.b(nk4.this.t(), 1), 0, me1.b(nk4.this.t(), 3), me1.b(nk4.this.t(), 3));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements SquareMediaPickAdapter.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaItem f19544a;

            public a(MediaItem mediaItem) {
                this.f19544a = mediaItem;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    com.zenmen.palmchat.chat.h.h(nk4.this.t(), i);
                } else {
                    nk4.this.w(this.f19544a);
                }
            }
        }

        public k() {
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public boolean a(MediaItem mediaItem) {
            if (mediaItem == null) {
                return false;
            }
            return nk4.this.p.containsKey(mediaItem.fileFullPath);
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public void b(MediaItem mediaItem, boolean z) {
            nk4.this.B(mediaItem, z);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", z ? 1 : 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagemultipleedit_halfphotochoose_select", "click", jSONObject);
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
                nk4.this.v();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clicktype", 1);
                jSONObject.put("type", mediaItem.mimeType == 1 ? 2 : 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagemultipleedit_halfphotochoose_choice", "click", jSONObject);
            com.zenmen.palmchat.chat.h.c(nk4.this.t(), mediaItem, new a(mediaItem));
        }

        @Override // com.zenmen.media.album.SquareMediaPickAdapter.a
        public boolean e(MediaItem mediaItem) {
            boolean z = mediaItem.mimeType == 1;
            if (nk4.this.p.size() >= nk4.this.v) {
                return false;
            }
            if (z && (!f() || nk4.this.v < 9)) {
                return false;
            }
            if (nk4.this.p.size() != 0) {
                Iterator it = nk4.this.p.entrySet().iterator();
                while (it.hasNext()) {
                    if (((MediaItem) ((Map.Entry) it.next()).getValue()).mimeType == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean f() {
            return nk4.this.p.isEmpty();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrameworkBaseActivity frameworkBaseActivityT = nk4.this.t();
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
            if (tg4.b(frameworkBaseActivityT, permissionType.permissionList)) {
                return;
            }
            BaseActivityPermissionDispatcher.b(nk4.this.t(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_ALBUM_DIALOG);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nk4.this.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yk3 f19547a;

        public n(yk3 yk3Var) {
            this.f19547a = yk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            nk4 nk4Var = nk4.this;
            yk3 yk3Var = this.f19547a;
            nk4Var.B(yk3Var.f22214a, yk3Var.b);
            nk4.this.m.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements Runnable {
        public static String e = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DCIM/Camera";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19548a;
        public WeakReference<ng3> b;
        public ArrayList<MediaItem> c;
        public boolean d;

        public o(int i, ArrayList<MediaItem> arrayList, boolean z, ng3 ng3Var) {
            this.f19548a = i;
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
                if (weakReference2 == null || weakReference2.get() == null || !this.b.get().y0(this.f19548a) || (arrayList = this.c) == null || i < 0 || i >= arrayList.size()) {
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
                                        this.b.get().L0(this.f19548a, (ArrayList) arrayList2.clone());
                                        i3++;
                                    }
                                } else if (this.b.get() != null) {
                                    if (i2 == 0) {
                                        this.b.get().e1(this.f19548a, mediaItem);
                                    } else {
                                        this.b.get().G(this.f19548a, mediaItem);
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
                    this.b.get().C0(this.f19548a);
                }
            } else {
                WeakReference<ng3> weakReference4 = this.b;
                if (weakReference4 != null && weakReference4.get() != null) {
                    this.b.get().L0(this.f19548a, arrayList2);
                }
            }
            LogUtil.d("logmedia", "count = " + i2 + ", totalTime = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    public nk4(FrameworkBaseActivity frameworkBaseActivity, PopMediaDialog popMediaDialog, View view) {
        this.y = frameworkBaseActivity;
        this.z = view;
        this.A = popMediaDialog;
    }

    public void A() {
        synchronized (this) {
            this.t = 0;
        }
        nk3.i().deleteObserver(this);
        ds0.a().d(this);
        zn6.b("pagemultipleedit_halfphotochoose_close");
    }

    public final void B(MediaItem mediaItem, boolean z) {
        if (mediaItem == null) {
            return;
        }
        if (!z) {
            this.p.remove(mediaItem.fileFullPath);
        } else if (this.p.size() < this.v) {
            this.p.put(mediaItem.fileFullPath, mediaItem);
        }
        this.m.notifyDataSetChanged();
        J();
        this.A.r(u());
    }

    public void C(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            K();
        }
    }

    @Override // defpackage.ng3
    public void C0(int i2) {
        t().runOnUiThread(new d(i2));
    }

    public void D(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            K();
            F();
        }
    }

    public void E() {
        K();
        F();
    }

    public final void F() {
        if (!this.q && tg4.b(t(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
            this.q = true;
            nk3.i().l(this);
        }
    }

    @Override // defpackage.ng3
    public void G(int i2, MediaItem mediaItem) {
        t().runOnUiThread(new c(i2, mediaItem));
    }

    public final void H(ArrayList<MediaItem> arrayList) {
        this.o = arrayList;
        if (!this.w || this.v >= 9) {
            ma3.a("updateRecycler show all", new Object[0]);
            this.m.u(this.o, false);
            return;
        }
        ma3.a("updateRecycler is addMode", new Object[0]);
        ArrayList<MediaItem> arrayList2 = new ArrayList<>();
        for (MediaItem mediaItem : this.o) {
            if (mediaItem.mimeType == 0) {
                arrayList2.add(mediaItem);
            }
        }
        this.m.u(arrayList2, false);
    }

    public final void I() {
        SquareMediaPickAdapter squareMediaPickAdapter = this.m;
        if (squareMediaPickAdapter == null) {
            return;
        }
        List<qk3> listF = squareMediaPickAdapter.f();
        LinkedHashMap<String, MediaItem> linkedHashMap = new LinkedHashMap<>();
        for (qk3 qk3Var : listF) {
            MediaItem mediaItem = qk3Var.b;
            if (mediaItem != null && this.p.containsKey(mediaItem.fileFullPath)) {
                MediaItem mediaItem2 = qk3Var.b;
                linkedHashMap.put(mediaItem2.fileFullPath, mediaItem2);
            }
        }
        this.p = linkedHashMap;
    }

    public final void J() {
        this.g.setSelected(true);
        this.g.setEnabled(!this.w);
        int size = this.p.size();
        if (size == 0) {
            this.k.setEnabled(false);
            this.k.setText("下一步");
            this.f.setVisibility(8);
        } else {
            this.k.setEnabled(true);
            this.k.setText(t().getResources().getString(R.string.square_media_pick_next, Integer.valueOf(size)));
            this.f.setVisibility(0);
        }
    }

    public final void K() {
        if (tg4.b(t(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
            this.b.setVisibility(0);
            this.f19533a.setVisibility(8);
            if (this.r) {
                this.c.setVisibility(0);
                this.j.setVisibility(8);
                this.f.setVisibility(8);
            } else {
                this.c.setVisibility(8);
                this.j.setVisibility(0);
                this.f.setVisibility(0);
            }
        } else {
            this.b.setVisibility(4);
            this.f19533a.setVisibility(0);
            this.c.setVisibility(8);
            this.j.setVisibility(8);
            this.f.setVisibility(8);
        }
        J();
    }

    @Override // defpackage.ng3
    public void L0(int i2, ArrayList<MediaItem> arrayList) {
        t().runOnUiThread(new e(i2, arrayList));
    }

    @Override // defpackage.ng3
    public void e1(int i2, MediaItem mediaItem) {
        t().runOnUiThread(new b(i2, mediaItem));
    }

    @qm5
    public void onMediaSelectEvent(yk3 yk3Var) {
        t().runOnUiThread(new n(yk3Var));
    }

    public final void s() {
        boolean z;
        Iterator<MediaItem> it = this.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().mimeType == 0) {
                z = false;
                break;
            }
        }
        this.r = z;
    }

    public FrameworkBaseActivity t() {
        return this.y;
    }

    public final ArrayList<MediaItem> u() {
        return new ArrayList<>(this.p.values());
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean z;
        LogUtil.d("logmedia", "observable update");
        bn2.b bVar = (bn2.b) obj;
        if (bVar.e || bVar.b.f1773a.size() != 0) {
            bn2.a aVar = bVar.b;
            LogUtil.d("logmedia", "update: new = " + aVar.f1773a.size() + ", old = " + this.n.size());
            boolean z2 = true;
            if (aVar.f1773a.size() > 0 && aVar.f1773a.size() == this.n.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= aVar.f1773a.size()) {
                        z = true;
                        break;
                    }
                    if (!TextUtils.equals(aVar.f1773a.get(i2).fileFullPath, this.n.get(i2).fileFullPath)) {
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
                this.t++;
                this.n.clear();
                this.n.addAll(aVar.f1773a);
                if (this.n.size() != 0) {
                    z2 = false;
                }
                this.r = z2;
                if (z2) {
                    H(new ArrayList<>());
                } else {
                    this.s.execute(new o(this.t, this.n, this.u, this));
                    this.u = false;
                }
                K();
            }
            nk3.i().deleteObserver(this);
            nk3.i().addObserver(this);
        }
    }

    public final void v() {
        zn6.b("pagemultipleedit_halfphotochoose_shoot");
        FrameworkBaseActivity frameworkBaseActivityT = t();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CAMERA;
        if (!tg4.b(frameworkBaseActivityT, permissionType.permissionList)) {
            BaseActivityPermissionDispatcher.b(t(), permissionType, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_CAMERA);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from", 77);
        intent.putExtra("extra_only_photo", this.v < 9);
        intent.setClass(t(), SquareCameraActivity.class);
        intent.putExtra("extra_need_feedback", true);
        t().startActivityForResult(intent, 10124);
    }

    public final void w(MediaItem mediaItem) {
        MediaItem mediaItem2;
        Intent intent = new Intent();
        intent.setClass(t(), SquareMediaPreviewActivity.class);
        int i2 = 0;
        boolean z = mediaItem.mimeType == 1;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (!z) {
            arrayList.addAll(this.p.values());
            Collections.sort(arrayList, new a());
        }
        intent.putParcelableArrayListExtra("selectlist", arrayList);
        List<qk3> listF = this.m.f();
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
        intent.putExtra("extra_key_max_num", this.v);
        SquareMediaPreviewActivity.h0 = arrayList2;
        intent.putExtra("first_item", mediaItem);
        intent.putExtra("show_mode", 2);
        intent.putExtra("enter_type", 2);
        t().startActivityForResult(intent, 10023);
    }

    public final void x(Intent intent, boolean z, int i2) {
        ArrayList<MediaItem> arrayList;
        if (this.w) {
            if (this.p.size() < 1 || z) {
                ArrayList<MediaItem> arrayList2 = new ArrayList<>();
                MediaItem mediaItem = (MediaItem) intent.getParcelableExtra("result_media");
                if (mediaItem != null) {
                    arrayList2.add(mediaItem);
                }
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList<>(this.p.values());
            }
            this.A.r(arrayList);
            this.A.dismiss();
        }
    }

    public void y(int i2, int i3, @Nullable Intent intent) {
        if (i2 == 10023 && i3 == -1 && intent != null) {
            x(intent, false, 78);
        } else if (i2 == 10124 && i3 == -1 && intent != null) {
            x(intent, true, 44);
        }
    }

    @Override // defpackage.ng3
    public boolean y0(int i2) {
        synchronized (this) {
            return i2 == this.t;
        }
    }

    public void z() {
        this.b = this.z.findViewById(R.id.head_layout);
        this.f19533a = this.z.findViewById(R.id.no_permission);
        this.j = this.z.findViewById(R.id.list_layout);
        this.c = this.z.findViewById(R.id.empty);
        this.d = (TextView) this.z.findViewById(R.id.action);
        this.e = (TextView) this.z.findViewById(R.id.open_camera);
        this.l = (RecyclerView) this.z.findViewById(R.id.media_grid_view);
        this.f = this.z.findViewById(R.id.media_select);
        this.g = this.z.findViewById(R.id.media_select_icon);
        this.h = this.z.findViewById(R.id.media_select_title);
        this.k = (TextView) this.z.findViewById(R.id.media_select_action);
        View viewFindViewById = this.z.findViewById(R.id.tv_multi_prompt);
        this.i = viewFindViewById;
        if (this.w && this.v < 9) {
            viewFindViewById.setVisibility(8);
        }
        this.g.setOnClickListener(new f());
        this.h.setOnClickListener(new g());
        this.k.setOnClickListener(new h());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(t(), 3);
        gridLayoutManager.setSpanSizeLookup(new i());
        this.l.setLayoutManager(gridLayoutManager);
        this.l.addItemDecoration(new j());
        this.l.setItemAnimator(null);
        this.l.setNestedScrollingEnabled(false);
        SquareMediaPickAdapter squareMediaPickAdapter = new SquareMediaPickAdapter(t(), null);
        this.m = squareMediaPickAdapter;
        this.l.setAdapter(squareMediaPickAdapter);
        this.m.v(new k());
        this.d.setOnClickListener(new l());
        this.e.setOnClickListener(new m());
        K();
        nk3.i().addObserver(this);
        FrameworkBaseActivity frameworkBaseActivityT = t();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD;
        boolean zB = tg4.b(frameworkBaseActivityT, permissionType.permissionList);
        if (zB) {
            D(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_PUBLISH_ALBUM, false);
        }
        HashMap map = new HashMap();
        map.put("status", zB ? "1" : "0");
        zn6.j("pagemultipleedit_halfphotochoose", "view", map);
        ds0.a().c(this);
    }

    public final void r() {
    }
}
