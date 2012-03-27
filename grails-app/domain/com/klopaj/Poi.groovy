package com.klopaj

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.*

/**
 * The Poi entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
@Indexed
class Poi {
    public static final String FIELD_ID = "id";
    public static final String FIELD_TAG = "tag";
    public static final String FIELD_ADDRESS = "addr";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESC = "desc";
    public static final String FIELD_TAG_NAME = "tagname";

    public static final String[] ALL_FIELDS = {FIELD_NAME; FIELD_TAG; FIELD_ADDRESS; FIELD_DESC} as String[];


    static mapping = {
        table 'pe_poi_data'
        // version is set to false, because this isn't available by default for legacy databases
        version true
        tags column: 'poi_data_id', joinTable: 'pe_poi_tag'
        id generator: 'identity', column: 'POI_DATA_ID'
        user column: 'user_id'
        logo column: 'logo_id'
    }
    Integer version

    @DocumentId
    @Audited
    Long id

    @Field
    @Audited
    @Boost(3.0f)
    String name

    @Field
    @Audited 
    @Boost(1.5f)
    String address

    @Field
    @Audited 
    @Boost(0.8f)
    String description
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

    @Boost(2.0f)
    @IndexedEmbedded
    Set<Tag> tags;

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

//    static search = {
//        name index: 'tokenized'
//        description index: 'tokenized'
//        address index: 'tokenized'
//    }

    String toString() {
        return "${id}"
    }
}
