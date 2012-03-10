package com.klopaj
/**
 * The Email entity.
 *
 * @author  Vuk  klopaj.com
 *
 *
 */
class Email {
    static mapping = {
         table 'rj_email'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'EMAIL_ID'
    }
    Integer version
    Integer status
    String fromEmail
    String fromName
    String mailTo
    String mailCc
    String mailBcc
    String text
    String html
    String subject
    String attachments
    Date createTime
    Date lastModified

    static constraints = {
        version(max: 2147483647)
        status(max: 2147483647)
        fromEmail(size: 0..50)
        fromName(size: 0..50)
        mailTo(size: 0..100)
        mailCc(size: 0..100)
        mailBcc(size: 0..100)
        text(size: 0..1000)
        html(size: 0..1000)
        subject(size: 0..100)
        attachments(size: 0..250)
        createTime()
        lastModified()
    }
    String toString() {
        return "${id}"
    }
}
