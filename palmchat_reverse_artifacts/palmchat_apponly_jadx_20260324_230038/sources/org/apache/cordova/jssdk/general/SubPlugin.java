package org.apache.cordova.jssdk.general;

import defpackage.ib3;
import java.lang.reflect.Field;
import org.apache.cordova.PluginResult;
import org.apache.cordova.jssdk.CordovaUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SubPlugin extends ib3 {
    @Override // defpackage.ib3
    public void initSupportAction() {
        TargetPlugin targetPlugin;
        Field[] declaredFields = Action.class.getDeclaredFields();
        if (declaredFields != null) {
            for (Field field : declaredFields) {
                if (field.getType() == String.class && (targetPlugin = (TargetPlugin) field.getAnnotation(TargetPlugin.class)) != null && targetPlugin.clazz() == getClass()) {
                    try {
                        this.supportActions.add((String) field.get(Action.class));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override // defpackage.ib3
    public JSONObject makeDefaultSucMsg() {
        return CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
    }

    @Override // defpackage.ib3
    public JSONObject makeErrorArgsMsg() {
        return CordovaUtils.makeNormalJsResult(PluginResult.Status.ERROR);
    }

    @Override // defpackage.ib3
    public JSONObject makeInvalidActionMsg() {
        return CordovaUtils.makeNormalJsResult(PluginResult.Status.INVALID_ACTION);
    }

    @Override // defpackage.ib3
    public JSONObject makeInvalidArgsMsg() {
        return CordovaUtils.makeNormalJsResult(PluginResult.Status.JSON_EXCEPTION);
    }

    @Override // defpackage.ib3
    public JSONObject makePermissionDeniedArgsMsg() {
        return CordovaUtils.makeNormalJsResult(PluginResult.Status.PERMISSION_DENIED);
    }
}
