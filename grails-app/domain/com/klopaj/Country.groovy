package com.klopaj
/**
 * The Country entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Country {
    static mapping = {
         table 'rj_country'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'COUNTRY_ID'
    }
    String name
    String alpha2
    String alpha3
    String numericCode
    String active

    static constraints = {
        name(size: 1..100, blank: false)
        alpha2(size: 0..2)
        alpha3(size: 0..3)
        numericCode(size: 0..3)
        active(size: 0..1)
    }
    String toString() {
        return "${id}"
    }
}
