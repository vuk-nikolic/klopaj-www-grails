package com.klopaj

import org.hibernate.envers.DefaultRevisionEntity

/**
 * RevisionEntity is an extended version of Envers' DefaultRevisionEntity. It hold data about the current revision
 * that will be made, and it adds user and a user that made the changed. <br />
 * It's mainly used in CustomRevisionListener, and everywhere revision needs to be gathered.
 *
 * @see com.klopaj.CustomRevisionListener
 */
@org.hibernate.envers.RevisionEntity(CustomRevisionListener.class)
class RevisionEntity extends DefaultRevisionEntity {
    static mapping = {
        table 'pe_revinfo'
        user column: 'user_id'
        id generator: 'identity', column: 'rev'
        version false
    }

    String username   // TODO: Do we need this field, we used it earlier just for display purposes
    User user

    static constraints = {
        user()
        version()
    }
}
