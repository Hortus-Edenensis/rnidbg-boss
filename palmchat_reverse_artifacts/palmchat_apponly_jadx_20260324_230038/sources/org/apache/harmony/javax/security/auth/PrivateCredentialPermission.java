package org.apache.harmony.javax.security.auth;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Principal;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class PrivateCredentialPermission extends Permission {
    private static final String READ = "read";
    private static final long serialVersionUID = 5284372143517237068L;
    private String credentialClass;
    private transient int offset;
    private transient CredOwner[] set;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CredOwner implements Serializable {
        private static final long serialVersionUID = -5607449830436408266L;
        private transient boolean isClassWildcard;
        private transient boolean isPNameWildcard;
        String principalClass;
        String principalName;

        public CredOwner(String str, String str2) {
            if ("*".equals(str)) {
                this.isClassWildcard = true;
            }
            if ("*".equals(str2)) {
                this.isPNameWildcard = true;
            }
            if (this.isClassWildcard && !this.isPNameWildcard) {
                throw new IllegalArgumentException("auth.12");
            }
            this.principalClass = str;
            this.principalName = str2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CredOwner)) {
                return false;
            }
            CredOwner credOwner = (CredOwner) obj;
            return this.principalClass.equals(credOwner.principalClass) && this.principalName.equals(credOwner.principalName);
        }

        public int hashCode() {
            return this.principalClass.hashCode() + this.principalName.hashCode();
        }

        public boolean implies(Object obj) {
            if (obj == this) {
                return true;
            }
            CredOwner credOwner = (CredOwner) obj;
            if (this.isClassWildcard || this.principalClass.equals(credOwner.principalClass)) {
                return this.isPNameWildcard || this.principalName.equals(credOwner.principalName);
            }
            return false;
        }
    }

    public PrivateCredentialPermission(String str, String str2) {
        super(str);
        if (!READ.equalsIgnoreCase(str2)) {
            throw new IllegalArgumentException("auth.11");
        }
        initTargetName(str);
    }

    private void initTargetName(String str) {
        boolean z;
        if (str == null) {
            throw new NullPointerException("auth.0E");
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            throw new IllegalArgumentException("auth.0F");
        }
        int iIndexOf = strTrim.indexOf(32);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("auth.10");
        }
        this.credentialClass = strTrim.substring(0, iIndexOf);
        int i = iIndexOf + 1;
        int length = strTrim.length();
        int i2 = 0;
        while (i < length) {
            int iIndexOf2 = strTrim.indexOf(32, i);
            int iIndexOf3 = strTrim.indexOf(34, iIndexOf2 + 2);
            if (iIndexOf2 == -1 || iIndexOf3 == -1 || strTrim.charAt(iIndexOf2 + 1) != '\"') {
                throw new IllegalArgumentException("auth.10");
            }
            i = iIndexOf3 + 2;
            i2++;
        }
        if (i2 < 1) {
            throw new IllegalArgumentException("auth.10");
        }
        int iIndexOf4 = strTrim.indexOf(32) + 1;
        this.set = new CredOwner[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iIndexOf5 = strTrim.indexOf(32, iIndexOf4);
            int i4 = iIndexOf5 + 2;
            int iIndexOf6 = strTrim.indexOf(34, i4);
            CredOwner credOwner = new CredOwner(strTrim.substring(iIndexOf4, iIndexOf5), strTrim.substring(i4, iIndexOf6));
            int i5 = 0;
            while (true) {
                if (i5 >= this.offset) {
                    z = false;
                    break;
                } else {
                    if (this.set[i5].equals(credOwner)) {
                        z = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z) {
                CredOwner[] credOwnerArr = this.set;
                int i6 = this.offset;
                this.offset = i6 + 1;
                credOwnerArr[i6] = credOwner;
            }
            iIndexOf4 = iIndexOf6 + 2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        initTargetName(getName());
    }

    private boolean sameMembers(Object[] objArr, Object[] objArr2, int i) {
        boolean z;
        if (objArr == null && objArr2 == null) {
            return true;
        }
        if (objArr == null || objArr2 == null) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    z = false;
                    break;
                }
                if (objArr[i2].equals(objArr2[i3])) {
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (obj == null || PrivateCredentialPermission.class != obj.getClass()) {
            return false;
        }
        PrivateCredentialPermission privateCredentialPermission = (PrivateCredentialPermission) obj;
        return this.credentialClass.equals(privateCredentialPermission.credentialClass) && (i = this.offset) == privateCredentialPermission.offset && sameMembers(this.set, privateCredentialPermission.set, i);
    }

    @Override // java.security.Permission
    public String getActions() {
        return READ;
    }

    public String getCredentialClass() {
        return this.credentialClass;
    }

    public String[][] getPrincipals() {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, this.offset, 2);
        for (int i = 0; i < strArr.length; i++) {
            String[] strArr2 = strArr[i];
            CredOwner[] credOwnerArr = this.set;
            strArr2[0] = credOwnerArr[i].principalClass;
            strArr[i][1] = credOwnerArr[i].principalName;
        }
        return strArr;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.offset; i++) {
            iHashCode += this.set[i].hashCode();
        }
        return getCredentialClass().hashCode() + iHashCode;
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (permission == null || PrivateCredentialPermission.class != permission.getClass()) {
            return false;
        }
        PrivateCredentialPermission privateCredentialPermission = (PrivateCredentialPermission) permission;
        if (!"*".equals(this.credentialClass) && !this.credentialClass.equals(privateCredentialPermission.getCredentialClass())) {
            return false;
        }
        int i = privateCredentialPermission.offset;
        if (i == 0) {
            return true;
        }
        CredOwner[] credOwnerArr = this.set;
        CredOwner[] credOwnerArr2 = privateCredentialPermission.set;
        int i2 = this.offset;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < i && !credOwnerArr[i3].implies(credOwnerArr2[i4])) {
                i4++;
            }
            if (i4 == credOwnerArr2.length) {
                return false;
            }
        }
        return true;
    }

    @Override // java.security.Permission
    public PermissionCollection newPermissionCollection() {
        return null;
    }

    public PrivateCredentialPermission(String str, Set<Principal> set) {
        super(str);
        this.credentialClass = str;
        this.set = new CredOwner[set.size()];
        for (Principal principal : set) {
            CredOwner credOwner = new CredOwner(principal.getClass().getName(), principal.getName());
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.offset) {
                    break;
                }
                if (this.set[i].equals(credOwner)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                CredOwner[] credOwnerArr = this.set;
                int i2 = this.offset;
                this.offset = i2 + 1;
                credOwnerArr[i2] = credOwner;
            }
        }
    }
}
