package com.zenmen.palmchat.maintab.cell;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.yz;
import defpackage.zz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicCellListActivity extends BaseActionBarActivity {
    public GroupItem q = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14609a;

        public a(ArrayList arrayList) {
            this.f14609a = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CellItem cellItem = (CellItem) this.f14609a.get(i);
            zz zzVarB = CellViewControllerManager.b(cellItem);
            if (zzVarB.getView() instanceof yz) {
                ((yz) zzVarB.getView()).onEntranceClick();
            }
            zzVarB.processOnClick(DynamicCellListActivity.this, cellItem);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<CellItem> f14610a;

        public b(List<CellItem> list) {
            ArrayList<CellItem> arrayList = new ArrayList<>();
            this.f14610a = arrayList;
            arrayList.addAll(list);
        }

        public final int a() {
            return (DynamicCellListActivity.this.q == null || DynamicCellListActivity.this.q.styleType == 0 || DynamicCellListActivity.this.q.styleType != 1) ? R.drawable.icon_tab_cell_default : R.drawable.icon_tab_cell_default2;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CellItem getItem(int i) {
            return this.f14610a.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f14610a.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVarA;
            if (view == null) {
                view = DynamicCellListActivity.this.getLayoutInflater().inflate(R.layout.activity_dynamic_list_item, (ViewGroup) null, false);
            }
            if (view.getTag() == null) {
                cVarA = c.a(view);
                view.setTag(cVarA);
            } else {
                cVarA = (c) view.getTag();
            }
            CellItem cellItem = this.f14610a.get(i);
            cVarA.f14611a.setImageResource(a());
            if (!TextUtils.isEmpty(cellItem.icon)) {
                gr2.j().h(cellItem.icon, cVarA.f14611a, bq6.v());
            }
            cVarA.b.setText(cellItem.getNameForShow());
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f14611a;
        public TextView b;

        public static c a(View view) {
            c cVar = new c();
            cVar.f14611a = (ImageView) view.findViewById(R.id.icon);
            cVar.b = (TextView) view.findViewById(R.id.title);
            return cVar;
        }
    }

    public final void B1() {
        String stringExtra = getIntent().getStringExtra("extra_group_name");
        this.q = (GroupItem) getIntent().getParcelableExtra("extra_group_info");
        initToolbar(stringExtra);
        ListView listView = (ListView) findViewById(R.id.list);
        ArrayList arrayList = new ArrayList();
        for (CellItem cellItem : this.q.items) {
            if (CellViewControllerManager.a(this.q, cellItem)) {
                arrayList.add(cellItem);
            }
        }
        listView.setAdapter((ListAdapter) new b(arrayList));
        listView.setOnItemClickListener(new a(arrayList));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dynamic_list);
        B1();
    }
}
