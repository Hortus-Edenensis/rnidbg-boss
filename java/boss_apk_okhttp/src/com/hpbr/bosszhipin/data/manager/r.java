package com.hpbr.bosszhipin.data.manager;

import com.hpbr.bosszhipin.common.pub.entity.ROLE;
import com.hpbr.bosszhipin.module.login.entity.UserBean;

public final class r {
    private static long uid;
    private static ROLE role = ROLE.of(0);
    private static UserBean user;

    private r() {}

    public static void configureRuntimeUser(long uidValue, int roleValue, String name) {
        uid = uidValue;
        role = ROLE.of(roleValue);
        UserBean nextUser = new UserBean();
        nextUser.name = name == null ? "" : name;
        user = nextUser;
    }

    public static ROLE D() {
        return role;
    }

    public static UserBean r() {
        if (user == null) {
            configureRuntimeUser(0L, 0, "");
        }
        return user;
    }

    public static long z() {
        return uid;
    }
}
