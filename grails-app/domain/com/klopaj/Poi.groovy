package com.klopaj
/**
 * The Poi entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Poi {
    static mapping = {
         table 'pe_poi_data'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         peTagList column:'poi_data_id',joinTable:'pe_poi_tag'
         id generator:'identity', column:'POI_DATA_ID'
         userIdRjUser column:'user_id'
    }
    Integer version
    String name
    String address
    String description
    Byte actref
    Date datetime
    String contactTel1
    String contactTel2
    String contactEmail
    String contactWww
    String contactFax
    Double latitude
    Double longitude
    Integer logoId
    // Relation
    User userIdRjUser

    static hasMany = [ peTagList : Tag ]

    static constraints = {
        version(max: 2147483647)
        name(size: 0..255)
        address(size: 0..255)
        description()
        actref()
        datetime()
        contactTel1(size: 0..45)
        contactTel2(size: 0..45)
        contactEmail(size: 0..255)
        contactWww(size: 0..255)
        contactFax(size: 0..45)
        latitude()
        longitude()
        logoId(nullable: true, max: 2147483647)
        userIdRjUser()
        peTagList()
    }
    String toString() {
        return "${id}"
    }
}
