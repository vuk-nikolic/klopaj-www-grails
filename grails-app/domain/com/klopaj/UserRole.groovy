package com.klopaj

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

    static mapping = {
        table 'rj_user_role'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id composite: ['role', 'user']
        user column: 'USER_ID'
        role column: 'ROLE_ID'
    }

    User user
    Role role

    boolean equals(other) {
        if (!(other instanceof UserRole)) {
            return false
        }

        other.user?.id == user?.id &&
                other.role?.id == role?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (role) builder.append(role.id)
        builder.toHashCode()
    }

    static UserRole get(long secUserId, long secRoleId) {
        find 'from UserRole where user.id=:secUserId and role.id=:secRoleId',
                [secUserId: secUserId, secRoleId: secRoleId]
    }

    static UserRole create(User secUser, Role role, boolean flush = false) {
        new UserRole(user: secUser, role: role).save(flush: flush, insert: true)
    }

    static boolean remove(User secUser, Role role, boolean flush = false) {
        UserRole instance = UserRole.findByUserAndSecRole(secUser, role)
        if (!instance) {
            return false
        }

        instance.delete(flush: flush)
        true
    }

    static void removeAll(User secUser) {
        executeUpdate 'DELETE FROM UserRole WHERE user=:user', [secUser: secUser]
    }

    static void removeAll(Role role) {
        executeUpdate 'DELETE FROM UserRole WHERE role=:role', [role: role]
    }


}
