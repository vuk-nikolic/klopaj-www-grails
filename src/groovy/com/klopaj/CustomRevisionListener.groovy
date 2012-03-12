package com.klopaj

import org.hibernate.envers.RevisionListener

/**
 * CustomRevisionListener is an implementtion of Envers' RevisionListener, that adds who made a change
 * to @Audited entities.<br />
 * It just gets the currently logged user and it storesinto RevisionEntity
 *
 * @see com.klopaj.RevisionEntity
 */
class CustomRevisionListener implements RevisionListener {
    def springSecurityService

    void newRevision(Object o) {
        RevisionEntity revisionEntity = (RevisionEntity) revisionEntity;

        User user = User.get(springSecurityService.principal.id);
        if (user != null) {
            revisionEntity.setUsername(user.getUsername());
            revisionEntity.setUser(user);
        }
    }
}
