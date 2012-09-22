/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

class PoiTagLib {
    def poiTagIcon = { attrs ->
        Poi poi = attrs.poi
        Collection tags = poi.getTags()
        if (tags?.size() > 0) {
            Tag tag = null

            for (Tag t : tags) {
                if (t.getTagType() == "FOOD") {
                    tag = t
                    break
                }
            }

            if (null != tag) {
                def altText = tag.name ? tag.name : ""
                out << "<img src=\"/img/poi-type-national.png\" alt=" + altText + ">"
            } else {
                out << "<img src=\"/img/unlike.png\" >"
            }

        } else {
            out << "<img src=\"/img/unlike.png\" >"
        }

    }
}
