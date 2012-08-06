dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = "net.sf.ehcache.hibernate.EhCacheProvider"

    // hibernate search configuration:
//    search.default.directory_provider = 'filesystem'
}

grails {
    mongo {
        host = "localhost"
        port = "27017"
        username = "pectopah"
        password = "pectopah!"
        databaseName = "klopaj"
    }
}

// environment specific settings
environments {
    development {
        dataSource {
//            dbCreate = "update" // one of 'create', 'create-drop','update'
            pooled = true
            username = "root"
            password = ""
            url = "jdbc:mysql://localhost:3306/pectopah?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/pectopah?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
//            url = "jdbc:mysql://localhost:3306/klopaj-www-grails_production"
            url = "jdbc:mysql://localhost:3306/pectopah"
        }
    }
}

/* Added by the Hibernate Spatial Plugin. */
dataSource {
    dialect = org.hibernatespatial.mysql.MySQLSpatialDialect
}
