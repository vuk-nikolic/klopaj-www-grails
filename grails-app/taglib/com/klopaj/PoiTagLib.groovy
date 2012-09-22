/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

class PoiTagLib {
    /**
     * poiTagIcon renders the whole img tag for Poi. It uses Poi's tags, and uses first "FOOD" tag type and renders it.
     */
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
                out << "<img src=\"/img/" + tag.iconFileName + "\" alt=" + altText + ">"
            } else {
                out << "<img src=\"/img/unlike.png\" >"
            }

        } else {
            out << "<img src=\"/img/unlike.png\" >"
        }

    }
}
