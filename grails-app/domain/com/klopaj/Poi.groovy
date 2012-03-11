package com.klopaj

import org.hibernate.envers.Audited
/**
 * The Poi entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Poi {
    static mapping = {
        table 'pe_poi_data'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        tags column: 'poi_data_id', joinTable: 'pe_poi_tag'
        id generator: 'identity', column: 'POI_DATA_ID'
        user column: 'user_id'
        logo column: 'logo_id'
    }
    Integer version
    @Audited String name
    @Audited String address
    @Audited String description
    @Audited Byte actref
    @Audited Date datetime
    @Audited String contactTel1
    @Audited String contactTel2
    @Audited String contactEmail
    @Audited String contactWww
    @Audited String contactFax
    @Audited Double latitude
    @Audited Double longitude
    @Audited Photo logo;
    // Relation
    User user

    static hasMany = [tags: Tag, comments: Comment, favorites: Favorite, votes: Vote, photos: Photo] // TODO How to annotate this relationship?

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
        logo()
        user()
        tags()
    }

    String toString() {
        return "${id}"
    }
}
