package com.klopaj
/**
 * The UserStatus entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class UserStatus {
    static mapping = {
         table 'rj_user_status'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'USER_STATUS_ID'
    }
    String name
    String description

    static constraints = {
        name(size: 1..10, blank: false)
        description(size: 0..50)
    }
    String toString() {
        return "${id}"
    }
}
