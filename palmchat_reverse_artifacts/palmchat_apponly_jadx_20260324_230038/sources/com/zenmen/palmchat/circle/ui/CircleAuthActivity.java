package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleApplyListItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.BaseViewHolder;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.adapters.EndlessScrollListener;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.j70;
import defpackage.k36;
import defpackage.k80;
import defpackage.k86;
import defpackage.m66;
import defpackage.qa0;
import defpackage.ry5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAuthActivity extends BaseActionBarActivity {
    public RecyclerView q;
    public d s;
    public String t;
    public TextView w;
    public k80 y;
    public EndlessScrollListener z;
    public ArrayList<CircleApplyListItem> r = new ArrayList<>();
    public final int u = 20;
    public int v = 1;
    public boolean x = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<List<CircleApplyListItem>>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleApplyListItem>> baseResponse) {
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleAuthActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleAuthActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
                CircleAuthActivity.this.z.c(CircleAuthActivity.this.v);
                return;
            }
            CircleAuthActivity.this.x = true;
            List<CircleApplyListItem> data = baseResponse.getData();
            if (CircleAuthActivity.this.v == 1) {
                CircleAuthActivity.this.r.clear();
            }
            if (data == null || data.size() == 0) {
                CircleAuthActivity.this.z.a();
                if (CircleAuthActivity.this.v > 1) {
                    return;
                }
            } else {
                CircleAuthActivity.this.r.addAll(data);
            }
            if (CircleAuthActivity.this.v == 1) {
                CircleAuthActivity.this.q.setAdapter(CircleAuthActivity.this.s);
            } else {
                CircleAuthActivity.this.s.notifyDataSetChanged();
            }
            if (CircleAuthActivity.this.r.size() < 20) {
                CircleAuthActivity.this.z.a();
            } else {
                CircleAuthActivity.this.z.b();
            }
            if (CircleAuthActivity.this.r.size() == 0) {
                CircleAuthActivity.this.Q1(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements EndlessScrollListener.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void a(int i) {
            CircleAuthActivity.this.z.a();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void b() {
            if (CircleAuthActivity.this.s != null) {
                CircleAuthActivity.this.s.c();
            }
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void c(int i) {
            CircleAuthActivity.this.v = i;
            CircleAuthActivity.this.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse<CircleApplyListItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13066a;

        public c(int i) {
            this.f13066a = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleApplyListItem> baseResponse) {
            int i;
            CircleAuthActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                CircleApplyListItem data = baseResponse.getData();
                if (data != null) {
                    ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).opTime = data.opTime;
                    ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).opNickName = data.opNickName;
                }
                ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).applyStatus = 1;
                CircleAuthActivity.this.s.notifyItemChanged(this.f13066a);
                return;
            }
            if (baseResponse.getResultCode() == 4006) {
                ry5.a("您已经在群里了");
                ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).applyStatus = 1;
                CircleApplyListItem data2 = baseResponse.getData();
                if (data2 != null) {
                    ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).opTime = data2.opTime;
                    ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).opNickName = data2.opNickName;
                }
                CircleAuthActivity.this.s.notifyItemChanged(this.f13066a);
                return;
            }
            if (CircleAuthActivity.this.y.d(CircleAuthActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            CircleApplyListItem data3 = baseResponse.getData();
            if (data3 != null && ((i = data3.applyStatus) == 3 || i == 4)) {
                ((CircleApplyListItem) CircleAuthActivity.this.r.get(this.f13066a)).applyStatus = data3.applyStatus;
                CircleAuthActivity.this.s.notifyItemChanged(this.f13066a);
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                ry5.a("请求失败");
            } else {
                ry5.a(baseResponse.getErrorMsg());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.Adapter<BaseViewHolder> {
        public boolean e;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends BaseViewHolder {
            public TextView d;
            public ImageView e;
            public TextView f;
            public TextView g;
            public TextView h;
            public TextView i;
            public View j;
            public TextView k;

            /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleAuthActivity$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class ViewOnClickListenerC1009a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CircleApplyListItem f13067a;

                public ViewOnClickListenerC1009a(CircleApplyListItem circleApplyListItem) {
                    this.f13067a = circleApplyListItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CircleAuthActivity circleAuthActivity = CircleAuthActivity.this;
                    CircleApplyListItem circleApplyListItem = this.f13067a;
                    circleAuthActivity.N1(circleApplyListItem.uid, circleApplyListItem.headImgUrl, circleApplyListItem.userName);
                }
            }

            public a(View view) {
                super(view);
                this.d = (TextView) view.findViewById(R.id.list_circle_join_auth_name);
                this.e = (ImageView) view.findViewById(R.id.list_circle_join_auth_cover);
                this.g = (TextView) view.findViewById(R.id.list_circle_join_auth_question);
                this.h = (TextView) view.findViewById(R.id.list_circle_join_auth_answer);
                this.i = (TextView) view.findViewById(R.id.tv_deal_tip);
                this.f = (TextView) view.findViewById(R.id.list_circle_join_auth_agree);
                this.j = view.findViewById(R.id.vw_line);
                this.k = (TextView) view.findViewById(R.id.list_circle_join_auth_agree_verify_fail);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void o(CircleApplyListItem circleApplyListItem, int i, View view) {
                CircleAuthActivity.this.M1(circleApplyListItem, i);
            }

            public final void n(final CircleApplyListItem circleApplyListItem, final int i) {
                this.d.setText(circleApplyListItem.userName);
                int i2 = circleApplyListItem.sex;
                if (i2 == 1) {
                    this.d.setCompoundDrawablePadding(k36.b(6.0f));
                    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.circle_auth_female, 0);
                } else if (i2 == 0) {
                    this.d.setCompoundDrawablePadding(k36.b(6.0f));
                    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.circle_auth_male, 0);
                } else {
                    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                if (TextUtils.isEmpty(circleApplyListItem.checkQuestion)) {
                    this.g.setVisibility(8);
                } else {
                    this.g.setVisibility(0);
                    this.g.setText("问题：" + circleApplyListItem.checkQuestion);
                }
                if (TextUtils.isEmpty(circleApplyListItem.userAnswer)) {
                    this.h.setText("");
                } else if (TextUtils.isEmpty(circleApplyListItem.checkQuestion)) {
                    this.h.setText(circleApplyListItem.userAnswer);
                } else {
                    this.h.setText("答案：" + circleApplyListItem.userAnswer);
                }
                if (TextUtils.isEmpty(circleApplyListItem.opNickName) || circleApplyListItem.applyStatus != 1) {
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                    this.j.setVisibility(0);
                    this.i.setText("处理人：" + circleApplyListItem.opNickName + " " + circleApplyListItem.opTime + "同意");
                }
                gr2.j().h(circleApplyListItem.headImgUrl, this.e, bq6.s());
                this.e.setOnClickListener(new ViewOnClickListenerC1009a(circleApplyListItem));
                this.k.setVisibility(8);
                this.f.setVisibility(0);
                int i3 = circleApplyListItem.applyStatus;
                if (i3 == 0) {
                    this.f.setText("同意");
                    this.f.setBackgroundResource(R.drawable.selector_btn_green);
                    this.f.setClickable(true);
                    this.f.setEnabled(true);
                    this.f.setOnClickListener(new View.OnClickListener() { // from class: q60
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f20185a.o(circleApplyListItem, i, view);
                        }
                    });
                    return;
                }
                if (i3 == 1 || i3 == 3 || i3 == 4) {
                    if (i3 == 1) {
                        this.f.setText("已同意");
                    } else if (i3 == 3) {
                        this.f.setText("已过期");
                    } else {
                        this.f.setVisibility(4);
                        this.k.setVisibility(0);
                    }
                    this.f.setBackgroundResource(R.drawable.group_reject_bg);
                    this.f.setClickable(false);
                    this.f.setEnabled(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (getItemViewType(i) == 1) {
                return;
            }
            ((a) baseViewHolder).n((CircleApplyListItem) CircleAuthActivity.this.r.get(i), i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return i == 0 ? new a(LayoutInflater.from(CircleAuthActivity.this).inflate(R.layout.list_item_circle_reply_notice, viewGroup, false)) : new BaseViewHolder(LayoutInflater.from(CircleAuthActivity.this).inflate(R.layout.layout_rv_loading_more_footer, viewGroup, false));
        }

        public void c() {
            this.e = false;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return !this.e ? CircleAuthActivity.this.r.size() : CircleAuthActivity.this.r.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == CircleAuthActivity.this.r.size() ? 1 : 0;
        }

        public d() {
            this.e = true;
        }
    }

    public final void M1(CircleApplyListItem circleApplyListItem, int i) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        qa0.i().d(circleApplyListItem.id, 1, new c(i));
    }

    public final void N1(String str, String str2, String str3) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(str);
        contactInfoItem.setIconURL(str2);
        contactInfoItem.setNickName(str3);
        contactInfoItem.setSourceType(12);
        AppContext context = AppContext.getContext();
        Intent intent = new Intent(context, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", 6);
        k86.X(intent);
        context.startActivity(intent);
    }

    public final void O1() {
        qa0.i().g(this.t, this.v, 20, new a());
    }

    public final void P1() {
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(new b());
        this.z = endlessScrollListener;
        this.q.addOnScrollListener(endlessScrollListener);
    }

    public final void Q1(boolean z) {
        if (z) {
            this.w.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.w.setVisibility(0);
            this.q.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_auth);
        setSupportActionBar(initToolbar(R.string.circle_reply_note));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_circle_join_auth);
        this.q = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.w = (TextView) findViewById(R.id.tv_empty);
        this.t = getIntent().getStringExtra(j70.f18338a);
        this.s = new d();
        P1();
        this.y = new k80(this.t);
        O1();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.x) {
            setResult(-1, new Intent());
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.x) {
            setResult(-1, new Intent());
        }
        finish();
        return true;
    }
}
