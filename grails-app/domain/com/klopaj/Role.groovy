package com.klopaj
/**
 * The Role entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Role {
    static mapping = {
        table 'rj_role'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        rjPermissionList column: 'ROLE_ID', joinTable: 'rj_role_permission'
        rjUserList column: 'ROLE_ID', joinTable: 'rj_user_role'
        id generator: 'identity', column: 'ROLE_ID'
        authority column: 'name'
    }
    String authority

    static hasMany = [rjPermissionList: UserPermission, rjUserList: User]

    static belongsTo = [User]

    static constraints = {
        authority(size: 1..20, blank: false)
        rjPermissionList()
        rjUserList()
    }

    String toString() {
        return "${id}"
    }
}
