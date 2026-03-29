package com.zenmen.palmchat.circle.app.dragon;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import defpackage.bo0;
import defpackage.j70;
import defpackage.lg1;
import defpackage.mg1;
import defpackage.pc0;
import defpackage.ry5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DragonCreatorActivity extends BaseActionBarActivity {
    public LinearLayout A;
    public ImageView B;
    public mg1 E;
    public DragonItem F;
    public String H;
    public String I;
    public String J;
    public DatePicker L;
    public TimePicker M;
    public Toolbar q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public EditText w;
    public TextView x;
    public CheckBox y;
    public TextView z;
    public HashMap<Long, EditText> C = new HashMap<>();
    public ArrayList<DragonConfirmItem> G = new ArrayList<>();
    public boolean K = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DragonCreatorActivity.this.z.setText("");
            DragonCreatorActivity.this.y.setChecked(false);
            DragonCreatorActivity.this.z.setTag(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DragonCreatorActivity.this.Q1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DragonCreatorActivity.this.K) {
                return;
            }
            DragonCreatorActivity.this.W1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DragonCreatorActivity.this.K) {
                return;
            }
            DragonCreatorActivity.this.Y1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                DragonCreatorActivity.this.Z1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            DragonCreatorActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                ry5.a(DragonCreatorActivity.this.getString(R.string.send_failed));
            } else if (baseResponse.getResultCode() != 0) {
                ry5.a(baseResponse.getErrorMsg());
            } else {
                ry5.a(DragonCreatorActivity.this.getString(R.string.send_success));
                DragonCreatorActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends wi0<BaseResponse<HashMap<String, Long>>> {
        public g() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<HashMap<String, Long>> baseResponse) {
            DragonCreatorActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                ry5.a((baseResponse == null || TextUtils.isEmpty(baseResponse.getErrorMsg())) ? DragonCreatorActivity.this.getString(R.string.send_failed) : baseResponse.getErrorMsg());
            } else {
                DragonCreatorActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends wi0<BaseResponse<DragonItem>> {
        public i() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DragonItem> baseResponse) {
            DragonItem data;
            if (baseResponse.getResultCode() != 0 || (data = baseResponse.getData()) == null) {
                return;
            }
            DragonCreatorActivity.this.F = data;
            DragonCreatorActivity.this.G = data.getItems();
            DragonCreatorActivity.this.R1();
            DragonCreatorActivity.this.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f12999a;

        public j(Dialog dialog) {
            this.f12999a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jC = pc0.c(DragonCreatorActivity.this.L.getYear(), DragonCreatorActivity.this.L.getMonth() + 1, DragonCreatorActivity.this.L.getDayOfMonth(), DragonCreatorActivity.this.M.getCurrentHour().intValue(), DragonCreatorActivity.this.M.getCurrentMinute().intValue());
            DragonCreatorActivity.this.y.setChecked(true);
            DragonCreatorActivity.this.z.setTag(Long.valueOf(jC));
            DragonCreatorActivity.this.z.setText(pc0.a(jC));
            this.f12999a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        Z1();
    }

    public final void Q1() {
        DragonItem dragonItem = this.F;
        String str = dragonItem.content;
        long j2 = dragonItem.timeDeadLine;
        dragonItem.content = this.w.getText().toString();
        String str2 = this.F.content;
        if (str2 == null || str2.isEmpty()) {
            Toast.makeText(this, "主题不能为空", 0).show();
            return;
        }
        Iterator<Long> it = this.C.keySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            String string = this.C.get(Long.valueOf(it.next().longValue())).getText().toString();
            if (string != null && string.length() > 0) {
                this.F.selfContent = string;
                z = true;
            }
        }
        if (!z) {
            Toast.makeText(this, "自己得参与", 0).show();
            return;
        }
        DragonItem dragonItem2 = this.F;
        dragonItem2.groupId = this.J;
        dragonItem2.publisherId = this.H;
        dragonItem2.publisherName = this.I;
        dragonItem2.isOverTime = this.y.isChecked();
        this.F.timeDeadLine = ((Long) this.z.getTag()).longValue();
        this.F.isSelfJoin = true;
        if (!this.K) {
            ArrayList<DragonConfirmItem> arrayListS1 = S1();
            showBaseProgressBar("正在处理", false);
            lg1.c().k(this.F, arrayListS1, new g());
        } else {
            ArrayList<DragonConfirmItem> arrayListS12 = S1();
            if (arrayListS12.isEmpty()) {
                return;
            }
            String str3 = arrayListS12.size() > 0 ? arrayListS12.get(0).content : "";
            showBaseProgressBar("正在处理", false);
            lg1.c().e(this.F, str3, new f());
        }
    }

    public final void R1() {
        this.w.setText(this.F.content);
        EditText editText = this.w;
        String str = this.F.content;
        editText.setSelection(str == null ? 0 : str.length());
        this.y.setChecked(this.F.isOverTime);
        this.z.setText(pc0.a(this.F.timeDeadLine));
        this.z.setTag(Long.valueOf(this.F.timeDeadLine));
    }

    public final ArrayList<DragonConfirmItem> S1() {
        ArrayList<DragonConfirmItem> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        Iterator<DragonConfirmItem> it = this.G.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DragonConfirmItem next = it.next();
            if (this.C.containsKey(Long.valueOf(next.sid))) {
                EditText editText = this.C.get(Long.valueOf(next.sid));
                if (editText.isEnabled()) {
                    String string = editText.getText().toString();
                    String str = string != null ? string : "";
                    if (!next.content.equals(str)) {
                        next.content = str;
                        arrayList.add(next);
                    }
                }
                map.put(Long.valueOf(next.sid), Boolean.TRUE);
            }
        }
        Iterator<Long> it2 = this.C.keySet().iterator();
        while (it2.hasNext()) {
            long jLongValue = it2.next().longValue();
            if (!map.containsKey(Long.valueOf(jLongValue))) {
                String string2 = this.C.get(Long.valueOf(jLongValue)).getText().toString();
                if (string2 == null) {
                    string2 = "";
                }
                if (jLongValue != DragonConfirmItem.UNDEFINED_ID || !string2.isEmpty()) {
                    DragonConfirmItem dragonConfirmItem = new DragonConfirmItem();
                    dragonConfirmItem.uid = this.H;
                    dragonConfirmItem.uname = this.F.publisherName;
                    dragonConfirmItem.content = string2;
                    arrayList.add(dragonConfirmItem);
                }
            }
        }
        return arrayList;
    }

    public final void U1() {
        this.A.removeAllViews();
        this.C.clear();
        int i2 = 0;
        while (i2 < this.G.size()) {
            DragonConfirmItem dragonConfirmItem = this.G.get(i2);
            i2++;
            this.C.put(Long.valueOf(dragonConfirmItem.sid), this.E.b(this, this.F.type, this.A, dragonConfirmItem, i2, dragonConfirmItem.uid.equals(this.H)));
        }
        DragonConfirmItem dragonConfirmItem2 = new DragonConfirmItem();
        dragonConfirmItem2.uid = this.H;
        dragonConfirmItem2.sid = DragonConfirmItem.UNDEFINED_ID;
        dragonConfirmItem2.uname = bo0.r().l(dragonConfirmItem2.uid).getNameForShow();
        dragonConfirmItem2.content = "";
        EditText editTextB = this.E.b(this, this.F.type, this.A, dragonConfirmItem2, this.G.size() + 1, true);
        if (this.K) {
            editTextB.requestFocus();
        } else {
            this.w.requestFocus();
        }
        this.C.put(Long.valueOf(dragonConfirmItem2.sid), editTextB);
    }

    public final void V1() {
        if (this.F.dragonId == 0) {
            return;
        }
        lg1.c().i(this.J, this.F.dragonId, new i());
    }

    public final void W1() {
        this.s.setTextColor(getResources().getColor(R.color.auth_line_text_normal_color));
        this.t.setBackgroundColor(getResources().getColor(R.color.auth_line_text_normal_color));
        this.u.setTextColor(getResources().getColor(R.color.text_color_999));
        this.v.setBackgroundColor(getResources().getColor(R.color.gap_line_color));
        this.F.type = 1;
        U1();
    }

    public final void X1() {
        this.w.addTextChangedListener(new h());
    }

    public final void Y1() {
        this.u.setTextColor(getResources().getColor(R.color.auth_line_text_normal_color));
        this.v.setBackgroundColor(getResources().getColor(R.color.auth_line_text_normal_color));
        this.s.setTextColor(getResources().getColor(R.color.text_color_999));
        this.t.setBackgroundColor(getResources().getColor(R.color.gap_line_color));
        this.F.type = 2;
        U1();
    }

    public final void Z1() {
        Dialog dialog = new Dialog(this, R.style.CircleBottomDialog);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_circle_dragon_bottom, (ViewGroup) null);
        dialog.setContentView(linearLayout);
        Window window = dialog.getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = getResources().getDisplayMetrics().widthPixels;
        linearLayout.measure(0, 0);
        attributes.height = linearLayout.getMeasuredHeight();
        attributes.alpha = 9.0f;
        window.setAttributes(attributes);
        this.L = (DatePicker) linearLayout.findViewById(R.id.circle_dragon_datepicker);
        TimePicker timePicker = (TimePicker) linearLayout.findViewById(R.id.circle_dragon_timepicker);
        this.M = timePicker;
        timePicker.setIs24HourView(Boolean.TRUE);
        try {
            ((ViewGroup) ((ViewGroup) this.L.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(8);
        } catch (Exception unused) {
        }
        Calendar calendar = Calendar.getInstance();
        this.L.updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
        this.M.setCurrentHour(Integer.valueOf(calendar.get(11)));
        this.M.setCurrentMinute(Integer.valueOf(calendar.get(12)));
        ((TextView) linearLayout.findViewById(R.id.circle_dragon_date_select)).setOnClickListener(new j(dialog));
        dialog.show();
        dialog.setOnCancelListener(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_dragon_creator);
        this.J = getIntent().getStringExtra(j70.f18338a);
        DragonItem dragonItem = (DragonItem) getIntent().getSerializableExtra(j70.e);
        this.F = dragonItem;
        if (dragonItem == null) {
            this.F = new DragonItem();
            this.K = false;
        } else {
            this.J = dragonItem.groupId;
            this.K = true;
        }
        this.H = getIntent().getStringExtra(j70.b);
        this.I = bo0.r().l(this.H).getNameForShow();
        Toolbar toolbarInitToolbar = initToolbar("");
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("创建群接龙");
        setSupportActionBar(this.q);
        TextView textView = (TextView) this.q.findViewById(R.id.action_button);
        this.r = textView;
        textView.setEnabled(false);
        this.r.setText("发布");
        this.r.setOnClickListener(new b());
        this.E = new mg1();
        EditText editText = (EditText) findViewById(R.id.circle_dragon_create_content_edit);
        this.w = editText;
        if (this.K) {
            editText.setEnabled(false);
        }
        this.x = (TextView) findViewById(R.id.circle_dragon_create_content_hint);
        X1();
        this.y = (CheckBox) findViewById(R.id.circle_dragon_create_time);
        TextView textView2 = (TextView) findViewById(R.id.circle_dragon_time_deadline);
        this.z = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: kg1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18684a.T1(view);
            }
        });
        this.A = (LinearLayout) findViewById(R.id.layout_circle_dragon_create_fellow);
        this.s = (TextView) findViewById(R.id.circle_dragon_create_title_common);
        this.t = (TextView) findViewById(R.id.circle_dragon_create_title_commonline);
        this.u = (TextView) findViewById(R.id.circle_dragon_create_title_word);
        this.v = (TextView) findViewById(R.id.circle_dragon_create_title_wordline);
        this.s.setOnClickListener(new c());
        this.u.setOnClickListener(new d());
        if (this.F.type == 1) {
            W1();
        } else {
            Y1();
        }
        this.y.setOnCheckedChangeListener(new e());
        this.B = (ImageView) findViewById(R.id.circle_dragon_add_fellow);
        R1();
        V1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextWatcher {
        public h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            DragonCreatorActivity.this.r.setEnabled(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence == null) {
                DragonCreatorActivity.this.x.setText("0/500");
                return;
            }
            DragonCreatorActivity.this.x.setText(charSequence.toString().length() + "/500");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
