package org.apache.webplatform.jssdk;

import android.util.Log;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.c;
import defpackage.dt0;
import defpackage.ed5;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.rs0;
import defpackage.zw4;
import java.io.File;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class FacePlugin extends CordovaPlugin {
    private static final String FUN_ADD_FACE = "addExpression";
    private static String TAG = "FacePlugin";

    private void addFace(final CallbackContext callbackContext, String str) {
        dt0.l(c.b(), zw4.b()).e(str, pu1.k, String.valueOf(System.currentTimeMillis()), new ed5() { // from class: org.apache.webplatform.jssdk.FacePlugin.1
            @Override // defpackage.ed5, defpackage.il2
            public void onError(int i, String str2) {
                callbackContext.error(str2);
            }

            @Override // defpackage.ed5, defpackage.il2
            public void onFinish(File file) {
                ExpressionObject expressionObject = new ExpressionObject();
                expressionObject.path = file.getAbsolutePath();
                expressionObject.coverPath = file.getAbsolutePath();
                expressionObject.md5 = rb3.b(file);
                rs0.a(expressionObject);
                callbackContext.success();
            }
        });
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        Log.i(TAG, str + "-" + jSONArray.toString());
        str.hashCode();
        if (!str.equals(FUN_ADD_FACE)) {
            return false;
        }
        addFace(callbackContext, jSONArray.optString(0));
        return true;
    }
}
