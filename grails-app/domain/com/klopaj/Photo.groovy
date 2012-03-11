package com.klopaj
/**
 * The Photo entity.
 *
 * @author Vuk  klopaj.com
 *
 *
 */
class Photo {
    static mapping = {
        table 'pe_photo'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator: 'identity', column: 'photo_id'
        user column: 'USER_ID'
        poi column: 'POI_DATA_ID'
    }
    Integer version
    String filename
    String description
    Date datetime
    // Relation
    User user
    // Relation
    Poi poi
    String extension
    Boolean logo

    static constraints = {
        version(max: 2147483647)
        filename(size: 0..255)
        description(size: 0..255)
        datetime(nullable: true)
        user()
        poi()
        extension(size: 0..255)
        logo(nullable: true)
    }

    String toString() {
        return "${id}"
    }
}
