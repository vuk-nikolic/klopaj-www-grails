package com.klopaj
/**
 * The PeUserOpenid entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class PeUserOpenid {
    static mapping = {
         table 'pe_user_openid'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'openid_id'
    }
    Integer version
    String openIdIdentifier
    Long userId

    static constraints = {
        version(max: 2147483647)
        openIdIdentifier(size: 0..255)
        userId(max: 9223372036854775807L)
    }
    String toString() {
        return "${openidId}" 
    }
}
