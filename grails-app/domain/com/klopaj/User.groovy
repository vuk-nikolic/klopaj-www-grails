package com.klopaj
/**
 * The User entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class User {
    static mapping = {
         table 'rj_user'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         rjRoleList column:'USER_ID',joinTable:'rj_user_role'
         id generator:'identity', column:'USER_ID'
         statusRjUserStatus column:'STATUS'
    }
    Integer version
    String username
    String hashpw
    String locale
    Date lastLogin
    Date createTime
    Date lastModified
    String name
    String email
    String sex
    Boolean usingGravatar
    // Relation
    UserStatus statusRjUserStatus

    static hasMany = [ rjRoleList : UserRole ]

    static constraints = {
        version(max: 2147483647)
        username(size: 1..25, blank: false)
        hashpw(size: 0..60)
        locale(size: 0..12)
        lastLogin(nullable: true)
        createTime()
        lastModified()
        name(size: 0..100)
        email(size: 0..100)
        sex(size: 1..1, blank: false)
        usingGravatar(nullable: true)
        statusRjUserStatus()
        rjRoleList()
    }
    String toString() {
        return "${id}"
    }
}
