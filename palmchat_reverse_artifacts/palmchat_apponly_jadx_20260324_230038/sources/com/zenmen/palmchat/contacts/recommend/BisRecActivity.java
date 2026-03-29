package com.zenmen.palmchat.contacts.recommend;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.UI;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.f7;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.ih;
import defpackage.iq5;
import defpackage.l50;
import defpackage.m66;
import defpackage.on0;
import defpackage.pm2;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.vn0;
import defpackage.wh4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BisRecActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public i q;
    public f7 r;
    public ContactRequestsVO s;
    public ih t;
    public h u = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.onImmediateClickEvent("2012", null, null);
            Intent intentA = on0.a("");
            intentA.putExtra("from", "pop_page");
            BisRecActivity.this.startActivity(intentA);
            BisRecActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactRequestsVO contactRequestsVO;
            if (l50.a() || (contactRequestsVO = (ContactRequestsVO) adapterView.getItemAtPosition(i)) == null) {
                return;
            }
            String str = contactRequestsVO.requestRid;
            ContactInfoItem contactInfoItemConvert2ContactInfoItem = contactRequestsVO.convert2ContactInfoItem();
            rn0.r(contactInfoItemConvert2ContactInfoItem.getUid());
            Intent intent = new Intent(BisRecActivity.this, (Class<?>) m66.c());
            intent.putExtra("user_item_info", contactInfoItemConvert2ContactInfoItem);
            intent.putExtra("from", 24);
            intent.putExtra("rid", str);
            BisRecActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements h {
        public c() {
        }

        @Override // com.zenmen.palmchat.contacts.recommend.BisRecActivity.h
        public void a(ContactRequestsVO contactRequestsVO) {
            BisRecActivity.this.s = contactRequestsVO;
            BisRecActivity.this.q.c(contactRequestsVO.fromUid, 2L);
            BisRecActivity.this.q.notifyDataSetChanged();
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(BisRecActivity.this, R.string.contact_add_friend_unable, 1).g();
            } else {
                BisRecActivity bisRecActivity = BisRecActivity.this;
                bisRecActivity.E1(bisRecActivity.s);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestsVO f13616a;
        public final /* synthetic */ ContactRequestArgs b;

        public d(ContactRequestsVO contactRequestsVO, ContactRequestArgs contactRequestArgs) {
            this.f13616a = contactRequestsVO;
            this.b = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                BisRecActivity.this.hideBaseProgressBar();
                BisRecActivity.this.q.c(this.f13616a.fromUid, 1L);
                BisRecActivity.this.q.notifyDataSetChanged();
                wh4.d(BisRecActivity.this.s.fromUid, BisRecActivity.this.s.requestType);
                iq5.j(false, new String[0]);
                return;
            }
            if (iOptInt == 1) {
                BisRecActivity.this.F1(this.f13616a.fromUid, this.b);
                return;
            }
            if (iOptInt == 1318) {
                BisRecActivity.this.hideBaseProgressBar();
                sy5.e(BisRecActivity.this, R.string.send_refuse, 1).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                BisRecActivity.this.hideBaseProgressBar();
                rx4.b(BisRecActivity.this, jSONObject);
            } else {
                BisRecActivity.this.hideBaseProgressBar();
                sy5.f(BisRecActivity.this, rx4.a(jSONObject), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            BisRecActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            BisRecActivity.this.hideBaseProgressBar();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13619a;

        public g(String str) {
            this.f13619a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            BisRecActivity.this.hideBaseProgressBar();
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                BisRecActivity.this.q.c(this.f13619a, 2L);
                BisRecActivity.this.q.notifyDataSetChanged();
                wh4.d(BisRecActivity.this.s.fromUid, BisRecActivity.this.s.requestType);
                iq5.j(false, new String[0]);
                return;
            }
            if (iOptInt == 1318) {
                return;
            }
            if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(BisRecActivity.this, jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(ContactRequestsVO contactRequestsVO);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends BaseAdapter {
        public LayoutInflater b;
        public Context c;
        public h d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ContactRequestsVO> f13620a = new ArrayList();
        public HashMap<String, Long> e = new HashMap<>();

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactRequestsVO f13621a;

            public a(ContactRequestsVO contactRequestsVO) {
                this.f13621a = contactRequestsVO;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.d.a(this.f13621a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public SocialPortraitView f13622a;
            public TextView b;
            public TextView c;
            public TextView d;
            public View e;
            public View f;
            public TextView g;

            public b() {
            }
        }

        public i(Context context, h hVar) {
            this.c = context;
            this.b = LayoutInflater.from(context);
            this.d = hVar;
        }

        public final String b(String str, String str2) {
            ContactInfoItem contactInfoItemL = bo0.r().l(str);
            return contactInfoItemL != null ? contactInfoItemL.getIconURL() : str2;
        }

        public void c(String str, long j) {
            this.e.put(str, Long.valueOf(j));
        }

        public void e(ArrayList<ContactRequestsVO> arrayList) {
            if (arrayList != null) {
                this.f13620a.clear();
                this.f13620a.addAll(arrayList);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f13620a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f13620a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f13620a.get(i).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = this.b.inflate(R.layout.list_item_recommend, (ViewGroup) null);
                bVar = new b();
                SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.portrait);
                bVar.f13622a = socialPortraitView;
                socialPortraitView.changeShapeType(3);
                bVar.b = (TextView) view.findViewById(R.id.name);
                bVar.c = (TextView) view.findViewById(R.id.nick_name_phone);
                bVar.d = (TextView) view.findViewById(R.id.confirm_button);
                bVar.e = view.findViewById(R.id.divider);
                bVar.f = view.findViewById(R.id.view_title);
                bVar.g = (TextView) view.findViewById(R.id.tv_title);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ContactRequestsVO contactRequestsVO = this.f13620a.get(i);
            if (i == 0) {
                bVar.f.setVisibility(0);
            } else {
                bVar.f.setVisibility(8);
            }
            bVar.g.setText(com.zenmen.palmchat.contacts.recommend.a.a().a());
            String strB = b(contactRequestsVO.fromUid, contactRequestsVO.fromHeadIcon);
            if (TextUtils.isEmpty(strB)) {
                gr2.j().c(bVar.f13622a);
                bVar.f13622a.setImageResource(R.drawable.default_portrait);
            } else {
                gr2.j().h(strB, bVar.f13622a, bq6.s());
            }
            bVar.b.setText(contactRequestsVO.fromNickName);
            bVar.c.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            bVar.c.setText(contactRequestsVO.recommendText);
            bVar.d.setVisibility(0);
            if (bo0.r().w(contactRequestsVO.fromUid)) {
                bVar.d.setEnabled(false);
                bVar.d.setText(R.string.contact_already_friend);
            } else {
                long jLongValue = this.e.containsKey(contactRequestsVO.fromUid) ? this.e.get(contactRequestsVO.fromUid).longValue() : 0L;
                if (jLongValue == 2) {
                    bVar.d.setEnabled(false);
                    bVar.d.setText(R.string.contact_friend_wait_confirm);
                } else if (jLongValue == 1) {
                    bVar.d.setEnabled(false);
                    bVar.d.setText(R.string.contact_already_friend);
                } else {
                    bVar.d.setEnabled(true);
                    bVar.d.setText(R.string.contact_add_friend);
                }
            }
            bVar.d.setOnClickListener(new a(contactRequestsVO));
            if (i == getCount() - 1) {
                bVar.e.setVisibility(8);
            } else {
                bVar.e.setVisibility(8);
            }
            return view;
        }
    }

    public void E1(ContactRequestsVO contactRequestsVO) {
        if (contactRequestsVO == null) {
            return;
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.b(contactRequestsVO)).i(String.valueOf(23)).j(String.valueOf(1)).a();
        f7 f7Var = new f7(new d(contactRequestsVO, contactRequestArgsA), new e());
        this.r = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void F1(String str, ContactRequestArgs contactRequestArgs) {
        f fVar = new f();
        g gVar = new g(str);
        if (this.t == null) {
            this.t = new ih(gVar, fVar);
        }
        try {
            this.t.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void G1() {
        setSupportActionBar(initToolbar("好友推荐"));
    }

    public final void H1() {
        ((TextView) findViewById(R.id.tv_title)).setText(com.zenmen.palmchat.contacts.recommend.a.a().c());
        TextView textView = (TextView) findViewById(R.id.btn_ok);
        textView.setText(com.zenmen.palmchat.contacts.recommend.a.a().b());
        textView.setOnClickListener(new a());
        this.q = new i(this, this.u);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.q);
        listView.setOnItemClickListener(new b());
        LogUtil.onImmediateClickEvent("2011", null, null);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 3 || cursor == null) {
            return;
        }
        this.q.e(ContactRequestsVO.buildFromCursorForShow(cursor));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bis_rec);
        G1();
        H1();
        UI.c(this, 3, null, this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        if (i2 != 3) {
            return null;
        }
        return new CursorLoader(this, vn0.f21483a, null, "request_type = ?", new String[]{Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR)}, "_id DESC");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
