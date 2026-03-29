package org.apache.harmony.javax.security.auth;

import java.security.DomainCombiner;
import java.security.Principal;
import java.security.ProtectionDomain;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SubjectDomainCombiner implements DomainCombiner {
    private static final AuthPermission _GET = new AuthPermission("getSubjectFromDomainCombiner");
    private Subject subject;

    public SubjectDomainCombiner(Subject subject) {
        subject.getClass();
        this.subject = subject;
    }

    @Override // java.security.DomainCombiner
    public ProtectionDomain[] combine(ProtectionDomain[] protectionDomainArr, ProtectionDomain[] protectionDomainArr2) {
        int i;
        int length = protectionDomainArr != null ? protectionDomainArr.length + 0 : 0;
        if (protectionDomainArr2 != null) {
            length += protectionDomainArr2.length;
        }
        if (length == 0) {
            return null;
        }
        ProtectionDomain[] protectionDomainArr3 = new ProtectionDomain[length];
        if (protectionDomainArr != null) {
            Set<Principal> principals = this.subject.getPrincipals();
            Principal[] principalArr = (Principal[]) principals.toArray(new Principal[principals.size()]);
            i = 0;
            while (i < protectionDomainArr.length) {
                if (protectionDomainArr[i] != null) {
                    protectionDomainArr3[i] = new ProtectionDomain(protectionDomainArr[i].getCodeSource(), protectionDomainArr[i].getPermissions(), protectionDomainArr[i].getClassLoader(), principalArr);
                }
                i++;
            }
        } else {
            i = 0;
        }
        if (protectionDomainArr2 != null) {
            System.arraycopy(protectionDomainArr2, 0, protectionDomainArr3, i, protectionDomainArr2.length);
        }
        return protectionDomainArr3;
    }

    public Subject getSubject() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(_GET);
        }
        return this.subject;
    }
}
