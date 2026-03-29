package com.zenmen.media.roomchatdemo.videocallgroup;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.zenmen.media.common.NiceImageView;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupSelectionActivity;
import com.zenmen.palmchat.R;
import defpackage.ir2;
import defpackage.u66;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends BaseAdapter {
    public static String d = "UserListModelAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<u66> f12004a;
    public Context b;
    public VideoCallGroupSelectionActivity.e c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12005a;
        public final /* synthetic */ b b;

        public a(int i, b bVar) {
            this.f12005a = i;
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Log.i(c.d, "uid: " + ((u66) c.this.f12004a.get(this.f12005a)).c());
            if (((u66) c.this.f12004a.get(this.f12005a)).f()) {
                return;
            }
            CheckBox checkBox = this.b.b;
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                ((u66) c.this.f12004a.get(this.f12005a)).j(false);
            } else {
                checkBox.setChecked(true);
                ((u66) c.this.f12004a.get(this.f12005a)).j(true);
            }
            Iterator it = c.this.f12004a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((u66) it.next()).e()) {
                    i++;
                }
            }
            if (!c.this.c.b(i)) {
                c.this.c.a(((u66) c.this.f12004a.get(this.f12005a)).c(), checkBox.isChecked());
            } else {
                checkBox.setChecked(false);
                ((u66) c.this.f12004a.get(this.f12005a)).j(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f12006a;
        public CheckBox b;
        public NiceImageView c;

        public b() {
        }
    }

    public c(List<u66> list, Context context, VideoCallGroupSelectionActivity.e eVar) {
        this.f12004a = list;
        this.b = context;
        this.c = eVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        try {
            return this.f12004a.size();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f12004a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            b bVar = new b();
            View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.manychats_video_call_group_user_list, (ViewGroup) null);
            NiceImageView niceImageView = (NiceImageView) viewInflate.findViewById(R.id.sel_user_icon);
            bVar.c = niceImageView;
            niceImageView.setCornerTopRightRadius(2);
            bVar.c.setCornerTopLeftRadius(2);
            bVar.c.setCornerBottomRightRadius(2);
            bVar.c.setCornerBottomLeftRadius(2);
            bVar.f12006a = (TextView) viewInflate.findViewById(R.id.group_user_name);
            bVar.b = (CheckBox) viewInflate.findViewById(R.id.ckb);
            viewInflate.setTag(bVar);
            view = viewInflate;
        }
        u66 u66Var = this.f12004a.get(i);
        b bVar2 = (b) view.getTag();
        bVar2.f12006a.setText(u66Var.d());
        ir2.a(this.b, bVar2.c, u66Var.a(), u66Var.b());
        Log.e("myadapter", u66Var.d() + "------" + u66Var.e());
        bVar2.b.setChecked(u66Var.e());
        bVar2.b.setEnabled(u66Var.f() ^ true);
        view.setOnClickListener(new a(i, bVar2));
        return view;
    }
}
