/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj

/**
 * Client represents user's client software. It can be:
 *      1. web app
 *      2. android
 *      3. iPhone
 *      4. iPad
 */
class Client {

    static mapping = {
        table 'pe_client'
        // version is set to false, because this isn't available by default for legacy databases
        version true
        id generator: 'identity', column: 'CLIENT_ID'
        name column: 'name'
    }
    Integer version
    String name
}
