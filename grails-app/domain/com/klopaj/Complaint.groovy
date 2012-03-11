package com.klopaj
/**
 * The Complaint entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Complaint {
    static mapping = {
         table 'pe_complaint'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'COMPLAINT_ID'
         user column:'USER_ID'
    }
    String reference
    Integer refId
    String text
    Date datetime
    Integer version
    // Relation
    User user

    static constraints = {
        reference(size: 1..30, blank: false)
        refId(max: 2147483647)
        text(size: 0..500)
        datetime()
        version(max: 2147483647)
        user()
    }
    String toString() {
        return "${id}"
    }
}
