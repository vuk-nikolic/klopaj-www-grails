package com.klopaj
/**
 * The UserOauth2 entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class UserOauth2 {
    static mapping = {
         table 'pe_user_oauth2'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'oauth2_id'
    }
    Integer version
    String serviceUserId
    Long userId         // TODO: This should be a reference to Photo, and not it's id!
    String serviceName

    static constraints = {
        version(max: 2147483647)
        serviceUserId(size: 0..255)
        userId(max: 9223372036854775807L)
        serviceName(size: 0..255)
    }
    String toString() {
        return "${id}"
    }
}
