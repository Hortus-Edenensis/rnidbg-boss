package defpackage;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ib3 {
    protected ba3 mCordovaInterface;
    protected List<String> supportActions = Collections.emptyList();

    public boolean canExec(String str) {
        Iterator<String> it = this.supportActions.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        v93Var.a(makeInvalidActionMsg());
    }

    public abstract void initSupportAction();

    public void initialize(ba3 ba3Var) {
        this.mCordovaInterface = ba3Var;
        this.supportActions = new ArrayList();
        initSupportAction();
    }

    public abstract JSONObject makeDefaultSucMsg();

    public abstract JSONObject makeErrorArgsMsg();

    public abstract JSONObject makeInvalidActionMsg();

    public abstract JSONObject makeInvalidArgsMsg();

    public abstract JSONObject makePermissionDeniedArgsMsg();

    public void onDestroy() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
    }
}
