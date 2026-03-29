package defpackage;

import android.content.ContentValues;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.RecommendRequestSendActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class sm1 extends BaseAdapter {
    public static final String f = "sm1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameworkBaseActivity f20779a;
    public LayoutInflater b;
    public ArrayList<ContactRequestsVO> c = new ArrayList<>();
    public f7 d;
    public ih e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20780a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ ContactRequestsVO c;

        public a(String str, ContactInfoItem contactInfoItem, ContactRequestsVO contactRequestsVO) {
            this.f20780a = str;
            this.b = contactInfoItem;
            this.c = contactRequestsVO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!jo6.r()) {
                sm1.this.f(this.f20780a, false, this.b, this.c.sourceType);
                return;
            }
            Intent intent = new Intent(sm1.this.f20779a, (Class<?>) RecommendRequestSendActivity.class);
            intent.putExtra("uid_key", this.f20780a);
            intent.putExtra("user_item_info_key", this.b);
            intent.putExtra("source_type_key", this.c.sourceType);
            intent.putExtra("real_name", this.c.realName);
            intent.putExtra("subtype_key", 95);
            intent.putExtra("send_from_type", 12);
            sm1.this.f20779a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f20781a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ContactRequestArgs e;

        public b(ContactInfoItem contactInfoItem, String str, boolean z, int i, ContactRequestArgs contactRequestArgs) {
            this.f20781a = contactInfoItem;
            this.b = str;
            this.c = z;
            this.d = i;
            this.e = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                sm1.this.f20779a.hideBaseProgressBar();
                wh4.h(this.f20781a);
                iq5.j(false, new String[0]);
            } else {
                if (iOptInt == 1) {
                    sm1.this.g(this.b, this.c, this.f20781a, this.d, this.e);
                    return;
                }
                if (iOptInt == 1318) {
                    sm1.this.f20779a.hideBaseProgressBar();
                    sy5.e(sm1.this.f20779a, R.string.send_refuse, 1).g();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    sm1.this.f20779a.hideBaseProgressBar();
                    rx4.b(sm1.this.f20779a, jSONObject);
                } else {
                    sm1.this.f20779a.hideBaseProgressBar();
                    sy5.f(sm1.this.f20779a, rx4.a(jSONObject), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            sm1.this.f20779a.hideBaseProgressBar();
            new sd3(sm1.this.f20779a).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            sm1.this.f20779a.hideBaseProgressBar();
            LogUtil.d(sm1.f, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20784a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactInfoItem c;

        public e(boolean z, String str, ContactInfoItem contactInfoItem) {
            this.f20784a = z;
            this.b = str;
            this.c = contactInfoItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            sm1.this.f20779a.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(sm1.this.f20779a, jSONObject);
                    return;
                } else {
                    if (iOptInt == -1) {
                        sy5.e(sm1.this.f20779a, R.string.send_failed, 0).g();
                        return;
                    }
                    return;
                }
            }
            if (this.f20784a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + this.b);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{this.b});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{this.b});
            }
            wh4.h(this.c);
            rn0.r(this.b);
            wh4.d(this.b, this.c.getRequestType());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EffectiveShapeView f20785a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;

        public static f a(View view) {
            f fVar = new f();
            fVar.f20785a = (EffectiveShapeView) view.findViewById(R.id.portrait);
            fVar.b = (TextView) view.findViewById(R.id.friend_name);
            fVar.c = (TextView) view.findViewById(R.id.recommend_hint_text_view);
            fVar.d = (TextView) view.findViewById(R.id.apply_button);
            fVar.e = (TextView) view.findViewById(R.id.wait_for_verify_hint);
            return fVar;
        }
    }

    public sm1(FrameworkBaseActivity frameworkBaseActivity) {
        this.f20779a = frameworkBaseActivity;
        this.b = LayoutInflater.from(frameworkBaseActivity);
    }

    public final void f(String str, boolean z, ContactInfoItem contactInfoItem, int i) {
        if (str == null) {
            return;
        }
        String strM = "";
        if (jo6.i() && io0.t(i) && !TextUtils.isEmpty(contactInfoItem.getIdentifyCode())) {
            ContactInfoItem contactInfoItemL = bo0.r().l(str);
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(contactInfoItem.getIdentifyCode());
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(contactInfoItem)).i(String.valueOf(i)).j(String.valueOf(95)).g(strM).a();
        f7 f7Var = new f7(new b(contactInfoItem, str, z, i, contactRequestArgsA), new c());
        this.d = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            this.f20779a.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void g(String str, boolean z, ContactInfoItem contactInfoItem, int i, ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(new e(z, str, contactInfoItem), new d());
        this.e = ihVar;
        try {
            ihVar.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVarA;
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_enhance_recommend, (ViewGroup) null, false);
            fVarA = f.a(view);
            view.setTag(fVarA);
        } else {
            fVarA = (f) view.getTag();
        }
        h(fVarA, i);
        return view;
    }

    public void h(f fVar, int i) {
        ContactRequestsVO contactRequestsVO = this.c.get(i);
        String str = contactRequestsVO.requestInfo;
        String strJ = j(contactRequestsVO.fromUid, contactRequestsVO.fromHeadIcon);
        String str2 = contactRequestsVO.fromUid;
        ContactInfoItem contactInfoItemConvert2ContactInfoItem = contactRequestsVO.convert2ContactInfoItem();
        if (TextUtils.isEmpty(strJ)) {
            fVar.f20785a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(strJ, fVar.f20785a, bq6.s());
        }
        fVar.f20785a.changeShapeType(3);
        fVar.f20785a.setDegreeForRoundRectangle(13, 13);
        if (bo0.r().w(str2)) {
            fVar.d.setEnabled(false);
            fVar.d.setText(R.string.contact_already_friend);
        } else if (contactRequestsVO.acceptStatus == 2) {
            fVar.d.setVisibility(4);
            fVar.e.setVisibility(0);
        } else {
            fVar.d.setVisibility(0);
            fVar.e.setVisibility(4);
            fVar.d.setEnabled(true);
            fVar.d.setText(R.string.recommend_friend_dialog_message_new_batch_add);
        }
        fVar.b.setText(contactRequestsVO.getFormatShowName());
        fVar.c.setText(contactRequestsVO.recommendText);
        fVar.d.setOnClickListener(new a(str2, contactInfoItemConvert2ContactInfoItem, contactRequestsVO));
    }

    public void i() {
        f7 f7Var = this.d;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.e;
        if (ihVar != null) {
            ihVar.onCancel();
        }
    }

    public final String j(String str, String str2) {
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        return contactInfoItemL != null ? contactInfoItemL.getIconURL() : str2;
    }

    public void l(ArrayList<ContactRequestsVO> arrayList) {
        if (arrayList != null) {
            this.c = arrayList;
            notifyDataSetChanged();
        }
    }
}
