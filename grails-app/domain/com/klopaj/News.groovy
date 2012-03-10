package com.klopaj
/**
 * The News entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class News {
    static mapping = {
         table 'pe_news'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'NEWS_ID'
    }
    String text
    Boolean active

    static constraints = {
        text(size: 1..1000, blank: false)
        active()
    }
    String toString() {
        return "${id}"
    }
}
