// Place your Spring DSL code here
import org.codehaus.groovy.grails.orm.hibernate.HibernateEventListeners
import org.hibernate.envers.event.AuditEventListener
import com.klopaj.search.Serbian2LatinConverter;

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

    serbian2LatinConverter(com.klopaj.search.Serbian2LatinConverter)
}

