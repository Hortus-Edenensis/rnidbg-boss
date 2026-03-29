package com.zenmen.square.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.ui.widget.draggridview.DragGridView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.a46;
import defpackage.ap3;
import defpackage.ei4;
import defpackage.l50;
import defpackage.os3;
import defpackage.tk3;
import defpackage.tn;
import defpackage.xk3;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareMultiPublishActivity extends SquareBasePublishActivity {
    public static final String r0 = "SquareMultiPublishActivity";
    public View l0;
    public DragGridView m0;
    public int n0;
    public os3 o0;
    public xk3 p0 = null;
    public os3.d q0 = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements xk3.a {
        public a() {
        }

        @Override // xk3.a
        public void a(ArrayList<MediaItem> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null && arrayList.size() > 0) {
                for (MediaItem mediaItem : arrayList) {
                    String str = mediaItem.editedImagePath;
                    if (str != null) {
                        mediaItem.fileFullPath = str;
                    }
                }
                if (!arrayList.isEmpty()) {
                    arrayList2.addAll(arrayList);
                }
            }
            SquareMultiPublishActivity.this.x.clear();
            SquareMultiPublishActivity.this.x.addAll(arrayList2);
            SquareMultiPublishActivity.this.L2();
            SquareMultiPublishActivity.this.D2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("pagemultipleedit_upleft_back", "click");
            SquareMultiPublishActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MediaItem mediaItem;
            if (l50.a() || adapterView == null || adapterView.getAdapter() == null || (mediaItem = (MediaItem) adapterView.getAdapter().getItem(i)) == null) {
                return;
            }
            if (mediaItem.mimeType == 10) {
                SquareMultiPublishActivity.this.J2();
                zn6.c("pagemultipleedit_editarea_addphoto", "click");
                return;
            }
            ArrayList<FeedBean> arrayListA = ei4.a(SquareMultiPublishActivity.this.x);
            Intent intent = new Intent(SquareMultiPublishActivity.this, (Class<?>) SquareMultiPublishPreviewActivity.class);
            intent.putExtra("selectIndex", i);
            intent.putParcelableArrayListExtra("extra_key_feeds", arrayListA);
            intent.putExtra("KEY_FROM", "from_publish_preview");
            SquareMultiPublishActivity.this.startActivityForResult(intent, 201);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements os3.d {
        public d() {
        }

        @Override // os3.d
        public void a(int i) {
            zn6.c("pagemultipleedit_editarea_cancelphoto", "click");
            SquareMultiPublishActivity.this.D2();
        }
    }

    public final void J2() {
        tk3.i(this, this.x.size(), 200);
    }

    public final void K2() {
        xk3 xk3VarT = ap3.a().t();
        this.p0 = xk3VarT;
        xk3VarT.a(this, new a());
    }

    public final void L2() {
        ArrayList<MediaItem> arrayList = this.x;
        if (arrayList != null && arrayList.size() == 1 && this.x.get(0).mimeType == 1) {
            this.m0.setNumColumns(1);
            this.m0.getLayoutParams().width = os3.j(this.x.get(0));
        } else {
            this.m0.getLayoutParams().width = a46.b(this, 288.0f);
            this.m0.setNumColumns(3);
        }
        os3 os3Var = new os3(this, this.x);
        this.o0 = os3Var;
        os3Var.l(this.q0);
        this.m0.setDrag(true);
        this.m0.setAdapter((ListAdapter) this.o0);
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public float S1(int i) {
        float fB = i - tn.b(this, 24);
        Log.d(r0, "keyboard change y:" + fB);
        return -fB;
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public View a2() {
        return this.l0;
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public void e2() {
        this.l0 = findViewById(R$id.rl_topic);
        super.e2();
        DragGridView dragGridView = (DragGridView) findViewById(com.zenmen.palmchat.friendcircle.R$id.gridview);
        this.m0 = dragGridView;
        dragGridView.setOnItemClickListener(new c());
        L2();
        this.N.setBgColorType(1);
        this.N.setPageFrom(2);
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public boolean g2() {
        return false;
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, "", true);
        toolbarInitToolbar.setNavigationIcon(R$drawable.selector_arrow_back);
        toolbarInitToolbar.setNavigationOnClickListener(new b());
        ((TextView) toolbarInitToolbar.findViewById(R$id.title)).setText("编辑");
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 200) {
            if (i2 == -1 && intent != null) {
                new ArrayList();
                ArrayList<MediaItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("select_picture");
                for (MediaItem mediaItem : parcelableArrayListExtra) {
                    String str = mediaItem.editedImagePath;
                    if (str != null) {
                        mediaItem.fileFullPath = str;
                    }
                }
                if (!parcelableArrayListExtra.isEmpty()) {
                    this.x.addAll(parcelableArrayListExtra);
                    L2();
                }
            }
        } else if (i != 201) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1 && intent != null) {
            ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("extra_key_feeds");
            this.x.clear();
            Iterator it = parcelableArrayListExtra2.iterator();
            while (it.hasNext()) {
                this.x.add(((FeedBean) it.next()).getMediaItem());
            }
            L2();
        }
        D2();
        this.p0.onActivityResult(i, i2, intent);
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        K2();
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.n0 = getIntent().getIntExtra("key_from", 0);
        }
        r2(true);
        setContentView(R$layout.square_layout_activity_multi_publish);
        initActionBar();
        e2();
        U1();
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.n0));
        zn6.j("pagemultipleedit", "view", map);
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            this.p0.onPermissionDenied(permissionType, permissionUsage);
        }
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD) {
            this.p0.onPermissionGrant(permissionType, permissionUsage, z);
        }
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p0.onResume();
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public boolean s2() {
        Editable text = this.L.getText();
        if (text == null || TextUtils.isEmpty(text.toString())) {
            return true;
        }
        if (this.L.getSelectionStart() != this.L.getSelectionEnd()) {
            return false;
        }
        int selectionStart = this.L.getSelectionStart();
        if (selectionStart < text.length()) {
            selectionStart++;
        }
        return text.toString().substring(0, selectionStart).endsWith("\n\n");
    }

    @Override // com.zenmen.square.activity.SquareBasePublishActivity
    public void y2() {
        super.y2();
        this.p0.show();
    }
}
