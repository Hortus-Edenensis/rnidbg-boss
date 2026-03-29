package com.zenmen.palmchat.settings.portrait;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.location.LocationViewActivityV2;
import com.zenmen.palmchat.settings.portrait.PortraitAlbumAdapter;
import com.zenmen.palmchat.ui.widget.draggridview.DragGridView;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.ez2;
import defpackage.hx3;
import defpackage.iq5;
import defpackage.k86;
import defpackage.l50;
import defpackage.m66;
import defpackage.qk4;
import defpackage.qp4;
import defpackage.r66;
import defpackage.sd3;
import defpackage.sk4;
import defpackage.sy5;
import defpackage.v4;
import defpackage.zn6;
import defpackage.zo4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PortraitAlbumActivity extends FrameworkBaseActivity {
    public static final String H = "PortraitAlbumActivity";
    public DragGridView q;
    public PortraitAlbumAdapter r;
    public TextView s;
    public View t;
    public PortraitAlbumAdapter.Item u;
    public LocationViewActivityV2.k v;
    public View w;
    public TextView x;
    public View y;
    public boolean z = true;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public int E = 0;
    public sk4 F = new sk4();
    public PortraitAlbumAdapter.b G = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitAlbumActivity.this.b2();
            PortraitAlbumActivity.this.v.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
                materialDialog.dismiss();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                PortraitAlbumActivity portraitAlbumActivity = PortraitAlbumActivity.this;
                portraitAlbumActivity.c2(portraitAlbumActivity.u);
                materialDialog.dismiss();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sd3 sd3Var = new sd3(PortraitAlbumActivity.this);
            sd3Var.k("确定要删除吗？").n(GravityEnum.CENTER).P("删除").M(Color.parseColor("#ff463c")).L("取消").I(Color.parseColor("#cccccc")).h(false).f(new a());
            sd3Var.e().show();
            PortraitAlbumActivity.this.v.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements PortraitAlbumAdapter.b {
        public c() {
        }

        @Override // com.zenmen.palmchat.settings.portrait.PortraitAlbumAdapter.b
        public void onSelect(int i) {
            PortraitAlbumActivity.this.B = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.dismiss();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            PortraitAlbumActivity.this.Z1();
            materialDialog.dismiss();
            zn6.c("headalbum_quitsure", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PortraitAlbumActivity.this.showBaseProgressBar();
            List<PortraitAlbumAdapter.Item> listC = PortraitAlbumActivity.this.r.c();
            ArrayList arrayList = new ArrayList();
            for (PortraitAlbumAdapter.Item item : listC) {
                if (item.portrait == null && item.mediaItem != null) {
                    arrayList.add(item);
                }
            }
            if (arrayList.size() > 0) {
                PortraitAlbumActivity.this.n2(arrayList);
            } else {
                PortraitAlbumActivity.this.l2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<JSONObject> {
        public f() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            PortraitAlbumActivity.this.hideBaseProgressBar();
            if (jSONObject != null) {
                LogUtil.json("logportrait", jSONObject, "/userem.avatar.set.v2");
                try {
                    int i = jSONObject.getInt("resultCode");
                    if (i == 0) {
                        ds0.a().b(new r66());
                        iq5.j(false, new String[0]);
                        boolean unused = PortraitAlbumActivity.this.z;
                        PortraitAlbumActivity.this.B = false;
                        ez2.a("已提交修改");
                        PortraitAlbumActivity.this.Z1();
                        return;
                    }
                    if (i == 1137 || i == 1138) {
                        PortraitAlbumActivity.this.F.h(jSONObject);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ez2.b("提交失败，请稍后再试");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.ErrorListener {
        public g() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PortraitAlbumActivity.this.hideBaseProgressBar();
            ez2.b("提交失败，请稍后再试");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("from", Integer.valueOf(PortraitAlbumActivity.this.E));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {
        public j() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.json("logportrait", jSONObject.toString(), "getPortraits");
            PortraitAlbumActivity.this.y.setVisibility(8);
            PortraitAlbumActivity.this.w.setVisibility(0);
            try {
                ArrayList arrayList = new ArrayList();
                ContactInfoItem contactInfoItemA = dn0.a(v4.e(PortraitAlbumActivity.this));
                if (contactInfoItemA != null && contactInfoItemA.hasPortrait()) {
                    PortraitAlbumAdapter.Item item = new PortraitAlbumAdapter.Item();
                    item.selected = true;
                    ContactInfoItem.Portrait portrait = new ContactInfoItem.Portrait();
                    item.portrait = portrait;
                    portrait.headImg = contactInfoItemA.getBigIconURL();
                    item.portrait.headIcon = contactInfoItemA.getIconURL();
                    arrayList.add(item);
                    LogUtil.d("logportrait", "portrait: headImg = " + item.portrait.headImg);
                    LogUtil.d("logportrait", "portrait: headIcon = " + item.portrait.headIcon);
                }
                List<ContactInfoItem.Portrait> listO = qk4.o(jSONObject);
                if (listO != null) {
                    for (int i = 0; i < listO.size() && i < 6; i++) {
                        PortraitAlbumAdapter.Item item2 = new PortraitAlbumAdapter.Item();
                        item2.selected = false;
                        item2.portrait = listO.get(i);
                        arrayList.add(item2);
                    }
                }
                PortraitAlbumActivity.this.i2(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PortraitAlbumActivity.this.y.setVisibility(8);
            PortraitAlbumActivity.this.x.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitAlbumActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements AdapterView.OnItemClickListener {
        public m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PortraitAlbumAdapter.Item item;
            if (l50.a() || adapterView == null || adapterView.getAdapter() == null || (item = (PortraitAlbumAdapter.Item) adapterView.getAdapter().getItem(i)) == null) {
                return;
            }
            if (item.isAdd) {
                PortraitAlbumActivity.this.u = null;
                PortraitAlbumActivity.this.b2();
            } else {
                PortraitAlbumActivity.this.u = item;
                PortraitAlbumActivity.this.h2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements DragGridView.f {
        public n() {
        }

        @Override // com.zenmen.palmchat.ui.widget.draggridview.DragGridView.f
        public void e0() {
            PortraitAlbumActivity.this.B = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitAlbumActivity.this.z = !r3.z;
            if (PortraitAlbumActivity.this.z) {
                PortraitAlbumActivity.this.s.setCompoundDrawablesWithIntrinsicBounds(R.drawable.portrait_album_share_selected, 0, 0, 0);
            } else {
                PortraitAlbumActivity.this.s.setCompoundDrawablesWithIntrinsicBounds(R.drawable.portrait_album_share_unselected, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("result", Integer.valueOf(PortraitAlbumActivity.this.B ? 1 : 2));
            }
        }

        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || PortraitAlbumActivity.this.isFinishing()) {
                return;
            }
            if (!hx3.m(PortraitAlbumActivity.this)) {
                sy5.e(PortraitAlbumActivity.this, R.string.square_network_error, 0).g();
                return;
            }
            zn6.j("headalbum_save", "click", new a());
            if (PortraitAlbumActivity.this.a2()) {
                PortraitAlbumActivity.this.k2();
            } else {
                PortraitAlbumActivity.this.j2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitAlbumActivity.this.e2();
        }
    }

    public static void f2(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) PortraitAlbumActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final void Z1() {
        if (this.C) {
            Intent intent = new Intent(this, (Class<?>) m66.c());
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(v4.e(this));
            intent.putExtra("user_item_info", contactInfoItem);
            intent.putExtra("from", 70);
            startActivity(intent);
        }
        finish();
    }

    public final boolean a2() {
        Iterator<PortraitAlbumAdapter.Item> it = this.r.c().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().selected) {
                i2++;
            }
        }
        return i2 > 0;
    }

    public final void b2() {
        Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 1);
        intent.putExtra("from", "from_person_info");
        startActivityForResult(intent, 1);
    }

    public final void c2(PortraitAlbumAdapter.Item item) {
        this.r.c().remove(item);
        PortraitAlbumAdapter portraitAlbumAdapter = new PortraitAlbumAdapter(this, this.r.c());
        this.r = portraitAlbumAdapter;
        portraitAlbumAdapter.f(this.G);
        this.q.setAdapter((ListAdapter) this.r);
        m2();
        this.B = true;
    }

    public void d2() {
        this.F.d(this);
        DragGridView dragGridView = (DragGridView) findViewById(R.id.gridview);
        this.q = dragGridView;
        dragGridView.setOnItemClickListener(new m());
        PortraitAlbumAdapter portraitAlbumAdapter = new PortraitAlbumAdapter(this, null);
        this.r = portraitAlbumAdapter;
        portraitAlbumAdapter.f(this.G);
        this.q.setDrag(true);
        this.q.setImgMoveListener(new n());
        this.q.setAdapter((ListAdapter) this.r);
        TextView textView = (TextView) findViewById(R.id.share);
        this.s = textView;
        textView.setOnClickListener(new o());
        View viewFindViewById = findViewById(R.id.submit);
        this.t = viewFindViewById;
        viewFindViewById.setOnClickListener(new p());
        m2();
        this.w = findViewById(R.id.content);
        this.x = (TextView) findViewById(R.id.error);
        this.y = findViewById(R.id.loading);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#04b4a2")), 5, 9, 18);
        this.x.setText(spannableStringBuilder);
        this.x.setOnClickListener(new q());
        this.y.setVisibility(8);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
    }

    public final void e2() {
        try {
            this.y.setVisibility(0);
            this.w.setVisibility(8);
            this.x.setVisibility(8);
            new qk4(new j(), new k()).n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void g2() {
        sd3 sd3Var = new sd3(this);
        sd3Var.k("未保存的内容将会丢失，是否退出？").n(GravityEnum.CENTER).P("确定").M(Color.parseColor("#00c85a")).L("取消").I(Color.parseColor("#cccccc")).h(false).f(new d());
        sd3Var.e().show();
        zn6.c("headalbum_quit", "view");
    }

    public final void h2() {
        LocationViewActivityV2.k.b bVar = new LocationViewActivityV2.k.b(this);
        bVar.a("更换照片", Color.parseColor("#222222"), new a());
        if (this.r.getCount() > 2) {
            bVar.a("删除照片", Color.parseColor("#ff463c"), new b());
        }
        bVar.d("取消");
        LocationViewActivityV2.k kVarC = bVar.c();
        this.v = kVarC;
        kVarC.show();
    }

    public final void i2(List<PortraitAlbumAdapter.Item> list) {
        PortraitAlbumAdapter portraitAlbumAdapter = new PortraitAlbumAdapter(this, list);
        this.r = portraitAlbumAdapter;
        portraitAlbumAdapter.f(this.G);
        this.q.setAdapter((ListAdapter) this.r);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(R.id.toolbar, "", true);
        toolbarInitToolbar.setNavigationIcon(R.drawable.selector_arrow_back);
        toolbarInitToolbar.setNavigationOnClickListener(new l());
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("头像相册");
    }

    public void j2() {
        new sd3(this).k("需要设置1张图片为头像").n(GravityEnum.CENTER).P("我知道了").h(true).e().show();
        zn6.c("headalbum_alert", "view");
    }

    public final void k2() {
        if (this.B) {
            this.F.g(true, new e());
        } else {
            ez2.a("已提交修改");
            Z1();
        }
    }

    public final void l2() {
        List<PortraitAlbumAdapter.Item> listC = this.r.c();
        ArrayList arrayList = new ArrayList();
        for (PortraitAlbumAdapter.Item item : listC) {
            ContactInfoItem.Portrait portrait = item.portrait;
            if (portrait != null) {
                if (item.selected) {
                    arrayList.add(0, portrait);
                } else {
                    arrayList.add(portrait);
                }
            }
        }
        try {
            new qk4(new f(), new g()).p(arrayList, this.z ? 1 : 0, 0);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void n2(List<PortraitAlbumAdapter.Item> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<PortraitAlbumAdapter.Item> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mediaItem.fileFullPath);
        }
        zo4.e(arrayList, true, 0, new h(list), 7);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                List<PortraitAlbumAdapter.Item> listC = this.r.c();
                MediaItem mediaItem = new MediaItem();
                mediaItem.fileFullPath = stringExtra;
                PortraitAlbumAdapter.Item item = new PortraitAlbumAdapter.Item();
                item.mediaItem = mediaItem;
                listC.add(item);
                PortraitAlbumAdapter portraitAlbumAdapter = new PortraitAlbumAdapter(this, listC);
                this.r = portraitAlbumAdapter;
                portraitAlbumAdapter.f(this.G);
                this.q.setAdapter((ListAdapter) this.r);
                PortraitAlbumAdapter.Item item2 = this.u;
                if (item2 != null) {
                    c2(item2);
                }
                if (this.r.getCount() <= 2) {
                    this.r.e(0);
                }
            }
            m2();
            this.B = true;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.B) {
            g2();
        } else {
            Z1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        setContentView(R.layout.layout_activity_portrait_album);
        this.C = getIntent().getIntExtra("backUserDetail", 0) == 1;
        this.E = getIntent().getIntExtra("from", 0);
        initActionBar();
        d2();
        e2();
        zn6.j("headalbum_show", "view", new i());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            ds0.a().d(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void m2() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements qp4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f15308a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitAlbumActivity.this.hideBaseProgressBar();
                ez2.b("");
            }
        }

        public h(List list) {
            this.f15308a = list;
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.d(PortraitAlbumActivity.H, "uploadImage fail!!");
            PortraitAlbumActivity.this.runOnUiThread(new a());
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            LogUtil.d(PortraitAlbumActivity.H, "uploadImage success!!");
            for (int i = 0; i < arrayList.size(); i++) {
                ((PortraitAlbumAdapter.Item) this.f15308a.get(i)).portrait = new ContactInfoItem.Portrait();
                ((PortraitAlbumAdapter.Item) this.f15308a.get(i)).portrait.headIcon = arrayList.get(i).thumbUrl;
                ((PortraitAlbumAdapter.Item) this.f15308a.get(i)).portrait.headImg = arrayList.get(i).url;
            }
            PortraitAlbumActivity.this.l2();
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
            LogUtil.d(PortraitAlbumActivity.H, "onItemSuccess：");
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
        }
    }
}
