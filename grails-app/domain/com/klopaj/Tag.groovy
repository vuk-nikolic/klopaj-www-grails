package com.klopaj

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.ContainedIn

/**
 * The Tag entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Tag {
    static mapping = {
        table 'pe_tag'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        pois column: 'tag_id', joinTable: 'pe_poi_tag'
        id generator: 'identity', column: 'TAG_ID'
    }

    @Audited
    Long id

    @Audited @Field
    String name

    @Audited String description
    @Audited String imageUrl
    @Audited String iconFileName
    @Audited Date datetime
    Integer version
    @Audited String tagType

    @ContainedIn
    Set<Poi> pois

    static hasMany = [pois: Poi]
    static belongsTo = [Poi]

    static constraints = {
        name(size: 1..255, blank: false)
        description(size: 0..2000)
        imageUrl(size: 0..255)
        iconFileName(size: 0..255)
        datetime()
        version(max: 2147483647)
        tagType(size: 1..45, blank: false)
        pois()
    }

    String toString() {
        return "${id}"
    }
}
