package com.klopaj

import org.hibernate.envers.Audited
/**
 * The Tag entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Tag {
    static mapping = {
         table 'pe_tag'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         pePoiDataList column:'tag_id',joinTable:'pe_poi_tag'
         id generator:'identity', column:'TAG_ID'
    }
    @Audited String name
    @Audited String description
    @Audited String imageUrl
    @Audited Date datetime
    Integer version
    @Audited String tagType

    static hasMany = [ pePoiDataList : Poi ] // TODO How to annotate this relationship?

    static belongsTo = [  Poi ]

    static constraints = {
        name(size: 1..255, blank: false)
        description(size: 0..2000)
        imageUrl(size: 0..255)
        datetime()
        version(max: 2147483647)
        tagType(size: 1..45, blank: false)
        pePoiDataList()
    }
    String toString() {
        return "${id}"
    }
}
