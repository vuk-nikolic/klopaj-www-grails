package com.klopaj
/**
 * The User entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class User {
    static mapping = {
        table 'rj_user'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        roles column: 'USER_ID', joinTable: 'rj_user_role'
        id generator: 'identity', column: 'USER_ID'
        userStatus column: 'STATUS'
        password column: '`hashpw`'
    }
    String locale
    Date lastLogin
    Date createTime
    Date lastModified
    String name
    String email
    String sex
    Boolean usingGravatar
    // Relation
    UserStatus userStatus

    static hasMany = [roles: Role, comments: Comment, votes: Vote, photos: Photo, favorites: Favorite]

    static constraints = {
        username(size: 1..25, blank: false)
        password(size: 0..60)
        locale(size: 0..12)
        lastLogin(nullable: true)
        createTime()
        lastModified()
        name(size: 0..100)
        email(size: 0..100)
        sex(size: 1..1, blank: false)
        usingGravatar(nullable: true)
        userStatus()
        roles()
    }

    String toString() {
        return "${id}"
    }

    // From Spring security plugin
    transient springSecurityService

    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired


    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
