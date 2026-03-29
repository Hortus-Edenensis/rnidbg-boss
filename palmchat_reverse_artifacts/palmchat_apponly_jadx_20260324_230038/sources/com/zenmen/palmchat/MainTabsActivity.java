package com.zenmen.palmchat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.openapi.webapp.WebAppManager;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import com.zenmen.palmchat.Vo.DaemonConfig;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.a;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.activity.search.SearchContentActivity;
import com.zenmen.palmchat.activity.tools.SQLiteRecoveryActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.MainTabsViewPager;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.circle.ui.CircleLaunchCreateCircleActivity;
import com.zenmen.palmchat.contacts.AddContactActivity;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.conversations.threadsnew.SeeMeManager;
import com.zenmen.palmchat.conversations.threadsnew.ThreadsNewFragment;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.framework.square.bean.ShareSmsBean;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.loginnew.ConfirmGBBean;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.FindFriendFragment;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.tab.TabItemsManager;
import com.zenmen.palmchat.mine.NewMineFragment;
import com.zenmen.palmchat.modulemanager.LXModuleInitManager;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ColorFilterFrameLayout;
import com.zenmen.palmchat.widget.TabsBarLayout;
import com.zenmen.square.activity.SquarePublishActivity;
import com.zenmen.square.fragment.online.OnlineRecommend;
import com.zenmen.square.fragment.squareguide.QueryGuidePopupResult;
import defpackage.UI;
import defpackage.a46;
import defpackage.ad1;
import defpackage.ah;
import defpackage.ao6;
import defpackage.av4;
import defpackage.az2;
import defpackage.b05;
import defpackage.b6;
import defpackage.bn0;
import defpackage.c92;
import defpackage.ch;
import defpackage.cx5;
import defpackage.d20;
import defpackage.dc3;
import defpackage.dg2;
import defpackage.dm0;
import defpackage.ds0;
import defpackage.e9;
import defpackage.ec3;
import defpackage.ew1;
import defpackage.f84;
import defpackage.ff2;
import defpackage.fk2;
import defpackage.fo5;
import defpackage.fz4;
import defpackage.gc3;
import defpackage.go2;
import defpackage.gu4;
import defpackage.hc3;
import defpackage.ho3;
import defpackage.ip3;
import defpackage.ir5;
import defpackage.is0;
import defpackage.jo6;
import defpackage.jp3;
import defpackage.k86;
import defpackage.kc3;
import defpackage.lb3;
import defpackage.lj5;
import defpackage.ma3;
import defpackage.me1;
import defpackage.mo3;
import defpackage.nl0;
import defpackage.np3;
import defpackage.nx3;
import defpackage.o30;
import defpackage.o34;
import defpackage.oc0;
import defpackage.os5;
import defpackage.pe5;
import defpackage.pm2;
import defpackage.q05;
import defpackage.qg;
import defpackage.qm5;
import defpackage.qq2;
import defpackage.qv1;
import defpackage.rv1;
import defpackage.sd3;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.t56;
import defpackage.tg4;
import defpackage.tj2;
import defpackage.tn0;
import defpackage.tu3;
import defpackage.u5;
import defpackage.uk5;
import defpackage.uv3;
import defpackage.v8;
import defpackage.vg4;
import defpackage.vt2;
import defpackage.wg4;
import defpackage.wh5;
import defpackage.wt2;
import defpackage.x6;
import defpackage.x63;
import defpackage.xn3;
import defpackage.z64;
import defpackage.zf2;
import defpackage.zm1;
import defpackage.zm4;
import defpackage.zn6;
import defpackage.zw4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MainTabsActivity extends BaseActionBarActivity implements pm2<Cursor>, Observer {
    public static final String A0 = "MainTabsActivity";
    public static String z0 = "tab_msg";
    public TextView A;
    public TextView B;
    public MenuItem C;
    public MenuItem E;
    public MenuItem F;
    public ColorFilterFrameLayout G;
    public ThreadsNewFragment H;
    public SquareTabFragment I;
    public FindFriendFragment J;
    public NewMineFragment K;
    public CountDownTimer L;
    public zm1 R;
    public Response.Listener<JSONObject> S;
    public Response.ErrorListener T;
    public boolean V;
    public MaterialDialog W;
    public boolean e0;
    public ShareSmsBean f0;
    public dc3 i0;
    public String j0;
    public int k0;
    public ChatItem l0;
    public MainTabsViewPager q;
    public TabsPagerAdapter r;
    public TabsBarLayout v;
    public MaterialDialog v0;
    public MaterialDialog w0;
    public String[] x;
    public Toolbar z;
    public boolean s = false;
    public boolean t = false;
    public String u = null;
    public final Handler w = new Handler();
    public final int[] y = {R.drawable.icon_menu_group, R.drawable.icon_menu_add, R.drawable.icon_menu_sys, R.drawable.icon_menu_help};
    public hc3 M = new hc3();
    public final ArrayList<String> N = new ArrayList<>();
    public final ArrayList<MessageVo> O = new ArrayList<>();
    public gc3 P = new gc3();
    public final BroadcastReceiver Q = new k();
    public boolean U = false;
    public boolean X = false;
    public final o34 Y = new o34(this);
    public final kc3 Z = kc3.c();
    public String g0 = null;
    public BroadcastReceiver h0 = new d0();
    public final SparseArray<String> m0 = new SparseArray<>();
    public String n0 = null;
    public PopupWindow.OnDismissListener o0 = new h();
    public final is0.f p0 = new i();
    public final is0.f q0 = new j();
    public final List<MessageVo> r0 = new ArrayList();
    public int s0 = 0;
    public boolean t0 = false;
    public boolean u0 = true;
    public final bn0.q x0 = new q();
    public int y0 = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class TabsPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12078a;
        public List<TabItem> b;

        @SuppressLint({"WrongConstant"})
        public TabsPagerAdapter(FragmentManager fragmentManager, List<TabItem> list) {
            super(fragmentManager, BaseFragment.E());
            this.f12078a = "TabsPagerAdapter";
            this.b = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
            LogUtil.i("TabsPagerAdapter", "destroyItem:" + i + " objct=" + obj);
        }

        public List<TabItem> f() {
            return this.b;
        }

        public final int g(String str) {
            int i = -1;
            for (TabItem tabItem : this.b) {
                if (!tabItem.isAdditionalTab()) {
                    i++;
                    if (tabItem.tag.equals(str)) {
                        return i;
                    }
                }
            }
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            Iterator<TabItem> it = this.b.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!it.next().isAdditionalTab()) {
                    i++;
                }
            }
            return i;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            String stringExtra;
            String strD2 = MainTabsActivity.this.D2(i);
            LogUtil.i("TabsPagerAdapter", "getItem:" + i + " key=" + strD2);
            if ("tab_msg".equals(strD2)) {
                ThreadsNewFragment threadsNewFragment = new ThreadsNewFragment();
                if (MainTabsActivity.this.getIntent() != null && (stringExtra = MainTabsActivity.this.getIntent().getStringExtra("thread_sub_tab")) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("thread_sub_tab", stringExtra);
                    threadsNewFragment.setArguments(bundle);
                }
                return threadsNewFragment;
            }
            if ("tab_mine".equals(strD2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("DynamicConfigFragment_EXTRA_KEY", ec3.j().e(this.b, "tab_mine"));
                return (NewMineFragment) Fragment.instantiate(MainTabsActivity.this, NewMineFragment.r, bundle2);
            }
            if ("tab_square".equals(strD2)) {
                return new SquareTabFragment();
            }
            if ("tab_find_friend".equals(strD2)) {
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("DynamicConfigFragment_EXTRA_KEY", ec3.j().e(this.b, "tab_find_friend"));
                return (FindFriendFragment) Fragment.instantiate(MainTabsActivity.this, FindFriendFragment.v, bundle3);
            }
            if (!TabItemsManager.e(strD2)) {
                return null;
            }
            Bundle bundle4 = new Bundle();
            bundle4.putParcelable("DynamicConfigFragment_EXTRA_KEY", ec3.j().e(this.b, strD2));
            return (DynamicConfigFragment) Fragment.instantiate(MainTabsActivity.this, DynamicConfigFragment.h, bundle4);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            String strD2 = MainTabsActivity.this.D2(i);
            Iterator<TabItem> it = this.b.iterator();
            while (it.hasNext() && !it.next().tag.equals(strD2)) {
            }
            int iHashCode = strD2.hashCode();
            LogUtil.i("TabsPagerAdapter", "getItemId position=" + i + "id=" + iHashCode + "key=" + strD2);
            return iHashCode;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int itemPosition;
            if (obj instanceof ThreadsNewFragment) {
                itemPosition = g("tab_msg");
            } else if (obj instanceof SquareTabFragment) {
                itemPosition = g("tab_square");
            } else if (obj instanceof FindFriendFragment) {
                itemPosition = g("tab_find_friend");
            } else if (obj instanceof DynamicConfigFragment) {
                DynamicConfigFragment dynamicConfigFragment = (DynamicConfigFragment) obj;
                itemPosition = dynamicConfigFragment.Y() != null ? g(dynamicConfigFragment.Y().tag) : super.getItemPosition(obj);
            } else {
                itemPosition = super.getItemPosition(obj);
            }
            LogUtil.i("TabsPagerAdapter", "getItemPosition:" + obj + ",position= " + itemPosition);
            return itemPosition;
        }

        public void h(List<TabItem> list) {
            this.b = list;
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Object objInstantiateItem = super.instantiateItem(viewGroup, i);
            if (objInstantiateItem instanceof NewMineFragment) {
                MainTabsActivity.this.K = (NewMineFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof SquareTabFragment) {
                MainTabsActivity.this.I = (SquareTabFragment) objInstantiateItem;
                if (MainTabsActivity.this.u != null) {
                    MainTabsActivity.this.I.Z0(MainTabsActivity.this.u);
                    MainTabsActivity.this.u = null;
                }
            } else if (objInstantiateItem instanceof FindFriendFragment) {
                MainTabsActivity.this.J = (FindFriendFragment) objInstantiateItem;
            } else if (objInstantiateItem instanceof ThreadsNewFragment) {
                MainTabsActivity.this.H = (ThreadsNewFragment) objInstantiateItem;
            }
            LogUtil.i("TabsPagerAdapter", "instantiateItem:" + i + " objct=" + objInstantiateItem);
            return objInstantiateItem;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends c92.c {
        public a() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ch.s().j0();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends c92.c {
        public b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ma3.a("GestureDetectorHelper onDoubleTap", new Object[0]);
            if (MainTabsActivity.this.I != null) {
                MainTabsActivity.this.I.x();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements u5.c {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long jB = ir5.b();
                if (MainTabsActivity.this.K != null) {
                    MainTabsActivity.this.K.Z().h();
                    MainTabsActivity.this.K.Z().s();
                }
                LogUtil.i(MainTabsActivity.A0 + "mNewMineFragment", "time =" + ir5.e(jB));
                LXModuleInitManager.getInstance().onMainTabUIReady(MainTabsActivity.this);
            }
        }

        public b0() {
        }

        @Override // u5.c
        public void a() {
            MainTabsActivity.this.runOnUiThread(new a());
        }

        @Override // u5.c
        public void b() {
            MainTabsActivity.this.Z.m();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends c92.c {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.v("Double", "GestureDetectorHelper onDoubleTap find");
            if (MainTabsActivity.this.J != null) {
                MainTabsActivity.this.J.x();
                return false;
            }
            Log.v("Double", "GestureDetectorHelper onDoubleTap find but but null");
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 extends go2<LXBaseNetBean<ConfirmGBBean>> {
        public c0() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/user.sex.default.status.get", new HashMap()).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ConfirmGBBean> lXBaseNetBean, Exception exc) {
            LogUtil.d(MainTabsActivity.A0, "initLoginGBCheck info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0) {
                return;
            }
            MainTabsActivity.this.b3(lXBaseNetBean.data);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f12086a;

        public d(MenuItem menuItem) {
            this.f12086a = menuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabsActivity.this.R2(this.f12086a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 extends BroadcastReceiver {
        public d0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !TextUtils.equals(intent.getAction(), mo3.o)) {
                return;
            }
            MainTabsActivity.this.s2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabsActivity mainTabsActivity = MainTabsActivity.this;
            mainTabsActivity.R2(mainTabsActivity.C);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12089a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.d {
            public a() {
            }

            @Override // com.zenmen.palmchat.a.d
            public void a(String str) {
                if (MainTabsActivity.this.q == null || str == null) {
                    return;
                }
                MainTabsActivity.this.q.setCurrentItem(MainTabsActivity.this.A2(str), false);
            }
        }

        public e0(boolean z, String str) {
            this.f12089a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12089a && DaemonConfig.f(MainTabsActivity.this)) {
                com.zenmen.palmchat.a.c(MainTabsActivity.this, new a());
            } else {
                if (TextUtils.isEmpty(this.b)) {
                    return;
                }
                MainTabsActivity.this.q.setCurrentItem(MainTabsActivity.this.A2(this.b), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabsActivity mainTabsActivity = MainTabsActivity.this;
            mainTabsActivity.R2(mainTabsActivity.E);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 extends HashMap<String, Object> {
        public f0() {
            put("action", "send_message");
            put("status", "shareImage");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainTabsActivity.this.h3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g0 extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<MainTabsActivity> f12094a;

        public g0(MainTabsActivity mainTabsActivity) {
            this.f12094a = new WeakReference<>(mainTabsActivity);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(!SqliteRecover.hasCorruptedDatabaseFileForLauncher());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            MainTabsActivity mainTabsActivity = this.f12094a.get();
            if (!bool.booleanValue()) {
                LogUtil.uploadInfoImmediate("chat002-show", null);
            }
            if (mainTabsActivity == null || bool.booleanValue()) {
                return;
            }
            mainTabsActivity.z2().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements PopupWindow.OnDismissListener {
        public h() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MainTabsActivity.this.M.a(MainTabsActivity.this, Float.valueOf(1.0f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h0 implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            Bundle bundleA;
            Intent intent = new Intent();
            intent.setClass(context, MainTabsActivity.class);
            String string = (aVar == null || (bundleA = aVar.a()) == null) ? null : bundleA.getString("main_tab");
            if (!TextUtils.isEmpty(string)) {
                intent.putExtra("new_intent_position", string);
            }
            if (aVar != null && aVar.a() != null) {
                intent.putExtras(aVar.a());
            }
            k86.Y(intent);
            return intent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements is0.f {
        public i() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                if (oc0.c()) {
                    Intent intent = new Intent(AppContext.getContext(), (Class<?>) CircleLaunchCreateCircleActivity.class);
                    intent.putExtra("extra_from", 2);
                    MainTabsActivity.this.startActivity(intent);
                    return;
                } else {
                    oc0.g("lx_group_create2_click");
                    Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
                    intent2.putExtra("from_type", 4);
                    MainTabsActivity.this.startActivity(intent2);
                    return;
                }
            }
            if (i == 1) {
                Intent intent3 = new Intent(AppContext.getContext(), (Class<?>) AddContactActivity.class);
                intent3.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_menu");
                MainTabsActivity.this.startActivity(intent3);
                return;
            }
            if (i == 2) {
                MainTabsActivity.this.g3();
                return;
            }
            if (i != 3) {
                return;
            }
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent4 = new Intent();
            intent4.setClass(MainTabsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.m());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent4.putExtras(bundle);
            MainTabsActivity.this.startActivity(intent4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements is0.f {
        public j() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                ip3.c("pagemsg_myfriend");
                MainTabsActivity.this.h3();
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "21", "1", null, null);
                zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_app_21", null, null);
                Intent intent = new Intent(MainTabsActivity.this, (Class<?>) ContactActivity.class);
                k86.X(intent);
                MainTabsActivity.this.startActivity(intent);
                return;
            }
            if (i == 1) {
                Intent intent2 = new Intent(AppContext.getContext(), (Class<?>) AddContactActivity.class);
                intent2.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_menu");
                MainTabsActivity.this.startActivity(intent2);
                return;
            }
            if (i == 2) {
                LogUtil.uploadInfoImmediate("search_more_new", "1", null, null);
                Intent intent3 = new Intent(MainTabsActivity.this, (Class<?>) SearchContentActivity.class);
                k86.X(intent3);
                MainTabsActivity.this.startActivity(intent3);
                return;
            }
            if (i == 3) {
                MainTabsActivity.this.g3();
                return;
            }
            if (i != 4) {
                return;
            }
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent4 = new Intent();
            intent4.setClass(MainTabsActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.m());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent4.putExtras(bundle);
            MainTabsActivity.this.startActivity(intent4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                LogUtil.i(MainTabsActivity.A0, "mainTabBroadcastReceiver " + action);
                if (action != null) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        if (AppContext.getContext().getTrayPreferences().a("firstTimeToBackground", true)) {
                            AppContext.getContext().getTrayPreferences().i("firstTimeToBackground", false);
                            vg4 vg4VarA = wg4.a(context);
                            vg4VarA.d();
                            vg4VarA.a();
                            return;
                        }
                        return;
                    }
                    if (MainTabsActivity.this.isFinishing()) {
                        return;
                    }
                    if ("android.intent.action.TIME_TICK".equals(action)) {
                        ch.s().g0(1);
                        LogUtil.i("TimeChangeReceiver", "每分钟变化");
                    } else if (com.igexin.push.core.b.N.equals(action)) {
                        ch.s().g0(2);
                        LogUtil.i("TimeChangeReceiver", "修改系统时间");
                    } else if ("android.intent.action.TIMEZONE_CHANGED".equals(action)) {
                        ch.s().g0(3);
                        LogUtil.i("TimeChangeReceiver", "修改系统时区");
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends MaterialDialog.e {
        public l() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            MainTabsActivity.this.a3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends MaterialDialog.e {
        public m() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            MainTabsActivity.this.v0.show();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            while (MainTabsActivity.this.m0.size() > 0) {
                MainTabsActivity mainTabsActivity = MainTabsActivity.this;
                mainTabsActivity.t2((String) mainTabsActivity.m0.valueAt(0));
                MainTabsActivity.this.m0.removeAt(0);
            }
            sy5.e(MainTabsActivity.this, R.string.string_share_toast_cancel_images, 1).g();
            MainTabsActivity.this.u2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends HashMap<String, Object> {
        public n() {
            put("action", "send_message");
            put("status", "cancelSendMessage");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainTabsActivity.this.v.logViewStatus("tab_display_new");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainTabsActivity.this.f0 != null) {
                MainTabsActivity mainTabsActivity = MainTabsActivity.this;
                k86.V(mainTabsActivity, mainTabsActivity.f0.msgContent, MainTabsActivity.this.f0.numbers, 104);
                MainTabsActivity.this.f0 = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12105a;

        public r(uk5 uk5Var) {
            this.f12105a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = MainTabsActivity.A0;
            LogUtil.i(str, " onStatusChanged eventType ：" + this.f12105a.f21235a);
            uk5 uk5Var = this.f12105a;
            int i = uk5Var.f21235a;
            if (i == 0) {
                MainTabsActivity.this.h3();
                return;
            }
            if (i == 1) {
                MainTabsActivity.this.p3(Integer.valueOf(uk5Var.b));
                return;
            }
            if (i != 9) {
                if (i == 16) {
                    LogUtil.i(str, "TYPE_DYNAMIC_CONFIG_CHANGE");
                    MainTabsActivity.this.n3();
                    DaemonConfig.m();
                    return;
                }
                if (i == 22) {
                    if (MainTabsActivity.this.U) {
                        MainTabsActivity.this.i3(this.f12105a.d);
                        return;
                    }
                    return;
                }
                if (i != 31 && i != 33 && i != 11 && i != 12) {
                    if (i == 27) {
                        if (!MainTabsActivity.this.U || zm4.f()) {
                            return;
                        }
                        MainTabsActivity mainTabsActivity = MainTabsActivity.this;
                        bn0.f(mainTabsActivity, mainTabsActivity.x0);
                        return;
                    }
                    if (i != 28 && i != 35 && i != 36) {
                        if (i != 38) {
                            if (i == 39 && MainTabsActivity.this.U) {
                                MainTabsActivity.this.m3(true);
                                return;
                            }
                            return;
                        }
                        MainTabsActivity.this.l3();
                        MainTabsActivity.this.X = true;
                        if (MainTabsActivity.this.U) {
                            MainTabsActivity.this.m3(false);
                        }
                        tu3.F(TeenagersModeManager.a().d());
                        return;
                    }
                }
            }
            LogUtil.i(str, "onStatusChanged updateDiscover ignore");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements Response.Listener<JSONObject> {
        public s() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            Log.i(MainTabsActivity.A0, jSONObject.toString() + "");
            if (jSONObject.optInt("resultCode", -1) != 0) {
                qg.e();
            } else {
                if (MainTabsActivity.this.isFinishing()) {
                    return;
                }
                MainTabsActivity.this.Z2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Response.ErrorListener {
        public t() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            Log.i(MainTabsActivity.A0, volleyError.toString() + "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f12108a;

        public u(MaterialDialog materialDialog) {
            this.f12108a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainTabsActivity mainTabsActivity = MainTabsActivity.this;
            qg.c(mainTabsActivity, mainTabsActivity.getPackageName(), 101);
            LogUtil.uploadInfoImmediate(MainTabsActivity.this.j0, "res7711", "1", null, null);
            zn6.e(MainTabsActivity.this.j0, "lx_client_app_res7711", null, null);
            this.f12108a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements TabsBarLayout.b {
        public v() {
        }

        @Override // com.zenmen.palmchat.widget.TabsBarLayout.b
        public void a(TabItem tabItem, int i) {
            MainTabsActivity.this.T2(tabItem, i, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f12110a;

        public w(MaterialDialog materialDialog) {
            this.f12110a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate(MainTabsActivity.this.j0, "res7713", "1", null, null);
            zn6.e(MainTabsActivity.this.j0, "lx_client_app_res7713", null, null);
            this.f12110a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x extends MaterialDialog.e {
        public x() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            HashMap map = new HashMap();
            map.put("action", 1);
            map.put("from", 1);
            LogUtil.uploadInfoImmediate("chatpage-cli", map);
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MainTabsActivity.this).edit();
            editorEdit.putBoolean(SqliteRecover.CHECK_DATABASE, false);
            editorEdit.apply();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            Intent intent = new Intent(MainTabsActivity.this, (Class<?>) SQLiteRecoveryActivity.class);
            intent.putExtra("check_database_now", true);
            MainTabsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements q05.e<LXBaseNetBean<QueryGuidePopupResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12112a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements q05.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LXBaseNetBean f12113a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.MainTabsActivity$y$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0946a implements q05.e {
                public C0946a() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // q05.e
                public void a(Object obj) {
                    a aVar = a.this;
                    if (((QueryGuidePopupResult) aVar.f12113a.data).triggerPositionList != null) {
                        if (MainTabsActivity.this.J != null) {
                            MainTabsActivity.this.J.L0();
                        }
                        if (MainTabsActivity.this.I != null) {
                            MainTabsActivity.this.I.b1();
                        }
                        if (MainTabsActivity.this.H != null) {
                            MainTabsActivity.this.H.O0();
                        }
                    }
                }
            }

            public a(LXBaseNetBean lXBaseNetBean) {
                this.f12113a = lXBaseNetBean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q05.f
            public void a() {
                lj5.c().e = true;
                LXBaseNetBean lXBaseNetBean = this.f12113a;
                if (lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                    q05.w("key_api_query_guide_popup", Long.valueOf(System.currentTimeMillis()));
                    T t = this.f12113a.data;
                    if (t != 0) {
                        if (((QueryGuidePopupResult) t).configType == 1) {
                            lj5.c().c = true;
                            lj5.c().e = false;
                            if (MainTabsActivity.this.I != null) {
                                MainTabsActivity.this.I.S0();
                            }
                        } else if (((QueryGuidePopupResult) t).configType == 2) {
                            lj5.c().d = true;
                            y yVar = y.this;
                            MainTabsActivity.this.L = q05.l(yVar.f12112a, ((QueryGuidePopupResult) this.f12113a.data).delayTime * 1000, new C0946a());
                        }
                    }
                }
                if (!lj5.c().e || MainTabsActivity.this.I == null) {
                    return;
                }
                MainTabsActivity.this.I.R0();
            }
        }

        public y(Activity activity) {
            this.f12112a = activity;
        }

        @Override // q05.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LXBaseNetBean<QueryGuidePopupResult> lXBaseNetBean) {
            lj5.c().b = true;
            q05.u(this.f12112a, new a(lXBaseNetBean));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements TabsBarLayout.a {
        public z() {
        }

        @Override // com.zenmen.palmchat.widget.TabsBarLayout.a
        public boolean a(TabItem tabItem, int i) {
            MainTabsActivity.this.T2(tabItem, i, false);
            return true;
        }
    }

    public static String w2(Context context, int i2) {
        return k86.l(i2);
    }

    public static int x2() {
        if (com.zenmen.palmchat.smallvideo.a.a()) {
            return 5;
        }
        int iL = ec3.j().l(z0);
        if (iL != -1) {
            return iL;
        }
        String str = z0;
        str.hashCode();
        if (str.equals("tab_discover")) {
            return 2;
        }
        return !str.equals("tab_mine") ? 1 : 4;
    }

    public static String y2() {
        return z0;
    }

    public int A2(String str) {
        return B2(str, false);
    }

    public int B2(String str, boolean z2) {
        TabsPagerAdapter tabsPagerAdapter = this.r;
        if (tabsPagerAdapter == null) {
            return 0;
        }
        int i2 = -1;
        for (TabItem tabItem : tabsPagerAdapter.f()) {
            if (!tabItem.isAdditionalTab() || z2) {
                i2++;
                if (tabItem.tag.equals(str)) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public os5 C2(String str) {
        return os5.a(this.v, str);
    }

    public final String D2(int i2) {
        TabsPagerAdapter tabsPagerAdapter = this.r;
        if (tabsPagerAdapter == null) {
            return "tab_msg";
        }
        int i3 = -1;
        for (TabItem tabItem : tabsPagerAdapter.f()) {
            if (!tabItem.isAdditionalTab() && (i3 = i3 + 1) == i2) {
                return tabItem.tag;
            }
        }
        return "tab_msg";
    }

    public final TabItem E2(String str) {
        TabsPagerAdapter tabsPagerAdapter = this.r;
        if (tabsPagerAdapter == null) {
            return null;
        }
        for (TabItem tabItem : tabsPagerAdapter.f()) {
            if (tabItem.tag.equals(str)) {
                return tabItem;
            }
        }
        return null;
    }

    public final void F2() {
        dc3 dc3Var = this.i0;
        if (dc3Var != null) {
            dc3Var.f();
        }
    }

    public final void G2(View view) {
        c92.a(view, new a());
    }

    public final void H2(View view) {
        if (view == null) {
            Log.v("Double", "bind doubleTap but view null");
        } else {
            c92.a(view, new c());
        }
    }

    public final void I2() {
        LogUtil.d("", "initLoginGBCheck isLoginDone " + dm0.l);
        if (dm0.l) {
            dm0.l = false;
            zw4.e(new c0());
        }
    }

    public final void J2() {
        this.x = nl0.g() ? new String[]{getString(R.string.main_menu_group_chat), getString(R.string.main_menu_add), getString(R.string.main_menu_scan), getString(R.string.main_menu_help)} : new String[]{getString(R.string.main_menu_group_chat), getString(R.string.main_menu_add), getString(R.string.main_menu_scan)};
    }

    public final void K2(View view) {
        if (view == null) {
            return;
        }
        c92.a(view, new b());
    }

    public final void L2() {
        findViewById(R.id.toolbar).setVisibility(0);
        Toolbar toolbarInitToolbar = initToolbar(R.id.toolbar, getString(R.string.app_name), false);
        this.z = toolbarInitToolbar;
        toolbarInitToolbar.setBackground(null);
        this.A = (TextView) this.z.findViewById(R.id.title);
        pe5.a().i(getWindow(), (ImageView) findViewById(R.id.topBgView), this.A);
        l3();
        setSupportActionBar(this.z);
        this.z.setVisibility(8);
        getWindow().setNavigationBarColor(-1);
        a46.A(getWindow(), true);
    }

    public final void N2() {
        LogUtil.i(A0, "moveTaskToBack");
        try {
            moveTaskToBack(true);
        } catch (Exception e2) {
            e2.printStackTrace();
            super.onBackPressed();
        }
    }

    public final void O2(Intent intent) {
        ThreadsNewFragment threadsNewFragment;
        if (intent == null) {
            return;
        }
        try {
            this.t = intent.getBooleanExtra("from_Chatter", false);
            String stringExtra = intent.getStringExtra("new_intent_position");
            boolean booleanExtra = intent.getBooleanExtra("from_daemon", false);
            intent.getBooleanExtra("new_intent_need_show_videoTab", false);
            Bundle bundleExtra = intent.getBundleExtra("extra_new_intent_videotab_init_bundle");
            if (bundleExtra != null) {
                bundleExtra.getString("extra_new_intent_dh_groupid");
            }
            this.u = intent.getStringExtra("square_tab");
            int intExtra = intent.getIntExtra("from", 0);
            SquareTabFragment squareTabFragment = this.I;
            if (squareTabFragment != null) {
                squareTabFragment.a1(intExtra, this.u);
                this.I.Z0(this.u);
                this.u = null;
            }
            String stringExtra2 = intent.getStringExtra("find_friend_tab");
            if (this.J != null) {
                boolean booleanExtra2 = intent.getBooleanExtra("find_friend_open_map", false);
                this.J.K0(intExtra == 81 ? 43 : intExtra);
                this.J.G0(stringExtra2, intExtra, booleanExtra2, intent.getIntExtra("find_friend_popType_map", 0), intent.getIntExtra("type", 0));
                if (intent.getBooleanExtra("find_friend_refund_super_result", false)) {
                    int intExtra2 = intent.getIntExtra("find_friend_refund_super_from", 0);
                    int intExtra3 = intent.getIntExtra("find_friend_refund_super_scene", 0);
                    boolean booleanExtra3 = intent.getBooleanExtra("find_friend_refund_super_deep", false);
                    LogUtil.d("RefundManager", "obtainIntent superFrom " + intExtra2 + " superScene " + intExtra3 + " superDeep " + booleanExtra3);
                    com.zenmen.palmchat.paidservices.superexpose.a.b().g(this.J.getActivity(), intExtra3, intExtra2, booleanExtra3);
                }
            }
            String stringExtra3 = intent.getStringExtra("thread_sub_tab");
            this.n0 = stringExtra3;
            if (stringExtra3 != null && (threadsNewFragment = this.H) != null) {
                threadsNewFragment.M0(stringExtra3);
            }
            MainTabsViewPager mainTabsViewPager = this.q;
            if (mainTabsViewPager != null) {
                mainTabsViewPager.post(new e0(booleanExtra, stringExtra));
            }
            if (!this.s) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("share_images");
                ChatItem chatItemConvert2ContactOrGroupChatInfo = (ChatItem) intent.getParcelableExtra("share_chat_item");
                if (parcelableArrayListExtra != null && chatItemConvert2ContactOrGroupChatInfo != null) {
                    this.N.clear();
                    this.O.clear();
                    if (chatItemConvert2ContactOrGroupChatInfo instanceof ThreadChatItem) {
                        chatItemConvert2ContactOrGroupChatInfo = ((ThreadChatItem) chatItemConvert2ContactOrGroupChatInfo).convert2ContactOrGroupChatInfo();
                    }
                    this.l0 = chatItemConvert2ContactOrGroupChatInfo;
                    this.j0 = chatItemConvert2ContactOrGroupChatInfo.getChatId();
                    this.k0 = chatItemConvert2ContactOrGroupChatInfo.getChatType();
                    this.m0.clear();
                    int i2 = 0;
                    while (i2 < parcelableArrayListExtra.size()) {
                        ((MessageVo) parcelableArrayListExtra.get(i2)).mid = xn3.a();
                        int i3 = i2 + 1;
                        this.m0.put(i3, ((MessageVo) parcelableArrayListExtra.get(i2)).mid);
                        this.N.add(((MessageVo) parcelableArrayListExtra.get(i2)).mid);
                        this.O.add((MessageVo) parcelableArrayListExtra.get(i2));
                        i2 = i3;
                    }
                    V2();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("messages", this.N);
                    getLoaderManager().destroyLoader(0);
                    UI.c(this, 0, bundle, this);
                    while (this.m0.size() != 0) {
                        if (U2(chatItemConvert2ContactOrGroupChatInfo.getChatId(), this.m0.valueAt(0), chatItemConvert2ContactOrGroupChatInfo.getChatType(), (MessageVo) parcelableArrayListExtra.get(0))) {
                            return;
                        } else {
                            this.m0.removeAt(0);
                        }
                    }
                    f3(true, 0, 0);
                    return;
                }
                Uri data = intent.getData();
                if (data != null && AccountUtils.r(this)) {
                    t56.a(this, data);
                }
            }
            this.f0 = (ShareSmsBean) intent.getParcelableExtra("share_sms");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void P2(int i2, boolean z2) {
        D2(i2);
        this.q.setCurrentItem(i2, false);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: Q2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 0 || cursor == null) {
            return;
        }
        this.r0.clear();
        while (cursor.moveToNext()) {
            this.r0.add(MessageVo.buildFromCursor(cursor));
        }
        e3(this.r0);
    }

    public final void R2(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_contact) {
            ip3.c("pagemsg_myfriend");
            h3();
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "21", "1", null, null);
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_app_21", null, null);
            Intent intent = new Intent(this, (Class<?>) ContactActivity.class);
            k86.X(intent);
            startActivity(intent);
            return;
        }
        if (itemId == R.id.menu_more) {
            LogUtil.onClickEvent("WKDL4", null, null);
            d3();
        } else {
            if (itemId != R.id.menu_search) {
                return;
            }
            LogUtil.uploadInfoImmediate("search_more_new", "1", null, null);
            Intent intent2 = new Intent(this, (Class<?>) SearchContentActivity.class);
            k86.X(intent2);
            startActivity(intent2);
        }
    }

    public final void S2(int i2) {
        boolean z2;
        this.v.setIndex(i2);
        this.z.setVisibility(8);
        String strD2 = D2(i2);
        if ("tab_msg".equals(strD2)) {
            if (this.n0 != null) {
                this.n0 = null;
                z2 = true;
            } else {
                z2 = false;
            }
            ch.s().k0(z2);
            this.g0 = null;
            o3();
        } else if ("tab_mine".equals(strD2) || "tab_square".equals(strD2) || "tab_find_friend".equals(strD2) || "tab_people_match".equals(strD2)) {
            this.z.setVisibility(8);
        }
        X2(i2);
        AppLifeCircleManager.getInstance().getSessionStorageManager().e("MainTabsActivity_" + z0);
        rv1.j(strD2, "tab_find_friend");
    }

    public final void T2(TabItem tabItem, int i2, boolean z2) {
        if (tabItem != null && !TextUtils.isEmpty(tabItem.appId)) {
            f84.e(ah.c(tabItem.appId, String.valueOf(i2)), "click");
        }
        if (tabItem == null || !tabItem.isAdditionalTab()) {
            P2(i2, z2);
            if (tabItem != null) {
                vt2.f(this, tabItem.tag);
            }
            m3(true);
            ec3.j().y(this, "update_type_maintab_select");
        } else if (tabItem.isDirectJumpTab()) {
            tabItem.jump();
            String str = tabItem.tag;
            if (str != null && str.equals("tab_square_publish")) {
                ip3.c("pagepost");
                SquareTabFragment squareTabFragment = this.I;
                if (squareTabFragment != null) {
                    squareTabFragment.Q0();
                    SquarePublishActivity.D0 = 2;
                }
            }
        } else if (tabItem.isVideoTab() && wt2.c()) {
            vt2.f(this, tabItem.tag);
            Bundle bundle = new Bundle();
            bundle.putString("source_tab_tag", tabItem.tag);
            bundle.putString("source_page_tag", tabItem.tag);
            vt2.e(this, bundle, false);
        }
        if (com.zenmen.palmchat.smallvideo.a.a()) {
            AppLifeCircleManager.getInstance().getSessionStorageManager().e("MainTabsActivity_tab_small_video");
        }
        if (tabItem != null) {
            ch.s().Q(tabItem.tag);
        }
    }

    public final boolean U2(String str, String str2, int i2, MessageVo messageVo) {
        if (TextUtils.isEmpty(str) || messageVo == null) {
            return false;
        }
        if (i2 == 1) {
            str = str + "@muc.youni";
        }
        String str3 = str;
        try {
            if (!messageVo.isSend || !TextUtils.isEmpty(messageVo.data2)) {
                String str4 = messageVo.data5;
                getMessagingServiceInterface().r(MessageVo.buildForwardImageMessage(str2, str3, messageVo.data1, messageVo.data3, messageVo.data2, messageVo.data4, 0, messageVo.text, str4 != null && str4.equals(String.valueOf(1))));
            } else {
                if (!new File(messageVo.data1).exists()) {
                    sy5.e(AppContext.getContext(), R.string.send_image_file_delete, 0).g();
                    return false;
                }
                PhotoObject photoObject = new PhotoObject();
                photoObject.path = messageVo.data1;
                MessageVo messageVoBuildImageMessage = MessageVo.buildImageMessage(str2, str3, photoObject, false, 0, messageVo.data4 != null ? new JSONObject(messageVo.data4).optString(az.at) : null);
                messageVoBuildImageMessage.extention = messageVo.extention;
                messageVoBuildImageMessage.data5 = messageVo.data5;
                ch.s().u().r(messageVoBuildImageMessage);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(A0, 3, new f0(), e2);
        }
        return true;
    }

    public final void V2() {
        this.v0 = null;
        this.w0 = null;
        this.s0 = 0;
        this.t0 = false;
        this.u0 = true;
        this.s = false;
    }

    public final void W2() {
        LogUtil.i(A0, "sendEvaluateOkToServer");
        zm1 zm1Var = new zm1();
        this.R = zm1Var;
        try {
            zm1Var.n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void X2(int i2) {
        SquareTabFragment squareTabFragment;
        String strD2 = D2(i2);
        z0 = strD2;
        if (!this.U || !"tab_msg".equals(strD2)) {
            this.Y.i();
        } else if (jo6.D()) {
            this.Y.m();
        } else {
            this.Y.v();
        }
        if ("tab_msg".equals(z0)) {
            LogUtil.onClickEvent("1", null, null);
            zn6.d("lx_client_app_1", null, null);
            zn6.d("lx_group_message_tab_show", null, null);
        } else if ("tab_discover".equals(z0) || "tab_dynamic_1".equals(z0)) {
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_app_3", null, x63.g().toString());
            dg2.f().i();
        } else if ("tab_mine".equals(z0)) {
            LogUtil.onClickEvent("4", null, null);
            zn6.d("lx_client_app_4", null, null);
        }
        if ("tab_msg".equals(z0)) {
            ThreadsNewFragment threadsNewFragment = this.H;
            if (threadsNewFragment != null) {
                threadsNewFragment.K0();
            }
        } else if ("tab_square".equals(z0) && (squareTabFragment = this.I) != null) {
            squareTabFragment.V0();
        }
        if (this.U) {
            i3(null);
            this.P.h();
        }
        k3();
    }

    public final void Y2(String str) {
        T2(E2(str), A2(str), false);
    }

    public final void Z2() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_app_evaluate_guide, (ViewGroup) null);
        MaterialDialog materialDialogE = new sd3(this).p(viewInflate, false).e();
        materialDialogE.setCanceledOnTouchOutside(false);
        viewInflate.findViewById(R.id.item_ok).setOnClickListener(new u(materialDialogE));
        viewInflate.findViewById(R.id.item_cancel).setOnClickListener(new w(materialDialogE));
        materialDialogE.show();
        qg.d();
        LogUtil.uploadInfoImmediate(this.j0, "res7710", null, null, null);
        zn6.e(this.j0, "lx_client_app_res7710", null, null);
    }

    public final void a3() {
        MaterialDialog materialDialogE = new sd3(this).T(R.string.string_share_tip).j(R.string.string_share_give_up_images).K(R.string.string_share_no).O(R.string.string_share_yes).h(false).f(new m()).e();
        this.w0 = materialDialogE;
        materialDialogE.setCanceledOnTouchOutside(false);
        this.w0.show();
    }

    public final void b3(ConfirmGBBean confirmGBBean) {
        if (isFinishing() || confirmGBBean == null || !confirmGBBean.defaultSex) {
            return;
        }
        new dm0(this).o();
    }

    public final void c3(fz4 fz4Var) {
        if (this.i0 == null) {
            this.i0 = new dc3(this);
        }
        this.i0.h(fz4Var);
    }

    public void d3() {
        this.M.d(this, this.q, new String[]{"我的朋友", getString(R.string.main_menu_add), "搜索", getString(R.string.main_menu_scan), getString(R.string.main_menu_help)}, new int[]{R.drawable.icon_menu_my_friend, R.drawable.icon_menu_add, R.drawable.icon_menu_main_search, R.drawable.icon_menu_sys, R.drawable.icon_menu_help}, this.q0, this.o0, true);
    }

    public final void e3(List<MessageVo> list) {
        if (this.m0.size() <= 0) {
            LogUtil.i(A0, "over");
            return;
        }
        int iKeyAt = this.m0.keyAt(0);
        String str = this.m0.get(iKeyAt);
        for (MessageVo messageVo : list) {
            if (messageVo.mid.equals(str)) {
                String str2 = A0;
                LogUtil.i(str2, "index:" + iKeyAt + ", progress:" + messageVo.sendingProgress + ", state:" + messageVo.status);
                f3(false, iKeyAt, messageVo.sendingProgress);
                if (messageVo.status != 1) {
                    this.m0.remove(iKeyAt);
                    if (this.m0.size() != 0) {
                        while (this.m0.size() != 0) {
                            SparseArray<String> sparseArray = this.m0;
                            String str3 = sparseArray.get(sparseArray.keyAt(0));
                            if (U2(this.j0, str3, this.k0, v2(str3))) {
                                return;
                            } else {
                                this.m0.removeAt(0);
                            }
                        }
                        f3(true, 0, 0);
                        return;
                    }
                    LogUtil.i(str2, "share image over");
                    f3(true, 0, 0);
                } else {
                    continue;
                }
            }
        }
    }

    public final void f3(boolean z2, int i2, int i3) {
        this.s = true;
        if (z2) {
            u2();
            return;
        }
        StringBuilder sb = new StringBuilder(getString(R.string.string_share_content));
        sb.append("(");
        sb.append(i2);
        sb.append("/");
        sb.append(this.O.size());
        sb.append("):");
        sb.append(i3);
        sb.append("%");
        MaterialDialog materialDialog = this.v0;
        if (materialDialog != null) {
            materialDialog.s(sb);
            return;
        }
        MaterialDialog materialDialogE = new sd3(this).T(R.string.string_share_tip).k(sb).O(R.string.string_share_cancel).h(false).f(new l()).e();
        this.v0 = materialDialogE;
        materialDialogE.setCanceledOnTouchOutside(false);
        this.v0.show();
    }

    public final void g3() {
        LogUtil.uploadInfoImmediate("top_scan", "1", null, null);
        if (com.zenmen.palmchat.videocall.c.f()) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) ScannerActivity.class));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 0;
    }

    public final void h3() {
        if (this.B == null) {
            return;
        }
        int iA = (!tn0.i().t() && tn0.i().w()) ? 0 : gu4.a();
        LogUtil.d(A0, "updateContactRedDot:" + iA);
        if (iA > 0) {
            this.B.setVisibility(0);
            this.B.setText(w2(this, iA));
            this.y0 = iA;
        } else {
            this.B.setVisibility(8);
            this.y0 = 0;
        }
        p3(null);
    }

    public void i3(String str) {
        String strY2 = y2();
        String str2 = ad1.d;
        if (strY2.equals("tab_msg")) {
            str2 = ad1.d;
        } else if (strY2.equals("tab_discover") || strY2.equals("tab_dynamic_1")) {
            str2 = ad1.f;
        } else if (strY2.equals("tab_mine")) {
            str2 = ad1.h;
        } else if (strY2.equals("tab_square")) {
            str2 = ad1.j;
        } else if (strY2.equals("tab_find_friend")) {
            str2 = ad1.g;
        } else if (strY2.equals("tab_people_match")) {
            return;
        }
        if (str == null || ad1.j(str2, str)) {
            ad1.h().m(str2, this);
        }
    }

    public void j3(String str) {
        this.q.setCurrentItem(A2(str), false);
    }

    public final void k3() {
        MenuItem menuItem = this.E;
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
        MenuItem menuItem2 = this.F;
        if (menuItem2 != null) {
            menuItem2.setVisible(true);
        }
        MenuItem menuItem3 = this.C;
        if (menuItem3 != null) {
            menuItem3.setVisible("tab_msg".equals(z0));
        }
    }

    public final void l3() {
        ImageView imageView;
        Toolbar toolbar = this.z;
        if (toolbar == null || (imageView = (ImageView) toolbar.findViewById(R.id.young_protect_icon)) == null) {
            return;
        }
        if (TeenagersModeManager.a().d()) {
            imageView.setVisibility(0);
            TextView textView = this.A;
            if (textView != null) {
                textView.setMaxWidth(me1.b(this, 150));
                return;
            }
            return;
        }
        imageView.setVisibility(8);
        TextView textView2 = this.A;
        if (textView2 != null) {
            textView2.setMaxWidth(me1.b(this, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN));
        }
    }

    public void m3(boolean z2) {
        List<TabItem> listC = ec3.j().c(this.X, z2);
        if (listC != null) {
            LogUtil.uploadInfoImmediate("tab_refresh", null);
            this.v.updateItems(listC);
            G2(this.v.getTabsBarItemView("tab_msg"));
            K2(this.v.getTabsBarItemView("tab_square"));
            H2(this.v.getTabsBarItemView("tab_find_friend"));
            this.r.h(listC);
            this.q.setOffscreenPageLimit(8);
            this.v.setIndex(this.q.getCurrentItem());
            ds0.a().b(CellUpdateEvent.produceEvent(0, listC));
            try {
                S2(this.q.getCurrentItem());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            p3(null);
            o3();
        }
        this.X = false;
    }

    public final void n2() {
        LogUtil.d("ClearAd", "clearCacheAd MainTabsActivity adDestroy");
        if (!b6.d()) {
            jp3.g();
            uv3.k();
            ao6.f();
            wh5.t();
            if (b6.q) {
                SPCacheManager.INSTANCE.getAllCacheAd().clear();
            }
            SPCacheManager.INSTANCE.getAllShowAd().clear();
            WifiNestAd.INSTANCE.onDestroy();
            return;
        }
        b6.f1653a = b6.e("MainTabsActivity");
        LogUtil.d("ClearAd", "clearCacheAd MainTabsActivity adDestroy mainTabLowOom " + b6.f1653a);
        jp3.g();
        uv3.k();
        ao6.f();
        wh5.t();
        qv1.i();
        if (b6.q || b6.f1653a) {
            SPCacheManager.INSTANCE.getAllCacheAd().clear();
        }
        SPCacheManager.INSTANCE.getAllShowAd().clear();
        WifiNestAd.INSTANCE.onDestroy();
        b6.f1653a = false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public boolean needCheckStorage() {
        return true;
    }

    public final void o2() {
        ArrayList<TabItem> arrayList = this.v.mTabs;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (TabItem tabItem : arrayList) {
            if (tabItem != null && tabItem.isAdditionalTab() && tabItem.isSquarePublishTab()) {
                ip3.d("pagepost");
                return;
            }
        }
    }

    public final void o3() {
        os5 os5VarC2 = C2("tab_msg");
        if (os5VarC2 != null) {
            os5VarC2.e(this.g0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 101) {
            W2();
            LogUtil.uploadInfoImmediate(this.j0, "res7712", "1", "1", null);
            zn6.e(this.j0, "lx_client_app_res7712", "1", null);
        } else if (i2 == 1688) {
            qq2.h(i2, i3, intent, 1);
        } else {
            super.onActivityResult(i2, i3, intent);
        }
        NewMineFragment newMineFragment = this.K;
        if (newMineFragment != null) {
            newMineFragment.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean zA = com.zenmen.palmchat.smallvideo.a.a();
        if (!z0.equals("tab_msg") || zA) {
            P2(0, zA);
            return;
        }
        if (SAppUtil.a.b() && e9.d().t(this.sInstance)) {
            return;
        }
        if (!k86.M()) {
            N2();
        } else {
            super.onBackPressed();
            LogUtil.i(A0, "onBackPressed");
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        List<Fragment> fragments;
        ma3.a("dddd".split(",")[0], new Object[0]);
        this.Z.p();
        super.onCreate(bundle);
        LogUtil.i(A0, "onCreate");
        if (getWindow() != null && getWindow().getDecorView() != null) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 256);
        }
        pe5.a().h();
        J2();
        setContentView(R.layout.layout_activity_main_tabs);
        SeeMeManager.c = 0L;
        LogUtil.i("SeeMeManager", "SeeMeManager.lastTime init 0");
        L2();
        this.G = (ColorFilterFrameLayout) findViewById(R.id.rootView);
        TabsBarLayout tabsBarLayout = (TabsBarLayout) findViewById(R.id.tabBar);
        this.v = tabsBarLayout;
        tabsBarLayout.setOnTabSelectListener(new v());
        this.v.setOnTabLongClickListener(new z());
        this.P.f(this);
        this.q = (MainTabsViewPager) findViewById(R.id.view_pager);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null && !fragments.isEmpty()) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof SquareTabFragment) {
                    this.I = (SquareTabFragment) fragment;
                } else if (fragment instanceof FindFriendFragment) {
                    this.J = (FindFriendFragment) fragment;
                }
            }
        }
        this.r = new TabsPagerAdapter(getSupportFragmentManager(), ec3.j().m());
        this.q.setOffscreenPageLimit(8);
        this.q.setAdapter(this.r);
        this.v.updateItems(this.r.f());
        G2(this.v.getTabsBarItemView("tab_msg"));
        K2(this.v.getTabsBarItemView("tab_square"));
        H2(this.v.getTabsBarItemView("tab_find_friend"));
        this.q.setOnPageChangeListener(new a0());
        ds0.a().c(this);
        M2();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction(com.igexin.push.core.b.N);
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        k86.T(this, this.Q, intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.h0, new IntentFilter(mo3.o));
        O2(getIntent());
        ch.s().r().j(this);
        ch.s().v0(true);
        n3();
        zf2.e().a();
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(SqliteRecover.CHECK_DATABASE, true);
        this.V = z2;
        if (z2) {
            new g0(this).execute(new Void[0]);
        }
        TabItem tabItemD = ec3.j().d("tab_find_friend");
        if (tabItemD != null && TabItemsManager.a(tabItemD)) {
            Y2("tab_find_friend");
        } else if (ec3.j().d("tab_square") != null) {
            Y2("tab_square");
        }
        s2();
        new u5(new b0()).d(this);
        I2();
        this.Z.q(this);
        SAppUtil.L(this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        ArrayList<String> stringArrayList;
        if (i2 != 0 || bundle == null || (stringArrayList = bundle.getStringArrayList("messages")) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("packet_id=?");
        if (stringArrayList.size() > 1) {
            for (int i3 = 0; i3 < stringArrayList.size() - 1; i3++) {
                sb.append(" or ");
                sb.append("packet_id=?");
            }
        }
        String[] strArr = new String[stringArrayList.size()];
        for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
            strArr[i4] = stringArrayList.get(i4);
        }
        return new CursorLoader(this, DBUriManager.a(ho3.class, 0), null, sb.toString(), strArr, "date ASC");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_tabs_new, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_more);
        menuItemFindItem.getActionView().setOnClickListener(new d(menuItemFindItem));
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_search);
        this.C = menuItemFindItem2;
        menuItemFindItem2.getActionView().setOnClickListener(new e());
        MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_contact);
        this.E = menuItemFindItem3;
        View actionView = menuItemFindItem3.getActionView();
        actionView.setOnClickListener(new f());
        TextView textView = (TextView) actionView.findViewById(R.id.tv_red_dot);
        this.B = textView;
        textView.setVisibility(8);
        this.B.post(new g());
        this.F = menu.findItem(R.id.menu_more);
        k3();
        pe5.a().j(menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LogUtil.i(A0, "onDestroy");
        ds0.a().d(this);
        getLoaderManager().destroyLoader(0);
        k86.U(this, this.Q);
        ch.s().r().l(this);
        zm1 zm1Var = this.R;
        if (zm1Var != null) {
            zm1Var.onCancel();
        }
        CountDownTimer countDownTimer = this.L;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.h0);
        n2();
        np3.f();
        fo5.h();
        rv1.k();
        ew1.P();
        av4.g();
        o30.u();
        this.P.g();
        dm0.l = false;
        v8.G();
        z64.y();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        showPopupMenu(this, this.q, this.x, this.y, this.p0, null, true);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("force_exit", false);
        String str = A0;
        Log.i(str, "rxx force exit :" + booleanExtra);
        if (booleanExtra) {
            finish();
            System.exit(0);
        }
        LogUtil.i(str, "onNewIntent");
        O2(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        R2(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.Z.r();
        this.M.b(this);
        super.onPause();
        LogUtil.i(A0, "onPause");
        this.U = false;
        bn0.q(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        SquareTabFragment squareTabFragment;
        super.onPermissionGrant(permissionType, permissionUsage, z2);
        if (!permissionUsage.name().equals(BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_GET_LOCATION.name()) || (squareTabFragment = this.I) == null) {
            return;
        }
        squareTabFragment.O0(permissionType, permissionUsage);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i3;
        FindFriendFragment findFriendFragment;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if ((i2 != BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_LOCATION.requestCode && i2 != BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_MAP_SEPARATION_LOCATION.requestCode && i2 != BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_FEED_USER_MAP_LOCATION.requestCode) || !tg4.e(iArr)) {
            if (i2 == BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_ONLINE_LOCATION.requestCode && tg4.e(iArr) && (findFriendFragment = this.J) != null && (findFriendFragment.p0() instanceof OnlineRecommend)) {
                ((OnlineRecommend) this.J.p0()).B1();
                return;
            }
            return;
        }
        FindFriendFragment findFriendFragment2 = this.J;
        if (findFriendFragment2 != null) {
            boolean z2 = true;
            if (i2 == BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_MAP_SEPARATION_LOCATION.requestCode) {
                i3 = 1;
            } else {
                i3 = i2 == BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_FEED_USER_MAP_LOCATION.requestCode ? 8 : 1;
                z2 = false;
            }
            findFriendFragment2.C0(z2, i3);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void onRestart() {
        this.Z.s();
        super.onRestart();
        x6.a().g(this, true);
        LogUtil.i(A0, "onRestart");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MainTabsViewPager mainTabsViewPager;
        this.Z.t();
        super.onResume();
        LogUtil.i(A0, "onResume");
        this.U = true;
        if (ff2.b()) {
            r2(this);
        }
        this.P.i();
        ColorFilterFrameLayout colorFilterFrameLayout = this.G;
        if (colorFilterFrameLayout != null) {
            colorFilterFrameLayout.onResume();
        }
        m3(false);
        h3();
        p3(null);
        i3(null);
        p2();
        zm4.h(this);
        if (!zm4.f()) {
            bn0.f(this, this.x0);
        }
        if (qg.a() && !bn0.l()) {
            q2();
        }
        this.w.postDelayed(new o(), 50L);
        q3();
        if (this.f0 != null && (mainTabsViewPager = this.q) != null) {
            mainTabsViewPager.postDelayed(new p(), 100L);
        }
        o2();
        if (com.zenmen.palmchat.smallvideo.a.a()) {
            AppLifeCircleManager.getInstance().getSessionStorageManager().e("MainTabsActivity_tab_small_video");
        } else {
            AppLifeCircleManager.getInstance().getSessionStorageManager().e("MainTabsActivity_" + z0);
        }
        if (this.t) {
            UserProfileGuide.k(this, 18);
            this.t = false;
        }
        this.Z.u();
        String str = z0;
        if (str != null && str.equals("tab_find_friend")) {
            com.zenmen.palmchat.miniwidget.a.f().d(this);
        }
        String str2 = z0;
        if (str2 != null && str2.equals("tab_msg") && e9.d().a(this) && e9.d().c) {
            b05.a("Activity需要显示弹窗");
            e9.d().s(this.sInstance);
        }
        e9.d().c = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            try {
                Object obj = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (obj != null) {
                    ((Bundle) obj).remove("android:support:fragments");
                }
                bundle.remove("android:support:fragments");
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        this.Z.v();
        super.onStart();
        super.bindMessagingService();
        if (!this.e0) {
            x6.a().g(this, false);
        }
        LogUtil.i(A0, "onStart");
        this.Z.w();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        this.w.post(new r(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.Z.x();
        super.onStop();
        super.unBindMessagingService();
        LogUtil.i(A0, "onStop");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
        super.onSupportActionModeStarted(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.Y.n(z2);
        if (z2 && "tab_msg".equals(z0) && !com.zenmen.palmchat.smallvideo.a.a()) {
            if (jo6.D()) {
                this.Y.m();
            } else {
                this.Y.v();
            }
        }
    }

    public final void p2() {
        com.zenmen.palmchat.contacts.recommend.a.b(this);
    }

    public final void p3(Integer num) {
        if (num == null) {
            num = Integer.valueOf(ch.s().B());
        }
        int iIntValue = num.intValue();
        Integer numValueOf = Integer.valueOf(Integer.valueOf(num.intValue() + tn0.i().s()).intValue() + this.y0);
        os5 os5VarC2 = C2("tab_msg");
        if (os5VarC2 != null) {
            if (numValueOf.intValue() > 0) {
                os5VarC2.c(true);
                os5VarC2.b(numValueOf.intValue());
            } else {
                os5VarC2.c(false);
            }
        }
        String strC = nl0.c();
        if (numValueOf.intValue() == 0) {
            if (strC.equals("release")) {
                this.A.setText(getString(R.string.app_name));
            } else if (strC.equals("debug")) {
                this.A.setText(getString(R.string.app_name_test));
            } else if (strC.equals("debug2")) {
                this.A.setText("DEBUG2" + getString(R.string.app_name_test));
            } else if (strC.equals("debug3")) {
                this.A.setText("DEBUG3" + getString(R.string.app_name_test));
            } else {
                this.A.setText(getString(R.string.app_name_dev));
            }
        } else if (strC.equals("release")) {
            this.A.setText(getString(R.string.app_name_unread, numValueOf));
        } else if (strC.equals("debug")) {
            this.A.setText(getString(R.string.app_name_unread_test, numValueOf));
        } else if (strC.equals("debug2")) {
            this.A.setText("DEBUG2" + getString(R.string.app_name_unread_test, numValueOf));
        } else if (strC.equals("debug3")) {
            this.A.setText("DEBUG3" + getString(R.string.app_name_unread_test, numValueOf));
        } else {
            this.A.setText(getString(R.string.app_name_unread_dev, numValueOf));
        }
        ThreadsNewFragment threadsNewFragment = this.H;
        if (threadsNewFragment != null) {
            threadsNewFragment.T0(iIntValue);
        }
    }

    public final void q2() {
        LogUtil.i(A0, "checkEvaluateFromServer");
        this.S = new s();
        this.T = new t();
        zm1 zm1Var = new zm1();
        this.R = zm1Var;
        try {
            zm1Var.o(this.S, this.T);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void q3() {
        try {
            fz4 lastOpenAppInfo = WebAppManager.getInstance().getLastOpenAppInfo();
            if (lastOpenAppInfo != null) {
                c3(lastOpenAppInfo);
            } else {
                F2();
            }
        } catch (Exception e2) {
            ma3.c(e2);
        }
    }

    public void r2(Activity activity) {
        Long l2 = (Long) q05.k("key_api_query_guide_popup", -1L);
        long jD = lj5.c().d();
        if (jD <= -1) {
            b05.d("square.query.guide.popup.v1====》没读到配置");
            lj5.c().e = true;
            return;
        }
        if (System.currentTimeMillis() - l2.longValue() > jD * 1000) {
            b05.d("square.query.guide.popup.v1====》超过间隔时间");
            lj5.c().c = false;
            lj5.c().d = false;
            lj5.c().e = false;
            lj5.c().b = false;
            lj5.c().a(activity, new y(activity));
            return;
        }
        b05.d("square.query.guide.popup.v1====》间隔时间是" + ((System.currentTimeMillis() - l2.longValue()) / 1000) + ",总时间是====》" + jD);
        lj5.c().e = true;
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        if (lb3Var == null) {
            return;
        }
        int iB = lb3Var.b();
        if (iB == 1 || iB == 2) {
            d20.m(true);
        }
    }

    public final void s2() {
        if (jo6.G() && !"tab_msg".equals(z0)) {
            String strC = cx5.b().c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            this.g0 = strC;
            o3();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showPermissionDenyDialog(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        FindFriendFragment findFriendFragment;
        FindFriendFragment findFriendFragment2;
        SquareTabFragment squareTabFragment;
        if (permissionType.requestCode == 1007 && permissionType.name().equals(BaseActivityPermissionDispatcher.PermissionType.SQUARE_LOCATION.name()) && (squareTabFragment = this.I) != null) {
            squareTabFragment.W(permissionType, permissionUsage);
            return;
        }
        if (permissionType.requestCode == 1008 && permissionType.name().equals(BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_LOCATION.name()) && (findFriendFragment2 = this.J) != null) {
            findFriendFragment2.N0(permissionType, permissionUsage);
        } else if (permissionType.requestCode == 1009 && permissionType.name().equals(BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_LOCATION.name()) && (findFriendFragment = this.J) != null) {
            findFriendFragment.N0(permissionType, permissionUsage);
        } else {
            super.showPermissionDenyDialog(permissionType, permissionUsage);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        this.e0 = true;
    }

    public final void t2(String str) {
        try {
            getMessagingServiceInterface().s(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(A0, 3, new n(), e2);
        }
        com.zenmen.palmchat.database.b.i(str, this.l0);
    }

    public final void u2() {
        getLoaderManager().destroyLoader(0);
        MaterialDialog materialDialog = this.v0;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
        MaterialDialog materialDialog2 = this.w0;
        if (materialDialog2 != null) {
            materialDialog2.dismiss();
        }
        if (this.l0 != null) {
            Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", this.l0);
            k86.X(intent);
            startActivity(intent);
            this.l0 = null;
        }
        V2();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.U) {
            p2();
        }
    }

    public final MessageVo v2(String str) {
        for (MessageVo messageVo : this.O) {
            if (messageVo.mid.equals(str)) {
                return messageVo;
            }
        }
        return null;
    }

    public MaterialDialog z2() {
        if (this.W == null) {
            this.W = new sd3(this).j(R.string.database_recovery_dialog_content).K(R.string.database_recovery_dialog_button_not_fix).O(R.string.database_recovery_dialog_button_fix).h(false).f(new x()).e();
        }
        return this.W;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements ViewPager.OnPageChangeListener {
        public a0() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            MainTabsActivity.this.S2(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements bn0.q {
        public q() {
        }

        @Override // bn0.q
        public void a(boolean z) {
        }
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public final void M2() {
    }

    public final void n3() {
    }
}
