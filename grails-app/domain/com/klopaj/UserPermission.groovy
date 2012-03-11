package com.klopaj
/**
 * The UserPermission entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class UserPermission {
    static mapping = {
         table 'rj_permission'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         roles column:'PERMISSION_ID',joinTable:'rj_role_permission'
         id generator:'identity', column:'PERMISSION_ID'
    }
    Integer version
    String name

    static hasMany = [ roles: Role ]

    static belongsTo = [  Role ]

    static constraints = {
        version(max: 2147483647)
        name(size: 1..20, blank: false)
        roles()
    }
    String toString() {
        return "${id}"
    }
}
