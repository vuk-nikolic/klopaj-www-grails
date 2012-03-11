import com.klopaj.Poi
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Poi) {
            def returnArray = [:]

            // Fields:
            returnArray['id'] = it.id
            returnArray['name'] = it.name
            returnArray['address'] = it.address
            returnArray['address'] = it.address
            returnArray['actref'] = it.actref
            returnArray['datetime'] = it.datetime
            returnArray['contactTel1'] = it.contactTel1
            returnArray['contactTel2'] = it.contactTel2
            returnArray['contactEmail'] = it.contactEmail
            returnArray['contactWww'] = it.contactWww
            returnArray['contactFax'] = it.contactFax
            returnArray['latitude'] = it.latitude
            returnArray['longitude'] = it.longitude
            returnArray['logo'] = it.logo

            // And collections as well
            returnArray['comments'] = it.comments
            returnArray['votes'] = it.votes
            returnArray['favorites'] = it.favorites
            returnArray['photos'] = it.photos

            return returnArray
        }
    }
    def destroy = {
    }
}
