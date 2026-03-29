package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.openapi.offline.request.FetchPkgInfo;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.tab.TabItemsManager;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.TabCellView5;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class f22 {
    public DynamicConfigFragment b;
    public FrameLayout c;
    public NestedScrollView d;
    public LinearLayout e;
    public TabItem f;
    public int h;
    public lt3 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<zz> f17415a = new ArrayList<>();
    public List<FetchPkgInfo> g = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17416a;

        public a(Context context) {
            this.f17416a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intentP;
            if (l50.a() || (intentP = ve.p((FrameworkBaseActivity) this.f17416a, f22.this.i.a())) == null) {
                return;
            }
            try {
                this.f17416a.startActivity(intentP);
                ip3.c("pagemy_app_usedmore2");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17417a;

        public b(Context context) {
            this.f17417a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intentP;
            if (l50.a() || (intentP = ve.p((FrameworkBaseActivity) this.f17417a, f22.this.i.a())) == null) {
                return;
            }
            try {
                this.f17417a.startActivity(intentP);
                ip3.c("pagemy_app_hotmore");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f17418a;

        public c(LinearLayout linearLayout) {
            this.f17418a = linearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int childCount = this.f17418a.getChildCount();
            if (childCount > 1) {
                boolean z = this.f17418a.getChildAt(1).getVisibility() == 0;
                for (int i = 1; i < childCount; i++) {
                    this.f17418a.getChildAt(i).setVisibility(z ? 8 : 0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17419a;

        public d(Context context) {
            this.f17419a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            String strC = f22.this.i.c();
            try {
                strC = strC.substring(0, strC.indexOf("url=") + 4) + URLEncoder.encode(strC.substring(strC.indexOf("url=") + 4), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            bu3.g().j(this.f17419a, strC);
            ip3.c("pagemy_app_usedmore1");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f17420a;

        public e(uk5 uk5Var) {
            this.f17420a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = f22.this.f17415a.iterator();
            while (it.hasNext()) {
                ((zz) it.next()).onStatusChanged(this.f17420a);
            }
        }
    }

    public f22(DynamicConfigFragment dynamicConfigFragment, int i) {
        this.b = dynamicConfigFragment;
        this.h = i;
        this.i = new lt3(dynamicConfigFragment.getContext());
    }

    public void A() {
        TabItem tabItem;
        FragmentActivity activity = this.b.getActivity();
        os5 os5VarC2 = (activity == null || (tabItem = this.f) == null || !(activity instanceof MainTabsActivity)) ? null : ((MainTabsActivity) activity).C2(tabItem.tag);
        if (os5VarC2 != null) {
            int iL = l();
            LogUtil.i("FragmentCellViewManager", "updateMainTabUnreadView count" + iL);
            boolean z = true;
            if (iL > 0) {
                os5VarC2.d(false);
                os5VarC2.c(true);
                os5VarC2.b(iL);
            } else {
                os5VarC2.c(false);
                if (iL != -1 && this.b.W() != -1) {
                    z = false;
                }
                os5VarC2.d(z);
            }
        }
    }

    public final void c(Context context, ViewGroup viewGroup, GroupItem groupItem, ArrayList<CellItem> arrayList) {
        int i = groupItem.styleType;
        if (i == 0 || i == 1) {
            e(context, viewGroup, groupItem, arrayList);
        } else if (i == 8) {
            new mf6(groupItem, arrayList, this.f, this.b, this.f17415a).c(context, viewGroup);
        } else {
            d(context, viewGroup, groupItem, arrayList);
        }
    }

    public final void d(Context context, ViewGroup viewGroup, GroupItem groupItem, ArrayList<CellItem> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            CellItem cellItem = arrayList.get(i);
            zz zzVarB = CellViewControllerManager.b(cellItem);
            zzVarB.onCreateView(this.b, this.f, groupItem, cellItem);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i == arrayList.size() - 1 && groupItem.styleType == 2) {
                layoutParams.setMargins(0, 0, 0, groupItem.ignorePadding ? 0 : me1.b(context, 14));
            }
            View view = zzVarB.getView();
            viewGroup.addView(view, layoutParams);
            if (view instanceof TabCellView5) {
                ((TabCellView5) view).calculateParams();
            }
            this.f17415a.add(zzVarB);
        }
    }

    public final void e(Context context, ViewGroup viewGroup, GroupItem groupItem, ArrayList<CellItem> arrayList) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_dynamic_group_top, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.groupName);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.group_layout);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.groupgo_layout);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.rowLayout2);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.rowLayout3);
        if (GroupItem.TAG_RECENT_USE.equals(groupItem.tag) && TeenagersModeManager.a().d()) {
            return;
        }
        if (arrayList.size() != 0) {
            int iB = this.i.b();
            ArrayList arrayList2 = new ArrayList();
            if (!GroupItem.TAG_RECENT_USE.equals(groupItem.tag) || arrayList.size() <= iB) {
                arrayList2.addAll(arrayList);
            } else {
                arrayList2.addAll(arrayList.subList(0, iB));
            }
            ArrayList<CellItem> arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            textView.setText(groupItem.getNameForShow());
            int i = groupItem.styleType;
            if (i == 1) {
                ip3.d("pagemy_app_hotmore");
                relativeLayout.setOnClickListener(new b(context));
            } else if (i == 8) {
                relativeLayout2.setOnClickListener(new c(linearLayout));
            } else {
                textView.setVisibility(8);
            }
            int iB2 = me1.b(context, 40);
            int iB3 = me1.b(context, 15);
            if (GroupItem.TAG_RECENT_USE.equals(groupItem.tag)) {
                linearLayout2.setVisibility(8);
                relativeLayout2.setVisibility(0);
                ip3.d("pagemy_app_usedmore1");
                relativeLayout2.setOnClickListener(new d(context));
            }
            if (arrayList3.size() > 0) {
                int iB4 = me1.b(context, 80);
                me1.b(context, 84);
                int iG = ((((me1.g() - iB3) + iB2) - (iB4 * 4)) - (me1.b(context, 24) * 2)) / 8;
                int i2 = 0;
                LinearLayout linearLayout3 = null;
                for (CellItem cellItem : arrayList3) {
                    if (i2 % 4 == 0) {
                        linearLayout3 = new LinearLayout(context);
                        linearLayout3.setOrientation(0);
                        linearLayout3.setGravity(80);
                        linearLayout.addView(linearLayout3);
                    }
                    i2++;
                    zz zzVarB = CellViewControllerManager.b(cellItem);
                    zzVarB.onCreateView(this.b, this.f, groupItem, cellItem);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iB4, -2);
                    layoutParams.setMargins(iG, 0, iG, 0);
                    linearLayout3.addView(zzVarB.getView(), layoutParams);
                    this.f17415a.add(zzVarB);
                }
            }
        } else {
            if (!GroupItem.TAG_RECENT_USE.equals(groupItem.tag)) {
                return;
            }
            textView.setText(groupItem.getNameForShow());
            linearLayout2.setVisibility(0);
            ip3.d("pagemy_app_usedmore2");
            linearLayout2.setOnClickListener(new a(context));
            relativeLayout2.setVisibility(8);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, groupItem.ignorePadding ? 0 : me1.b(context, 10));
        viewGroup.addView(viewInflate, layoutParams2);
    }

    public final void f(CellItem cellItem) {
        if (!WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(jo6.e("LX-31157")) || cellItem.turnInfo == null || TextUtils.isEmpty(cellItem.appId) || !cellItem.turnInfo.url.startsWith("zenxin://webapp")) {
            return;
        }
        FetchPkgInfo fetchPkgInfo = new FetchPkgInfo();
        fetchPkgInfo.setExtId(cellItem.appId);
        String strD = b64.b().d(cellItem.appId);
        if (TextUtils.isEmpty(strD)) {
            fetchPkgInfo.setVerCode(0);
        } else {
            fetchPkgInfo.setVerCode(Integer.valueOf(strD).intValue());
        }
        this.g.add(fetchPkgInfo);
    }

    public void g() {
        try {
            for (zz zzVar : this.f17415a) {
                if (zzVar.getView() != null) {
                    zzVar.onDestroyView();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e.removeAllViews();
        this.f17415a.clear();
        this.g.clear();
    }

    public void h() {
        j();
        A();
        v();
    }

    public void i(GroupItem groupItem, boolean z, boolean z2) {
        boolean z3;
        Context context = this.b.getContext();
        if (context == null) {
            return;
        }
        List<CellItem> list = groupItem.items;
        if (list != null) {
            Iterator<CellItem> it = list.iterator();
            while (it.hasNext()) {
                if (CellViewControllerManager.BuildInType.SETTINGS_HEAD.key.equals(it.next().tag)) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        } else {
            z3 = false;
        }
        int iB = (!z2 || z3) ? 0 : me1.b(context, 12);
        ArrayList<CellItem> arrayList = new ArrayList<>();
        List<CellItem> list2 = groupItem.items;
        if (list2 != null) {
            for (CellItem cellItem : list2) {
                f(cellItem);
                if (CellViewControllerManager.a(groupItem, cellItem)) {
                    arrayList.add(cellItem);
                }
            }
        }
        int i = groupItem.styleType;
        if (i == 0 || i == 1) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setTag(groupItem);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(iB, 0, iB, 0);
            this.e.addView(linearLayout, layoutParams);
            c(context, linearLayout, groupItem, arrayList);
            return;
        }
        if (i == 3) {
            if (arrayList.size() > 0) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                int iB2 = me1.b(context, 11);
                linearLayout2.setPadding(0, iB2, 0, iB2);
                if (!com.zenmen.palmchat.sync.a.e() || z) {
                    layoutParams2.setMargins(iB, 0, iB, me1.b(context, 10));
                } else {
                    layoutParams2.setMargins(iB, 0, iB, me1.b(context, 10));
                }
                linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.shape_gray_round_corner_12dp));
                linearLayout2.setOrientation(1);
                linearLayout2.setTag(groupItem);
                this.e.addView(linearLayout2, layoutParams2);
                c(context, linearLayout2, groupItem, arrayList);
                return;
            }
            return;
        }
        if (i == 4) {
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setOrientation(0);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            linearLayout3.setTag(groupItem);
            layoutParams3.setMargins(iB, 0, iB, 0);
            this.e.addView(linearLayout3, layoutParams3);
            c(context, linearLayout3, groupItem, arrayList);
            return;
        }
        if (i != 5) {
            if (arrayList.size() > 0) {
                LinearLayout linearLayout4 = new LinearLayout(context);
                linearLayout4.setOrientation(1);
                linearLayout4.setTag(groupItem);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.setMargins(iB, 0, iB, 0);
                this.e.addView(linearLayout4, layoutParams4);
                c(context, linearLayout4, groupItem, arrayList);
                return;
            }
            return;
        }
        if (arrayList.size() > 0) {
            LinearLayout linearLayout5 = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            int iB3 = me1.b(context, 11);
            linearLayout5.setPadding(0, iB3, 0, iB3);
            layoutParams5.setMargins(iB, 0, iB, me1.b(context, 10));
            linearLayout5.setBackground(context.getResources().getDrawable(R.drawable.shape_gray_round_corner_12dp));
            linearLayout5.setOrientation(1);
            linearLayout5.setTag(groupItem);
            this.e.addView(linearLayout5, layoutParams5);
            c(context, linearLayout5, groupItem, arrayList);
        }
    }

    public final void j() {
        g();
        TabItem tabItem = this.f;
        if (tabItem != null) {
            boolean z = false;
            for (GroupItem groupItem : tabItem.groups) {
                i(groupItem, z, "tab_mine".equals(this.f.tag));
                if (z) {
                    z = false;
                }
                if (GroupItem.TAG_VIP.equals(groupItem.tag)) {
                    z = true;
                }
            }
        }
    }

    public final int k() {
        MainTabsActivity mainTabsActivity;
        if (this.f == null || (mainTabsActivity = (MainTabsActivity) this.b.getActivity()) == null) {
            return 0;
        }
        return mainTabsActivity.A2(this.f.tag);
    }

    public int l() {
        int i = 0;
        boolean z = false;
        for (zz zzVar : this.f17415a) {
            a00 viewStatus = zzVar.getViewStatus();
            int i2 = viewStatus.f1127a;
            CellItem cellItem = zzVar.getCellItem();
            if (i2 > 0 && CellItem.c.a(cellItem.strikeType)) {
                i += i2;
            }
            if ((CellItem.c.d(cellItem.strikeType) && i2 == -1) || ((CellItem.c.c(cellItem.strikeType) && viewStatus.g) || (CellItem.c.b(cellItem.strikeType) && viewStatus.h))) {
                z = true;
            }
        }
        if (i == 0 && z) {
            return -1;
        }
        return i;
    }

    public void m(zz zzVar, a00 a00Var) {
        CellItem cellItem = zzVar.getCellItem();
        GroupItem groupItem = zzVar.getGroupItem();
        if (TextUtils.isEmpty(this.f.kitCode)) {
            return;
        }
        int iK = k();
        try {
            int i = 0;
            int i2 = -1;
            GroupItem groupItem2 = null;
            int i3 = 0;
            for (zz zzVar2 : this.f17415a) {
                GroupItem groupItem3 = zzVar2.getGroupItem();
                zzVar2.getCellItem();
                if (groupItem2 != groupItem3) {
                    i2++;
                    groupItem2 = groupItem3;
                    i3 = 0;
                } else {
                    i3++;
                }
                if (zzVar2 == zzVar) {
                    break;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", cellItem.tag);
            jSONObject.put("type", a00Var.f1127a);
            jSONObject.put("styleType", groupItem.styleType);
            jSONObject.put("label", TextUtils.isEmpty(a00Var.b) ? 0 : 1);
            if (!TextUtils.isEmpty(a00Var.e)) {
                i = 1;
            }
            jSONObject.put("guideIcon", i);
            jSONObject.put(EventParams.KEY_GROUP, i2);
            jSONObject.put("index", i3);
            jSONObject.put("pageIndex", iK);
            LogUtil.uploadInfoImmediate(cellItem.kitCode, null, null, jSONObject.toString());
            if (TextUtils.isEmpty(cellItem.appId) && TextUtils.isEmpty(cellItem.kitCode)) {
                return;
            }
            ah ahVarC = ah.c(cellItem.appId, iK + "-" + i2 + "-" + i3);
            if (!TextUtils.isEmpty(cellItem.kitCode)) {
                ahVarC.d = cellItem.kitCode;
            }
            f84.e(ahVarC, "click");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void n() {
        TabItem tabItem = this.f;
        if (tabItem == null || tabItem.kitCode == null) {
            return;
        }
        int iK = k();
        JSONArray jSONArray = new JSONArray();
        try {
            int i = -1;
            GroupItem groupItem = null;
            int i2 = 0;
            for (zz zzVar : this.f17415a) {
                GroupItem groupItem2 = zzVar.getGroupItem();
                CellItem cellItem = zzVar.getCellItem();
                if (groupItem != groupItem2) {
                    i++;
                    groupItem = groupItem2;
                    i2 = 0;
                } else {
                    i2++;
                }
                a00 viewStatus = zzVar.getViewStatus();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tag", cellItem.tag);
                jSONObject.put("type", viewStatus.f1127a);
                jSONObject.put("styleType", groupItem2.styleType);
                jSONObject.put("pageIndex", iK);
                jSONObject.put(EventParams.KEY_GROUP, i);
                jSONObject.put("index", i2);
                jSONObject.put("label", TextUtils.isEmpty(viewStatus.b) ? 0 : 1);
                jSONObject.put("guideIcon", viewStatus.g ? 1 : 0);
                jSONArray.put(jSONObject);
                if (!TextUtils.isEmpty(cellItem.appId) || !TextUtils.isEmpty(cellItem.kitCode)) {
                    ah ahVarC = ah.c(cellItem.appId, iK + "-" + i + "-" + i2);
                    if (!TextUtils.isEmpty(cellItem.kitCode)) {
                        ahVarC.d = cellItem.kitCode;
                    }
                    f84.e(ahVarC, bq.b.V);
                }
            }
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate(this.f.kitCode, null, null, jSONArray.toString());
    }

    public void o(int i, int i2, Intent intent) {
        Iterator<zz> it = this.f17415a.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @qm5
    public void onCellUpdateEvent(CellUpdateEvent cellUpdateEvent) {
        this.b.e0(cellUpdateEvent);
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        if (uk5Var == null || this.b.getActivity() == null || this.b.getActivity().isFinishing()) {
            return;
        }
        this.b.getActivity().runOnUiThread(new e(uk5Var));
    }

    public View p(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.h, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.rootLayout);
        this.c = frameLayout;
        this.d = (NestedScrollView) frameLayout.findViewById(R.id.rootScrollView);
        this.e = (LinearLayout) this.c.findViewById(R.id.contentLayout);
        TabItem tabItem = this.f;
        if (!(TabItemsManager.BuildInType.TAB_MINE.key.equals(tabItem.tag) & (tabItem != null))) {
            h();
        }
        LogUtil.i("FragmentCellViewManager", "onCreateView");
        ds0.a().c(this);
        return viewInflate;
    }

    public void q() {
        Iterator<zz> it = this.f17415a.iterator();
        while (it.hasNext()) {
            it.next().onDestroyView();
        }
        ds0.a().d(this);
    }

    public void r() {
        Iterator<zz> it = this.f17415a.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void s() {
        Iterator<zz> it = this.f17415a.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        A();
    }

    public void t() {
        ch.s().r().j(this);
    }

    public void u() {
        ch.s().r().l(this);
    }

    public final void v() {
        if (!WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(jo6.c("LX-31157", "A")) || this.g == null) {
            return;
        }
        x54.b().a(this.g);
    }

    public void w(TabItem tabItem) {
        this.f = tabItem;
    }

    public void x(boolean z) {
        Iterator<zz> it = this.f17415a.iterator();
        while (it.hasNext()) {
            it.next().setUserVisibleHint(z);
        }
        if (z) {
            n();
        }
    }

    public void y() {
        j();
        A();
        v();
    }

    public void z(Context context, GroupItem groupItem) {
        String str;
        for (int i = 0; i < this.e.getChildCount(); i++) {
            View childAt = this.e.getChildAt(i);
            if ((childAt.getTag() instanceof GroupItem) && (str = ((GroupItem) childAt.getTag()).tag) != null && str.equals(groupItem.tag)) {
                if (childAt instanceof ViewGroup) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (zz zzVar : this.f17415a) {
                            if (zzVar.getGroupItem() != null && zzVar.getGroupItem().tag != null && zzVar.getGroupItem().tag.equals(groupItem.tag)) {
                                zzVar.onDestroyView();
                                arrayList.add(zzVar);
                            }
                        }
                        this.f17415a.removeAll(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    viewGroup.removeAllViews();
                    ArrayList<CellItem> arrayList2 = new ArrayList<>();
                    List<CellItem> list = groupItem.items;
                    if (list != null) {
                        for (CellItem cellItem : list) {
                            f(cellItem);
                            if (CellViewControllerManager.a(groupItem, cellItem)) {
                                arrayList2.add(cellItem);
                            }
                        }
                    }
                    c(context, viewGroup, groupItem, arrayList2);
                    LogUtil.i("FragmentCellViewManager", "updateGroup" + this.f17415a.size());
                    return;
                }
                return;
            }
        }
    }
}
