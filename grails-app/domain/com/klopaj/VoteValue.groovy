package com.klopaj
/**
 * The VoteValue entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class VoteValue {
    static mapping = {
         table 'pe_vote_value'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'VOTE_VALUE_ID'
    }
    Byte voteValueId

    static constraints = {
        voteValueId()
    }
    String toString() {
        return "${voteValueId}" 
    }
}
