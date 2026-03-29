package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class sg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20738a;
    public int b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            sg6.this.e(true, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            sg6.this.e(false, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f20743a;

        public e(MaterialDialog materialDialog) {
            this.f20743a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20743a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f20744a;

        public f(MaterialDialog materialDialog) {
            this.f20744a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20744a.cancel();
            sg6.this.f();
        }
    }

    public sg6() {
        this.f20738a = 0;
        this.b = 0;
        int iB = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
        this.f20738a = iB;
        this.b = iB;
    }

    public final List<Integer> c() {
        ArrayList arrayList = new ArrayList();
        boolean z = !yg4.a(this.f20738a, 67108864);
        boolean z2 = !yg4.a(this.f20738a, 134217728);
        boolean z3 = !yg4.a(this.b, 67108864);
        boolean z4 = !yg4.a(this.b, 134217728);
        if (z != z3) {
            arrayList.add(Integer.valueOf(z ? 3 : 1));
        }
        if (z2 != z4) {
            arrayList.add(Integer.valueOf(z ? 4 : 2));
        }
        return arrayList;
    }

    public final boolean d(boolean z) {
        return !yg4.a(this.f20738a, z ? 67108864 : 134217728);
    }

    public final void e(boolean z, boolean z2) {
        g(!z2, z ? 67108864 : 134217728);
    }

    public final void f() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("report_type", "click");
        map.put("click_type", c());
        lh6.V().j0("audioMatch_settings", map);
        if (this.f20738a == this.b) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("privacyConfig", Integer.valueOf(this.f20738a));
        try {
            new eq3(new a(), new b()).n(map2);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void g(boolean z, int i) {
        this.f20738a = yg4.b(this.f20738a, z, i);
    }

    public void h(Activity activity) {
        HashMap<String, String> map = new HashMap<>();
        map.put("report_type", "view");
        lh6.V().b("audioMatch_settings", map);
        MaterialDialog materialDialogE = new sd3(activity).h(true).v(true).c(0).o(R.layout.layout_dialog_voice_match_setting, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            CheckBox checkBox = (CheckBox) viewJ.findViewById(R.id.checkbox_voice);
            checkBox.setChecked(d(true));
            checkBox.setOnCheckedChangeListener(new c());
            CheckBox checkBox2 = (CheckBox) viewJ.findViewById(R.id.checkbox_video);
            checkBox2.setChecked(d(false));
            checkBox2.setOnCheckedChangeListener(new d());
            ((TextView) viewJ.findViewById(R.id.cancel)).setOnClickListener(new e(materialDialogE));
            ((TextView) viewJ.findViewById(R.id.confirm)).setOnClickListener(new f(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.setOnDismissListener(new g());
        materialDialogE.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnDismissListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
