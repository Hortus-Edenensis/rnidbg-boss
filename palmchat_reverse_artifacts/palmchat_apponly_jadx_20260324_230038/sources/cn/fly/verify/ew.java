package cn.fly.verify;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2262a = ed.a("0147fdfhhfhefgjfhdhj'dGfhdchgddjf");
    private static ew b;
    private a c;
    private volatile boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable;

        <T> T a(String str) throws Throwable;

        <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable;

        <T> T a(String str, String str2, Object obj) throws Throwable;

        <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f2263a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;
        private Method f;
        private Method g;
        private boolean h;

        public b(Context context) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            this.f2263a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = false;
            try {
                fz.a(new File(context.getFilesDir(), ed.a("014Bfdfhhfhefgjfhdhj5d7fhdchgddhf")));
            } catch (Throwable unused) {
            }
            try {
                File file = new File(context.getFilesDir(), ew.f2262a);
                if (!file.exists()) {
                    byte[] bArrDecode = Base64.decode("UEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAAUAAQATUVUQS1JTkYvTUFOSUZFU1QuTUb+ygAA803My0xLLS7RDUstKs7Mz7NSMNQz4OVySa3Q9clPTiwBCyXnJBYXpxbrpaRW8HI5F6UmlqSm6DpVWimkVACVG5rxcvFyAQBQSwcI8N6zmEcAAABJAAAAUEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAALAAAAY2xhc3Nlcy5kZXidV11sVEUUPnPn/uy9e3e7vWC3wEILW6H8yIKgAtsgpQrVbBWkaQwlxmX3Uq52d8vubcGfGDXgz4OJSkxIRKMPNTyY+BPiDw8mxN8HH9Qn9UXRaHzQRBMf0ETjNzN3t1tpYuIm3z1nzpzzzZk5c2fnlv0TzqYt15HfaYw/tO77Qw+en+UXjNXPnf+zu48u6qczCaIpIjoxttWj6Fd2iQZJ2TuAkBHBjV5n1PqlgIJGJEyfQm5yiH6GvMtCPBAAx4Bp4CTwBPAUcBp4HngX+BL4HbBiRMuAHLAHmAAeBV4EXgZmgXPAq8BrwPvAl8AvwGXgL4DbRBlgA7AF2AnsBcaAcaABnALOAG8AF4APgc+BH4BfgD8AhnkkgC5gM7AHOAQcB04BzwIvAOeAN4GLwFfAN8CPwG8AaAiC4gCWUq5dMlpLsW6dgFjsRcBVQDewBFgKGAAHfjWJMC3Sgcumsgs9hvUyIz1lzdnb/bvFmkZ6f5u+tc1/V8Qjch22VC5OVNvFkb4P9q5oHncKElg16eFST+S7Vj5NWiclo41SGpHU6XopLSk5RlsjrYrHQsY3SBmnvJgbrH1SqraNiGukVG01gsqfInkOk9jhqrbgfA/Jfh1X+ndt+t9tetKd01dFuuBVkkmdxRX/VMqW1euAVdTFhP1uUb+Et8Fb5jkZk9NSaxVl33Gx/wwasWNOdVOMZmJoy741lP1kri9ju0LGIx+WfSsBnxU0YpmIS9Jnpmv0GJyyHwn7gLRn30Z8LEkjMctBOy789psu78GmV37rpd9IotWn9WjoeyVBov2F6epinJGkGmPI7Ijb0XxymE9GzCftmRkN+XLMJcR4BvI1dFPkea3uMk/LNsAQ46ZgWMnFDuDYyQk8Bc+N4BE18myvO6ODxwDPY+CxDJGbLXhGkZenZ0+BxzFswbPbUDwqYvVCETx7Ev5xXfpzZNLDYlTtTdAjeLp0kVy9UxcVMmQeh+JqT3r9nuV1qRmhAidbM7IyGLN9ZtlHBb9mjbianNszmsjJBnsHKi0sLyVcrVMT77Eh358Gxuj932t27JBOT18QjE5Ug8fBt0HwdXtWhoNPB98psX/AZxqW4BsywKfWwtYtwbdZj9ZORtxA2WmXIk85rvDRuMs7ebNGZzHOrVGNtsUdWnl+m27RNteglR9sh3YsZeLNFOv5fyt4dRTh/kcFLaxuXFbQkRXs/7j5v2K1vef9XL2jQor8U1y9k+J/RtThshadhVzFZbiKM1rnqA7pyvO3eW5oUiYin7l+LtuG9FH6XFwiihM2Fp2HTJ4K+trR0TzxgdEdZA4E1SDcSdrOfkoMB7uDatmvb7ynOFMkrVAgXsBDL4inWZA/yhRKtUquUs6VimHusPTPNQPztLxQLk7OBPfmitVqLSyGQa2aOxBMVIvhdN3P09IFukeP1mvHG3nqLIhhc5PF6kRuaLLYgMlrM91++B6/FM63HQjrQXUiT1e12SRd8fAkRutpM9f9I5OIzw3Vqo2wPl0Ka8h2yQIOewJ/siwyvbJrxA+P1tDHxkgbO0jsIGkHC8TGyRu/MvdF4wskP8/YzN4uiYjbihWfeGnyftJLyJHSaqU2Nu5rhH5l49jIHdPVMIBP0j/hV6bE0jWGB/fdQsYRkTHZUkgW60itLpVEpKjEiU/4IXXhcZOPIet+uW0xKNVml2tAnW2WiCF9hSnqsNAxPITkbaGoeAdqM2kPemsKUYwZVGdq9/rkKCknY1ZUn6Okmo7SG7SkEh7du3D2i+Z3qQQWzzdGwwqWA0gyKJf96uBUcHNrOcmt+seHbwFrsVryKY5Wq2FPFevFSkNOUamoKcXqfskPZvw6JRp+OFgq+Y1GgL1HXY2FR9DDo0GDjJni5DQ4ZyqtorZUuX1woFlJ2suutW69xKnPYV6Ks7XO+9wY1NniFOfXO99x7Ron4Pou4wTtYhlrwyXO+pzznJbrtJ5nVuWFRYsslzjf6sxyttIeoLSxPL95+w4rz7wOzq4DKa7BA7TCyEhzO0/ffN5Zrm1zaCvPCLfZ/doDy+eNsEWMsCI2QBpjOzPxNEsn0jzt4plMpyHT0EjT0Me6zXk+yX/5iD6j1afaVqudbPnYLVsrVt4nH3lYf91kT7JPTGafiTH7W+Anm9mfOsw+G2f2SXH16mg7s5uy+f2g0dw3BKe57whx/ja/IUya+47gKdUWZzzrVXfaTQg0e5WPuO+xlDqDxZ1X61Vjie8OHvnLu1uv4hH3QYpi5T0xpXTxjfMPUEsHCKFWFIudBgAAHA0AAFBLAQIUABQACAgIAG2HfFbw3rOYRwAAAEkAAAAUAAQAAAAAAAAAAAAAAAAAAABNRVRBLUlORi9NQU5JRkVTVC5NRv7KAABQSwECFAAUAAgICABth3xWoVYUi50GAAAcDQAACwAAAAAAAAAAAAAAAACNAAAAY2xhc3Nlcy5kZXhQSwUGAAAAAAIAAgB/AAAAYwcAAAAA", 2);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(bArrDecode);
                        eg.a(fileOutputStream);
                        file.setReadOnly();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        eg.a(fileOutputStream2);
                        throw th;
                    }
                }
                Class cls = (Class) fy.a(fy.a(fy.a(ed.a("0219dc[dgHdddidlfdfhdkfh=ifYdffdfk0f(ecfldiVgf")), file), ed.a("009gRedWd*dcgk=gd6fhfh"), new Object[]{ed.a("026c'eddffddfdcfd$cdiTfdfediNeBdc!fUdjfdfjdifidiQe.dc0fJdj"), null}, (Class<?>[]) new Class[]{String.class, ClassLoader.class});
                Method declaredMethod = cls.getDeclaredMethod(ed.a("014f>ec>fVdf8jiDdiedMeIfhfjelglei"), String[].class);
                this.f2263a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod(ed.a("010UdiKeSddeddlBf2fjelglei"), Class.class, Object.class, String.class, Class[].class, Object[].class);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod(ed.a("010TdiLe:ddeddl>fMfjelglei"), String.class, Object.class, String.class, Class[].class, Object[].class);
                this.c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = cls.getDeclaredMethod(ed.a("012ef%fffjeiDe6fh+idecf"), String.class);
                this.d = declaredMethod4;
                declaredMethod4.setAccessible(true);
                Method declaredMethod5 = cls.getDeclaredMethod(ed.a("012efPfffjeiAe1fh;idecf"), String.class, Class[].class, Object[].class);
                this.e = declaredMethod5;
                declaredMethod5.setAccessible(true);
                Method declaredMethod6 = cls.getDeclaredMethod(ed.a("0095eeOfi!fjfldi@fgYdc"), String.class, String.class, Object.class);
                this.f = declaredMethod6;
                declaredMethod6.setAccessible(true);
                Method declaredMethod7 = cls.getDeclaredMethod(ed.a("007'ee@fi7fjgk'g[gc"), String.class);
                this.g = declaredMethod7;
                declaredMethod7.setAccessible(true);
                this.h = true;
            } catch (Throwable unused2) {
            }
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = this.b;
            if (method != null) {
                return (T) method.invoke(null, cls, obj, str, clsArr, objArr);
            }
            throw new Throwable("IHA is null");
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str) throws Throwable {
            Method method = this.d;
            if (method != null) {
                return (T) method.invoke(null, str);
            }
            throw new Throwable("nHI is null");
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = this.c;
            if (method != null) {
                return (T) method.invoke(null, str, obj, str2, clsArr, objArr);
            }
            throw new Throwable("IHABC is null");
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, String str2, Object obj) throws Throwable {
            Method method = this.f;
            if (method != null) {
                return (T) method.invoke(null, str, str2, obj);
            }
            throw new Throwable("mthGetHField is null");
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = this.e;
            if (method != null) {
                return (T) method.invoke(null, str, clsArr, objArr);
            }
            throw new Throwable("mthNewHInstanceByParams is null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements a {
        @Override // cn.fly.verify.ew.a
        public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = (Method) Class.class.getDeclaredMethod(ed.a("017Iee3fi:fk=fcgdLdjZf!dchcGfihYeddc"), String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return (T) method.invoke(obj, objArr);
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str) throws Throwable {
            return (T) Class.class.getDeclaredMethod(ed.a("011efAffei)e+fhNidecf"), new Class[0]).invoke((Class) Class.class.getDeclaredMethod(ed.a("007*efeddjehOdGdfCf"), String.class).invoke(null, str), new Object[0]);
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable {
            return (T) a((Class) Class.class.getDeclaredMethod(ed.a("007+efeddjehXd[df,f"), String.class).invoke(null, str), obj, str2, clsArr, objArr);
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, String str2, Object obj) throws Throwable {
            Field field = (Field) Class.class.getDeclaredMethod(ed.a("016DeeCfiZfk.fcgdXdj0fXdcfldiKfg5dc"), String.class).invoke((Class) Class.class.getDeclaredMethod(ed.a("007Xefeddjeh8dLdfGf"), String.class).invoke(null, str), str2);
            field.setAccessible(true);
            return (T) field.get(obj);
        }

        @Override // cn.fly.verify.ew.a
        public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
            if (clsArr == null || clsArr.length == 0 || objArr == null || objArr.length == 0) {
                return (T) a(str);
            }
            Constructor constructor = (Constructor) Class.class.getDeclaredMethod(ed.a("022[ee[fiNfk>fcgd3djAfNdcgked-eLfhLi*djdg-ci3eddj"), Class[].class).invoke((Class) Class.class.getDeclaredMethod(ed.a("0077efeddjehTd9dfWf"), String.class).invoke(null, str), clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        }
    }

    private ew(Context context, int i) {
        if (i < 30 || Build.VERSION.SDK_INT < 30) {
            this.c = new c();
        } else {
            this.c = new b(context);
        }
    }

    public static synchronized ew a(Context context) {
        if (b == null && context != null) {
            b = new ew(context, context.getApplicationInfo().targetSdkVersion);
        }
        return b;
    }

    public boolean b(Context context) {
        if (!this.d) {
            try {
                File file = new File(context.getFilesDir(), f2262a);
                if (file.exists()) {
                    this.d = file.delete();
                }
            } catch (Throwable unused) {
            }
        }
        return this.d;
    }

    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
        return (T) this.c.a(cls, obj, str, clsArr, objArr);
    }

    public <T> T a(String str) throws Throwable {
        return (T) this.c.a(str);
    }

    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable {
        return (T) this.c.a(str, obj, str2, clsArr, objArr);
    }

    public <T> T a(String str, String str2, Object obj) throws Throwable {
        return (T) this.c.a(str, str2, obj);
    }

    public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
        return (T) this.c.a(str, clsArr, objArr);
    }
}
