package com.klopaj.auditlog

import org.hibernate.envers.RevisionListener
import com.klopaj.RevisionEntity
import com.klopaj.User

/**
 * CustomRevisionListener is an implementation of Envers' RevisionListener, that adds who made a change
 * to @Audited entities.<br />
 * It just gets the currently logged user and it stores into RevisionEntity
 *
 * @see com.klopaj.RevisionEntity
 */
class CustomRevisionListener implements RevisionListener {
    def springSecurityService

    void newRevision(Object o) {
        RevisionEntity revisionEntity = (RevisionEntity) o;

        User user = User.get(springSecurityService.principal.id);
        if (user != null) {
            revisionEntity.setUsername(user.getUsername());
            revisionEntity.setUser(user);
        }
    }
}
