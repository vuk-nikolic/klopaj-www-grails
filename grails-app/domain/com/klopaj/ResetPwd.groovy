package com.klopaj
/**
 * The ResetPwd entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class ResetPwd {
    static mapping = {
         table 'pe_reset_pwd'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'reset_pwd_id'
    }
    Integer version
    String code
    Date datetime
    Long userId

    static constraints = {
        version(max: 2147483647)
        code(size: 1..255, blank: false)
        datetime(nullable: true)
        userId(max: 9223372036854775807L)
    }
    String toString() {
        return "${id}"
    }
}
