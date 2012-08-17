// Place your Spring DSL code here


import com.klopaj.services.sql.SqlSearchService
import org.codehaus.groovy.grails.orm.hibernate.HibernateEventListeners
import org.hibernate.envers.event.AuditEventListener
import com.klopaj.services.sql.SqlPoiService

beans = {

    passwordEncoder(grails.plugins.springsecurity.BCryptPasswordEncoder)
    // Add support for Envers listeners
    auditListener(AuditEventListener)
    hibernateEventListeners(HibernateEventListeners) {
        listenerMap = ['post-insert': auditListener,
                'post-update': auditListener,
                'post-delete': auditListener,
                'pre-collection-update': auditListener,
                'pre-collection-remove': auditListener,
                'post-collection-recreate': auditListener]
    }

    searchService(SqlSearchService)
    userService(SqlSearchService)
    poiService(SqlPoiService)
}

