package com.klopaj
/**
 * The UserOauth2 entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class UserOauth2 {
    static mapping = {
        table 'pe_user_oauth2'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator: 'identity', column: 'oauth2_id'
        user column: 'USER_ID'
    }
    Integer version
    String serviceUserId
    User user
    String serviceName

    static constraints = {
        version(max: 2147483647)
        serviceUserId(size: 0..255)
        user()
        serviceName(size: 0..255)
    }

    String toString() {
        return "${id}"
    }
}
