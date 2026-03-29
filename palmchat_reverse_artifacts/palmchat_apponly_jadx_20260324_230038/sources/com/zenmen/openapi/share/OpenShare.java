package com.zenmen.openapi.share;

import android.app.Activity;
import defpackage.b94;
import defpackage.q84;
import defpackage.s84;
import defpackage.u84;
import defpackage.v84;
import defpackage.z84;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OpenShare {
    private static final String CLAZZ_NAME = "com.zenmen.palmchat.opensdk.share.LXShare";
    private static final String METHOD_NAME_SEND = "sendMessage";
    private static final String METHOD_NAME_SHARE = "shareMessage";
    private Object adapterObject;
    public a builder;
    private Method sendMethod;
    private Method shareMethod;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f12027a;
        public String b;
        public int c;
        public OpenDataBean d = new OpenDataBean();

        public OpenShare e() {
            return new OpenShare(this);
        }

        public a f(String str) {
            this.b = str;
            return this;
        }

        public a g(Activity activity) {
            this.f12027a = activity;
            return this;
        }

        public a h(int i) {
            this.c = i;
            return this;
        }

        public a i(s84 s84Var) {
            this.d.setNameCard(s84Var);
            this.d.setShowType(s84Var.s());
            return this;
        }

        public a j(u84 u84Var) {
            this.d.setApp(u84Var);
            this.d.setShowType(u84Var.u());
            return this;
        }

        public a k(v84 v84Var) {
            this.d.setVideo(v84Var);
            this.d.setShowType(v84Var.l());
            return this;
        }

        public a l(z84 z84Var) {
            this.d.setText(z84Var);
            this.d.setShowType(z84Var.h());
            return this;
        }

        public a m(b94 b94Var) {
            this.d.setWeb(b94Var);
            this.d.setShowType(b94Var.s());
            return this;
        }

        public a n(q84... q84VarArr) {
            this.d.setImages(q84VarArr);
            this.d.setShowType(2);
            return this;
        }
    }

    public OpenShare(a aVar) {
        this.builder = aVar;
        invokeClass(CLAZZ_NAME, aVar.f12027a, aVar.b);
    }

    private Object invokeClass(String str, Activity activity, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Activity.class, String.class);
            if (declaredConstructor == null) {
                return null;
            }
            Object objNewInstance = declaredConstructor.newInstance(activity, str2);
            this.adapterObject = objNewInstance;
            if (objNewInstance == null) {
                return null;
            }
            this.sendMethod = cls.getMethod(METHOD_NAME_SEND, OpenDataBean.class);
            this.shareMethod = cls.getMethod(METHOD_NAME_SHARE, OpenDataBean.class);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private void invokeMethod(Object obj, Method method, Object... objArr) {
        if (obj == null || method == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    private void sendMessage(OpenDataBean openDataBean) {
        invokeMethod(this.adapterObject, this.sendMethod, openDataBean);
    }

    private void shareMessage(OpenDataBean openDataBean) {
        invokeMethod(this.adapterObject, this.shareMethod, openDataBean);
    }

    public void share() {
        if (this.builder.d == null) {
            return;
        }
        int i = this.builder.c;
        if (i == 0) {
            sendMessage(this.builder.d);
        } else {
            if (i != 1) {
                return;
            }
            shareMessage(this.builder.d);
        }
    }
}
