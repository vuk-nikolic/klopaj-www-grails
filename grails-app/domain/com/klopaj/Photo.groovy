package com.klopaj
/**
 * The Photo entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Photo {
    static mapping = {
         table 'pe_photo'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'photo_id'
    }
    Integer version
    String filename
    String description
    Date datetime
    Long userId
    Integer poiDataId
    String extension
    Boolean logo

    static constraints = {
        version(max: 2147483647)
        filename(size: 0..255)
        description(size: 0..255)
        datetime(nullable: true)
        userId(max: 9223372036854775807L)
        poiDataId(max: 2147483647)
        extension(size: 0..255)
        logo(nullable: true)
    }
    String toString() {
        return "${id}"
    }
}
