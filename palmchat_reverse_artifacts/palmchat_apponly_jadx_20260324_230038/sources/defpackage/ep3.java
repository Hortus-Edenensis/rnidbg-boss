package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ep3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ep3 f17328a;

    public static ep3 c() {
        if (f17328a == null) {
            f17328a = new ep3();
        }
        return f17328a;
    }

    public final void a(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        String strD;
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String strConcat = str.concat("_TEMP");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(strConcat);
            sb.append(" (");
            String str2 = "";
            int i = 0;
            while (true) {
                Property[] propertyArr = daoConfig.properties;
                if (i < propertyArr.length) {
                    String str3 = propertyArr[i].columnName;
                    if (b(database, str).contains(str3)) {
                        arrayList.add(str3);
                        try {
                            strD = d(daoConfig.properties[i].type);
                        } catch (Exception e) {
                            e.printStackTrace();
                            strD = null;
                        }
                        sb.append(str2);
                        sb.append(str3);
                        sb.append(" ");
                        sb.append(strD);
                        if (daoConfig.properties[i].primaryKey) {
                            sb.append(" PRIMARY KEY");
                        }
                        str2 = ",";
                    }
                    i++;
                }
            }
            sb.append(");");
            database.execSQL(sb.toString());
            database.execSQL("INSERT INTO " + strConcat + " (" + TextUtils.join(",", arrayList) + ") SELECT " + TextUtils.join(",", arrayList) + " FROM " + str + x.aQ);
        }
    }

    public final List<String> b(Database database, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = database.rawQuery("SELECT * FROM " + str + " limit 1", null);
                if (cursorRawQuery != null) {
                    arrayList = new ArrayList(Arrays.asList(cursorRawQuery.getColumnNames()));
                }
            } catch (Exception e) {
                Log.v(str, e.getMessage(), e);
                e.printStackTrace();
                if (cursorRawQuery != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public final String d(Class<?> cls) throws Exception {
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Long.class) || cls.equals(Integer.class) || cls.equals(Long.TYPE)) {
            return "INTEGER";
        }
        if (cls.equals(Boolean.class)) {
            return "BOOLEAN";
        }
        Exception exc = new Exception("MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS".concat(" - Class: ").concat(cls.toString()));
        exc.printStackTrace();
        throw exc;
    }

    public void e(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        a(database, clsArr);
        xt0.b(database, true);
        xt0.a(database, false);
        f(database, clsArr);
    }

    public final void f(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String strConcat = str.concat("_TEMP");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                Property[] propertyArr = daoConfig.properties;
                if (i < propertyArr.length) {
                    String str2 = propertyArr[i].columnName;
                    if (b(database, strConcat).contains(str2)) {
                        arrayList.add(str2);
                    }
                    i++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE ");
            sb.append(strConcat);
            database.execSQL("INSERT INTO " + str + " (" + TextUtils.join(",", arrayList) + ") SELECT " + TextUtils.join(",", arrayList) + " FROM " + strConcat + x.aQ);
            database.execSQL(sb.toString());
        }
    }
}
