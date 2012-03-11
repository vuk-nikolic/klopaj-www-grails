package com.klopaj
/**
 * The UserOpenid entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class UserOpenid {
    static mapping = {
        table 'pe_user_openid'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator: 'identity', column: 'openid_id'
        user column: 'USER_ID'
    }
    Integer version
    String openIdIdentifier
    User user

    static constraints = {
        version(max: 2147483647)
        openIdIdentifier(size: 0..255)
        user()
    }

    String toString() {
        return "${openidId}"
    }
}
